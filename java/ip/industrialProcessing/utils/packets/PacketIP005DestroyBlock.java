package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketIP005DestroyBlock extends PacketIP000 {

	int x;
	int y;
	int z;
	boolean dropItems;
	
	public PacketIP005DestroyBlock() {
		super(PacketHandler.IP_DESTROY_BLOCK);
		// TODO Auto-generated constructor stub
	}
	
	public PacketIP005DestroyBlock(int x,int y,int z, boolean dropItems) {
		super(PacketHandler.IP_DESTROY_BLOCK);
		this.x = x;
		this.y = y;
		this.z = z;
		this.dropItems = dropItems;
	}

	@Override
	protected void writePacketData(DataOutput dataoutput) throws IOException {
		dataoutput.writeInt(x);
		dataoutput.writeInt(y);
		dataoutput.writeInt(z);
		dataoutput.writeBoolean(dropItems);
	}

	@Override
	protected void readPacketData(DataInput datainput) throws IOException {
		x= datainput.readInt();
		y= datainput.readInt();
		z= datainput.readInt();
		dropItems= datainput.readBoolean();
	}
	
	public static PacketIP005DestroyBlock getPacketFromCustom250packet(Packet250CustomPayload packet) {
		return (PacketIP005DestroyBlock) PacketIP000.getPacketFromCustom250packet(new PacketIP005DestroyBlock(), packet);
	}

}
