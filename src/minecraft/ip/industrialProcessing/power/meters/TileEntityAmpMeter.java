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
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAmpMeter extends TileEntityMachine implements IPowerAcceptor, IPowerProducer, IAnimationProgress {

    LocalDirection inputSide = LocalDirection.UP;
    LocalDirection outputSide = LocalDirection.BACK;

    public TileEntityAmpMeter() {
    }

    private float amps;
    private PowerAcceptorConnection output;
    private boolean connectionsUnchecked = true;

    @Override
    public boolean canUpdate() { 
        return connectionsUnchecked;
    }
    
    @Override
    public void updateEntity() {
        if(connectionsUnchecked)
           checkConnections(); 
    }
    
    @Override
    public float getAnimationProgress(float scale) {
	return this.amps;
    }

    @Override
    public int producePower(int maxAmount) {
	return 0; // this isn't used
    }

    @Override
    public boolean canProducePower(ForgeDirection side) {
	LocalDirection direction = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return direction == outputSide;
    }

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	if (canAcceptPower(side) && output != null) {
	    
	    int amount = output.acceptor.acceptPower(maxAmount, output.connectedFrom, doAccept);   //.distributePower(maxAmount, maxAmount, doAccept);
	    if (doAccept) {
		this.amps += (amount / 1000F - this.amps) / 10;
		System.out.println("amount of power through the network: " + amount);
	    }
	    return amount;
	}
	return 0;
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
	this.connectionsUnchecked  = false;
	ForgeDirection outDir = DirectionUtils.GetWorldDirection(this.outputSide, getForwardDirection());
	TileEntity entity = this.worldObj.getBlockTileEntity(this.xCoord + outDir.offsetX, this.yCoord + outDir.offsetY, this.zCoord + outDir.offsetZ);
	if (entity instanceof IPowerAcceptor) {
	    this.output = new PowerAcceptorConnection((IPowerAcceptor) entity, outDir.getOpposite());
	} else
	    this.output = null;

    }

}
