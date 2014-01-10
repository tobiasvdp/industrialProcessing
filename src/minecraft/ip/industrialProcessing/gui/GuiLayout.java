package ip.industrialProcessing.gui;

import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutComponent;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInput;
import ip.industrialProcessing.machines.crusher.GuiContainerCrusher;
import ip.industrialProcessing.slots.SlotBase;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class GuiLayout {

	ArrayList<GuiLayoutPanel> layoutPanels;
	int slotIndex = 0;

	public GuiLayout() {
		layoutPanels = new ArrayList<GuiLayoutPanel>();
		slotIndex = 0;
	}

	public GuiLayoutPanel addLayoutPanel(GuiLayoutPanelType type) {
		GuiLayoutPanel panel = null;
		int x = 0;
		int y = 0;
		int offsetX = 0;
		int offsetY = 0;
		for (int i = 0; i < layoutPanels.size(); i++) {
			if (layoutPanels.get(i).type == type) {
				offsetX += 2 + layoutPanels.get(i).getWidth();
				offsetY += 2 + layoutPanels.get(i).getHeight();
			}
		}

		switch (type) {
		case slotsInput:
			x = 43 + offsetX;
			y = 20;
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52);
			layoutPanels.add(panel);
			break;
		case slotsOutput:
			x = 115 + offsetX;
			y = 20;
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52);
			layoutPanels.add(panel);
			break;
		case slotsSide:
			break;
		case worker:
			x = 94;
			y = 41 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 24, 16);
			panel.setGuiContainerLayout().addDrawRectagle(x, y, 72, 240, 24, 16);
			layoutPanels.add(panel);
			break;
		case power:
			x = 116;
			y = 6 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 54, 10);
			panel.setGuiContainerLayout().addDrawRectagle(x, y, 18, 246, 54, 10);
			layoutPanels.add(panel);
			break;
		default:
			break;

		}
		return panel;
	}

	public int getSlotIndex() {
		return slotIndex;
	}

	public void setSlotIndex(int val) {
		slotIndex = val;
	}

	public Iterator<Slot> getSlots(IInventory iinventory) {
		ArrayList<Slot> slots = new ArrayList<Slot>();
		Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
		while (it.hasNext()) {
			GuiLayoutPanel container = it.next();
			if (container.getSlotLayout() != null) {
				SlotBase[] containerSlots = container.getSlotLayout().getGuiContainerSlots(iinventory);
				for (int i = 0; i < containerSlots.length; i++)
					slots.add(containerSlots[i]);
			}
		}
		return slots.iterator();
	}

	public void draw(Gui gui, int offsetX, int offsetY) {
		for (int i = 0; i < layoutPanels.size(); i++) {
			layoutPanels.get(i).draw(gui, offsetX, offsetY);
		}
	}
}
