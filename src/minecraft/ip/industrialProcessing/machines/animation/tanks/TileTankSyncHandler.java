package ip.industrialProcessing.machines.animation.tanks;

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
import ip.industrialProcessing.utils.handler.packets.PacketHandler;
import ip.industrialProcessing.utils.packetHandlers.TileSyncHandler;

public class TileTankSyncHandler extends TileSyncHandler { 
	public static void sendTankData(TileEntity entity, TankHandler handler) {
		double x = entity.xCoord;
		double y = entity.yCoord;
		double z = entity.zCoord;
		int dimensionId = entity.worldObj.getWorldInfo().getVanillaDimension();
		double range = 32;

		Packet250CustomPayload packet = getTankPayload(entity, handler);
		PacketDispatcher.sendPacketToAllAround(x, y, z, range, dimensionId, packet);
	}

	private static Packet250CustomPayload getTankPayload(TileEntity entity, TankHandler handler) {

		int ints =  3 + handler.getTankCount() * 2; // x + y + z + tanks * (amount + fluidId)
		int bytes = 4 * ints;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			writeTileEntity(outputStream, entity);  
			writeTankHandler(outputStream, handler); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getCustomPacket(bos, PacketHandler.TANK_SYNC);
	}

	protected static void writeTankHandler(DataOutputStream outputStream, TankHandler handler) throws IOException {

		int tanks = handler.getTankCount();
		for (int i = 0; i < tanks; i++) {
			int amount = handler.getAmount(i);
			int fluidId = handler.getFluidID(i);
			outputStream.writeInt(amount);
			outputStream.writeInt(fluidId);
		}
	}

	protected static void readTankHandler(DataInputStream inputStream, TankHandler handler) throws IOException {
		int tanks = handler.getTankCount();
		for (int i = 0; i < tanks; i++) {
			int amount = inputStream.readInt();
			int fluidId = inputStream.readInt();
			handler.setAmount(i, amount);
			handler.setFluidId(i, fluidId);
		}
	}

	public static void handleTankSync(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		Entity playerEntity = (Entity) player;
		TileEntity tileEntity;
		boolean isAnimated;

		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		try {
			tileEntity = readTileEntity(inputStream, playerEntity.worldObj);
			if (tileEntity instanceof ITankSyncable) {
				ITankSyncable syncable = (ITankSyncable) tileEntity;
				readTankHandler(inputStream, syncable.getTankHandler());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

}
