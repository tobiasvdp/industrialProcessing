package ip.industrialProcessing.gui.guiContainer.layout.components;

import java.awt.Point;
import java.awt.Rectangle;

import net.minecraft.inventory.Slot;
import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;

public class GuiContainerLayoutSlot extends GuiContainerLayout {

	public void addDrawRectaglesFromSlotLayout(GuiLayoutPanel panel, SlotLayout layout){
		Slot[] slots = layout.getGuiContainerSlots(null);
		for(int i = 0;i<slots.length;i++){
			GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
			rectangle.origin = new Rectangle(0,238,18,18);
			rectangle.destination = new Point(slots[i].xDisplayPosition-1-panel.getX(),slots[i].yDisplayPosition-1-panel.getY());
			rect.add(rectangle);
		}
	}
}
