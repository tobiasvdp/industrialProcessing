package mod.industrialProcessing.plants.construction.solderingStation;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public class RecipesSolderingStation extends RecipesMultiblock {
    public RecipesSolderingStation() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	// soldering
	addRecipe(something(3000, 0, Tiers.Tier0));
    }

    private RecipeMultiblock something(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(3, ISetupItems.itemStripBoard, 1), new RecipeInputInventorySlot(0, ISetupItems.itemRedstoneCircuitry, 1), new RecipeInputInventorySlot(1, ISetupItems.itemCopperWire, 1), new RecipeInputInventorySlot(2, ISetupItems.itemRedstoneCircuitry, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(4, ISetupItems.itemStripBoardWired, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }
}
