package ip.industrialProcessing.gui.container.slot.layout.components;

import java.awt.Rectangle;

import net.minecraft.inventory.Slot;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;

public class SlotLayoutInventory extends SlotLayout {
	public SlotLayoutInventory(Rectangle rect) {
		this.rect = rect;
		this.layout = SlotLayoutType.inventory;
		slots = new Slot[40];
		int count = 0;
		for (int i = 0; i < 9; i++) {
			slots[count] = new Slot(null, count++,i * 18+1, 58+1);
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				slots[count] = new Slot(null, count++,	j * 18+1, i * 18+1);
			}
		}
		for (int i = 0; i < 4; i++) {
			slots[count] = new Slot(null, count++,165+1, 56-18*i+1);
		}
	}
}
