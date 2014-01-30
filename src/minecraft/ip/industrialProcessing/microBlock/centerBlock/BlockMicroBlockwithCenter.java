package ip.industrialProcessing.microBlock.centerBlock;

import java.util.List;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import ip.industrialProcessing.microBlock.BlockMicroBlock;
import ip.industrialProcessing.utils.packets.PacketIP004RayTraceToServer;
import ip.industrialProcessing.utils.registry.MicroBlockRegistry;

public abstract class BlockMicroBlockwithCenter extends BlockMicroBlock {

	protected BlockMicroBlockwithCenter(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
		if (te instanceof TileEntityMicroBlockwithCenter) {
			IMicroBlockCore microblock = (IMicroBlockCore) te;
			if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock) {
				Block block = Block.blocksList[par5EntityPlayer.getCurrentEquippedItem().getItem().itemID];
				if (block != null && (block instanceof BlockMicroBlockwithCenter || !(block instanceof BlockMicroBlock))) {
					return false;
				}
			}
			return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
		} else {
			return false;
		}
	}

	@Override
	public MovingObjectPosition rayTroughBlock(World world, int par2, int par3, int par4, Entity entity) {

		TileEntity te = world.getBlockTileEntity(par2, par3, par4);
		if (te instanceof TileEntityMicroBlockwithCenter) {
			IMicroBlockCore microblock = (IMicroBlockCore) te;
			if (((EntityPlayer) entity).getCurrentEquippedItem() != null && ((EntityPlayer) entity).getCurrentEquippedItem().getItem() instanceof ItemBlock) {
				Block block = Block.blocksList[((EntityPlayer) entity).getCurrentEquippedItem().getItem().itemID];
				if (block != null && block instanceof BlockMicroBlock) {
					MicroBlockRegistry.setBounds(false);
				}
			}
		}

		float reach = 5.0f;
		Vec3 vec3 = getPositionEntity(1.0f, entity);
		Vec3 vec31 = getLookEntity(1.0f, entity);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * reach, vec31.yCoord * reach, vec31.zCoord * reach);
		MovingObjectPosition hit = world.clip(vec3, vec32);

		MicroBlockRegistry.setBounds(true);

		return hit;
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		isDestroying = false;
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
			AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);

			if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
				par6List.add(axisalignedbb1);
			}
	}

	@Override
	protected void handleMiss(int blockX, int blockY, int blockZ, int sideHit, EntityPlayer player, Vec3 hitVec, int x, int y, int z, int hitType) {
		TileEntity te = player.worldObj.getBlockTileEntity(blockX, blockY, blockZ);
		if (te instanceof IMicroBlockCore) {
			IMicroBlockCore microTe = (IMicroBlockCore) te;
			if (microTe.countSetSides() == 0) {
				microTe.destroyBlock(player);
			}
		} else {
			te = player.worldObj.getBlockTileEntity(x, y, z);
			if (te instanceof IMicroBlockCore) {
				IMicroBlockCore microTe = (IMicroBlockCore) te;
				if (microTe.countSetSides() == 0) {
					microTe.destroyBlock(player);
				}
			}
		}
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		boolean destroy = false;
		if (world.isRemote) {
			MovingObjectPosition hit = rayTroughBlock(world, x, y, z, player);
			if (hit != null) {
				PacketDispatcher.sendPacketToServer(new PacketIP004RayTraceToServer(hit, 2).getCustom250Packet());
			}
		}
		return destroy;
	}

}
