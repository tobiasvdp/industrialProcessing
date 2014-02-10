package ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGasProcessor  extends BlockMachineRendered {

	public BlockGasProcessor() {
		super(ConfigMachineBlocks.getGasProcessorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "GasProcessor", ISetupCreativeTabs.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityGasProcessor te = new TileEntityGasProcessor();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererGasProcessorId();
    }

}
