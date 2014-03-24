package mod.industrialProcessing.block;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.crystals.BlockCrystal;
import mod.industrialProcessing.block.doors.BlockDoor;
import mod.industrialProcessing.block.ore.BlockIPOre;
import mod.industrialProcessing.block.pane.BlockIPPane;
import mod.industrialProcessing.block.platforms.BlockPlatform;
import mod.industrialProcessing.block.platforms.BlockStairs;
import mod.industrialProcessing.block.tree.BlockIndustrialLeaves;
import mod.industrialProcessing.block.tree.BlockIndustrialLog;
import mod.industrialProcessing.block.tree.BlockIndustrialSapling;
import mod.industrialProcessing.block.tree.BlockPineLog;
import mod.industrialProcessing.block.tree.BlockRubberLog;
import mod.industrialProcessing.plants.decoration.machineBlock.BlockMachineBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockPane;
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

	public final static BlockDoor blockDoorEmergency = new BlockDoor(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "Orange", "Iron", "iron_block", "glass");

	public final static Block blockHalfWavePlate = (new BlockIPPane("blockHalfWavePlate", "blockHalfWavePlate", Material.iron, false)).setHardness(0.9F).setStepSound(Block.soundTypeMetal);
	
	public final static BlockMachineBlock blockMachineBlock = new BlockMachineBlock();
	/*
	 * public final static MicroBlock microBlock = new MicroBlock();
	 */
	// TODO public final static BlockMachineBlock blockMachineBlock = new
	// BlockMachineBlock();
}
