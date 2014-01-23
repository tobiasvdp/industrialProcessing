package ip.industrialProcessing.machines.crusher;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityCrusher extends TileEntityPoweredWorkerMachine {

	public static RecipesMachine recipes = new RecipesCrusher();

	public TileEntityCrusher() {
		super(LocalDirection.LEFT, 10000, 100, true); // does 100 work per tick, lasts
												// 100 ticks
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

}
