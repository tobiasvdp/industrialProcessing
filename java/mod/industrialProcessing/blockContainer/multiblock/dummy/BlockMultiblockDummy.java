package mod.industrialProcessing.blockContainer.multiblock.dummy;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.utils.inventory.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public abstract class BlockMultiblockDummy extends BlockContainerIPRendered {

	public BlockMultiblockDummy	(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness, resistance, material, soundtype,iconNames);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block par5) {
		super.onNeighborBlockChange(world, x, y, z, par5);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (player.isSneaking() || te == null)
			return false;
		TileEntityMultiblockDummy TEdummy = ((TileEntityMultiblockDummy) te);
		if (TEdummy.getState() == MultiblockState.COMPLETED) {
			TileEntityMultiblockCore TEcore = TEdummy.getCore();
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
		Block block = par1World.getBlock(x, y, z);
		
		if (block != null) {
			if (!block.isReplaceable(par1World, x, y, z))
				canPlace = false;
		}
		return canPlace;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
		TileEntity entity = world.getTileEntity(x, y, z);
		world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		if (((TileEntityMultiblockDummy) entity).searchForCore()) {
			((TileEntityMultiblockDummy) entity).getCore().onLayoutChange();
		}
		((TileEntityMultiblockDummy)entity).setsideFromMetadata(dir);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		TileEntityMultiblockCore core = ((TileEntityMultiblockDummy) world.getTileEntity(x, y, z)).getCore();
		((TileEntityMultiblockDummy) world.getTileEntity(x, y, z)).onDestroy();
		((TileEntityMultiblockDummy) world.getTileEntity(x, y, z)).delCore();
		world.func_147480_a(x, y, z, true);
		super.breakBlock(world, x, y, z, par5, par6);
		if (core != null) {
			core.onLayoutChange();
		}
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		par1World.markBlockForUpdate(par2, par3, par4);
		par1World.setLightValue(EnumSkyBlock.Block, par2, par3, par4, 14);
	}
}
