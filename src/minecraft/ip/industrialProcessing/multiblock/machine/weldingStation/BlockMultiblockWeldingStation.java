package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.BlockMultiblockBlockRendered;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMultiblockWeldingStation extends BlockMultiblockBlock{

	public BlockMultiblockWeldingStation() {
		super(ConfigMachineBlocks.getBlockMultiblockWeldingStationID(), "Welding station", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingStation();
	}

	@Override
	protected Icon registerIcon(IconRegister iconRegister, MultiblockState state) {
		// TODO Auto-generated method stub
		return null;
	}

}
