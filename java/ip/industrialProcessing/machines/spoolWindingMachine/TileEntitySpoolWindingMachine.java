package ip.industrialProcessing.machines.spoolWindingMachine;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

public class TileEntitySpoolWindingMachine extends TileEntityPoweredWorkerMachine {
	public static RecipesSpoolWindingMachine recipes = new RecipesSpoolWindingMachine();

	public TileEntitySpoolWindingMachine() {
		super(LocalDirection.LEFT, 10000, 100, false);
		this.addStack(null, LocalDirection.UP, true, false);
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
