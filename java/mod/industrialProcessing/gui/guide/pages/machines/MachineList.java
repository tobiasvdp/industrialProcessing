package mod.industrialProcessing.gui.guide.pages.machines;

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
import mod.industrialProcessing.gui.framework.panels.Expander;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.Panel;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.panels.WrapPanel;
import mod.industrialProcessing.utils.registry.BlockRegistry;
import mod.industrialProcessing.utils.registry.BlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MachineList extends UserControl {

    public MachineList(IButtonClickListener<ItemStack> clickListener) {
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.isHittestVisible = true;
        StackPanel stack = new StackPanel();
        stack.orientation = Orientation.VERTICAL;
        for (BlockType type : BlockType.values()) {
            Block[] blocks = BlockRegistry.getBlocksByTagArray(type);
            if (blocks.length > 0) {
                sort(blocks);

                Expander expander = new Expander();
                expander.header = createHeader(type, false);
                expander.expandedHeader = createHeader(type, true);
                expander.orientation = Orientation.VERTICAL;
                Panel machines = new WrapPanel();
                expander.content = machines;
                for (Block block : blocks) {
                    UIElement blockButton = createButton(block);
                    Button button = new Button<ItemStack>(blockButton, new ItemStack(block));
                    button.subscribeClick(clickListener);
                    machines.addChild(button);
                }
                stack.addChild(expander);
            }
        }
        this.child = stack;
    }

    private UIElement createHeader(BlockType type, boolean b) {
        TextBlock tb = TextBlock.createText(type.toString());
        tb.margin = new Thickness(0, 1, 0, 1);
        Decorator decorator = Decorator.createExpanderDecorator(b);

        decorator.setChild(tb);
        return decorator;
    }

    private UIElement createButton(Block block) {
        return SlotItemControl.createItemstack(new ItemStack(block));
    }

    private void sort(Block[] blocks) {
        Arrays.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return o1.getLocalizedName().compareTo(o2.getLocalizedName());
            }
        });
    }
}
