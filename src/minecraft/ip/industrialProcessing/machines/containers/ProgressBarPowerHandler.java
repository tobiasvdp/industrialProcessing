package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.IPowerStorage;

public class ProgressBarPowerHandler implements IProgressBarHandler {

	private IPowerStorage storage;

	public ProgressBarPowerHandler(IPowerStorage storage) {
		this.storage = storage;
	}

	@Override
	public int getValueCount() {
		return 2;
	}

	@Override
	public int getValue(int i) {
		switch(i)
		{
		case 0:
			return storage.getStoredPower();
		case 1:
			return storage.getPowerCapacity();
		}
		return 0;
	}
	
	public static ProgressInfoPower getInfo(ProgressBarHandlerInfo info)
	{
		int[] values = info.getValueStorage();
		ProgressInfoPower value = new ProgressInfoPower();
		value.powerCapacity = values[1];
		value.storedPower = values[0];
		return value;
	}

}
