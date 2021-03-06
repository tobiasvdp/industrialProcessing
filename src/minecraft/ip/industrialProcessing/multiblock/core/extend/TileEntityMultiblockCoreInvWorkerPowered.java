package ip.industrialProcessing.multiblock.core.extend;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.PowerWorkerHelper;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblockWorker;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.recipes.IPowerRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.DirectionUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMultiblockCoreInvWorkerPowered extends TileEntityMultiblockCoreInvWorker implements IPoweredMachine {

    public TileEntityMultiblockCoreInvWorkerPowered(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes, LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
        super(structure, tierRequirments, recipes);
        this.powerInputSide = powerInput;
        this.maxWorkSpeed = maxWorkSpeed;
        this.storage = new SimplePowerStorage(powerCapacity);
    }

    private LocalDirection powerInputSide;
    private int maxWorkSpeed;
    private SimplePowerStorage storage;

    @Override
    public void doWork() {
        Recipe recipe = ((RecipeMultiblockWorker) getWorker()).getCurrentRecipe();

        if (recipe != null) {
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
