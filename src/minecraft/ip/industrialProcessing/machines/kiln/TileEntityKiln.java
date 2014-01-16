package ip.industrialProcessing.machines.kiln;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.power.plants.IHeatable;
import ip.industrialProcessing.recipes.Recipe;
import java.util.Iterator;

public class TileEntityKiln extends TileEntityPoweredWorkerMachine implements IHeatable{

	public static RecipesKiln recipes = new RecipesKiln();

	public TileEntityKiln() {
		super(LocalDirection.UNKNOWN, 100000, 100); // does 100 work per tick, lasts
												// 100 ticks
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.RIGHT, false, true);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public void addHeat(int heat) {
		((SimplePowerStorage)getMainPowerStorage()).fillPower(heat*16, true);
	}
	
	@Override
	public void updateEntity() {
		((SimplePowerStorage)getMainPowerStorage()).drainPower(1, true);
		if(getMainPowerStorage().getStoredPower() > 8000)
		    super.updateEntity();
		
	}

}
