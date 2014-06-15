package mod.industrialProcessing.plants.construction.weldingStation;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
//	addRecipe(heatingElement(3000, 0, Tiers.Tier0));
//	addRecipe(dryer(3000, 0, Tiers.Tier0));
//	addRecipe(filter(3000, 0, Tiers.Tier0));
//	addRecipe(filterTray(3000, 0, Tiers.Tier0));
	addRecipe(motorStator(3000, 0, Tiers.Tier0));
	addRecipe(ironT(3000, 0, Tiers.Tier0));
	addRecipe(ironFrame(3000, 0, Tiers.Tier0));
	addRecipe(ironMachineBlock(3000, 0, Tiers.Tier0));
	addRecipe(motorRotor(3000, 0, Tiers.Tier0));
	addRecipe(slipRing(3000, 0, Tiers.Tier0));
	addRecipe(ironBracket(3000, 0, Tiers.Tier0));
	addRecipe(manualTreeTap(3000, 0, Tiers.Tier0));
	addRecipe(drawPlate(3000, 0, Tiers.Tier0));
//	addRecipe(electroMotor(3000, 0, Tiers.Tier0));
//	addRecipe(multipoleRotor(3000, 0, Tiers.Tier0));
//	addRecipe(generator(3000, 0, Tiers.Tier0));
	addRecipe(crushingPlate(3000, 0, Tiers.Tier0));
//	addRecipe(crusher(3000, 0, Tiers.Tier0));
//	addRecipe(mixer(3000, 0, Tiers.Tier0));
//	addRecipe(mixingHook(3000, 0, Tiers.Tier0));
	addRecipe(copperBoard(3000, 0, Tiers.Tier0));
//	addRecipe(lamp(2000, 0, Tiers.Tier0));
//	addRecipe(solder(4000, 0, Tiers.Tier0));
	addRecipe(smallEngine(3000, 0, Tiers.Tier0));
	addRecipe(tank(3000, 0, Tiers.Tier0));
//	addRecipe(boiler(3000, 0, Tiers.Tier0));
//	addRecipe(solidBurner(3000, 0, Tiers.Tier0));
//	addRecipe(turbineBlades(3000, 0, Tiers.Tier0));
//	addRecipe(turbine(3000, 0, Tiers.Tier0));
	addRecipe(platform(3000, 0, Tiers.Tier0));
	addRecipe(platformStairs(3000, 0, Tiers.Tier0));
    }

    private RecipeMultiblock platform(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 6, 6, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock platformStairs(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(2, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockStairs, RecipeSlotType.INVENTORY, 4, 4, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock turbineBlades(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBlade, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemTurbineBlades, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock turbine(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemTurbineBlades, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemTurbineBlades, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemTurbineBlades, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, IndustrialProcessing.blockWire, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockTurbine, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock solidBurner(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, Block.furnaceIdle, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockSolidBurner, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock boiler(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockTank, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockBoiler, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock tank(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, Blocks.glass_pane, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockTank, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock rainTank(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockRainTank, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock fluidpipe(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemLeadIngot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemLeadIngot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemLeadIngot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemLeadIngot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemLeadIngot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemLeadIngot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, Blocks.glass, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 6, 6, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock heatingElement(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemCopperWireInsulated, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemCopperWireInsulated, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCopperWireInsulated, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock containerCore(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, Blocks.chest, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockContainer, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock container(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, Items.dye, 1, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockContainerWall, RecipeSlotType.INVENTORY, 8, 8, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock dryer(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockDryer, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock smallEngine(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(5, ISetupItems.itemCarbonBrush, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemCopperCoil, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCopperCoil, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemSmallEngine, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock solder(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemSolderAlloyWire, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemSolderEmpty, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemSolder, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock lamp(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.ingotIron, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, Item.ingotIron, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, Item.ingotIron, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, Block.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, Block.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, Item.ingotIron, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, Item.ingotIron, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, Item.ingotIron, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockPetrolLamp, RecipeSlotType.INVENTORY, 3, 3, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock copperBoard(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCopperPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIsolationBoard, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCopperPlate, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemCopperBoard, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock filterTray(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, Item.leather, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemFilterTray, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock filter(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemFilterTray, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemFilterTray, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemSmallEngine, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockFilter, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock mixer(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemSmallEngine, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemMixingHook, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockMixer, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock mixingHook(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMixingHook, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock frame(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemFrame, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }


    private RecipeMultiblock crushingPlate(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronTips, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemCrusingPlate, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock multipoleRotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMotorPoleAxis, RecipeSlotType.INVENTORY, 3, 3, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock manualTreeTap(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBracket, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBowl, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockManualTreeTap, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock slipRing(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCarbonBrush, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemCarbonBrush, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, Items.iron_ingot, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCarbonBrush, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCarbonBrush, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemSlipRing, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock motorRotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemElectroMagnet, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemSlipRing, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMotorRotor, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock motorStator(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemCopperCoil, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemCopperCoil, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCopperCoil, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemCopperCoil, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemMotorStator, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironT(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemIronT, RecipeSlotType.INVENTORY, 2, 2, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironFrame(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronT, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronT, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronT, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronT, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockFrame, RecipeSlotType.INVENTORY, 2, 2, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironBracket(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemIronBracket, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock drawPlate(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, ISetupItems.itemDrawPlate, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironMachineBlock(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Items.dye, 14, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, Items.dye, 14, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockFrame, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }
}
