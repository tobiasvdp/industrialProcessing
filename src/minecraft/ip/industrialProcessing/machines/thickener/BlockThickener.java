package ip.industrialProcessing.machines.thickener;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockThickener extends BlockMachine {

    public BlockThickener() {
	super(ConfigMachineBlocks.getThickenerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Thickener", IndustrialProcessing.tabOreProcessing);

    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityThickener();
    }

}
