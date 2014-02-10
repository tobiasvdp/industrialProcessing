package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.gui.container.syncing.info.InfoButton;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Container;

public class GuiContainerLayoutButton extends GuiContainerLayout {

	private GuiButton button;
	private Rectangle rectangle;
	private String[] displayString;
	private GuiContainerDrawRectagle[] icons;
	private boolean drawIcons;
	private boolean specificTexture = true;

	@Override
	public void drawForeGround(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.draw(gui, container, index, offsetX, offsetY, mouseX, mouseY);
		if (container instanceof ContainerIP && gui instanceof GuiContainerIP) {
			ContainerIP handlerContainer = (ContainerIP) container;
			ArrayList<IHandlerContainer> handlers = handlerContainer.getHandlers(GuiLayoutPanelType.singlebutton);
			if (handlers.size() > index) {
				InfoButton info = HandlerButton.getInfo(((IHandlerButton) handlers.get(index)));
				if (info.state != -1) {
					if (drawIcons) {
						if (specificTexture)
							((GuiContainerIP) gui).setTextureSpecific();
						else
							((GuiContainerIP) gui).setTextureLayout();
						gui.drawTexturedModalRect(icons[info.state].destination.x + offsetX, icons[info.state].destination.y + offsetY, icons[info.state].origin.x, icons[info.state].origin.y, icons[info.state].origin.width, icons[info.state].origin.height);
						((GuiContainerIP) gui).setTextureLayout();
						if (new Rectangle(offsetX, offsetY, rectangle.width, rectangle.height).contains(mouseX, mouseY))
							((GuiContainerIP) gui).toolTip = new ToolTip(displayString[info.state]);
					} else {
						button.displayString = displayString[info.state];
						((GuiContainerIP) gui).refresh();
					}
				}
			}
		}
	}

	@Override
	public void draw(Gui gui, Container container, int index, int offsetX, int offsetY, int mouseX, int mouseY) {

	}

	@Override
	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY, Block craftingBlock) {
	}

	public ArrayList<GuiButton> getButtons(int offsetX, int offsetY) {
		ArrayList<GuiButton> buttons = new ArrayList<GuiButton>();
		buttons.add(new GuiButton(button.id, button.xPosition + offsetX, button.yPosition + offsetY, rectangle.width, rectangle.height, button.displayString));
		return buttons;
	}

	public void setButton(Rectangle... rect) {
		button = new GuiButton(0, rect[0].x, rect[0].y, rect[0].width, rect[0].height, "");
		rectangle = new Rectangle(rect[0].x, rect[0].y, rect[0].width, rect[0].height);
	}

	public void setButtonValues(String[] states) {
		displayString = states;
	}

	public void setButtonIcons(GuiContainerDrawRectagle[] rect) {
		drawIcons = true;
		icons = rect;
	}

	public void setButtonIconsCentered() {
		for (GuiContainerDrawRectagle icon : icons) {
			int x = rectangle.width / 2 - icon.origin.width / 2;
			int y = rectangle.height / 2 - icon.origin.height / 2;
			icon.destination = new Point(x, y);
		}
	}

	public void setButtonIconsLayoutBound() {
		specificTexture = false;

	}
}
