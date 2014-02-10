package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityManoMeter extends TileEntityMachine implements IAnimationSyncable, IAnimationProgress {

	private static final float MAX_PRESSURE = 8000f;
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
			float pressure = 0;
			TileEntityTransportFluidsBase pipe = getPipe();

			if (pipe != null)
				pressure = pipe.getPressure(ForgeDirection.UP);

			float pressureProgress = pressure / MAX_PRESSURE + 0.5f;
			this.animationHandler.moveToProgress(pressureProgress, 0.0125f);
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
		}
		this.animationHandler.update();
	}

	private TileEntityTransportFluidsBase getPipe() {
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
		if (entity instanceof TileEntityTransportFluidsBase)
			return (TileEntityTransportFluidsBase) entity;
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
	public AnimationHandler getAnimationHandler(int index) {
		return this.animationHandler;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		// TODO Auto-generated method stub
		return false;
	}

}
