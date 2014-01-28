package ip.industrialProcessing.microBlock;

import java.util.Random;

import cpw.mods.fml.common.network.PacketDispatcher;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.packets.PacketIP002SendMicroBlockDestructionChange;
import ip.industrialProcessing.utils.packets.PacketIP003ScheduleBlockUpdateToServer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class BlockMicroBlock extends BlockMachineRendered {

	public boolean isDestroying = false;

	protected BlockMicroBlock(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
		this.setBlockBounds(0, 0, 0, 1f, 1f, 1f);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			MovingObjectPosition hit = rayTroughBlock(par1World, par2, par3, par4, par5EntityPlayer);
			handleSideBlock(par1World, par5EntityPlayer, hit, 1);
		}
		return true;
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return invertSide(par5);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		handleHit(x, y, z, world.getBlockMetadata(x, y, z), (EntityPlayer) entityLivingBase, null, 1);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	}

	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		if (par1World.isRemote) {
			MovingObjectPosition hit = rayTroughBlock(par1World, par2, par3, par4, par5EntityPlayer);
			handleSideBlock(par1World, par5EntityPlayer, hit, 0);
		}
	}

	private boolean handleSideBlock(World world, EntityPlayer player, MovingObjectPosition hit, int hitType) {
		if (hit != null) {
			ForgeDirection offset = sideToForge(hit.sideHit);
			int x = hit.blockX + offset.offsetX;
			int y = hit.blockY + offset.offsetY;
			int z = hit.blockZ + offset.offsetZ;
			int blockID = world.getBlockId(x, y, z);
			if (Block.blocksList[blockID] instanceof BlockMicroBlock) {
				int invertedSide = invertSide(hit.sideHit);
				handleHit(x, y, z, invertedSide, player, hit, hitType);
			} else {
				handleMiss(hit.blockX, hit.blockY, hit.blockZ, hit.sideHit, player, hit.hitVec, x, y, z, hitType);
			}
		}
		return false;
	}

	private void handleMiss(int blockX, int blockY, int blockZ, int sideHit, EntityPlayer player, Vec3 hitVec, int x, int y, int z, int hitType) {
		if (hitType == 1)
			Minecraft.getMinecraft().playerController.onPlayerRightClick(player, player.worldObj, player.getCurrentEquippedItem(), blockX, blockY, blockZ, sideHit, hitVec);
		if (hitType == 0) {
			Minecraft.getMinecraft().playerController.clickBlock(blockX, blockY, blockZ, sideHit);
			isDestroying = true;
			PacketDispatcher.sendPacketToServer(new PacketIP003ScheduleBlockUpdateToServer(x, y, z, this.blockID, 50).getCustom250Packet());
		}
		if (hitType == 2)
			Minecraft.getMinecraft().playerController.onPlayerDestroyBlock(blockX, blockY, blockZ, 0);
	}

	private void handleHit(int x, int y, int z, int sideHit, EntityPlayer player, MovingObjectPosition hit, int hitType) {
		if (hitType == 1) {
			ItemStack itemstack = player.getCurrentEquippedItem();
			if (itemstack != null && itemstack.getItem() instanceof ItemBlock && Block.blocksList[itemstack.getItem().itemID] instanceof BlockMicroBlock) {
				TileEntity te = player.worldObj.getBlockTileEntity(x, y, z);
				if (te instanceof IMicroBlock) {
					IMicroBlock microblock = (IMicroBlock) te;
					ForgeDirection dir = sideToForge(sideHit);
					if (microblock.isSideFree(dir)) {
						microblock.setSide(dir, itemstack.getItem().itemID);
					}
				}
			}
		}
		if (hitType == 2) {
			TileEntity te = player.worldObj.getBlockTileEntity(x, y, z);
			if (te instanceof IMicroBlock) {
				IMicroBlock microblock = (IMicroBlock) te;
				ForgeDirection dir = sideToForge(sideHit);
				if (microblock.isSideFree(dir)) {
					handleMiss(hit.blockX, hit.blockY, hit.blockZ, hit.sideHit, player, hit.hitVec, x, y, z, 2);
				} else {
					microblock.unsetSide(dir,player);
				}
			}
		}
		if (hitType == 0) {
			TileEntity te = player.worldObj.getBlockTileEntity(x, y, z);
			if (te instanceof IMicroBlock) {
				IMicroBlock microblock = (IMicroBlock) te;
				ForgeDirection dir = sideToForge(sideHit);
				if (microblock.isSideFree(dir)) {
					handleMiss(hit.blockX, hit.blockY, hit.blockZ, hit.sideHit, player, hit.hitVec, x, y, z, 0);
				} else {
					microblock.unsetSide(dir,player);
				}
			}
		}
	}

	private int invertSide(int sideHit) {
		switch (sideHit) {
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 2;
		case 4:
			return 5;
		case 5:
			return 4;
		}
		return 0;
	}

	private ForgeDirection sideToForge(int sideHit) {
		switch (sideHit) {
		case 0:
			return ForgeDirection.DOWN;
		case 1:
			return ForgeDirection.UP;
		case 2:
			return ForgeDirection.NORTH;
		case 3:
			return ForgeDirection.SOUTH;
		case 4:
			return ForgeDirection.WEST;
		case 5:
			return ForgeDirection.EAST;
		}
		return ForgeDirection.UNKNOWN;
	}

	private MovingObjectPosition rayTroughBlock(World world, int par2, int par3, int par4, Entity entity) {
		this.setBlockBounds(0, 0, 0, 0, 0, 0);
		float reach = 5.0f;
		Vec3 vec3 = getPositionEntity(1.0f, entity);
		Vec3 vec31 = getLookEntity(1.0f, entity);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * reach, vec31.yCoord * reach, vec31.zCoord * reach);
		MovingObjectPosition hit = world.clip(vec3, vec32);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		return hit;
	}

	public Vec3 getPositionEntity(float par1, Entity entity) {
		if (par1 == 1.0F) {
			return entity.worldObj.getWorldVec3Pool().getVecFromPool(entity.posX, entity.posY, entity.posZ);
		} else {
			double d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double) par1;
			double d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double) par1;
			double d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) par1;
			return entity.worldObj.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
		}
	}

	public Vec3 getLookEntity(float par1, Entity entity) {
		float f1;
		float f2;
		float f3;
		float f4;

		if (par1 == 1.0F) {
			f1 = MathHelper.cos(-entity.rotationYaw * 0.017453292F - (float) Math.PI);
			f2 = MathHelper.sin(-entity.rotationYaw * 0.017453292F - (float) Math.PI);
			f3 = -MathHelper.cos(-entity.rotationPitch * 0.017453292F);
			f4 = MathHelper.sin(-entity.rotationPitch * 0.017453292F);
			return entity.worldObj.getWorldVec3Pool().getVecFromPool((double) (f2 * f3), (double) f4, (double) (f1 * f3));
		} else {
			f1 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par1;
			f2 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par1;
			f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
			f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
			float f5 = -MathHelper.cos(-f1 * 0.017453292F);
			float f6 = MathHelper.sin(-f1 * 0.017453292F);
			return entity.worldObj.getWorldVec3Pool().getVecFromPool((double) (f4 * f5), (double) f6, (double) (f3 * f5));
		}
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		boolean destroy = false;
		if (world.isRemote) {
			MovingObjectPosition hit = rayTroughBlock(world, x, y, z, player);
			destroy = handleSideBlock(world, player, hit, 2);
		}
		return destroy;
	}

	public abstract MicroBlockType getMicroBlockType();

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		if (isDestroying)
			return null;
		else
			return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if (isDestroying) {
			isDestroying = false;
		}
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (isDestroying) {
			isDestroying = false;
			PacketDispatcher.sendPacketToAllPlayers(new PacketIP002SendMicroBlockDestructionChange(this.blockID, isDestroying).getCustom250Packet());
		}
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

}
