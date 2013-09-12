package ip.industrialProcessing.logic.transport.wired.cable;

import java.util.ArrayList;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTBusType;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicCable extends TileEntity implements ICommunicationTransport {
	public boolean isEnabled = true;
	private boolean init = true;;
	private ArrayList<Integer> placedSide = new ArrayList<Integer>();
	
	public TElogicCable() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(init){
			placedSide.add(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
			init = false;
		}
	}

	@Override
	public void sendDiscoveryPacket(ForgeDirection receivingSide, ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
		if (te instanceof ICommunicationNode) {
			ICommunicationNode com = (ICommunicationNode) te;
			com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), path, node, side);
		}
		if (te instanceof ICommunicationTransport) {
			ICommunicationTransport com = (ICommunicationTransport) te;
			if (com.getBusType() == getBusType())
				com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), path, node, side);
		}
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if (!ContainsThis(path) && this.isEnabled) {
			path.add(this);
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				if (dir != receivedSide) {
					this.sendDiscoveryPacket(receivedSide,dir, path, node, side);
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
			this.sendDiscoveryPacket(null,dir, new ArrayList<ICommunicationTransport>(), null, null);
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
		return UTBusType.cable;
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
	public int getPlacedSidesSize() {
		return placedSide.size();
	}

	@Override
	public int getPlacedSide(int i) {
		return placedSide.get(i);
	}

}
