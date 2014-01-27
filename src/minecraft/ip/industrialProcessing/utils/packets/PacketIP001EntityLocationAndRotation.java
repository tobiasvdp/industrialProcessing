package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.subMod.mine.PacketHandler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketIP001EntityLocationAndRotation extends Packet250CustomPayload {

	double posX;
	double posY;
	double posZ;
	float rotationPitch;
	float rotationYaw;
	int entityId;
	
	public PacketIP001EntityLocationAndRotation(Entity entity) {
		super();
		this.channel = PacketHandler.move;
		entityId=entity.entityId;
		posX=entity.posX;
		posY=entity.posY;
		posZ=entity.posZ;
		rotationPitch=entity.rotationPitch;
		rotationYaw=entity.rotationYaw;
	}
	
	@Override
	public void readPacketData(DataInput datainput) throws IOException {
		super.readPacketData(datainput);
		entityId=datainput.readInt();
		posX=datainput.readDouble();
		posY=datainput.readDouble();
		posZ=datainput.readDouble();
		rotationPitch=datainput.readFloat();
		rotationYaw=datainput.readFloat();
	}

	@Override
	public void writePacketData(DataOutput dataoutput) throws IOException {
		super.writePacketData(dataoutput);
		dataoutput.writeInt(entityId);
		dataoutput.writeDouble(posX);
		dataoutput.writeDouble(posY);
		dataoutput.writeDouble(posZ);
		dataoutput.writeDouble(rotationPitch);
		dataoutput.writeDouble(rotationYaw);
	}

	@Override
	public void processPacket(NetHandler nethandler) {
		nethandler.handleCustomPayload(this);
	}

	@Override
	public int getPacketSize() {
		return 36;
	}

}
