package ip.industrialProcessing.subMod.blackSmith.utils.handler;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler  implements IPacketHandler{
	
	public static final String channel = "ip.blackSmith";

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		// TODO Auto-generated method stub
		
	}
}
