package mod.industrialProcessing.blocks;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blocks.crystals.BlockCrystal;
import mod.industrialProcessing.blocks.ore.BlockIPOre;
import mod.industrialProcessing.blocks.platforms.BlockPlatform;
import mod.industrialProcessing.blocks.platforms.BlockStairs;
import mod.industrialProcessing.blocks.tree.BlockIndustrialLeaves;
import mod.industrialProcessing.blocks.tree.BlockIndustrialLog;
import mod.industrialProcessing.blocks.tree.BlockIndustrialSapling;
import mod.industrialProcessing.blocks.tree.BlockPineLog;
import mod.industrialProcessing.blocks.tree.BlockRubberLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public interface ISetupBlocks {
	public static final Block blockCopperOre = new BlockOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockTinOre = new BlockOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockGalenaOre = new BlockOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockRutileOre = new BlockIPOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockChromiteOre = new BlockOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockCinnebarOre = new BlockIPOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockTaliaOre = new BlockOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	public static final Block blockBauxiteOre = new BlockOre().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);

	public final static BlockIP blockGrit = (BlockIP) new BlockIP(2.0f, 5.0f, Material.ground, Block.soundTypeGravel);
	public final static BlockIP blockAsphalt = (BlockIP) new BlockIP(2.0f, 5.0f, Material.clay, Block.soundTypeStone);
	public final static BlockIP blockCobbleLimestone = (BlockIP) new BlockIP(1.0f, 5.0f, Material.ground, Block.soundTypeStone);
	public final static BlockIP blockLimestone = (BlockIP) new BlockIP(2.0f, 5.0f, Material.ground, Block.soundTypeStone, IndustrialProcessing.blockCobbleLimestone).setCreativeTab(IndustrialProcessing.tabOres);
	public final static BlockIP blockHardSand = (BlockIP) new BlockIP(2.0f, 5.0f, Material.ground, Block.soundTypeSand);

	public final static BlockPlatform blockPlatform = new BlockPlatform();
	public final static BlockStairs blockStairs = new BlockStairs();
	public final static BlockCrystal blockCinnebar = new BlockCrystal();
	public final static BlockCrystal blockRutile = new BlockCrystal();

	public final static BlockIndustrialLeaves blockLeaves = new BlockIndustrialLeaves();
	public final static BlockIndustrialLog blockLog = new BlockIndustrialLog();
	public final static BlockRubberLog blockRubberLog = new BlockRubberLog();
	public final static BlockPineLog blockPineLog = new BlockPineLog();
	public final static BlockIndustrialSapling blockSapling = new BlockIndustrialSapling();

	/*
	 * public final static Block blockHalfWavePlate = (new
	 * BlockPane(ConfigBlocks.getInstance().getBlockHalfWavePlateID(),
	 * "blockHalfWavePlate", "blockHalfWavePlate", Material.iron,
	 * false)).setHardness
	 * (0.9F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName
	 * ("halfWavePlate"); public final static BlockDoorEmergency
	 * blockDoorEmergency = new BlockDoorEmergency();
	 * 
	 * public final static MicroBlock microBlock = new MicroBlock();
	 */
	// TODO public final static BlockMachineBlock blockMachineBlock = new
	// BlockMachineBlock();
}
