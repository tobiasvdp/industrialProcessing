package mod.industrialProcessing.gui.guide.pages.tools;

import java.util.Arrays;
import java.util.Comparator;

import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.Decorator;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.SlotItemControl;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.Panel;
import mod.industrialProcessing.gui.framework.panels.WrapPanel;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import mod.industrialProcessing.utils.registry.ItemType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolsList extends UserControl {
    public ToolsList(IButtonClickListener<ItemStack> clickListener) {
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.isHittestVisible = true;
        Panel machines = new WrapPanel();

        Item[] items = ItemRegistry.getItemsByTagArray(ItemType.tool);
        ItemStack[] itemStacks = new ItemStack[items.length];
        for (int i = 0; i < items.length; i++) {
            itemStacks[i] = new ItemStack(items[i], 1);
        }

        if (itemStacks.length > 0) {
            sort(itemStacks); 
            for (ItemStack itemStack : itemStacks) {
                UIElement blockButton = createButton(itemStack);
                Button button = new Button<ItemStack>(blockButton, itemStack);
                button.subscribeClick(clickListener);
                machines.addChild(button);
            }
        }
        this.child = machines;
    }

    private UIElement createHeader(ItemType type, boolean b) {
        TextBlock tb = TextBlock.createText(type.toString());
        tb.margin = new Thickness(0, 1, 0, 1);
        Decorator decorator = Decorator.createExpanderDecorator(b);

        decorator.setChild(tb);
        return decorator;
    }

    private UIElement createButton(ItemStack itemStack) {
        return SlotItemControl.createItemstack(itemStack);
    }

    private void sort(ItemStack[] blocks) {
        Arrays.sort(blocks, new Comparator<ItemStack>() {
            @Override
            public int compare(ItemStack o1, ItemStack o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });
    }
}
