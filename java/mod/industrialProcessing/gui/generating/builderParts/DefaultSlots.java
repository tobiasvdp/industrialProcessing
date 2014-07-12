package mod.industrialProcessing.gui.generating.builderParts;

import java.util.ArrayList;

import mod.industrialProcessing.gui.containers.CraftingContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.SlotControl;
import mod.industrialProcessing.gui.framework.controls.SlotItemControl;
import mod.industrialProcessing.gui.framework.custom.ElementGrid;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.gui.framework.slots.SlotBase;
import mod.industrialProcessing.gui.framework.slots.SlotOutput;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
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
				grid.columns.add(new GridSize(slotGrid.width / 18, SizeMode.RELATIVE));
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

	public static void setup(ArrayList<SlotClusterReference> slotRefs, RecipeSlot[] slots, GridPanel grid, Alignment min, IButtonClickListener<ItemStack> stackClickListener) {
		for (SlotClusterReference slot : slotRefs) {
			if (slot.slotCount == 1) {
				ItemStack stack = getStack(slots, slot.startSlot);
				UIElement slotControl = (stackClickListener == null || stack == null) ? SlotItemControl.createSlot(stack) : SlotItemControl.createButtonSlot(stack, stackClickListener);
				slotControl.horizontalAlign = min;
				slotControl.verticalAlign = Alignment.CENTER;
				grid.children.add(new GridCell(0, grid.columns.size(), slotControl));
				grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
			} else {
				ItemStack[] stacks = new ItemStack[slot.slotCount];
				for (int i = 0; i < stacks.length; i++) {
					stacks[i] = getStack(slots, slot.startSlot + i);
				}
				ElementGrid slotGrid = stackClickListener == null ? ElementGrid.createSlotItemGrid(stacks, slot.size, slot.orientation) : ElementGrid.createButtonSlotItemGrid(stacks, slot.size, slot.orientation, stackClickListener);
				slotGrid.horizontalAlign = min;
				slotGrid.verticalAlign = Alignment.CENTER;
				grid.children.add(new GridCell(0, grid.columns.size(), slotGrid));
				grid.columns.add(new GridSize(slotGrid.width / 18, SizeMode.RELATIVE));
			}
		}
	}

	private static int getAmount(RecipeSlot slot) {
		return slot.getMaxAmount();
	}
	
	private static ItemStack getStack(RecipeSlot[] slots, int startSlot) {
		for (int i = 0; i < slots.length; i++) {
			RecipeSlot slot = slots[i];
			if (slot.index == startSlot && slot.type != RecipeSlotType.TANK) {
				int amount = getAmount(slot);
				//return new ItemStack(slot.getItem(), amount, slot.metadata);
				return slot.getDefaultDisplayStack();
			}
		}
		return null;
	}
}
