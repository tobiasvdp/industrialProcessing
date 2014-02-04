package ip.industrialProcessing.multiblock.dummy.block.displayPanel;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.multiblock.ITEmultiblock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TEmultiblockDisplayPanel extends TileEntity {

	private ITEmultiblock connect;
	private int[] coord = new int[3];
	private boolean load = true;

	public TEmultiblockDisplayPanel() {

	}
	
	public ITEmultiblock getConnect(){
		if (load){
			searchForCore();
			load = false;
		}
		return connect;
	}

	public boolean searchForCore() {
		ForgeDirection dir = getBackside(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
		TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
		if (te != null && te instanceof ITEmultiblock) {
			connect = (ITEmultiblock) te;
			System.out.println(worldObj + " found");
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			return true;
		} else
			connect = null;
		return false;

	}

	private ForgeDirection getBackside(int blockMetadata) {
		return getForwardFromMetadata(blockMetadata).getOpposite();
	}

	public static ForgeDirection getForwardFromMetadata(int metadata) {
		switch (metadata) {
		case 0:
			return ForgeDirection.NORTH;
		case 1:
			return ForgeDirection.EAST;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.WEST;
		}
		return null;
	}

	public int getModelID() {
		return 0;
	}

	public int getModelConnection() {
		if (getConnect() == null)
			return 0;
		if (getConnect().getState() == MultiblockState.CONNECTED)
			return 1;
		if (getConnect().getState() == MultiblockState.COMPLETED)
			return 2;
		return 0;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeCore(nbt);
	}
	
	private void writeCore(NBTTagCompound nbt) {
		nbt.setBoolean("load", true);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readCore(nbt);
	}

	private void readCore(NBTTagCompound nbt) {
	load = nbt.getBoolean("load");	
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.data);
	}

}
