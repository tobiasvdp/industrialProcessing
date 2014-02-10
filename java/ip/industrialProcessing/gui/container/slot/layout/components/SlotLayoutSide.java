package ip.industrialProcessing.gui.container.slot.layout.components;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.slots.SlotBase;

import java.awt.Rectangle;

public class SlotLayoutSide extends SlotLayout {
	public SlotLayoutSide(int amount, int startIndex, Rectangle rect) {
		this.rect = rect;
		slots = new SlotBase[amount];
		int count = 0;
		int spacing = 1;
		for (int i = 0; i < amount; i++) {
			slots[count++] = new SlotBase(null, startIndex++, 0, 18 * i + spacing * i);
		}
	}
}
