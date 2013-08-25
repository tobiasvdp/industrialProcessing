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
		GameRegistry.addShapelessRecipe(new ItemStack(IndustrialProcessing.itemThickStick), new ItemStack(Item.stick), new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemHammer), "   ", " y ", "x  ", 'x',new ItemStack(IndustrialProcessing.itemThickStick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockMultiblockWeldingStationScreen),"xxx","x x"," y ",'x',new ItemStack(Item.ingotIron),'y',new ItemStack(IndustrialProcessing.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addRecipe(new ItemStack(IndustrialProcessing.itemBlowingTorch), "   ", " y ", "x  ", 'x',new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.flintAndSteel));
		
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockMultiblockWeldingStation),"xxx","yzy","iji",'x',new ItemStack(Block.stoneSingleSlab),'y',new ItemStack(Block.planks),'z',new ItemStack(Block.workbench),'i',new ItemStack(IndustrialProcessing.itemThickStick),'j',new ItemStack(IndustrialProcessing.itemHammer,1,WILDCARD_VALUE) );
		GameRegistry.addShapedRecipe(new ItemStack(IndustrialProcessing.blockMultiblockWeldingStationRight),"xxx","yzy","iji",'x',new ItemStack(Block.stoneSingleSlab),'y',new ItemStack(Block.planks),'z',new ItemStack(Block.chest),'i',new ItemStack(Item.stick),'j',new ItemStack(IndustrialProcessing.itemHammer,1,WILDCARD_VALUE) );
	}

	private static ConfigBaseRecipes instance = new ConfigBaseRecipes();

	public static ConfigBaseRecipes getInstance() {
		return instance;
	}
}
