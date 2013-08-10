package ip.industrialProcessing.machines.diskFilter;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityDiskFilter extends TileEntityFluidMachine {

    public TileEntityDiskFilter() {
	addStack(null, LocalDirection.UP, true, false); // Mixing ingredient

	LocalDirection[] nodirections = new LocalDirection[0];
	// buckets!
	addStack(null, nodirections, true, false); // Liquid Input Full Input
	addStack(null, nodirections, false, true); // Liquid Input Empty Output
	addStack(null, nodirections, true, false); // Liquid Input Full Input
	addStack(null, nodirections, false, true); // Liquid Input Empty Output
	addStack(null, nodirections, true, false); // Liquid Output Empty Input
	addStack(null, nodirections, false, true); // Liquid Output Full Output
	LocalDirection[] allSides = new LocalDirection[] { LocalDirection.LEFT, LocalDirection.RIGHT, LocalDirection.FRONT, LocalDirection.BACK };

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, allSides, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, allSides, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
    }

    @Override
    public void updateEntity() {
	addBucketToTank(1, 2, 0);
	addBucketToTank(3, 4, 1);
	getBucketFromTank(5, 6, 2);
	super.updateEntity();
    };

    private static RecipesDiskFilter recipes = new RecipesDiskFilter();

    @Override
    public Iterator<Recipe> iterateRecipes() {
	return recipes.iterator();
    }


    @Override
    protected boolean isValidInput(int slot, int itemID) { 

	if (slot == 5) // fluid output container input slot, only empty container
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

	if (slot == 1 || slot == 3) { // fluid input container input slot, only filled containers with correct fluid
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
