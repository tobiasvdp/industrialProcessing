package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockToggleButton extends BlockMultiblockDummy{

	public BLmultiblockToggleButton() {
		super(ConfigMachineBlocks.getBLmultiblockToggleButton(),"MultiblockToggleButton",ISetupCreativeTabs.tabMultiblocks);
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
		TileEntityMultiblockDummy TEdummy = ((TileEntityMultiblockDummy) te);
		if (TEdummy.getState() == MultiblockState.COMPLETED) {
			player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		}
		return true;
	}

}
