package ip.industrialProcessing.utils.packetHandlers;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileSyncHandler {

    protected static TileEntity readTileEntity(DataInputStream inputStream, World worldObj) throws IOException {

	int xcoord = inputStream.readInt();
	int ycoord = inputStream.readInt();
	int zcoord = inputStream.readInt();
	return worldObj.getBlockTileEntity(xcoord, ycoord, zcoord);
    }

    protected static void writeTileEntity(DataOutputStream outputStream, TileEntity entity) throws IOException {
	outputStream.writeInt(entity.xCoord);
	outputStream.writeInt(entity.yCoord);
	outputStream.writeInt(entity.zCoord);
    }

    protected static Packet250CustomPayload getCustomPacket(ByteArrayOutputStream bos, String channel) {
	Packet250CustomPayload packet = new Packet250CustomPayload();
	packet.channel = channel;
	packet.data = bos.toByteArray();
	packet.length = bos.size();
	return packet;
    }

}
