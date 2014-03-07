package mod.industrialProcessing.utils.handlers.heat;

import net.minecraft.item.ItemStack;

public interface IHeatHandler {
	public int getHeatOfItem(ItemStack fuel);
}
