package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.block.Block;
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
		//welding
		addRecipe(motorStator(3000,0));
		addRecipe(ironT(3000,0));
		addRecipe(ironFrame(3000,0));
		addRecipe(ironMachineBlock(3000, 0));
		addRecipe(motorRotor(3000,0));
		addRecipe(slipRing(3000,0));
		addRecipe(ironBracket(3000,0));
		addRecipe(manualTreeTap(3000,0));
		addRecipe(drawPlate(3000,0));
		addRecipe(electroMotor(3000,0));
		addRecipe(multipoleRotor(3000,0));
		addRecipe(generator(3000,0));
		addRecipe(crankGenerator(3000,0));
		addRecipe(crushingPlate(3000,0));
		addRecipe(crusher(3000,0));
		addRecipe(frame(3000,0));
		addRecipe(mixer(3000,0));
		addRecipe(copperBoard(3000,0));
		addRecipe(lamp(2000,0));
		addRecipe(solder(4000,0));
		
		//soldering
		addRecipe(something(3000,0));
		
	}
	private Recipe something(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(15, IndustrialProcessing.itemStripBoard.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(16, IndustrialProcessing.itemRedstoneCircuitry.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(17, IndustrialProcessing.itemCopperWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(18, IndustrialProcessing.itemRedstoneCircuitry.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(19, IndustrialProcessing.itemSolder.itemID, RecipeSlotType.DAMAGEDITEM, 1),new RecipeInputSlot(20, IndustrialProcessing.itemSolderingIron.itemID, RecipeSlotType.DAMAGEDITEM, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(21, IndustrialProcessing.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}

	private Recipe solder(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemSolderEmpty.itemID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemSolder.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe lamp(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, Block.glass.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, Block.glass.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockPetrolLamp.blockID, RecipeSlotType.INVENTORY, 3, 3, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe copperBoard(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemCopperPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIsolationBoard.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemCopperPlate.itemID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemCopperBoard.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}

	private Recipe mixer(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(6, IndustrialProcessing.itemScreen.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemScreen.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemScreen.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockMixer.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe frame(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemFrame.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe crusher(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, IndustrialProcessing.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockCrusher.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe crushingPlate(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe crankGenerator(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemCrankWheel.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockGenerator.blockID, RecipeSlotType.INVENTORY, 1)};
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockManualGenerator.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe generator(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, IndustrialProcessing.itemMotorPoleAxis.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.blockElectroMotor.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(0, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockGenerator.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
	private Recipe multipoleRotor(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemMotorPoleAxis.itemID, RecipeSlotType.INVENTORY, 3, 3, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
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
	private Recipe electroMotor(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, IndustrialProcessing.itemMotorStator.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemMotorRotor.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockElectroMotor.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
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
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY,1),new RecipeInputSlot(5, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1) };
		
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
	private Recipe ironMachineBlock(int workTime, int power) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.dyePowder.itemID,14, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(2, Item.dyePowder.itemID,14, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(3, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.BLmultiblockFrame.blockID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(6, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(7, IndustrialProcessing.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(8, IndustrialProcessing.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
}
