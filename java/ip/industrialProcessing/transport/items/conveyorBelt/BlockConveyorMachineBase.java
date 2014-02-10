package ip.industrialProcessing.transport.items.conveyorBelt;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupItems;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockConveyorMachineBase extends BlockConveyorBase {

    public BlockConveyorMachineBase(int blockID, Material material, float hardness, StepSound stepSound, String name, CreativeTabs creativeTab) {
	super(blockID, material, hardness, stepSound, name, creativeTab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {

	ItemStack playerItem = player.inventory.getCurrentItem();

	if (playerItem != null && (playerItem.itemID == ISetupItems.itemHexKey.itemID)) {
	    TileEntityConveyorConnectionsBase conveyorBelt = (TileEntityConveyorConnectionsBase) world.getBlockTileEntity(x, y, z);
	    conveyorBelt.toggleSlope(player);
	    return false;
	} else
	    player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
    }

    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

	AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);

	if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
	    par6List.add(axisalignedbb1);
	}
    }
}
