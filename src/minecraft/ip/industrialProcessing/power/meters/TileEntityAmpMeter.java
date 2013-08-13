package ip.industrialProcessing.power.meters;

import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.PowerDistributorManager;
import ip.industrialProcessing.power.PowerProducerManager;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAmpMeter extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress {

    LocalDirection inputSide = LocalDirection.BACK;
    LocalDirection outputSide = LocalDirection.UP;

    public TileEntityAmpMeter() {
	super(1000);
    }

    private float amps;
    private PowerAcceptorConnection output;
    private boolean connectionsUnchecked = true;

    int available;
    int demand;
    private int throughput;

    @Override
    public boolean canUpdate() {
	return connectionsUnchecked;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	this.amps = throughput / 500f;
	this.demand = 0;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.amps;
    }

    @Override
    public int producePower(int maxAmount, boolean doProduce) {
	if (doProduce) {
	    int production = Math.min(this.available, maxAmount);
	    this.available -= production;
	    this.throughput = production;
	    return production;
	} else {
	    this.demand += maxAmount;
	    return maxAmount;
	}
    }

    @Override
    public boolean canOutputPower(ForgeDirection side) {
	LocalDirection direction = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return direction == outputSide;
    }

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	if (doAccept) {
	    int accepted = Math.min(maxAmount, this.demand);
	    this.demand -= accepted;
	    return accepted;
	} else {
	    this.available += maxAmount;
	    return maxAmount;
	}
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection direction = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return direction == inputSide;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    public void checkConnections() {
	this.connectionsUnchecked = false;
	ForgeDirection outDir = DirectionUtils.GetWorldDirection(this.outputSide, getForwardDirection());
	TileEntity entity = this.worldObj.getBlockTileEntity(this.xCoord + outDir.offsetX, this.yCoord + outDir.offsetY, this.zCoord + outDir.offsetZ);
	if (entity instanceof IPowerAcceptor) {
	    this.output = new PowerAcceptorConnection((IPowerAcceptor) entity, outDir.getOpposite());
	} else
	    this.output = null;

    }

}
