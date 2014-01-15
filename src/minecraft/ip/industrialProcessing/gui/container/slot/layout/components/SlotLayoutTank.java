package ip.industrialProcessing.gui.container.slot.layout.components;

import java.awt.Rectangle;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;

public class SlotLayoutTank extends SlotLayout{
	//false = input
	boolean inputOrOuput;
	
	public SlotLayoutTank(int startIndex, Rectangle rect,boolean bool) {
		this.rect = rect;
		this.layout = SlotLayoutType.horizontal;
		slots = new SlotBase[2];
		slots[0] = new SlotBase(null, startIndex++, 22+1, 0+1);
		slots[1] = new SlotBase(null, startIndex++, 22+1, 34+1);
		inputOrOuput = bool;
	}
}
