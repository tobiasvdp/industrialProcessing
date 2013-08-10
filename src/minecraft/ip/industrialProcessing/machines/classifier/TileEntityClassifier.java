package ip.industrialProcessing.machines.classifier;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityClassifier extends TileEntityFluidMachine {

    public TileEntityClassifier()
    {
	addStack(null, ForgeDirection.UP, true, false); // Input Solid ingredient
	addStack(null, ForgeDirection.DOWN, false, true); // Output Solid ingredient

	ForgeDirection[] nodirections = new ForgeDirection[0];
	// buckets!
	addStack(null, nodirections, true, false); // Liquid Input Full Input
	addStack(null, nodirections, false, true); // Liquid Input Empty Output
	addStack(null, nodirections, true, false); // Liquid Output Empty Input
	addStack(null, nodirections, false, true); // Liquid Output Full Output

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, new ForgeDirection[] { ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST }, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, new ForgeDirection[] { ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST }, false, true);
    }
    
    private static RecipesClassifier recipes = new RecipesClassifier();
    @Override
    public Iterator<Recipe> iterateRecipes() { 
	return recipes.iterator();
    }


    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot == 0) // 0 is the recipe slot, others are buckets for liquid
		       // containers
	    return recipes.isValidInput(slot, itemID);

	if (slot == 4) // fluid output container input slot, only empty container
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

	if (slot == 2) { // fluid input container input slot, only filled containers with correct fluid
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