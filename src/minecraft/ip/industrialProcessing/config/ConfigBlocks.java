package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.microBlock.MicroBlockTileEntity;
import ip.industrialProcessing.utils.registry.BlockRegistry;
import ip.industrialProcessing.utils.registry.BlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlocks {

	private int blockCopperOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "CopperID", 1000).getInt();
	private int blockTinOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "TinID", 1001).getInt();
	private int blockGalenaOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "GalenaID", 1002).getInt();
	private int blockRutileOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "RutileID", 1003).getInt();
	private int blockChromiteOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "ChromiteID", 1004).getInt();
	private int blockCinnebarOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "CinnebarID", 1005).getInt();
	private int blockTaliaOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "TaliaID", 1006).getInt();
	private int blockBauxiteOreID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "BauxiteOreID", 1012).getInt();

	private int blockIronFlatID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "IronFlatID", 1007).getInt();

	private int blockCinnebarCrystalID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "CinnebarCrystalID", 1008).getInt();
	private int blockRutileCrystalID = IndustrialProcessing.config.get(ConfigCategories.ore.toString(), "RutileCrystalID", 1009).getInt();
	private int blockGritID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockGritID", 1010).getInt();
	private int blockAsphaltID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockAsphaltID", 1011).getInt();

	private int blockPlatformID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "PlatformFlatID", 2001).getInt();
	private int blockStairsID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "PlatformStairsID", 2002).getInt();

	private int blockLogID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "TreeLogID", 2004).getInt();
	private int blockLeavesID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "TreeLeavesID", 2005).getInt();
	private int blockSaplingID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "TreeSaplingID", 2006).getInt();
	private int blockRubberLogID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "RubberTreeLogID", 2007).getInt();
	private int blockMachineBlockID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockMachineBlockID", 2008).getInt();

	private int blockPineLogID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "PineTreeLogID", 2009).getInt();

	private int blockCobbleLimestoneID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockCobbleLimestoneID", 2010).getInt();
	private int blockLimestoneID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockLimestoneID", 2011).getInt();
	private int blockHardSandID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockHardSandID", 2012).getInt();
	private int blockHalfWavePlateID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockHalfWavePlateID", 2013).getInt();
	private int blockDoorEmergencyID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockDoorEmergencyID", 2014).getInt();
	private int blockMicroBlockID = IndustrialProcessing.config.get(ConfigCategories.blocks.toString(), "blockMicroBlockID", 2015).getInt();

	public static int getBlockMicroBlockID() {
		return getInstance().blockMicroBlockID;
	}
	public static int getBlockHalfWavePlateID() {
		return getInstance().blockHalfWavePlateID;
	}

	public static int getBlockDoorEmergencyID() {
		return getInstance().blockDoorEmergencyID;
	}
	
	public static int getBlockHardSandID() {
		return getInstance().blockHardSandID;
	}

	public static int getBlockBauxiteID() {
		return getInstance().blockBauxiteOreID;
	}

	public static int getBlockCobbleLimestoneID() {
		return getInstance().blockCobbleLimestoneID;
	}

	public static int getBlockLimestoneID() {
		return getInstance().blockLimestoneID;
	}

	public static int blockMachineBlock() {
		return getInstance().blockMachineBlockID;
	}

	public static int blockAsphalt() {
		return getInstance().blockAsphaltID;
	}

	public static int blockGrit() {
		return getInstance().blockGritID;
	}

	public static int getBlockChromiteOreID() {
		return getInstance().blockChromiteOreID;
	}

	public static int getBlockCinnebarOreID() {
		return getInstance().blockCinnebarOreID;
	}

	public static int getBlockCinnebarCrystalID() {
		return getInstance().blockCinnebarCrystalID;
	}

	public static int getBlockRutileCrystalID() {
		return getInstance().blockRutileCrystalID;
	}

	public static int getBlockTaliaOreID() {
		return getInstance().blockTaliaOreID;
	}

	public static int getBlockRutileOreID() {
		return getInstance().blockRutileOreID;
	}

	public static int getPlatformBlockID() {
		return getInstance().blockPlatformID;
	}

	public static int getStairsBlockID() {
		return getInstance().blockStairsID;
	}

	public static int blockIronFlat() {
		return getInstance().blockIronFlatID;
	}

	public static int BlockGalenaOreID() {
		return getInstance().blockGalenaOreID;
	}

	public static int BlockCopperOreID() {
		return getInstance().blockCopperOreID;
	}

	public static int BlockTinOreID() {
		return getInstance().blockTinOreID;
	}

	public static int getLeavesID() {
		return getInstance().blockLeavesID;
	}

	public static int getLogID() {
		return getInstance().blockLogID;
	}

	public static int getRubberLogID() {
		return getInstance().blockRubberLogID;
	}

	public static int getPineLogID() {
		return getInstance().blockPineLogID;
	}

	public static int getSaplingID() {
		return getInstance().blockSaplingID;
	}

	private ConfigBlocks() {

	}

	public void registerOres() {
		registerOre(ISetupBlocks.blockBauxiteOre, "IP.World.BauxiteOre", "Bauxite Ore", "bauxite", 1);
		registerOre(ISetupBlocks.blockCopperOre, "IP.World.CopperOre", "Copper Ore", "copper", 1);
		registerOre(ISetupBlocks.blockTinOre, "IP.World.TinOre", "Tin Ore", "tin", 1);
		registerOre(ISetupBlocks.blockGalenaOre, "IP.World.GalenaOre", "Galena Ore", "silver", 2);
		OreDictionary.registerOre("galena", ISetupBlocks.blockGalenaOre);
		OreDictionary.registerOre("lead", ISetupBlocks.blockGalenaOre);
		registerOre(ISetupBlocks.blockRutileOre, "IP.World.RutileOre", "Rutile Ore", "rutile", 2); 
		registerOre(ISetupBlocks.blockChromiteOre, "IP.World.ChromiteOre", "Chromite Ore", "chromite", 2);
		registerOre(ISetupBlocks.blockCinnebarOre, "IP.World.CinnebarOre", "Cinnebar Ore", "cinnebar", 1);
		registerOre(ISetupBlocks.blockTaliaOre, "IP.World.TaliaOre", "Thallium Ore", "talia", 3);

		registerBlock(ISetupBlocks.blockIronFlat, "IP.Block.IronFlat", "Flat Iron block");
		registerBlock(ISetupBlocks.blockHardSand, "IP.Block.HardSand", "Hardened sand");
		registerBlock(ISetupBlocks.blockCobbleLimestone, "IP.Block.cobbleLime", "Cobble limestone");
		registerBlock(ISetupBlocks.blockLimestone, "IP.Block.limestone", "Limestone");
		registerBlock(ISetupBlocks.blockPlatform, "IP.Block.Platform", "Walkway", BlockType.structure);
		registerBlock(ISetupBlocks.blockGrit, "IP.Block.Grit", "Grit");
		registerBlock(ISetupBlocks.blockAsphalt, "IP.Block.Asphalt", "Asphalt");
		registerBlock(ISetupBlocks.blockStairs, "IP.Block.Stairs", "Walkway Stairs", BlockType.structure);
		registerBlock(ISetupMachineBlocks.blockAnvil, "IP.Block.Anvil", "Anvil", BlockType.assemble);
		registerBlock(ISetupBlocks.blockHalfWavePlate, "IP.Block.hwPlate", "Half wave plate", BlockType.structure);

		registerBlock(ISetupBlocks.blockCinnebar, "IP.World.Cinnebar", "Cinnebar Crystal");
		registerBlock(ISetupBlocks.blockRutile, "IP.World.Rutile", "Rutile Crystal");

		registerBlock(ISetupBlocks.blockLeaves, ItemBlockWithMetadata.class, "IP.World.Tree.Leaves", "Leaves");
		registerBlock(ISetupBlocks.blockLog, ItemBlockWithMetadata.class, "IP.World.Tree.Log", "Log");
		registerBlock(ISetupBlocks.blockRubberLog, "IP.World.Tree.Log.Rubber", "Rubber Log");
		registerBlock(ISetupBlocks.blockPineLog, "IP.World.Tree.Log.Pine", "Pine Log");
		registerBlock(ISetupBlocks.blockSapling, ItemBlockWithMetadata.class, "IP.World.Tree.Sapling", "Sapling");

		registerBlock(ISetupBlocks.blockMachineBlock, "IP.Block.MachineB", "Machine block", BlockType.Machine, BlockType.assemble);
		registerBlock(ISetupBlocks.blockDoorEmergency, "IP.Block.DoorEm", "Emergency door", BlockType.decoration);
		
		ConfigMachineBlocks.registerMachineBlock(ISetupBlocks.microBlock, "IP.MicroBlock", "Microblock", MicroBlockTileEntity.class);
		
// register vanilla ores
        BlockRegistry.RegisterBlock(Block.oreIron, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreGold, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreCoal, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreDiamond, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreNetherQuartz, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreLapis, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreRedstone, BlockType.Resource, BlockType.Vanilla);
        BlockRegistry.RegisterBlock(Block.oreEmerald, BlockType.Resource, BlockType.Vanilla);
	}

	@Deprecated
	private void registerOre(Block block, String uniqueId, String displayName, String oreDictionaryKey, int level) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", level);
		LanguageRegistry.addName(block, displayName);
		OreDictionary.registerOre(oreDictionaryKey, block);
        BlockRegistry.RegisterBlock(block, BlockType.Resource);
	}

	@Deprecated
	private void registerBlock(Block block, String uniqueId, String displayName) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
	}

	@Deprecated
	private void registerBlock(Block block, Class<? extends ItemBlock> itemBlock, String uniqueId, String displayName) {
		GameRegistry.registerBlock(block, itemBlock, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
	}

	private void registerOre(Block block, String uniqueId, String displayName, String oreDictionaryKey, int level, BlockType... type) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", level);
		LanguageRegistry.addName(block, displayName);
		OreDictionary.registerOre(oreDictionaryKey, block);
		BlockRegistry.RegisterBlock(block, type);
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
        BlockRegistry.RegisterBlock(block, BlockType.Resource);
	}

	private static ConfigBlocks instance = new ConfigBlocks();

	public static ConfigBlocks getInstance() {
		return instance;
	}

}
