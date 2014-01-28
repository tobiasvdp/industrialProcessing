package ip.industrialProcessing.microBlock;

import ip.industrialProcessing.multiblock.IMicroBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class BlockMicroBlock extends BlockContainer {

	protected BlockMicroBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setBlockBounds(0, 0, 0, 1f, 1f, 1f);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			MovingObjectPosition hit = rayTroughBlock(par1World, par2, par3, par4, par5EntityPlayer);
			handleSideBlock(par1World, par5EntityPlayer, hit);
		}
		return true;
	}

	private void handleSideBlock(World world, EntityPlayer player, MovingObjectPosition hit) {
		if (hit != null) {
			ForgeDirection offset = sideToForge(hit.sideHit);
			int x = hit.blockX + offset.offsetX;
			int y = hit.blockY + offset.offsetY;
			int z = hit.blockZ + offset.offsetZ;
			int blockID = world.getBlockId(x, y, z);
			if (Block.blocksList[blockID] instanceof BlockMicroBlock) {
				int invertedSide = invertSide(hit.sideHit);
				handleHit(x, y, z, invertedSide, player);
			} else {
				handleMiss(hit.blockX, hit.blockY, hit.blockZ, hit.sideHit, player, hit.hitVec);
			}
		}
	}

	private void handleMiss(int blockX, int blockY, int blockZ, int sideHit, EntityPlayer player, Vec3 hitVec) {
		Minecraft.getMinecraft().playerController.onPlayerRightClick(player, player.worldObj, player.getCurrentEquippedItem(), blockX, blockY, blockZ, sideHit, hitVec);
	}

	private void handleHit(int x, int y, int z, int sideHit, EntityPlayer player) {
		ItemStack itemstack = player.getCurrentEquippedItem();
		if(itemstack != null && itemstack.getItem() instanceof ItemBlock && Block.blocksList[itemstack.getItem().itemID] instanceof BlockMicroBlock){
		TileEntity te = player.worldObj.getBlockTileEntity(x, y, z);
		if(te instanceof IMicroBlock){
			IMicroBlock microblock = (IMicroBlock) te;
			ForgeDirection dir = sideToForge(sideHit);
			if(microblock.isSideFree(dir)){
				microblock.setSide(dir, itemstack.getItem().itemID);
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

	public abstract MicroBlockType getMicroBlockType();

}
