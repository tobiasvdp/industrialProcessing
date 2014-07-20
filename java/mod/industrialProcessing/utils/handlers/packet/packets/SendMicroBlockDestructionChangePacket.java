package mod.industrialProcessing.utils.handlers.packet.packets;

import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SendMicroBlockDestructionChangePacket extends PacketIP000 {
	
	boolean isDestroying;
	int blockID;

	public SendMicroBlockDestructionChangePacket() {
		super(PacketHandler.IP_MICROBLOCKS_DESTROYING);
	}
	
	public SendMicroBlockDestructionChangePacket(int blockID,boolean isDestroying) {
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
	
    public static SendMicroBlockDestructionChangePacket getPacketFromCustom250packet(Packet250CustomPayload packet) {
	return (SendMicroBlockDestructionChangePacket) PacketIP000.getPacketFromCustom250packet(new SendMicroBlockDestructionChangePacket(), packet);
    }

}
