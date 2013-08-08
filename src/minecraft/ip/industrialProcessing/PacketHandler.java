package ip.industrialProcessing;

import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.packetHandlers.TileSyncHandler; 

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public static final String ANIMATION_SYNC = "IP.AniSync";

	public PacketHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) { 
		if (packet.channel.equals("IP.WorkSyncable")) {
			TileSyncHandler.handleAnimationSync(manager, packet, player);
		}  
	}

	public static void sendCustomPacket(ByteArrayOutputStream bos, String name) {

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = name;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToAllPlayers(packet);

		System.out.println("Writing " + bos.size() + " bytes to " + name);
	}

	public static void sendPacket(Packet packet) {
		System.out.println("Sending "+packet.toString()+" to all players");
		PacketDispatcher.sendPacketToAllPlayers(packet);
	}
}
