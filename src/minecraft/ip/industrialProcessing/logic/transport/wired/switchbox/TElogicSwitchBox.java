package ip.industrialProcessing.logic.transport.wired.switchbox;

import java.util.ArrayList;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicSwitchBox extends TileEntity implements ICommunicationNode{
	public UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if(node != null){
			this.registerNode(receivedSide, node);
			node.registerNode(side, this);
		}else{
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
		TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord+sendingSide.offsetY, zCoord+sendingSide.offsetZ);
		if (te instanceof ICommunication){
			ICommunication com = (ICommunication) te;
			com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), new  ArrayList<ICommunicationTransport>(), this, sendingSide);
		}
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node) {
		if(!this.nodeCollection[side.ordinal()].contains(node))
			this.nodeCollection[side.ordinal()].add(node);
	}

	@Override
	public void removeNode(ICommunicationNode node) {
		for(UTlogicNodeContainer sideContainer: this.nodeCollection){
			sideContainer.remove(node);
		}
	}

	@Override
	public void sendDestructionPacket() {
		for(UTlogicNodeContainer sideContainer: this.nodeCollection){
			sideContainer.notifyOfRemoval(this);
		}
	}

	@Override
	public void sendDiscoveryPacket() {
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			this.sendDiscoveryPacket(dir);
		}
	}

}
