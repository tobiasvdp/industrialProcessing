package ip.industrialProcessing.machines.plants.metalProcessing.extruder;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityExtruder extends TileEntityPoweredFluidWorkerMachine {

    public static RecipesExtruder recipes = new RecipesExtruder();

    public TileEntityExtruder() {
	super(LocalDirection.LEFT, 10000, false);
	LocalDirection[] nodirections = new LocalDirection[0];

	addStack(null, LocalDirection.DOWN, false, true);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
	addStack(null, LocalDirection.DOWN, true, false);
	addStack(null, LocalDirection.DOWN, false, true);

    }

    @Override
    public void updateEntity() {
	addBucketToTank(1, 2, 0);
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

}
