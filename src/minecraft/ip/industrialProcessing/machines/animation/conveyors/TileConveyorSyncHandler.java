package ip.industrialProcessing.machines.animation.conveyors;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.packetHandlers.TileSyncHandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class TileConveyorSyncHandler extends TileSyncHandler {

	public static void sendConveyorData(TileEntity entity, IConveyor handler) {
		double x = entity.xCoord;
		double y = entity.yCoord;
		double z = entity.zCoord;
		int dimensionId = entity.worldObj.getWorldInfo().getVanillaDimension();
		double range = 32;

		Packet250CustomPayload packet = getConveyorPayload(entity, handler);
		PacketDispatcher.sendPacketToAllAround(x, y, z, range, dimensionId, packet);
	}

	private static Packet250CustomPayload getConveyorPayload(TileEntity entity, IConveyor handler) {

		int ints = 4 + handler.getStackCount() * 4; // x + y + z + stackCount +
													// stack * (type
													// + amount + damage +
													// source + destination +
													// progress)
		int bytes = 4 * ints;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			writeTileEntity(outputStream, entity);
			writeConveyorHandler(outputStream, handler);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getCustomPacket(bos, PacketHandler.CONVEYOR_SYNC);
	}

	protected static void writeConveyorHandler(DataOutputStream outputStream, IConveyor handler) throws IOException {

		int stackCount = handler.getStackCount();
		outputStream.writeInt(stackCount);
		for (int i = 0; i < stackCount; i++) {
			IConveyorStack movingStack = handler.getStack(i);
			ItemStack stack = movingStack.getItemStack();

			int amount = stack.stackSize;
			int itemId = stack.itemID;
			int damage = stack.getItemDamage();

			byte destination = (byte) movingStack.getDestination().ordinal();
			byte source = (byte) movingStack.getSource().ordinal();
			short progress = (short) (movingStack.getProgress() * Short.MAX_VALUE);

			outputStream.writeInt(amount);
			outputStream.writeInt(itemId);
			outputStream.writeInt(damage);
			outputStream.writeByte(destination);
			outputStream.writeByte(source);
			outputStream.writeShort(progress);
		}
	}

	protected static void readConveyorHandler(DataInputStream inputStream, IConveyor handler) throws IOException {
		int stackCount = inputStream.readInt();
		handler.clearStacks();
		for (int i = 0; i < stackCount; i++) {
			int amount = inputStream.readInt();
			int itemId = inputStream.readInt();
			int damage = inputStream.readInt();

			LocalDirection[] directions = LocalDirection.values();
			LocalDirection destination = directions[inputStream.readByte()];
			LocalDirection source = directions[inputStream.readByte()];
			float progress = inputStream.readShort() / (float) Short.MAX_VALUE;

			ItemStack stack = new ItemStack(itemId, amount, damage);

			handler.addStack(stack, destination, source, progress);
		}
	}

	public static void handleConveyorSync(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		Entity playerEntity = (Entity) player;
		TileEntity tileEntity;
		boolean isAnimated;

		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		try {
			tileEntity = readTileEntity(inputStream, playerEntity.worldObj);
			if (tileEntity instanceof IConveyor) {
				IConveyor syncable = (IConveyor) tileEntity;
				readConveyorHandler(inputStream, syncable);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
