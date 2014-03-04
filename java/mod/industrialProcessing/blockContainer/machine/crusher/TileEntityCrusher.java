package mod.industrialProcessing.blockContainer.machine.crusher;

import java.util.Iterator;

public class TileEntityCrusher extends TileEntityPoweredWorkerMachine {

	public static RecipesMachine recipes = new RecipesCrusher();

	public TileEntityCrusher() {
		super(LocalDirection.LEFT, 10000, 100, true); // does 100 work per tick, lasts
												// 100 ticks
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
		setupPowerSlot();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public Iterator<IMachineRecipe> iterateRecipes() {
		return recipes.getRecipes();
	}
}
