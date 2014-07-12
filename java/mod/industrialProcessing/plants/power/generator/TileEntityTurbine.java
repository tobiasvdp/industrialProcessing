package mod.industrialProcessing.plants.power.generator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.handler.numbers.IProgressable;

import java.util.Iterator;

import mod.industrialProcessing.power.utils.IMechanicalMotion;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

// TODO: make the turbine use the recipes
public class TileEntityTurbine extends TileEntityFluidWorkerMachine implements IPressuredTank, ITankSyncable, IProgressable {

    private static final float DRAG = 0.1f;
    private TankHandler tankHandler;
    private LocalDirection motionOutputDirection = LocalDirection.FRONT;
    public static RecipesTurbine recipes = new RecipesTurbine();

    public TileEntityTurbine() {
	super(true);
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.DOWN, false, true);
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.FRONT, true, false);

	addStack(null, new LocalDirection[0], true, false);
	addStack(null, new LocalDirection[0], false, true);
	this.tankHandler = new TankHandler(this, new int[] { 0 });
    }

    @Override
    public void updateEntity() {
	getBucketFromTank(0, 1, 0);

	if (!this.worldObj.isRemote) {

	    if (this.tankHandler.readDataFromTanks())
		TileTankSyncHandler.sendTankData(this, this.tankHandler);

	    float speed = this.animationHandler.getSpeed();
	    speed -= speed * DRAG * AnimationHandler.DT;
	    ForgeDirection generatorDirection = DirectionUtils.getWorldDirection(motionOutputDirection, this.getForwardDirection());
	    IMechanicalMotion generator = getGenerator(generatorDirection.getOpposite());
	    if (generator != null) {
		float resistance = generator.setSpeed(generatorDirection, speed);
		speed -= speed * resistance * AnimationHandler.DT;
	    }
	    this.animationHandler.setSpeed(speed);
	}
	super.updateEntity();
    }

    private IMechanicalMotion getGenerator(ForgeDirection dir) {

	TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
	if (entity instanceof IMechanicalMotion)
	    return (IMechanicalMotion) entity;
	return null;
    }

    private void addEnergy(int waterFill) {
	float speed = this.animationHandler.getSpeed();
	speed += waterFill * AnimationHandler.DT / 100;
	this.animationHandler.setSpeed(speed);
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

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    @Override
    public void workProgressed(int amount) {
	addEnergy(amount);
	// super.workProgressed(amount);
    }

    @Override
    public void workDone() {
    }

    @Override
    public void workCancelled() {
    }

    @Override
    public void beginWork() {
    }

    @Override
    protected void doWork() {
	IFluidTank tank = this.getTank(1);
	work(tank.getFluidAmount() / 100);
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }

    @Override
    public float getProgress(int index) {
	switch (index) {
	case 0:
	    return this.getRPM();
	default:
	    return 0;
	}
    }

    @Override
    public float getMaxProgress(int index) {
	switch (index) {
	case 0:
	    return 500;
	default:
	    return 0;
	}
    }
}
