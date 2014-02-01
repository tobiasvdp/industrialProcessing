package ip.industrialProcessing.machines;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.items.ItemBattery;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.recipes.IPowerRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.subMod.logic.old.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.subMod.logic.old.api.network.interfaces.StatusType;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.PowerTransfers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPoweredWorkerMachine extends TileEntityWorkerMachine implements IPoweredMachine {

    private LocalDirection powerInputSide;
    private int maxWorkSpeed;

    private SimplePowerStorage storage;
    private int batterySlot = -1;

    public TileEntityPoweredWorkerMachine(LocalDirection powerInput, int powerCapacity, int maxWorkSpeed, boolean hasAnimatedTileEntityRenderer) {
        super(hasAnimatedTileEntityRenderer);
        this.powerInputSide = powerInput;
        this.maxWorkSpeed = maxWorkSpeed;
        this.storage = new SimplePowerStorage(powerCapacity);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote)
            drainBattery();
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        if (i == batterySlot) {
            return PowerTransfers.isBattery(itemstack);
        }
        return super.isItemValidForSlot(i, itemstack);
    }

    public boolean drainBattery() {
        ItemStack stack = getStackInSlot(batterySlot);
        if (stack != null) {
            return PowerTransfers.transfer(stack, 100, this.storage) > 0;
        }
        return false;
    }

    protected void setupPowerSlot() {
        this.batterySlot = addStack(null, new LocalDirection[0], true, true);
    }

    public TileEntityPoweredWorkerMachine(LocalDirection powerInput, int powerCapacity, boolean hasAnimatedTileEntityRenderer) {
        this(powerInput, powerCapacity, PowerWorkerHelper.DEFAULT_WORK_SPEED, hasAnimatedTileEntityRenderer);
    }

    @Override
    public void doWork() {
        Recipe recipe = ((RecipeWorker) this.worker).getCurrentRecipe();

        if (recipe != null && !worldObj.isRemote) {
            status = StatusType.working;
            int amount = PowerWorkerHelper.getWork(this.storage, this.maxWorkSpeed);
            int maxWork = this.storage.drainPower(amount, false);
            
            if (recipe instanceof IPowerRecipe) {
		IPowerRecipe powerRecipe = (IPowerRecipe) recipe;
		if (powerRecipe.getPowerRequired() > 0)
		    maxWork /= powerRecipe.getPowerRequired();
		else
		    maxWork = this.maxWorkSpeed;
	    } else
		maxWork = this.maxWorkSpeed;

	    int maxPower = work(maxWork);
	    if (recipe instanceof IPowerRecipe) {
		IPowerRecipe powerRecipe = (IPowerRecipe) recipe;
		maxPower *= powerRecipe.getPowerRequired();
		this.storage.drainPower(maxPower, true);
	    }

        } else
            status = StatusType.idle;
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
        if (canAcceptPower(side) && !worldObj.isRemote) {
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

    @Override
    public InterfaceType[] getConnectionTypes() {
        return new InterfaceType[] { InterfaceType.single, InterfaceType.inventory, InterfaceType.worker, InterfaceType.power };
    };

}
