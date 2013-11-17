package ip.industrialProcessing.logic.network;

import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTLogicType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityLogicNetworkNode extends TElogicNode implements INetworkNode {

	@Override
	public void ExtendedReceive(UTpacket packet) {
		super.ExtendedReceive(packet);
		if (packet.getType() == UTpacketType.deliver) {
			UTVariable[] data = (UTVariable[]) packet.getData(2);
			setData(data);
		}
		if (packet.getType() == UTpacketType.request) {
			UTVariableType type = ((UTVariable[]) packet.getData(2))[0].ID;
			UTVariable[] data = getData(type);
			if (data != null) {
				createDeliverPacket((ICommunicationNode) packet.getData(1), (ICommunicationNode) packet.getData(0), data);
			}
		}
	}

	public abstract void setData(UTVariable[] data);

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
    public UTLogicType getLogicType(){
    	return UTLogicType.networkedNode;
    }

}
