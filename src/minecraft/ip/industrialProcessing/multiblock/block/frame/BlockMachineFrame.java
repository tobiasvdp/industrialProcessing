package ip.industrialProcessing.multiblock.block.frame;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.BlockMultiblockBlockRendered;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMachineFrame extends BlockMultiblockBlockRendered {

	public BlockMachineFrame() {

		super(ConfigMachineBlocks.getMachineFrameBlockID(), "BlockMachineFrame", IndustrialProcessing.tabOreProcessing);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMachineFrame();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererBlockMachineFrameID();
	}

}
