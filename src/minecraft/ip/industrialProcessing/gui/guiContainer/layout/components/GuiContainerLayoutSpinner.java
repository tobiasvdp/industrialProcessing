package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.info.InfoButton;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;

import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutSpinner extends GuiContainerLayoutButton {
	
	@Override
	public void drawForeGround(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP && gui instanceof GuiContainerIP) {

		}
	}
}
