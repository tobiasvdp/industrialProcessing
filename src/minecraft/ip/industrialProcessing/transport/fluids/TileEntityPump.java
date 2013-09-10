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
	LocalDirection inputSide = LocalDirection.LEFT;
	LocalDirection outputSide = LocalDirection.RIGHT;
	LocalDirection powerSide = LocalDirection.BACK;

	private int storedPower;
	private int inputPressure;
	private int outputPressure;
	private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.MIRROR, 1f, true);
	private static final int powerStorageCapacity = 1000;

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public boolean isFluidOuptut(ForgeDirection from) {
		LocalDirection direction = DirectionUtils.GetLocalDirection(from, getForwardDirection());
		return direction == outputSide;
	}

	public boolean isFluidInput(ForgeDirection from) {
		LocalDirection direction = DirectionUtils.GetLocalDirection(from, getForwardDirection());
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
			int maxTransfer = Math.min(500, this.storedPower*4);
			int transfer = 2000 - (this.outputPressure - this.inputPressure);
			transfer = Math.min(maxTransfer, Math.max(0, transfer));
			int center = (this.inputPressure + this.outputPressure) / 2;
			this.inputPressure -= transfer + center;
			this.outputPressure += transfer - center;
			this.storedPower -= transfer / 4;

			int mul = this.animationHandler.isIncrementing() ? 1 : 5;
			this.animationHandler.setSpeed(transfer / 100f * mul);
			this.animationHandler.update();
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);  
		}
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		if (canAcceptPower(side)) {
			return PowerHelper.getResistanceForStorage(this.storedPower, this.powerStorageCapacity);
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
		LocalDirection direction = DirectionUtils.GetLocalDirection(side, getForwardDirection());
		return direction == powerSide;
	}

	public int getInputPressure() {
		return inputPressure;
	}

	public void setInputPressure(int inputPressure) {
		this.inputPressure = inputPressure;
	}

	public int getOutputPressure() {
		return outputPressure;
	}

	public void setOutputPressure(int outputPressure) {
		this.outputPressure = outputPressure;
	}

	public IFluidTank getTank() {
		return tank;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("PIn", inputPressure);
		nbt.setInteger("Pout", outputPressure);
		nbt.setInteger("Pow", storedPower);
		this.tank.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.inputPressure = nbt.getInteger("PIn");
		this.outputPressure = nbt.getInteger("Pout");
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
