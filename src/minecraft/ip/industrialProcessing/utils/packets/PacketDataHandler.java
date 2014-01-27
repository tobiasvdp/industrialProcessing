package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.subMod.mine.PacketHandler;

import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.Player;

public class PacketDataHandler {
    public static void handle001EntityLocationAndRotation(Player player, PacketIP001EntityLocationAndRotation packet) {
	World world = ((Entity) player).worldObj;
	if (world != null && !world.isRemote && packet != null) {
	    Entity entity = world.getEntityByID(packet.entityId);
	    entity.setPositionAndRotation(packet.posX, packet.posY, packet.posZ, packet.rotationYaw,packet.rotationPitch);
	}
    }
}
