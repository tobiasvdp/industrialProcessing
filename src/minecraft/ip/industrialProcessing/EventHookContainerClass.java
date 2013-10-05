package ip.industrialProcessing;

import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.utils.blockContainer.IBlockInBlock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class EventHookContainerClass {
	@ForgeSubscribe
	public void blockPlaced(PlayerInteractEvent event) {
		if (event.action == Action.RIGHT_CLICK_BLOCK) {
			ForgeDirection dir = ForgeDirection.getOrientation(event.face);
			TileEntity te = event.entityPlayer.worldObj.getBlockTileEntity(event.x + dir.offsetX, event.y + dir.offsetY, event.z + dir.offsetZ);
			if(event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().itemID == IndustrialProcessing.itemWrench.itemID){
				setRotation(event.entityPlayer.worldObj, event.x, event.y, event.z, event.entityPlayer);
				event.setCanceled(true);
			}
			if (te instanceof IBlockInBlock) {
				IBlockInBlock container = (IBlockInBlock) te;
				container.addBlockToContainer(dir.getOpposite());
				System.out.println(dir.getOpposite());
				event.setCanceled(true);
			}
		}
	}
	
	public static void setRotation(World world, int x, int y, int z, EntityLivingBase entityLivingBase) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if (entity instanceof IRotateableEntity) {
			setRotation((IRotateableEntity) entity, entityLivingBase);
		}
	}

	public static void setRotation(IRotateableEntity entity, EntityLivingBase entityLivingBase) {
		int dir = MathHelper.floor_double((double) ((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		IRotateableEntity machine = (IRotateableEntity) entity;
		ForgeDirection forward = getForwardFromMetadata(dir);
		if (entityLivingBase.isSneaking())
			forward = forward.getOpposite();
		machine.setForwardDirection(forward);
	}
	
	public static ForgeDirection getForwardFromMetadata(int metadata) {
		switch (metadata) {
		case 0:
			return ForgeDirection.NORTH;
		case 1:
			return ForgeDirection.EAST;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.WEST;
		}
		return null;
	}
	
	@ForgeSubscribe
	public void onBlockHighlightEvent(DrawBlockHighlightEvent evt) {
		MovingObjectPosition hitpos = evt.player.rayTrace(70D, 1.0f);
		if (hitpos != null) {
			TileEntity te = evt.player.worldObj.getBlockTileEntity(hitpos.blockX, hitpos.blockY, hitpos.blockZ);
			if (te instanceof IBlockInBlock) {
				evt.setCanceled(true);
			} else {
				ForgeDirection dir = ForgeDirection.getOrientation(hitpos.sideHit);
				te = evt.player.worldObj.getBlockTileEntity(hitpos.blockX + dir.offsetX, hitpos.blockY + dir.offsetY, hitpos.blockZ + dir.offsetZ);
				if (te instanceof IBlockInBlock) {
					evt.setCanceled(true);
				}
			}
		}
	}

	private int transformToForgeDirection(int blockMetadata) {
		switch (blockMetadata) {
		case 0:
			return 0;
		case 1:
			return 1;
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
}
