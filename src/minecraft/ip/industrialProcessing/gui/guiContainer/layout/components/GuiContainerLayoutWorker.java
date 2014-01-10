package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;

import java.awt.Rectangle;

import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutWorker extends GuiContainerLayout {

	private static Rectangle rectangle = new Rectangle(96, 240, 24, 16);

	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY,int mouseX,int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY,mouseX,mouseY);
		if (container instanceof ContainerWorkerMachine) {
			ContainerWorkerMachine workercontainer = (ContainerWorkerMachine) container;
			ProgressInfoWorker info = workercontainer.getProgressInfoWorker(index);
			if (info.totalWork != 0)
				gui.drawTexturedModalRect(1 + offsetX, 1 + offsetY, rectangle.x, rectangle.y, info.workDone * rectangle.width / info.totalWork, rectangle.height);
		}
	}
}
