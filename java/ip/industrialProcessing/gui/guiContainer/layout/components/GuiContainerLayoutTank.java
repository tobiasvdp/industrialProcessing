package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerTank;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerTank;
import ip.industrialProcessing.gui.container.syncing.info.InfoTank;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class GuiContainerLayoutTank extends GuiContainerLayout {

	private static Rectangle rectangle = new Rectangle(90, 206, 16, 50);

	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP && gui instanceof GuiContainerIP) {
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.tankInput, GuiLayoutPanelType.tankOutput, GuiLayoutPanelType.simpleTankInput,GuiLayoutPanelType.simpleTankOutput);
			if (handlers.size() > index) {
				InfoTank info = HandlerTank.getInfo(((IHandlerTank) handlers.get(index)));
				if (info.capacity != 0) {
					drawProgressBarTank((GuiContainerIP) gui, offsetX, offsetY, info, mouseX, mouseY);
					gui.drawTexturedModalRect(1 + offsetX, 1 + offsetY, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
				}
			}
		}
	}

	protected void drawProgressBarTank(GuiContainerIP gui, int offsetX, int offsetY, InfoTank tank, int mouseX, int mouseY) {
		if (tank.amount > 0) {

			Fluid fluid = FluidRegistry.getFluid(tank.fluidId);
			if (fluid != null) {
				Icon icon = fluid.getIcon();
				gui.setTextureBlocks();

				int size = tank.amount * rectangle.height / tank.capacity;
				int targetX = offsetX + 1;
				int targetY0 = offsetY+1;
				int targetY = targetY0 +  rectangle.height  - size;

				gui.drawTexturedModelRectFromIcon(targetX, targetY, icon, rectangle.width, size);

				gui.setTextureLayout();

				//tooltip
				Rectangle target = new Rectangle(targetX, targetY0, rectangle.width, rectangle.height);
				if (target.contains(mouseX, mouseY)) {
					String name = fluid.getLocalizedName();
					if (name.equals(fluid.getUnlocalizedName())) {
						int blockID = fluid.getBlockID();
						name = Block.blocksList[blockID].getLocalizedName();
					}
					gui.toolTip = new ToolTip(name, "\u00a77" + tank.amount + "mB");
				}
			}
		}
	}

}
