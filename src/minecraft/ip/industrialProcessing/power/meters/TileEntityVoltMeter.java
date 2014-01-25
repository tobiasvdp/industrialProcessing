package ip.industrialProcessing.power.meters;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.utils.DirectionUtils;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityVoltMeter extends TileEntityMachine implements IPowerAcceptor, IAnimationProgress, IAnimationSyncable {

	private LocalDirection inputSide = LocalDirection.BACK;
	private int producers;
	private float voltage;
	private int inputs;
	private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1f, true);

	@Override
	public void updateEntity() {

		if (!this.worldObj.isRemote) {
			float totalVoltage = inputs == 0 ? 0 : this.voltage;
			this.voltage = 0;
			this.inputs = 0;

			float targetAngle = Math.min(1, totalVoltage / 48f);
			// 0.25 sec to go from current angle to target angle?
			
			this.animationHandler.moveToProgress(targetAngle, 0.25f); 
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
		}
		this.animationHandler.update();
	}

	@Override
	public float getAnimationProgress(float scale, int index) {
		return this.animationHandler.getAnimationProgress(scale);
	}
	@Override
	public int getAnimationCount() { 
		return 1;
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		return Float.POSITIVE_INFINITY; // 10000+MΩ
	}

	@Override
	public void applyPower(ForgeDirection side, float coulombs, float voltage) {
		// DO nothing with the power, as it should be equal or close to 0
		// Coulomb.
		this.voltage += voltage;
		this.inputs++;
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		ForgeDirection forward = getForwardDirection();
		LocalDirection local = DirectionUtils.getLocalDirection(side, forward);
		return local == inputSide;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) { 
		return false;
	}

	@Override
	public AnimationHandler getAnimationHandler(int index) {
		return this.animationHandler;
	}
}
