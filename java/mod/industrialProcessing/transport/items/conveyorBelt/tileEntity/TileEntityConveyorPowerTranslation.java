package mod.industrialProcessing.transport.items.conveyorBelt.tileEntity;

import mod.industrialProcessing.utils.registry.HandlerRegistry;

public abstract class TileEntityConveyorPowerTranslation extends TileEntityConveyorInteractionBase {

    public TileEntityConveyorPowerTranslation() {
	super();
	this.speed = 0.01f;
    }

    @Override
    public void updateEntity() {
	if (!worldObj.isRemote && this.line != -1) {
	    float targetSpeed = Math.max(0.01f, HandlerRegistry.getSpeedForConveyorLine(this.line));
	    this.speed = targetSpeed;

	    if (Math.abs(this.syncedSpeed - targetSpeed) > 0.1)
		// if there is a big change since last speed sync: sync again.
		syncConveyor();
	}
	super.updateEntity();
    }

}
