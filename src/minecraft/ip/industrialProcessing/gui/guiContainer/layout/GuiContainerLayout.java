package ip.industrialProcessing.gui.guiContainer.layout;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotType;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerDrawRectagle;
import ip.industrialProcessing.recipes.Recipe;

public class GuiContainerLayout {
	public static Rectangle[] slotLocations = new Rectangle[]{new Rectangle(0,238,18,18),new Rectangle(0,220,18,18),new Rectangle(0,202,18,18)};
	public static Rectangle[] workerLocations = new Rectangle[]{new Rectangle(0, 0, 24, 16),new Rectangle(24, 0, 24, 16)};
	
	protected ArrayList<GuiContainerDrawRectagle> rect;

	public GuiContainerLayout() {
		rect = new ArrayList<GuiContainerDrawRectagle>();
	}
	
	public void addDrawRectaglesFromSlotLayout(GuiLayoutPanel panel, SlotLayout layout){
		addDrawRectaglesFromSlotLayout(panel,layout,SlotType.inventory);
	}
	public void addDrawRectaglesFromSlotLayout(GuiLayoutPanel panel, SlotLayout layout,SlotType type){
		Slot[] slots = layout.getGuiContainerSlots(null);
		for(int i = 0;i<slots.length;i++){
			GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
			rectangle.origin = slotLocations[type.ordinal()];
			rectangle.destination = new Point(slots[i].xDisplayPosition-1-panel.getX(),slots[i].yDisplayPosition-1-panel.getY());
			rect.add(rectangle);
		}
	}

	public void addDrawRectagle(Rectangle rec) {
		GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
		rectangle.destination = new Point(0, 0);
		rectangle.origin = rec;
		rect.add(rectangle);
	}
	
	public void addDrawRectagle(int u, int v, int width, int height) {
		GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
		rectangle.destination = new Point(0, 0);
		rectangle.origin = new Rectangle(u, v, width, height);
		rect.add(rectangle);
	}

	public void addDrawRectagle(int x, int y, int u, int v, int width, int height) {
		GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
		rectangle.destination = new Point(x, y);
		rectangle.origin = new Rectangle(u, v, width, height);
		rect.add(rectangle);
	}

	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		Iterator<GuiContainerDrawRectagle> it = rect.iterator();
		while (it.hasNext()) {
			GuiContainerDrawRectagle rectangle = it.next();
			gui.drawTexturedModalRect(rectangle.destination.x + offsetX, rectangle.destination.y + offsetY, rectangle.origin.x, rectangle.origin.y, rectangle.origin.width, rectangle.origin.height);
		}
	}
	
	public void drawForeGround(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {

	}

	protected boolean isMouseInside(int mouseX, int mouseY, int i, int j, int width, int height) {
		if (mouseX > i && mouseY > j) {
			if(mouseX < i+width && mouseY < j+height)
				return true;
		}
		return false;
	}

	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY, Block craftingBlock) {
		Iterator<GuiContainerDrawRectagle> it = rect.iterator();
		while (it.hasNext()) {
			GuiContainerDrawRectagle rectangle = it.next();
			gui.drawTexturedModalRect(rectangle.destination.x + x, rectangle.destination.y + y, rectangle.origin.x, rectangle.origin.y, rectangle.origin.width, rectangle.origin.height);
		}
	}

}
