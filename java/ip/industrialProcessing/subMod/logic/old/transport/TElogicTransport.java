package ip.industrialProcessing.subMod.logic.old.transport;

import ip.industrialProcessing.subMod.logic.old.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.old.utils.UTLogicType;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacket;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacketType;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TElogicTransport extends TileEntity implements ICommunicationTransport {

	int internalSides = 0;
	int sidesCount = 1;

	private ArrayList<UTpacket> packets = new ArrayList<UTpacket>();
	boolean enabled = true;

	public TElogicTransport() {
		super();
	}

	@Override
	public void addToBlockside(int par5) {
		this.internalSides += this.transformToStorage(par5);
		this.sidesCount++;
		System.out.println("added blockside " + this.internalSides);
		System.out.println(this.hasBlockSide(par5));
	}

	@Override
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
		for (ICommunicationTransport node : path) {
			if (node == this) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void createRecheckPacket() {
		ArrayList<ICommunicationTransport> path = new ArrayList<ICommunicationTransport>();
		path.add(this);
		for (ForgeDirection sendingSide : ForgeDirection.VALID_DIRECTIONS) {
			this.packets.add(new UTpacket(UTpacketType.recheck, sendingSide.getOpposite(), path, sendingSide));
		}
		this.Send();
	}

	@Override
	public abstract void ExtendedReceive(UTpacket packet);

	@Override
	public void ExtendedSend(UTpacket packet) {
	}

	@Override
	public int getBlockSidesCount() {
		return this.sidesCount;
	}

	@Override
	public UTBusType getBusType(ForgeDirection side) {
		TileEntity te = this.worldObj.getBlockTileEntity(this.xCoord + side.offsetX, this.yCoord + side.offsetY, this.zCoord + side.offsetZ);
		if (te instanceof ICommunication) {
			return ((ICommunication) te).getBusType();
		}
		return UTBusType.invalid;
	}

	@Override
	public UTLogicType getLogicType() {
		return UTLogicType.transport;
	}

	@Override
	public boolean hasBlockSide(int side) {
		side = this.transformToStorage(side);
		return (this.internalSides & side) == side;
	}

	@Override
	public boolean hasMultipleBlockSides() {
		return this.sidesCount > 1;
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
	public void Receive(UTpacket packet) {
		if (packet.getType() == UTpacketType.discovery || packet.getType() == UTpacketType.recheck) {
			if (!this.ContainsThis((ArrayList<ICommunicationTransport>) packet.getData(1))) {
				((ArrayList<ICommunicationTransport>) packet.getData(1)).add(this);
				ForgeDirection receivingside = (ForgeDirection) packet.getData(0);
				for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
					if (dir != receivingside) {
						packet.setData(0, dir);
						this.packets.add(new UTpacket(packet));
					}
				}
				this.scheduleSend();
			}
		}
		this.ExtendedReceive(packet);
	}

	@Override
	public void removeFromBlockside(int par5) {
		this.internalSides -= this.transformToStorage(par5);
		this.sidesCount--;
	}

	@Override
	public void scheduleSend() {
		this.worldObj.scheduleBlockUpdateWithPriority(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord), 1, -1);
	}

	@Override
	public void Send() {
		for (UTpacket packet : this.packets) {
			if (packet.getType() == UTpacketType.discovery || packet.getType() == UTpacketType.recheck) {
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				TileEntity te = this.worldObj.getBlockTileEntity(this.xCoord + sendingSide.offsetX, this.yCoord + sendingSide.offsetY, this.zCoord + sendingSide.offsetZ);
				if (te instanceof ICommunication) {
					ICommunication com = (ICommunication) te;
					packet.setData(0, sendingSide.getOpposite());
					com.Receive(packet);
				}
			}
			this.ExtendedSend(packet);
		}
		this.packets.clear();
	}

	private int transformToStorage(int par5) {
		switch (par5) {
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 4;
		case 3:
			return 8;
		case 4:
			return 16;
		case 5:
			return 32;
		default:
			return 0;
		}
	}

}
