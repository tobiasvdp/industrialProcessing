package ip.industrialProcessing.machines.filter;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityFilter extends TileEntityPoweredWorkerMachine {

    public static RecipesFilter recipes = new RecipesFilter();

    public TileEntityFilter() {
	super(LocalDirection.LEFT, 10000, true);
	this.addStack(null, LocalDirection.UP, true, false);
	this.addStack(null, LocalDirection.RIGHT, false, true);
	this.addStack(null, LocalDirection.DOWN, false, true);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return recipes.isValidInput(slot, itemID);
    }

    @Override
    public Iterator<Recipe> iterateRecipes() {
	return recipes.getRecipes();
    }
}
