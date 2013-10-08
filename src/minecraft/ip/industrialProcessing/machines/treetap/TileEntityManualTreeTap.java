package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityManualTreeTap extends TileEntityWorkerMachine {
    
    public static RecipesManualTreeTap recipes = new RecipesManualTreeTap();
    public TileEntityManualTreeTap() {
        addStack(null, (LocalDirection) null, true, false);
        addStack(null, (LocalDirection) null, false, true);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return recipes.isValidInput(0, itemID);
    }

    @Override
    public Iterator<Recipe> iterateRecipes() { 
        return recipes.iterator();
    }
}
