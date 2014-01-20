package ip.industrialProcessing.multiblock.core;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
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

public abstract class BlockMultiblockCore extends BlockContainer{

	public BlockMultiblockCore(int blockID, String name, CreativeTabs tab) {
		super(blockID, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "inputTop");
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
		TileEntityMultiblockCore TEcore = (TileEntityMultiblockCore) te;
		if (TEcore.getState() == MultiblockState.COMPLETED) {
			player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
			return true;
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
		int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		TileEntityMultiblockCore core = ((TileEntityMultiblockCore) world.getBlockTileEntity(x, y, z));
		core.setsideFromMetadata(dir);
		core.setModelID();
		core.setModelConnection();
		core.notifyNeighboursOfCorePlaced();
		core.onLayoutChange();
	}
	
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		((TileEntityMultiblockCore) world.getBlockTileEntity(x, y, z)).onDestroy();
		((TileEntityMultiblockCore) world.getBlockTileEntity(x, y, z)).destroyMultiblock();
    	super.breakBlock(world, x, y, z, par5, par6);
    }

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		par1World.markBlockForUpdate(par2, par3, par4);
	}

}
