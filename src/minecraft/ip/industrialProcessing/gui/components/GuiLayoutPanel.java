package ip.industrialProcessing.gui.components;

import java.awt.Rectangle;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutComponent;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutHeat;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInput;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInventory;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutOutput;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutPower;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutTank;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotType;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutHeat;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutLifespan;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutPower;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutSlot;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutTank;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutWorker;
import ip.industrialProcessing.recipes.Recipe;

public class GuiLayoutPanel {
	Rectangle rect;
	Rectangle rectReduced;
	public GuiLayoutPanelType type;
	GuiLayout parent;
	
	SlotLayout slotLayout;
	GuiContainerLayout guiContainerLayout;
	
	public GuiLayoutPanel(GuiLayout layout,GuiLayoutPanelType type, int x,int y,int width,int height) {
		rect = new Rectangle(x, y, width, height);
		this.type = type;
		parent = layout;
	}
	
	public GuiLayoutPanel(GuiLayout layout,GuiLayoutPanelType type, int x,int y,int width,int height,int width2,int height2) {
		rect = new Rectangle(x, y, width, height);
		rectReduced = new Rectangle(x, y, width2, height2);
		this.type = type;
		parent = layout;
	}
	
	public int getHeight(){
		return rect.height;
	}
	
	public int getWidth(){
		return rect.width;
	}
	
	public int getWidthReduced() {
		if(rectReduced != null)
			return rectReduced.width;
		return rect.width;
	}
	
	public int getX(){
		return rect.x;
	}
	
	public void setX(int val) {
		rect.x = val;
	}
	
	public int getY(){
		return rect.y;
	}
	
	public void setSlotLayout(SlotLayoutType layout, int amount){
		switch(getSlotComponent()){
		case inventory:
			this.slotLayout = new SlotLayoutInventory(rect);
			break;
		case input:
			this.slotLayout = new SlotLayoutInput(layout, amount, parent.getSlotIndex(), rect);
			setGuiContainerLayout(GuiLayoutPanelType.slotsInput);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case output:
			this.slotLayout = new SlotLayoutOutput(layout, amount, parent.getSlotIndex(), rect);
			setGuiContainerLayout(GuiLayoutPanelType.slotsOutput);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case power:
			this.slotLayout = new SlotLayoutPower(parent.getSlotIndex(), rect);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case side:
			break;
		case tankOutput:
			this.slotLayout = new SlotLayoutTank(parent.getSlotIndex(), rect, true);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case tankInput:
			this.slotLayout = new SlotLayoutTank(parent.getSlotIndex(), rect, false);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		case heat:
			this.slotLayout = new SlotLayoutHeat(parent.getSlotIndex(), rect);
			parent.setSlotIndex(parent.getSlotIndex()+amount);
			break;
		default:
			break;
		}
		
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
		case slotsInventory:
			return SlotLayoutComponent.inventory;
		case power:
			return SlotLayoutComponent.power;
		case tankInput:
			return SlotLayoutComponent.tankInput;
		case tankOutput:
			return SlotLayoutComponent.tankOutput;
		case heat:
			return SlotLayoutComponent.heat;
		default:
			return SlotLayoutComponent.input;
		}
		
	}
	
	public GuiContainerLayout setGuiContainerLayout(GuiLayoutPanelType type){
		switch(type){
		case power:
			guiContainerLayout = new GuiContainerLayoutPower();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this,this.slotLayout,SlotType.power);
			guiContainerLayout.addDrawRectagle(20,4,18, 246, 54, 10);
			break;
		case tankInput:
		case tankOutput:
			guiContainerLayout = new GuiContainerLayoutTank();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this,this.slotLayout,SlotType.tank);
			guiContainerLayout.addDrawRectagle(72, 204, 18, 52);
			break;
		case worker:
			guiContainerLayout = new GuiContainerLayoutWorker();
			//draws from different texture file, done in worker component
			break;
		case slotsInput:
			this.guiContainerLayout = new GuiContainerLayoutSlot();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this,this.slotLayout);
			break;
		case slotsOutput:
			this.guiContainerLayout = new GuiContainerLayoutSlot();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this,this.slotLayout);
			break;
		case slotsSide:
			break;
		case heat:
			guiContainerLayout = new GuiContainerLayoutHeat();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this,this.slotLayout,SlotType.inventory);
			guiContainerLayout.addDrawRectagle(106, 202, 15, 54);
			guiContainerLayout.addDrawRectagle(18,19,56, 206, 16, 16);
			break;
		case lifespan:
			guiContainerLayout = new GuiContainerLayoutLifespan();
			guiContainerLayout.addDrawRectagle(126, 248, 50, 8);
			break;
		default:
			break;

		
		}
		return guiContainerLayout;
	}

	public void draw(Gui gui,Container container,int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		if(guiContainerLayout != null){
			guiContainerLayout.draw(gui,container,index, offsetX + rect.x, offsetY+rect.y, mouseX,mouseY);
		}
	}

	public void drawFilledPanel(Gui gui,int index,int x, int y, Recipe recipe, int mouseX,int mouseY, Block craftingBlock) {
		if(guiContainerLayout != null){
			guiContainerLayout.drawFilled(gui,slotLayout,recipe,index, x, y, mouseX,mouseY,craftingBlock);
		}
	}
}
