package ip.industrialProcessing.multiblock;

import cpw.mods.fml.common.network.Player;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
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
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class BlockMultiblockCore extends BlockContainer {

	protected BlockMultiblockCore(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "frame_full");
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		ITileEntityMultiblockCore core = (ITileEntityMultiblockCore) world.getBlockTileEntity(x, y, z);
		if (core != null) {
			core.breakEntireStructure();
			world.setBlockToAir(x, y, z);
		}
		return true;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		TileEntityMultiblockCore core = (TileEntityMultiblockCore) world.getBlockTileEntity(x, y, z);
		if (core != null) {
			core.checkConnectedSides();
			world.notifyBlocksOfNeighborChange(x, y, z, world.getBlockId(x, y, z));
		}
		super.onNeighborBlockChange(world, x, y, z, par5);

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public Icon getIcon(int par1, int par2) {
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking() || (((ITileEntityMultiblockCore) tileEntity).getState() != MultiblockState.COMPLETED)) {
			return false;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister) {

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
	((TileEntityMultiblockCore) world.getBlockTileEntity(x, y, z)).creator = entityLivingBase;
	super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
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
