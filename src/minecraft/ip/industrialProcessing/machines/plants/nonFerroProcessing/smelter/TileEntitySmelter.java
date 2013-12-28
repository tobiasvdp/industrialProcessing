package ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.RecipesExtruder;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntitySmelter extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesSmelter recipes = new RecipesSmelter();

	public TileEntitySmelter() {
		super(LocalDirection.LEFT, 10000);
		LocalDirection[] nodirections = new LocalDirection[0];

		addStack(null, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
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
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		return false;
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(0, fluidId);
	}

}