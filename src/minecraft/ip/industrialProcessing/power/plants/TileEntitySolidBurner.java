package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.utils.handler.fuel.IBurner;
import ip.industrialProcessing.utils.working.BurningWorker;
import ip.industrialProcessing.utils.working.IBurnWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.ForgeDirection;

public class TileEntitySolidBurner extends TileEntityMachine implements IWorkingEntity, IBurnWorkHandler, IBurner {

    private BurningWorker worker;
    private int airTime;

    public TileEntitySolidBurner() {
        addStack(null, new LocalDirection[] { LocalDirection.LEFT, LocalDirection.RIGHT }, true, false);
        addStack(null, LocalDirection.DOWN, false, true);
        this.worker = new BurningWorker(this);
    }

    public boolean isBurning() {
        return worker.isWorking();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        worker.readFromNBT(nbt);
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
        super.updateEntity();
        this.worker.doWork(1);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        if (slot == 0) {
            int burnTime = TileEntityFurnace.getItemBurnTime(new ItemStack(itemID, 1, 0));
            return burnTime > 0;
        }
        return false;
    }

    public int getRemainingBurnTime() {
        return this.worker.getTotalWork() - this.worker.getWorkDone();
    }

    public int getTotalBurnTime() {
        return this.worker.getTotalWork();
    }

    @Override
    public IWorker getWorker() {
        return this.worker;
    }

    @Override
    public boolean hasWork() {
        return true;
    }

    @Override
    public boolean canWork() {
        return true;
    }

    @Override
    public void workDone() {
    }

    @Override
    public void prepareWork() {
    }

    @Override
    public void workCancelled() {
    }

    @Override
    public void workProgressed(int amount) {
        if (HeaterUtils.increaseHeat(amount, this, ForgeDirection.UP)) {
            airTime++;
            if (airTime >= 5 * 20) {
                HeaterUtils.ignite(this, ForgeDirection.UP);
                airTime = 0;
            }
        } else
            airTime = 0;
    }

    @Override
    public void beginWork() {
    }

    @Override
    public TileEntity getTileEntity() {
        return this;
    }

    @Override
    public int getFuelSlot() {
        return 0;
    }

    @Override
    public int getAshSlot() {
        return 1;
    }

    @Override
    public void addToSlot(int ash, int itemID, int amount) {
        ItemStack ashStack = getStackInSlot(ash);
        if (ashStack == null)
            this.setInventorySlotContents(ash, new ItemStack(IndustrialProcessing.itemAsh, amount));
        else if (ashStack.itemID == IndustrialProcessing.itemAsh.itemID && ashStack.stackSize <= ashStack.getMaxStackSize() - amount && ashStack.stackSize <= this.getInventoryStackLimit() - amount) {
            ashStack = ashStack.copy();
            ashStack.stackSize++;
            this.setInventorySlotContents(ash, ashStack);
        }
    }

    @Override
    public int getBurnTime() {
        return this.worker.getTotalWork() - this.worker.getWorkDone();
    }

    @Override
    public int getMaxBurnTime() {
        return this.worker.getTotalWork();
    }

}
