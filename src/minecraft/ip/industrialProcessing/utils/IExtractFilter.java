package ip.industrialProcessing.utils;

import net.minecraft.item.ItemStack;

public interface IExtractFilter {
    boolean canAcceptStack(ItemStack stack);
}
