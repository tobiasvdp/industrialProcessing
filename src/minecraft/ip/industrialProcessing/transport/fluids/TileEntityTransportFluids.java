package ip.industrialProcessing.transport.fluids;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import buildcraft.api.transport.IPipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.FluidTransfers;

public class TileEntityTransportFluids extends TileEntityTransport implements IFluidInfo, ITankSyncable {

	protected FluidTank tank = new FluidTank(1000);
	protected float pressure = 0;
	private static int tileID;
	private int id;
	private TankHandler tankHandler = new TankHandler(this, new int[] { 0 });

	public float getPressure() {
		return pressure;
	}

	public TileEntityTransportFluids() {
		this.id = tileID++;
	}

	public FluidTankInfo getTankInfo() {
		return tank.getInfo();
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		tank.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		tank.readFromNBT(par1nbtTagCompound);
	}

	@Override
	protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
		if (this.canConnect(direction)) {
			ForgeDirection from = direction.getOpposite();
			if (entity instanceof TileEntityTransportFluids) {
				TileEntityTransportFluids other = (TileEntityTransportFluids) entity;
				if (other.canConnect(direction.getOpposite()))
					return TransportConnectionState.TRANSPORT;
				return TransportConnectionState.NONE;
			}
			// TODO: check if
			// connection should be
			// made (lava pipe with
			// water pipe ..)

			if (entity instanceof TileEntityManoMeter && direction == ForgeDirection.UP)
				return TransportConnectionState.TRANSPORT;

			if (entity instanceof TileEntityPump) {
				TileEntityPump pump = (TileEntityPump) entity;
				if (pump.isFluidOuptut(from))
					return TransportConnectionState.OUTPUT;
				if (pump.isFluidInput(from))
					return TransportConnectionState.INPUT;
			}
			if (entity instanceof IFluidHandler) {
				IFluidHandler handler = (IFluidHandler) entity;
				return canInsertOrExtractFluid(handler, from);
			}
		}
		return TransportConnectionState.NONE;
	}

	private TransportConnectionState canInsertOrExtractFluid(IFluidHandler handler, ForgeDirection from) {
		FluidTankInfo[] info = handler.getTankInfo(from);
		if (info != null && info.length > 0)
			return TransportConnectionState.DUAL; // can't decide if input only
		// or input/output
		return TransportConnectionState.NONE;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (this.worldObj.isRemote)
			return;
		handlePumps();
		outputToInputs();
		inputFromOutputs();
		equalizeToOtherPipes();
		leakPressure();

		if (this.tankHandler.readDataFromTanks())
			TileTankSyncHandler.sendTankData(this, this.tankHandler);
	}

	protected void leakPressure() {

		this.pressure -= this.pressure * 0.005f;
		if (Float.isNaN(this.pressure) || Float.isInfinite(this.pressure))
			this.pressure = 0;
	}

	protected IFluidTank getTank(ForgeDirection direction) {
		return this.tank;
	}

	protected float getPressure(ForgeDirection direction) {
		return this.pressure;
	}

	protected void setPressure(ForgeDirection direction, float value) {
		this.pressure = value;
	}

	protected void addPressure(ForgeDirection direction, float value) {
		this.pressure += value;
	}

	protected boolean canConnect(ForgeDirection direction) {
		return true;
	}

	private void handlePumps() {
		for (int i = 0; i < states.length; i++) {
			TransportConnectionState state = this.states[i];
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			if (state == TransportConnectionState.INPUT || state == TransportConnectionState.OUTPUT) {
				TileEntityPump pump = getNeighborPump(direction);
				if (pump != null) {
					float lastPressure = this.getPressure(direction);
					if (pump.isFluidInput(direction.getOpposite())) {
						float pumpPressure = pump.getInputPressure();
						float flow = pumpPressure - lastPressure;
						if (flow < 0) {

							pumpPressure -= flow / 4;
							this.addPressure(direction, flow / 4);

							FluidTransfers.transfer(-(int) flow, this.tank, pump.getTank());
						}
						pump.setInputPressure(pumpPressure);

					} else if (pump.isFluidOuptut(direction.getOpposite())) {
						float pumpPressure = pump.getOutputPressure();

						float flow = pumpPressure - this.pressure;
						if (flow > 0) {

							pumpPressure -= flow / 4;
							this.addPressure(direction, flow / 4);

							FluidTransfers.transfer((int) (flow), pump.getTank(), this.tank);
						}
						pump.setOutputPressure(pumpPressure);
					}
				}
			}
		}
	}

	private void equalizeToOtherPipes() {

		float totalDifference = 0;
		float[] flows = new float[6];
		for (int i = 0; i < states.length; i++) {
			TransportConnectionState state = this.states[i];
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			if (state == TransportConnectionState.TRANSPORT) {
				TileEntityTransportFluids other = getNeighborPipe(direction);
				if (other != null) {

					float flow = this.getPressure(direction) - other.getPressure(direction.getOpposite());
					float gravFlow = getGravityFlow(other, direction);
					flow += gravFlow;
					if (flow > 0) {
						flows[i] = flow;
						totalDifference += Math.abs(flow);
					}
				}
			}
		}
		if (totalDifference > 0) {
			for (int i = 0; i < states.length; i++) {
				TransportConnectionState state = this.states[i];
				ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
				if (state == TransportConnectionState.TRANSPORT) {
					TileEntityTransportFluids other = getNeighborPipe(direction);
					if (other != null) {
						float flow = flows[i] * flows[i] / totalDifference;
						if (flow > 0) {
							FluidTransfers.transfer((int) (flow), this.tank, other.tank);
						} else if (flow < 0) {
							FluidTransfers.transfer((int) (flow), other.tank, this.tank);
						}
						other.addPressure(direction.getOpposite(), flow / 4f);
						this.addPressure(direction, -flow / 4f);
					}
				}
			}
		}
	}

	private float getGravityFlow(TileEntityTransportFluids other, ForgeDirection direction) {

		float scale = 0.15f;// 15f;
		float amount = this.tank.getFluidAmount();
		float otherAmount = other.tank.getFluidAmount();

		if (direction == ForgeDirection.DOWN) {
			// other tank is below this tank.
			return amount * scale;
		}

		if (direction == ForgeDirection.UP) {
			// other tank is above this tank.
			return -otherAmount * scale;
		}

		return (amount - otherAmount) * scale;
	}

	/*
	 * private float getPressure(ForgeDirection direction) { float extra = 1;//
	 * this.tank.getFluidAmount() * -100f / this.tank.getCapacity(); //extra =
	 * this.pressure; if (direction == ForgeDirection.DOWN) return this.pressure
	 * + extra;// output to below else if (direction == ForgeDirection.UP)
	 * return this.pressure; // output to above else return this.pressure +
	 * extra / 2; // sides
	 * 
	 * }
	 */
	private void inputFromOutputs() {
		for (int i = 0; i < states.length; i++) {
			TransportConnectionState state = this.states[i];
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			ForgeDirection from = direction.getOpposite();
			if (state == TransportConnectionState.DUAL) {
				IFluidHandler other = getNeighborFluidHandler(direction);
				if (other != null) {
					float tankPressure = getTankPressure(other, direction);
					float currentPressure = getPressure(direction);
					if (currentPressure < tankPressure) {
						float flow = tankPressure - currentPressure;
						if (flow > 0) {
							this.addPressure(direction, flow / 4);
							FluidTransfers.transfer((int) (flow), other, from, this.tank);
						}
					}
				}
			}
		}
	}

	private void outputToInputs() {
		for (int i = 0; i < states.length; i++) {
			TransportConnectionState state = this.states[i];
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			ForgeDirection from = direction.getOpposite();
			if (state == TransportConnectionState.DUAL) {
				IFluidHandler other = getNeighborFluidHandler(direction);
				if (other != null) {
					float tankPressure = getTankPressure(other, direction);
					float currentPressure = getPressure(direction);
					if (currentPressure > tankPressure) {
						float flow = tankPressure - currentPressure;
						if (flow < 0) {
							this.addPressure(direction, +flow / 4);

							FluidTransfers.transfer(-(int) (flow), this.tank, other, from);
						}
					}
				}
			}
		}
	}

	private float getTankPressure(IFluidHandler other, ForgeDirection direction) {
		if (other instanceof IPressuredTank) {
			IPressuredTank tank = (IPressuredTank) other;
			return tank.getPressure(direction.getOpposite());
		}
		return 0;
	}

	private IFluidHandler getNeighborFluidHandler(ForgeDirection direction) {
		TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
		if (ent instanceof IFluidHandler)
			return (IFluidHandler) ent;
		return null;
	}

	private TileEntityTransportFluids getNeighborPipe(ForgeDirection direction) {
		TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
		if (ent instanceof TileEntityTransportFluids)
			return (TileEntityTransportFluids) ent;
		return null;
	}

	private TileEntityPump getNeighborPump(ForgeDirection direction) {
		TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
		if (ent instanceof TileEntityPump)
			return (TileEntityPump) ent;
		return null;
	}

	@Override
	public FluidTankInfo[] getTanks() {
		return new FluidTankInfo[] { this.tank.getInfo() };
	}

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

	@Override
	public IFluidTank getTankInSlot(int slot) {
		if (slot == 0)
			return this.tank;
		return null;
	}
}
