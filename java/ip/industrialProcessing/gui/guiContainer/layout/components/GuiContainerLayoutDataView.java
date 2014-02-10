package ip.industrialProcessing.gui.guiContainer.layout.components;

import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerDataView;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerDataView;
import ip.industrialProcessing.gui.container.syncing.info.InfoButton;
import ip.industrialProcessing.gui.container.syncing.info.InfoDataView;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;

public class GuiContainerLayoutDataView extends GuiContainerLayout {

	
	@Override
	public void drawForeGround(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.drawForeGround(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP && gui instanceof GuiContainerIP) {
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.dataview);
			if (handlers.size() > index) {
				InfoDataView info = HandlerDataView.getInfo(((IHandlerDataView) handlers.get(index)));
				if (info.state != -1) {
						gui.drawCenteredString(((GuiContainerIP)gui).getFontRenderer(), info.state + "", offsetX+9, offsetY+5, 16777215);
						((GuiContainerIP)gui).setTextureLayout();
				}
			}
		}
	}
	
}
