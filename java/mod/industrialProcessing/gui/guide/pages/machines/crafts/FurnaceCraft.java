package mod.industrialProcessing.gui.guide.pages.machines.crafts;

import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class FurnaceCraft implements ICraftBase {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("WorkerVertical.png", 32, 24);
    private ItemStack source;
    private ItemStack target;

    public FurnaceCraft(int key, ItemStack value) {
	this.source = new ItemStack(key, 1, 0);
	this.target = value;
    }

    @Override
    public UIElement getGui(IButtonClickListener<ItemStack> slotClickListener) {

	StackPanel stack = new StackPanel();
	stack.addChild(TextBlock.createText(Block.furnaceIdle.getLocalizedName()));
	stack.orientation = Orientation.HORIZONTAL;

	GridPanel grid = new GridPanel();
	grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	grid.rows.add(new GridSize(1, SizeMode.RELATIVE));

	Button input = SlotItemControl.createButtonSlot(source, slotClickListener);
	input.horizontalAlign = Alignment.CENTER;
	ProgressBar worker = ProgressBar.createWorker(WORKER_TEXTURE);
	worker.orientation = Orientation.VERTICAL;
	worker.horizontalAlign = Alignment.CENTER;
	Button output = SlotItemControl.createButtonSlot(target, slotClickListener);
	output.horizontalAlign = Alignment.CENTER;
	grid.children.add(new GridCell(0, 0, input));
	grid.children.add(new GridCell(1, 0, worker));
	grid.children.add(new GridCell(2, 0, output));
	stack.addChild(grid);
	return stack;
    }

}
