package ip.industrialProcessing.subMod.logic.network;

import ip.industrialProcessing.gui.container.syncing.info.InfoMachine;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.subMod.logic.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.transport.TElogicNode;
import ip.industrialProcessing.subMod.logic.utils.UTBuffer;
import ip.industrialProcessing.subMod.logic.utils.UTBufferType;
import ip.industrialProcessing.subMod.logic.utils.UTLogicType;
import ip.industrialProcessing.subMod.logic.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.utils.UTVariableType;
import ip.industrialProcessing.subMod.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.subMod.logic.utils.UTpacket;
import ip.industrialProcessing.subMod.logic.utils.UTpacketType;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityLogicNetworkNode extends TElogicNode implements INetworkNode {

	public boolean isLoaded = false;

	public TileEntityLogicNetworkNode() {
		super();
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			this.buffer[dir.ordinal()] = new UTBuffer(UTBufferType.collection);
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

	@Override
	public void createDeliverPacket(ICommunicationNode dest, ICommunicationNode origin, UTVariable... data) {
		this.packets.add(new UTpacket(UTpacketType.deliver, dest, origin, data));
		this.scheduleSend();
	}

	@Override
	public void createRequestPacket(ICommunicationNode dest, ICommunicationNode origin, UTVariable... data) {
		this.packets.add(new UTpacket(UTpacketType.request, dest, origin, data));
		this.scheduleSend();
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		super.ExtendedReceive(packet);
		if (!this.isLoaded) {
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				for (int i = 0; i < this.nodeCollection[dir.ordinal()].getSize(); i++) {
					this.addToBuffer(this.nodeCollection[dir.ordinal()].getNode(i), this.buffer[dir.ordinal()]);
				}
			}
			this.isLoaded = true;
		}
		if (packet.getType() == UTpacketType.deliver) {
			UTVariable[] data = (UTVariable[]) packet.getData(2);
			this.setData(data, (ICommunicationNode) packet.getData(1));
		}
		if (packet.getType() == UTpacketType.request) {
			UTVariableType type = ((UTVariable[]) packet.getData(2))[0].ID;
			UTVariable[] data = this.getData(type);
			if (data != null) {
				this.createDeliverPacket((ICommunicationNode) packet.getData(1), (ICommunicationNode) packet.getData(0), data);
			}
		}
	}

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

	public void fillBufferFromNodelist() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			UTBuffer buffer = this.buffer[dir.ordinal()];
			UTlogicNodeContainer container = this.nodeCollection[dir.ordinal()];
			buffer.clear();
			for (int i = 0; i < container.getSize(); i++) {
				ICommunicationNode node = container.getNode(i);
				this.addToBuffer(node, buffer);
			}
		}
	}

	public abstract UTVariable[] getData(UTVariableType type);

	@Override
	public UTLogicType getLogicType() {
		return UTLogicType.networkedNode;
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide) {
		if (!this.nodeCollection[side.ordinal()].contains(node)) {
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
			this.addToBuffer(node, this.buffer[side.ordinal()]);
		}
	}

	public void sendToAll() {
		for (ForgeDirection dir : this.getConnectableOutputSides()) {
			UTlogicNodeContainer container = this.getConnectionsOnSide(this.getExternalForgeDirection(dir));
			for (ICommunicationNode node : container.iterate()) {
				this.createRequestPacket(node, this, new UTVariable(UTVariableType.power));
				System.out.println("send packet to " + node);
			}
		}
	}

	public abstract void setData(UTVariable[] data, ICommunicationNode node);
}
