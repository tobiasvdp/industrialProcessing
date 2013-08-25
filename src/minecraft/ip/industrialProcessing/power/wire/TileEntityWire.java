package ip.industrialProcessing.power.wire;

import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerOutput;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityWire extends TileEntityTransport implements IPowerAcceptor {

    PowerDistributor distributor = new PowerDistributor();

    protected void updateNetwork() {
	WireNetworkMap.UpdateNetworkAt(worldObj, xCoord, yCoord, zCoord);
	notifyBlockChange();
	System.out.println("network around " + xCoord + ", " + yCoord + ", " + zCoord + " found " + this.distributor.getOutputs().length + " outputs");
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

    public void setOutputs(WireConnection[] outputs) {
	PowerAcceptorConnection[] connections = new PowerAcceptorConnection[outputs.length];
	for (int i = 0; i < connections.length; i++) {
	    WireConnection output = outputs[i];
	    IPowerAcceptor acceptor = getAcceptorAt(output);
	    connections[i] = new PowerAcceptorConnection(acceptor, output.direction);
	}
	this.distributor.setOutputs(connections);
    }

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
	// nothing? no connection:
	if (entity == null)
	    return TransportConnectionState.NONE;
	// wire? wire connection:
	if (entity instanceof TileEntityWire)
	    return TransportConnectionState.TRANSPORT;
	// acceptor? output connection:
	if (entity instanceof IPowerAcceptor) {
	    IPowerAcceptor acceptor = (IPowerAcceptor) entity;
	    if (acceptor.canAcceptPower(direction.getOpposite()))
		return TransportConnectionState.OUTPUT;
	}
	// producer? input connection:
	if (entity instanceof IPowerOutput) {
	    IPowerOutput producer = (IPowerOutput) entity;
	    if (producer.canOutputPower(direction.getOpposite()))
		return TransportConnectionState.INPUT;
	}
	// missed something? don't care about it:
	return TransportConnectionState.NONE;
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) { 
	return distributor.getResistance(voltage);
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	distributor.distributePower(voltage, coulombs);
    }

}
