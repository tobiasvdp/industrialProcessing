package mod.industrialProcessing.plants.power.motor.electroMotor;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.power.network.IPowerAcceptor;
import mod.industrialProcessing.power.network.PowerHelper;
import mod.industrialProcessing.power.network.SimplePowerStorage;
import mod.industrialProcessing.power.utils.IMechanicalMotion;
import mod.industrialProcessing.utils.handlers.numbers.IProgressable;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityElectroMotor extends TileEntityBlockContainerIP implements IPowerAcceptor, IProgressable {

    private static final float DRAG = 0.1f;
    private SimplePowerStorage storage = new SimplePowerStorage(10000);
    private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1000, true);
    private LocalDirection motionOutputDirection = LocalDirection.BACK;
    private LocalDirection powerInputSide = LocalDirection.FRONT;
    private float voltage;
    private float lastVoltage;

    private IMechanicalMotion getGenerator(ForgeDirection dir) {

        TileEntity entity = this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
        if (entity instanceof IMechanicalMotion)
            return (IMechanicalMotion) entity;
        return null;
    }

    private void addEnergy(float waterFill) {
        float speed = this.animationHandler.getSpeed();
        speed += waterFill * AnimationHandler.DT / 500;
        speed -= speed * DRAG * AnimationHandler.DT;
        this.animationHandler.setSpeed(speed);
    }

    @Override
    public void updateEntity() {

        if (!this.worldObj.isRemote) {
            this.lastVoltage = this.voltage;
            this.voltage = 0f;
            float drain = this.storage.drainPower(100, true);
            addEnergy(drain * 20); // a lil more efficient

            //TODO TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);

            ForgeDirection generatorDirection = getExternalDirection(motionOutputDirection);
            IMechanicalMotion generator = getGenerator(generatorDirection);
            if (generator != null) {
                float speed = this.animationHandler.getSpeed();
                float resistance = generator.setSpeed(generatorDirection.getOpposite(), speed);
                speed -= speed * resistance * AnimationHandler.DT;
                this.animationHandler.setSpeed(speed);
            }
        }
        this.animationHandler.update();
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
        return PowerHelper.getResistanceForStorage(storage);
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
        if (canAcceptPower(side)) {
            int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
            this.storage.fillPower(joules, true);
            this.voltage += voltage;
        }
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        return this.powerInputSide == getLocalDirection(side);
    }

    @Override
    public float getProgress(int index) {
        switch (index) {
        case 0:
            return this.lastVoltage;
        case 1:
            return this.animationHandler.getSpeed();
        }
        return 0;
    }

    @Override
    public float getMaxProgress(int index) {
        switch (index) {
        case 0:
            return 250;
        case 1:
            return this.animationHandler.getScale();
        }
        return 0;
    }

}
