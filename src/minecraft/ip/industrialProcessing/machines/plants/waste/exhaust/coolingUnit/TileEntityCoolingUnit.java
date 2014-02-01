package ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityCoolingUnit extends TileEntityPoweredFluidWorkerMachine {

    public TileEntityCoolingUnit() {
	super(LocalDirection.LEFT, 10000, false);
	LocalDirection[] nodirections = new LocalDirection[0];

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
	setupPowerSlot();
    }

    @Override
    public void updateEntity() {
	FluidStack drain = drain(ForgeDirection.DOWN, 2, true);
	if (drain != null && drain.amount > 0) {
	    fill(ForgeDirection.WEST, new FluidStack(FluidRegistry.WATER, drain.amount / 2), true);
	}
	super.updateEntity();
    };

    public static RecipesCoolingUnit recipes = new RecipesCoolingUnit();

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
