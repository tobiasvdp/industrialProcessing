package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlocks {

	private int blockCopperOreID = 1000;
	private int blockTinOreID = 1001;

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
	}

	private void registerOre(Block block, String uniqueId, String displayName, String oreDictionaryKey) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		OreDictionary.registerOre(oreDictionaryKey, block);
	}

	private static ConfigBlocks instance = new ConfigBlocks();

	public static ConfigBlocks getInstance() {
		return instance;
	}

}