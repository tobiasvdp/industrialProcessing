package ip.industrialProcessing.api.handlers;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.working.IWorker;

public class HandlerPower implements IHandlerPower{
	private IPowerStorage power;
	private boolean[] hasChanged;
	private int offset;

	public HandlerPower(IPowerStorage power) {
		this.power = power;
		this.hasChanged = new boolean[getValueCount()];
		for(int i = 0;i<getValueCount();i++){
		    hasChanged[i] = false;
		}
	}
	
	@Override
	public int getValueCount() {
		return 2;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return this.power.getStoredPower();
		case 1:
			return this.power.getPowerCapacity();
		}
		return 0;
	}
	
	@Override
	public int[] getValueStorage() {
		int[] value = new int[2];
		value[0] = power.getStoredPower();
		value[1] = power.getPowerCapacity();
		return value;
	}

	public static InfoPower getInfo(IHandlerPower handler)
	{
		InfoPower info = new InfoPower();
		int[] values = handler.getValueStorage();
		info.storedPower = values[0];
		info.powerCapacity = values[1];
		return info;
	}

	@Override
	public boolean hasChanged(int i) {
	    return hasChanged[i];
	}

	@Override
	public int getIndexOffset() {
	    return this.offset;
	}

	@Override
	public void setIndexOffset(int offset) {
	    this.offset = offset;
	}

	@Override
	public void put(int index, int par2) {
	    hasChanged[index] = true;
		switch (index) {
		case 0:
			this.power.setStoredPower(par2);
		case 1:
			this.power.setPowerCapacity(par2);
		}
	}
}
