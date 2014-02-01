package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import ip.industrialProcessing.utils.handler.heat.IHeated;
import ip.industrialProcessing.utils.working.HeatManager;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityBoiler extends TileEntityFluidWorkerMachine implements IHeatable, IHeated, IPressuredTank, ITankSyncable {

    public static RecipesBoiler recipes = new RecipesBoiler();
    private HeatManager heatManager;
    private TankHandler tankHandler;

    public TileEntityBoiler() {
	super(false);
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, new LocalDirection[] { LocalDirection.RIGHT, LocalDirection.LEFT }, true, false);
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.UP, false, true);

	addStack(null, new LocalDirection[0], true, false);
	addStack(null, new LocalDirection[0], false, true);

	this.tankHandler = new TankHandler(this, new int[] { 0, 1 });

	this.heatManager = new HeatManager(0.001f, 100f, 0.1f, this.getWorker());
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	addBucketToTank(0, 1, 0);

	float COOLING_RATE = 0.005f;
	if (!this.worldObj.isRemote) {
	    float ambientTemperature = (this.worldObj.getBiomeGenForCoords(this.xCoord, this.zCoord).getFloatTemperature() * 20);

	    this.heatManager.update(ambientTemperature);

	    if (this.tankHandler.readDataFromTanks())
		TileTankSyncHandler.sendTankData(this, this.tankHandler);
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	this.heatManager.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.heatManager.readFromNBT(nbt);
    }

    private IFluidHandler getFluidHandler(int x, int y, int z) {
	TileEntity entityAbove = this.worldObj.getBlockTileEntity(x, y, z);
	if (entityAbove instanceof IFluidHandler)
	    return (IFluidHandler) entityAbove;
	return null;
    }

    @Override
    protected void doWork() {
	if (!this.worldObj.isRemote)
	    this.heatManager.doWork();
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return slot == 0 && fluidId == FluidRegistry.WATER.getID();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot == 0) { // fluid input container input slot, only filled
	    // containers with correct fluid (=water)
	    FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
	    if (fluid == null)
		return false;
	    return recipes.isValidFluidInput(0, fluid.fluidID);
	}
	return false;
    }

    @Override
    public void addHeat(int heat) {
	this.heatManager.addHeat(heat);
    }

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
	return recipes.getRecipes();
    }

    public int getTemperature() {
	return (int) this.heatManager.getTemperature();
    }

    @Override
    public float getPressure(ForgeDirection from) {
	if (from == ForgeDirection.UP) {
	    FluidTankInfo[] info = getTankInfo(from);
	    if (info.length > 0) {
		FluidTankInfo tank = info[0];
		int amount = tank.fluid == null ? 0 : tank.fluid.amount;
		return (amount * 1000f / tank.capacity * this.getHeat() / 250f);
	    }
	}
	return 0;
    }

    @Override
    public TankHandler getTankHandler() {
	return this.tankHandler;
    }

    @Override
    public void addPressure(ForgeDirection from, float pressure) {
    }

    @Override
    public float getHeat() {
	return this.heatManager.getTemperature();
    }

    @Override
    public float getMaxHeat() {
	return 10000;
    }

}
