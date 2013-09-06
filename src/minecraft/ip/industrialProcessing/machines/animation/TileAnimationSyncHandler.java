package ip.industrialProcessing.machines.animation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.packetHandlers.TileSyncHandler;

public class TileAnimationSyncHandler extends TileSyncHandler {

    // TODO: don't send the animation data every frame, speed will provide for
    // interpolation.
    public static void sendAnimationData(TileEntity entity, AnimationHandler handler) {
	double x = entity.xCoord;
	double y = entity.yCoord;
	double z = entity.zCoord;
	int dimensionId = entity.worldObj.getWorldInfo().getVanillaDimension();
	double range = 32;

	Packet250CustomPayload packet = getAnimationPayload(entity, handler);
	PacketDispatcher.sendPacketToAllAround(x, y, z, range, dimensionId, packet);
    }

    private static Packet250CustomPayload getAnimationPayload(TileEntity entity, AnimationHandler handler) {

	ByteArrayOutputStream bos = new ByteArrayOutputStream(4 * 5);
	DataOutputStream outputStream = new DataOutputStream(bos);

	try {
	    writeTileEntity(outputStream, entity); // 3 * 4 bytes
	    writeAnimationHandler(outputStream, handler); // 2 * 4 bytes
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return getCustomPacket(bos, PacketHandler.ANIMATION_SYNC);
    }

    protected static void writeAnimationHandler(DataOutputStream outputStream, AnimationHandler handler) throws IOException {
	float progress = handler.getProgress();
	float speed = handler.getSpeed();
	if (!handler.isIncrementing())
	    speed = -speed;
	System.out.println("Sending progress " + progress + " and speed " + speed);
	outputStream.writeFloat(progress);
	outputStream.writeFloat(speed);
    }

    protected static void readAnimationHandler(DataInputStream inputStream, AnimationHandler handler) throws IOException {
	float progress = inputStream.readFloat();
	float speed = inputStream.readFloat();
	boolean incrementing = true;
	System.out.println("Received progress " + progress + " and speed " + speed);
	if (speed < 0) {
	    incrementing = false;
	    speed = -speed;
	}
	// TRANSACTIONAL: all 3 reads need to succeed
	handler.setProgress(progress);
	handler.setSpeed(speed);
	handler.setIncrementing(incrementing);
    }

    public static void handleAnimationSync(INetworkManager manager, Packet250CustomPayload packet, Player player) {

	Entity playerEntity = (Entity) player;
	TileEntity tileEntity;
	boolean isAnimated;

	DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	try {
	    tileEntity = readTileEntity(inputStream, playerEntity.worldObj);
	    if (tileEntity instanceof IAnimationSyncable) {
		IAnimationSyncable syncable = (IAnimationSyncable) tileEntity;
		readAnimationHandler(inputStream, syncable.getAnimationHandler());
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	    return;
	}
    }

}
