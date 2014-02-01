package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.utils.DirectionUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityGenerator extends TileEntityPowerGenerator implements IAnimationProgress, IMechanicalMotion, IAnimationSyncable {

    private AnimationHandler animationHandler;
    LocalDirection outputSide = LocalDirection.BACK;
    LocalDirection inputSide = LocalDirection.FRONT;

    public TileEntityGenerator() {

	this.animationHandler = new AnimationHandler(AnimationMode.WRAP, 1f, true);
    }

    @Override
    public void updateEntity() {
	if (!this.worldObj.isRemote) {
	    this.animationHandler.update();
	    TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
	}
	super.updateEntity();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	LocalDirection power = DirectionUtils.getLocalDirection(opposite, getForwardDirection());
	return power == outputSide;
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
    public float getVoltage() {
	return this.animationHandler.getSpeed() * 30;
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
    public float setSpeed(ForgeDirection side, float speed) {
	ForgeDirection direction = DirectionUtils.getWorldDirection(this.inputSide, this.getForwardDirection());
	if (side == direction) {
	    this.animationHandler.setSpeed(speed);
	    return (float) Math.pow(this.lastCharge / 10, 1.5);
	}
	return 0;
    }

    @Override
    public AnimationHandler getAnimationHandler(int index) {
	return this.animationHandler;
    }

}
