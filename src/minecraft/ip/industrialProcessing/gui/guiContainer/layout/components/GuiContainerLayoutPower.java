package ip.industrialProcessing.gui.guiContainer.layout.components;

import java.awt.Rectangle;

import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.GuiContainerView;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.gui.PowerToolTip;

public class GuiContainerLayoutPower extends GuiContainerLayout {

	private static Rectangle rectangle = new Rectangle(18, 238, 52, 8);

	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerPoweredWorkerMachine) {
			ContainerPoweredWorkerMachine powercontainer = (ContainerPoweredWorkerMachine) container;
			ProgressInfoPower info = powercontainer.getProgressInfoPower(index);
			if (info.powerCapacity != 0) {
				gui.drawTexturedModalRect(1 + offsetX, 1 + offsetY, rectangle.x, rectangle.y, info.storedPower * rectangle.width / info.powerCapacity, rectangle.height);
				if (gui instanceof GuiContainerView) {
					ToolTip toolTip = PowerToolTip.getToolTip(info, new org.lwjgl.util.Rectangle(1 + offsetX, 1 + offsetY, rectangle.width, rectangle.height), mouseX, mouseY);
					if (toolTip != null)
						((GuiContainerView) gui).toolTip = toolTip;
				}
			}
		}
	}
}
