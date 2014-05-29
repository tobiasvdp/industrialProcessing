package ip.industrialProcessing.multiblock.core.block.weldingStation;

import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.recipes.PoweredRecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RecipesWeldingStation extends RecipesMultiblock {
    public RecipesWeldingStation() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	// welding
	addRecipe(rainTank(3000, 0, Tiers.Tier0));
	addRecipe(fluidpipe(3000, 0, Tiers.Tier0));
	addRecipe(container(3000, 0, Tiers.Tier0));
	addRecipe(containerCore(3000, 0, Tiers.Tier0));
	addRecipe(heatingElement(3000, 0, Tiers.Tier0));
	addRecipe(dryer(3000, 0, Tiers.Tier0));
	addRecipe(filter(3000, 0, Tiers.Tier0));
	addRecipe(filterTray(3000, 0, Tiers.Tier0));
	addRecipe(motorStator(3000, 0, Tiers.Tier0));
	addRecipe(ironT(3000, 0, Tiers.Tier0));
	addRecipe(ironFrame(3000, 0, Tiers.Tier0));
	addRecipe(ironMachineBlock(3000, 0, Tiers.Tier0));
	addRecipe(motorRotor(3000, 0, Tiers.Tier0));
	addRecipe(slipRing(3000, 0, Tiers.Tier0));
	addRecipe(ironBracket(3000, 0, Tiers.Tier0));
	addRecipe(manualTreeTap(3000, 0, Tiers.Tier0));
	addRecipe(drawPlate(3000, 0, Tiers.Tier0));
	addRecipe(electroMotor(3000, 0, Tiers.Tier0));
	addRecipe(multipoleRotor(3000, 0, Tiers.Tier0));
	addRecipe(generator(3000, 0, Tiers.Tier0));
	addRecipe(crankGenerator(3000, 0, Tiers.Tier0));
	addRecipe(crushingPlate(3000, 0, Tiers.Tier0));
	addRecipe(crusher(3000, 0, Tiers.Tier0));
	addRecipe(mixer(3000, 0, Tiers.Tier0));
	addRecipe(mixingHook(3000, 0, Tiers.Tier0));
	addRecipe(copperBoard(3000, 0, Tiers.Tier0));
	addRecipe(lamp(2000, 0, Tiers.Tier0));
	addRecipe(solder(4000, 0, Tiers.Tier0));
	addRecipe(smallEngine(3000, 0, Tiers.Tier0));
	addRecipe(tank(3000, 0, Tiers.Tier0));
	addRecipe(boiler(3000, 0, Tiers.Tier0));
	addRecipe(solidBurner(3000, 0, Tiers.Tier0));
	addRecipe(turbineBlades(3000, 0, Tiers.Tier0));
	addRecipe(turbine(3000, 0, Tiers.Tier0));
	addRecipe(platform(3000, 0, Tiers.Tier0));
	addRecipe(platformStairs(3000, 0, Tiers.Tier0));
    }

    private RecipeMultiblock platform(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 6, 6, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock platformStairs(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(2, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupBlocks.blockPlatform.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupBlocks.blockStairs.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock turbineBlades(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemTurbineBlades.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock turbine(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemTurbineBlades.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemTurbineBlades.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemTurbineBlades.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupMachineBlocks.blockTransportFluids.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupMachineBlocks.blockWire.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockTurbine.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock solidBurner(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, Block.furnaceIdle.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockSolidBurner.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock boiler(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupMachineBlocks.blockTransportFluids.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupMachineBlocks.blockTank.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockBoiler.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock tank(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupMachineBlocks.blockTransportFluids.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, Block.thinGlass.blockID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockTank.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock rainTank(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupMachineBlocks.blockTransportFluids.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockRainTank.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock fluidpipe(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemLeadIngot.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, Block.glass.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, Block.glass.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, Block.glass.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockTransportFluids.blockID, RecipeSlotType.INVENTORY, 6, 6, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock heatingElement(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock containerCore(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, Block.chest.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockContainer.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock container(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, Item.dyePowder.itemID, 1, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockContainerWall.blockID, RecipeSlotType.INVENTORY, 8, 8, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock dryer(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemHeatingElement.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockDryer.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock smallEngine(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(5, ISetupItems.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemSmallEngine.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock solder(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemSolderAlloyWire.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemSolderEmpty.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemSolder.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock lamp(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, Block.glass.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, Block.glass.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockPetrolLamp.blockID, RecipeSlotType.INVENTORY, 3, 3, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock copperBoard(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCopperPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIsolationBoard.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCopperPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemCopperBoard.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock filterTray(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, Item.leather.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemFilterTray.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock filter(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemFilterTray.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemFilterTray.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemSmallEngine.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockFilter.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock mixer(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemSmallEngine.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemMixingHook.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockMixer.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock mixingHook(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMixingHook.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock frame(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemFrame.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock crusher(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemSmallEngine.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemStripBoardWired.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockCrusher.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock crushingPlate(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronTips.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemCrusingPlate.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock crankGenerator(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCrankWheel.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupMachineBlocks.blockGenerator.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockManualGenerator.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock generator(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemMotorPoleAxis.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupMachineBlocks.blockElectroMotor.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockGenerator.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock multipoleRotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMotorPoleAxis.itemID, RecipeSlotType.INVENTORY, 3, 3, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock manualTreeTap(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBracket.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBowl.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockManualTreetap.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock slipRing(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCarbonBrush.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemSlipRing.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock electroMotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemMotorStator.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemMotorRotor.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.blockElectroMotor.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock motorRotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemElectroMagnet.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemSlipRing.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMotorRotor.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock motorStator(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMotorStator.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironT(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemIronT.itemID, RecipeSlotType.INVENTORY, 2, 2, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironFrame(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronT.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronT.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronT.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronT.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupMachineBlocks.BLmultiblockFrame.blockID, RecipeSlotType.INVENTORY, 2, 2, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironBracket(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(6, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemIronBracket.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock drawPlate(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemDrawPlate.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironMachineBlock(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.dyePowder.itemID, 14, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, Item.dyePowder.itemID, 14, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupMachineBlocks.BLmultiblockFrame.blockID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate.itemID, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupBlocks.blockMachineBlock.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }
}
