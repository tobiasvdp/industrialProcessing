package ip.industrialProcessing.power.storage;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.PowerTransfers;
import net.minecraft.nbt.NBTTagCompound;

public class PowerStorageEnergyCell implements IPowerStorage {

    private int slotCount;
    private int startSlot;
    private TileEntityEnergyCell cell;

    // two batteries internal capacity
    private float storedJoules = 0;
    private float totalJouleCapacity = 200000;

    public PowerStorageEnergyCell(TileEntityEnergyCell tileEntityEnergyCell, int i, int bATTERY_SLOTS) {
        this.cell = tileEntityEnergyCell;
        this.startSlot = i;
        this.slotCount = bATTERY_SLOTS;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        this.storedJoules = nbt.getFloat("Charge");
        this.totalJouleCapacity = nbt.getFloat("Capacity");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setFloat("Charge", this.storedJoules);
        nbt.setFloat("Capacity", this.totalJouleCapacity);
    }

    public float getTotalJouleCapacity() {
        return totalJouleCapacity + getTotalJoulesFromBatteries();
    }

    private float getTotalJoulesFromBatteries() {
        int total = 0;
        for (int i = 0; i < slotCount; i++) {
            total += PowerTransfers.getBatteryMaxCharge(cell.getStackInSlot(i + startSlot));
        }
        return total;
    }

    public float getStoredJoules() {
        float total = storedJoules + getJoulesFromBatteries();
        return total;
    }

    private float getJoulesFromBatteries() {
        int total = 0;
        for (int i = 0; i < slotCount; i++) {
            total += PowerTransfers.getBatteryCharge(cell.getStackInSlot(i + startSlot));
        }
        return total;
    }

    public void setTotalJoules(float totalJoules) {
        // TODO: slowly rebalance, not instant?
        float leftover = totalJoules;
        float[] caps = new float[slotCount];
        float totalCap = this.totalJouleCapacity;
        for (int i = 0; i < slotCount; i++) {
            totalCap += caps[i] = PowerTransfers.getBatteryMaxCharge(cell.getStackInSlot(i + startSlot));
        }
        for (int i = 0; i < slotCount; i++) {
            float amount = totalJoules * caps[i] / totalCap;
            if (amount > 0)
                leftover -= amount - PowerTransfers.setBatteryCharge(cell.getStackInSlot(i + startSlot), amount);
        }
        this.storedJoules = leftover;
        cell.onInventoryChanged();
    }

    public void addTotalJoules(float energy) {
        float totalJoules = getStoredJoules() + energy;
        setTotalJoules(totalJoules);
    }

    @Override
    public float getStoredPower() {
        return getStoredJoules();
    }

    @Override
    public float getPowerCapacity() {
        return getTotalJouleCapacity();
    }

    @Override
    public void setStoredPower(float power) {
        setTotalJoules(power);
    }

    @Override
    public void setPowerCapacity(float powerCapacity) {
    }

    @Override
    public float fillPower(float amount, boolean doFill) {
        int stored = (int) Math.ceil(this.getStoredJoules());
        int cap = (int) Math.floor(this.getTotalJouleCapacity());
        amount = Math.min(cap - stored, amount);
        if (doFill)
            addTotalJoules(amount);
        return amount;
    }

    @Override
    public float drainPower(float amount, boolean doDrain) {
        float stored = this.getStoredJoules();
        amount = Math.min(stored, amount);
        if (doDrain)
            addTotalJoules(-amount);
        return amount;
    }

    public int getBatteryCount() {
        int count = 0;
        for (int i = 0; i < slotCount; i++) {
            if (PowerTransfers.isBattery(cell.getStackInSlot(i + startSlot))) {
                count++;
            }
        }
        return count;
    }
}
