package ip.industrialProcessing.multiblock.core;

import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
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

public abstract class BLmultiblockCore extends BlockContainer {

	public BLmultiblockCore(int blockID, String name, CreativeTabs tab) {
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
		return true;
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
		System.out.println(dir);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		TEmultiblockCore core = ((TEmultiblockCore) world.getBlockTileEntity(x, y, z));
		core.setModelID();
		core.setModelConnection();
		System.out.println(core.getModelID() + " " + core.getModelConnection());
		core.notifyNeighboursOfCorePlaced();
		core.onLayoutChange();
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		((TEmultiblockCore) world.getBlockTileEntity(x, y, z)).destroyMultiblock();
		world.setBlockToAir(x, y, z);
		return true;
	}

}
