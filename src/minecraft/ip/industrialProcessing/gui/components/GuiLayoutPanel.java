package ip.industrialProcessing.gui.components;

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
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerDrawRectagle;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutButton;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutHeat;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutImage;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutLifespan;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutPower;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutSimpleHeat;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutSlot;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutTank;
import ip.industrialProcessing.gui.guiContainer.layout.components.GuiContainerLayoutWorker;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Container;

public class GuiLayoutPanel {
	Rectangle rect;
	Rectangle rectReduced;
	public GuiLayoutPanelType type;
	GuiLayout parent;
	boolean fixed;

	public int line = 1;

	SlotLayout slotLayout;
	GuiContainerLayout guiContainerLayout;

	public GuiLayoutPanel(GuiLayout layout, GuiLayoutPanelType type, int x, int y, int width, int height, boolean fixed) {
		rect = new Rectangle(x, y, width, height);
		this.fixed = fixed;
		this.type = type;
		parent = layout;
	}

	public GuiLayoutPanel(GuiLayout layout, GuiLayoutPanelType type, int x, int y, int width, int height, boolean fixed, int width2, int height2) {
		rect = new Rectangle(x, y, width, height);
		this.fixed = fixed;
		rectReduced = new Rectangle(x, y, width2, height2);
		this.type = type;
		parent = layout;
	}
	
	public boolean isFixed(){
		return fixed;
	}
	
	public Rectangle getRect(){
		return rect;
	}

	public GuiLayoutPanel setLine(int line) {
		this.line = line;
		return this;
	}

	public int getHeight() {
		return rect.height;
	}

	public int getWidth() {
		return rect.width;
	}

	public int getWidthReduced() {
		if (rectReduced != null)
			return rectReduced.width;
		return rect.width;
	}

	public int getX() {
		return rect.x;
	}

	public void setX(int val) {
		rect.x = val;
	}

	public void setY(int y) {
		this.rect.y = y;
	}

	public int getY() {
		return rect.y;
	}

	public void setSlotLayout(SlotLayoutType layout, int amount, int... startIndex) {
		int slotindex = 0;
		if(startIndex.length == 1){
			System.out.println("check");
		}else{
			slotindex = parent.getSlotIndex();
		}
		switch (getSlotComponent()) {
		case inventory:
			this.slotLayout = new SlotLayoutInventory(rect);
			break;
		case input:
			this.slotLayout = new SlotLayoutInput(layout, amount, slotindex, rect);
			setGuiContainerLayout(GuiLayoutPanelType.slotsInput);
			parent.setSlotIndex(slotindex + amount);
			break;
		case output:
			this.slotLayout = new SlotLayoutOutput(layout, amount, slotindex, rect);
			setGuiContainerLayout(GuiLayoutPanelType.slotsOutput);
			parent.setSlotIndex(slotindex + amount);
			break;
		case power:
			this.slotLayout = new SlotLayoutPower(slotindex, rect);
			parent.setSlotIndex(slotindex + amount);
			break;
		case side:
			break;
		case tankOutput:
			this.slotLayout = new SlotLayoutTank(slotindex, rect, true);
			parent.setSlotIndex(slotindex + amount);
			break;
		case tankInput:
			this.slotLayout = new SlotLayoutTank(slotindex, rect, false);
			parent.setSlotIndex(slotindex + amount);
			break;
		case heat:
			this.slotLayout = new SlotLayoutHeat(slotindex, rect);
			parent.setSlotIndex(slotindex + amount);
			break;
		default:
			break;
		}
		parent.reDoLayout();
	}
	
	public GuiLayoutPanel setImageLocation(Rectangle rect){
		if(type == GuiLayoutPanelType.image){
			this.rect.setSize(rect.width, rect.height);
			((GuiContainerLayoutImage)this.guiContainerLayout).setOrigin(rect);
			parent.reDoLayout();
		}
		return this;
	}
	
	public GuiLayoutPanel setButtonSize(int width,int height){
		if(type == GuiLayoutPanelType.singlebutton){
			this.rect.setSize(width, height);
			((GuiContainerLayoutButton)this.guiContainerLayout).setButton(new Rectangle(0,0,width,height));
			parent.reDoLayout();
		}
		return this;
	}
	public GuiLayoutPanel setButtonsSize(Rectangle... rect){
		//wrong
		if(type == GuiLayoutPanelType.singlebutton){
			((GuiContainerLayoutButton)this.guiContainerLayout).setButton(rect);
			parent.reDoLayout();
		}
		return this;
	}
	public GuiLayoutPanel setButtonStateNames(String... states){
		if(type == GuiLayoutPanelType.singlebutton){
			((GuiContainerLayoutButton)this.guiContainerLayout).setButtonValues(states);
		}
		return this;
	}
	
	public GuiLayoutPanel setButtonIcons(Rectangle... rectangle){
		if(type == GuiLayoutPanelType.singlebutton){
			GuiContainerDrawRectagle[] icons = new GuiContainerDrawRectagle[rectangle.length];
			for(int i =0;i<rectangle.length;i++){
				icons[i] = new GuiContainerDrawRectagle();
				icons[i].destination = new Point(0,0);
				icons[i].origin = new Rectangle(rectangle[i].x,rectangle[i].y,rectangle[i].width,rectangle[i].height);
			}
			((GuiContainerLayoutButton)this.guiContainerLayout).setButtonIcons(icons);
		}
		return this;
	}
	
	public GuiLayoutPanel setButtonIconsCentered() {
		if(type == GuiLayoutPanelType.singlebutton ){
			((GuiContainerLayoutButton)this.guiContainerLayout).setButtonIconsCentered();
		}
		return this;
	}
	
	public GuiLayoutPanel setButtonLayoutTexture() {
		if(type == GuiLayoutPanelType.singlebutton ){
			((GuiContainerLayoutButton)this.guiContainerLayout).setButtonIconsLayoutBound();
		}
		return this;
	}
	
	public ArrayList<GuiButton> getGuiButtons(int offsetX, int offsetY){ 
		return ((GuiContainerLayoutButton)this.guiContainerLayout).getButtons(offsetX+ rect.x,offsetY+ rect.y);
	}

	public SlotLayout getSlotLayout() {
		return slotLayout;
	}

	private SlotLayoutComponent getSlotComponent() {
		switch (type) {
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

	public GuiContainerLayout setGuiContainerLayout(GuiLayoutPanelType type) {
		switch (type) {
		case power:
			guiContainerLayout = new GuiContainerLayoutPower();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this, this.slotLayout, SlotType.power);
			guiContainerLayout.addDrawRectagle(20, 4, 18, 246, 54, 10);
			break;
		case simpleTankInput:
		case simpleTankOutput:
			guiContainerLayout = new GuiContainerLayoutTank();
			guiContainerLayout.addDrawRectagle(72, 204, 18, 52);
			break;
		case tankInput:
		case tankOutput:
			guiContainerLayout = new GuiContainerLayoutTank();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this, this.slotLayout, SlotType.tank);
			guiContainerLayout.addDrawRectagle(72, 204, 18, 52);
			break;
		case worker:
			guiContainerLayout = new GuiContainerLayoutWorker();
			// draws from different texture file, done in worker component
			break;
		case slotsInput:
			this.guiContainerLayout = new GuiContainerLayoutSlot();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this, this.slotLayout);
			break;
		case slotsOutput:
			this.guiContainerLayout = new GuiContainerLayoutSlot();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this, this.slotLayout);
			break;
		case slotsSide:
			break;
		case heat:
			guiContainerLayout = new GuiContainerLayoutHeat();
			this.guiContainerLayout.addDrawRectaglesFromSlotLayout(this, this.slotLayout, SlotType.inventory);
			guiContainerLayout.addDrawRectagle(106, 202, 15, 54);
			guiContainerLayout.addDrawRectagle(18, 19, 56, 206, 16, 16);
			break;
		case simpleHeat:
			guiContainerLayout = new GuiContainerLayoutSimpleHeat();
			guiContainerLayout.addDrawRectagle(106, 202, 15, 54);
			break;
		case lifespan:
			guiContainerLayout = new GuiContainerLayoutLifespan();
			guiContainerLayout.addDrawRectagle(126, 248, 50, 8);
			break;
		case image:
			guiContainerLayout = new GuiContainerLayoutImage();
			// draws from different texture file, done in image component
			break;
		case singlebutton:
			guiContainerLayout = new GuiContainerLayoutButton();
			break;
		default:
			break;

		}
		return guiContainerLayout;
	}

	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		if (guiContainerLayout != null) {
			guiContainerLayout.draw(gui, container, index, offsetX + rect.x, offsetY + rect.y, mouseX, mouseY);
		}
	}

	public void drawFilledPanel(Gui gui, int index, int x, int y, Recipe recipe, int mouseX, int mouseY, Block craftingBlock) {
		if (guiContainerLayout != null) {
			guiContainerLayout.drawFilled(gui, slotLayout, recipe, index, x, y, mouseX, mouseY, craftingBlock);
		}
	}

	public void drawForeGround(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		if (guiContainerLayout != null) {
			guiContainerLayout.drawForeGround(gui, container, index, offsetX + rect.x, offsetY + rect.y, mouseX, mouseY);
		}
	}


}
