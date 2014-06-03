package ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityIsomerizationReactor extends TileEntityPoweredFluidWorkerMachine {
    public static RecipesIsomerizationReactor recipes = new RecipesIsomerizationReactor();

    public TileEntityIsomerizationReactor() {
	super(LocalDirection.LEFT, 10000, 100, false);
	LocalDirection[] nodirections = new LocalDirection[0];
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.BACK, true, false);

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);
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
    public Iterator<IMachineRecipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }
}
