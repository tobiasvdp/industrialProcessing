package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerPower;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerWorker;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerPower;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerWorker;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.gui.container.syncing.info.InfoWorker;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.items.guide.gui.machines.GuideMachinePage;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

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
			((GuiContainerIP) gui).setTextureWorker();
			gui.drawTexturedModalRect(offsetX, offsetY, rectangleBare.x, rectangleBare.y, rectangleBare.width, rectangleBare.height);
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.worker);
			if (handlers.size() != 0) {
				InfoWorker info = HandlerWorker.getInfo(((IHandlerWorker) handlers.get(0)));
				if (info.totalWork != 0 && gui instanceof GuiContainerIP) {
					gui.drawTexturedModalRect(offsetX, offsetY, rectangleFill.x, rectangleFill.y, info.workDone * rectangleFill.width / info.totalWork, rectangleFill.height);
				}
			}
			((GuiContainerIP) gui).setTextureLayout();
		}
	}

	@Override
	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY,Block craftingBlock) {

		if(gui instanceof GuideMachinePage){
		((GuideMachinePage)gui).setTextureWorker(craftingBlock);
			gui.drawTexturedModalRect(x, y + 19, rectangleFill.x, rectangleFill.y, rectangleFill.width, rectangleFill.height);
		((GuideMachinePage)gui).setTextureLayout();
		}
	}
}
