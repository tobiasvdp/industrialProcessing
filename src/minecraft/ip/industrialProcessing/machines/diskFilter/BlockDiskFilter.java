package ip.industrialProcessing.machines.diskFilter;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockDiskFilter extends BlockMachineRendered {

	public BlockDiskFilter() {
		super(ConfigMachineBlocks.getDiskFilterBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Disk Filter", IndustrialProcessing.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityDiskFilter te =  new TileEntityDiskFilter();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType() {
    	return ConfigRenderers.getRendererDiskFilterId();
    }

}
