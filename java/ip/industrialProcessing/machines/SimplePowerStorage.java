package ip.industrialProcessing.machines;

import net.minecraft.nbt.NBTTagCompound;

public class SimplePowerStorage implements IPowerStorage {

    public SimplePowerStorage(float capacity) {
        this(0, capacity);
    }

    public SimplePowerStorage(float initial, float capacity) {
        this.powerStorage = initial;
        this.powerCapacity = capacity;
    }

    private float powerStorage;
    private float powerCapacity;

    @Override
    public float getStoredPower() {
        return powerStorage;
    }

    @Override
    public float getPowerCapacity() {
        return powerCapacity;
    }

    public float drainPower(float work, boolean doDrain) {
        float maxDrain = Math.min(work, this.powerStorage);
        if (doDrain)
            this.powerStorage -= maxDrain;
        return maxDrain;
    }

    public float fillPower(float power, boolean doFill) {
        float maxFill = Math.min(power, this.powerCapacity - this.powerStorage);
        if (doFill)
            this.powerStorage += maxFill;
        return maxFill;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("PowerStorage"))
            this.powerStorage = nbt.getInteger("PowerStorage");
        else if (nbt.hasKey("StoredPower"))
            this.powerStorage = nbt.getFloat("StoredPower");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setFloat("StoredPower", this.powerStorage);
    }

    @Override
    public void setStoredPower(float power) {
        this.powerStorage = power;
    }

    @Override
    public void setPowerCapacity(float powerCapacity) {
        this.powerCapacity = powerCapacity;

    }
}
