package ip.industrialProcessing.power.motor;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.plants.IMechanicalMotion;
import ip.industrialProcessing.utils.DirectionUtils;

public class TileEntityElectroMotor extends TileEntityMachine implements IPowerAcceptor {

    private static final float DRAG = 0.1f;
    private SimplePowerStorage storage = new SimplePowerStorage(10000);
    private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.WRAP, 1, true);
    private LocalDirection motionOutputDirection = LocalDirection.FRONT;
    private LocalDirection powerInputSide = LocalDirection.FRONT;

    private IMechanicalMotion getGenerator(ForgeDirection dir) {

        TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
        if (entity instanceof IMechanicalMotion)
            return (IMechanicalMotion) entity;
        return null;
    }

    private void addEnergy(int waterFill) {
        float speed = this.animationHandler.getSpeed();
        speed += waterFill * this.animationHandler.DT / 500;
        speed -= speed * DRAG * this.animationHandler.DT;
        this.animationHandler.setSpeed(speed);
    }

    @Override
    public void updateEntity() {

        if (!this.worldObj.isRemote) {

            int drain = this.storage.drainPower(100, true);
            addEnergy(drain*20); // a lil more efficient

            TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);

            ForgeDirection generatorDirection = DirectionUtils.getWorldDirection(motionOutputDirection, this.getForwardDirection());
            IMechanicalMotion generator = getGenerator(generatorDirection.getOpposite());
            if (generator != null) {
                float speed = this.animationHandler.getSpeed();
                float resistance = generator.setSpeed(generatorDirection, speed);
                speed -= speed * resistance * this.animationHandler.DT;
                this.animationHandler.setSpeed(speed);
            }
        }
        this.animationHandler.update();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return false;
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
        }
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        return this.powerInputSide  == DirectionUtils.getLocalDirection(side, getForwardDirection());
    }

}
