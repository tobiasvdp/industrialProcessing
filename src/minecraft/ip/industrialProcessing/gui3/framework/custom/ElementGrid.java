package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ElementGrid extends UserControl {

    public static ElementGrid createSlotGrid(Slot[] slots, int size, Orientation orientation) {
        UIElement[] slotElements = new UIElement[slots.length];
        for (int i = 0; i < slotElements.length; i++) {
            slotElements[i] = SlotControl.createSlot(slots[i]);
        }
        return new ElementGrid(slotElements, size, orientation);
    }

    public static ElementGrid createSlotItemGrid(ItemStack[] slots, int size, Orientation orientation) {
        return createButtonSlotItemGrid(slots, size, orientation, null);
    }

    public static ElementGrid createButtonSlotItemGrid(ItemStack[] slots, int size, Orientation orientation, IButtonClickListener<ItemStack> stackClickListener) {
        UIElement[] slotElements = new UIElement[slots.length];
        for (int i = 0; i < slotElements.length; i++) {
            slotElements[i] = stackClickListener == null || slots[i] == null ? SlotItemControl.createSlot(slots[i]) : SlotItemControl.createButtonSlot(slots[i], stackClickListener);
        }
        return new ElementGrid(slotElements, size, orientation);
    }

    public ElementGrid(UIElement[] slots, int size, Orientation orientation) {
        int rows = 0;
        int columns = 0;
        switch (orientation) {
        case HORIZONTAL:
            rows = size;
            columns = (slots.length - 1) / rows + 1;
            break;
        case VERTICAL:
            columns = size;
            rows = (slots.length - 1) / columns + 1;
            break;
        }

        GridPanel grid = new GridPanel();
        for (int i = 0; i < rows; i++) {
            grid.rows.add(new GridSize(18, SizeMode.ABSOLUTE));
        }
        for (int i = 0; i < columns; i++) {
            grid.columns.add(new GridSize(18, SizeMode.ABSOLUTE));
        }
        int i = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                grid.children.add(new GridCell(y, x, slots[i++]));
                if (i >= slots.length)
                    break;
            }
            if (i >= slots.length)
                break;
        }
        this.child = grid;
        this.width = columns * 18;
        this.height = rows * 18;
    }
    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) { 
        super.renderOverride(size, renderer);
    }
}
