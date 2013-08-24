package ip.industrialProcessing.multiblock.extended.inventory.worker.power;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.PowerWorkerHelper;
import ip.industrialProcessing.multiblock.extended.inventory.worker.TileEntityMultiblockCoreInvWorker;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.recipes.Recipe;

public abstract class TileEntityMultiblockCoreInvWorkerPowered extends TileEntityMultiblockCoreInvWorker implements IPowerAcceptor {

    private LocalDirection powerInputSide;
    private int powerStorage;
    private int powerCapacity;
    private int maxWorkSpeed;

    public TileEntityMultiblockCoreInvWorkerPowered(MultiblockLayout layout, LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
	super(layout, maxWorkSpeed);
	this.powerInputSide = powerInput;
	this.powerStorage = 0;
	this.powerCapacity = powerCapacity;
	this.maxWorkSpeed = maxWorkSpeed;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	System.out.println(powerStorage);
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
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	// TODO Auto-generated method stub

    }

    @Override
    public float getResistance(ForgeDirection side) {
	if (canAcceptPower(side)) {
	    return PowerHelper.getResistanceForStorage(this.powerStorage, this.powerCapacity);
	}
	return Float.POSITIVE_INFINITY;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	return this.powerInputSide == DirectionUtils.GetLocalDirection(side, getForwardDirection());
    }

    public int getPowerCapacity() {
	return powerCapacity;
    }

    public int getPowerStorage() {
	return powerStorage;
    }

    public void incPowerStorage(int accept) {
	powerStorage += accept;
    }

}
