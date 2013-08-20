package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.BlockMultiblockBlockRendered;
import ip.industrialProcessing.multiblock.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.BlockMultiblockCoreRendered;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMultiblockWeldingStation extends BlockMultiblockCoreRendered{

	public BlockMultiblockWeldingStation() {
		super(ConfigMachineBlocks.getBlockMultiblockWeldingStationID(), Material.iron, 1F, Block.soundMetalFootstep, "Welding station", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingStation();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getrendererBlockMultiblockWeldingStationID();
	}
}