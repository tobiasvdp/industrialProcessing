package mod.industrialProcessing.recipe;

import java.util.Iterator;

public interface IMachineRecipes<T extends IMachineRecipe> {
    Iterator<T> getRecipes();
    int size();
    boolean isEmpty();
    T get(int index);
}
