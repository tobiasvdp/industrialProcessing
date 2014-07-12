package mod.industrialProcessing.utils.inventory;

import net.minecraft.item.ItemStack;

public interface IExtractFilter {
    boolean canAcceptStack(ItemStack stack);
}
