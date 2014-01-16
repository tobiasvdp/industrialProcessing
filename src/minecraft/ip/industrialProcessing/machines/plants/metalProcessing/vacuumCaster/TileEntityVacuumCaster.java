package ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityVacuumCaster extends TileEntityPoweredFluidWorkerMachine {

	public TileEntityVacuumCaster() {
		super(LocalDirection.LEFT, 10000);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addStack(null, LocalDirection.BACK, true, false);
		
		addStack(null, LocalDirection.DOWN, false, true);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	};

	public static RecipesVacuumCaster recipes = new RecipesVacuumCaster();

	@Override
	public boolean hasWork() {
		return true;
	}

	@Override
	public boolean canWork() {
		return true;
	}
	
	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		return false;
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

}
