package ip.industrialProcessing.power;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class PowerDistributorManager {

    private PowerDistributor distributor = new PowerDistributor();
    private IPowerProducer supplier;

    public PowerDistributorManager(TileEntityMachine entity, IPowerProducer supplier) {
	this.entity = entity;
	this.supplier = supplier;
    }

    protected TileEntityMachine entity;
 

    public void searchPowerAcceptors() { 
	ArrayList<PowerAcceptorConnection> connections = new ArrayList<PowerAcceptorConnection>();
	for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (supplier.canProducePower(direction))
		searchPowerAcceptor(direction, connections);
	}
	PowerAcceptorConnection[] outputs = connections.toArray(new PowerAcceptorConnection[connections.size()]);
	this.distributor.setOutputs(outputs);
	notifyUpdate();
    }

    protected void notifyUpdate() {
	entity.worldObj.markBlockForUpdate(entity.xCoord, entity.yCoord, entity.zCoord);
    }

    protected void searchPowerAcceptor(ForgeDirection direction, ArrayList<PowerAcceptorConnection> connections) {
	IPowerAcceptor acceptor = getAcceptor(direction);
	if (acceptor != null) {
	    ForgeDirection opposite = direction.getOpposite();
	    if (acceptor.canAcceptPower(opposite)) {
		connections.add(new PowerAcceptorConnection(acceptor, opposite));
	    }
	}
    }

    protected IPowerAcceptor getAcceptor(ForgeDirection direction) {
	if (this.entity.worldObj != null) {
	    TileEntity neighbor = this.entity.worldObj.getBlockTileEntity(this.entity.xCoord + direction.offsetX, this.entity.yCoord + direction.offsetY, this.entity.zCoord + direction.offsetZ);
	    if (neighbor instanceof IPowerAcceptor) {
		return (IPowerAcceptor) neighbor;
	    }
	}
	return null;
    }

    public int distributePower(int storedPower, int maxPowerPerSide, boolean doDistribute) {
	return this.distributor.distributePower(storedPower, maxPowerPerSide, doDistribute);
    }

    public void writeToNBT(NBTTagCompound nbt) {
	PowerAcceptorConnection[] connections = this.distributor.getOutputs();
	int[] directions = new int[connections.length];
	for (int i = 0; i < connections.length; i++) {
	    directions[i] = connections[i].connectedFrom.getOpposite().ordinal();
	}
	nbt.setIntArray("Cons", directions);
    }

    public void readFromNBT(NBTTagCompound nbt) {
	int[] directions = nbt.getIntArray("Cons");
	ArrayList<PowerAcceptorConnection> connections = new ArrayList<PowerAcceptorConnection>(directions.length);
	for (int i = 0; i < directions.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[directions[i]];
	    searchPowerAcceptor(direction, connections);
	}
	PowerAcceptorConnection[] outputs = connections.toArray(new PowerAcceptorConnection[connections.size()]);
	this.distributor.setOutputs(outputs);
    } 
}
