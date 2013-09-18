package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicTransport extends TileEntity implements ICommunicationTransport{
	
	private ArrayList<UTpacket> packets = new ArrayList<UTpacket>();
	boolean enabled = true;
	
	public TElogicTransport() {
		super();
	}

	@Override
	public void Receive(UTpacket packet) {
		System.out.println("Packet recieved on " + xCoord +" "+ yCoord +" "+ zCoord);
		if(packet.getType() == UTpacketType.discovery || packet.getType() == UTpacketType.recheck){
			if (!ContainsThis(((ArrayList<ICommunicationTransport>)packet.getData(1)))){
				((ArrayList<ICommunicationTransport>)packet.getData(1)).add(this);
				ForgeDirection receivingside = ((ForgeDirection)packet.getData(0));
				for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
					if(dir != receivingside){
						packet.setData(0, dir.getOpposite());
						packets.add(new UTpacket(packet));
					}
				}
				scheduleSend();
			}
		}
		ExtendedReceive(packet);
	}

	@Override
	public abstract void ExtendedReceive(UTpacket packet);

	@Override
	public void scheduleSend() {
		this.worldObj.scheduleBlockUpdateWithPriority(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord), 1, -1);
	}

	@Override
	public void Send() {
		for(UTpacket packet:packets){
			if(packet.getType() == UTpacketType.discovery ||packet.getType() == UTpacketType.recheck){
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
				if (te instanceof ICommunication) {
					System.out.println("relay packet to "+te.xCoord + " " + te.yCoord + " " + te.zCoord);
					ICommunication com = (ICommunication) te;
					com.Receive(packet);
				}
			}
		}
		packets.clear();
	}

	@Override
	public UTBusType getBusType(ForgeDirection side) {
			TileEntity te = worldObj.getBlockTileEntity(xCoord + side.offsetX, yCoord + side.offsetY, zCoord + side.offsetZ);
			if (te instanceof ICommunication) {
				return ((ICommunication) te).getBusType();
			}
			return UTBusType.invalid;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void isEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
		for(ICommunicationTransport node: path){
			if(node == this)
				return true;
		}
		return false;
	}
	
	@Override
	public void createRecheckPacket(){
		ArrayList<ICommunicationTransport> path = new ArrayList<ICommunicationTransport>();
		path.add(this);
		for(ForgeDirection sendingSide: ForgeDirection.VALID_DIRECTIONS)
			packets.add(new UTpacket(UTpacketType.recheck, sendingSide.getOpposite(), path, sendingSide));
		this.Send();
	}

}
