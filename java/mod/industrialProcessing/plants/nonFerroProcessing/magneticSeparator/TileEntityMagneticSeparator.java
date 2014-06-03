package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

public class TileEntityMagneticSeparator extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesMagneticSeparator recipes = new RecipesMagneticSeparator();

	public TileEntityMagneticSeparator() {
		super(LocalDirection.LEFT, 10000, false);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addStack(null, LocalDirection.UP, true, false);
		
		addStack(null, LocalDirection.DOWN, false, true);
		addStack(null, LocalDirection.RIGHT, false, true);
		addStack(null, LocalDirection.RIGHT, false, true);
		addStack(null, LocalDirection.RIGHT, false, true);
		setupPowerSlot();
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
	public Iterator<IMachineRecipe> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
	    return recipes.isValidFluidInput(0, fluidId);
	}


}
