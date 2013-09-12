package ip.industrialProcessing.transport.fluids;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.PowerHelper;

public class TileEntityPump extends TileEntityMachine implements IPowerAcceptor, IAnimationProgress, IAnimationSyncable {

	FluidTank tank = new FluidTank(1000);
	LocalDirection inputSide = LocalDirection.RIGHT;
	LocalDirection outputSide = LocalDirection.LEFT;
	LocalDirection powerSide = LocalDirection.BACK;

	private int storedPower;
	private float inputPressure;
	private float outputPressure;
	private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.MIRROR, 1f, true);
	private static final int powerStorageCapacity = 1000;

	private static final int PRESSURE_DIFFERENTIAL = 6000;
	private static final int POWER_TO_PRESSURE_RATIO = 50;

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public boolean isFluidOuptut(ForgeDirection from) {
		LocalDirection direction = DirectionUtils.getLocalDirection(from, getForwardDirection());
		return direction == outputSide;
	}

	public boolean isFluidInput(ForgeDirection from) {
		LocalDirection direction = DirectionUtils.getLocalDirection(from, getForwardDirection());
		return direction == inputSide;
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!this.worldObj.isRemote) { 
			int maxTransfer = Math.min(PRESSURE_DIFFERENTIAL, this.storedPower * POWER_TO_PRESSURE_RATIO);
			float transfer = PRESSURE_DIFFERENTIAL - (this.outputPressure - this.inputPressure);
			transfer = Math.min(maxTransfer, Math.max(0, transfer));
			float center = (this.inputPressure + this.outputPressure) / 2;
			if (!this.animationHandler.isIncrementing()) {
				this.inputPressure -= (transfer + center);
				this.outputPressure += (transfer - center);
			}
			this.storedPower -= transfer / POWER_TO_PRESSURE_RATIO;

			int mul = this.animationHandler.isIncrementing() ? 5 : 1;
			this.animationHandler.setSpeed(transfer / 500f * mul);
			this.animationHandler.update();
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
		}
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		if (canAcceptPower(side)) {
			return 1 + PowerHelper.getResistanceForStorage(this.storedPower, this.powerStorageCapacity) / 5;
		}
		return Float.POSITIVE_INFINITY;
	}

	@Override
	public void applyPower(ForgeDirection side, float coulombs, float voltage) {
		if (canAcceptPower(side)) {
			int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
			this.storedPower = Math.min(this.storedPower + joules, this.powerStorageCapacity);
		}
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		LocalDirection direction = DirectionUtils.getLocalDirection(side, getForwardDirection());
		return direction == powerSide;
	}

	public float getInputPressure() {
		return inputPressure;
	}

	public void setInputPressure(float inputPressure) {
		this.inputPressure = inputPressure;
	}

	public float getOutputPressure() {
		return outputPressure;
	}

	public void setOutputPressure(float outputPressure) {
		this.outputPressure = outputPressure;
	}

	public IFluidTank getTank() {
		return tank;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setFloat("PInf", inputPressure);
		nbt.setFloat("Poutf", outputPressure);
		nbt.setInteger("Pow", storedPower);
		this.tank.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.inputPressure = nbt.getFloat("PInf");
		this.outputPressure = nbt.getFloat("Poutf");
		this.storedPower = nbt.getInteger("Pow");
		this.tank.setFluid(null);
		this.tank.readFromNBT(nbt);
	}

	@Override
	public AnimationHandler getAnimationHandler() {
		return this.animationHandler;
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getAnimationProgress(float scale, int animationIndex) {
		return this.animationHandler.getAnimationProgress(scale);
	}
}
