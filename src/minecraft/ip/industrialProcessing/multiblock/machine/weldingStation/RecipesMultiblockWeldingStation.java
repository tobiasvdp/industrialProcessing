package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMultiblockWeldingStation extends RecipesMachine {
	public RecipesMultiblockWeldingStation() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(blowingTorch(1000, 0));
		addRecipe(hammer(1000, 0));
		addRecipe(smallMachineCasing(8000, 1000));
		addRecipe(ironTips(5000,0));
		addRecipe(ironPlates(8000,0));
		addRecipe(ironCrushingPlate(10000, 5000));
		addRecipe(smallMachineCasingCrusher(10000,5000));
		addRecipe(Crusher(50000,20000));
	}

	private Recipe blowingTorch(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(8, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, Item.flintAndSteel.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemBlowingTorch.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}

	private Recipe hammer(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(8, IndustrialProcessing.itemThickStick.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemHammer.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}

	private Recipe smallMachineCasing(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(13, IndustrialProcessing.itemBlowingTorch.itemID, RecipeSlotType.DAMAGEDITEM, 1), new RecipeInputSlot(2, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(9, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(10, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, Item.dyePowder.itemID,14, RecipeSlotType.INVENTORY, 1), };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemSmallMachineCasing.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}
	
	private Recipe ironTips(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(12, IndustrialProcessing.itemHammer.itemID, RecipeSlotType.DAMAGEDITEM, 1), 
				new RecipeInputSlot(2,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(4,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(6,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(8,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(10,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), 
		};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 32, 32, 0) };

		return recipe;
	}
	
	private Recipe ironPlates(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(12, IndustrialProcessing.itemHammer.itemID, RecipeSlotType.DAMAGEDITEM, 1), 
				new RecipeInputSlot(2,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(3,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(5,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(6,Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),
		};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 2, 2, 0) };

		return recipe;
	}
	
	private Recipe ironCrushingPlate(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(13, IndustrialProcessing.itemBlowingTorch.itemID, RecipeSlotType.DAMAGEDITEM, 1), 
				new RecipeInputSlot(2,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(3,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(4,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(5,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(6,IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(7,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(8,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(9,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
				new RecipeInputSlot(10,IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 2),
		};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}
	private Recipe smallMachineCasingCrusher(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(12, IndustrialProcessing.itemHammer.itemID, RecipeSlotType.DAMAGEDITEM, 1), 
				new RecipeInputSlot(5,IndustrialProcessing.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(6,IndustrialProcessing.itemSmallMachineCasing.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(7,IndustrialProcessing.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1),
		};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.itemSmallMachineCasingCrusher.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}
	private Recipe Crusher(int workTime, int powerUsage) {
		Recipe recipe = new Recipe();

		recipe.workRequired = workTime;
		recipe.powerRequired = powerUsage;
		recipe.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(13, IndustrialProcessing.itemBlowingTorch.itemID, RecipeSlotType.DAMAGEDITEM, 1), 
				new RecipeInputSlot(3,IndustrialProcessing.itemInputPort.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(6,IndustrialProcessing.itemSmallMachineCasingCrusher.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(7,IndustrialProcessing.itemPowerPort.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(8,IndustrialProcessing.itemSupportBars.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(9,IndustrialProcessing.itemOutputPort.itemID, RecipeSlotType.INVENTORY, 1),
				new RecipeInputSlot(10,IndustrialProcessing.itemSupportBars.itemID, RecipeSlotType.INVENTORY, 1),
		};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(11, IndustrialProcessing.blockCrusher.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}
}
