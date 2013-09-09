package ip.industrialProcessing.multiblock.dummy.block.displayPanel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockDisplayPanel extends BLmultiblockDummy {

	public BLmultiblockDisplayPanel() {
		super(ConfigMachineBlocks.getBLmultiblockDisplayPanel(), "BLmultiblockDisplayPanel", IndustrialProcessing.tabMultiblocks);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockDisplayPanel();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockDisplayPanel();
	}

}
