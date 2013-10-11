package ip.industrialProcessing.machines;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPoweredFluidWorkerMachine extends TileEntityFluidWorkerMachine implements IPoweredMachine {

    private LocalDirection powerInputSide;
    private int maxWorkSpeed;

    private SimplePowerStorage storage;

    public TileEntityPoweredFluidWorkerMachine(LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
	this.powerInputSide = powerInput;
	this.maxWorkSpeed = maxWorkSpeed;
	this.storage = new SimplePowerStorage(powerCapacity);
    }

    public TileEntityPoweredFluidWorkerMachine(LocalDirection powerInput, int powerCapacity) {
	this(powerInput, powerCapacity, PowerWorkerHelper.DEFAULT_WORK_SPEED);
    }

    @Override
    public void doWork() {

	Recipe recipe = ((RecipeWorker) this.serverWorker).getCurrentRecipe();

	if (recipe != null) {
	    int amount = PowerWorkerHelper.getWork(this.storage, this.maxWorkSpeed);

	    if (recipe.powerRequired > 0)
		amount /= recipe.powerRequired;

	    int maxWork = this.storage.drainPower(amount, false);
	    int maxPower = work(maxWork);
	    if (recipe.powerRequired > 0)
		maxPower *= recipe.powerRequired;
	    this.storage.drainPower(maxPower, true);
	}
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	this.storage.writeToNBT(nbt);
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
	if (canAcceptPower(side)) {
	    return PowerHelper.getResistanceForStorage(this.storage);
	}
	return Float.POSITIVE_INFINITY;
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	if (canAcceptPower(side)) {
	    int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
	    this.storage.fillPower(joules, true);
	}
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	return this.powerInputSide == DirectionUtils.getLocalDirection(side, getForwardDirection());
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
	return this.storage;
    }
}
