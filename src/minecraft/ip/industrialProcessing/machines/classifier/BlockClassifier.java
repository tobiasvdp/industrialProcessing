package ip.industrialProcessing.machines.classifier;

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

public class BlockClassifier extends BlockMachine {

    public BlockClassifier() {
	super(ConfigMachineBlocks.getClassifierBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Spiral Classifier", IndustrialProcessing.tabMachines);
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityClassifier();
    }

}
