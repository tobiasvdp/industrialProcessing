package mod.industrialProcessing.plants.construction.solderingStation;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;

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

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemStripBoard, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemRedstoneCircuitry, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemCopperWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemRedstoneCircuitry, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(4, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }
}
