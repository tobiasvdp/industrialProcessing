package ip.industrialProcessing.multiblock.core.block.SolderingStation;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesSolderingStation extends RecipesMultiblock {
	public RecipesSolderingStation() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		//soldering
		addRecipe(something(3000,0,Tiers.Tier0));
	}
	
	private RecipeMultiblock something(int workTime, int power, Tiers tier) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemStripBoard.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(0, ISetupItems.itemRedstoneCircuitry.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, ISetupItems.itemCopperWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, ISetupItems.itemRedstoneCircuitry.itemID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(4, ISetupItems.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		recipe.tier = tier;
		return recipe;
	}
}
