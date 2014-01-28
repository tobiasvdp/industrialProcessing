package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.StatCollector;

public class PlayerInventory extends UserControl {

    public PlayerInventory(Slot[] inventorySlots, Slot[] hotbarSlots, Slot[] armorSlots, Slot[] crafting, Slot craftingOut) {

	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;

	SlotGrid inventory = new SlotGrid(inventorySlots, 3, Orientation.HORIZONTAL);
	inventory.width = 9 * 18;
	inventory.height = 3 * 18;
	SlotGrid hotbar = new SlotGrid(hotbarSlots, 1, Orientation.HORIZONTAL);
	hotbar.margin = new Thickness(7, 0, 0, 0);
	hotbar.width = 9 * 18;
	hotbar.height = 1 * 18;
	TextBlock text = new TextBlock(StatCollector.translateToLocal("container.inventory"), 4210752);
	stack.addChild(text);

	StackPanel vertical = new StackPanel();
	vertical.orientation = Orientation.VERTICAL;
	vertical.addChild(inventory);
	vertical.addChild(hotbar);
	StackPanel horizontal = new StackPanel();
	horizontal.orientation = Orientation.HORIZONTAL;
	horizontal.addChild(vertical);
	if (armorSlots != null) {
	    SlotGrid armor = new SlotGrid(armorSlots, 1, Orientation.VERTICAL);
	    armor.width = 18;
	    armor.height = 4 * 18;
	    armor.margin = new Thickness(0, 0, 0, 7);
	    horizontal.addChild(armor);
	}
	if (crafting != null && craftingOut != null) {
	    CraftingGrid grid = CraftingGrid.createSmallVertical(crafting, craftingOut);
	    grid.margin = new Thickness(0, 0, 0, 7);
	    horizontal.addChild(grid);
	}
	stack.addChild(horizontal);
	this.child = stack;
	this.width = Float.NaN;
	this.height = Float.NaN;
	this.verticalAlign = Alignment.MAX;
    }

    public static PlayerInventory createInventory(Container container, int startSlot) {
	return createInventory(container, startSlot, true, false);
    }

    public static PlayerInventory createInventory(Container container, int startSlot, boolean showArmor, boolean showCraftGrid) {
	Slot[] hotbar = new Slot[9];
	for (int i = 0; i < hotbar.length; i++) {
	    hotbar[i] = container.getSlot(startSlot++);
	}
	Slot[] inventory = new Slot[3 * 9];
	for (int i = 0; i < inventory.length; i++) {
	    inventory[i] = container.getSlot(startSlot++);
	}
	Slot[] armorSlots = null;
	if (showArmor) {
	    armorSlots = new Slot[4];
	    for (int i = 0; i < armorSlots.length; i++) {
		armorSlots[i] = container.getSlot(startSlot++);
	    }
	}
	return new PlayerInventory(inventory, hotbar, armorSlots, null, null);
    }
}
