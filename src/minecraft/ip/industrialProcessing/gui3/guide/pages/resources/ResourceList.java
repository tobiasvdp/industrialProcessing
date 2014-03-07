package ip.industrialProcessing.gui3.guide.pages.resources;

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
import ip.industrialProcessing.utils.registry.BlockRegistry;
import ip.industrialProcessing.utils.registry.BlockType;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResourceList extends UserControl {
    public ResourceList(IButtonClickListener<ItemStack> clickListener) {
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.isHittestVisible = true;
        Panel machines = new WrapPanel();

        Item[] items = ItemRegistry.getItemsByTagArray(ItemType.ore);
        Iterator<Block> blocks = BlockRegistry.getBlocksByTag(BlockType.Resource);
        ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();

        for (Iterator<Block> iterator = blocks; iterator.hasNext();) {
            Block block = (Block) iterator.next();
            itemStacks.add(new ItemStack(block));
        }
        for (int i = 0; i < items.length; i++) {
            itemStacks.add(new ItemStack(items[i]));
        }

        ItemStack[] itemStackArray = new ItemStack[itemStacks.size()];
        itemStacks.toArray(itemStackArray);
        if (itemStackArray.length > 0) {
            sort(itemStackArray);
            for (ItemStack itemStack : itemStackArray) {
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
