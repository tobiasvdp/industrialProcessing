package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntitySolidBurner extends TileEntityMachine {

	private int burnTimeRemaining = 0;
	private int airTime = 0;
	private int totalBurnTime;
	private boolean isBurning = false;

	public TileEntitySolidBurner() {
		addStack(null, new LocalDirection[]{ LocalDirection.LEFT, LocalDirection.RIGHT}, true, false);
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
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("BurnTimeRemaining", this.burnTimeRemaining);
		nbt.setInteger("TotalBurnTime", this.totalBurnTime);
		nbt.setBoolean("IsBurning", this.isBurning);
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
		if (burnTimeRemaining > 0) {
			burnTimeRemaining--;
			increaseHeat();
			this.isBurning = true;
		}
		if (this.isBurning != burnState)
			notifyBlockChange();
	}

	private void increaseHeat() {
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
