package ip.industrialProcessing.machines.dryer;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockDryer extends BlockMachine {

	public BlockDryer() {
		super(ConfigMachineBlocks.getDryerBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Dryer", IndustrialProcessing.tabMachines); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		return new TileEntityDryer();
	}

}
