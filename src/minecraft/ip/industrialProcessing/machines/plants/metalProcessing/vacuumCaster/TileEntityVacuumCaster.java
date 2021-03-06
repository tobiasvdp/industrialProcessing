package ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityVacuumCaster extends TileEntityPoweredFluidWorkerMachine {

    public TileEntityVacuumCaster() {
	super(LocalDirection.LEFT, 10000, false);
	LocalDirection[] nodirections = new LocalDirection[0];

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
	addStack(null, LocalDirection.BACK, true, false);
	addStack(null, nodirections, true, false);
	addStack(null, nodirections, false, true);

	setupPowerSlot();
    }

    @Override
    public void updateEntity() {
	addBucketToTank(1, 2, 0);
	super.updateEntity();
    };

    public static RecipesVacuumCaster recipes = new RecipesVacuumCaster();

    @Override
    public boolean hasWork() {
	return true;
    }

    @Override
    public boolean canWork() {
	return true;
    }

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot == 0)
	    return recipes.isValidInput(slot, itemID);
	return false;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }

}
