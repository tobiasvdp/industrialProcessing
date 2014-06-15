package mod.industrialProcessing.plants.machine.treetap;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RecipesManualTreeTap extends RecipesMachine {
    public RecipesManualTreeTap() {
    }

    public RecipesManualTreeTap addLatex() {

	PoweredRecipe latex = new PoweredRecipe();

	latex.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Items.bucket, RecipeSlotType.INVENTORY, 1) };
	latex.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidLatex.getBucket(), RecipeSlotType.INVENTORY, 1, 1, 0.5) };
	latex.workRequired = 2000;
	latex.powerRequired = 0;
	addRecipe(latex);
	return this;
    }

    public RecipesManualTreeTap addResin() {

	PoweredRecipe resin = new PoweredRecipe();

	resin.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Items.bucket, RecipeSlotType.INVENTORY, 1) };
	resin.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidResin.getBucket(), RecipeSlotType.INVENTORY, 1, 1, 0.5) };
	resin.workRequired = 2000;
	resin.powerRequired = 0;
	addRecipe(resin);
	return this;
    }
}
