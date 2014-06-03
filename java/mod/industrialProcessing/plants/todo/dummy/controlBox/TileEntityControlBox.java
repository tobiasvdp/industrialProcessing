package mod.industrialProcessing.plants.todo.dummy.controlBox;

import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.utils.IReceiver;
import ip.industrialProcessing.utils.IRemote;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityControlBox extends TileEntityMultiblockDummy implements IReceiver {
	public TileEntityControlBox() {
		super();
	}

	TileEntity te;
	int[] teCoord = new int[] {};

	@Override
	public boolean receiveTileEntity(IRemote remote, ItemStack itemStack) {
		teCoord = remote.getTileEntity(this, itemStack);
		te = null;
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		return true;
	}

	public TileEntity getTileEntity() {
		if (te == null && teCoord != null && teCoord.length == 3) {
			te = worldObj.getBlockTileEntity(teCoord[0], teCoord[1], teCoord[2]);
		}
		return te;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		te = null;
		if (nbt.getIntArray("storedTE") != null)
			teCoord = nbt.getIntArray("storedTE");
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		if (teCoord != null)
			nbt.setIntArray("storedTE", teCoord);
		super.writeToNBT(nbt);
	}

	public void triggerButton(int i) {
		if (getTileEntity() != null && getTileEntity() instanceof IControlBoxReceiver) {
			((IControlBoxReceiver) getTileEntity()).buttonPressed(i);
		}
	}

}
