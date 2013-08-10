package ip.industrialProcessing.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class BlockMachine extends BlockContainer {
    public BlockMachine(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
	super(par1, par2Material);
	setHardness(hardness);
	setStepSound(stepSound);
	setUnlocalizedName(name);
	setCreativeTab(tab);
	func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
	if (tileEntity == null || player.isSneaking()) {
	    return false;
	}
	player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
	InventoryUtils.DropInventoryContents(world, x, y, z);
	super.breakBlock(world, x, y, z, par5, par6);
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
	boolean canPlace = true;
	int l = par1World.getBlockId(x, y, z);
	Block block = Block.blocksList[l];
	if (block != null) {
	    if (!block.isBlockReplaceable(par1World, x, y, z))
		canPlace = false;
	}
	return canPlace;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	int dir = MathHelper.floor_double((double) ((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
	System.out.println("Facing "+getForwardFromMetadata(dir));
    }
    // TODO: use the tile entity to store orientation
    public ForgeDirection getForwardFromMetadata(World world, int x, int y, int z)
    {
	int metadata = world.getBlockMetadata(x, y, z);
	return getForwardFromMetadata(metadata);
    }

    public static ForgeDirection getForwardFromMetadata(int metadata) { 
	switch(metadata)
	{
	case 0:
	    return ForgeDirection.NORTH;
	case 1:
	    return ForgeDirection.EAST;
	case 2:
	    return ForgeDirection.SOUTH; 
	case 3:
	    return ForgeDirection.WEST;
	}
	return null;
    }

}
