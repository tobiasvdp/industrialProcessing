package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketIP002SendMicroBlockDestructionChange extends PacketIP000 {
	
	boolean isDestroying;
	int blockID;

	public PacketIP002SendMicroBlockDestructionChange() {
		super(PacketHandler.IP_MICROBLOCKS_DESTROYING);
	}
	
	public PacketIP002SendMicroBlockDestructionChange(int blockID,boolean isDestroying) {
		super(PacketHandler.IP_MICROBLOCKS_DESTROYING);
		this.isDestroying = isDestroying;
		this.blockID = blockID;
	}

	@Override
	protected void writePacketData(DataOutput dataoutput) throws IOException {
		dataoutput.writeBoolean(isDestroying);
		dataoutput.writeInt(blockID);
	}

	@Override
	protected void readPacketData(DataInput datainput) throws IOException {
		isDestroying = datainput.readBoolean();
		blockID = datainput.readInt();
	}
	
    public static PacketIP002SendMicroBlockDestructionChange getPacketFromCustom250packet(Packet250CustomPayload packet) {
	return (PacketIP002SendMicroBlockDestructionChange) PacketIP000.getPacketFromCustom250packet(new PacketIP002SendMicroBlockDestructionChange(), packet);
    }

}
