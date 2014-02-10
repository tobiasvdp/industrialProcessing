package ip.industrialProcessing.recipes;

import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.utils.working.IWorkHandler;

import java.util.Iterator;

public interface IRecipeWorkHandler extends IWorkHandler, IMachineSlots { 
	Iterator<IMachineRecipe> iterateRecipes();
}
