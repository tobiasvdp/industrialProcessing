package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEmultiblockDummy extends TileEntity implements ITEmultiblockDummy {
	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	public void setModelConnection(int modelConnection) {
		this.modelConnection = modelConnection;
	}

	protected TEmultiblockCore core;
	protected boolean loadedFromNBT;
	protected int[] coreDataFromNBT;
	private MultiblockState state = MultiblockState.DISCONNECTED;
	private int modelID;
	private int modelConnection;
	private int groupID;
	protected int ID;

	public TEmultiblockDummy() {

	}

	public TEmultiblockCore getCore() {
		if (loadedFromNBT) {
			core = (TEmultiblockCore) worldObj.getBlockTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
			loadedFromNBT = false;
		}
		return core;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeCore(nbt);
	}

	private void writeCore(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();

		NBTTagCompound nbtComp = new NBTTagCompound();
		nbtComp.setInteger("modelConnection", modelConnection);
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("modelID", modelID);
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("ID", ID);
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("state", state.ordinal());
		nbttaglist.appendTag(nbtComp);
		
		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("groupID", groupID);
		nbttaglist.appendTag(nbtComp);

		NBTTagList nbttaglistCore = new NBTTagList();

		if (getCore() != null) {
			nbtComp = new NBTTagCompound();
			nbtComp.setInteger("x", getCore().xCoord);
			nbttaglistCore.appendTag(nbtComp);

			nbtComp = new NBTTagCompound();
			nbtComp.setInteger("y", getCore().yCoord);
			nbttaglistCore.appendTag(nbtComp);

			nbtComp = new NBTTagCompound();
			nbtComp.setInteger("z", getCore().zCoord);
			nbttaglistCore.appendTag(nbtComp);
		}

		nbt.setTag("Data", nbttaglist);
		nbt.setTag("Core", nbttaglistCore);

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readCore(nbt);
	};

	private void readCore(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Data");

		NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(0);
		modelConnection = nbttagcompound1.getInteger("modelConnection");
		

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(1);
		modelID = nbttagcompound1.getInteger("modelID");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(2);
		ID = nbttagcompound1.getInteger("ID");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(3);
		state = MultiblockState.values()[nbttagcompound1.getInteger("state")];
		
		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(4);
		groupID = nbttagcompound1.getInteger("groupID");

		nbttaglist = nbt.getTagList("Core");

		if (nbttaglist.tagCount() != 0) {
			nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(0);
			int x = nbttagcompound1.getInteger("x");

			nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(1);
			int y = nbttagcompound1.getInteger("y");

			nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(2);
			int z = nbttagcompound1.getInteger("z");

			loadedFromNBT = true;
			coreDataFromNBT = new int[] { x, y, z };

		}

	}

	public boolean searchForCore() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TEmultiblockDummy) {
				TEmultiblockDummy te = (TEmultiblockDummy) neighbour;
				if (te.getCore() != null) {
					TEmultiblockCore teCore = te.getCore();
					if (teCore.getState() != MultiblockState.COMPLETED && teCore.isDummyValidForStructure(this)) {
						setCore(teCore);
						notifyNeighboursOfCoreSet();
						return true;
					} else if (teCore.getState() == MultiblockState.COMPLETED && teCore.isDummyValidForStructure(this, true)) {
						setCore(teCore);
						notifyNeighboursOfCoreSet();
						return true;
					}
				}
			} else if (neighbour instanceof TEmultiblockCore) {
				TEmultiblockCore te = (TEmultiblockCore) neighbour;
				if (te.getState() != MultiblockState.COMPLETED && te.isDummyValidForStructure(this)) {
					setCore(te);
					notifyNeighboursOfCoreSet();
					return true;
				} else if (te.getState() == MultiblockState.COMPLETED && te.isDummyValidForStructure(this, true)) {
					setCore(te);
					notifyNeighboursOfCoreSet();
					return true;
				}
			}
		}
		return false;
	}

	private void notifyNeighboursOfCoreSet() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TEmultiblockDummy) {
				TEmultiblockDummy te = (TEmultiblockDummy) neighbour;
				if (te.getCore() == null)
					te.searchForCore();
			}
		}
	}

	private void setCore(TEmultiblockCore te) {
		core = te;
		ID = getCore().setDummieID(this);
		getCore().registerDummy(this);
		modelConnection = getCore().setDummieModelConnection(this);
		modelID = getCore().setDummieModelID(this);

		setBlockRotation();
		state = MultiblockState.CONNECTED;
	}

	public void setState(MultiblockState state) {
		this.state = state;
	}

	public void delCore() {
		if (getCore() != null) {
			getCore().unregisterDummy(this);
			core = null;
			state = MultiblockState.DISCONNECTED;
			modelID = 0;
			modelConnection = 0;
			ID = 0;
		}
	}

	public int getModelID() {
		return modelID;
	}

	public int getModelConnection() {
		return modelConnection;
	}

	public void setGroup(int id) {
		groupID = id;
	}

	public int getGroup() {
		return groupID;
	}

	public void setBlockRotation() {
		if (getCore() != null)
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, getCore().getBlockMetadata(), 1);
	}

	public int getID() {
		return ID;
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.customParam1);
	}

	@Override
	public MultiblockState getState() {
		return state;
	}

	@Override
	public int getX() {
		return this.xCoord;
	}

	@Override
	public int getY() {
		return this.yCoord;
	}

	@Override
	public int getZ() {
		return this.zCoord;
	}

	@Override
	public ForgeDirection getForwardDirection() {
		if (getCore() != null)
			return this.getCore().getForwardDirection();
		return ForgeDirection.NORTH;
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canWrenchRotate() {
		return false;
	}
}
