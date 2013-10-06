package ip.industrialProcessing.transport.fluids;

import java.util.List;

import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.utils.FluidTransfers;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public abstract class TileEntityTransportFluidsBase extends TileEntityTransport implements IFluidInfo, ITankSyncable {

	private static final int CONNECTION_GROUPS = 16;
	protected TankHandler tankHandler;
	private int connectionGroup=1;

	public void setConnectionGroup(int color){
		connectionGroup = color;
		updateConnections();
	}
	
	public TileEntityTransportFluidsBase() {
	}

	@Override
	protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
		if (this.canConnect(direction)) {
			ForgeDirection from = direction.getOpposite();
			if (entity instanceof TileEntityTransportFluidsBase) {
				TileEntityTransportFluidsBase other = (TileEntityTransportFluidsBase) entity;
				if (other.connectionGroup == this.connectionGroup && other.canConnect(direction.getOpposite()))
					return TransportConnectionState.TRANSPORT;
				return TransportConnectionState.NONE;
			}

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

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("Group", this.connectionGroup);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		this.connectionGroup = par1nbtTagCompound.getInteger("Group");
	}

	protected abstract void leakPressure();

	protected abstract IFluidTank getTank(ForgeDirection direction);

	protected abstract float getPressure(ForgeDirection direction);

	protected abstract void addPressure(ForgeDirection direction, float value);

	protected abstract boolean canConnect(ForgeDirection direction);

	private void handlePumps() {
		for (int i = 0; i < states.length; i++) {
			TransportConnectionState state = this.states[i];
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			if (state == TransportConnectionState.INPUT || state == TransportConnectionState.OUTPUT) {
				TileEntityPump pump = getNeighborPump(direction);
				if (pump != null) {
					float lastPressure = this.getPressure(direction);
					IFluidTank tank = this.getTank(direction);
					if (pump.isFluidInput(direction.getOpposite())) {
						float pumpPressure = pump.getInputPressure();
						float flow = pumpPressure - lastPressure;
						if (flow < 0) {

							pumpPressure -= flow / 4;
							this.addPressure(direction, flow / 4);

							FluidTransfers.transfer(-(int) flow, tank, pump.getTank());
						}
						pump.setInputPressure(pumpPressure);

					} else if (pump.isFluidOuptut(direction.getOpposite())) {
						float pumpPressure = pump.getOutputPressure();

						float flow = pumpPressure - lastPressure;
						if (flow > 0) {

							pumpPressure -= flow / 4;
							this.addPressure(direction, flow / 4);

							FluidTransfers.transfer((int) (flow), pump.getTank(), tank);
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
				TileEntityTransportFluidsBase other = getNeighborPipe(direction);
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
					TileEntityTransportFluidsBase other = getNeighborPipe(direction);
					if (other != null) {
						IFluidTank tank = this.getTank(direction);
						IFluidTank otherTank = other.getTank(direction.getOpposite());
						float flow = flows[i] * flows[i] / totalDifference;
						if (flow > 0) {
							FluidTransfers.transfer((int) (flow), tank, otherTank);
						} else if (flow < 0) {
							FluidTransfers.transfer((int) (flow), otherTank, tank);
						}
						other.addPressure(direction.getOpposite(), flow / 4f);
						this.addPressure(direction, -flow / 4f);
					}
				}
			}
		}
	}

	private float getGravityFlow(TileEntityTransportFluidsBase other, ForgeDirection direction) {

		float scale = 0.15f;// 15f;
		float amount = this.getTank(direction).getFluidAmount();
		float otherAmount = other.getTank(direction.getOpposite()).getFluidAmount();

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
							FluidTransfers.transfer((int) (flow), other, from, this.getTank(direction));
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

							FluidTransfers.transfer(-(int) (flow), this.getTank(direction), other, from);
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

	private TileEntityTransportFluidsBase getNeighborPipe(ForgeDirection direction) {
		TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
		if (ent instanceof TileEntityTransportFluidsBase)
			return (TileEntityTransportFluidsBase) ent;
		return null;
	}

	private TileEntityPump getNeighborPump(ForgeDirection direction) {
		TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
		if (ent instanceof TileEntityPump)
			return (TileEntityPump) ent;
		return null;
	}

	@Override
	public abstract FluidTankInfo[] getTanks();

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

	@Override
	public abstract IFluidTank getTankInSlot(int slot);

	public void cycleGroups(boolean sneaking) {
		if (sneaking)
			connectionGroup--;
		else
			connectionGroup++;

		if (connectionGroup < 0)
			connectionGroup += CONNECTION_GROUPS;
		else if (connectionGroup >= CONNECTION_GROUPS)
			connectionGroup -= CONNECTION_GROUPS;

		searchForConnections();
		this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, getBlockType().blockID);
	}

	public void setBounds() {

		float xMin = -3 / 16f;
		float yMin = -3 / 16f;
		float zMin = -3 / 16f;
		float xMax = 3 / 16f;
		float yMax = 3 / 16f;
		float zMax = 3 / 16f;

		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			TransportConnectionState state = this.states[i];
			if (state.isConnected()) {
				float dx = direction.offsetX / 2f;
				float dz = direction.offsetZ / 2f;
				float dy = direction.offsetY / 2f;

				xMin = Math.min(xMin, dx);
				yMin = Math.min(yMin, dy);
				zMin = Math.min(zMin, dz);

				xMax = Math.max(xMax, dx);
				yMax = Math.max(yMax, dy);
				zMax = Math.max(zMax, dz);

			}
		}

		this.getBlockType().setBlockBounds(xMin + 0.5f, yMin + 0.5f, zMin + 0.5f, xMax + 0.5f, yMax + 0.5f, zMax + 0.5f);
	}

	public void addCollisionBoxesToList(AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			TransportConnectionState state = this.states[i];
			if (state.isConnected()) {

				double xMin = -3 / 16f;
				double yMin = -3 / 16f;
				double zMin = -3 / 16f;
				double xMax = 3 / 16f;
				double yMax = 3 / 16f;
				double zMax = 3 / 16f;

				double dx = direction.offsetX / 2f;
				double dz = direction.offsetZ / 2f;
				double dy = direction.offsetY / 2f;

				xMin = Math.min(xMin, dx) + xCoord + 0.5f;
				yMin = Math.min(yMin, dy) + yCoord + 0.5f;
				zMin = Math.min(zMin, dz) + zCoord + 0.5f;

				xMax = Math.max(xMax, dx) + xCoord + 0.5f;
				yMax = Math.max(yMax, dy) + yCoord + 0.5f;
				zMax = Math.max(zMax, dz) + zCoord + 0.5f;

				AxisAlignedBB bbx = AxisAlignedBB.getBoundingBox(xMin, yMin, zMin, xMax, yMax, zMax);
				if (bbx.intersectsWith(par5AxisAlignedBB)) {
					par6List.add(bbx);
				}
			}
		} 
	}
}
