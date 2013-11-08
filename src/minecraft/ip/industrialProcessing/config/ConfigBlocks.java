package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import net.minecraft.block.Block;
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
        registerOre(IndustrialProcessing.blockCopperOre, "IP.World.CopperOre", "Copper Ore", "copper");
        registerOre(IndustrialProcessing.blockTinOre, "IP.World.TinOre", "Tin Ore", "tin");
        registerOre(IndustrialProcessing.blockGalenaOre, "IP.World.GalenaOre", "Galena Ore", "silver");
        OreDictionary.registerOre("galena", IndustrialProcessing.blockGalenaOre);
        registerOre(IndustrialProcessing.blockRutileOre, "IP.World.RutileOre", "Rutile Ore", "rutile");
        registerOre(IndustrialProcessing.blockChromiteOre, "IP.World.ChromiteOre", "Chromite Ore", "chromite");
        registerOre(IndustrialProcessing.blockCinnebarOre, "IP.World.CinnebarOre", "Cinnebar Ore", "cinnebar");
        registerOre(IndustrialProcessing.blockTaliaOre, "IP.World.TaliaOre", "Thallium Ore", "talia");
        registerBlock(IndustrialProcessing.blockIronFlat, "IP.Block.IronFlat", "Flat Iron block");

        registerBlock(IndustrialProcessing.blockPlatform, "IP.Block.Platform", "Walkway");
        registerBlock(IndustrialProcessing.blockGrit, "IP.Block.Grit", "Grit");
        registerBlock(IndustrialProcessing.blockAsphalt, "IP.Block.Asphalt", "Asphalt");
        registerBlock(IndustrialProcessing.blockStairs, "IP.Block.Stairs", "Walkway Stairs");

        registerBlock(IndustrialProcessing.blockCinnebar, "IP.World.Cinnebar", "Cinnebar Crystal");
        registerBlock(IndustrialProcessing.blockRutile, "IP.World.Rutile", "Rutile Crystal");

        registerBlock(IndustrialProcessing.blockLeaves, "IP.World.Tree.Leaves", "Leaves");
        registerBlock(IndustrialProcessing.blockLog, "IP.World.Tree.Log", "Log");
        registerBlock(IndustrialProcessing.blockRubberLog, "IP.World.Tree.Log.Rubber", "Rubber Log");
        registerBlock(IndustrialProcessing.blockPineLog, "IP.World.Tree.Log.Pine", "Pine Log");
        registerBlock(IndustrialProcessing.blockSapling, "IP.World.Tree.Sapling", "Sapling");
        
        registerBlock(IndustrialProcessing.blockMachineBlock, "IP.Block.MachineB", "Machine block");
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
