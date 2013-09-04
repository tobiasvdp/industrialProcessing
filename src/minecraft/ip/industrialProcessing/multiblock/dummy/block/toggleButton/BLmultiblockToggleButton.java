package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BLmultiblockToggleButton extends BLmultiblockDummy{

	public BLmultiblockToggleButton() {
		super(ConfigMachineBlocks.getBLmultiblockToggleButton(),"MultiblockToggleButton",IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockToggleButton();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (player.isSneaking() || te == null)
			return false;
		TEmultiblockDummy TEdummy = ((TEmultiblockDummy) te);
		if (TEdummy.getState() == MultiblockState.COMPLETED) {
			((TEmultiblockToggleButton) TEdummy).toggle();
		}
		return true;
	}

}
