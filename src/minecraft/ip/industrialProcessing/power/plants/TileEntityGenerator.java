package ip.industrialProcessing.power.plants;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityGenerator extends TileEntityPowerGenerator implements IAnimationProgress, IMechanicalMotion {

	private AnimationHandler animationHandler;
	private float lastCharge;

	public TileEntityGenerator() {
		super(100);
		this.animationHandler = new AnimationHandler(AnimationMode.WRAP, 1f, true);
	}

	@Override
	public void updateEntity() {
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	@Override
	public boolean canOutputPower(ForgeDirection opposite) {
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public float getCharge(float q) {
		this.lastCharge = q;
		return q;
	}

	public float getLastAmps() {
		return this.lastCharge / this.animationHandler.DT;
	}

	@Override
	public float getVoltage() {
		return this.animationHandler.getSpeed();
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
	public float setSpeed(float speed) {
		this.animationHandler.setSpeed(speed);
		return this.lastCharge;
	}
}
