package ip.industrialProcessing.machines;

import ip.industrialProcessing.gui.IGuiLayoutTriggerAcceptor;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySynced extends TileEntity implements IGuiLayoutTriggerAcceptor {
	int[] buttonState = new int[1];
	int[] dataState = new int[1];

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.data);
		this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

	protected void notifyBlockChange() {
		if (!this.worldObj.isRemote) {
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];// maybe this number needs to be
			// corrected
			String methodName = e.getMethodName();
			String className = e.getClassName();
		}

	}

	@Override
	public void triggerButton(int id) {

		if (this instanceof IStateConfig) {
			int stateValue = ((IStateConfig) this).getStateValue(id) + 1;
			if (stateValue > ((IStateConfig) this).getMaxStateValue(id))
				stateValue = ((IStateConfig) this).getMinStateValue(id);
			((IStateConfig) this).setStateValue(id, stateValue);
			setButtonState(id, stateValue);
			System.out.println("Button " + id + " on " + stateValue);
		}
	}

	@Override
	public int getButtonState(int id) {
		if (buttonState.length > id)
			return buttonState[id];
		return 0;
	}

	@Override
	public int setButtonState(int id, int par2) {
		while (buttonState.length <= id) {
			int[] temp = new int[buttonState.length*2];
			for(int i =0;i<buttonState.length;i++){
				temp[i] = buttonState[i];
			}
			buttonState = temp;
		}
		buttonState[id] = par2;
		return par2;
	}

	@Override
	public int getDataViewState(int id) {
		if (dataState.length > id)
			return dataState[id];
		return 0;
	}

	@Override
	public int setDataViewState(int id, int par2) {
		while (dataState.length <= id) {
			int[] temp = new int[dataState.length*2];
			for(int i =0;i<dataState.length;i++){
				temp[i] = dataState[i];
			}
			dataState = temp;
		}
		dataState[id] = par2;
		return par2;
	}
}
