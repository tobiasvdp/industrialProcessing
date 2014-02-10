package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Rectangle;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutImage extends GuiContainerLayout {
	private Rectangle rectangle;
	public void setOrigin(Rectangle rect){
		rectangle = rect;
	}
	
	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		((GuiContainerIP) gui).setTextureSpecific();
		gui.drawTexturedModalRect(offsetX, offsetY, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		((GuiContainerIP) gui).setTextureLayout();
	}
	
	@Override
	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY, Block craftingBlock) {
	}
}
