package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesBloomery extends RecipesMultiblock {
	@Deprecated
	private Tiers tier;

	@Deprecated
	public Tiers getTier() {
		return tier;
	}
	
	RecipesBloomery(){
		addDefaultRecipes();
		addTier1Recipes();
	}
	
	@Deprecated
	public RecipesBloomery(Tiers tier) {
		if (tier == Tiers.Tier0)
			addDefaultRecipes();
		if (tier == Tiers.Tier1)
			addTier1Recipes();
		if(tier == Tiers.all){
			addDefaultRecipes();
			addTier1Recipes();
		}	
		this.tier = tier;
	}

	private void addDefaultRecipes() {
		addRecipe(iron(750,0,Tiers.Tier0));
		addRecipe(copper(500,0,Tiers.Tier0));
		addRecipe(tin(450,0,Tiers.Tier0));
		addRecipe(lead(450,0,Tiers.Tier0));
	}
	private void addTier1Recipes() {
		addRecipe(iron3(1500,0,Tiers.Tier1));
		addRecipe(copper3(1000,0,Tiers.Tier1));
		addRecipe(tin3(900,0,Tiers.Tier1));
		addRecipe(pr4(500,0,Tiers.Tier1));
		addRecipe(solderingAlloyIngot(500,0,Tiers.Tier1));
		addRecipe(lead3(450,0,Tiers.Tier1));
	}

    private RecipeMultiblock solderingAlloyIngot(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockGalenaOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemSolderAlloyIngot.itemID, RecipeSlotType.INVENTORY, 2, 2, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
	
    private RecipeMultiblock pr4(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemLimestoneDust.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, Block.glass.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemSilicium.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemFiberGlass.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }

    private RecipeMultiblock lead3(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemLeadDust.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemLeadDust.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemLeadDust.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
    
    private RecipeMultiblock tin3(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinIngot.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
	
    private RecipeMultiblock copper3(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperIngot.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
    
    private RecipeMultiblock iron3(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 3, 3, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }

    private RecipeMultiblock lead(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemLeadDust.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
    
    private RecipeMultiblock tin(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinIngot.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
    
    private RecipeMultiblock copper(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperIngot.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }
    
    private RecipeMultiblock iron(int workTime, int powerConsumption,Tiers tier) {
    	RecipeMultiblock recipe = new RecipeMultiblock();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        recipe.tier = tier;
        return recipe;
    }

}
