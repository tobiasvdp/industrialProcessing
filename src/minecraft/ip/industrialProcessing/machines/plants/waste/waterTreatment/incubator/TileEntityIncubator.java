package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityIncubator extends TileEntityPoweredFluidWorkerMachine{
	public TileEntityIncubator() {
		super(LocalDirection.LEFT, 10000);
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		// TODO Auto-generated method stub
		return false;
	}
}
