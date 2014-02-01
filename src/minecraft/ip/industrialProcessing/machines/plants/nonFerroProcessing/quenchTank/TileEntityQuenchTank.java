package ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityQuenchTank extends TileEntityFluidWorkerMachine {

    public static RecipesQuenchTank recipes = new RecipesQuenchTank();

    public TileEntityQuenchTank() {
	super(false);
	LocalDirection[] nodirections = new LocalDirection[0];

	addStack(null, LocalDirection.UP, true, false);
	addStack(null, LocalDirection.DOWN, false, true);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);
	addStack(null, nodirections, true, false);
	addStack(null, nodirections, false, true);
    }

    @Override
    public void updateEntity() {
	addBucketToTank(2, 3, 0);
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
    public Iterator<Recipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(0, fluidId);
    }

}
