package ip.industrialProcessing.power;

import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class PowerDistributorManager {

    private boolean[] validLocalOutputDirections = new boolean[6];

    private IPowerProducer supplier;

    public PowerDistributorManager(TileEntityMachine entity, IPowerProducer supplier) {
	this.entity = entity;
	this.supplier = supplier;
    }

    protected TileEntityMachine entity;

    protected ArrayList<ForgeDirection> connectedDirections = new ArrayList<ForgeDirection>();
    protected boolean unDiscovered = false;

    public void searchPowerAcceptors() {
	this.unDiscovered = false;
	connectedDirections.clear();
	for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (supplier.canProducePower(direction))
		searchPowerAcceptor(direction);
	}
	notifyUpdate();
    }

    protected void notifyUpdate() {
	entity.worldObj.markBlockForUpdate(entity.xCoord, entity.yCoord, entity.zCoord);
    }

    protected void searchPowerAcceptor(ForgeDirection direction) {
	IPowerAcceptor acceptor = getAcceptor(direction);
	if (acceptor != null) {
	    if (acceptor.canAcceptPower(direction.getOpposite())) {
		connectedDirections.add(direction);
	    }
	}
    }

    protected IPowerAcceptor getAcceptor(ForgeDirection direction) {
	TileEntity neighbor = this.entity.worldObj.getBlockTileEntity(this.entity.xCoord + direction.offsetX, this.entity.yCoord + direction.offsetY, this.entity.zCoord + direction.offsetZ);
	if (neighbor instanceof IPowerAcceptor) {
	    return (IPowerAcceptor) neighbor;
	}
	return null;
    }

    public int distributePower(int storedPower, int maxPowerPerSide, boolean doAccept) {
	// the more machines connected, the less each machine gets:
	int maxPower = Math.min(maxPowerPerSide, storedPower / connectedDirections.size());
	int outputted = 0;

	IPowerAcceptor[] acceptors = new IPowerAcceptor[connectedDirections.size()];
	ForgeDirection[] directions = new ForgeDirection[connectedDirections.size()];
	for (int i = 0; i < connectedDirections.size(); i++) {
	    ForgeDirection direction = connectedDirections.get(i);
	    IPowerAcceptor acceptor = getAcceptor(direction);
	    acceptors[i] = acceptor;
	    directions[i] = direction;
	}
	return distributePower(acceptors, directions, storedPower, maxPowerPerSide, doAccept);
    }

    public static int distributePower(IPowerAcceptor[] acceptors, ForgeDirection[] acceptorSides, int maxPower, int maxPowerPerReceiver, boolean doAccept) {
	int totalUsage = 0;
	int[] usages = new int[acceptors.length];

	for (int i = 0; i < acceptors.length; i++) {
	    IPowerAcceptor acceptor = acceptors[i];
	    ForgeDirection side = acceptorSides[i];
	    if (acceptor != null) {
		int maxOutput = maxPowerPerReceiver < 0 ? maxPower : Math.min(maxPower, maxPowerPerReceiver);
		int usage = acceptor.acceptPower(maxOutput, side, false);
		// protection against abuse of acceptors that want to take to
		// much:
		usages[i] = Math.min(usage, maxOutput);
		totalUsage += usage;
	    }
	}
	if (!doAccept || totalUsage == 0) {
	    return totalUsage;
	} else {
	    int consumed = 0;
	    for (int i = 0; i < acceptors.length; i++) {
		IPowerAcceptor acceptor = acceptors[i];
		ForgeDirection side = acceptorSides[i];
		int sidePower = usages[i] * maxPower / totalUsage;
		if (acceptor != null) {
		    int usage = acceptor.acceptPower(sidePower, side, true);
		    consumed += usage;
		}
	    }
	    return consumed;
	}
    }

    public void writeToNBT(NBTTagCompound nbt) {
	int[] directions = new int[this.connectedDirections.size()];
	for (int i = 0; i < connectedDirections.size(); i++) {
	    ForgeDirection direction = connectedDirections.get(i);
	    directions[i] = direction.ordinal();
	}
	nbt.setIntArray("Cons", directions);
    }

    public void readFromNBT(NBTTagCompound nbt) {
	int[] directions = nbt.getIntArray("Cons");
	this.connectedDirections.clear();
	for (int i = 0; i < directions.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[directions[i]];
	    searchPowerAcceptor(direction);
	}
    }
}
