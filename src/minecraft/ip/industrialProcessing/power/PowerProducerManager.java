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
	if (!connectedDirections.isEmpty()) {
	    int production = this.supplier.producePower(storageCapacity - storedPower);
	    if (production > 0 || storageCapacity > 0) { // distribute whenever
							 // there is power
		storedPower += production;
		// this shouldn't happen if generatePower is implemented
		// correctly:
		if (storedPower > storageCapacity)
		    storedPower = storageCapacity;
		this.distributePower(storedPower, maxPowerOutput, true);
		notifyUpdate();
	    }
	}
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
