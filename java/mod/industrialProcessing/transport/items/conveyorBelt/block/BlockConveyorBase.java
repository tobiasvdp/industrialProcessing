package mod.industrialProcessing.transport.items.conveyorBelt.block;

import java.util.List;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorInteractionBase;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorTransportBase;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.registry.HandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockConveyorBase extends BlockContainerIPRendered {

	public BlockConveyorBase(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness, resistance, material, soundtype, iconNames);
		textureName = INamepace.TEXTURE_NAME_PREFIX + "conveyor";
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
		notifyDestroyed(par1World, par2, par3 - 1, par4);
		notifyDestroyed(par1World, par2, par3 + 1, par4);
	}

	private void notifyDestroyed(World par1World, int i, int j, int k) {
		Block block = par1World.getBlock(i, j, k);
		par1World.notifyBlockChange(i, j, k, block);
	}

	@Override
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {
		super.onBlockDestroyedByExplosion(par1World, par2, par3, par4, par5Explosion);
		notifyDestroyed(par1World, par2, par3 - 1, par4);
		notifyDestroyed(par1World, par2, par3 + 1, par4);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		TileEntityConveyorConnectionsBase conveyorBelt = (TileEntityConveyorConnectionsBase) world.getTileEntity(x, y, z);
		BlockContainerIP.setRotation(conveyorBelt, entityLivingBase);
		conveyorBelt.searchForConnections();
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		super.onEntityCollidedWithBlock(par1World, par2, par3, par4, par5Entity);
		TileEntityConveyorInteractionBase conveyorBelt = (TileEntityConveyorInteractionBase) par1World.getTileEntity(par2, par3, par4);
		if (par5Entity instanceof EntityItem) {
			EntityItem item = (EntityItem) par5Entity;
			if (!item.isDead) {
				conveyorBelt.addItemStack(item.getEntityItem(), null);
				item.setDead();
			}
		} else if (par5Entity instanceof EntityLivingBase) {
			conveyorBelt.moveEntity((EntityLivingBase) par5Entity);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {

		ItemStack playerItem = player.inventory.getCurrentItem();

		if (playerItem != null && (playerItem.getItem().equals(ISetupItems.itemHexKey))) {
			TileEntityConveyorConnectionsBase conveyorBelt = (TileEntityConveyorConnectionsBase) world.getTileEntity(x, y, z);
			conveyorBelt.toggleSlope(player);
			return false;
		}
		if (!world.isRemote) {
			TileEntityConveyorConnectionsBase conveyorBelt = (TileEntityConveyorConnectionsBase) world.getTileEntity(x, y, z);
			System.out.println(conveyorBelt.getLineID());
		}
		return false;
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityConveyorConnectionsBase conveyorBelt = (TileEntityConveyorConnectionsBase) par1World.getTileEntity(par2, par3, par4);
		conveyorBelt.searchForConnections();
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		TileEntityConveyorTransportBase cb = (TileEntityConveyorTransportBase) world.getTileEntity(x, y, z);
		cb.breakBlock();
		notifyDestroyed(world, x, y - 1, z);
		notifyDestroyed(world, x, y + 1, z);
		HandlerRegistry.removeFromConveyorLine(cb);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		TileEntityConveyorInteractionBase cb = (TileEntityConveyorInteractionBase) par1iBlockAccess.getTileEntity(par2, par3, par4);
		cb.setBounds();
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		TileEntityConveyorInteractionBase conveyorBelt = (TileEntityConveyorInteractionBase) par1World.getTileEntity(par2, par3, par4);
		conveyorBelt.addCollisionBoxes(par6List, par5AxisAlignedBB);
	}
}
