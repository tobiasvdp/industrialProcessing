package ip.industrialProcessing.power.wire;

import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerOutput;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityWire extends TileEntityTransport implements IPowerAcceptor {

    PowerDistributor distributor = new PowerDistributor();

    protected void updateNetwork() {
	WireNetworkMap.UpdateNetworkAt(worldObj, xCoord, yCoord, zCoord);
	notifyBlockChange();
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
	    if (acceptor != null && !(acceptor instanceof TileEntityWire)) {
		connections[i] = new PowerAcceptorConnection(output.x, output.y, output.z, output.direction);
	    }
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
	return distributor.getResistance(voltage, this.worldObj);
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	distributor.distributePower(voltage, coulombs, this.worldObj);
    }

    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
	super.writeToNBT(par1nbtTagCompound);
	distributor.writeToNBT(par1nbtTagCompound);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
	super.readFromNBT(par1nbtTagCompound);
	distributor.readFromNBT(par1nbtTagCompound);
    }
}
