package ip.industrialProcessing.machines.flotationCell;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityFlotationCell extends TileEntityFluidWorkerMachine {

	public TileEntityFlotationCell() { 
	    super(false);
		LocalDirection[] nodirections = new LocalDirection[0];
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
		LocalDirection[] allSides = new LocalDirection[] { LocalDirection.LEFT, LocalDirection.RIGHT, LocalDirection.FRONT, LocalDirection.BACK };

		// 0: input tank
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		// 1: paste output tank
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
		// 2: dirty water output tank
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);

	}

	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0); // liquid
		getBucketFromTank(2, 3, 1); // paste
		getBucketFromTank(4, 5, 2); // dirty water
		super.updateEntity();
	};

	public static RecipesFlotationCell recipes = new RecipesFlotationCell();

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
