package ip.industrialProcessing.machines.electrolyser;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityElectrolyser extends TileEntityPoweredFluidWorkerMachine{
	public static RecipesElectrolyser recipes = new RecipesElectrolyser();
	public TileEntityElectrolyser(){
		super(LocalDirection.LEFT, 10000,100, false);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, nodirections, true, false);
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);
		
		addStack(null, LocalDirection.BACK, false, true);
	}
	
	@Override
	public void updateEntity() {
		IFluidTank airTank = getTankInSlot(1);
		airTank.fill(new FluidStack(ISetupFluids.itemFluidAir, 20), true);
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
		return recipes.getRecipes();
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
