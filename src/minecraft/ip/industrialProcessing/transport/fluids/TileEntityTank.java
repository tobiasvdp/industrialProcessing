package ip.industrialProcessing.transport.fluids;

import java.util.Arrays;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.utils.FluidTransfers;

public class TileEntityTank extends TileEntitySynced implements IFluidHandler, IConnectedTile, IFluidInfo, ITankSyncable, IPressuredTank {

	private FluidTank tank = new FluidTank(10 * FluidContainerRegistry.BUCKET_VOLUME);
	private boolean isTop = false;

	private AnimationHandler animation = new AnimationHandler(AnimationMode.CLAMP, 10f, true);
	private ConnectionState[] states = new ConnectionState[6];
	private boolean unverified = true;
	private TankHandler tankHandler;
	private float pressure;
	private float pressureAbove;

	public TileEntityTank() {
		Arrays.fill(states, ConnectionState.DISCONNECTED);
		this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	public void searchForNeighbors() {
		this.unverified = true;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		this.pressure = 0;
		this.pressureAbove = 0;
		if (tank.getFluidAmount() > 0 || unverified) {
			TileEntity entityBelow = this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
			if (entityBelow instanceof TileEntityTank) {
				if (!this.worldObj.isRemote) {
					TileEntityTank tankBelow = (TileEntityTank) entityBelow;
					FluidTransfers.transfer(10000, this.tank, tankBelow.tank);
				}
				states[ForgeDirection.DOWN.ordinal()] = ConnectionState.CONNECTED;
			} else
				states[ForgeDirection.DOWN.ordinal()] = ConnectionState.DISCONNECTED;
		}
		if (unverified) {
			TileEntity entityAbove = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
			if (entityAbove instanceof TileEntityTank) {
				TileEntityTank tankAbove = (TileEntityTank) entityAbove;
				this.pressureAbove = tankAbove.getPressure(ForgeDirection.DOWN);
				states[ForgeDirection.UP.ordinal()] = ConnectionState.CONNECTED;
			} else
				states[ForgeDirection.UP.ordinal()] = ConnectionState.DISCONNECTED;
		}

		if (!this.worldObj.isRemote) {
			if (this.tankHandler.readDataFromTanks())
				TileTankSyncHandler.sendTankData(this, this.tankHandler);
			this.pressure = this.tank.getFluidAmount() * 220 / this.tank.getCapacity();
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		this.tank.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.tank.setFluid(null);
		this.tank.readFromNBT(nbt);
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (tank.getFluidAmount() == tank.getCapacity()) {
			return fillAbove(resource, doFill);
		}
		int fill = tank.fill(resource, doFill);
		return fill;
	}

	private int fillAbove(FluidStack resource, boolean doFill) {
		TileEntity entityAbove = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
		if (entityAbove instanceof TileEntityTank) {
			TileEntityTank tankAbove = (TileEntityTank) entityAbove;
			int fill = tankAbove.fill(ForgeDirection.DOWN, resource, doFill);
			return fill;
		}
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource != null && resource.isFluidEqual(tank.getFluid())) {
			FluidStack drain = tank.drain(resource.amount, doDrain);
			return drain;
		}
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		FluidStack stack = tank.drain(maxDrain, doDrain);
		return stack;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tank.getInfo() };
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		return this.states[direction.ordinal()];
	}

	@Override
	public FluidTankInfo[] getTanks() {
		return new FluidTankInfo[] { this.tank.getInfo() };
	}

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

	public IFluidTank getTankInSlot(int slot) {
		if (slot == 0)
			return this.tank;
		return null;
	}
	
	@Override
	public int getTankCount() { 
		return 1;
	}


	@Override
	public float getPressure(ForgeDirection from) {
		if (from == ForgeDirection.UP)
			return 0;
		if (from == ForgeDirection.DOWN)
			return this.pressure + this.pressureAbove;
		return this.pressure / 2 + this.pressureAbove;
	}
}
