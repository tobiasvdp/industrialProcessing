package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityIncubator extends TileEntityPoweredWorkerMachine {
    public static RecipesIncubator recipes = new RecipesIncubator();

    public TileEntityIncubator() {
	super(LocalDirection.LEFT, 10000, 100, false);

	this.addStack(null, LocalDirection.UP, true, false);
	this.addStack(null, LocalDirection.DOWN, false, true);
	setupPowerSlot();
    }

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return recipes.isValidInput(slot, itemID);
    }

}
