package ip.industrialProcessing.api.handlers;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.working.IWorker;

public class HandlerPower implements IHandlerPower{
	private IPowerStorage power;

	public HandlerPower(IPowerStorage power) {
		this.power = power;
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
}
