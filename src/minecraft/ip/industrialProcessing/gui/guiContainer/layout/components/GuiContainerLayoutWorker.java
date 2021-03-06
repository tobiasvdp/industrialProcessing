package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerWorker;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerWorker;
import ip.industrialProcessing.gui.container.syncing.info.InfoWorker;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutWorker extends GuiContainerLayout {

    private static Rectangle rectangleBare = GuiContainerLayout.workerLocations[0];
    private static Rectangle rectangleFill = GuiContainerLayout.workerLocations[1];

    @Override
    public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
	super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
	if (container instanceof ContainerIP) {
	    ((GuiContainerIP) gui).setTextureSpecific();
	    gui.drawTexturedModalRect(offsetX, offsetY, rectangleBare.x, rectangleBare.y, rectangleBare.width, rectangleBare.height);
	    ContainerIP handlerContainer = (ContainerIP) container;
	    ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.worker);
	    if (handlers.size() != 0) {
		InfoWorker info = HandlerWorker.getInfo(((IHandlerWorker) handlers.get(0)));
		if (info.totalWork != 0 && gui instanceof GuiContainerIP) {
		    gui.drawTexturedModalRect(offsetX, offsetY, rectangleFill.x, rectangleFill.y, info.workDone * rectangleFill.width / info.totalWork, rectangleFill.height);
		    Rectangle target = new Rectangle(offsetX, offsetY, rectangleBare.width, rectangleBare.height);
		    if (target.contains(mouseX, mouseY)) {
			((GuiContainerIP) gui).toolTip = new ToolTip("\u00a77" + info.workDone + "/" + info.totalWork);
		    }
		}
	    }
	    ((GuiContainerIP) gui).setTextureLayout();
	}
    }

    @Override
    public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY, Block craftingBlock) {

    }
}
