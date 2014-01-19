package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.buildingBlock.BlockIP;
import ip.industrialProcessing.buildingBlock.BlockOreIP;
import ip.industrialProcessing.buildingBlock.BlockPane;
import ip.industrialProcessing.decoration.block.machineBlock.BlockMachineBlock;
import ip.industrialProcessing.decoration.crystals.BlockCinnebar;
import ip.industrialProcessing.decoration.crystals.BlockRutile;
import ip.industrialProcessing.decoration.platforms.BlockPlatform;
import ip.industrialProcessing.decoration.platforms.BlockStairs;
import ip.industrialProcessing.decoration.trees.BlockIndustrialLeaves;
import ip.industrialProcessing.decoration.trees.BlockIndustrialLog;
import ip.industrialProcessing.decoration.trees.BlockIndustrialSapling;
import ip.industrialProcessing.decoration.trees.BlockPineLog;
import ip.industrialProcessing.decoration.trees.BlockRubberLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public interface ISetupBlocks {
    public static final Block blockCopperOre = (new BlockOre(ConfigBlocks.BlockCopperOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockCopperOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockCopperOre").setCreativeTab(IndustrialProcessing.tabOres);;
    public static final Block blockTinOre = (new BlockOre(ConfigBlocks.BlockTinOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockTinOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockTinOre").setCreativeTab(IndustrialProcessing.tabOres);
    public static final Block blockGalenaOre = (new BlockOre(ConfigBlocks.BlockGalenaOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockGalenaOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockGalenaOre").setCreativeTab(IndustrialProcessing.tabOres);
    public static final Block blockRutileOre = (new BlockOreIP(ConfigBlocks.getBlockRutileOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockRutileOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockRutileOre").setCreativeTab(IndustrialProcessing.tabOres);
    public static final Block blockChromiteOre = (new BlockOre(ConfigBlocks.getBlockChromiteOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockChromiteOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockChromiteOre").setCreativeTab(IndustrialProcessing.tabOres);
    public static final Block blockCinnebarOre = (new BlockOreIP(ConfigBlocks.getBlockCinnebarOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockCinnebarOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockCinnebarOre").setCreativeTab(IndustrialProcessing.tabOres);
    public static final Block blockTaliaOre = (new BlockOre(ConfigBlocks.getBlockTaliaOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockTaliaOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockTaliaOre").setCreativeTab(IndustrialProcessing.tabOres);
    public static final Block blockBauxiteOre = (new BlockOre(ConfigBlocks.getBlockBauxiteID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockBauxiteOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockBauxiteOre").setCreativeTab(IndustrialProcessing.tabOres);

    public final static BlockIP blockIronFlat = new BlockIP(ConfigBlocks.getInstance().blockIronFlat(), "ip.block.ironflat", 5.0f, Material.iron, Block.soundMetalFootstep);
    public final static BlockIP blockGrit = (BlockIP) new BlockIP(ConfigBlocks.getInstance().blockGrit(), "Grit", 1.0f, Material.ground, Block.soundGravelFootstep).setCreativeTab(IndustrialProcessing.tabOres);
    public final static BlockIP blockAsphalt = (BlockIP) new BlockIP(ConfigBlocks.getInstance().blockAsphalt(), "Asphalt", 1.0f, Material.clay, Block.soundStoneFootstep).setCreativeTab(IndustrialProcessing.tabOres);
    public final static BlockMachineBlock blockMachineBlock = new BlockMachineBlock();
    public final static BlockIP blockCobbleLimestone = (BlockIP) new BlockIP(ConfigBlocks.getInstance().getBlockCobbleLimestoneID(), "blockCobbleLimestone", 1.0f, Material.ground, Block.soundStoneFootstep).setCreativeTab(IndustrialProcessing.tabOres);
    public final static BlockIP blockLimestone = (BlockIP) new BlockIP(ConfigBlocks.getInstance().getBlockLimestoneID(), "blockLimestone", 1.0f, Material.ground, Block.soundStoneFootstep,IndustrialProcessing.blockCobbleLimestone.blockID).setCreativeTab(IndustrialProcessing.tabOres);
    public final static BlockIP blockHardSand = (BlockIP) new BlockIP(ConfigBlocks.getInstance().getBlockHardSandID(), "blockHardSand", 1.0f, Material.ground, Block.soundSandFootstep).setCreativeTab(IndustrialProcessing.tabOres);
    
    public final static BlockPlatform blockPlatform = new BlockPlatform();
    public final static BlockStairs blockStairs = new BlockStairs();
    public final static BlockCinnebar blockCinnebar = new BlockCinnebar();
    public final static BlockRutile blockRutile = new BlockRutile();

    public final static BlockIndustrialLeaves blockLeaves = new BlockIndustrialLeaves();
    public final static BlockIndustrialLog blockLog = new BlockIndustrialLog();
    public final static BlockRubberLog blockRubberLog = new BlockRubberLog();
    public final static BlockPineLog blockPineLog = new BlockPineLog();
    public final static BlockIndustrialSapling blockSapling = new BlockIndustrialSapling();
    
    public final static Block blockHalfWavePlate = (new BlockPane(ConfigBlocks.getInstance().getBlockHalfWavePlateID(), "blockHalfWavePlate", "blockHalfWavePlate", Material.iron, false)).setHardness(0.9F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("halfWavePlate");
}
