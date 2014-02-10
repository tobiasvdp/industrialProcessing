package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutSpinner extends GuiContainerLayoutButton {
	
	@Override
	public void drawForeGround(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP && gui instanceof GuiContainerIP) {

		}
	}
}
