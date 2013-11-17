package ip.industrialProcessing.machines.flotationCell;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockFlotationCell extends BlockMachineRendered {

	public BlockFlotationCell() {
		super(ConfigMachineBlocks.getFlotationCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Flotation Cell", IndustrialProcessing.tabOreProcessing);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityFlotationCell te = new TileEntityFlotationCell();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererFlotationCellId();
	}
}
