package mod.industrialProcessing.plants.power.meter;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.client.rendering.tileEntity.IAnimationProgress;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.IAnimationSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.power.network.IPowerAcceptor;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityVoltMeter extends TileEntityBlockContainerIP implements IPowerAcceptor, IAnimationProgress, IAnimationSyncable {

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
		System.out.println(voltage);
		this.inputs++;
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		LocalDirection local = getLocalDirection(side);
		return local == inputSide;
	}

	@Override
	public AnimationHandler getAnimationHandler(int index) {
		return this.animationHandler;
	}
}
