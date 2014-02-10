package ip.industrialProcessing.utils.working;

import ip.industrialProcessing.config.ISetupItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;

public class BurningWorker extends ServerWorker {

    private static final int ASH_MAXCOUNT = 1000;
    private IBurnWorkHandler handler;
    private int fuelValue;
    private int ashCounter;

    public BurningWorker(IBurnWorkHandler handler) {
	super(handler, 0);
	this.handler = handler;
    }

    @Override
    public boolean hasWork() {
	return super.hasWork(); // should always have work
    };

    @Override
    public boolean canWork() {
	return super.canWork() && canStoreAsh();
    };

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("Ash", ashCounter);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	if (nbt.hasKey("Ash"))
	    this.ashCounter = nbt.getInteger("Ash");
    }

    @Override
    protected void onBeginWork() {
	super.onBeginWork();

	int fuelSlot = this.handler.getFuelSlot();
	ItemStack burnStack = this.handler.decrStackSize(fuelSlot, 1);
	if (burnStack == null)
	    this.fuelValue = 0;
	this.fuelValue = TileEntityFurnace.getItemBurnTime(burnStack);
	this.totalWork = fuelValue;
	this.ashCounter = 0;
    }

    @Override
    protected void onWorkProgressed(int amount) {
	super.onWorkProgressed(amount);
	this.ashCounter += amount;
	if (ashCounter > ASH_MAXCOUNT) {
	    ashCounter -= ASH_MAXCOUNT;
	    outputAsh();
	}
    }

    private void outputAsh() {
	int ash = this.handler.getAshSlot();
	ItemStack ashStack = this.handler.getStackInSlot(ash);

	this.handler.addToSlot(ash, ISetupItems.itemAsh.itemID, 1);
    }

    @Override
    protected void onEndWork() {
	super.onEndWork();
	this.fuelValue = 0;
    }

    @Override
    protected void onPrepareWork() {
	super.onPrepareWork();
    }

    private boolean canStoreAsh() {
	int ash = this.handler.getAshSlot();
	ItemStack ashStack = this.handler.getStackInSlot(ash);
	if (ashStack == null)
	    return true;
	if (ashStack.itemID != ISetupItems.itemAsh.itemID)
	    return false;
	if (ashStack.stackSize < ashStack.getMaxStackSize() && ashStack.stackSize < this.handler.getInventoryStackLimit())
	    return true;
	return false;
    }
}
