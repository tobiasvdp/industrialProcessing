package ip.industrialProcessing.config;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.IndustrialProcessing;
import cpw.mods.fml.common.registry.GameRegistry;

public class ConfigBaseRecipes {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;

	public ConfigBaseRecipes() {
		// TODO Auto-generated constructor stub
	}

	public void addBaseRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemWovenPatern), new ItemStack(Item.leather), new ItemStack(ISetupItems.itemKnife,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemThickStick), new ItemStack(Item.stick), new ItemStack(Item.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemScreen), new ItemStack(ISetupItems.itemWovenPatern), new ItemStack(ISetupItems.itemFrame));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemPestle), new ItemStack(ISetupItems.itemThickStick), new ItemStack(ISetupItems.itemKnife,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCoalDust), new ItemStack(Item.coal), new ItemStack(ISetupItems.itemIronBowl,1,WILDCARD_VALUE),new ItemStack(ISetupItems.itemPestle,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemElectroMagnet), new ItemStack(ISetupItems.itemIronBar), new ItemStack(ISetupItems.itemCopperCoil));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCopperCoil), new ItemStack(ISetupItems.itemThickStick), new ItemStack(ISetupItems.itemCopperWireInsulated));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCopperWireInsulated), new ItemStack(ISetupFluids.bucketFluidLatex,1,WILDCARD_VALUE), new ItemStack(ISetupItems.itemCopperWire));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemCopperWire), new ItemStack(ISetupItems.itemCopperIngot), new ItemStack(ISetupItems.itemDrawPlate,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ISetupItems.itemActiveCoal), new ItemStack(ISetupItems.itemCoalDust), new ItemStack(ISetupItems.itemGrownCulture));
		GameRegistry.addRecipe(new ItemStack(ISetupItems.itemHammer), "   ", " y ", "x  ", 'x',new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ISetupItems.itemKnife), "  y", " y ", "x  ", 'x',new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ISetupItems.itemBlowingTorch), "   ", " y ", "x  ", 'x',new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.flintAndSteel));
		
		GameRegistry.addRecipe(new ItemStack(ISetupItems.itemCrankWheel), "  x", "xxx", "x  ", 'x',new ItemStack(ISetupItems.itemThickStick));
		GameRegistry.addRecipe(new ItemStack(ISetupItems.itemCarbonBrush,8), "xxx", "xyx", "xxx", 'x',new ItemStack(ISetupItems.itemCoalDust),'y',new ItemStack(ISetupFluids.bucketFluidLatex,1,WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(ISetupMachineBlocks.BLmultiblockScreen),"xxx","x x"," y ",'x',new ItemStack(Item.ingotIron),'y',new ItemStack(ISetupItems.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addShapedRecipe(new ItemStack(ISetupMachineBlocks.BLmultiblockWeldingStation),"xxx","yzy","iji",'x',new ItemStack(Block.stoneSingleSlab),'y',new ItemStack(Block.planks,1,WILDCARD_VALUE),'z',new ItemStack(Block.workbench),'i',new ItemStack(ISetupItems.itemThickStick),'j',new ItemStack(ISetupItems.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addShapedRecipe(new ItemStack(ISetupMachineBlocks.BLmultiblockWeldingTableExt),"xxx","yzy","iji",'x',new ItemStack(Block.stoneSingleSlab),'y',new ItemStack(Block.planks,1,WILDCARD_VALUE),'z',new ItemStack(Block.chest),'i',new ItemStack(Item.stick),'j',new ItemStack(ISetupItems.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addSmelting(ISetupBlocks.blockCopperOre.blockID, new ItemStack(ISetupItems.itemCopperIngot), 0);
		GameRegistry.addSmelting(ISetupBlocks.blockTinOre.blockID, new ItemStack(ISetupItems.itemTinIngot), 0);
		GameRegistry.addSmelting(ISetupBlocks.blockGalenaOre.blockID, new ItemStack(ISetupItems.itemSilverIngot), 0);
		GameRegistry.addSmelting(ISetupItems.itemCopperMineral.itemID, new ItemStack(ISetupItems.itemCopperIngot), 0);
		GameRegistry.addSmelting(ISetupItems.itemTinOxideDust.itemID, new ItemStack(ISetupItems.itemTinIngot), 0);
		GameRegistry.addSmelting(ISetupItems.itemSilverDust.itemID, new ItemStack(ISetupItems.itemSilverIngot), 0);
	}

	private static ConfigBaseRecipes instance = new ConfigBaseRecipes();

	public static ConfigBaseRecipes getInstance() {
		return instance;
	}
}
