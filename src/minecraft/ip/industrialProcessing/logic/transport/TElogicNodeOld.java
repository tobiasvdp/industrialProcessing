package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.machines.IRotateableEntity;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicNodeOld extends TileEntity implements ICommunicationNode{

	private UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	private UTBuffer[] buffer = new UTBuffer[6];
	public String name;
	private boolean[] placedSide = new boolean[6];
	private ForgeDirection[] conectableSides;
	private boolean init = true;

	public TElogicNodeOld() {
		conectableSides = setConnectableSides();
		for (int i = 0; i < 6; i++) {
			nodeCollection[i] = new UTlogicNodeContainer();
			buffer[i] = new UTBuffer(UTBusType.bus);
			placedSide[i] = false;
		}
	}
	
	private int transformToForgeDirection(int blockMetadata) {
		switch (blockMetadata) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 3;
		case 3:
			return 2;
		case 4:
			return 5;
		case 5:
			return 4;
		}
		return 0;
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(init){
			placedSide[(transformToForgeDirection(worldObj.getBlockMetadata(xCoord, yCoord, zCoord)))] = true;
			init = false;
		}
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		System.out.println("recieved packet on node");
		if (node != null) {
			this.registerNode(receivedSide, node, side);
			node.registerNode(side, this, receivedSide);
		} else {
			scheduleSendDiscoveryPacket(receivedSide);
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
			System.out.println("Registered node " + node.getName());
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
			this.buffer[side.ordinal()] = new UTBuffer(getBusType(side));
		}
	}

	@Override
	public void removeNode(ICommunicationNode node) {
		System.out.println("Unregistered node " + node.getName());
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
			System.out.println(this.worldObj.getTotalWorldTime());
			this.worldObj.scheduleBlockUpdateWithPriority(xCoord, yCoord, zCoord,worldObj.getBlockId(xCoord, yCoord, zCoord), 1, -1);
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
	public boolean getPlacedSide(int i) {
		return placedSide[i];
	}
	@Override
	public int getPlacedSidesSize() {
		return 6;
	}
	public void addToConnectedSides(int side, boolean transform){}
	
	@Override
	public boolean[] getPlacedSides() {
		return placedSide;
	}
	@Override
	public boolean isConnectableOnSide(ForgeDirection side) {
		return false;
	}
	
	public void removeConnectedSides(int side, boolean transform){
		
	}
	public UTBuffer getBuffer(ForgeDirection dir){
		return buffer[dir.ordinal()];
	}
	@Override
	public void scheduleSendDiscoveryPacket(ForgeDirection sendingSide){
		
	}
	@Override
	public boolean scheduleSend(ForgeDirection side,boolean value){
		return true;
	}
	@Override
	public boolean scheduleSend(ForgeDirection side,boolean value, int index){
		return true;
	}
}
