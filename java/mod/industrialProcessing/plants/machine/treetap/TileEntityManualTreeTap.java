package mod.industrialProcessing.plants.machine.treetap;

import java.util.ArrayList;
import java.util.Iterator;

import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvWork;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityManualTreeTap extends TileEntityMachineInvWork {

    public static RecipesManualTreeTap rubberRecipes = new RecipesManualTreeTap().addLatex();
    public static RecipesManualTreeTap pineRecipes = new RecipesManualTreeTap().addResin();

    public TileEntityManualTreeTap() {
	super(pineRecipes);
	addStack(null, (LocalDirection) null, true, false);
	addStack(null, (LocalDirection) null, false, true);
    }

    @Override
    protected boolean isValidInput(int slot, Item itemID) {
	ForgeDirection direction = this.getForwardDirection();
	Block id = worldObj.getBlock(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);

	if (id.equals(ISetupBlocks.blockRubberLog))
	    return rubberRecipes.isValidInput(slot, itemID);
	else if (id.equals(ISetupBlocks.blockPineLog))
	    return pineRecipes.isValidInput(slot, itemID);
	return false;
    }

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
	if (this.worldObj != null) {
	    ForgeDirection direction = this.getForwardDirection();
	    Block id = worldObj.getBlock(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);

	    if (id.equals(ISetupBlocks.blockRubberLog))
		return rubberRecipes.getRecipes();
	    else if (id.equals(ISetupBlocks.blockPineLog))
		return pineRecipes.getRecipes();
	}
	return new ArrayList<IMachineRecipe>().iterator();
    }
}
