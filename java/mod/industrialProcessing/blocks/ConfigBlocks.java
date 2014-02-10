package mod.industrialProcessing.blocks;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.utils.registry.BlockRegistry;
import mod.industrialProcessing.utils.registry.BlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlocks {

	public void registerOres() {
		BlockRegistry.registerOre(ISetupBlocks.blockBauxiteOre, "IP.ore.bauxiteOre","bauxite", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockCopperOre, "IP.ore.copperOre", "copper", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockTinOre, "IP.ore.tinOre", "tin", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockGalenaOre, "IP.ore.galenaOre", "silver", 2);
		BlockRegistry.registerOre(ISetupBlocks.blockRutileOre, "IP.ore.rutileOre", "rutile", 2);
		BlockRegistry.registerOre(ISetupBlocks.blockChromiteOre, "IP.ore.chromiteOre", "chromite", 2);
		BlockRegistry.registerOre(ISetupBlocks.blockCinnebarOre, "IP.ore.cinnebarOre", "cinnebar", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockTaliaOre, "IP.ore.taliaOre", "talia", 3);
	}

	private void registerBlock(Block block, String uniqueId, String displayName, BlockType... type) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		BlockRegistry.RegisterBlock(block, type);
	}

	private void registerBlock(Block block, Class<? extends ItemBlock> itemBlock, String uniqueId, String displayName, BlockType... type) {
		GameRegistry.registerBlock(block, itemBlock, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		BlockRegistry.RegisterBlock(block, type);
	}

	private static ConfigBlocks instance = new ConfigBlocks();

	public static ConfigBlocks getInstance() {
		return instance;
	}

}
