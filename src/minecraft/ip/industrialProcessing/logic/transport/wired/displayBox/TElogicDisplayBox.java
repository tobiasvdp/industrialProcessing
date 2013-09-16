package ip.industrialProcessing.logic.transport.wired.displayBox;

import java.util.ArrayList;
import java.util.UUID;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTsendDiscoveryPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicDisplayBox extends TileEntity implements ICommunicationNode, ICommunicationTransport {

	private boolean isEnabled;
	private UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	private UTBuffer[] buffer = new UTBuffer[6];
	public String name;
	private boolean[] placedSide = new boolean[6];
	private ArrayList<UTsendDiscoveryPacket> sendDiscoveryBuffer = new ArrayList<UTsendDiscoveryPacket>();

	public TElogicDisplayBox() {
		for (int i = 0; i < 6; i++) {
			nodeCollection[i] = new UTlogicNodeContainer();
			buffer[i] = new UTBuffer(UTBusType.bus);
			placedSide[i] = false;
		}
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if (!ContainsThis(path) && this.isEnabled) {
			if (node != null) {
				this.registerNode(receivedSide, node, side);
				node.registerNode(side, this, receivedSide);
			} else {
				sendDiscoveryPacket(receivedSide);
			}
			path.add(this);
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				if (dir != receivedSide) {
					this.ScheduleSendDiscoveryPacket(receivedSide, dir, path, node, side);
				}
			}
		}
	}

	@Override
	public UTBusType getBusType() {
		return UTBusType.cable;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public void isEnabled(boolean enabled) {
		isEnabled = enabled;
	}

	@Override
	public void sendDiscoveryPackets() {
		for (UTsendDiscoveryPacket packet : sendDiscoveryBuffer) {
			TileEntity te = worldObj.getBlockTileEntity(xCoord + packet.getSendingSide().offsetX, yCoord + packet.getSendingSide().offsetY, zCoord + packet.getSendingSide().offsetZ);
			if (te instanceof ICommunicationNode) {
				ICommunicationNode com = (ICommunicationNode) te;
				com.ReceiveDiscoveryPacket(packet.getSendingSide().getOpposite(), packet.getPath(), packet.getNode(), packet.getSide());
			}
			if (te instanceof ICommunicationTransport) {
				ICommunicationTransport com = (ICommunicationTransport) te;
				if (com.getBusType() == getBusType())
					com.ReceiveDiscoveryPacket(packet.getSendingSide().getOpposite(), packet.getPath(), packet.getNode(), packet.getSide());
			}
		}
		sendDiscoveryBuffer.clear();
	}

	@Override
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
		for (ICommunicationTransport trans : path) {
			if (trans == this)
				return true;
		}
		return false;
	}

	@Override
	public void requestRecheck() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			sendDiscoveryBuffer.add(new UTsendDiscoveryPacket(null, dir, new ArrayList<ICommunicationTransport>(), null, null));
			this.sendDiscoveryPackets();
		}
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
	public void sendDiscoveryPacket() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			this.sendDiscoveryPacket(dir);
		}
	}

	@Override
	public void sendDestructionPacket() {
		for (UTlogicNodeContainer sideContainer : this.nodeCollection) {
			sideContainer.notifyOfRemoval(this);
		}
	}

	@Override
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side) {
		return this.nodeCollection[side.ordinal()];
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
	public boolean receive(ICommunicationNode origin, ForgeDirection side, boolean value) {
		buffer[side.ordinal()].put(0, value);
		return true;
	}

	@Override
	public boolean receive(ICommunicationNode origin, ForgeDirection side, boolean value, int index) {
		buffer[side.ordinal()].put(index, value);
		return true;
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
	public boolean getPlacedSide(int i) {
		return placedSide[i];
	}

	@Override
	public int getPlacedSidesSize() {
		return 6;
	}

	@Override
	public void addToConnectedSides(int side, boolean transform) {
		placedSide[side] = true;
	}

	@Override
	public boolean[] getPlacedSides() {
		return  placedSide;
	}

	@Override
	public boolean isConnectableOnSide(ForgeDirection side) {
		return false;
	}

	@Override
	public ForgeDirection[] setConnectableSides() {
		return new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST};
	}

	@Override
	public void setMultipleSides(boolean b) {
		
	}

	@Override
	public boolean getMultipleSides() {
		return false;
	}

	@Override
	public void removeConnectedSides(int side, boolean transform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UTBuffer getBuffer(ForgeDirection dir) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ScheduleSendDiscoveryPacket(ForgeDirection receivingSide, ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		sendDiscoveryBuffer.add(new UTsendDiscoveryPacket(receivingSide, sendingSide, path, node, side));
		this.worldObj.scheduleBlockUpdateWithPriority(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord), 1, -1);
	}

	@Override
	public boolean scheduleSend(ForgeDirection side, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scheduleSend(ForgeDirection side, boolean value, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void scheduleSendDiscoveryPacket(ForgeDirection sendingSide) {
		// TODO Auto-generated method stub
		
	}
}
