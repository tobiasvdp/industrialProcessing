package ip.industrialProcessing.power;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class PowerDistributorManager {

    private PowerDistributor distributor = new PowerDistributor();
    private IPowerOutput supplier;

    public PowerDistributorManager(TileEntityMachine entity, IPowerOutput supplier) {
	this.entity = entity;
	this.supplier = supplier;
    }

    protected TileEntityMachine entity;

    public void searchPowerAcceptors() {
	ArrayList<PowerAcceptorConnection> connections = new ArrayList<PowerAcceptorConnection>();
	for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (supplier.canOutputPower(direction))
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
		connections.add(new PowerAcceptorConnection(entity.xCoord + direction.offsetX, entity.yCoord + direction.offsetY, entity.zCoord + direction.offsetZ, opposite));
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

    public float getResistance(float voltage, World world) {
	return this.distributor.getResistance(voltage, world);
    }

    public void distributePower(float voltage, float coulombs, World world) {
	this.distributor.distributePower(voltage, coulombs, world);
    }

    public void writeToNBT(NBTTagCompound nbt) {
	/*
	 * PowerAcceptorConnection[] connections =
	 * this.distributor.getOutputs(); int[] directions = new
	 * int[connections.length]; for (int i = 0; i < connections.length; i++)
	 * { directions[i] =
	 * connections[i].connectedFrom.getOpposite().ordinal(); }
	 * nbt.setIntArray("Cons", directions);
	 */
	this.distributor.writeToNBT(nbt);
    }

    public void readFromNBT(NBTTagCompound nbt) {
	this.distributor.readFromNBT(nbt);
	/*
	 * int[] directions = nbt.getIntArray("Cons");
	 * ArrayList<PowerAcceptorConnection> connections = new
	 * ArrayList<PowerAcceptorConnection>(directions.length); for (int i =
	 * 0; i < directions.length; i++) { ForgeDirection direction =
	 * ForgeDirection.VALID_DIRECTIONS[directions[i]];
	 * searchPowerAcceptor(direction, connections); }
	 * PowerAcceptorConnection[] outputs = connections.toArray(new
	 * PowerAcceptorConnection[connections.size()]);
	 * this.distributor.setOutputs(outputs);
	 */
    }

    public void distributePower(IPowerProducer generator, World world) {
	distributePower(generator, 1 / 20F, 1f, world);
    }

    /**
     * Distributes power from a generator over the network with i(t) =
     * v(t)/R^2*tau and q(t) = i(t) * dt;
     * 
     * @param generator
     *            power producer, supplies voltage
     * @param time
     *            time between two frames
     * @param tau
     *            time constant
     */
    public void distributePower(IPowerProducer generator, float time, float tau, World world) {
	float voltage = generator.getVoltage();
	float networkResistance = this.distributor.getResistance(voltage, world);
	float networkResistanceSquared = networkResistance * networkResistance;
	float current = (voltage / networkResistanceSquared * tau);
	float charge = current * time;
	charge = generator.getCharge(charge); // feedback to the generator
	this.distributePower(voltage, charge, world);
    }
}
