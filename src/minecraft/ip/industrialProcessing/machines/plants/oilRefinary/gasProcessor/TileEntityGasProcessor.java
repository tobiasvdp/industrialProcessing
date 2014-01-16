package ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityGasProcessor extends TileEntityPoweredFluidWorkerMachine{
	public static RecipesGasProcessor recipes = new RecipesGasProcessor();
	
	public TileEntityGasProcessor(){
		super(LocalDirection.LEFT, 10000,100);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.BACK, true, false);
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, false, true);
		
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
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}
}
