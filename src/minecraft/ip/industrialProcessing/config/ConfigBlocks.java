package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlocks {

	private int blockCopperOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(),"CopperID",1000).getInt();
	private int blockTinOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(),"TinID",1001).getInt();
	private int blockIronFlatID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(),"IronFlatID",1002).getInt();
	
	private int blockPlatformID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(),"PlatformFlatID",2001).getInt();


	public static int getPlatformBlockID() {
		return getInstance().blockPlatformID;
	}
	
	public static int blockIronFlat() {
		return getInstance().blockIronFlatID;
	}
	public static int BlockCopperOreID() {
		return getInstance().blockCopperOreID;
	}

	public static int BlockTinOreID() {
		return getInstance().blockTinOreID;
	}

	private ConfigBlocks() {

	}

	public void registerOres() {
		registerOre(IndustrialProcessing.blockCopperOre, "IP.World.CopperOre", "Copper Ore", "copper");
		registerOre(IndustrialProcessing.blockTinOre, "IP.World.TinOre", "Tin Ore", "copper");
		registerBlock(IndustrialProcessing.blockIronFlat, "IP.Block.IronFlat", "Flat Iron block");
		
		registerBlock(IndustrialProcessing.blockPlatform, "IP.Block.Platform", "Walkway");
	}

	private void registerOre(Block block, String uniqueId, String displayName, String oreDictionaryKey) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		OreDictionary.registerOre(oreDictionaryKey, block);
	}
	private void registerBlock(Block block, String uniqueId, String displayName) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
	}

	private static ConfigBlocks instance = new ConfigBlocks();

	public static ConfigBlocks getInstance() {
		return instance;
	}

}