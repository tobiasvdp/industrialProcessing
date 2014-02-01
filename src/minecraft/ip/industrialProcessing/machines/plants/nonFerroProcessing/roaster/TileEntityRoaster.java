package ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.power.plants.IHeatable;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.handler.heat.IHeated;

import java.util.Iterator;

import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityRoaster extends TileEntityFluidWorkerMachine implements IHeated, IHeatable {

    public static RecipesRoaster recipes = new RecipesRoaster();

    public TileEntityRoaster() {
	super(false);
	LocalDirection[] nodirections = new LocalDirection[0];

	addStack(null, LocalDirection.UP, true, false);
	addStack(null, LocalDirection.BACK, false, true);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, false, true);
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
    public Iterator<Recipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(0, fluidId);
    }

    @Override
    public float getHeat() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public float getMaxHeat() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void addHeat(int heat) {
	// TODO Auto-generated method stub

    }

}
