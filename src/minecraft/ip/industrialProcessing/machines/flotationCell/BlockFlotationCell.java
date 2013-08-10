package ip.industrialProcessing.machines.flotationCell;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockFlotationCell extends BlockMachine {

    public BlockFlotationCell() {
	super(ConfigMachineBlocks.getFlotationCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Flotation Cell", IndustrialProcessing.tabMachines);

    }
    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityFlotationCell();
    }

}
