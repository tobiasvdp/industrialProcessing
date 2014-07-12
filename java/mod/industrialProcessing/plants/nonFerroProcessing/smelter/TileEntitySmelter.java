package ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.power.plants.IHeatable;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.utils.handler.heat.IHeated;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntitySmelter extends TileEntityFluidWorkerMachine implements IHeated, IHeatable {

    public static RecipesSmelter recipes = new RecipesSmelter();

    public TileEntitySmelter() {
        super(false);
        LocalDirection[] nodirections = new LocalDirection[0];

        addStack(null, LocalDirection.UP, true, false);
        addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
        addStack(null, nodirections, true, false);
        addStack(null, nodirections, false, true);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
    };

    @Override
    public boolean hasWork() {
        return true;
    }

    @Override
    public boolean canWork() {
        return true;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        if (slot == 0)
            return recipes.isValidInput(slot, itemID);
        return false;
    }

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
        return recipes.getRecipes();
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
        return recipes.isValidFluidInput(0, fluidId);
    }

    @Override
    public void addHeat(float heat) {
        // TODO Auto-generated method stub

    }

    @Override
    public float getHeat() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getMaxHeat() {
        // TODO Auto-generated method stub
        return 0;
    }

}
