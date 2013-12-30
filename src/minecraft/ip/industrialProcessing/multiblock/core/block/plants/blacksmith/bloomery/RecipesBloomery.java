package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesBloomery extends RecipesMachine {
	private Tiers tier;

	public Tiers getTier() {
		return tier;
	}
	public RecipesBloomery(Tiers tier) {
		if (tier == Tiers.Tier0)
			addDefaultRecipes();
		if (tier == Tiers.Tier1)
			addTier1Recipes();
		this.tier = tier;
	}

	private void addDefaultRecipes() {
		addRecipe(iron(750,0));
		addRecipe(copper(500,0));
	}
	private void addTier1Recipes() {
		addRecipe(iron3(1500,0));
		addRecipe(copper3(1000,0));
		addRecipe(pr4(500,0));
	}

    private Recipe pr4(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemLimestoneDust.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, Block.glass.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemSilicium.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemFiberGlass.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
	
    private Recipe copper3(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperIngot.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
    
    private Recipe iron3(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe copper(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperIngot.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
    
    private Recipe iron(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

}
