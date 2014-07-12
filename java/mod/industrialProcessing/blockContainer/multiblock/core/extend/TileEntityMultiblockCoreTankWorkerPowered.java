package mod.industrialProcessing.blockContainer.multiblock.core.extend;

import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.power.network.IPowerStorage;
import mod.industrialProcessing.power.network.IPoweredMachine;
import mod.industrialProcessing.power.network.PowerHelper;
import mod.industrialProcessing.power.network.PowerWorkerHelper;
import mod.industrialProcessing.power.network.SimplePowerStorage;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.IPowerRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeMultiblockWorker;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMultiblockCoreTankWorkerPowered extends TileEntityMultiblockCoreTankWorker implements IPoweredMachine {

    public TileEntityMultiblockCoreTankWorkerPowered(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes, LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
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
        Recipe recipe = ((RecipeMultiblockWorker) getWorker()).findCurrentRecipe();

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
