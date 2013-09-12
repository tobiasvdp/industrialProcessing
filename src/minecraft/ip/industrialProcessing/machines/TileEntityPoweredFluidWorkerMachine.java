package ip.industrialProcessing.machines;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPoweredFluidWorkerMachine extends TileEntityFluidWorkerMachine implements IPowerAcceptor {
 
    private LocalDirection powerInputSide;
    private int powerStorage;
    private int powerCapacity;
    private int maxWorkSpeed;

    public TileEntityPoweredFluidWorkerMachine(LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
	this.powerInputSide = powerInput;
	this.powerStorage = 0;
	this.powerCapacity = powerCapacity;
	this.maxWorkSpeed = maxWorkSpeed;
    }

    public TileEntityPoweredFluidWorkerMachine(LocalDirection powerInput, int powerCapacity) {
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
    public float getResistance(ForgeDirection side, float voltage) {
	if (canAcceptPower(side)) {  
	    return PowerHelper.getResistanceForStorage(this.powerStorage, this.powerCapacity);
	}
	return Float.POSITIVE_INFINITY;
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	if (canAcceptPower(side)) { 
	    int joules = (int) PowerHelper.getEnergy(coulombs, voltage); 
	    this.powerStorage = Math.min(this.powerStorage + joules, this.powerCapacity);
	}
    } 

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	return this.powerInputSide == DirectionUtils.getLocalDirection(side, getForwardDirection());
    }

}
