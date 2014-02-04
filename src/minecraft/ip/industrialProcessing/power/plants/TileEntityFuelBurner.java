package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.tanks.IPfluidTank;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.utils.handler.fuel.IBurner;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityFuelBurner extends TileEntityFluidMachine implements IWorkingEntity, IWorkHandler, IBurner {

    private int airTime;
    private int totalBurnTime;
    private int burnTime;
    private ServerWorker worker;

    public TileEntityFuelBurner() {
        addTank(10000, LocalDirection.LEFT, true, false);
        addStack(null, (LocalDirection) null, true, false);
        addStack(null, (LocalDirection) null, false, true);
        this.worker = new ServerWorker(this, 1000);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        worker.writeToNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        worker.writeToNBT(nbt);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void updateEntity() {
        addBucketToTank(0, 1, 0);
        super.updateEntity();
        this.worker.doWork(1);
    }

    private void increaseHeat(int heat) {
        IHeatable boiler = getBoiler();
        if (boiler != null) {
            boiler.addHeat(heat);
        } else {
            if (this.worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
                airTime += heat;
            else
                airTime = 0;

            if (airTime > 5 * 20) {
                this.worldObj.playSoundEffect(xCoord + 0.5D, yCoord + 1.5D, zCoord + 0.5D, "fire.ignite", 1.0F, 1);
                this.worldObj.setBlock(xCoord, yCoord + 1, zCoord, Block.fire.blockID);
            }
        }
    }

    private IHeatable getBoiler() {
        TileEntity tile = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
        if (tile instanceof IHeatable)
            return (IHeatable) tile;
        return null;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        if (slot == 0) {
            FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
            if (fluid == null)
                return false;
            return isTankValidForFluid(0, fluid.fluidID);
        }
        return false;
    }

    @Override
    public int getBurnTime() {
        return this.worker.getTotalWork() - this.worker.getWorkDone();
    }

    @Override
    public int getMaxBurnTime() {
        return this.worker.getTotalWork();
    }

    @Override
    public boolean hasWork() {
        return true;
    }

    @Override
    public boolean canWork() {
        IPfluidTank tank = getTank(0);
        return tank.getFluidAmount() > 0 && this.worker.getTotalWork() > 0;
    }

    @Override
    public void workDone() {
    }

    @Override
    public void prepareWork() {
        int totalBurnTime = getBurnTime(getTank(0).getFluid());
        this.worker.setTotalWork(totalBurnTime);
    }

    private int getBurnTime(FluidStack fluidStack) {
        if (fluidStack != null) {
            Fluid fluid = fluidStack.getFluid();
            if (fluid != null) {
                Block block = Block.blocksList[fluid.getBlockID()];
                if (block != null) {
                    ItemStack stack = new ItemStack(block, 1);
                    return 10 + TileEntityFurnace.getItemBurnTime(stack);
                }
            }
        }
        return 0;
    }

    @Override
    public void workCancelled() {

    }

    @Override
    public void workProgressed(int amount) {
        increaseHeat(amount);
    }

    @Override
    public void beginWork() {
        getTank(0).drain(1, true);
    }

    @Override
    public TileEntity getTileEntity() {
        return this;
    }

    @Override
    public IWorker getWorker() {
        return this.worker;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
        if (slot == 0)
            return getBurnTime(new FluidStack(FluidRegistry.getFluid(fluidId), 0)) > 0;
        return false;
    }
}
