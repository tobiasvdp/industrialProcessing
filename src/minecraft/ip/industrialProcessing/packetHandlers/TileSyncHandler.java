package ip.industrialProcessing.packetHandlers;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.utils.working.ServerWorker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

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
