package ip.industrialProcessing.logic;

import ip.industrialProcessing.api.info.IExpirable;
import ip.industrialProcessing.api.info.InfoMachine;
import ip.industrialProcessing.api.info.InfoSlot;
import ip.industrialProcessing.api.info.InfoTank;
import ip.industrialProcessing.logic.api.network.interfaces.InterfaceType;
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
		} else if (packet.channel == DISPLAY_GET_DATA) {
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
					if (node >= buffer.size() || buffer.get(node) == null) {
						TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
						tile.fillBufferFromNodelist();
					}
					switch (buffer.get(node).ID) {
					case machine:
						switch (type) {
						case status:
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).status.ordinal());
							if (((InfoMachine) buffer.get(node).value).isExpired()) {
								TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
								ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
								tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.status));
							}
							break;
						case power:
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).power.powerCapacity);
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).power.storedPower);
							if (((InfoMachine) buffer.get(node).value).power.isExpired()) {
								TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
								ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
								tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.power));
							}
							break;
						case work:
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).worker.totalWork);
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).worker.workDone);
							if (((InfoMachine) buffer.get(node).value).worker.isExpired()) {
								TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
								ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
								tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.work));
							}
							break;
						case tank:
							boolean expired = false;
							InfoMachine machine = ((InfoMachine) buffer.get(node).value);
							for (int i = 0; i < machine.tanks.size(); i++) {
								InfoTank tank = machine.getOrSetTank(i);
								outputStream.writeInt(tank.amount);
								outputStream.writeInt(tank.capacity);
								outputStream.writeInt(tank.fluidId);
								if (tank.isExpired()) {
									expired = true;
								}
							}
							if (expired || machine.tanks.size() == 0) {
								TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
								ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
								tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.tank));
							}
							break;
						case slot:
							boolean expired2 = false;
							InfoMachine machine2 = ((InfoMachine) buffer.get(node).value);
							for (int i = 0; i < machine2.slots.size(); i++) {
								InfoSlot slot = machine2.getOrSetSlot(i);
								outputStream.writeInt(slot.amount);
								outputStream.writeInt(slot.damage);
								outputStream.writeInt(slot.id);
								if (slot.isExpired()) {
									expired2 = true;
								}
							}
							if (expired2 || machine2.slots.size() == 0) {
								TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
								ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
								tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.slot));
							}
							break;
						case name:
							InfoMachine machine3 = ((InfoMachine) buffer.get(node).value);
							String name = machine3.name;
							if (name != null) {
								for (int i = 0; i < name.length(); i++)
									outputStream.writeInt(name.charAt(i));
							}
							TileEntityLogicNetworkNode tile2 = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							ICommunicationNode nodeCom2 = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
							tile2.createRequestPacket(nodeCom2, tile2, new UTVariable(UTVariableType.name));
							break;
						case coord:
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).x);
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).y);
							outputStream.writeInt(((InfoMachine) buffer.get(node).value).z);
							TileEntityLogicNetworkNode tile = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							ICommunicationNode nodeCom = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
							tile.createRequestPacket(nodeCom, tile, new UTVariable(UTVariableType.coord));
							break;
						case interfaceTypes:
							InfoMachine machine4 = ((InfoMachine) buffer.get(node).value);
							if (machine4.interfaceTypes != null) {
								for (InterfaceType interfaceType : machine4.interfaceTypes) {
									outputStream.writeInt(interfaceType.ordinal());
								}
							}
							TileEntityLogicNetworkNode tile3 = (TileEntityLogicNetworkNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
							ICommunicationNode nodeCom3 = te.getConnectionsOnSide(te.getExternalForgeDirection(ForgeDirection.NORTH)).getNode(node);
							tile3.createRequestPacket(nodeCom3, tile3, new UTVariable(UTVariableType.interfaceTypes));
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
					int node = 0;
					UTVariableType type = UTVariableType.unknown;
					ArrayList<Integer> value = new ArrayList<Integer>();
					try {
						node = inputStream.readInt();
						type = UTVariableType.values()[inputStream.readInt()];
						while (true) {
							value.add(inputStream.readInt());
						}

					} catch (IOException e) {
					} finally {
						int[] values = new int[value.size()];
						for (int i = 0; i < value.size(); i++) {
							values[i] = value.get(i);
						}
						guiLogicDisplay.setData(node, type, values);
					}
				}
			}
		}
	}

}
