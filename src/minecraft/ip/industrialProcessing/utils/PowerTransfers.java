package ip.industrialProcessing.utils;

import ip.industrialProcessing.items.ItemBattery;
import ip.industrialProcessing.machines.IPowerStorage;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PowerTransfers {

    public static int transfer(ItemStack stack, int maxAmount, IPowerStorage storage) {
        if (isBattery(stack)) {

            int charge = stack.getMaxDamage() - stack.getItemDamage();
            maxAmount = Math.min(charge, maxAmount);
            int fill = storage.fillPower(maxAmount, false);
            stack.setItemDamage(stack.getItemDamage() + fill);
            storage.fillPower(fill, true);
            return fill;
        }
        return 0;
    }

    public static int transfer(IPowerStorage storage, int maxAmount, ItemStack stack) {
        if (isBattery(stack)) {
            maxAmount = Math.min(stack.getItemDamage(), maxAmount);
            int drain = storage.drainPower(maxAmount, false);
            stack.setItemDamage(stack.getItemDamage() - drain);
            storage.drainPower(drain, true);
            return drain;
        }
        return 0;
    }

    public static int setBatteryCharge(ItemStack stack, int totalJoules) {
        if (isBattery(stack)) {
            int charge = Math.min(stack.getMaxDamage(), totalJoules);
            totalJoules -= charge;
            stack.setItemDamage(stack.getMaxDamage() - charge);
        }
        return totalJoules;
    }

    public static boolean isBattery(ItemStack stack) {
        if (stack == null)
            return false;
        Item item = stack.getItem();
        return item instanceof ItemBattery;
    }

    public static int getBatteryCharge(ItemStack stack) {
        if (!isBattery(stack))
            return 0;
        return stack.getMaxDamage() - stack.getItemDamage();
    }

    public static int getBatteryMaxCharge(ItemStack stack) {
        if (!isBattery(stack))
            return 0;
        return stack.getMaxDamage();
    }

}
