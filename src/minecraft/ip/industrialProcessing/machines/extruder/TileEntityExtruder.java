package ip.industrialProcessing.machines.extruder;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityExtruder extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesExtruder recipes = new RecipesExtruder();

	public TileEntityExtruder() {
		super(LocalDirection.LEFT, 10000);
		LocalDirection[] nodirections = new LocalDirection[0];
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, false, true);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
	}

	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0);
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
		if (slot == 2)
			return recipes.isValidInput(slot, itemID);
		if (slot == 1)
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
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		if (slot == 0) { // fluid input container input slot, only filled
			 // containers with correct fluid
	    return recipes.isValidFluidInput(0, fluidId);
		}
		return false;
	}

}
