package ip.industrialProcessing.recipes;

import java.util.Iterator;

import net.minecraft.item.crafting.IRecipe;

public interface IMachineRecipes<T extends IMachineRecipe> {
    Iterator<T> getRecipes();
    int size();
    boolean isEmpty();
    T get(int index);
}
