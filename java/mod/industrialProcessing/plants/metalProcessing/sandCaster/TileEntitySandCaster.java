package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntitySandCaster extends TileEntityPoweredFluidWorkerMachine implements IAnimationSyncable {

    public TileEntitySandCaster() {
	super(LocalDirection.LEFT, 10000, true);
	LocalDirection[] nodirections = new LocalDirection[0];

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
	addStack(null, LocalDirection.BACK, true, false);

	addStack(null, LocalDirection.DOWN, false, true);

	addStack(null, nodirections, true, false);

	addStack(null, nodirections, false, true);
	setupPowerSlot();
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	addBucketToTank(2, 3, 0);

	if (this.animationHandler.getProgress() < 0 && getStackInSlot(0) != null)
	    this.animationHandler.setProgress(0);
	if (this.animationHandler.getProgress() >= 0 && getStackInSlot(0) == null)
	    this.animationHandler.setProgress(-1);
    };

    public static RecipesSandCaster recipes = new RecipesSandCaster();

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
	if (slot == 0)
	    return recipes.isValidInput(slot, itemID);
	return false;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }
}
