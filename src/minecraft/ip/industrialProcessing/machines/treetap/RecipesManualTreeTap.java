package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.item.Item;

public class RecipesManualTreeTap extends RecipesMachine {
    public RecipesManualTreeTap() {
    }

    public RecipesManualTreeTap addLatex() {

	PoweredRecipe latex = new PoweredRecipe();

	latex.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.bucketEmpty.itemID, RecipeSlotType.INVENTORY, 1) };
	latex.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.bucketFluidLatex.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.5) };
	latex.workRequired = 2000;
	latex.powerRequired = 0;
	addRecipe(latex);
	return this;
    }

    public RecipesManualTreeTap addResin() {

	PoweredRecipe resin = new PoweredRecipe();

	resin.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.bucketEmpty.itemID, RecipeSlotType.INVENTORY, 1) };
	resin.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.bucketResin.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.5) };
	resin.workRequired = 2000;
	resin.powerRequired = 0;
	addRecipe(resin);
	return this;
    }
}
