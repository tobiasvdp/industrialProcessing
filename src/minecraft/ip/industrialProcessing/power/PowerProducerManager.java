package ip.industrialProcessing.power;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class PowerProducerManager {
    private IPowerProducer supplier;
    private TileEntity entity;

    private ArrayList<ForgeDirection> connectedDirections = new ArrayList<ForgeDirection>();
    private boolean unDiscovered = false;

    int storedPower = 0;
    int storageCapacity = 0;
    int maxPowerOutput = 1;
    int updateCount = 0;

    public PowerProducerManager(TileEntity entity, IPowerProducer supplier, int capacity, int maxOutput) {
	this.entity = entity;
	this.supplier = supplier;
	this.unDiscovered = true;
	this.storageCapacity = capacity;
	this.maxPowerOutput = maxOutput;
    }

    public void searchPowerAcceptors() {
	this.unDiscovered = false;
	connectedDirections.clear();
	for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    searchPowerAcceptor(direction);
	}
	notifyUpdate();
    }

    private void notifyUpdate() {
	entity.worldObj.markBlockForUpdate(entity.xCoord, entity.yCoord, entity.zCoord);
    }

    private void searchPowerAcceptor(ForgeDirection direction) {
	IPowerAcceptor acceptor = getAcceptor(direction);
	if (acceptor != null) {
	    if (acceptor.canAcceptPower(direction.getOpposite())) {
		connectedDirections.add(direction);
	    }
	}
    }

    private IPowerAcceptor getAcceptor(ForgeDirection direction) {
	TileEntity neighbor = this.entity.worldObj.getBlockTileEntity(this.entity.xCoord + direction.offsetX, this.entity.yCoord + direction.offsetY, this.entity.zCoord + direction.offsetZ);
	if (neighbor instanceof IPowerAcceptor) {
	    return (IPowerAcceptor) neighbor;
	}
	return null;
    }

    public void updateDistributor() {
	if (this.unDiscovered)
	    searchPowerAcceptors();
	if (!connectedDirections.isEmpty()) {
	    int production = this.supplier.producePower(storageCapacity - storedPower);
	    if (production > 0 || storageCapacity > 0) { // distribute whenever there is power
		storedPower += production;
		// this shouldn't happen if generatePower is implemented
		// correctly:
		if (storedPower > storageCapacity)
		    storedPower = storageCapacity;
		// the more machines connected, the less each machine gets:
		int maxPower = Math.min(maxPowerOutput, storedPower / connectedDirections.size());
		for (int i = 0; i < connectedDirections.size(); i++) {
		    ForgeDirection direction = connectedDirections.get(i);
		    IPowerAcceptor acceptor = getAcceptor(direction);
		    if (acceptor != null) {
			int used = acceptor.acceptPower(Math.min(storedPower, maxPower), direction.getOpposite());
			storedPower -= used;
		    }
		}
		notifyUpdate();
	    }
	}
    }

    public void writeToNBT(NBTTagCompound nbt) {
	int[] directions = new int[this.connectedDirections.size()];
	for (int i = 0; i < connectedDirections.size(); i++) {
	    ForgeDirection direction = connectedDirections.get(i);
	    directions[i] = direction.ordinal();
	}
	nbt.setInteger("PowStor", this.storedPower);
	nbt.setIntArray("Cons", directions);
    }

    public void readFromNBT(NBTTagCompound nbt) {
	this.storedPower = nbt.getInteger("PowStor");
	int[] directions = nbt.getIntArray("Cons");
	this.connectedDirections.clear();
	for (int i = 0; i < directions.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[directions[i]].getOpposite();
	    searchPowerAcceptor(direction);
	}
    }
}
