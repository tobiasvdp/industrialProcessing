package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockManoMeter extends BlockMachineRendered {

	public BlockManoMeter() {
		super(ConfigTransportBlocks.getBlockTransportFluidManometerID(), Material.iron, 1F, Block.soundMetalFootstep, "Manometer", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityManoMeter();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererManometerId();
	}
}
