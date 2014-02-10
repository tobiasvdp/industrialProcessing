package ip.industrialProcessing.gui.container.slot.layout.components;

import java.awt.Rectangle;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;

public class SlotLayoutPower extends SlotLayout{
	public SlotLayoutPower(int startIndex, Rectangle rect) {
		this.rect = rect;
		this.layout = SlotLayoutType.horizontal;
		slots = new SlotBase[1];
		slots[0] = new SlotBase(null, startIndex++, 0, 0);
	}
}
