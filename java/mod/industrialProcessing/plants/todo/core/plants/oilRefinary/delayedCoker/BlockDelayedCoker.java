package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.delayedCoker;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
