package ip.industrialProcessing.logic.utils;

import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public class UTsendDiscoveryPacket {
	private ForgeDirection receivingSide;
	private ForgeDirection sendingSide;
	private ArrayList<ICommunicationTransport> path;
	private ICommunicationNode node;
	private ForgeDirection side;
	public UTsendDiscoveryPacket(ForgeDirection receivingSide, ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		this.receivingSide = receivingSide;
		this.sendingSide = sendingSide;;
		this.path = path;
		this.node = node;
		this.side = side;
	}
	public ForgeDirection getReceivingSide() {
		return receivingSide;
	}
	public ForgeDirection getSendingSide() {
		return sendingSide;
	}
	public ArrayList<ICommunicationTransport> getPath() {
		return path;
	}
	public ICommunicationNode getNode() {
		return node;
	}
	public ForgeDirection getSide() {
		return side;
	}

}
