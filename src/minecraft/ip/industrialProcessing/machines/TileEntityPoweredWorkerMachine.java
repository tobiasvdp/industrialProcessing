package ip.industrialProcessing.machines;

import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPoweredWorkerMachine extends TileEntityWorkerMachine implements IPowerAcceptor {

    private LocalDirection powerInputSide;
    private int powerStorage;
    private int powerCapacity;
    private int maxWorkSpeed;

    public TileEntityPoweredWorkerMachine(LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
	this.powerInputSide = powerInput;
	this.powerStorage = 0;
	this.powerCapacity = powerCapacity;
	this.maxWorkSpeed = maxWorkSpeed;
    }

    public TileEntityPoweredWorkerMachine(LocalDirection powerInput, int powerCapacity) {
	this(powerInput, powerCapacity, PowerWorkerHelper.DEFAULT_WORK_SPEED);
    }

    @Override
    public void doWork() {
	int amount = PowerWorkerHelper.getWork(this.powerCapacity, this.powerStorage, this.maxWorkSpeed);
	this.powerStorage -= work(amount);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	readPowerStatus(nbt);
    }

    private void readPowerStatus(NBTTagCompound nbt) {
	this.powerStorage = nbt.getInteger("PowStor");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	writePowerStatus(nbt);
    }

    private void writePowerStatus(NBTTagCompound nbt) {
	nbt.setInteger("PowStor", this.powerStorage);
    }

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side) {
	if (canAcceptPower(side)) {
	    int accept = PowerWorkerHelper.acceptPower(this.powerCapacity, this.powerStorage, maxAmount);
	    this.powerStorage += accept;
	    return accept;
	}
	return 0;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	return this.powerInputSide == DirectionUtils.GetLocalDirection(side, getForwardDirection());
    }

}
