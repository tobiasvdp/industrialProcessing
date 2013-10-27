package ip.industrialProcessing.multiblock.dummy.block.destilationTray;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.tankPlating.TileEntityTankPlating;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDestilationTray  extends BLmultiblockDummy{

	public BlockDestilationTray() {
		super(ConfigMachineBlocks.getBlockDestilationTrayID(), "BlockDestilationTray", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDestilationTray();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererDestilationTray();
	}

}
