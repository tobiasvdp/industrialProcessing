package mod.industrialProcessing.plants.blackSmith.waterBasin;

import org.apache.logging.log4j.core.pattern.NDCPatternConverter;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
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
		recipe.inputs = new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemPliersHeatedIron))};
		recipe.outputs = new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1,  new ItemStack(Items.iron_ingot)),new RecipeOutputInventorySlot(2,  new ItemStack(IndustrialProcessing.itemPliers))};
		return recipe;
	}
	private RecipeMultiblock lead() {
		RecipeMultiblock recipe =  new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = 0;
		recipe.inputs = new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemLeadBowl))};
		recipe.outputs = new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1,  new ItemStack(IndustrialProcessing.itemLeadIngot,2)),new RecipeOutputInventorySlot(2,  new ItemStack(IndustrialProcessing.itemIronBowl))};
		return recipe;
	}
	private RecipeMultiblock copper() {
		RecipeMultiblock recipe =  new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = 0;
		recipe.inputs = new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemPliersHeatedCopper))};
		recipe.outputs = new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1,  new ItemStack(IndustrialProcessing.itemCopperIngot)),new RecipeOutputInventorySlot(2,  new ItemStack(IndustrialProcessing.itemPliers))};
		return recipe;
	}
	
}
