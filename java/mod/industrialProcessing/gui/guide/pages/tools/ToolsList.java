package mod.industrialProcessing.gui.guide.pages.tools;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Panel;
import ip.industrialProcessing.gui3.framework.panels.WrapPanel;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;

import java.util.Arrays;
import java.util.Comparator;

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
        TextBlock tb = TextBlock.createText(type.getDisplayName());
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
