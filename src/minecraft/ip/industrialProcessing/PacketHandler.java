package ip.industrialProcessing;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.conveyors.TileConveyorSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
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
	public static final String CONVEYOR_SYNC = "IP.ConvSync";
	public static final String TANK_SYNC = "IP.TankSync";
	public static final String BUTTON_PRESSED = "IP.ButtonPressed";
	public static final String SYNC_CLIENT = "IP.clientSync";
	public static final String SEND_INFO = "IP.sendInfo";
	public static final String SCREEN_PRESSED = "IP.ScreenPressed";
	public static final String IP_ELEVATOR_BUTTON = "IP.MB.EL.Button";
	public static final String IP_LOGIC_SYNCSIDE = "IP.Lg.SyncSide";

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(ANIMATION_SYNC)) {
			TileAnimationSyncHandler.handleAnimationSync(manager, packet, player);
		} else if (packet.channel.equals(TANK_SYNC)) {
			TileTankSyncHandler.handleTankSync(manager, packet, player);
		} else if (packet.channel.equals(BUTTON_PRESSED)) {
		} else if (packet.channel.equals(CONVEYOR_SYNC)) {
			TileConveyorSyncHandler.handleConveyorSync(manager, packet, player);
		}

		// TODO: move this away from here, please!
		if (packet.channel.equals(IP_ELEVATOR_BUTTON)) {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
			int x;
			int y;
			int z;
			int id;
			try {
				x = inputStream.readInt();
				y = inputStream.readInt();
				z = inputStream.readInt();
				id = inputStream.readInt();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			TEmultiblockToggleButton te = (TEmultiblockToggleButton) playerMP.worldObj.getBlockTileEntity(x, y, z);
			((TEmultiblockElevator) te.getCore()).gotoFloor(id);
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
		if (packet.channel.equals(SCREEN_PRESSED)) {
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

		if (packet.channel.equals(IP_LOGIC_SYNCSIDE)) {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
			int x;
			int y;
			int z;
			boolean sides[] = new boolean[6];
			try {
				x = inputStream.readInt();
				y = inputStream.readInt();
				z = inputStream.readInt();
				for (int i = 0; i < sides.length; i++) {
					sides[i] = inputStream.readBoolean();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			EntityPlayer playerMP = (EntityPlayer) player;
			ICommunicationTransport com = (ICommunicationTransport) playerMP.worldObj.getBlockTileEntity(x, y, z);
			int count = 0;
			/*
			 * for(int i = 0;i<sides.length;i++){ if(sides[i]){ count++;
			 * com.addToConnectedSides(i,false); }else{
			 * com.removeConnectedSides(i, false); } } if (count>1)
			 * com.setMultipleSides(true); else com.setMultipleSides(false);
			 */
		}
	}

}
