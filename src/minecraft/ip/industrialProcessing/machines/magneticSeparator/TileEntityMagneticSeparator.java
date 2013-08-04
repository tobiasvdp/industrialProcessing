package ip.industrialProcessing.machines.magneticSeparator;

import java.util.Iterator;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMagneticSeparator extends TileEntityMachine {

	public static RecipesMagneticSeparator recipes = new RecipesMagneticSeparator();
	
	public TileEntityMagneticSeparator()
	{
		ForgeDirection[] sides = new ForgeDirection[]{
				 ForgeDirection.EAST,
				 ForgeDirection.SOUTH,
				 ForgeDirection.WEST,
				 ForgeDirection.NORTH
		};
	
		this.addStack(null, ForgeDirection.UP, true, false); // input
		this.addStack(null, ForgeDirection.DOWN, false, true); // output
		this.addStack(null, sides, false, true); // ironOxide
		this.addStack(null, sides, false, true); // nickel
		this.addStack(null, sides, false, true); // sphalerite
	}
	
	@Override
	public boolean hasWork() { 
		return true;
	}

	@Override
	public boolean canWork() { 
		return true;
	}

	@Override
	public void workDone() { 
		
	}

	@Override
	public void beginWork() { 
		
	}

	@Override
	public Iterator<Recipe> iterateRecipes() { 
		return recipes.iterator();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) { 
		return recipes.isValidInput(slot, itemID);
	}

}
