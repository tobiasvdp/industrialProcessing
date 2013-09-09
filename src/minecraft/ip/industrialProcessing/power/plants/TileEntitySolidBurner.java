package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import ic2.api.item.Items;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntitySolidBurner extends TileEntityMachine {

	private int burnTimeRemaining = 0;
	private int airTime = 0;
	private int totalBurnTime;
	private boolean isBurning = false;

	public TileEntitySolidBurner() {
		addStack(null, LocalDirection.FRONT, true, false);
	}

	public boolean isBurning() {
		return isBurning;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.burnTimeRemaining = nbt.getInteger("BurnTimeRemaining");
		this.totalBurnTime = nbt.getInteger("TotalBurnTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("BurnTimeRemaining", this.burnTimeRemaining);
		nbt.setInteger("TotalBurnTime", this.totalBurnTime);
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
				this.worldObj.playSoundEffect((double) xCoord + 0.5D, (double) yCoord + 1.5D, (double) zCoord + 0.5D, "fire.ignite", 1.0F, 1);
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
