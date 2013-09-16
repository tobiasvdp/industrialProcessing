package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicNode extends TileEntity implements ICommunicationNode{

	public TElogicNode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UTBusType getBusType() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPlacedSidesSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addToConnectedSides(int side, boolean transform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeConnectedSides(int side, boolean transform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean[] getPlacedSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendDiscoveryPacket(ForgeDirection sendingSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDiscoveryPacket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDestructionPacket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNode(ICommunicationNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRandomName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UTBusType getBusType(ForgeDirection side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UTBuffer getBuffer(ForgeDirection dir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean scheduleSend(ForgeDirection side, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean send(ForgeDirection side, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scheduleSend(ForgeDirection side, boolean value, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean send(ForgeDirection side, boolean value, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receive(ICommunicationNode origin, ForgeDirection side, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receive(ICommunicationNode origin, ForgeDirection side, boolean value, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnectableOnSide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ForgeDirection[] setConnectableSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void scheduleSendDiscoveryPacket(ForgeDirection sendingSide) {
		// TODO Auto-generated method stub
		
	}
	
	protected abstract void transition();

}
