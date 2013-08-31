package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BLmultiblockDummy extends BlockContainer {

	public BLmultiblockDummy(int blockID, String name, CreativeTabs tab) {
		super(blockID, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(name);
		setCreativeTab(tab);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		super.onNeighborBlockChange(world, x, y, z, par5);

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (player.isSneaking() || te == null)
			return false;
		TEmultiblockDummy TEdummy = ((TEmultiblockDummy) te);
		if (TEdummy.getState() == MultiblockState.COMPLETED) {
			TEmultiblockCore TEcore = (TEmultiblockCore) TEdummy.getCore();
			if (TEcore.getState() == MultiblockState.COMPLETED) {
				player.openGui(IndustrialProcessing.instance, 0, world, TEcore.xCoord, TEcore.yCoord, TEcore.zCoord);
				return true;
			}
		}
		return false;
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
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		if (((TEmultiblockDummy) world.getBlockTileEntity(x, y, z)).searchForCore()) {
			((TEmultiblockDummy) world.getBlockTileEntity(x, y, z)).getCore().onLayoutChange();
		}
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		TEmultiblockCore core = ((TEmultiblockDummy) world.getBlockTileEntity(x, y, z)).getCore();
		((TEmultiblockDummy) world.getBlockTileEntity(x, y, z)).delCore();
		world.destroyBlock(x, y, z, true);
		if (core != null)
			core.onLayoutChange();
		return true;
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		par1World.markBlockForUpdate(par2, par3, par4);
	}
}
