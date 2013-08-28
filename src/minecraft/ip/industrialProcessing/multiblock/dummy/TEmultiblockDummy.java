package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEmultiblockDummy extends TileEntity {
	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	public void setModelConnection(int modelConnection) {
		this.modelConnection = modelConnection;
	}

	private TEmultiblockCore core;
	private MultiblockState state = MultiblockState.DISCONNECTED;
	private int modelID;
	private int modelConnection;
	private int ID;

	public TEmultiblockDummy() {

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
		

		nbt.setTag("Core", nbttaglist);
		
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readCore(nbt);
	};

	private void readCore(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Core");

		NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(0);
		modelConnection = nbttagcompound1.getInteger("modelConnection");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(1);
		modelID = nbttagcompound1.getInteger("modelID");
		
		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(2);
		ID = nbttagcompound1.getInteger("ID");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(3);
		state = MultiblockState.values()[nbttagcompound1.getInteger("state")];

	}

	public boolean searchForCore() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TEmultiblockDummy) {
				TEmultiblockDummy te = (TEmultiblockDummy) neighbour;
				if(te.getCore() != null){
					TEmultiblockCore teCore = te.getCore();
					if (teCore.getState() != MultiblockState.COMPLETED && teCore.isDummyValidForStructure(this)) {
						setCore(teCore);
						notifyNeighboursOfCoreSet();
						return true;
					}else if(teCore.getState() == MultiblockState.COMPLETED && teCore.isDummyValidForStructure(this,true)){
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
				}else if(te.getState() == MultiblockState.COMPLETED && te.isDummyValidForStructure(this,true)){
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
				if(te.getCore() == null)
					te.searchForCore();
			} 
		}
	}

	private void setCore(TEmultiblockCore te) {
		core = te;
		ID = core.setDummieID(this);
		core.registerDummy(this);
		modelConnection = core.setDummieModelConnection(this);
		modelID = core.setDummieModelID(this);
	
		setBlockRotation();
		state = MultiblockState.CONNECTED;
	}
	
	public void setState(MultiblockState state){
		this.state = state;
	}
	
	public void delCore(){
		if (core!= null){
			core.unregisterDummy(this);
			core = null;
			state = MultiblockState.DISCONNECTED;
			modelID = 0;
			modelConnection = 0;
			ID = 0;
		}
	}

	public TEmultiblockCore getCore() {
		return core;
	}
	public int getModelID(){
		return modelID;
	}
	public int getModelConnection(){
		return modelConnection;
	}
	public void setBlockRotation(){
		if(core != null)
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, core.getBlockMetadata(), 1);
	}

	public int getID() {
		return ID;
	}
}
