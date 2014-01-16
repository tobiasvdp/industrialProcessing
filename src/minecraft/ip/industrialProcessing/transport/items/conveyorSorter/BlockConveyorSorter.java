package ip.industrialProcessing.transport.items.conveyorSorter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorSorter extends BlockConveyorBase {
    public BlockConveyorSorter() {
	super(ConfigMachineBlocks.getBLtransportConveyorBeltSorter(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Sorter", ISetupCreativeTabs.tabPower);
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
	player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return true;
    }
}
