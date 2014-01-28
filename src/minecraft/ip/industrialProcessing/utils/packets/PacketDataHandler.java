package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.microBlock.BlockMicroBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.Player;

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
			((BlockMicroBlock)Block.blocksList[packet.blockID]).isDestroying = packet.isDestroying;
		}
	}
	public static void handlePacketIP003ScheduleBlockUpdateToServer(Player player, PacketIP003ScheduleBlockUpdateToServer packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote && packet != null) {
			world.scheduleBlockUpdate(packet.x, packet.y, packet.z, packet.blockID, packet.delay);
		}
	}
	public static void handlePacketIP005DestroyBlock(Player player, PacketIP005DestroyBlock packet) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote && packet != null) {
			world.destroyBlock(packet.x, packet.y, packet.z, packet.dropItems);
		}
	}
}
