package ip.industrialProcessing.multiblock.machine.mixer;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.BlockMultiblockCore;

public class BlockMultiblockMixer extends BlockMultiblockCore{

	public BlockMultiblockMixer() {
		super(ConfigMachineBlocks.getlargeMixerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Large mixer", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockMixer();
	}

}
