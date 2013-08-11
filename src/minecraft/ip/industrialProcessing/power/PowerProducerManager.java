package ip.industrialProcessing.power;

import ip.industrialProcessing.machines.TileEntityMachine;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class PowerProducerManager extends PowerDistributorManager {

    int storedPower = 0;
    int storageCapacity = 0;
    int maxPowerOutput = 1;
    int updateCount = 0;
    private IPowerProducer supplier;

    public PowerProducerManager(TileEntityMachine entity, IPowerProducer supplier, int capacity, int maxOutput) {
	super(entity, supplier);
	this.supplier = supplier;
	this.storageCapacity = capacity;
	this.maxPowerOutput = maxOutput;
    }

    public void updateDistributor() {
	if (this.unDiscovered)
	    searchPowerAcceptors();
	int production = this.supplier.producePower(storageCapacity - storedPower);
	this.storedPower += production;
	// sense the network for demand (distributor updates the power
	// distribution internally in this call)
	int desiredPower = this.distributePower(storedPower, maxPowerOutput, false);
	// fulfill the demand of the network
	this.storedPower -= this.distributePower(storedPower, maxPowerOutput, true);

	notifyUpdate();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("PowStor", this.storedPower);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storedPower = nbt.getInteger("PowStor");
    }
}
