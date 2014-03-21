package mod.industrialProcessing.blockContainer.machine.generator;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInv;
import mod.industrialProcessing.power.network.IPowerOutput;
import mod.industrialProcessing.power.network.IPowerProducer;
import mod.industrialProcessing.power.network.PowerDistributorManager;
import mod.industrialProcessing.utils.handlers.numbers.IProgressable;
import net.minecraft.nbt.NBTTagCompound;

public abstract class TileEntityPowerGenerator extends TileEntityMachineInv implements IPowerProducer, IPowerOutput, IProgressable {

    private PowerDistributorManager powerManager;
    private boolean searched = false;
    protected float lastCharge;

    public TileEntityPowerGenerator() {

        this.powerManager = new PowerDistributorManager(this, this);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.powerManager.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        this.powerManager.writeToNBT(nbt);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!searched)
            searchForPowerAcceptors();

        this.powerManager.distributePower(this, this.worldObj);
    }

    public void searchForPowerAcceptors() {
        this.searched = true;
        this.powerManager.searchPowerAcceptors();
    }

    @Override
    public float getProgress(int index) {
        switch (index) {
        case 0:
            return getVoltage();
        case 1:
            return lastCharge;
        case 2:
            return lastCharge * getVoltage();
        }
        return 0;
    }

    @Override
    public float getMaxProgress(int index) {
        switch (index) {
        case 0:
            return 250;
        case 1:
            return 200;
        case 2:
            return 10000;
        }
        return 0;
    }

    @Override
    public float getCharge(float q) {
        this.lastCharge = q;
        return q;
    }
}
