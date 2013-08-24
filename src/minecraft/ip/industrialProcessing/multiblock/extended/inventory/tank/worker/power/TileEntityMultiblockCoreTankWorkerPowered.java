package ip.industrialProcessing.multiblock.extended.inventory.tank.worker.power;

import java.util.Iterator;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.PowerWorkerHelper;
import ip.industrialProcessing.multiblock.extended.inventory.tank.worker.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeFluidPowerWorker;
import ip.industrialProcessing.recipes.RecipeFluidWorker;
import ip.industrialProcessing.utils.working.ServerWorker;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMultiblockCoreTankWorkerPowered extends TileEntityMultiblockCoreTankWorker implements IPowerAcceptor {
    private static final float BASE_RESISTANCE = 100;
    private int powerStorage;
    private int powerCapacity;
    private int maxWorkSpeed;

    public TileEntityMultiblockCoreTankWorkerPowered(MultiblockLayout layout, int powerCapacity, int maxWorkSpeed) {
	super(layout, maxWorkSpeed);
	this.powerStorage = 0;
	this.powerCapacity = powerCapacity;
	this.maxWorkSpeed = maxWorkSpeed;
    }

    @Override
    protected ServerWorker createServerSideWorker() {
	return new RecipeFluidPowerWorker(this);
    }

    @Override
    public void doWork() {
	work(amount, powerStorage);
	if (!worldObj.isRemote) {
	    powerStorage = ((RecipeFluidPowerWorker) getWorker()).powerConsumption(powerStorage);
	}
    }

    protected int work(int amount, int power) {
	return this.getWorker().doWork(amount, power);
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
    public void applyPower(ForgeDirection side, float charge, float voltage) {
	if (canAcceptPower(side)) {
	    // TODO: balance the energy
	    float joules = charge * voltage;
	    int accept = PowerWorkerHelper.acceptPower(this.powerCapacity, this.powerStorage, (int) joules);
	    this.powerStorage += accept;
	}
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
	if (canAcceptPower(side)) {
	    float available = this.powerStorage / (float) this.powerCapacity;
	    // 0% = X ohm;
	    // 100% = Infinite Ohm;
	    if (available == 1)
		return Float.POSITIVE_INFINITY;
	    float ohm = BASE_RESISTANCE * (float) (-1 / Math.log(available));
	    return ohm;
	}
	return Float.POSITIVE_INFINITY;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	return true;
    }

    public int getPowerCapacity() {
	return powerCapacity;
    }

    public int getPowerStorage() {
	return powerStorage;
    }

    public void incPowerStorage(int accept) {
	powerStorage += Math.min(accept, powerCapacity - powerStorage);
    }

}
