package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraftforge.common.ForgeDirection;

public class TileEntityManualTreeTap extends TileEntityWorkerMachine {

	public static RecipesManualTreeTap rubberRecipes = new RecipesManualTreeTap().addLatex();
	public static RecipesManualTreeTap pineRecipes = new RecipesManualTreeTap().addResin();

	public TileEntityManualTreeTap() {
	    super(false);
		addStack(null, (LocalDirection) null, true, false);
		addStack(null, (LocalDirection) null, false, true);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		ForgeDirection direction = this.getForwardDirection();
		int id = worldObj.getBlockId(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);

		if (id == ISetupBlocks.blockRubberLog.blockID)
			return rubberRecipes.isValidInput(slot, itemID);
		else if (id == ISetupBlocks.blockPineLog.blockID)
			return pineRecipes.isValidInput(slot, itemID);
		return false;
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		if (this.worldObj != null) {
			ForgeDirection direction = this.getForwardDirection();
			int id = worldObj.getBlockId(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);

			if (id == ISetupBlocks.blockRubberLog.blockID)
				return rubberRecipes.getRecipes();
			else if (id == ISetupBlocks.blockPineLog.blockID)
				return pineRecipes.getRecipes();
		}
		return new ArrayList<Recipe>().iterator();
	}
}
