package ip.industrialProcessing.recipes;

import java.util.Iterator;

import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.utils.working.IWorkHandler;

public interface IRecipeWorkHandler extends IWorkHandler, IMachineSlots { 
	Iterator<IMachineRecipe> iterateRecipes();
}
