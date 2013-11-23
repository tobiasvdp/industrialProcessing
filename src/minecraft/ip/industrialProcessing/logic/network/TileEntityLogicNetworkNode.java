package ip.industrialProcessing.logic.network;

import ip.industrialProcessing.api.info.InfoMachine;
import ip.industrialProcessing.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBufferType;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTLogicType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityLogicNetworkNode extends TElogicNode implements INetworkNode {

	public boolean isLoaded = false;
	
	public TileEntityLogicNetworkNode() {
		super();
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			buffer[dir.ordinal()] = new UTBuffer(UTBufferType.collection);
		}
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		super.ExtendedReceive(packet);
		if(!isLoaded){
			for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
				for(int i =0;i<nodeCollection[dir.ordinal()].getSize();i++){
					addToBuffer(nodeCollection[dir.ordinal()].getNode(i), buffer[dir.ordinal()]);
				}
			}
			isLoaded = true;
		}
		if (packet.getType() == UTpacketType.deliver) {
			UTVariable[] data = (UTVariable[]) packet.getData(2);
			setData(data, (ICommunicationNode) packet.getData(1));
		}
		if (packet.getType() == UTpacketType.request) {
			UTVariableType type = ((UTVariable[]) packet.getData(2))[0].ID;
			UTVariable[] data = getData(type);
			if (data != null) {
				createDeliverPacket((ICommunicationNode) packet.getData(1), (ICommunicationNode) packet.getData(0), data);
			}
		}
	}

	public abstract void setData(UTVariable[] data, ICommunicationNode node);

	public abstract UTVariable[] getData(UTVariableType type);

	@Override
	public void ExtendedSend(UTpacket packet) {
		super.ExtendedSend(packet);
		if (packet.getType() == UTpacketType.deliver) {
			ICommunicationNode com = (ICommunicationNode) packet.getData(0);
			com.Receive(packet);
		}
		if (packet.getType() == UTpacketType.request) {
			ICommunicationNode com = (ICommunicationNode) packet.getData(0);
			com.Receive(packet);
		}
	}

	@Override
	public void createDeliverPacket(ICommunicationNode dest, ICommunicationNode origin, UTVariable... data) {
		packets.add(new UTpacket(UTpacketType.deliver, dest, origin, data));
		this.scheduleSend();
	}

	@Override
	public void createRequestPacket(ICommunicationNode dest, ICommunicationNode origin, UTVariable... data) {
		packets.add(new UTpacket(UTpacketType.request, dest, origin, data));
		this.scheduleSend();
	}

	public void sendToAll() {
		for (ForgeDirection dir : getConnectableOutputSides()) {
			UTlogicNodeContainer container = getConnectionsOnSide(getExternalForgeDirection(dir));
			for (ICommunicationNode node : container.iterate()) {
				createRequestPacket(node, this, new UTVariable(UTVariableType.power));
				System.out.println("send packet to " + node);
			}
		}
	}

	@Override
	public UTLogicType getLogicType() {
		return UTLogicType.networkedNode;
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide) {
		if (!this.nodeCollection[side.ordinal()].contains(node)) {
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
			addToBuffer(node, this.buffer[side.ordinal()]);
		}
	}
	
	public void fillBufferFromNodelist(){
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			UTBuffer buffer = this.buffer[dir.ordinal()];
			UTlogicNodeContainer container = nodeCollection[dir.ordinal()];
			buffer.clear();
			for(int i =0;i<container.getSize();i++){
				ICommunicationNode node = container.getNode(i);
				addToBuffer(node, buffer);
			}
		}
	}
	
	protected void addToBuffer(ICommunicationNode node, UTBuffer buffer) {
		switch (node.getLogicType()) {
		case gate:
			break;
		case interfaces:
			InfoMachine machine = new InfoMachine();
			machine.status = StatusType.active;
			buffer.add(0, UTVariableType.machine, machine);
			break;
		case networkedNode:
			break;
		case node:
			break;
		case transport:
			break;
		default:
			buffer.add(0, UTVariableType.unknown, new UTBuffer(UTBufferType.Integer));
			break;

		}
	}
}
