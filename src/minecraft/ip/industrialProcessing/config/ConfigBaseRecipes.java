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
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemWovenPatern), new ItemStack(Item.leather), new ItemStack(IndustrialProcessing.itemKnife,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemThickStick), new ItemStack(Item.stick), new ItemStack(Item.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemScreen), new ItemStack(IndustrialProcessing.itemWovenPatern), new ItemStack(IndustrialProcessing.itemFrame));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemPestle), new ItemStack(IndustrialProcessing.itemThickStick), new ItemStack(IndustrialProcessing.itemKnife,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemCoalDust), new ItemStack(Item.coal), new ItemStack(IndustrialProcessing.itemIronBowl,1,WILDCARD_VALUE),new ItemStack(IndustrialProcessing.itemPestle,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemElectroMagnet), new ItemStack(IndustrialProcessing.itemIronBar), new ItemStack(IndustrialProcessing.itemCopperCoil));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemCopperCoil), new ItemStack(IndustrialProcessing.itemThickStick), new ItemStack(IndustrialProcessing.itemCopperWireInsulated));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemCopperWireInsulated), new ItemStack(IndustrialProcessing.bucketFluidLatex,1,WILDCARD_VALUE), new ItemStack(IndustrialProcessing.itemCopperWire));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemCopperWire), new ItemStack(IndustrialProcessing.itemCopperIngot), new ItemStack(IndustrialProcessing.itemDrawPlate,1,WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemActiveCoal), new ItemStack(IndustrialProcessing.itemCoalDust), new ItemStack(IndustrialProcessing.itemGrownCulture));
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemHammer), "   ", " y ", "x  ", 'x',new ItemStack(IndustrialProcessing.itemThickStick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemKnife), "  y", " y ", "x  ", 'x',new ItemStack(IndustrialProcessing.itemThickStick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemBlowingTorch), "   ", " y ", "x  ", 'x',new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.flintAndSteel));
		
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemCrankWheel), "  x", "xxx", "x  ", 'x',new ItemStack(IndustrialProcessing.itemThickStick));
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemCarbonBrush,8), "xxx", "xyx", "xxx", 'x',new ItemStack(IndustrialProcessing.itemCoalDust),'y',new ItemStack(IndustrialProcessing.bucketFluidLatex,1,WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.BLmultiblockScreen),"xxx","x x"," y ",'x',new ItemStack(Item.ingotIron),'y',new ItemStack(IndustrialProcessing.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.BLmultiblockWeldingStation),"xxx","yzy","iji",'x',new ItemStack(Block.stoneSingleSlab),'y',new ItemStack(Block.planks,1,WILDCARD_VALUE),'z',new ItemStack(Block.workbench),'i',new ItemStack(IndustrialProcessing.itemThickStick),'j',new ItemStack(IndustrialProcessing.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.BLmultiblockWeldingTableExt),"xxx","yzy","iji",'x',new ItemStack(Block.stoneSingleSlab),'y',new ItemStack(Block.planks,1,WILDCARD_VALUE),'z',new ItemStack(Block.chest),'i',new ItemStack(Item.stick),'j',new ItemStack(IndustrialProcessing.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addSmelting(IndustrialProcessing.blockCopperOre.blockID, new ItemStack(IndustrialProcessing.itemCopperIngot), 0);
		GameRegistry.addSmelting(IndustrialProcessing.blockTinOre.blockID, new ItemStack(IndustrialProcessing.itemTinIngot), 0);
		GameRegistry.addSmelting(IndustrialProcessing.blockGalenaOre.blockID, new ItemStack(IndustrialProcessing.itemSilverIngot), 0);
		GameRegistry.addSmelting(IndustrialProcessing.itemCopperMineral.itemID, new ItemStack(IndustrialProcessing.itemCopperIngot), 0);
		GameRegistry.addSmelting(IndustrialProcessing.itemTinOxideDust.itemID, new ItemStack(IndustrialProcessing.itemTinIngot), 0);
		GameRegistry.addSmelting(IndustrialProcessing.itemSilverDust.itemID, new ItemStack(IndustrialProcessing.itemSilverIngot), 0);
	}

	private static ConfigBaseRecipes instance = new ConfigBaseRecipes();

	public static ConfigBaseRecipes getInstance() {
		return instance;
	}
}
