package ip.industrialProcessing.logic.transport.wired.cable;

import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicCable extends BlockContainer {

	public BLlogicCable(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicCable();
	}
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
		ICommunicationTransport com = (ICommunicationTransport) par1World.getBlockTileEntity(par2, par3, par4);
		com.isEnabled(true);
		com.requestRecheck();
	}
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
		ICommunicationTransport com = (ICommunicationTransport) par1World.getBlockTileEntity(par2, par3, par4);
		com.isEnabled(false);
		com.requestRecheck();
	}

}
