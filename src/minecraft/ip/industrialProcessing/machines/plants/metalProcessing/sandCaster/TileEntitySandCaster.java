package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.plants.metalProcessing.turretLathe.RecipesTurretLathe;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntitySandCaster extends TileEntityPoweredFluidWorkerMachine {

	public TileEntitySandCaster() {
		super(LocalDirection.LEFT, 10000);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addStack(null, LocalDirection.BACK, true, false);
		
		addStack(null, LocalDirection.DOWN, false, true);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	};

	public static RecipesSandCaster recipes = new RecipesSandCaster();

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
		return recipes.iterator();
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
