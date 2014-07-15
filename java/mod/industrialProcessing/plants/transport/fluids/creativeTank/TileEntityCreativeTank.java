package mod.industrialProcessing.plants.transport.fluids.creativeTank;

import mod.industrialProcessing.fluids.IFluidInfo;
import mod.industrialProcessing.fluids.tank.IPressuredTank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityCreativeTank extends TileEntity implements IPressuredTank, IFluidHandler, IFluidInfo, IInventory {

	public TileEntityCreativeTank() {

	}

	ItemStack currentConfig;
	FluidStack currentFluid;

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_) {
		super.writeToNBT(p_145841_1_);
		if (currentConfig != null) {
			NBTTagCompound compound = new NBTTagCompound();
			currentConfig.writeToNBT(compound);
			p_145841_1_.setTag("Config", compound);
		}
		if (currentFluid != null) {
			NBTTagCompound compound = new NBTTagCompound();
			currentFluid.writeToNBT(compound);
			p_145841_1_.setTag("Fluid", compound);
		}

	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_) {

		super.readFromNBT(p_145839_1_);

		if (p_145839_1_.hasKey("Fluid")) {
			NBTTagCompound compound = p_145839_1_.getCompoundTag("Fluid");
			currentFluid = FluidStack.loadFluidStackFromNBT(compound);
		} else
			currentFluid = null;
		if (p_145839_1_.hasKey("Config")) {
			NBTTagCompound compound = p_145839_1_.getCompoundTag("Config");
			currentConfig = ItemStack.loadItemStackFromNBT(compound);
		} else
			currentConfig = null;
	}

	@Override
	public float getPressure(ForgeDirection from) {
		return currentFluid == null ? -1000 : 1000;
	}

	@Override
	public void addPressure(ForgeDirection from, float pressure) {

	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (resource == null)
			return 0;
		return currentFluid == null ? resource.amount : 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource == null)
			return null;
		return currentFluid != null ? resource : null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (currentFluid != null) {
			FluidStack returnStack = currentFluid.copy();
			returnStack.amount = maxDrain;
			return returnStack;
		}
		return null;

	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return getTanks();
	}

	@Override
	public FluidTankInfo[] getTanks() {
		return new FluidTankInfo[] { new FluidTankInfo(currentFluid == null ? null : currentFluid.copy(), 1000) };
	}

	@Override
	public FluidTankInfo getTankInfoForSlot(int slot) {
		if (slot == 0)
			return new FluidTankInfo(currentFluid == null ? null : currentFluid.copy(), 1000);
		return null;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		if (var1 == 0)
			return currentConfig;
		return null;
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if (var1 == 0) {
			ItemStack current = currentConfig;
			currentConfig = null;
			currentFluid = null;
			return current;
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		if (var1 == 0) {
			System.out.println("adding stack " + var2);
			currentFluid = FluidContainerRegistry.getFluidForFilledItem(var2);
			currentConfig = var2;
		}
	}

	@Override
	public String getInventoryName() {
		return "creativeTank";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {

		if (var2 != null)
			return FluidContainerRegistry.isContainer(var2);

		return false;
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

}
