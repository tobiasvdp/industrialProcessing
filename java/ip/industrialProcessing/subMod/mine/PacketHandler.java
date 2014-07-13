package ip.industrialProcessing.subMod.mine;

import ibxm.Player;
import ip.industrialProcessing.utils.BlockBreaker;
import ip.industrialProcessing.utils.packets.PacketDataHandler;
import ip.industrialProcessing.utils.packets.PacketIP001EntityLocationAndRotation;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.entity.Entity;

public class PacketHandler implements IPacketHandler {

	public static final String channel = "ip.mine";
	public static final String destroyBlock = "ip.mine.destr";
	public static final String move = "ip.mine.mov";

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(destroyBlock)) {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

			ArrayList<int[]> blocks = new ArrayList<int[]>();

			try {
				int size = inputStream.readInt();
				for (int i = 0; i < size; i++) {
					blocks.add(new int[] { inputStream.readInt(), inputStream.readInt(), inputStream.readInt() });
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println("broken blocks");
			BlockBreaker.breakBlocks(((Entity) player).worldObj, blocks);

		}
		if(packet.channel.equals(move)){
			PacketDataHandler.handle001EntityLocationAndRotation(player, PacketIP001EntityLocationAndRotation.getPacketFromCustom250packet(packet));
		}
	}

}
