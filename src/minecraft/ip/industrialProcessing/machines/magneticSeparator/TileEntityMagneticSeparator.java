package ip.industrialProcessing.machines.magneticSeparator;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMagneticSeparator extends TileEntityMachine {

	public static RecipesMagneticSeparator recipes = new RecipesMagneticSeparator();
	
	public TileEntityMagneticSeparator()
	{  
	
		this.addStack(null, LocalDirection.UP, true, false); // input
		this.addStack(null, LocalDirection.DOWN, false, true); // output
		this.addStack(null, LocalDirection.RIGHT, false, true); // ironOxide
		this.addStack(null, LocalDirection.RIGHT, false, true); // nickel
		this.addStack(null, LocalDirection.RIGHT, false, true); // sphalerite
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
