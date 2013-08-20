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

public class BlockMultiblockWeldingStationScreen extends BlockMultiblockBlockRendered{

	public BlockMultiblockWeldingStationScreen() {
		super(ConfigMachineBlocks.getBlockMultiblockTankWeldingStationScreenID(), "IP.Machine.Multi.Weld.Screen", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingStationScreen();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getrendererBlockMultiblockWeldingStationScreenID();
	}

}
