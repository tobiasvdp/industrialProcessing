package ip.industrialProcessing.logic.transport.wired.cable;

import java.util.ArrayList;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicCable extends TileEntity implements ICommunicationTransport{
	public boolean isEnabled = true;
	@Override
	public void sendDiscoveryPacket(ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord+sendingSide.offsetY, zCoord+sendingSide.offsetZ);
		if (te instanceof ICommunication){
			ICommunication com = (ICommunication) te;
			com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), path, node, side);
		}
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
if(!ContainsThis(path) && this.isEnabled){
	path.add(this);
	for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
		if(dir != receivedSide){
			this.sendDiscoveryPacket(dir, path, node, side);
		}
	}
}
	}

	@Override
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
for(ICommunicationTransport trans:path){
	if(trans == this)
		return true;
}
		return false;
	}

	@Override
	public void requestRecheck() {
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			this.sendDiscoveryPacket(dir, new ArrayList<ICommunicationTransport>(), null, null);
		}
	}

	@Override
	public boolean isEnabled() {
return isEnabled;
	}

	@Override
	public void isEnabled(boolean enabled) {
isEnabled=enabled;
	}

}
