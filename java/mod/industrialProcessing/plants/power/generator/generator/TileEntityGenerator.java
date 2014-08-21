package mod.industrialProcessing.plants.power.generator.generator;

import mod.industrialProcessing.blockContainer.machine.power.generator.TileEntityPowerGenerator;
import mod.industrialProcessing.client.rendering.tileEntity.IAnimationProgress;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.IAnimationSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.power.utils.IMechanicalMotionReceiver;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityGenerator extends TileEntityPowerGenerator implements IAnimationProgress, IMechanicalMotionReceiver, IAnimationSyncable {

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
    protected boolean isValidInput(int slot, Item itemID) {
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
