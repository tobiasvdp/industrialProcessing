package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTLogicType;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;
import ip.industrialProcessing.utils.blockContainer.IBlockInBlock;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicTransport extends TileEntity implements ICommunicationTransport, IBlockInBlock{
	
	int internalSides = 0;
	int sidesCount = 1;
	
	private ArrayList<UTpacket> packets = new ArrayList<UTpacket>();
	boolean enabled = true;
	
	public TElogicTransport() {
		super();
	}

	@Override
	public void Receive(UTpacket packet) {
		if(packet.getType() == UTpacketType.discovery || packet.getType() == UTpacketType.recheck){
			if (!ContainsThis(((ArrayList<ICommunicationTransport>)packet.getData(1)))){
				((ArrayList<ICommunicationTransport>)packet.getData(1)).add(this);
				ForgeDirection receivingside = ((ForgeDirection)packet.getData(0));
				for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
					if(dir != receivingside){
						packet.setData(0, dir);
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
				ForgeDirection sendingSide = ((ForgeDirection) packet.getData(0));
				TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
				if (te instanceof ICommunication) {
					ICommunication com = (ICommunication) te;
					packet.setData(0, sendingSide.getOpposite());
					com.Receive(packet);
				}
			}
			ExtendedSend(packet);
		}
		packets.clear();
	}
	@Override
	public void ExtendedSend(UTpacket packet){}

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
	
	private int transformToStorage(int par5) {
		switch(par5){
		case 0:return 1;
		case 1:return 2;
		case 2:return 4;
		case 3:return 8;
		case 4:return 16;
		case 5:return 32;
		default: return 0;
		}
	}

		
	@Override
	public void addToBlockside(int par5) {
		internalSides += (transformToStorage(par5));
		sidesCount++;
		System.out.println("added blockside "+ internalSides);
		System.out.println(hasBlockSide(par5));
	}

	@Override
	public void removeFromBlockside(int par5) {
		internalSides -= (transformToStorage(par5));
		sidesCount--;
	}

	@Override
	public boolean hasBlockSide(int side) {
		side = (transformToStorage(side));
		return ((internalSides & side) == side);
	}

	@Override
	public boolean hasMultipleBlockSides() {
		return (sidesCount > 1);
	}

	@Override
	public int getBlockSidesCount() {
		return sidesCount;
	}
	
	@Override
	public void addBlockToContainer(ForgeDirection dir) {
		System.out.println("adding to side is " + dir);
	}
	
    @Override
    public UTLogicType getLogicType(){
    	return UTLogicType.transport;
    }

}
