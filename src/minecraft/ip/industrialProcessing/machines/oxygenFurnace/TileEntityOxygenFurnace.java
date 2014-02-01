package ip.industrialProcessing.machines.oxygenFurnace;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityOxygenFurnace extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesOxygenFurnace recipes = new RecipesOxygenFurnace();

	public TileEntityOxygenFurnace() {
		super(LocalDirection.LEFT, 10000, false);
		LocalDirection[] nodirections = new LocalDirection[0];
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, false, true);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, false, true); 
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
		setupPowerSlot();
	}

	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0); 
		getBucketFromTank(2, 3, 2);
		super.updateEntity();
	};

	@SideOnly(Side.SERVER)
	@Override
	public boolean hasWork() {
		return true;
	}

	@SideOnly(Side.SERVER)
	@Override
	public boolean canWork() {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 2) // fluid output container input slot, only empty
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
	public Iterator<IMachineRecipe> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

}
