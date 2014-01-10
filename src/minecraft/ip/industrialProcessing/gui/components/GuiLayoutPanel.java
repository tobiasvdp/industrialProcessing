package ip.industrialProcessing.gui.components;

import java.awt.Rectangle;

import net.minecraft.client.gui.Gui;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutComponent;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInput;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutOutput;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;

public class GuiLayoutPanel {
	Rectangle rect;
	public GuiLayoutPanelType type;
	GuiLayout parent;
	
	SlotLayout slotLayout;
	GuiContainerLayout guiContainerLayout;
	
	public GuiLayoutPanel(GuiLayout layout,GuiLayoutPanelType type, int x,int y,int width,int height) {
		rect = new Rectangle(x, y, width, height);
		this.type = type;
		parent = layout;
	}
	
	public int getHeight(){
		return rect.height;
	}
	
	public int getWidth(){
		return rect.width;
	}
	
	public int getX(){
		return rect.x;
	}
	
	public int getY(){
		return rect.y;
	}
	
	public void setSlotLayout(SlotLayoutType layout, int amount){
		switch(getSlotComponent()){
		case input:
			
			this.slotLayout = new SlotLayoutInput(layout, amount, parent.getSlotIndex(), rect.x, rect.y);;
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case output:
			this.slotLayout = new SlotLayoutOutput(layout, amount, parent.getSlotIndex(), rect.x, rect.y);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case side:
			break;
		case tank:
			break;
		default:
			break;
		}
		guiContainerLayout = new GuiContainerLayout();
		guiContainerLayout.addDrawRectaglesFromSlotLayout(this.slotLayout);
		
	}
	
	public SlotLayout getSlotLayout(){
		return slotLayout;
	}

	private SlotLayoutComponent getSlotComponent() {
		switch(type){
		case slotsInput:
			return SlotLayoutComponent.input;
		case slotsOutput:
			return SlotLayoutComponent.output;
		case slotsSide:
			return SlotLayoutComponent.side;
		default:
			return SlotLayoutComponent.input;
		}
		
	}
	
	public GuiContainerLayout setGuiContainerLayout(){
		guiContainerLayout = new GuiContainerLayout();
		return guiContainerLayout;
	}

	public void draw(Gui gui, int offsetX, int offsetY) {
		if(guiContainerLayout != null){
			guiContainerLayout.draw(gui, offsetX, offsetY);
		}
	}
}
