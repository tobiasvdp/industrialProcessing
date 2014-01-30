package ip.industrialProcessing.gui3.guide.pages.machines;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Expander;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.Panel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.WrapPanel;
import ip.industrialProcessing.utils.registry.BlockRegistry;
import ip.industrialProcessing.utils.registry.BlockType;

import java.util.Arrays;
import java.util.Comparator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MachineList extends UserControl {

    public MachineList() {
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
		    machines.addChild(new Button(blockButton));
		}
		stack.addChild(expander);
	    }
	}
	this.child = stack;
    }

    private UIElement createHeader(BlockType type, boolean b) {
	TextBlock tb = TextBlock.createText(type.getDisplayName());
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
