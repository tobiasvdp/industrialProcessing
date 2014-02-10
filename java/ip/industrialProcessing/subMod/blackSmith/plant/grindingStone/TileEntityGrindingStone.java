package ip.industrialProcessing.subMod.blackSmith.plant.grindingStone;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

public class TileEntityGrindingStone extends TileEntityWorkerMachine {
    public static RecipesGrindingStone recipes = new RecipesGrindingStone();

    public TileEntityGrindingStone() {
	super(true);
	LocalDirection[] nodirections = new LocalDirection[0];

	this.addStack(null, nodirections, true, false);
	this.addStack(null, nodirections, false, true);
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
