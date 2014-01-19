package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
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

public class TileEntityMultiblockDummy extends TileEntity implements ITileEntityMultiblockDummy {
	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	public void setModelConnection(int modelConnection) {
		this.modelConnection = modelConnection;
	}

	protected TileEntityMultiblockCore core;
	protected boolean loadedFromNBT;
	protected int[] coreDataFromNBT;
	private MultiblockState state = MultiblockState.DISCONNECTED;
	private boolean needRenderUpdate = false;
	private int modelID;
	private int modelConnection;
	private int groupID;
	protected int ID;
	protected FacingDirection side = FacingDirection.North;

	public TileEntityMultiblockDummy() {

	}

	public TileEntityMultiblockCore getCore() {
		if (loadedFromNBT) {
			core = (TileEntityMultiblockCore) worldObj.getBlockTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
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
		nbtComp.setBoolean("needRenderUpdate", needRenderUpdate);
		nbttaglist.appendTag(nbtComp);
		
		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("groupID", groupID);
		nbttaglist.appendTag(nbtComp);
		
		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("forward", side.ordinal());
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
		needRenderUpdate = nbttagcompound1.getBoolean("needRenderUpdate");
		
		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(5);
		groupID = nbttagcompound1.getInteger("groupID");
		
		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(6);
		side = FacingDirection.values()[nbttagcompound1.getInteger("forward")];

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
			if (neighbour instanceof TileEntityMultiblockDummy) {
				TileEntityMultiblockDummy te = (TileEntityMultiblockDummy) neighbour;
				if (te.getCore() != null) {
					TileEntityMultiblockCore teCore = te.getCore();
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
			} else if (neighbour instanceof TileEntityMultiblockCore) {
				TileEntityMultiblockCore te = (TileEntityMultiblockCore) neighbour;
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
			if (neighbour instanceof TileEntityMultiblockDummy) {
				TileEntityMultiblockDummy te = (TileEntityMultiblockDummy) neighbour;
				if (te.getCore() == null)
					te.searchForCore();
			}
		}
	}

	private void setCore(TileEntityMultiblockCore te) {
		core = te;
		ID = getCore().setDummieID(this);
		getCore().registerDummy(this);
		modelConnection = getCore().setDummieModelConnection(this);
		modelID = getCore().setDummieModelID(this);

		setBlockRotation();
		state = MultiblockState.CONNECTED;
		
		onSetCore();
	}

	public void onSetCore() {
		
	}

	public void setState(MultiblockState state) {
		this.state = state;
		needRenderUpdate = true;
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(needRenderUpdate){
			this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
			needRenderUpdate = false;
		}
		super.updateEntity();
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
		return FacingDirectionToForge(side);
	}

	private ForgeDirection FacingDirectionToForge(FacingDirection side2) {
		switch (side2) {
		case East:
			return ForgeDirection.WEST;
		case Invalid:
			return ForgeDirection.UNKNOWN;
		case North:
			return ForgeDirection.NORTH;
		case South:
			return ForgeDirection.SOUTH;
		case West:
			return ForgeDirection.EAST;
		default:
			return ForgeDirection.UNKNOWN;

		}
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {

	}

	@Override
	public boolean canWrenchRotate() {
		return false;
	}

	@Override
	public Tiers getTier() {
		if (getCore() != null)
			return this.getCore().getTier();
		return Tiers.Invalid;
	}

	public void onDestroy() {
		
	}
	
	public void setsideFromMetadata(int dir) {
		switch (dir) {
		case 1: {
			side = FacingDirection.West;
			break;
		}
		case 2: {
			side = FacingDirection.North;
			break;
		}
		case 3: {
			side = FacingDirection.East;
			break;
		}
		case 0: {
			side = FacingDirection.South;
			break;
		}
		default: {
			side = FacingDirection.North;
		}
		}
	}
}
