package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerHeat;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerHeat;
import ip.industrialProcessing.gui.container.syncing.info.InfoHeat;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutHeat extends GuiContainerLayout {
	private static Rectangle rectangleBar = new Rectangle(121, 203, 5, 35);
	private static Rectangle rectangleFlame = new Rectangle(56, 222, 16, 16);
	
	public GuiContainerLayoutHeat() {
		super();
	}
	
	@Override
	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY,Block craftingBlock) {
		gui.drawTexturedModalRect(x,y,106, 202, 15, 54);
		InfoHeat info = new InfoHeat();
		if (gui instanceof GuiContainerIP) {
			Rectangle target = new Rectangle(x, y, 15, 54);
			if (target.contains(mouseX, mouseY)) {
				String name = "Heat";
				((GuiContainerIP) gui).toolTip = new ToolTip(name, "\u00a77" + info.heat + (char) 176 + "C / " + info.maxHeat + (char) 176 + "C");
			}
		}
	}

	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP) {
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.heat);
			if (handlers.size() != 0) {
				InfoHeat info = HandlerHeat.getInfo(((IHandlerHeat) handlers.get(0)));
				if (info.maxHeat != 0) {
					int x = offsetX + 5;
					int y0 = 1 + offsetY;
					int height = info.heat * rectangleBar.height / info.maxHeat;
					int y = y0 + rectangleBar.height - height;
					gui.drawTexturedModalRect(x, y, rectangleBar.x, rectangleBar.y + rectangleBar.height - height, rectangleBar.width, height);
					if (gui instanceof GuiContainerIP) {
						Rectangle target = new Rectangle(offsetX, offsetY, 15, 54);
						if (target.contains(mouseX, mouseY)) {
							String name = "Heat";
							((GuiContainerIP) gui).toolTip = new ToolTip(name, "\u00a77" + info.heat + (char) 176 + "C / " + info.maxHeat + (char) 176 + "C");
						}
					}
				}
				if (info.maxBurnTime != 0) {
					int x = offsetX + 18;
					int y0 = 19 + offsetY;
					int height = info.burnTime * rectangleFlame.height / info.maxBurnTime;
					int y = y0 + rectangleFlame.height - height;
					gui.drawTexturedModalRect(x, y, rectangleFlame.x, rectangleFlame.y + rectangleFlame.height - height, rectangleFlame.width, height);
					if (gui instanceof GuiContainerIP) {
						Rectangle target = new Rectangle(x, y0, 16, 16);
						if (target.contains(mouseX, mouseY)) {
							String name = "Burning";
							((GuiContainerIP) gui).toolTip = new ToolTip(name, "\u00a77" + info.burnTime + " / " + info.maxBurnTime);
						}
					}
				}
			}
		}
	}
}
