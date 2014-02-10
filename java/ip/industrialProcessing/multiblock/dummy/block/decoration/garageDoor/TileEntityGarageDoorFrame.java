package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.block.decoration.garageDoor.TileEntityGarageDoor;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.EntityGarageDoor;
import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.network.packet.Packet250CustomPayload;

public class TileEntityGarageDoorFrame extends TileEntityMultiblockDummy {

	boolean isCreated = true;

	@Override
	public TileEntityGarageDoor getCore() {
		TileEntityMultiblockCore te = super.getCore();
		if (te != null)
			return (TileEntityGarageDoor) te;
		return null;
	}

	public TileEntityGarageDoorFrame() {
		super();
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (isCreated && getCore() != null) {
			giveHeightToCore();
			generateGarageDoor();
			isCreated = false;
		}
	}

	@Override
	public void onSetCore() {
		super.onSetCore();
		giveHeightToCore();
		generateGarageDoor();
	}

	private void giveHeightToCore() {
		int height = 0;
		boolean cont = true;
		while (cont) {
			height++;
			if (this.worldObj.getBlockId(xCoord, yCoord - height, zCoord) != 0 && this.worldObj.getBlockId(xCoord, yCoord - height, zCoord) != IndustrialProcessing.blockGarageDoorDoor.blockID) {
				height--;
				cont = false;
			}
		}
		if (getCore() != null) {
			getCore().setHeight(height, this.getID(), true);
		}
	}

	public int getHeight() {
		if (getCore() != null) {
			return getCore().getHeight();
		}
		return 0;
	}

	private ArrayList<int[]> doors = new ArrayList<int[]>();
	private boolean isDestroying = false;

	public void generateGarageDoor() {
		if (!isDestroying && getCore() != null && !getCore().isOpen()) {
			doors.clear();
			int height = getHeight();
			if (height > 0) {
				for (int i = 1; i <= height; i++) {
					if (this.worldObj.getBlockId(xCoord, yCoord - i, zCoord) != IndustrialProcessing.blockGarageDoorDoor.blockID) {
						this.worldObj.setBlock(xCoord, yCoord - i, zCoord, IndustrialProcessing.blockGarageDoorDoor.blockID);	
					}
					((TileEntityGarageDoorDoor) this.worldObj.getBlockTileEntity(xCoord, yCoord - i, zCoord)).setForwardDirection(getForwardDirection());
					doors.add(new int[] { xCoord, yCoord - i, zCoord });
				}
			}
		}
	}

	private void clearOldGarageDoor() {
		for (int i = 0; i < doors.size(); i++) {
			int[] xyz = doors.get(i);
			int x = xyz[0];
			int y = xyz[1];
			int z = xyz[2];
			int id = this.worldObj.getBlockId(x, y, z);
			if (id == IndustrialProcessing.blockGarageDoorDoor.blockID) {
				this.worldObj.setBlockToAir(x, y, z);
			}
		}
		doors.clear();
	}

	public void onDestroy() {
		isDestroying = true;
		clearOldGarageDoor();
		if (getCore() != null) {
			getCore().setHeight(-1, this.getID(), true);
		}
		super.onDestroy();
	}

	public void rise() {
		convertAllToEntity();
		getCore().doneWorking();
	}

	private void hideGarageDoor(ArrayList<int[]> doors2) {
		for (int i = 0; i < doors2.size(); i++) {
			if (worldObj.getBlockTileEntity(doors2.get(i)[0], doors2.get(i)[1], doors2.get(i)[2]) != null) {
				TileEntityGarageDoorDoor te = (TileEntityGarageDoorDoor) worldObj.getBlockTileEntity(doors2.get(i)[0], doors2.get(i)[1], doors2.get(i)[2]);
				te.hide();
			}
		}
	}

	public void convertAllToEntity() {
		ArrayList<int[]> doors = new ArrayList<int[]>();
		doors.addAll(this.doors);
		hideGarageDoor(doors);
		this.doors.clear();
		for (int i = 0; i < doors.size(); i++) {
			EntityGarageDoor en = new EntityGarageDoor(worldObj, (doors.get(i)[0] + 0.5), (doors.get(i)[1]), (doors.get(i)[2] + 0.5), this.yCoord, true, this);
			if (!worldObj.isRemote) {
				sendSpawnPackets((doors.get(i)[0] + 0.5), (doors.get(i)[1]), (doors.get(i)[2] + 0.5), this.yCoord, true, this);
			}
		}
	}

	public void fall() {
		int height = getHeight();
		for (int i = height; i >= 1; i--) {
			if (!worldObj.isRemote) {
				sendSpawnPackets((xCoord + 0.5), (yCoord - i + height), (zCoord + 0.5), this.yCoord - i, false, this);
			}
		}
	}

	private void sendSpawnPackets(double d, int i, double e, int j, boolean b, TileEntityGarageDoorFrame tileEntityGarageDoorFrame) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt((int) (d * 1000));
			outputStream.writeInt((int) (i * 1000));
			outputStream.writeInt((int) (e * 1000));
			outputStream.writeInt(j);
			outputStream.writeBoolean(b);
			outputStream.writeInt(tileEntityGarageDoorFrame.xCoord);
			outputStream.writeInt(tileEntityGarageDoorFrame.yCoord);
			outputStream.writeInt(tileEntityGarageDoorFrame.zCoord);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.IP_ENTITY_SPAWNGARAGEDOOR;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToAllAround(this.xCoord, this.yCoord, this.zCoord, 30, this.worldObj.provider.dimensionId, packet);
	}

	public void addToDoors(int... ints) {
		int height = getHeight();
		doors.add(ints);
		if (doors.size() == height) {
			getCore().doneWorking();
		}
	}
}
