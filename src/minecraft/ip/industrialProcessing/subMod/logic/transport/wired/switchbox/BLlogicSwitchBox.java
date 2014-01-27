package ip.industrialProcessing.subMod.logic.transport.wired.switchbox;

import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BLlogicSwitchBox extends BlockMachineRendered {

	public BLlogicSwitchBox() {
		super(ConfigLogic.getBLlogicSwitchBox(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLlogicSwitchBox", IPLogic.tabLogic);
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicSwitchBox();
	}

	@Override
	public int getRenderType() {
		return ConfigLogic.getRDlogicSwitchBox();
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		par1World.getBlockTileEntity(par2, par3, par4);

		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

		}
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		super.onBlockPlaced(par1World, par2, par3, par4, par5, par6, par7, par8, par9);
		return par5;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		par1World.getBlockTileEntity(par2, par3, par4);
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		world.getBlockTileEntity(x, y, z);
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		this.setBoundsByMetadata(meta, 0.2f, 0.0f, 0.2f, 0.8f, 0.4f, 0.8f);
	}

	private void setBoundsByMetadata(int metadata, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		switch (metadata) {
		case 0:
			this.setBlockBounds(minX, 1.0f - maxY, minZ, maxX, 1.0f - minY, maxZ);
			break;
		case 1:
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
			break;
		case 2:
			this.setBlockBounds(minX, minZ, 1.0f - maxY, maxX, maxZ, 1.0f - minY);
			break;
		case 3:
			this.setBlockBounds(minX, minZ, minY, maxX, maxZ, maxY);
			break;
		case 4:
			this.setBlockBounds(1.0f - maxY, minX, minZ, 1.0f - minY, maxX, maxZ);
			break;
		case 5:
			this.setBlockBounds(minY, minX, minZ, maxY, maxX, maxZ);
			break;
		default:
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		System.out.println("ticked " + par1World + " " + par1World.getTotalWorldTime());
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

}
