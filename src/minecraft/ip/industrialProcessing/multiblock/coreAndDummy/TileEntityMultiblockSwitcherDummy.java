package ip.industrialProcessing.multiblock.coreAndDummy;

import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.extend.TileEntityMultiblockDummyInvAndTank;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityMultiblockSwitcherDummy extends TileEntityMultiblockDummyInvAndTank implements ITileEntityMultiblockSwitcher {

	private boolean isCore = false;

	public void switchToCore() {
		System.out.println("switching to Core");
		if (requirementToBecomeCore()) {
			NBTTagCompound nbtTag = new NBTTagCompound();
			this.writeToNBT(nbtTag);
			nbtTag.setString("id", unlocalizedCoreName());
			nbtTag.setBoolean("isCore", true);
			nbtTag.removeTag("Core");
			NBTTagList tag = nbtTag.getTagList("Data");
			nbtTag.removeTag("Data");
			nbtTag.setTag("Core", tag);
			TileEntity te = TileEntity.createAndLoadEntity(nbtTag);
			worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
			((TileEntityMultiblockSwitcherCore) te).notifyOnCreation();
		}
	}

	public abstract boolean requirementToBecomeCore();

	public abstract String unlocalizedCoreName();

	@Override
	public boolean isCore() {
		return isCore;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		isCore = nbt.getBoolean("isCore");
		if (isCore && worldObj.isRemote) {
			System.out.println("need to switch to core");
			TileEntity te = TileEntity.createAndLoadEntity(nbt);
			worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
			((TileEntityMultiblockSwitcherCore) te).notifyOnCreation();
		} else {
			super.readFromNBT(nbt);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("isCore", isCore);
		super.writeToNBT(nbt);
	}

}
