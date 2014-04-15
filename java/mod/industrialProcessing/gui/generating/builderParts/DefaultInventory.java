package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.framework.custom.PlayerInventory;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.slots.SlotArmor;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class DefaultInventory {
	public static void setup(InventoryReference inventoryRef, InventoryPlayer inventoryPlayer, LayoutContainer container) {
		if (inventoryRef != null) {
			inventoryRef.inventorySlots = new Slot[3 * 9];
			inventoryRef.hotbarSlots = new Slot[9];
			for (int i = 0; i < 9; i++) {
				container.containerAddSlot(inventoryRef.hotbarSlots[i] = new Slot(inventoryPlayer, i, 8 + i * 18, 142));
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					int o = j + i * 9 + 9;
					container.containerAddSlot(inventoryRef.inventorySlots[o - 9] = new Slot(inventoryPlayer, o, 8 + j * 18, 84 + i * 18));
				}
			}
			if (inventoryRef.showArmor) {
				inventoryRef.armorSlots = new Slot[4];
				for (int i = 0; i < 4; i++) {
					container.containerAddSlot(inventoryRef.armorSlots[i] = new SlotArmor(inventoryPlayer.player, inventoryPlayer, 27 + 9 + 3 - i, 8 + 9 * 54 + 7, 8 + i * 18, i));
				}
			}
			// TODO: crafting grid;
		}
	}

	public static void setup(InventoryReference inventoryRef, GuiLayoutContainer guiContainer, StackPanel rootStack) {
		if (inventoryRef != null) {
			// TODO: crafting grid;
			rootStack.addChild(PlayerInventory.createInventory(inventoryRef.hotbarSlots, inventoryRef.inventorySlots, inventoryRef.armorSlots, null, null));
		}
	}

}