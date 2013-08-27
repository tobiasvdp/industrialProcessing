package ip.industrialProcessing;

import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.packetHandlers.TileSyncHandler; 

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public static final String ANIMATION_SYNC = "IP.AniSync";
	public static final String BUTTON_PRESSED = "IP.ButtonPressed";
	public static final String SYNC_CLIENT = "IP.clientSync";
	public static final String SEND_INFO = "IP.sendInfo";
	public static final String SCREEN_PRESSED = "IP.ScreenPressed";

	public PacketHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) { 
		if (packet.channel.equals("IP.WorkSyncable")) {
			TileSyncHandler.handleAnimationSync(manager, packet, player);
		}
		if (packet.channel.equals(BUTTON_PRESSED)) {
		}  
		if (packet.channel.equals(SYNC_CLIENT)) {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
			int x;
			int y;
			int z;

			try {
				x = inputStream.readInt();
				y = inputStream.readInt();
				z = inputStream.readInt();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			TileEntity te = playerMP.worldObj.getBlockTileEntity(x, y, z);
			te.worldObj.markBlockForUpdate(x, y, z);
		}  
		if(packet.channel.equals(SCREEN_PRESSED)){
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
			int screenID;
			int x;
			int y;
			int z;

			try {
				screenID = inputStream.readInt();
				x = inputStream.readInt();
				y = inputStream.readInt();
				z = inputStream.readInt();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			EntityPlayer playerMP = (EntityPlayer) player;
			playerMP.openGui(IndustrialProcessing.instance, screenID, playerMP.worldObj, x, y, z);
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
	
	 public static void send(String cmd, NBTTagCompound data) {
	        NBTTagCompound nbt = new NBTTagCompound();


	        nbt.setString("cmd", cmd);
	        nbt.setTag("data", data);


	        try {
	            Packet250CustomPayload pkt = new Packet250CustomPayload(SEND_INFO, CompressedStreamTools.compress(nbt));
	            PacketDispatcher.sendPacketToServer(pkt);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
