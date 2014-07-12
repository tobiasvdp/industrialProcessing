package mod.industrialProcessing.work.recipe;

import java.util.Iterator;

import net.minecraft.item.Item;

public interface IMachineRecipes<T extends IMachineRecipe> {
    Iterator<T> getRecipes();
    int size();
    boolean isEmpty();
    T get(int index);
	boolean isValidInput(int slot, Item item);
}
