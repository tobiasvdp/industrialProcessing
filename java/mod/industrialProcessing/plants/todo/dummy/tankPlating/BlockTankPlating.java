package mod.industrialProcessing.plants.todo.dummy.tankPlating;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTankPlating extends BlockMultiblockDummy{

	public BlockTankPlating() {
		super(ConfigMachineBlocks.getBlockTankPlatingID(), "BlockTankPlating", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTankPlating();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererTankPlating();
	}


}
