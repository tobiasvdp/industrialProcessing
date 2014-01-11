package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerPower;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerPower;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.machines.containers.gui.PowerToolTip;

import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutPower extends GuiContainerLayout {

	private static Rectangle rectangle = new Rectangle(18, 238, 52, 8);

	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP) {
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.power);
			if (handlers.size() != 0){
				InfoPower info = HandlerPower.getInfo(((IHandlerPower) handlers.get(0)));
				if (info.powerCapacity != 0) {
					gui.drawTexturedModalRect(21 + offsetX, 5 + offsetY, rectangle.x, rectangle.y, info.storedPower * rectangle.width / info.powerCapacity, rectangle.height);
					if (gui instanceof GuiContainerIP) {
						ToolTip toolTip = PowerToolTip.getToolTip(info, new org.lwjgl.util.Rectangle(21 + offsetX, 5 + offsetY, rectangle.width, rectangle.height), mouseX, mouseY);
						if (toolTip != null)
							((GuiContainerIP) gui).toolTip = toolTip;
					}
				}
			}
		}
	}
}
