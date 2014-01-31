package ip.industrialProcessing.machines.insulator;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityInsulator extends TileEntityPoweredFluidWorkerMachine{
	public static RecipesInsulator recipes = new RecipesInsulator();

	public TileEntityInsulator(){
		super(LocalDirection.LEFT, 10000,100, false);
		
		addStack(null, LocalDirection.UP, true, false);
		addStack(null, LocalDirection.DOWN, false, true);
		
		LocalDirection[] nodirections = new LocalDirection[0];
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, false, true);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, true, false);
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
	public Iterator<Recipe> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		if (slot == 2) {
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
