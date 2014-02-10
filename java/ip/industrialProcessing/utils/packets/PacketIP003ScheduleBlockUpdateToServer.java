package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketIP003ScheduleBlockUpdateToServer extends PacketIP000 {

	int x;
	int y;
	int z;
	int blockID;
	int delay;

	public PacketIP003ScheduleBlockUpdateToServer(int x, int y, int z, int blockID, int delay) {
		super(PacketHandler.IP_SCHEDULE_TICK);
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockID = blockID;
		this.delay = delay;
	}

	public PacketIP003ScheduleBlockUpdateToServer() {
		super(PacketHandler.IP_SCHEDULE_TICK);
	}

	@Override
	protected void writePacketData(DataOutput dataoutput) throws IOException {
		dataoutput.writeInt(x);
		dataoutput.writeInt(y);
		dataoutput.writeInt(z);
		dataoutput.writeInt(blockID);
		dataoutput.writeInt(delay);
	}

	@Override
	protected void readPacketData(DataInput datainput) throws IOException {
		x = datainput.readInt();
		y = datainput.readInt();
		z = datainput.readInt();
		blockID = datainput.readInt();
		delay = datainput.readInt();

	}

	public static PacketIP003ScheduleBlockUpdateToServer getPacketFromCustom250packet(Packet250CustomPayload packet) {
		return (PacketIP003ScheduleBlockUpdateToServer) PacketIP000.getPacketFromCustom250packet(new PacketIP003ScheduleBlockUpdateToServer(), packet);
	}

}
