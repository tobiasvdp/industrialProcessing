package mod.industrialProcessing.gui.guide.pages.machines.crafts;

import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.controls.SlotItemControl;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FurnaceCraft implements ICraftBase {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("WorkerVertical.png", 32, 24);
    private ItemStack source;
    private ItemStack target;

    public FurnaceCraft(int key, ItemStack value) {
	this.source = new ItemStack(Item.getItemById(key), 1, 0);
	this.target = value;
    }

    @Override
    public UIElement getGui(IButtonClickListener<ItemStack> slotClickListener) {

	StackPanel stack = new StackPanel();
	stack.addChild(TextBlock.createText(Blocks.furnace.getLocalizedName()));
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
