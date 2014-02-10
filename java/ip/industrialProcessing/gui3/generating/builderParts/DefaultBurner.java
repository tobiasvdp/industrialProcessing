package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.BurnerHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.handler.fuel.IBurner;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class DefaultBurner {

    public static void setup(BurnerReference burnerRef, GuiLayoutContainer container, TileEntity tileEntity, GridPanel parentGrid, Alignment align) {
	if (burnerRef != null) {
	    GridPanel grid = new GridPanel();
	    grid.columns.add(new GridSize(18, SizeMode.ABSOLUTE));
	    SlotControl slot;
	    if (burnerRef.lighterSlotIndex >= 0) {
		slot = SlotControl.createLighterSlot(burnerRef.lighterSlot);
		slot.verticalAlign = Alignment.MIN;
		grid.children.add(new GridCell(grid.rows.size(), 0, slot));
		grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	    }

	    ProgressBar burner = ProgressBar.createBurner();
	    burner.verticalAlign = Alignment.CENTER;
	    grid.children.add(new GridCell(grid.rows.size(), 0, burner));
	    grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	    Binder binder = new Binder<IProgressBinding>(burnerRef.progressHandler, burner);
	    container.addBinding(binder);
	    slot = SlotControl.createFuelSlot(burnerRef.fuelSlot);
	    slot.verticalAlign = Alignment.MIN;
	    grid.children.add(new GridCell(grid.rows.size(), 0, slot));
	    grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	    if (burnerRef.ashSlotIndex >= 0) {
		slot = SlotControl.createSlot(burnerRef.ashSlot);
		slot.verticalAlign = Alignment.MAX;
		grid.children.add(new GridCell(grid.rows.size(), 0, slot));
		grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	    }
	    grid.horizontalAlign = align;
	    parentGrid.children.add(new GridCell(0, parentGrid.columns.size(), grid));
	    parentGrid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	}
    }

    private static IBurner getBurner(TileEntity tileEntity) {
	IBurner burner = null;
	if (tileEntity instanceof IBurner)
	    burner = (IBurner) tileEntity;
	if (burner == null)
	    throw new NullPointerException("Burner without IBurner?!");
	return burner;
    }

    public static void setup(BurnerReference burnerRef, LayoutContainer container, TileEntity tileEntity) {
	if (burnerRef != null) {
	    IBurner burningEntity = getBurner(tileEntity);
	    IInventory inventory = getInventory(tileEntity);
	    container.addHandler(burnerRef.progressHandler = new BurnerHandler(burningEntity));
	    if (burnerRef.lighterSlotIndex >= 0) {
		container.containerAddSlot(burnerRef.lighterSlot = new SlotBase(inventory, burnerRef.lighterSlotIndex, 0, 0));
	    }
	    if (burnerRef.ashSlotIndex >= 0) {
		container.containerAddSlot(burnerRef.ashSlot = new SlotBase(inventory, burnerRef.ashSlotIndex, 0, 0));
	    }
		container.containerAddSlot(burnerRef.fuelSlot = new SlotBase(inventory, burnerRef.fuelSlotIndex, 0, 0));
	}
    }

    private static IInventory getInventory(TileEntity tileEntity) {
	IInventory inventory = null;
	if (tileEntity instanceof IInventory)
	    inventory = (IInventory) tileEntity;
	if (inventory == null)
	    throw new NullPointerException("Burner without IBurner?!");
	return inventory;
    }

}
