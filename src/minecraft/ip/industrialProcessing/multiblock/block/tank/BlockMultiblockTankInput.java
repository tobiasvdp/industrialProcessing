package ip.industrialProcessing.multiblock.block.tank;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigCreativeTabs;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.BlockMultiblockBlockRendered;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvInput;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMultiblockTankInput extends BlockMultiblockBlockRendered {

	private Icon completedIcon;
	private Icon connectedIcon;
	private Icon disconnectedIcon;
	
	public BlockMultiblockTankInput() {
		super(ConfigMachineBlocks.getBlockMultiblockTankInputID(), "BlockMultiblockTankInput", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockTankInput();
	}

	@Override
	protected Icon registerIcon(IconRegister iconRegister, MultiblockState state) {
		switch (state) {
		case COMPLETED:
			return iconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "MultiblockInvInput_full");
		case CONNECTED:
			return iconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "MultiblockInvInput_empty");
		case DISCONNECTED:
		default:
			return iconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "MultiblockInvInput_disconnected");
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking() || (((ITileEntityMultiblockBlock) tileEntity).getState() != MultiblockState.COMPLETED)) {
			return false;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}

}
