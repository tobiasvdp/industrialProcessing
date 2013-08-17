package ip.industrialProcessing.multiblock.block.frame;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMachineFrame extends BlockMultiblockBlock {

	public BlockMachineFrame() {

		super(ConfigMachineBlocks.getMachineFrameBlockID(),"BlockMachineFrame",
				IndustrialProcessing.tabOreProcessing);

	} 

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMachineFrame();
	}

	@Override
	protected Icon registerIcon(IconRegister par1IconRegister,
			MultiblockState state) { 
		switch (state) {
		case COMPLETED:
			return par1IconRegister
					.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
							+ "frame_full");
		case CONNECTED:
			return par1IconRegister
					.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
							+ "frame_empty");
		case DISCONNECTED:
		default:
			return par1IconRegister
					.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
							+ "frame_disconnected");
		}
	}

}
