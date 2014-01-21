package ip.industrialProcessing.power;

import ip.industrialProcessing.machines.TileEntityMachine;

import net.minecraft.nbt.NBTTagCompound;

public abstract class TileEntityPowerGenerator extends TileEntityMachine implements IPowerProducer, IPowerOutput {

    private PowerDistributorManager powerManager;
    private boolean searched = false; 

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
}
