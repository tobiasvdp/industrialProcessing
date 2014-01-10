package ip.industrialProcessing.gui.container.slot.layout.components;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;
import net.minecraft.inventory.IInventory;

public class SlotLayoutSide extends SlotLayout {
	public SlotLayoutSide(int amount, int startIndex) {
		offsetX = 175;
		offsetY = 5;
		sizeX = 18;
		sizeY = 75;
		slots = new SlotBase[amount];
		int count = 0;
		int spacing = 1;
		for (int i = 0; i < amount; i++) {
			slots[count++] = new SlotBase(null, startIndex++, 0, 18 * i + spacing * i);
		}
	}
}
