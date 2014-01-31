package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntitySourWaterStripper extends TileEntityPoweredFluidWorkerMachine {
    public static RecipesSourWaterStripper recipes = new RecipesSourWaterStripper();

    public TileEntitySourWaterStripper() {
	super(LocalDirection.LEFT, 10000, 100, false);
	LocalDirection[] nodirections = new LocalDirection[0];

	addStack(null, nodirections, true, false);
	addStack(null, nodirections, false, true);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.BACK, true, false);

	addStack(null, nodirections, true, false);
	addStack(null, nodirections, false, true);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);
    }

    @Override
    public void updateEntity() {
	addBucketToTank(0, 1, 0);
	getBucketFromTank(2, 3, 2);
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
	if (slot == 2)
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));
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
