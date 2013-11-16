package ip.industrialProcessing.logic;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.logic.network.display.GuiLogicDisplay;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.gui.MinecraftServerGui;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.network.ForgeNetworkHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public static final String channel = "ip.logic";
	public static final String channelStoC = "ip.logic.StoC";
	public static final String DISPLAY_GET_NODES = "ip.logic.dnode";

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
				System.out.println("got it on client");
				EntityClientPlayerMP client = (EntityClientPlayerMP)player;
				GuiScreen screen  = Minecraft.getMinecraft().currentScreen;
				if (screen instanceof GuiLogicDisplay){
					GuiLogicDisplay guiLogicDisplay = (GuiLogicDisplay) screen;
	
				try {
					for (int i = 0; inputStream.available() >= 0; i++) {
						int x = inputStream.readInt();
						int y = inputStream.readInt();
						int z = inputStream.readInt();				
						ICommunicationNode te = (ICommunicationNode) playerMP.worldObj.getBlockTileEntity(x, y, z);
						guiLogicDisplay.addNode(te);
					}
					guiLogicDisplay.drawTabbedNodes();
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
				}
			}
		}
	}

}
