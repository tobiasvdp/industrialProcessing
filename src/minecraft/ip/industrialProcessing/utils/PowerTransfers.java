package ip.industrialProcessing.utils;

import ip.industrialProcessing.items.ItemBattery;
import ip.industrialProcessing.machines.IPowerStorage;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PowerTransfers {

    public static int transfer(ItemStack stack, float maxAmount, IPowerStorage storage) {
        if (isBattery(stack)) {

            float charge = stack.getMaxDamage() - stack.getItemDamage();
            maxAmount = Math.min(charge, maxAmount);
            int fill = (int) Math.floor(storage.fillPower(maxAmount, false));
            stack.setItemDamage(stack.getItemDamage() + fill);
            storage.fillPower(fill, true);
            return fill;
        }
        return 0;
    }

    public static int transfer(IPowerStorage storage, float maxAmount, ItemStack stack) {
        if (isBattery(stack)) {
            maxAmount = Math.min(stack.getItemDamage(), maxAmount);
            int drain = (int) Math.floor(storage.drainPower(maxAmount, false));
            stack.setItemDamage(stack.getItemDamage() - drain);
            storage.drainPower(drain, true);
            return drain;
        }
        return 0;
    }

    public static float setBatteryCharge(ItemStack stack, float totalJoules) {
        if (isBattery(stack)) {
            int charge = Math.min(stack.getMaxDamage(), (int) Math.floor(totalJoules));
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
