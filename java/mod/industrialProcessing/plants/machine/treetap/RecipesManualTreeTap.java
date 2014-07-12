package mod.industrialProcessing.plants.machine.treetap;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RecipesManualTreeTap extends RecipesMachine {
    public RecipesManualTreeTap() {
    }

    public RecipesManualTreeTap addLatex() {

	PoweredRecipe latex = new PoweredRecipe();

	latex.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Items.bucket, 1) };
	latex.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupFluids.fluidLatex.getBucket(), 1, 1, 0.5) };
	latex.workRequired = 2000;
	latex.powerRequired = 0;
	addRecipe(latex);
	return this;
    }

    public RecipesManualTreeTap addResin() {

	PoweredRecipe resin = new PoweredRecipe();

	resin.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Items.bucket, 1) };
	resin.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupFluids.fluidResin.getBucket(), 1, 1, 0.5) };
	resin.workRequired = 2000;
	resin.powerRequired = 0;
	addRecipe(resin);
	return this;
    }
}
