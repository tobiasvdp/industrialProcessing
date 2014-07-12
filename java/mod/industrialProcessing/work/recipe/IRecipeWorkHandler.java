package mod.industrialProcessing.work.recipe;

import java.util.Iterator;

import net.minecraft.inventory.IInventory;
import mod.industrialProcessing.utils.inventory.IInventorySlots;
import mod.industrialProcessing.work.worker.IWorkHandler;
import mod.industrialProcessing.work.worker.IWorkingEntity;

public interface IRecipeWorkHandler<TMachineRecipe extends IMachineRecipe> extends IWorkHandler, IInventorySlots, IWorkingEntity {
	Iterator<TMachineRecipe> iterateRecipes();
}
