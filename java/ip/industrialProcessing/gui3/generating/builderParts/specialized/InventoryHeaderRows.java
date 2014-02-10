package ip.industrialProcessing.gui3.generating.builderParts.specialized;

import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.custom.ElementGrid;
import ip.industrialProcessing.gui3.framework.panels.DockPanel;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.slots.SlotBase;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class InventoryHeaderRows {

    public static void setup(ArrayList<InventoryHeaderRowReference> headerRows, GuiLayoutContainer guiContainer, StackPanel root, Orientation orientation) {

	for (InventoryHeaderRowReference headerRow : headerRows) {
	    DockPanel dock = new DockPanel();
	    SlotControl header = SlotControl.createSlot(headerRow.headerSlot);
	    header.horizontalAlign = Alignment.MIN;
	    header.verticalAlign = Alignment.CENTER;
	    dock.docked = header;

	    ElementGrid grid = ElementGrid.createSlotGrid(headerRow.slots, headerRow.size, orientation.getOpposite());
	    grid.horizontalAlign = Alignment.MAX;
	    grid.verticalAlign = Alignment.CENTER;
	    dock.content = grid;
	    dock.orientation = orientation;
	    root.addChild(dock);
	}
    }

    public static void setup(ArrayList<InventoryHeaderRowReference> headerRows, LayoutContainer container, TileEntity tileEntity) {
	IInventory inventory = getInventory(tileEntity);
	for (InventoryHeaderRowReference headerRow : headerRows) {
	    container.containerAddSlot(headerRow.headerSlot = new SlotBase(inventory, headerRow.headerSlotIndex, 0, 0));

	    headerRow.slots = new Slot[headerRow.slotCount];
	    for (int i = 0; i < headerRow.slotCount; i++) {
		container.containerAddSlot(headerRow.slots[i] = new SlotBase(inventory, headerRow.firstSlotIndex + i, 0, 0));
	    }
	}
    }

    public static IInventory getInventory(TileEntity tileEntity) {
	IInventory machine = null;
	if (tileEntity instanceof IInventory)
	    machine = (IInventory) tileEntity;
	if (machine == null)
	    throw new NullPointerException("Slot without IInventory?!");
	return machine;
    }
}
