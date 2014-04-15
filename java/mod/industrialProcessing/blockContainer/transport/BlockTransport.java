package mod.industrialProcessing.blockContainer.transport;

import java.util.List;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockTransport extends BlockContainerIPRendered {

	public BlockTransport(float hardness, float resistance, Material material, SoundType soundtype) {
		super(hardness, resistance, material, soundtype);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		TileEntity entity = par1World.getTileEntity(par2, par3, par4);
		TileEntityTransport transport = (TileEntityTransport) entity;
		transport.searchForConnections();
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityTransport transport = (TileEntityTransport) par1World.getTileEntity(par2, par3, par4);
		transport.searchForConnections();
	}

	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		TileEntityTransport entity = (TileEntityTransport) par1iBlockAccess.getTileEntity(par2, par3, par4);
		entity.setBounds();
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		TileEntityTransport entity = (TileEntityTransport) par1World.getTileEntity(par2, par3, par4);
		entity.addCollisionBoxesToList(par5AxisAlignedBB, par6List, par7Entity);
	}

	@Override
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0, 0, 0, 1, 1, 1);
	}
}
