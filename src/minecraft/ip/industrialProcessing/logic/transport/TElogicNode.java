package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicNode extends TileEntity implements ICommunicationNode{

	private UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	private UTBuffer[] buffer = new UTBuffer[6];
	public String name;
	private int placedSide = 0;
	private boolean init = true;

	public TElogicNode() {
		for (int i = 0; i < 6; i++) {
			nodeCollection[i] = new UTlogicNodeContainer();
			buffer[i] = new UTBuffer(UTBusType.bus);
		}
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(init){
			placedSide = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			init = false;
		}
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if (node != null) {
			this.registerNode(receivedSide, node, side);
			node.registerNode(side, this, receivedSide);
		} else {
			sendDiscoveryPacket(receivedSide);
		}
	}

	@Override
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side) {
		return this.nodeCollection[side.ordinal()];
	}

	@Override
	public void sendDiscoveryPacket(ForgeDirection sendingSide) {
		nodeCollection[sendingSide.ordinal()].clear();
		TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
		if (te instanceof ICommunication) {
			ICommunication com = (ICommunication) te;
			buffer[sendingSide.ordinal()] = new UTBuffer(com.getBusType());
			com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), new ArrayList<ICommunicationTransport>(), this, sendingSide);
		}
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide) {
		if (!this.nodeCollection[side.ordinal()].contains(node)) {
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
		}
	}

	@Override
	public void removeNode(ICommunicationNode node) {
		for (UTlogicNodeContainer sideContainer : this.nodeCollection) {
			sideContainer.remove(node);
		}
	}

	@Override
	public void sendDestructionPacket() {
		for (UTlogicNodeContainer sideContainer : this.nodeCollection) {
			sideContainer.notifyOfRemoval(this);
		}
	}

	@Override
	public void sendDiscoveryPacket() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			this.sendDiscoveryPacket(dir);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void createRandomName() {
		name = UUID.randomUUID().toString();
	}

	@Override
	public UTBusType getBusType(ForgeDirection side) {
		TileEntity te = worldObj.getBlockTileEntity(xCoord + side.offsetX, yCoord + side.offsetY, zCoord + side.offsetZ);
		if (te instanceof ICommunicationNode) {
			return UTBusType.bus;
		} else if (te instanceof ICommunicationTransport) {
			ICommunicationTransport com = (ICommunicationTransport) te;
			return com.getBusType();
		}
		return UTBusType.invalid;
	}

	@Override
	public boolean send(ForgeDirection side, boolean value) {
		buffer[side.ordinal()].put(0, value);
		if (getBusType(side) == UTBusType.cable) {
			for (int i = 0; i < nodeCollection[side.ordinal()].getSize(); i++) {
				nodeCollection[side.ordinal()].getNode(i).receive(this, nodeCollection[side.ordinal()].getSide(i), value);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean receive(ICommunicationNode origin, ForgeDirection side, boolean value) {
		buffer[side.ordinal()].put(0, value);
		transition();
		return true;
	}

	protected abstract void transition();

	@Override
	public boolean send(ForgeDirection side, boolean value, int index) {
		buffer[side.ordinal()].put(index, value);
		if (getBusType(side) == UTBusType.bundle) {
			for (int i = 0; i < nodeCollection[side.ordinal()].getSize(); i++) {
				nodeCollection[side.ordinal()].getNode(i).receive(this, nodeCollection[side.ordinal()].getSide(i), value);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean receive(ICommunicationNode origin, ForgeDirection side, boolean value, int index) {
		buffer[side.ordinal()].put(index, value);
		transition();
		return true;
	}

	@Override
	public UTBusType getBusType() {
		return UTBusType.bus;
	}

	@Override
	public boolean isSideConnected(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSideValid(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSideActivity(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPlacedSide() {
		return placedSide;
	}
}
