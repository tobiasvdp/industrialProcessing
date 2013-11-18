package ip.industrialProcessing.logic;

import ip.industrialProcessing.api.info.IExpirable;
import ip.industrialProcessing.api.info.InfoMachine;
import ip.industrialProcessing.logic.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.logic.network.display.GuiLogicDisplay;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public static final String channel = "ip.logic";
	public static final String channelStoC = "ip.logic.StoC";
	public static final String DISPLAY_GET_NODES = "ip.logic.dNode";
	public static final String DISPLAY_GET_DATA = "ip.logic.dData";

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if (packet.channel == DISPLAY_GET_NODES) {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
			EntityPlayer playerMP = (EntityPlayer) player;
			if (!playerMP.worldObj.isRemote) {
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
				try {
					ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
					DataOutputStream outputStream = new DataOutputStream(bos);
					TElogicNode te = (TElogicNode) playerMP.worldObj.getBlockTileEntity(x, y, z);

					for (ICommunicationNode node : te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).iterate()) {
						TileEntity teNode = (TileEntity) node;
						outputStream.writeInt(teNode.xCoord);
						outputStream.writeInt(teNode.yCoord);
						outputStream.writeInt(teNode.zCoord);
					}

					Packet250CustomPayload packetSend = new Packet250CustomPayload();
					packetSend.channel = PacketHandler.DISPLAY_GET_NODES;
					packetSend.data = bos.toByteArray();
					packetSend.length = bos.size();

					PacketDispatcher.sendPacketToPlayer(packetSend, player);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				EntityClientPlayerMP client = (EntityClientPlayerMP) player;
				GuiScreen screen = Minecraft.getMinecraft().currentScreen;
				if (screen instanceof GuiLogicDisplay) {
					GuiLogicDisplay guiLogicDisplay = (GuiLogicDisplay) screen;

					try {
						for (int i = 0; inputStream.available() >= 0; i++) {
							int x = inputStream.readInt();
							int y = inputStream.readInt();
							int z = inputStream.readInt();
							ICommunicationNode te = (ICommunicationNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							guiLogicDisplay.addNode(te);
						}

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						guiLogicDisplay.drawTabbedNodes();
					}
				}
			}
		}
		else 	if (packet.channel == DISPLAY_GET_DATA) {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
			EntityPlayer playerMP = (EntityPlayer) player;
			if (!playerMP.worldObj.isRemote) {
				int x;
				int y;
				int z;
				int node;
				UTVariableType type;
				try {
					x = inputStream.readInt();
					y = inputStream.readInt();
					z = inputStream.readInt();
					node = inputStream.readInt();
					type = UTVariableType.values()[inputStream.readInt()];
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
				try {
					ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
					DataOutputStream outputStream = new DataOutputStream(bos);
					TElogicNode te = (TElogicNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
					
					outputStream.writeInt(node);
					outputStream.writeInt(type.ordinal());
					
					UTBuffer buffer = te.getBuffer(ForgeDirection.NORTH);
					switch(buffer.get(node).ID){
					case machine:
						switch(type){
						case status:
							outputStream.writeInt(((InfoMachine)buffer.get(node).value).status.ordinal());
							if(((InfoMachine)buffer.get(node).value).isExpired()){
							    TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							    ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
							    tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.status));
							}
							break;
						case power:
							outputStream.writeInt(((InfoMachine)buffer.get(node).value).power.powerCapacity);
							outputStream.writeInt(((InfoMachine)buffer.get(node).value).power.storedPower);
							if(((InfoMachine)buffer.get(node).value).power.isExpired()){
							    TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							    ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
							    tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.power));
							}
							break;
						case work:
							outputStream.writeInt(((InfoMachine)buffer.get(node).value).worker.totalWork);
							outputStream.writeInt(((InfoMachine)buffer.get(node).value).worker.workDone);
							if(((InfoMachine)buffer.get(node).value).worker.isExpired()){
							    TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							    ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
							    tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.work));
							}
							break;
						default:
							break;
						}
						break;
					default:
						break;
					}
							


					Packet250CustomPayload packetSend = new Packet250CustomPayload();
					packetSend.channel = PacketHandler.DISPLAY_GET_DATA;
					packetSend.data = bos.toByteArray();
					packetSend.length = bos.size();

					PacketDispatcher.sendPacketToPlayer(packetSend, player);
				} catch (Exception ex) {
				}
			} else {
				EntityClientPlayerMP client = (EntityClientPlayerMP) player;
				GuiScreen screen = Minecraft.getMinecraft().currentScreen;
				if (screen instanceof GuiLogicDisplay) {
					GuiLogicDisplay guiLogicDisplay = (GuiLogicDisplay) screen;
					int node =0;
					UTVariableType type = UTVariableType.unknown;
					ArrayList<Integer> value = new ArrayList<Integer>();
					try {
						node = inputStream.readInt();
						type = UTVariableType.values()[inputStream.readInt()];
						while(true){
							value.add(inputStream.readInt());
						}

					} catch (IOException e) {
					} finally {
					    int[] values = new int[value.size()];
					    	for(int i =0;i<value.size();i++){
					    	    values[i] = value.get(i);
					    	}
						guiLogicDisplay.setData(node, type, values);
					}
				}
			}
		}
	}

}
