package ip.industrialProcessing.multiblock.dummy.block.tankPlating;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.wheel.TEmultiblockWheel;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTankPlating extends BLmultiblockDummy{

	public BlockTankPlating() {
		super(ConfigMachineBlocks.getBlockTankPlatingID(), "BlockTankPlating", IndustrialProcessing.tabMultiblocks);
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
