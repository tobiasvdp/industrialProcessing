package ip.industrialProcessing.transport;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.machines.TileEntitySynced;

import java.util.Arrays;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityTransport extends TileEntitySynced implements IConnectedTile {

    protected TransportConnectionState[] states = new TransportConnectionState[6];
    private boolean unverified = true;

    public TileEntityTransport() {
	Arrays.fill(states, TransportConnectionState.NONE);
    }

    @Override
    public boolean canUpdate() {
	return unverified;
    }

    @Override
    public void updateEntity() {
	if (unverified)
	    updateConnections();
    }

    protected abstract TransportConnectionState getState(TileEntity entity, ForgeDirection direction);

    public void searchForConnections() {
	unverified = true;
    }

    private void updateConnections() {
	System.out.println("Verifying transport at " + xCoord + ", " + yCoord + ", " + zCoord + " on " + (this.worldObj.isRemote ? "client" : "server"));
	boolean modified = false;

	for (int i = 0; i < this.states.length; i++) {
	    TransportConnectionState newState = getNeighborState(ForgeDirection.VALID_DIRECTIONS[i]);
	    TransportConnectionState currentState = this.states[i];
	    if (newState != currentState) {
		this.states[i] = newState;
		modified = true;
	    }
	}
	// if the network changed, update the map
	if (modified)
	    updateNetwork();
	unverified = false; // no more ticks required to verify neighbors
	System.out.println("States at " + xCoord + ", " + yCoord + ", " + zCoord + " are  UP:" + this.states[ForgeDirection.UP.ordinal()] + " DOWN:" + this.states[ForgeDirection.DOWN.ordinal()]);
    }

    public TransportConnectionState getTransportConnection(ForgeDirection direction) {
	return states[direction.ordinal()];
    }

    protected void updateNetwork() {
	notifyBlockChange();
    }

    private TransportConnectionState getNeighborState(ForgeDirection direction) {
	TileEntity entity = getNeighbor(direction);
	return getState(entity, direction);
    }

    private TileEntity getNeighbor(ForgeDirection direction) {
	return this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);

    }

    @Override
    public ConnectionState getConnection(ForgeDirection direction) {
	return this.states[direction.ordinal()].getConnectionState();
    }

    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
	super.writeToNBT(par1nbtTagCompound);
	int[] stateInts = new int[6];
	for (int i = 0; i < stateInts.length; i++) {
	    stateInts[i] = states[i].ordinal();
	}
	par1nbtTagCompound.setIntArray("TState", stateInts);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
	super.readFromNBT(par1nbtTagCompound);
	int[] stateInts = par1nbtTagCompound.getIntArray("TState");
	for (int i = 0; i < stateInts.length; i++) {
	    states[i] = TransportConnectionState.values()[stateInts[i]];
	}
	unverified = false;
    }
}
