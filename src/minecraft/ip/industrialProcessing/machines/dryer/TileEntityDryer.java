package ip.industrialProcessing.machines.dryer;

import java.util.Iterator;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityDryer extends TileEntityFluidMachine {

	public TileEntityDryer()
	{
		addTank(10*FluidContainerRegistry.BUCKET_VOLUME, ForgeDirection.UP, true, false);
		addTank(10*FluidContainerRegistry.BUCKET_VOLUME, new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST}, false, true);
		addStack(null, ForgeDirection.DOWN, false, true);
	}
	
	private static RecipesDryer recipes = new RecipesDryer();
	@Override
	public Iterator<Recipe> iterateRecipes() { 
		return recipes.iterator();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) { 
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	protected boolean isTankValidForFluid(int index, int fluidId) { 
		return recipes.isValidFluidInput(index, fluidId);
	}

}
