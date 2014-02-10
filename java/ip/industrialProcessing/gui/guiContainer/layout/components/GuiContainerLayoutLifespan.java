package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerLifeSpan;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerLifeSpan;
import ip.industrialProcessing.gui.container.syncing.info.InfoLifeSpan;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;

import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutLifespan extends GuiContainerLayout{
	private static Rectangle rectangle = new Rectangle(126, 242, 48, 6);
	
	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP) {
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.lifespan);
			if (handlers.size() != 0){
				InfoLifeSpan info = HandlerLifeSpan.getInfo(((IHandlerLifeSpan) handlers.get(0)));
				if (info.maxLifeTime != 0) {
					gui.drawTexturedModalRect(1 + offsetX, 1 + offsetY, rectangle.x, rectangle.y, info.lifeTime * rectangle.width / info.maxLifeTime, rectangle.height);
					if (gui instanceof GuiContainerIP) {
						Rectangle target = new Rectangle(offsetX+1, offsetY+1, 48, 6);
						if (target.contains(mouseX, mouseY)) {
							String name = "Durability";
							((GuiContainerIP) gui).toolTip = new ToolTip(name, "\u00a77" + info.lifeTime + " / " + info.maxLifeTime);
						}
					}
				}
			}
		}
	}
}
