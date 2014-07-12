package mod.industrialProcessing.gui.guide.pages.machines.crafts;

import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import net.minecraft.item.ItemStack;

public interface ICraftBase {
    UIElement getGui(IButtonClickListener<ItemStack> slotClickListener);
}
