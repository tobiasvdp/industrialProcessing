package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockRainTank extends BlockMachineRendered {

	public BlockRainTank() {
		super(ConfigTransportBlocks.getBlockRainTankID(), Material.iron, 1F, Block.soundMetalFootstep, "Rain Collector", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityRainTank();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererRainTankId();
	}
}
