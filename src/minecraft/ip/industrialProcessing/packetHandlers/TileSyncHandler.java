package ip.industrialProcessing.packetHandlers;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.multiblock.machineFrame.TileEntityMachineFrame; 
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

	public static void handleAnimationSync(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {

		Entity playerEntity = (Entity) player;
		TileEntity tileEntity;
		boolean isAnimated;

		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));
		try {
			tileEntity = readTileEntity(inputStream, playerEntity.worldObj);
			isAnimated = inputStream.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
 
	}

	private static TileEntity readTileEntity(DataInputStream inputStream,
			World worldObj) throws IOException {

		int xcoord = inputStream.readInt();
		int ycoord = inputStream.readInt();
		int zcoord = inputStream.readInt();
		return worldObj.getBlockTileEntity(xcoord, ycoord, zcoord);
	}

	private static void writeTileEntity(DataOutputStream outputStream,
			TileEntity entity) throws IOException {
		outputStream.writeInt(entity.xCoord);
		outputStream.writeInt(entity.yCoord);
		outputStream.writeInt(entity.zCoord);
	}

	public static void sendIsAnimatedSync(TileEntity entity) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream(4 * 5);
		DataOutputStream outputStream = new DataOutputStream(bos);
 
		try {
			writeTileEntity(outputStream, entity); // 3 * 4 bytes

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		PacketHandler.sendCustomPacket(bos, PacketHandler.ANIMATION_SYNC);

	}

	public static void sendNbt(TileEntity tileEntity) {
		Packet packet = tileEntity.getDescriptionPacket();
		PacketHandler.sendPacket(packet);
	}

}
