package mod.industrialProcessing.plants.transport.fluids.pump;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInv;
import mod.industrialProcessing.client.rendering.tileEntity.IAnimationProgress;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.IAnimationSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.power.utils.IMechanicalMotion;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityPump extends TileEntityMachineInv implements IAnimationProgress, IAnimationSyncable, IMechanicalMotion {

    public FluidTank tank = new FluidTank(1000);
    LocalDirection inputSide = LocalDirection.BACK;
    LocalDirection outputSide = LocalDirection.UP;
    LocalDirection powerSide = LocalDirection.FRONT;

    private float inputPressure;
    private float outputPressure;
    private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.WRAP, 1f, true);

    private float speed;
    private static final int PRESSURE_DIFFERENTIAL = 10000;
    private static final int POWER_TO_PRESSURE_RATIO = 50;

    @Override
    protected boolean isValidInput(int slot, Item itemID) {
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
            int maxTransfer = Math.min(PRESSURE_DIFFERENTIAL, (int) (this.speed  * POWER_TO_PRESSURE_RATIO)); 
            float transfer = PRESSURE_DIFFERENTIAL - (this.outputPressure - this.inputPressure);
            transfer = Math.min(maxTransfer, Math.max(0, transfer));
            float center = (this.inputPressure + this.outputPressure) / 2;
            this.inputPressure -= (transfer + center);
            this.outputPressure += (transfer - center);
            this.speed -= transfer / POWER_TO_PRESSURE_RATIO ;

            this.animationHandler.setSpeed(speed);
            this.animationHandler.update();
            TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
        } else
            this.animationHandler.update();
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
        nbt.setFloat("Speed", speed);
        this.tank.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.inputPressure = nbt.getFloat("PInf");
        this.outputPressure = nbt.getFloat("Poutf");
        this.speed = nbt.getFloat("Speed");
        this.tank.setFluid(null);
        this.tank.readFromNBT(nbt);
    }

    @Override
    public AnimationHandler getAnimationHandler(int index) {
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

    @Override
    public float setSpeed(ForgeDirection side, float speed) {

        ForgeDirection direction = DirectionUtils.getWorldDirection(this.powerSide, this.getForwardDirection());
        if (side == direction) {
            float diff = this.speed - speed;
            this.speed = speed;
            return diff;
        }
        return 0;
    }
}
