package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.utils.working.IWorkHandler;

import java.util.Iterator;

public interface IRecipeMultiblockWorkHandler extends IWorkHandler, IMachineSlots{
	Iterator<RecipeMultiblock> iterateRecipes();
	Tiers getTier();
}
