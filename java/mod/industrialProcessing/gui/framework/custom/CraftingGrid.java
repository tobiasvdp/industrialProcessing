package mod.industrialProcessing.gui.framework.custom;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.controls.Image;
import mod.industrialProcessing.gui.framework.controls.SlotControl;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import net.minecraft.inventory.Slot;

public class CraftingGrid extends UserControl {
    private static final Rect DEFAULT_CRAFT_SECTION_HORIZONTAL = new Rect(0, 0, 1, 0.5f);
    private static final Rect DEFAULT_CRAFT_SECTION_VERTICAL = new Rect(0, 0, 0.5f, 1f);
    private static final TextureReference DEFAULT_CRAFT_TEXTURE_HORIZONTAL = new TextureReference(new Size(24, 32), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Worker.png");
    private static final TextureReference DEFAULT_CRAFT_TEXTURE_VERTICAL = new TextureReference(new Size(32, 24), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/WorkerVertical.png");

    public CraftingGrid(int size, Orientation orientation, Slot[] inputSlots, Slot outputSlot) {
	width = Float.NaN;
	height = Float.NaN;
	if (orientation == Orientation.VERTICAL) {
	    width = size * 18;
	} else if (orientation == Orientation.HORIZONTAL) {
	    height = size * 18;
	}

	StackPanel stack = new StackPanel();
	stack.addChild(ElementGrid.createSlotGrid(inputSlots, size, Orientation.VERTICAL));
	stack.orientation = orientation;
	Image image;
	switch (orientation) {
	case HORIZONTAL:
	    stack.addChild(image = Image.createImage(DEFAULT_CRAFT_TEXTURE_HORIZONTAL, DEFAULT_CRAFT_SECTION_HORIZONTAL));
	    break;
	default:
	case VERTICAL:
	    stack.addChild(image = Image.createImage(DEFAULT_CRAFT_TEXTURE_VERTICAL, DEFAULT_CRAFT_SECTION_VERTICAL));
	    break;
	}
	image.horizontalAlign = image.verticalAlign = Alignment.CENTER;
	SlotControl slot = SlotControl.createSlot(outputSlot);
	slot.horizontalAlign = slot.verticalAlign = Alignment.CENTER;
	stack.addChild(slot);
	this.child = stack;
    }

    public static CraftingGrid createSmallHorizontal(Slot[] inputSlots, Slot output) {
	return new CraftingGrid(2, Orientation.HORIZONTAL, inputSlots, output);
    }

    public static CraftingGrid createSmallVertical(Slot[] inputSlots, Slot output) {
	return new CraftingGrid(2, Orientation.VERTICAL, inputSlots, output);
    }

    public static CraftingGrid createBigHorizontal(Slot[] inputSlots, Slot output) {
	return new CraftingGrid(3, Orientation.HORIZONTAL, inputSlots, output);
    }

    public static CraftingGrid createBigVertical(Slot[] inputSlots, Slot output) {
	return new CraftingGrid(3, Orientation.VERTICAL, inputSlots, output);
    }
}
