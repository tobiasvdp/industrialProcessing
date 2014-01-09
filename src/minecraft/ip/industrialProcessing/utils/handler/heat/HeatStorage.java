package ip.industrialProcessing.utils.handler.heat;

import cpw.mods.fml.common.registry.GameRegistry;
import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.utils.registry.HandlerRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class HeatStorage {

	public static void construction(IHeatStorage heat) {
		heat.setHeat(20);
		heat.setHeatFuel(20);
		heat.setBurnTime(0);
		heat.setMaxBurnTime(1);
	}

	public static void onUpdateEntity(IHeatStorage heat, IInventory inventory, int slot) {
		heat.transferHeat();
		heat.tickFuel();
		if (heat.getBurnTime() == 0)
			heat.ConsumeFuel(inventory.getStackInSlot(slot));
	}

	public static boolean onDoWork(IHeatStorage heat) {
		return (heat.getHeat() > heat.requiredHeatLevel());
	}

	public static boolean onIsValidInput(int itemID) {
		if (GameRegistry.getFuelValue(new ItemStack(itemID, 1, 0)) != 0) {
			return true;
		}
		return false;
	}

	public static void ConsumeFuel(World world,IHeatStorage heat, IMachineSlots machineSlot,IInventory inventory, ItemStack stack, int slot) {
		if (stack != null) {
			int val = GameRegistry.getFuelValue(stack);
			if (val != 0 && stack.stackSize > 0) {
				machineSlot.removeFromSlot(slot, stack.itemID, 1);
				inventory.onInventoryChanged();
				heat.setBurnTime(val);
				heat.setMaxBurnTime(val);
				heat.setHeatFuel(HandlerRegistry.getHeatValue(stack));
			}
		}
	}

	public static int getScaledHeat(IHeatStorage heat, int maxSize) {
		return (int) (heat.getHeat() * maxSize / heat.getMaxHeat());
	}

	public static void tickFuel(IHeatStorage heat) {
		if (heat.getBurnTime() > 0)
			heat.setBurnTime(heat.getBurnTime() - 1);
	}

	public static void transferHeat(IHeatStorage heat) {
		heat.setHeat(heat.getHeat() - heat.getCoolingFactor() * (heat.getHeat() - heat.getHeatFuel()));
		if (heat.getBurnTime() > 0)
			heat.setHeatFuel((float) (heat.getHeatFuel() * 0.99995));
		else
			heat.setHeatFuel(heat.getHeatFuel() - heat.getCoolingFactor() * (heat.getHeatFuel() - 20));
	}

	public static int getScaledBurnTime(IHeatStorage heat, int size) {
		return heat.getBurnTime() * size / heat.getMaxBurnTime();
	}

	public static void onWriteToNBT(IHeatStorage heat, NBTTagCompound nbt) {
		nbt.setInteger("T1", (int) heat.getHeat());
		nbt.setInteger("T2", (int) heat.getHeatFuel());
		nbt.setInteger("burnTime", heat.getBurnTime());
		nbt.setInteger("totalTime", heat.getMaxBurnTime());
	}

	public static void onReadFromNBT(IHeatStorage heat, NBTTagCompound nbt) {
		heat.setHeat(nbt.getInteger("T1"));
		heat.setHeatFuel(nbt.getInteger("T2"));
		heat.setBurnTime(nbt.getInteger("burnTime"));
		heat.setMaxBurnTime(nbt.getInteger("totalTime"));
	}
}
