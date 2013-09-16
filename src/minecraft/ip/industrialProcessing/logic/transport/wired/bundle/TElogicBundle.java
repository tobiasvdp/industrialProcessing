package ip.industrialProcessing.logic.transport.wired.bundle;

import java.util.ArrayList;

import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTsendDiscoveryPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicBundle extends TileEntity implements ICommunicationTransport{
	public boolean isEnabled = true;
	private boolean[] placedSide = new boolean[6];
	private ArrayList<UTsendDiscoveryPacket> sendDiscoveryBuffer = new ArrayList<UTsendDiscoveryPacket>();

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if (!ContainsThis(path) && this.isEnabled) {
			path.add(this);
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				if (dir != receivedSide) {
					this.ScheduleSendDiscoveryPacket(receivedSide,dir, path, node, side);
				}
			}
		}
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
			sendDiscoveryBuffer.add(new UTsendDiscoveryPacket(null,dir, new ArrayList<ICommunicationTransport>(), null, null));
			this.sendDiscoveryPackets();
		}
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
	public UTBusType getBusType() {
		return UTBusType.bundle;
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
		return placedSide;
	}

	@Override
	public void setMultipleSides(boolean b) {
		// TODO Auto-generated method stub
		
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
	public void ScheduleSendDiscoveryPacket(ForgeDirection receivingSide, ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		// TODO Auto-generated method stub
		
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
}
