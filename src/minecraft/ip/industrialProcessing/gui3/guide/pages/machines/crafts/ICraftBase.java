package ip.industrialProcessing.gui3.guide.pages.machines.crafts;

import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import net.minecraft.item.ItemStack;

public interface ICraftBase {
    UIElement getGui(IButtonClickListener<ItemStack> slotClickListener);
}
