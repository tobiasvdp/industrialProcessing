package ip.industrialProcessing.power.wire;

import java.lang.reflect.Array;
import java.util.Arrays;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerEntity;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.IPowerWire;
import ip.industrialProcessing.power.WireConnectionState;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityWire extends TileEntity implements IConnectedTile, IPowerAcceptor, IPowerWire {

    PowerDistributor distributor = new PowerDistributor();
    private WireConnectionState[] states = new WireConnectionState[6];

    public TileEntityWire() {
	Arrays.fill(states, WireConnectionState.NONE);
    }

    private boolean unverified = true;

    @Override
    public boolean canUpdate() {
	return unverified;
    }

    @Override
    public void updateEntity() {
	verifyNeighbors();
    }

    private WireConnectionState getState(IPowerEntity powerEntity, ForgeDirection direction) {
	// nothing? no connection:
	if (powerEntity == null)
	    return WireConnectionState.NONE;
	// wire? wire connection:
	if (powerEntity instanceof TileEntityWire)
	    return WireConnectionState.WIRE;
	// acceptor? output connection:
	if (powerEntity instanceof IPowerAcceptor) {
	    IPowerAcceptor acceptor = (IPowerAcceptor) powerEntity;
	    if (acceptor.canAcceptPower(direction.getOpposite()))
		return WireConnectionState.OUTPUT;
	}
	// producer? input connection:
	if (powerEntity instanceof IPowerProducer) {
	    IPowerProducer producer = (IPowerProducer) powerEntity;
	    if (producer.canOutputPower(direction.getOpposite()))
		return WireConnectionState.INPUT;
	}
	// missed something? don't care about it:
	return WireConnectionState.NONE;
    }

    public void verifyNeighbors() {
	boolean modified = false;

	for (int i = 0; i < this.states.length; i++) {
	    WireConnectionState newState = getNeighborState(ForgeDirection.VALID_DIRECTIONS[i]);
	    WireConnectionState currentState = this.states[i];
	    if (newState != currentState) {
		this.states[i] = newState;
		// don't care about added inputs, this doesn't change the
		// network

		boolean inputAdded = newState == WireConnectionState.INPUT;
		boolean inputRemoved = currentState == WireConnectionState.INPUT;
		if (!inputAdded && !inputRemoved)
		    modified = true;
	    }
	}
	// if the network changed, update the map
	if (modified)
	    updateNetwork();
	unverified = false; // no more ticks required to verify neighbors
    }

    private void updateNetwork() {
	WireNetworkMap.UpdateNetworkAt(worldObj, xCoord, yCoord, zCoord);
	System.out.println("network around " + xCoord + ", " + yCoord + ", " + zCoord + " found " + this.distributor.getOutputs().length+ " outputs");
    }

    private WireConnectionState getNeighborState(ForgeDirection direction) {
	IPowerEntity entity = getNeighbor(direction);
	return getState(entity, direction);
    }

    private IPowerEntity getNeighbor(ForgeDirection direction) {
	TileEntity entity = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	if (entity instanceof IPowerEntity)
	    return (IPowerEntity) entity;
	return null;
    }

    @Override
    public ConnectionState getConnection(ForgeDirection direction) {
	return states[direction.ordinal()].getConnectionState();
    }

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	return distributor.distributePower(maxAmount, maxAmount, doAccept);
    }

    private IPowerAcceptor getAcceptorAt(WireLocation wireLocation) {
	TileEntity entity = this.worldObj.getBlockTileEntity(wireLocation.x, wireLocation.y, wireLocation.z);
	if (entity instanceof IPowerAcceptor)
	    return (IPowerAcceptor) entity;
	return null;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	return true;
    }

    @Override
    public WireConnectionState getWireConnection(ForgeDirection direction) {
	return this.states[direction.ordinal()];
    }

    public void setOutputs(WireConnection[] outputs) {
	PowerAcceptorConnection[] connections = new PowerAcceptorConnection[outputs.length];
	for (int i = 0; i < connections.length; i++) {
	    WireConnection output = outputs[i];
	    IPowerAcceptor acceptor = getAcceptorAt(output);
	    connections[i] = new PowerAcceptorConnection(acceptor, output.direction);
	}
	this.distributor.setOutputs(connections);
    }
}
