package ip.industrialProcessing.machines.hydroCyclone;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockHydroCyclone extends BlockMachine {

    public BlockHydroCyclone() {
	super(ConfigMachineBlocks.getHydroCycloneBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Hydro Cyclone Separator", IndustrialProcessing.tabOreProcessing);

    }
    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityHydroCyclone();
    }

}
