package ip.industrialProcessing.utils.packets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.packet.Packet250CustomPayload;

public abstract class PacketIP000 {
    private String channel;

    public PacketIP000(String channel){
	this.channel = channel;
    }
    
    public Packet250CustomPayload getCustom250Packet() {
	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
	DataOutputStream outputStream = new DataOutputStream(bos);
	try {
	    writePacketData(outputStream);
	    Packet250CustomPayload packet = new Packet250CustomPayload(this.channel, bos.toByteArray());
	    return packet;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static PacketIP000 getPacketFromCustom250packet(PacketIP000 myPacket, Packet250CustomPayload packet) {
	DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	try {
	    myPacket.readPacketData(inputStream);
	    return myPacket;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    protected abstract void writePacketData(DataOutput dataoutput) throws IOException;
    protected abstract void readPacketData(DataInput datainput) throws IOException;
}
