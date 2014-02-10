package ip.industrialProcessing.subMod.blackSmith.plant.waterBasin;

import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesWaterBasin extends RecipesMultiblock {

	public RecipesWaterBasin() {
		addDefaultRecipes();
	}
	
	private void addDefaultRecipes() {
		addRecipe(something());
	}

	private RecipeMultiblock something() {
		RecipeMultiblock recipe =  new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = 0;
		recipe.inputs = new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(Item.axeIron))};
		recipe.outputs = new RecipeOutputSlot[]{new RecipeOutputSlot(1,  new ItemStack(Item.axeDiamond))};
		return recipe;
	}
	
}
