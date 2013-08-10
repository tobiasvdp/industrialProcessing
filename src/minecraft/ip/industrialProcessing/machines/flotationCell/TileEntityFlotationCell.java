package ip.industrialProcessing.machines.flotationCell;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.thickener.RecipesThickener;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityFlotationCell extends TileEntityFluidMachine {

    public TileEntityFlotationCell() {

	ForgeDirection[] nodirections = new ForgeDirection[0];
	// buckets!
	// 0: Liquid Input Full Input
	addStack(null, nodirections, true, false);
	// 1: Liquid Input Empty Output
	addStack(null, nodirections, false, true);
	// 2: Paste Output Empty Input
	addStack(null, nodirections, true, false);
	// 3: Paste Output Full Output
	addStack(null, nodirections, false, true);
	// 4 : Dirty Water Output Empty Input
	addStack(null, nodirections, true, false);
	// 5: Dirty Water Output Full Output
	addStack(null, nodirections, false, true);

	// 0: input tank
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, new ForgeDirection[] { ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST }, true, false);
	// 1: paste output tank
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, ForgeDirection.DOWN, false, true);
	// 2: dirty water output tank
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, new ForgeDirection[] { ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST }, false, true);

    }

    @Override
    public void updateEntity() {
	addBucketToTank(0, 1, 0); // liquid
	getBucketFromTank(2, 3, 1); // paste
	getBucketFromTank(4, 5, 2); // dirty water
	super.updateEntity();
    };

    private static RecipesFlotationCell recipes = new RecipesFlotationCell();

    @Override
    public Iterator<Recipe> iterateRecipes() {
	return recipes.iterator();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot == 2 || slot == 4) // fluid output container input slot, only
				    // empty
	    // container
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

	if (slot == 0) { // fluid input container input slot, only filled
			 // containers with correct fluid
	    FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
	    if (fluid == null)
		return false;
	    return recipes.isValidFluidInput(0, fluid.fluidID);
	}
	return false;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }
}