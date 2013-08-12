package ip.industrialProcessing.power.buildcraftGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;

public class BlockBuildcraftGenerator extends BlockPowerGenerator {

    public BlockBuildcraftGenerator() {
	super(ConfigMachineBlocks.getBuildcraftGeneratorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Buildcraft Generator", IndustrialProcessing.tabPower);
    }
    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityBuildcraftGenerator();
    }
 

}
