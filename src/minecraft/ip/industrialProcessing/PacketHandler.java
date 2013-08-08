package ip.industrialProcessing;

import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.packetHandlers.TileSyncHandler;
import ip.industrialProcessing.utils.working.IWorkSyncable;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public static final String WORK_SYNC = "IP.WorkSyncable";

	public PacketHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals("IP.WorkSyncable")) {
			TileSyncHandler.handleWorkSync(manager, packet, player);
		}

	}
}
