package ip.industrialProcessing.machines.wireMill;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityWireMill extends TileEntityPoweredWorkerMachine {
    
    public static RecipesWireMill recipes = new RecipesWireMill(); 
    
    public TileEntityWireMill() {
	super(LocalDirection.LEFT, 10000, 100); // does 100 work per tick, lasts
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
