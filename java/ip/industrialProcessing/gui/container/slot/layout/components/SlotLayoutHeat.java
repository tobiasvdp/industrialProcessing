package ip.industrialProcessing.gui.container.slot.layout.components;

import java.awt.Rectangle;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;

public class SlotLayoutHeat extends SlotLayout {

	public SlotLayoutHeat(int startIndex, Rectangle rect) {
		this.rect = rect;
		this.layout = SlotLayoutType.vertical;
		slots = new SlotBase[2];
		slots[0] = new SlotBase(null, startIndex++, 17 + 1, 0 + 1);
		slots[1] = new SlotBase(null, startIndex++, 17 + 1, 36 + 1);
	}
}
