package mod.industrialProcessing.work.recipe;

import java.util.Iterator;

import net.minecraft.inventory.IInventory;
import mod.industrialProcessing.utils.inventory.IInventorySlots;
import mod.industrialProcessing.work.worker.IWorkHandler;

public interface IRecipeWorkHandler extends IWorkHandler, IInventorySlots{ 
	Iterator<IMachineRecipe> iterateRecipes();
}
