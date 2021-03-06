package ip.industrialProcessing.machines.diskFilter;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityDiskFilter extends TileEntityPoweredFluidWorkerMachine {

    public TileEntityDiskFilter() {
	super(LocalDirection.LEFT, 10000, true);
	addStack(null, LocalDirection.RIGHT, false, true); // Mixing ingredient

	LocalDirection[] nodirections = new LocalDirection[0];
	// buckets!
	addStack(null, nodirections, true, false); // Liquid Input Full Input
	addStack(null, nodirections, false, true); // Liquid Input Empty Output
	addStack(null, nodirections, true, false); // Liquid Input Full Input
	addStack(null, nodirections, false, true); // Liquid Input Empty Output
	addStack(null, nodirections, true, false); // Liquid Output Empty Input
	addStack(null, nodirections, false, true); // Liquid Output Full Output

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, new LocalDirection[] { LocalDirection.BACK, LocalDirection.FRONT }, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
    }

    @Override
    public void updateEntity() {
	addBucketToTank(1, 2, 0);
	addBucketToTank(3, 4, 1);
	getBucketFromTank(5, 6, 2);
	super.updateEntity();
    };

    public static RecipesDiskFilter recipes = new RecipesDiskFilter();

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {

	if (slot == 5) // fluid output container input slot, only empty
		       // container
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

	if (slot == 1 || slot == 3) { // fluid input container input slot, only
				      // filled containers with correct fluid
	    FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
	    if (fluid == null)
		return false;
	    int inputTank = slot == 1 ? 0 : 1;
	    return recipes.isValidFluidInput(inputTank, fluid.fluidID);
	}
	return false;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }

}
