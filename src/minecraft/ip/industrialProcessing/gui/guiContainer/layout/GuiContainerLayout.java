package ip.industrialProcessing.gui.guiContainer.layout;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.gui.Gui;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerDrawRectagle;
import ip.industrialProcessing.slots.SlotBase;

public class GuiContainerLayout {
	ArrayList<GuiContainerDrawRectagle> rect;
	
	public GuiContainerLayout() {
		rect =  new ArrayList<GuiContainerDrawRectagle>();
	}
	
	public void addDrawRectaglesFromSlotLayout(SlotLayout layout){
		SlotBase[] slots = layout.getGuiContainerSlots(null);
		for(int i = 0;i<slots.length;i++){
			GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
			rectangle.origin = new Rectangle(0,238,18,18);
			rectangle.destination = new Point(slots[i].xDisplayPosition-1,slots[i].yDisplayPosition-1);
			rect.add(rectangle);
		}
	}
	
	public void addDrawRectagle(int x,int y,int u,int v,int width, int height){
		GuiContainerDrawRectagle rectangle = new GuiContainerDrawRectagle();
		rectangle.destination = new Point(x,y);
		rectangle.origin = new Rectangle(u,v,width,height);
		rect.add(rectangle);
	}

	public void draw(Gui gui,int offsetX,int offsetY) {
		Iterator<GuiContainerDrawRectagle> it = rect.iterator();
		while(it.hasNext()){
			GuiContainerDrawRectagle rectangle = it.next();
			gui.drawTexturedModalRect(rectangle.destination.x+offsetX, rectangle.destination.y+offsetY, rectangle.origin.x, rectangle.origin.y, rectangle.origin.width, rectangle.origin.height);
		}
	}
}
