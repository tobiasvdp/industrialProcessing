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
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.utils.FluidTransfers;

public class TileEntityTank extends TileEntitySynced implements IFluidHandler, IConnectedTile {

    private FluidTank tank = new FluidTank(10 * FluidContainerRegistry.BUCKET_VOLUME);
    private boolean isTop = false;

    private ConnectionState[] states = new ConnectionState[6];
    private boolean unverified = true;

    public TileEntityTank() {
	Arrays.fill(states, ConnectionState.DISCONNECTED);
    }

    @Override
    public boolean canUpdate() {
	return true;
    }

    public void searchForNeighbors()
    {
	this.unverified = true;
    }
    
    @Override
    public void updateEntity() {
	super.updateEntity();
	if (tank.getFluidAmount() > 0 || unverified ) {
	    TileEntity entityBelow = this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
	    if (entityBelow instanceof TileEntityTank) {
		TileEntityTank tankBelow = (TileEntityTank) entityBelow;
		FluidTransfers.transfer(1000, this.tank, tankBelow.tank);
		states[ForgeDirection.DOWN.ordinal()] = ConnectionState.CONNECTED;
	    } else
		states[ForgeDirection.DOWN.ordinal()] = ConnectionState.DISCONNECTED;
	}
	if (unverified) {
	    TileEntity entityAbove = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
	    if (entityAbove instanceof TileEntityTank)
		states[ForgeDirection.UP.ordinal()] = ConnectionState.CONNECTED;
	    else
		states[ForgeDirection.UP.ordinal()] = ConnectionState.DISCONNECTED;
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
	return tank.fill(resource, doFill);
    }

    private int fillAbove(FluidStack resource, boolean doFill) {
	TileEntity entityAbove = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
	if (entityAbove instanceof TileEntityTank) {
	    TileEntityTank tankAbove = (TileEntityTank) entityAbove;
	    return tankAbove.fill(ForgeDirection.DOWN, resource, doFill);
	}
	return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
	if (resource != null && resource.isFluidEqual(tank.getFluid()))
	    return tank.drain(resource.amount, doDrain);
	return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
	return tank.drain(maxDrain, doDrain);
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
}
