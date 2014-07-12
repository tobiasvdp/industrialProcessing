package mod.industrialProcessing.plants.blackSmith.bloomery;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RecipesBloomery extends RecipesMultiblock {
	@Deprecated
	private Tiers tier;

	@Deprecated
	public Tiers getTier() {
		return tier;
	}

	RecipesBloomery() {
		addDefaultRecipes();
		addTier1Recipes();
	}

	private void addDefaultRecipes() {
		addRecipe(iron(750, 0, Tiers.Tier0));
		addRecipe(ironDust(150, 0, Tiers.Tier0));
		addRecipe(copper(500, 0, Tiers.Tier0));
		addRecipe(tin(450, 0, Tiers.Tier0));
	}

	private void addTier1Recipes() {
		addRecipe(iron3(1500, 0, Tiers.Tier1));
		addRecipe(ironDust3(300, 0, Tiers.Tier1));
		addRecipe(copper3(1000, 0, Tiers.Tier1));
		addRecipe(tin3(900, 0, Tiers.Tier1));
		addRecipe(pr4(500, 0, Tiers.Tier1));
		addRecipe(solderingAlloyIngot(500, 0, Tiers.Tier1));
		addRecipe(lead3(450, 0, Tiers.Tier1));
	}

	private RecipeMultiblock solderingAlloyIngot(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, IndustrialProcessing.blockGalenaOre, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockTinOre, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, IndustrialProcessing.blockTinOre, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemSolderAlloyIngot, 2, 2, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock pr4(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemLimestoneDust, 1), new RecipeInputInventorySlot(4, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, ISetupItems.itemSilicium, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemFiberGlass, 3, 3, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock lead3(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemLeadDust, 1), new RecipeInputInventorySlot(4, ISetupItems.itemLeadDust, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBowl, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemLeadBowl, 1, 1, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock tin3(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, IndustrialProcessing.blockTinOre, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockTinOre, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, IndustrialProcessing.blockTinOre, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinIngot, 3, 3, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock copper3(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, IndustrialProcessing.blockCopperOre, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockCopperOre, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, IndustrialProcessing.blockCopperOre, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemHeatedCopper, 4, 4, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock iron3(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Blocks.iron_ore, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, Blocks.iron_ore, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, Blocks.iron_ore, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, IndustrialProcessing.itemWroughtIron, 3, 3, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock ironDust3(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronOxideDust, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronOxideDust, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronOxideDust, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, Items.iron_ingot, 3, 3, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock lead(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemLeadDust, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemLeadIngot, 1, 1, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock tin(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, IndustrialProcessing.blockTinOre, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinIngot, 1, 1, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock copper(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, IndustrialProcessing.blockCopperOre, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemHeatedCopper, 1, 1, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock iron(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Blocks.iron_ore, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, IndustrialProcessing.itemWroughtIron, 1, 1, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

	private RecipeMultiblock ironDust(int workTime, int powerConsumption, Tiers tier) {
		PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronOxideDust, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, Items.iron_ingot, 1, 1, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		recipe.tier = tier;
		return recipe;
	}

}
