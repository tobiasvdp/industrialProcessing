package ip.industrialProcessing.utils.packets;

import ip.industrialProcessing.subMod.mine.PacketHandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketIP001EntityLocationAndRotation extends PacketIP000{

    double posX;
    double posY;
    double posZ;
    float rotationPitch;
    float rotationYaw;
    int entityId;

    public PacketIP001EntityLocationAndRotation() {
	super(PacketHandler.move);
    }

    public PacketIP001EntityLocationAndRotation(Entity entity) {
	super(PacketHandler.move);
	entityId = entity.entityId;
	posX = entity.posX;
	posY = entity.posY;
	posZ = entity.posZ;
	rotationPitch = entity.rotationPitch;
	rotationYaw = entity.rotationYaw;
    }

    public void readPacketData(DataInput datainput) throws IOException {
	entityId = datainput.readInt();
	posX = datainput.readDouble();
	posY = datainput.readDouble();
	posZ = datainput.readDouble();
	rotationPitch = datainput.readFloat();
	rotationYaw = datainput.readFloat();
    }

    public void writePacketData(DataOutput dataoutput) throws IOException {
	dataoutput.writeInt(entityId);
	dataoutput.writeDouble(posX);
	dataoutput.writeDouble(posY);
	dataoutput.writeDouble(posZ);
	dataoutput.writeFloat(rotationPitch);
	dataoutput.writeFloat(rotationYaw);
    }
    
    public static PacketIP001EntityLocationAndRotation getPacketFromCustom250packet(Packet250CustomPayload packet) {
	return (PacketIP001EntityLocationAndRotation) PacketIP000.getPacketFromCustom250packet(new PacketIP001EntityLocationAndRotation(), packet);
    }
}
