package mod.industrialProcessing.blockContainer.machine;

import mod.industrialProcessing.power.network.IPowerStorage;
import mod.industrialProcessing.power.network.IPoweredMachine;
import mod.industrialProcessing.power.network.PowerHelper;
import mod.industrialProcessing.power.network.PowerTransfers;
import mod.industrialProcessing.power.network.PowerWorkerHelper;
import mod.industrialProcessing.power.network.SimplePowerStorage;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.IPowerRecipe;
import mod.industrialProcessing.work.recipe.RecipeWorker;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineInvWorkPower extends TileEntityMachineInvWork  implements IPoweredMachine {

    private LocalDirection powerInputSide;
    private int maxWorkSpeed;

    private SimplePowerStorage storage;
    private int batterySlot = -1;

    public TileEntityMachineInvWorkPower(RecipesMachine recipes, LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
        super(recipes);
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

    @Override
    public void doWork() {
        IMachineRecipe recipe = ((RecipeWorker) this.worker).getCurrentRecipe();

        if (recipe != null && !worldObj.isRemote) {
            int amount = PowerWorkerHelper.getWork(this.storage, this.maxWorkSpeed);
            int maxWork = (int) this.storage.drainPower(amount, false);

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

        } else{
        	
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
        if (canAcceptPower(side) && !worldObj.isRemote) {
            int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
            this.storage.fillPower(joules, true);
        }
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        return this.powerInputSide == getLocalDirection(side);
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
        return this.storage;
    }

}
