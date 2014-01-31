package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.custom.ElementGrid;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class DefaultSlots {
    public static void setup(ArrayList<SlotClusterReference> slotRefs, LayoutContainer container, GridPanel grid, Alignment max) {
	for (SlotClusterReference slot : slotRefs) {
	    if (slot.slotCount == 1) {
		SlotControl slotControl = SlotControl.createSlot(slot.slots[0]);
		slotControl.horizontalAlign = max;
		slotControl.verticalAlign = Alignment.CENTER;
		grid.children.add(new GridCell(0, grid.columns.size(), slotControl));
		grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	    } else {
		ElementGrid slotGrid = ElementGrid.createSlotGrid(slot.slots, slot.size, slot.orientation);
		slotGrid.horizontalAlign = max;
		slotGrid.verticalAlign = Alignment.CENTER;
		grid.children.add(new GridCell(0, grid.columns.size(), slotGrid));
		grid.columns.add(new GridSize((slot.slots.length - 1) / slot.size + 1, SizeMode.RELATIVE));
	    }
	}
    }

    public static void setup(ArrayList<SlotClusterReference> slots, LayoutContainer container, TileEntity tileEntity, boolean input) {
	if (!slots.isEmpty()) {
	    IInventory inventory = getInventory(tileEntity);
	    for (SlotClusterReference slotRef : slots) {
		int index = container.inventorySlots.size();
		slotRef.slots = new Slot[slotRef.slotCount];
		for (int i = 0; i < slotRef.slotCount; i++) {
		    container.containerAddSlot(slotRef.slots[i] = input ? new SlotBase(inventory, slotRef.startSlot + i, 0, 0) : new SlotOutput(inventory, slotRef.startSlot + i, 0, 0));
		}
	    }
	}
    }

    private static IInventory getInventory(TileEntity tileEntity) {
	IInventory inventory = null;
	if (tileEntity instanceof IInventory)
	    inventory = (IInventory) tileEntity;
	if (inventory == null)
	    throw new NullPointerException("Slots without IInventory?!");
	return inventory;
    }

    public static void setup(ArrayList<SlotClusterReference> slotRefs, RecipeSlot[] slots, GridPanel grid, Alignment min) {
	for (SlotClusterReference slot : slotRefs) {
	    if (slot.slotCount == 1) {
		ItemStack stack = getStack(slots, slot.startSlot);
		SlotItemControl slotControl = SlotItemControl.createSlot(stack);
		slotControl.horizontalAlign = min;
		slotControl.verticalAlign = Alignment.CENTER;
		grid.children.add(new GridCell(0, grid.columns.size(), slotControl));
		grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	    } else {
		ItemStack[] stacks = new ItemStack[slot.slotCount];
		for (int i = 0; i < stacks.length; i++) {
		    stacks[i] = getStack(slots, slot.startSlot + i);
		}
		ElementGrid slotGrid = ElementGrid.createSlotItemGrid(stacks, slot.size, slot.orientation);
		slotGrid.horizontalAlign = min;
		slotGrid.verticalAlign = Alignment.CENTER;
		grid.children.add(new GridCell(0, grid.columns.size(), slotGrid));
		grid.columns.add(new GridSize((slot.slots.length - 1) / slot.size + 1, SizeMode.RELATIVE));
	    }
	}
    }

    private static int getAmount(RecipeSlot slot) {
	if (slot instanceof RecipeInputSlot) {
	    RecipeInputSlot inputSlot = (RecipeInputSlot) slot;
	    return inputSlot.amount;
	} else if (slot instanceof RecipeOutputSlot) {
	    RecipeOutputSlot inputSlot = (RecipeOutputSlot) slot;
	    return inputSlot.maxAmount;
	}
	return 0;
    }

    private static ItemStack getStack(RecipeSlot[] slots, int startSlot) {
	for (int i = 0; i < slots.length; i++) {
	    RecipeSlot slot = slots[i];
	    if (slot.index == startSlot && slot.type != RecipeSlotType.TANK) {
		int amount = getAmount(slot);
		return new ItemStack(slot.itemId, amount, slot.metadata);
	    }
	}
	return null;
    }
}
