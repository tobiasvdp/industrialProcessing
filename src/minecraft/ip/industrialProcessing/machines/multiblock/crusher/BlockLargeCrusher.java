package ip.industrialProcessing.machines.multiblock.crusher;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.multiblock.BlockMultiMachineCore;

public class BlockLargeCrusher extends BlockMultiMachineCore {

	public BlockLargeCrusher() {
		super(ConfigMachineBlocks.getLargeCrusherBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Large Crusher", IndustrialProcessing.tabMachines);
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		return new TileEntityLargeCrusher();
	}

}
