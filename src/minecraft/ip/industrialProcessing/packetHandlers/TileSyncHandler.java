package ip.industrialProcessing.packetHandlers;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.multiblock.machineFrame.TileEntityMachineFrame;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorkSyncable;
import ip.industrialProcessing.utils.working.Worker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class TileSyncHandler {

	public static void handleWorkSync(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {

		Entity playerEntity = (Entity) player;
		TileEntity tileEntity;
		int totalWork;
		int workDone;

		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));
		try {
			tileEntity = readTileEntity(inputStream, playerEntity.worldObj);
			totalWork = inputStream.readInt();
			workDone = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		if (tileEntity instanceof IWorkSyncable) {
			IWorkSyncable syncable = (IWorkSyncable) tileEntity;
			syncable.setWorkDone(workDone);
			syncable.setTotalWork(totalWork);
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
		outputStream.write(entity.xCoord);
		outputStream.write(entity.yCoord);
		outputStream.write(entity.zCoord);
	}

	public static void sendWorkSync(TileEntityMachine tileEntityFilter) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
 
		Worker worker = tileEntityFilter.getWorker();
			try {
				writeTileEntity(outputStream, tileEntityFilter);
				outputStream.writeInt(worker.getWorkDone());
				outputStream.writeInt(worker.getTotalWork());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			sendCustomPacket(bos, PacketHandler.WORK_SYNC);

	}

	private static void sendCustomPacket(ByteArrayOutputStream bos, String name) {

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = name;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToAllPlayers(packet); 
	}

}
