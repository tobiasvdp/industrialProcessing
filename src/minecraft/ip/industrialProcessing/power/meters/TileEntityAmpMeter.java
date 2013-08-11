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

    LocalDirection inputSide = LocalDirection.LEFT;
    LocalDirection outputSide = LocalDirection.RIGHT;
    private PowerDistributor distributor;

    public TileEntityAmpMeter() {
	this.distributor = new PowerDistributor();
    }

    private float amps;

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
	if (canAcceptPower(side)) {
	    return distributor.distributePower(maxAmount, maxAmount, doAccept);
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
	ForgeDirection outDir = DirectionUtils.GetWorldDirection(this.outputSide, getForwardDirection());
	TileEntity entity = this.worldObj.getBlockTileEntity(this.xCoord + outDir.offsetX, this.yCoord + outDir.offsetY, this.zCoord + outDir.offsetZ);
	if (entity instanceof IPowerAcceptor) {
	    this.distributor.setOutputs(new PowerAcceptorConnection[] { new PowerAcceptorConnection((IPowerAcceptor) entity, outDir.getOpposite()) });
	} else
	    this.distributor.setOutputs(new PowerAcceptorConnection[0]);

    }

}
