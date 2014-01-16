package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BlockDelayedCoker extends BlockMultiblockCore{
	public BlockDelayedCoker(){
		super(ConfigMachineBlocks.getBlockDelayedCokerID(), "BlockDelayedCoker", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDelayedCoker();
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererDelayedCoker();
	}
}
