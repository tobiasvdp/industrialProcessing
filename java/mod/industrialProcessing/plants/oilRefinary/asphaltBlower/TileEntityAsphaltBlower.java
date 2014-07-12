package ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityAsphaltBlower extends TileEntityPoweredFluidWorkerMachine{
	public static RecipesAsphaltBlower  recipes = new RecipesAsphaltBlower();
	
	public TileEntityAsphaltBlower(){
		super(LocalDirection.LEFT, 10000,100,false);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, false, true);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		
		addStack(null, nodirections, false, true);
	}
	
	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0);
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
	public Iterator<IMachineRecipe> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) {
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		return false;
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}
}
