package ip.industrialProcessing.power;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPowerGenerator extends TileEntity {

    public TileEntityPowerGenerator(int capacity, int maxOutput)
    {
	this.storageCapacity = capacity;
	this.maxPowerOutput = maxOutput;
    }
    
    int storedPower = 0;
    int storageCapacity = 0;
    int maxPowerOutput = 1;
    ArrayList<IPowerAcceptor> acceptors = new ArrayList<IPowerAcceptor>();
    ArrayList<ForgeDirection> connectedDirections = new ArrayList<ForgeDirection>();
    private boolean unDiscovered;

    @Override
    public void setWorldObj(World par1World) {
	super.setWorldObj(par1World);
	this.unDiscovered = true;
    }

    public void searchPowerAcceptors() {
	this.unDiscovered = false;
	connectedDirections.clear();
	acceptors.clear();
	for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    TileEntity neighbor = this.worldObj.getBlockTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
	    if (neighbor instanceof IPowerAcceptor) {
		ForgeDirection connectionDirection = direction.getOpposite();
		IPowerAcceptor acceptor = (IPowerAcceptor) neighbor;
		if (acceptor.canAcceptPower(connectionDirection)) {
		    acceptors.add(acceptor);
		    connectedDirections.add(connectionDirection);
		}
	    }
	}
    }

    @Override
    public boolean canUpdate() {
	return true;
    }

    @Override
    public void updateEntity() {
	if (this.unDiscovered)
	    searchPowerAcceptors();
	super.updateEntity();
	if (!acceptors.isEmpty()) {
	    storedPower += generatePower(storageCapacity - storedPower);
	    // this shouldn't happen if generatePower is implemented correctly:
	    if (storedPower > storageCapacity)
		storedPower = storageCapacity;
	    // the more machines connected, the less each machine gets:
	    int maxPower = Math.min(maxPowerOutput, storedPower / acceptors.size());
	    for (int i = 0; i < acceptors.size(); i++) {
		IPowerAcceptor acceptor = acceptors.get(i);
		ForgeDirection direction = connectedDirections.get(i);
		int used = acceptor.acceptPower(Math.min(storedPower, maxPower), direction);
		storedPower -= used;
		System.out.println("Sending "+used+" power to "+direction);
	    }
	}
    }

    protected abstract int generatePower(int maxGeneration);
}
