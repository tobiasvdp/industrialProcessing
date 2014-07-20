package mod.industrialProcessing.utils.handlers.packet.packets;

import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class RayTraceToServerPacket extends PacketIP {

	int hitType;
	int entityID;
	MovingObjectPosition hit;

	public RayTraceToServerPacket() {
		super(PacketHandler.IP_RAY_TRACE);
	}

	public RayTraceToServerPacket(MovingObjectPosition hit, int hitType) {
		super(PacketHandler.IP_RAY_TRACE);
		this.hitType = hitType;
		this.hit = hit;
	}

	@Override
	protected void writePacketData(DataOutput dataoutput) throws IOException {
		dataoutput.writeInt(hitType);
		dataoutput.writeInt(hit.blockX);
		dataoutput.writeInt(hit.blockY);
		dataoutput.writeInt(hit.blockZ);
		dataoutput.writeInt(hit.sideHit);
		dataoutput.writeInt(hit.subHit);
		if (hit.entityHit != null)
			dataoutput.writeInt(hit.entityHit.entityId);
		else
			dataoutput.writeInt(-1);
		dataoutput.writeInt(hit.typeOfHit.ordinal());
		dataoutput.writeDouble(hit.hitVec.xCoord);
		dataoutput.writeDouble(hit.hitVec.yCoord);
		dataoutput.writeDouble(hit.hitVec.zCoord);
	}

	@Override
	protected void readPacketData(DataInput datainput) throws IOException {
		hitType = datainput.readInt();
		int blockX = datainput.readInt();
		int blockY = datainput.readInt();
		int blockZ = datainput.readInt();
		int sideHit = datainput.readInt();
		int subHit = datainput.readInt();
		entityID = datainput.readInt();
		EnumMovingObjectType typeOfHit = EnumMovingObjectType.values()[datainput.readInt()];
		Vec3 hitVec = Vec3.createVectorHelper(datainput.readDouble(), datainput.readDouble(), datainput.readDouble());
		hit = new MovingObjectPosition(blockX, blockY, blockZ, sideHit, hitVec);
		hit.subHit = subHit;
		hit.typeOfHit = typeOfHit;
	}

	public static RayTraceToServerPacket getPacketFromCustom250packet(Packet250CustomPayload packet) {
		return (RayTraceToServerPacket) PacketIP000.getPacketFromCustom250packet(new RayTraceToServerPacket(), packet);
	}

}
