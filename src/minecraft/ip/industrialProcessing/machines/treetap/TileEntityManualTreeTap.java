package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.working.ServerWorker;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityManualTreeTap extends TileEntityWorkerMachine {

    public static RecipesManualTreeTap rubberRecipes = new RecipesManualTreeTap().addLatex();
    public static RecipesManualTreeTap pineRecipes = new RecipesManualTreeTap().addResin();

    public TileEntityManualTreeTap() {
	addStack(null, (LocalDirection) null, true, false);
	addStack(null, (LocalDirection) null, false, true);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	ForgeDirection direction = this.getForwardDirection();
	int id = worldObj.getBlockId(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);

	if (id == IndustrialProcessing.blockRubberLog.blockID)
	    return rubberRecipes.isValidInput(slot, itemID);
	else if (id == IndustrialProcessing.blockPineLog.blockID)
	    return pineRecipes.isValidInput(slot, itemID);
	return false;
    }

    @Override
    public Iterator<Recipe> iterateRecipes() {
	ForgeDirection direction = this.getForwardDirection();
	int id = worldObj.getBlockId(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);

	if (id == IndustrialProcessing.blockRubberLog.blockID)
	    return rubberRecipes.iterator();
	else if (id == IndustrialProcessing.blockPineLog.blockID)
	    return pineRecipes.iterator();
	return null;
    }
}
