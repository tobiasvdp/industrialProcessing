package ip.industrialProcessing.transport.items.conveyorSorter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorSorter extends BlockConveyorBase {
    public BlockConveyorSorter() {
	super(ConfigMachineBlocks.getBLtransportConveyorBeltSorter(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Sorter", IndustrialProcessing.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityConveyorSorter();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererConveyorSorterID();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {

	//boolean result = super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return false;
    }
}
