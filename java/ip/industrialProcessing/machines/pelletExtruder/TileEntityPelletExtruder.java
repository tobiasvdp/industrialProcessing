package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

public class TileEntityPelletExtruder extends TileEntityPoweredWorkerMachine {

    public static RecipesPelletExtruder recipes = new RecipesPelletExtruder();

    public TileEntityPelletExtruder() {
	super(LocalDirection.LEFT, 10000, 20, false); // does 100 work per tick, lasts
					       // 100 ticks
	this.addStack(null, LocalDirection.UP, true, false);
	this.addStack(null, LocalDirection.DOWN, false, true);
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
