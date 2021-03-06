package ip.industrialProcessing.machines.dryer;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityDryer extends TileEntityPoweredFluidWorkerMachine {

	public TileEntityDryer() {
		super(LocalDirection.LEFT, 10000, false);
		addStack(null, new LocalDirection[] { LocalDirection.FRONT, LocalDirection.BACK }, false, true); // Mixing
																											// ingredient

		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full Input
		addStack(null, nodirections, false, true); // Liquid Input Empty Output
		addStack(null, nodirections, true, false); // Liquid Output Empty Input
		addStack(null, nodirections, false, true); // Liquid Output Full Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
	}

	@Override
	public void updateEntity() {
		addBucketToTank(1, 2, 0);
		getBucketFromTank(3, 4, 1);
		super.updateEntity();
	};

	public static RecipesDryer recipes = new RecipesDryer();

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
		if (slot == 0) // 0 is the recipe slot, others are buckets for liquid
			// containers
			return recipes.isValidInput(slot, itemID);

		if (slot == 3) // fluid output container input slot, only empty
						// container
			return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

		if (slot == 1) { // fluid input container input slot, only filled
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
