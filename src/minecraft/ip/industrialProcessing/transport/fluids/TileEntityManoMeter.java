package ip.industrialProcessing.transport.fluids;

import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;

public class TileEntityManoMeter extends TileEntityMachine implements IAnimationSyncable, IAnimationProgress {

	private LocalDirection connection = LocalDirection.DOWN;

	public TileEntityManoMeter() {
		this.animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1f, true);
		this.animationHandler.setProgress(0.5f);
	}

	private AnimationHandler animationHandler;

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();

		if (!this.worldObj.isRemote) {
			int pressure = 0;
			TileEntityTransportFluids pipe = getPipe();

			if (pipe != null)
				pressure = pipe.getPressure();

			float pressureProgress = pressure / 2000f + 0.5f;
			this.animationHandler.moveToProgress(pressureProgress, 0.125f);
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
		}
		this.animationHandler.update();
	}

	private TileEntityTransportFluids getPipe() {
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
		if (entity instanceof TileEntityTransportFluids)
			return (TileEntityTransportFluids) entity;
		return null;
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getAnimationProgress(float scale, int animationIndex) {
		return this.animationHandler.getAnimationProgress(scale);
	}

	@Override
	public AnimationHandler getAnimationHandler() {
		return this.animationHandler;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		// TODO Auto-generated method stub
		return false;
	}

}
