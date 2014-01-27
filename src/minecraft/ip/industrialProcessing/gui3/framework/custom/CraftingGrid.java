package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.controls.Image;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class CraftingGrid extends UserControl {
    private static final Rect DEFAULT_CRAFT_SECTION_HORIZONTAL = new Rect(0, 0, 1, 0.5f);
    private static final Rect DEFAULT_CRAFT_SECTION_VERTICAL = new Rect(0, 0, 0.5f, 1f);
    private static final TextureReference DEFAULT_CRAFT_TEXTURE_HORIZONTAL = new TextureReference(new Size(24, 32), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Worker.png");
    private static final TextureReference DEFAULT_CRAFT_TEXTURE_VERTICAL = new TextureReference(new Size(32, 24), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/WorkerVertical.png");

    public CraftingGrid(int size, Orientation orientation) {
	width = Float.NaN;
	height = Float.NaN;
	GridPanel grid = new GridPanel();
	for (int x = 0; x < size; x++) {
	    grid.columns.add(new GridSize(18, SizeMode.ABSOLUTE));
	}
	for (int y = 0; y < size; y++) {
	    grid.rows.add(new GridSize(18, SizeMode.ABSOLUTE));
	}
	for (int x = 0; x < size; x++) {
	    for (int y = 0; y < size; y++) {
		SlotControl slot = SlotControl.createSlot();
		grid.children.add(new GridCell(x, y, slot));
	    }
	}
	StackPanel stack = new StackPanel();
	stack.addChild(grid);
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
	SlotControl slot = SlotControl.createSlot();
	slot.horizontalAlign = slot.verticalAlign = Alignment.CENTER;
	stack.addChild(slot);
	this.child = stack;
    }

    public static CraftingGrid createSmallHorizontal() {
	return new CraftingGrid(2, Orientation.HORIZONTAL);
    }

    public static CraftingGrid createSmallVertical() {
	return new CraftingGrid(2, Orientation.VERTICAL);
    }

    public static CraftingGrid createBigHorizontal() {
	return new CraftingGrid(3, Orientation.HORIZONTAL);
    }

    public static CraftingGrid createBigVertical() {
	return new CraftingGrid(3, Orientation.VERTICAL);
    }
}
