package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import ip.industrialProcessing.utils.handler.heat.IHeated;

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

    private static RecipesBoiler recipes = new RecipesBoiler();
    private float heat = 0;
    private TankHandler tankHandler;

    public TileEntityBoiler() {
	super(false);
        addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, new LocalDirection[] { LocalDirection.RIGHT, LocalDirection.LEFT }, true, false);
        addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.UP, false, true);

        addStack(null, new LocalDirection[0], true, false);
        addStack(null, new LocalDirection[0], false, true);

        this.tankHandler = new TankHandler(this, new int[] { 0, 1 });
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        addBucketToTank(0, 1, 0);

        float COOLING_RATE = 0.001f;
        if (!this.worldObj.isRemote) {
            int ambientTemperature = (int) (this.worldObj.getBiomeGenForCoords(xCoord, zCoord).getFloatTemperature() * 20);
            // the hotter the boiler get,
            // the faster the heat dissipates to the environment:
            this.heat += COOLING_RATE * (ambientTemperature - this.heat);

            if (this.tankHandler.readDataFromTanks())
                TileTankSyncHandler.sendTankData(this, this.tankHandler);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setFloat("Heat", heat);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.heat = nbt.getFloat("Heat");
    }

    private IFluidHandler getFluidHandler(int x, int y, int z) {
        TileEntity entityAbove = this.worldObj.getBlockTileEntity(x, y, z);
        if (entityAbove instanceof IFluidHandler)
            return (IFluidHandler) entityAbove;
        return null;
    }

    @Override
    protected void doWork() {
        if (heat > 0) {
            int done = work((int) ((heat - 100) / 10f));
            this.heat -= done / 50f;
        }
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
        this.heat += heat * 1.5f;
    }

    @Override
    public Iterator<Recipe> iterateRecipes() {
        return recipes.iterator();
    }

    public int getTemperature() {
        return (int) this.heat;
    }

    @Override
    public float getPressure(ForgeDirection from) {
        if (from == ForgeDirection.UP) {
            FluidTankInfo[] info = getTankInfo(from);
            if (info.length > 0) {
                FluidTankInfo tank = info[0];
                int amount = tank.fluid == null ? 0 : tank.fluid.amount;
                return (amount * 1000f / tank.capacity * this.heat / 250f);
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
	return this.heat;
    }

    @Override
    public float getMaxHeat() { 
	return 10000;
    }

}
