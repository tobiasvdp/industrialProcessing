package ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.TileEntitySourWaterStripper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGasProcessor  extends BlockMachineRendered {

	public BlockGasProcessor() {
		super(ConfigMachineBlocks.getGasProcessorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "GasProcessor", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGasProcessor();
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererGasProcessorId();
    }

}
