package ip.industrialProcessing.multiblock.recipes;

import java.util.Iterator;

import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.utils.working.IWorkHandler;

public interface IRecipeMultiblockWorkHandler extends IWorkHandler, IMachineSlots{
	Iterator<RecipeMultiblock> iterateRecipes();
	Tiers getTier();
}
