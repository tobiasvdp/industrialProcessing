package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesWeldingStation extends RecipesMachine {
	public RecipesWeldingStation() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(motorStator(3000,0));
		addRecipe(ironT(3000,0));
		addRecipe(ironFrame(3000,0));
		addRecipe(ironBar(3000,0));
		addRecipe(ironPlate(3000,0));
		addRecipe(ironMachineBlock(3000, 0));
		addRecipe(motorRotor(3000,0));
		addRecipe(slipRing(3000,0));
		addRecipe(ironBowl(3000,0));
		addRecipe(ironBracket(3000,0));
		addRecipe(manualTreeTap(3000,0));
		addRecipe(drawPlate(3000,0));
		
	}
	private Recipe manualTreeTap(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemIronBracket.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronBowl.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockManualTreetap.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe slipRing(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemSlipRing.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe motorRotor(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemSlipRing.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemMotorRotor.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe motorStator(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemMotorStator.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironT(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemIronT.itemID, RecipeSlotType.INVENTORY, 2, 2, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironFrame(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronT.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, IndustrialProcessing.itemIronT.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemIronT.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemIronT.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.BLmultiblockFrame.blockID, RecipeSlotType.INVENTORY, 2, 2, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironBracket(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(6, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemIronBracket.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe drawPlate(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemDrawPlate.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironBowl(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemIronBowl.itemID, RecipeSlotType.INVENTORY, 3, 3, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironBar(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(2, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 8, 8, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironPlate(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 4, 4, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe ironMachineBlock(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.BLmultiblockFrame.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
}
