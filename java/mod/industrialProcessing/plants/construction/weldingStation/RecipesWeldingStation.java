package mod.industrialProcessing.plants.construction.weldingStation;

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
	addRecipe(multipoleRotor(3000, 0, Tiers.Tier0));
	addRecipe(crushingPlate(3000, 0, Tiers.Tier0));
	addRecipe(mixingHook(3000, 0, Tiers.Tier0));
	addRecipe(copperBoard(3000, 0, Tiers.Tier0));
	addRecipe(lamp(2000, 0, Tiers.Tier0));
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

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronPlate, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockPlatform, 6, 6, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock platformStairs(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(2, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(6, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(7, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(8, IndustrialProcessing.blockPlatform, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockStairs, 4, 4, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock turbineBlades(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBlade, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronBlade, 1),
		new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemTurbineBlades, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock turbine(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(3, ISetupItems.itemTurbineBlades, 1), new RecipeInputInventorySlot(4, ISetupItems.itemTurbineBlades, 1), new RecipeInputInventorySlot(5, ISetupItems.itemTurbineBlades, 1), new RecipeInputInventorySlot(6, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(8, IndustrialProcessing.blockWire, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockTurbine, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock solidBurner(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(7, Blocks.furnace, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(0, ISetupItems.itemHeatingElement, 1), new RecipeInputInventorySlot(1, ISetupItems.itemHeatingElement, 1), new RecipeInputInventorySlot(2, ISetupItems.itemHeatingElement, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockSolidBurner, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock boiler(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockTank, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(6, ISetupItems.itemHeatingElement, 1), new RecipeInputInventorySlot(7, ISetupItems.itemHeatingElement, 1), new RecipeInputInventorySlot(8, ISetupItems.itemHeatingElement, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockBoiler, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock tank(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(7, Blocks.glass_pane, RecipeSlotType.INVENTORY, 1),
		new RecipeInputInventorySlot(8, ISetupItems.itemIronPlate, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockTank, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock rainTank(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(7, IndustrialProcessing.blockTransportFluids, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronBar, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockRainTank, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock fluidpipe(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemLeadIngot, 1), new RecipeInputInventorySlot(2, ISetupItems.itemLeadIngot, 1), new RecipeInputInventorySlot(3, ISetupItems.itemLeadIngot, 1), new RecipeInputInventorySlot(5, ISetupItems.itemLeadIngot, 1), new RecipeInputInventorySlot(6, ISetupItems.itemLeadIngot, 1), new RecipeInputInventorySlot(8, ISetupItems.itemLeadIngot, 1), new RecipeInputInventorySlot(1, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(4, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(7, Blocks.glass, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockTransportFluids, 6, 6, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock heatingElement(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(3, ISetupItems.itemCopperWireInsulated, 1), new RecipeInputInventorySlot(4, ISetupItems.itemCopperWireInsulated, 1), new RecipeInputInventorySlot(5, ISetupItems.itemCopperWireInsulated, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronBar, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemHeatingElement, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock containerCore(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronPlate, 1),
		new RecipeInputInventorySlot(4, Blocks.chest, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockContainer, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock container(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronPlate, 1),
		new RecipeInputInventorySlot(4, Items.dye, 1, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockContainerWall, 8, 8, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock smallEngine(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(5, ISetupItems.itemCarbonBrush, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(3, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(1, ISetupItems.itemCopperCoil, 1), new RecipeInputInventorySlot(7, ISetupItems.itemCopperCoil, 1), new RecipeInputInventorySlot(0, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronPlate, 1),
		new RecipeInputInventorySlot(8, ISetupItems.itemIronPlate, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemSmallEngine, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock solder(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(1, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(2, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(3, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(5, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(6, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(7, ISetupItems.itemSolderAlloyWire, 1), new RecipeInputInventorySlot(8, ISetupItems.itemSolderAlloyWire, 1),
		new RecipeInputInventorySlot(4, ISetupItems.itemSolderEmpty, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemSolder, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock lamp(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Items.iron_ingot, 1), new RecipeInputInventorySlot(1, Items.iron_ingot, 1), new RecipeInputInventorySlot(2, Items.iron_ingot, 1), new RecipeInputInventorySlot(3, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, Blocks.glass, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(6, Items.iron_ingot, 1), new RecipeInputInventorySlot(7, Items.iron_ingot, 1), new RecipeInputInventorySlot(8, Items.iron_ingot, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockPetrolLamp, 3, 3, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock copperBoard(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemCopperPlate, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIsolationBoard, 1), new RecipeInputInventorySlot(7, ISetupItems.itemCopperPlate, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemCopperBoard, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock filterTray(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(4, Items.leather, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBar, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemFilterTray, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock mixingHook(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemMixingHook, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock frame(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemFrame, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }


    private RecipeMultiblock crushingPlate(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronTips, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronTips, 1),
		new RecipeInputInventorySlot(4, ISetupItems.itemIronPlate, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemCrusingPlate, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock multipoleRotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(1, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(2, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(3, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(5, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(6, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(7, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(8, ISetupItems.itemElectroMagnet, 1),
		new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1), };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemMotorPoleAxis, 3, 3, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock manualTreeTap(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemIronBracket, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronBowl, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockManualTreeTap, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock slipRing(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemCarbonBrush, 1), new RecipeInputInventorySlot(3, ISetupItems.itemCarbonBrush, 1), new RecipeInputInventorySlot(4, Items.iron_ingot, 1), new RecipeInputInventorySlot(5, ISetupItems.itemCarbonBrush, 1), new RecipeInputInventorySlot(7, ISetupItems.itemCarbonBrush, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemSlipRing, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock motorRotor(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemElectroMagnet, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemSlipRing, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemMotorRotor, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock motorStator(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemCopperCoil, 1), new RecipeInputInventorySlot(3, ISetupItems.itemCopperCoil, 1), new RecipeInputInventorySlot(5, ISetupItems.itemCopperCoil, 1), new RecipeInputInventorySlot(7, ISetupItems.itemCopperCoil, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemMotorStator, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironT(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronBar, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemIronT, 2, 2, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironFrame(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronT, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronT, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronT, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronT, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockFrame, 2, 2, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironBracket(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(6, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(8, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronPlate, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemIronBracket, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock drawPlate(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronPlate, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, ISetupItems.itemDrawPlate, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }

    private RecipeMultiblock ironMachineBlock(int workTime, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Items.dye, 14, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(2, Items.dye, 14, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(1, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockFrame, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(7, ISetupItems.itemIronPlate, 1),
		new RecipeInputInventorySlot(8, ISetupItems.itemIronBar, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockMachineBlock, 1, 1, 0) };

	recipe.workRequired = workTime;
	recipe.powerRequired = power;
	recipe.tier = tier;
	return recipe;
    }
}
