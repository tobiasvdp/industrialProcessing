package mod.industrialProcessing.plants.blackSmith.waterBasin;

import org.apache.logging.log4j.core.pattern.NDCPatternConverter;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesWaterBasin extends RecipesMultiblock {

	public RecipesWaterBasin() {
		addDefaultRecipes();
	}
	
	private void addDefaultRecipes() {
		addRecipe(iron());
		addRecipe(lead());
		addRecipe(copper());
	}

	private RecipeMultiblock iron() {
		RecipeMultiblock recipe =  new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = 0;
		recipe.inputs = new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(IndustrialProcessing.itemPliersHeatedIron))};
		recipe.outputs = new RecipeOutputSlot[]{new RecipeOutputSlot(1,  new ItemStack(Items.iron_ingot)),new RecipeOutputSlot(2,  new ItemStack(IndustrialProcessing.itemPliers))};
		return recipe;
	}
	private RecipeMultiblock lead() {
		RecipeMultiblock recipe =  new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = 0;
		recipe.inputs = new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(IndustrialProcessing.itemLeadBowl))};
		recipe.outputs = new RecipeOutputSlot[]{new RecipeOutputSlot(1,  new ItemStack(IndustrialProcessing.itemLeadIngot,2)),new RecipeOutputSlot(2,  new ItemStack(IndustrialProcessing.itemIronBowl))};
		return recipe;
	}
	private RecipeMultiblock copper() {
		RecipeMultiblock recipe =  new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = 0;
		recipe.inputs = new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(IndustrialProcessing.itemPliersHeatedCopper))};
		recipe.outputs = new RecipeOutputSlot[]{new RecipeOutputSlot(1,  new ItemStack(IndustrialProcessing.itemCopperIngot)),new RecipeOutputSlot(2,  new ItemStack(IndustrialProcessing.itemPliers))};
		return recipe;
	}
	
}
