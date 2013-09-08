package ip.industrialProcessing.machines;

import net.minecraft.nbt.NBTTagCompound;

public class SimplePowerStorage implements IPowerStorage {

	public SimplePowerStorage(int capacity) {
		this(0, capacity);
	}

	public SimplePowerStorage(int initial, int capacity) {
		this.powerStorage = initial;
		this.powerCapacity = capacity;
	}

	private int powerStorage;
	private int powerCapacity;

	@Override
	public int getStoredPower() {
		return powerStorage;
	}

	@Override
	public int getPowerCapacity() {
		return powerCapacity;
	}

	public int drainPower(int work, boolean doDrain) {
		int maxDrain = Math.min(work, this.powerStorage);
		if (doDrain)
			this.powerStorage -= maxDrain;
		return maxDrain;
	}

	public int fillPower(int power, boolean doFill) {
		int maxFill = Math.min(power, this.powerCapacity - this.powerStorage);
		if (doFill)
			this.powerStorage += maxFill;
		return maxFill;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		this.powerStorage = nbt.getInteger("PowerStorage");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("PowerStorage", this.powerStorage);
	}
}
