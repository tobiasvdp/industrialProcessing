package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.PowerTransfers;
import ip.industrialProcessing.utils.handler.fuel.IBurner;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityElectricHeater extends TileEntityMachine implements IPoweredMachine, IPowerAcceptor, IWorkingEntity, IWorkHandler, IBurner {

    private static final LocalDirection POWER_INPUT_SIDE = LocalDirection.LEFT;
    private static final int STORAGE_CAPACITY = 10000;
    private SimplePowerStorage powerStorage;
    private ServerWorker worker;
    private int airTime;

    public TileEntityElectricHeater() {
        addStack(null, (LocalDirection) null, true, false);
        this.powerStorage = new SimplePowerStorage(STORAGE_CAPACITY);
        this.worker = new ServerWorker(this, 100);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.worker.readFromNBT(nbt);
        this.powerStorage.readFromNBT(nbt);
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        this.powerStorage.writeToNBT(nbt);
        this.worker.writeToNBT(nbt);
        super.writeToNBT(nbt);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        int drain = 100;
        float maxSpeed = 5;
        float speed = this.powerStorage.getStoredPower() / this.powerStorage.getPowerCapacity() * maxSpeed;
        int amount = (int) (this.powerStorage.drainPower(speed * drain, false));
        this.worker.doWork((int) (this.powerStorage.drainPower(amount, true) / drain));
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        if (slot == 0) {
            return PowerTransfers.isBattery(new ItemStack(itemID, 1, 0));
        }
        return false;
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
        return PowerHelper.getResistanceForStorage(this.powerStorage);
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
        ForgeDirection inputSide = DirectionUtils.getWorldDirection(POWER_INPUT_SIDE, this.getForwardDirection());
        if (inputSide == side) {
            this.powerStorage.fillPower(PowerHelper.getEnergy(coulombs, voltage), true);
        }
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        ForgeDirection inputSide = DirectionUtils.getWorldDirection(POWER_INPUT_SIDE, this.getForwardDirection());
        return (inputSide == side);
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
        return this.powerStorage;
    }

    @Override
    public int getBurnTime() {
        return this.worker.getTotalWork() - this.worker.getWorkDone();
    }

    @Override
    public int getMaxBurnTime() {
        return this.worker.getTotalWork();
    }

    @Override
    public boolean hasWork() {
        return true;
    }

    @Override
    public boolean canWork() {
        return this.worker.getWorkDone() > 0 || this.powerStorage.getStoredPower() > 0;
    }

    @Override
    public void workDone() {

    }

    @Override
    public void prepareWork() {

    }

    @Override
    public void workCancelled() {

    }

    @Override
    public void workProgressed(int amount) {
        if (HeaterUtils.increaseHeat(amount / 2.5f, this, ForgeDirection.UP)) {
            airTime++;
            if (airTime >= 5 * 20) {
                HeaterUtils.ignite(this, ForgeDirection.UP);
                airTime = 0;
            }
        } else
            airTime = 0;
    }

    @Override
    public void beginWork() {

    }

    @Override
    public TileEntity getTileEntity() {
        return this;
    }

    @Override
    public IWorker getWorker() {
        return this.worker;
    }

}
