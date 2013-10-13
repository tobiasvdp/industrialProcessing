package ip.industrialProcessing.machines.treetap;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesManualTreeTap extends RecipesMachine {
    public RecipesManualTreeTap() {
        Recipe latex = new Recipe();

        latex.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.bucketEmpty.itemID, RecipeSlotType.INVENTORY, 1) };
        latex.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.bucketFluidLatex.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.5) };
        latex.workRequired = 5000;
        latex.powerRequired = 0; 
        addRecipe(latex);
    }
}
