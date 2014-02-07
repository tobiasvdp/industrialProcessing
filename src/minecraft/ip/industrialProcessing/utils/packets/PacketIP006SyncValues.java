package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketIP006SyncValues extends PacketIP000 {

	int x;
	int y;
	int z;
	int[] val;
	
	public PacketIP006SyncValues() {
		super(PacketHandler.IP_SYN_VAL);
	}
	
	public PacketIP006SyncValues(int x,int y,int z, int[] val) {
		super(PacketHandler.IP_SYN_VAL);
		this.x = x;
		this.y = y;
		this.z = z;
		this.val = val;
	}
	
	@Override
	protected void writePacketData(DataOutput dataoutput) throws IOException {
		dataoutput.writeInt(x);
		dataoutput.writeInt(y);
		dataoutput.writeInt(z);
		dataoutput.writeInt(val.length);
		for(int i =0;i<val.length;i++){
			dataoutput.writeInt(val[i]);
		}
	}

	@Override
	protected void readPacketData(DataInput datainput) throws IOException {
		this.x = datainput.readInt();
		this.y = datainput.readInt();
		this.z = datainput.readInt();
		int length = datainput.readInt();
		this.val = new int[length];
		for(int i =0;i<val.length;i++){
			val[i] = datainput.readInt();
		}
	}
	
	public static PacketIP006SyncValues getPacketFromCustom250packet(Packet250CustomPayload packet) {
		return (PacketIP006SyncValues) PacketIP000.getPacketFromCustom250packet(new PacketIP006SyncValues(), packet);
	}

}
