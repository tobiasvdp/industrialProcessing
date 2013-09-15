package ip.industrialProcessing.transport.items.conveyorBelt;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorBelt extends BlockMachineRendered {

	public BlockConveyorBelt() {
		super(ConfigMachineBlocks.getBLtransportConveyorBelt(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor", IndustrialProcessing.tabPower);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityConveyorBelt();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLtransportConveyorBelt();
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
		notifyDestroyed(par1World, par2, par3 - 1, par4);
		notifyDestroyed(par1World, par2, par3 + 1, par4);
	}

	private void notifyDestroyed(World par1World, int i, int j, int k) { 
		int id = par1World.getBlockId(i, j, k);
		par1World.notifyBlockChange(i, j, k, id);
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
		TileEntityConveyorBelt conveyorBelt = (TileEntityConveyorBelt) world.getBlockTileEntity(x, y, z);
		BlockMachine.setRotation(conveyorBelt, entityLivingBase);
		conveyorBelt.searchForConnections();
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		// TODO Auto-generated method stub
		super.onEntityCollidedWithBlock(par1World, par2, par3, par4, par5Entity);
		TileEntityConveyorBelt conveyorBelt = (TileEntityConveyorBelt) par1World.getBlockTileEntity(par2, par3, par4);
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

		if (!player.isSneaking()) {
			TileEntityConveyorBelt conveyorBelt = (TileEntityConveyorBelt) world.getBlockTileEntity(x, y, z);
			conveyorBelt.toggleSlope();
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityConveyorBelt conveyorBelt = (TileEntityConveyorBelt) par1World.getBlockTileEntity(par2, par3, par4);
		conveyorBelt.searchForConnections();
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		TileEntityConveyorBelt cb = (TileEntityConveyorBelt) par1iBlockAccess.getBlockTileEntity(par2, par3, par4);
		cb.setBounds();
//		super.setBlockBoundsBasedOnState(par1iBlockAccess, par2, par3, par4);
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		// super.addCollisionBoxesToList(par1World, par2, par3, par4,
		// par5AxisAlignedBB, par6List, par7Entity);

		TileEntityConveyorBelt conveyorBelt = (TileEntityConveyorBelt) par1World.getBlockTileEntity(par2, par3, par4);
		conveyorBelt.addCollisionBoxes(par6List, par5AxisAlignedBB);
	}
}
