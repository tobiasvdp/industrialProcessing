package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import ip.industrialProcessing.utils.DirectionUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityTurbine extends TileEntityFluidMachine implements IAnimationSyncable, IAnimationProgress, IPressuredTank, ITankSyncable {

    private static final float DRAG = 0.1f;
    private AnimationHandler animationHandler;
    private TankHandler tankHandler;
    private LocalDirection motionOutputDirection = LocalDirection.FRONT;

    public TileEntityTurbine() {
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.DOWN, false, true);
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.FRONT, true, false);

	addStack(null, new LocalDirection[0], true, false);
	addStack(null, new LocalDirection[0], false, true);
	this.tankHandler = new TankHandler(this, new int[] { 0 });
	this.animationHandler = new AnimationHandler(AnimationMode.WRAP, 1f, true);
    }

    @Override
    public void updateEntity() {
	getBucketFromTank(0, 1, 0);
	if (!this.worldObj.isRemote) {
	    IFluidTank steamTank = getTankInSlot(1); // steam
	    IFluidTank waterTank = getTankInSlot(0); // water 
	    int amount = (steamTank.getFluidAmount() / 50);
	    FluidStack steamDrain = steamTank.drain(amount, false);

	    if (steamDrain != null) {
		int steamID = steamDrain.fluidID;
		steamDrain.fluidID = FluidRegistry.WATER.getID();
		int waterFill = waterTank.fill(steamDrain, true);
		steamTank.drain(waterFill, true);

		addEnergy(waterFill * 2);
	    }
	    TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);

	    if (this.tankHandler.readDataFromTanks())
		TileTankSyncHandler.sendTankData(this, this.tankHandler);

	    ForgeDirection generatorDirection = DirectionUtils.getWorldDirection(motionOutputDirection, this.getForwardDirection());
	    IMechanicalMotion generator = getGenerator(generatorDirection.getOpposite());
	    if (generator != null) {
		float speed = this.animationHandler.getSpeed();
		float resistance = generator.setSpeed(generatorDirection, speed);
		speed -= speed * resistance * AnimationHandler.DT;
		this.animationHandler.setSpeed(speed);
	    }
	}
	this.animationHandler.update();
    }

    private IMechanicalMotion getGenerator(ForgeDirection dir) {

	TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
	if (entity instanceof IMechanicalMotion)
	    return (IMechanicalMotion) entity;
	return null;
    }

    private void addEnergy(int waterFill) {
	float speed = this.animationHandler.getSpeed();
	speed += waterFill * AnimationHandler.DT / 400;
	speed -= speed * DRAG * AnimationHandler.DT;
	this.animationHandler.setSpeed(speed);
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return slot == 1 && fluidId == FluidRegistry.getFluid("steam").getID();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot == 0) { // fluid input container input slot
	    // only empty containers
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));
	}
	return false;
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
    public float getPressure(ForgeDirection from) {
	FluidTankInfo[] info = getTankInfo(from);
	if (info.length > 0) {
	    FluidTankInfo tank = info[0];
	    int amount = tank.fluid == null ? 0 : tank.fluid.amount;
	    return amount * 1000f / tank.capacity;
	}
	return 0;
    }

    public int getRPM() {

	float rotationsPerSecond = this.animationHandler.getSpeed();
	float radPerSecond = rotationsPerSecond * 2 * 3.14159f;
	return (int) (radPerSecond / 0.104720f);
    }

    @Override
    public TankHandler getTankHandler() {
	return this.tankHandler;
    }

}
