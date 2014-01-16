package ip.industrialProcessing.power.plants;

import cpw.mods.fml.common.Mod.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntitySolidBurner extends TileEntityMachine {

    private int burnTimeRemaining = 0;
    private int airTime = 0;
    private int totalBurnTime;
    private boolean isBurning = false;
    private int cummulatedAsh = 0;

    public TileEntitySolidBurner() {
	addStack(null, new LocalDirection[] { LocalDirection.LEFT, LocalDirection.RIGHT }, true, false);
	addStack(null, LocalDirection.DOWN, false, true);
    }

    public boolean isBurning() {
	return isBurning;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.burnTimeRemaining = nbt.getInteger("BurnTimeRemaining");
	this.totalBurnTime = nbt.getInteger("TotalBurnTime");
	this.isBurning = nbt.getBoolean("IsBurning");
	this.cummulatedAsh = nbt.getInteger("CummulatedAsh");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("BurnTimeRemaining", this.burnTimeRemaining);
	nbt.setInteger("TotalBurnTime", this.totalBurnTime);
	nbt.setBoolean("IsBurning", this.isBurning);
	nbt.setInteger("CummulatedAsh", this.cummulatedAsh);
    }

    @Override
    public boolean canUpdate() {
	return true;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	boolean burnState = this.isBurning;
	if (burnTimeRemaining <= 0) {
	    ItemStack burnStack = this.decrStackSize(0, 1);
	    int burnTime = TileEntityFurnace.getItemBurnTime(burnStack);
	    burnTimeRemaining += burnTime;
	    this.totalBurnTime = burnTime;
	    this.isBurning = burnTime > 0;
	}
	if (burnTimeRemaining > 0 && this.cummulatedAsh < 1000) {
	    // don't burn when there is no room in the ash-tray!
	    burnTimeRemaining--;
	    increaseHeat();
	    this.isBurning = true;
	} else if (this.cummulatedAsh >= 1000) {
	    this.isBurning = false;
	}

	if (this.cummulatedAsh >= 1000) {
	    if (this.addToSlot(1, IndustrialProcessing.itemAsh.itemID, 1, 0)) {
		this.cummulatedAsh -= 1000;
	    }
	}

	if (this.isBurning != burnState)
	    notifyBlockChange();
    }

    private void increaseHeat() {
	this.cummulatedAsh += 10;
	IHeatable boiler = getBoiler();
	if (boiler != null) {
	    boiler.addHeat(1);
	} else {
	    if (this.worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
		airTime++;
	    else
		airTime = 0;

	    if (airTime > 20) {
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
	    int burnTime = TileEntityFurnace.getItemBurnTime(new ItemStack(itemID, 1, 0));
	    return burnTime > 0;
	}
	return false;
    }

    public int getRemainingBurnTime() {
	return this.burnTimeRemaining;
    }

    public int getTotalBurnTime() {
	return this.totalBurnTime;
    }

}
