package ip.industrialProcessing.multiblock.block.weldingStation;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.BlockMultiblockBlockRendered;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMultiblockWeldingStationRight extends BlockMultiblockBlockRendered{

	public BlockMultiblockWeldingStationRight() {
		super(ConfigMachineBlocks.getBlockMultiblockTankWeldingStationRightID(), "IP.Machine.Multi.Weld.Right", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingStationRight();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getrendererBlockMultiblockWeldingStationID();
	}

}
