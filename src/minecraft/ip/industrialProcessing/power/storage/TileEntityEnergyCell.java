package ip.industrialProcessing.power.storage;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

// This isn't an actual battery, as it has input and outputs, so the resistance defined here is the resistance the input network sees this "battery" as
public class TileEntityEnergyCell extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress, IAnimationSyncable {

	public TileEntityEnergyCell() {
		super(100);
		this.animation = new AnimationHandler(AnimationMode.CLAMP, 1f, true);
	}

	private static final LocalDirection inputSide = LocalDirection.FRONT;
	private static final LocalDirection outputSide = LocalDirection.BACK;

	private float storedJoules = 0;
	private float totalJouleCapacity = 50000;

	private AnimationHandler animation;

	@Override
	public float getAnimationProgress(float scale, int index) {
		return this.animation.getAnimationProgress(scale);
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setFloat("Charge", this.storedJoules);
		nbt.setFloat("Capacity", this.totalJouleCapacity);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.storedJoules = nbt.getFloat("Charge");
		this.totalJouleCapacity = nbt.getFloat("Capacity");
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!this.worldObj.isRemote) {
			float targetProgress = (float) this.storedJoules / this.totalJouleCapacity;
			float speed = (targetProgress - this.animation.getProgress()) * this.animation.DT * 0.5f;
			boolean incrementing = true;
			if (speed < 0) {
				speed = -speed;
				incrementing = false;
			}
			this.animation.setSpeed(speed);
			this.animation.setIncrementing(incrementing);
			TileAnimationSyncHandler.sendAnimationData(this, this.animation);
		}
		this.animation.update();
		
	}

	@Override
	public boolean canOutputPower(ForgeDirection opposite) {
		LocalDirection side = DirectionUtils.getLocalDirection(opposite, getForwardDirection());
		return side == outputSide;
	}

	@Override
	public float getVoltage() {
		return this.storedJoules / this.totalJouleCapacity * 12f;
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		return 10 + PowerHelper.getResistanceForStorage(this.storedJoules, this.totalJouleCapacity);
	}

	@Override
	public void applyPower(ForgeDirection side, float coulombs, float voltage) {
		if (this.storedJoules < this.totalJouleCapacity) {
			float energy = PowerHelper.getEnergy(coulombs, voltage);
			this.storedJoules = Math.min(this.storedJoules + energy, this.totalJouleCapacity);
			notifyBlockChange();
		}
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		LocalDirection input = DirectionUtils.getLocalDirection(side, getForwardDirection());
		return input == inputSide;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	@Override
	public float getCharge(float amount) {
		float voltage = getVoltage();
		float energy = PowerHelper.getEnergy(amount, voltage);
		float delta = Math.min(energy, this.storedJoules);
		this.storedJoules -= delta;
		notifyBlockChange();
		return PowerHelper.getCharge(delta, voltage);
	}
	
	@Override
	public AnimationHandler getAnimationHandler() {
	
		return this.animation;
	}
}
