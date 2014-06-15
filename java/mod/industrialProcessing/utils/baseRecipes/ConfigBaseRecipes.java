package mod.industrialProcessing.utils.baseRecipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.ConfigBlocks;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.utils.registry.BlockRegistry;
import mod.industrialProcessing.utils.registry.BlockType;
import mod.industrialProcessing.utils.registry.RecipeRegistry;
import mod.industrialProcessing.work.recipe.VanillaRecipeBridge;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ConfigBaseRecipes {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;

	public ConfigBaseRecipes() {

	}

	public void addBaseRecipes() {
		removeUnwantedRecipes();

		addShapelessRecipes();
		addShapedRecipes();
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.blockTorch, 4), new Object[] {"X", "#", 'X', Items.coal, '#', Items.stick});
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.blockTorch, 4), new Object[] {"X", "#", 'X', new ItemStack(Items.coal, 1, 1), '#', Items.stick});

		addSmeltingRecipes();

		//TODO: setPaneConnectors();

		BlockRegistry.RegisterBlock(Blocks.crafting_table, BlockType.Machine);
		RecipeRegistry.addVanillaRecipes(VanillaRecipeBridge.addVanillaRecipes());
		
	}

	private void addShapelessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemGuide), new ItemStack(Items.book), new ItemStack(Items.dye, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.blockTransportFluidsStone, 1, 3), new ItemStack(Blocks.stonebrick), new ItemStack(IndustrialProcessing.blockTransportFluids));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemWovenPatern), new ItemStack(Items.leather), new ItemStack(ISetupItems.itemKnife, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemThickStick), new ItemStack(Items.stick), new ItemStack(Items.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemScreen), new ItemStack(ISetupItems.itemWovenPatern), new ItemStack(ISetupItems.itemFrame));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemStripBoard), new ItemStack(ISetupItems.itemCopperBoard), new ItemStack(ISetupItems.itemKnife, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemPestle), new ItemStack(ISetupItems.itemThickStick), new ItemStack(ISetupItems.itemKnife, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCoalDust), new ItemStack(Items.coal), new ItemStack(ISetupItems.itemIronBowl, 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemPestle, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemHardenedSandDust), new ItemStack(ISetupBlocks.blockHardSand), new ItemStack(ISetupItems.itemIronBowl, 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemPestle, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemAluminumDust), new ItemStack(ISetupBlocks.blockBauxiteOre), new ItemStack(ISetupItems.itemIronBowl, 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemPestle, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemLeadDust), new ItemStack(ISetupBlocks.blockGalenaOre), new ItemStack(ISetupItems.itemIronBowl, 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemPestle, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemLimestoneDust), new ItemStack(ISetupBlocks.blockCobbleLimestone), new ItemStack(ISetupItems.itemIronBowl, 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemPestle, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemElectroMagnet), new ItemStack(ISetupItems.itemIronBar), new ItemStack(ISetupItems.itemCopperCoil));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCopperCoil), new ItemStack(ISetupItems.itemThickStick), new ItemStack(ISetupItems.itemCopperWireInsulated));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCopperWireInsulated), new ItemStack(ISetupFluids.fluidLatex.getBucket(), 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemCopperWire));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCopperWire,2), new ItemStack(ISetupItems.itemCopperIngot), new ItemStack(ISetupItems.itemDrawPlate, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemSolderAlloyWire,2), new ItemStack(ISetupItems.itemSolderAlloyIngot), new ItemStack(ISetupItems.itemDrawPlate, 1, WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemActiveCoal), new ItemStack(ISetupItems.itemCoalDust), new ItemStack(ISetupItems.itemGrownCulture));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemSandCast), new ItemStack(ISetupItems.itemCastingMulsh), new ItemStack(ISetupItems.itemFlask));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemnhardenedIsolationBoard), new ItemStack(ISetupFluids.fluidResin.getBucket()), new ItemStack(ISetupItems.itemFiberGlass));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemRedstoneCircuitry, 2), new ItemStack(Items.redstone), new ItemStack(Items.redstone), new ItemStack(Items.iron_ingot), new ItemStack(Items.leather));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.blockWire, 2), new ItemStack(Blocks.wool, 1, WILDCARD_VALUE), new ItemStack(ISetupItems.itemCopperBar));
	}

	private void addShapedRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemHammer), "   ", " y ", "x  ", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(Items.iron_ingot));
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemCastingMulsh, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.sand), 'y', new ItemStack(Items.clay_ball), 'z', new ItemStack(Items.water_bucket));
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemFlask), " x ", "x x", " x ", 'x', new ItemStack(Blocks.wooden_slab, 1, WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemSilicium, 8), "xxx", "xyx", "xxx", 'x', new ItemStack(ISetupItems.itemHardenedSandDust), 'y', new ItemStack(ISetupItems.itemAluminumDust));
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemSolderEmpty, 1), "xyx", " z ", "xyx", 'x', new ItemStack(Items.leather), 'y', new ItemStack(Blocks.planks, 1, WILDCARD_VALUE), 'z', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWire, 6), "xxx", "yyy", "   ", 'x', new ItemStack(Blocks.wool, 1, WILDCARD_VALUE), 'y', new ItemStack(ISetupItems.itemCopperBar));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWire, 6), "   ", "xxx", "yyy", 'x', new ItemStack(Blocks.wool, 1, WILDCARD_VALUE), 'y', new ItemStack(ISetupItems.itemCopperBar));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWire, 6), "yyy", "xxx", "   ", 'x', new ItemStack(Blocks.wool, 1, WILDCARD_VALUE), 'y', new ItemStack(ISetupItems.itemCopperBar));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWire, 6), "   ", "yyy", "xxx", 'x', new ItemStack(Blocks.wool, 1, WILDCARD_VALUE), 'y', new ItemStack(ISetupItems.itemCopperBar));
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemCrankWheel), "  x", "xxx", "x  ", 'x', new ItemStack(ISetupItems.itemThickStick));
		GameRegistry.addShapedRecipe(new ItemStack(ISetupItems.itemCarbonBrush, 8), "xxx", "xyx", "xxx", 'x', new ItemStack(ISetupItems.itemCoalDust), 'y', new ItemStack(ISetupFluids.fluidResin.getBucket(), 1, WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWeldingStation), "xxx", "yzy", "iji", 'x', new ItemStack(Blocks.stone_slab), 'y', new ItemStack(Blocks.planks, 1, WILDCARD_VALUE), 'z', new ItemStack(Blocks.crafting_table), 'i', new ItemStack(ISetupItems.itemThickStick), 'j', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWeldingTable), "xxx", "yzy", "iji", 'x', new ItemStack(Blocks.stone_slab), 'y', new ItemStack(Blocks.planks, 1, WILDCARD_VALUE), 'z', new ItemStack(Blocks.chest), 'i', new ItemStack(ISetupItems.itemThickStick), 'j', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockSolderingStation), "xxx", "yzy", "iji", 'x', new ItemStack(Blocks.stone_slab), 'y', new ItemStack(Blocks.planks, 1, WILDCARD_VALUE), 'z', new ItemStack(ISetupItems.itemSolderingIron), 'i', new ItemStack(ISetupItems.itemThickStick), 'j', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockGrindingStone), "x x", "xyx", "x x", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockAnvil), "zzz", " x ", "zyz", 'x', new ItemStack(Blocks.iron_block), 'y', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE), 'z', new ItemStack(Items.iron_ingot));
		
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockBloomery), "xyx", "y y", "xzx", 'x', new ItemStack(Items.clay_ball), 'y', new ItemStack(Blocks.dirt), 'z', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockBellows), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.log, 1, WILDCARD_VALUE), 'y', new ItemStack(Items.leather));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockIronBowl), "   ", "xyx", "   ", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(ISetupItems.itemIronBowl, 8));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockForge,4), "xyx", "y y", "xyx", 'x', new ItemStack(IndustrialProcessing.blockCobbleLimestone), 'y', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWaterBasin), "   ", "x x", "xxx", 'x', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.itemWoodenBucket), " y ", "x x", " x ", 'x', new ItemStack(Blocks.planks,1,WILDCARD_VALUE),'y',new ItemStack(Items.string));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.itemPliers), "x x", " x ", " x ", 'x', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWoodenBar), "  x", " x ", "x  ", 'x', new ItemStack(Blocks.planks,1,WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWoodenHammer), "xxx", " y ", "xxx", 'x', new ItemStack(Blocks.planks,1,WILDCARD_VALUE), 'y', new ItemStack(IndustrialProcessing.blockWoodenBar));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockWoodenWheel), "xzx", "xzz", " xx", 'x', new ItemStack(Blocks.planks,1,WILDCARD_VALUE),'z',new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockTripHammer), "zzz", "z z", "xxx", 'x', new ItemStack(Blocks.planks,1,WILDCARD_VALUE),'z',new ItemStack(Items.stick));
	}

	/*
	private void setPaneConnectors() {
		Block.opaqueCubeLookup[ConfigBlocks.getBlockHalfWavePlateID()] = true;
		Block.opaqueCubeLookup[Block.thinGlass.blockID] = true;
		Block.opaqueCubeLookup[ConfigMachineBlocks.getBlockGarageDoorID()] = true;
		Block.opaqueCubeLookup[Block.fenceIron.blockID] = true;
		Block.opaqueCubeLookup[ISetupBlocks.blockDoorEmergency.blockID] = true;
	}
	*/

	private void addSmeltingRecipes() {
		GameRegistry.addSmelting(ISetupBlocks.blockGalenaOre, new ItemStack(ISetupItems.itemSilverIngot), 0);
		GameRegistry.addSmelting(ISetupItems.itemCopperMineral, new ItemStack(ISetupItems.itemCopperIngot), 0);
		GameRegistry.addSmelting(ISetupItems.itemTinOxideDust, new ItemStack(ISetupItems.itemTinIngot), 0);
		GameRegistry.addSmelting(ISetupItems.itemSilverDust, new ItemStack(ISetupItems.itemSilverIngot), 0);
		GameRegistry.addSmelting(Blocks.sand, new ItemStack(ISetupBlocks.blockHardSand), 0);
		GameRegistry.addSmelting(ISetupBlocks.blockHardSand, new ItemStack(Blocks.glass), 0);
		GameRegistry.addSmelting(ISetupItems.itemnhardenedIsolationBoard, new ItemStack(ISetupItems.itemIsolationBoard), 0);
	}

	private void removeUnwantedRecipes() {
		Iterator recipes = CraftingManager.getInstance().getRecipeList().iterator();
		ArrayList<IRecipe> removal = new ArrayList<IRecipe>();
		while (recipes.hasNext()) {
			IRecipe recipe = (IRecipe) recipes.next();
			if (recipe.getRecipeOutput() != null && recipe.getRecipeOutput().getItem().equals(Items.iron_ingot)) {
				removal.add(recipe);
			} else if (recipe.getRecipeOutput() != null && recipe.getRecipeOutput().getItem().equals(Blocks.torch)) {
				removal.add(recipe);
			} else {
			}
		}
		for (IRecipe recipe : removal) {
			CraftingManager.getInstance().getRecipeList().remove(recipe);
		}
		recipes = FurnaceRecipes.smelting().getSmeltingList().entrySet().iterator();
		ArrayList<Object> removal2 = new ArrayList<Object>();
		while (recipes.hasNext()) {
			Map.Entry pairs = (Map.Entry) recipes.next();
			if (pairs.getValue() != null) {
				ItemStack stack = (ItemStack) pairs.getValue();
				if (stack.getItem().equals(Items.iron_ingot)) {
					removal2.add(pairs.getKey());
				} else if (stack.getItem().equals(Blocks.sand)) {
					removal2.add(pairs.getKey());
				}
			}
		}
		for (Object recipe : removal2) {
			FurnaceRecipes.smelting().getSmeltingList().remove(recipe);
		}

	}

	private static ConfigBaseRecipes instance = new ConfigBaseRecipes();

	public static ConfigBaseRecipes getInstance() {
		return instance;
	}
}
