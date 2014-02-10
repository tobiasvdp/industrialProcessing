package ip.industrialProcessing.utils.packets;

import ibxm.Player;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.microBlock.core.BlockMicroBlock;
import ip.industrialProcessing.utils.IProgressSync;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PacketDataHandler {
	public static void handle001EntityLocationAndRotation(Player player, PacketIP001EntityLocationAndRotation packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote && packet != null) {
			Entity entity = world.getEntityByID(packet.entityId);
			entity.setPositionAndRotation(packet.posX, packet.posY, packet.posZ, packet.rotationYaw, packet.rotationPitch);
		}
	}
	public static void handlePacketIP002SendMicroBlockDestructionChange(Player player, PacketIP002SendMicroBlockDestructionChange packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && world.isRemote && packet != null) {
			BlockMicroBlock.isDestroying = packet.isDestroying;
		}
	}
	public static void handlePacketIP003ScheduleBlockUpdateToServer(Player player, PacketIP003ScheduleBlockUpdateToServer packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote && packet != null) {
			world.scheduleBlockUpdate(packet.x, packet.y, packet.z, packet.blockID, packet.delay);
		}
	}
	public static void handlePacketIP004RayTraceToServer(Player player, PacketIP004RayTraceToServer packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote && packet != null) {
			Block block = Block.blocksList[world.getBlockId(packet.hit.blockX, packet.hit.blockY, packet.hit.blockZ)];
			ISetupBlocks.microBlock.handleSideBlock(world, (EntityPlayer) player, packet.hit, packet.hitType);
		}
	}
	public static void handlePacketIP005DestroyBlock(Player player, PacketIP005DestroyBlock packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote && packet != null) {
			world.destroyBlock(packet.x, packet.y, packet.z, packet.dropItems);
		}
	}
	public static void handlePacketIP006SyncValues(Player player, PacketIP006SyncValues packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && world.isRemote && packet != null) {
			TileEntity te = world.getBlockTileEntity(packet.x, packet.y, packet.z);
			if(te != null && te instanceof IProgressSync){
				((IProgressSync)te).setValues(packet.val);
			}
		}
	}
	
	public static TileEntity readTileEntity(DataInputStream inputStream, World worldObj) throws IOException {

		int xcoord = inputStream.readInt();
		int ycoord = inputStream.readInt();
		int zcoord = inputStream.readInt();
		return worldObj.getBlockTileEntity(xcoord, ycoord, zcoord);
	    }

	    public static void writeTileEntity(DataOutputStream outputStream, TileEntity entity) throws IOException {
		outputStream.writeInt(entity.xCoord);
		outputStream.writeInt(entity.yCoord);
		outputStream.writeInt(entity.zCoord);
	    }

	    public static Packet250CustomPayload getCustomPacket(ByteArrayOutputStream bos, String channel) {
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = channel;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		return packet;
	    }
}
