package mod.industrialProcessing.blockContainer.machine;

import mod.industrialProcessing.items.ItemBattery;
import mod.industrialProcessing.power.network.IPowerStorage;
import mod.industrialProcessing.power.network.IPoweredMachine;
import mod.industrialProcessing.power.network.PowerHelper;
import mod.industrialProcessing.power.network.PowerTransfers;
import mod.industrialProcessing.power.network.SimplePowerStorage;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineInvPower extends TileEntityMachineInv implements IPoweredMachine {

	private LocalDirection powerInputSide;
	protected SimplePowerStorage storage;
	protected int batterySlot = -1;

	public TileEntityMachineInvPower(LocalDirection powerInput, float powerCapacity) {
		this.powerInputSide = powerInput;
		this.storage = new SimplePowerStorage(powerCapacity);
	}

	protected void setupPowerSlot() {
		this.batterySlot = addStack(null, new LocalDirection[0], true, true);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!this.worldObj.isRemote)
			drainBattery();
	}

	public boolean drainBattery() {
		ItemStack stack = getStackInSlot(batterySlot);
		if (stack != null) {
			return PowerTransfers.transfer(stack, 100, this.storage) > 0;
		}
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.storage.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		this.storage.writeToNBT(nbt);
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		if (canAcceptPower(side)) {
			return PowerHelper.getResistanceForStorage(this.storage);
		}
		return Float.POSITIVE_INFINITY;
	}

	@Override
	public void applyPower(ForgeDirection side, float coulombs, float voltage) {
		if (canAcceptPower(side) && !worldObj.isRemote) {
			int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
			this.storage.fillPower(joules, true);
		}
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		return this.powerInputSide == getLocalDirection(side);
	}

	@Override
	public IPowerStorage getMainPowerStorage() {
		return this.storage;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if (i == batterySlot) {
			return PowerTransfers.isBattery(itemstack);
		}
		return super.isItemValidForSlot(i, itemstack);
	}

}
