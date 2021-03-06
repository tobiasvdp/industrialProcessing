package ip.industrialProcessing.subMod.logic.old.transport.wired.cable;

import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.old.transport.ICommunication;
import ip.industrialProcessing.subMod.logic.old.transport.ICommunicationTransport;

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

public class BLlogicCable extends BlockMachineRendered {

	public BLlogicCable() {
		super(ConfigLogic.getBlockDataBusID(), Material.circuits, 5.0f, Block.soundPowderFootstep, "BLlogicCable", IPLogic.tabLogic);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

	}

	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5, ItemStack par6ItemStack) {
		TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
		if (te == null) {
			return true;
		}
		if (te instanceof ICommunicationTransport) {
			ICommunicationTransport com = (ICommunicationTransport) te;
			if (!com.hasBlockSide(par5)) {
				com.addToBlockside(par5);
			}
		}
		return false;
	}

	private boolean canSideStay(ForgeDirection dir, World par1World, int par2, int par3, int par4) {
		if (par1World.getBlockId(par2 + dir.offsetX, par3 + dir.offsetY, par4 + dir.offsetZ) == 0) {
			return false;
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicCable();
	}

	@Override
	public int getRenderType() {
		return ConfigLogic.getRDlogicCable();
	}

	@Override
	public boolean isBlockReplaceable(World world, int x, int y, int z) {
		if (world.getClosestPlayer(x, y, z, 10).getCurrentEquippedItem().getItem().itemID == ConfigLogic.getBlockDataBusID()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		return false;
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		super.onBlockPlaced(par1World, par2, par3, par4, par5, par6, par7, par8, par9);
		return par5;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		ICommunicationTransport com = (ICommunicationTransport) par1World.getBlockTileEntity(par2, par3, par4);
		com.isEnabled(true);
		com.createRecheckPacket();
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
		if (te != null) {
			ICommunicationTransport com = (ICommunicationTransport) te;
			boolean destroy = false;
			int count = 0;
			par1World.getBlockId(par2, par3, par4);
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				int side = dir.ordinal();
				if (side == 0) {
					side = 1;
				} else if (side == 1) {
					side = 0;
				}
				if (com.hasBlockSide(side)) {
					if (!this.canSideStay(dir, par1World, par2, par3, par4)) {
						destroy = true;
						com.removeFromBlockside(side);
						count++;
					}
				}
			}
			if (destroy) {
				for (int i = 0; i < count; i++) {
					this.dropBlockAsItem(par1World, par2, par3, par4, 0, 1);
				}
				System.out.println(com.getBlockSidesCount());
				if (com.getBlockSidesCount() == 0) {
					par1World.destroyBlock(par2, par3, par4, false);
				}
			}

		}
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);

	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ICommunicationTransport com = (ICommunicationTransport) world.getBlockTileEntity(x, y, z);
		com.isEnabled(false);
		com.createRecheckPacket();
		for (int i = 0; i < com.getBlockSidesCount(); i++) {
			this.dropBlockAsItem_do(world, x, y, z, new ItemStack(this));
		}
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		TileEntity te = par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
		if (te == null) {
			int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
			this.setBoundsByMetadata(meta, 0.0f, 0.0f, 0.0f, 1f, 0.0f, 1f);
		} else {
			if (te instanceof ICommunicationTransport) {
				ICommunicationTransport com = (ICommunicationTransport) te;
				if (com.hasMultipleBlockSides()) {
					this.setBlockBounds(0, 0, 0, 1.0f, 0.0f, 1.0f);
				} else {
					int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
					this.setBoundsByMetadata(meta, 0.0f, 0.0f, 0.0f, 1f, 0.0f, 1f);
				}
			}
		}
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
		ICommunication te = (ICommunication) par1World.getBlockTileEntity(par2, par3, par4);
		te.Send();
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}
}
