package ip.industrialProcessing.gui;

import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInventory;
import ip.industrialProcessing.recipes.Recipe;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class GuiLayout {

	ArrayList<GuiLayoutPanel> layoutPanels;
	int slotIndex = 0;

	public GuiLayout() {
		layoutPanels = new ArrayList<GuiLayoutPanel>();
		addLayoutPanel(GuiLayoutPanelType.slotsInventory);
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
			x = 47 + offsetX;
			y = 45;
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52);
			// SlotLayout set by Block
			// GuiContainerLayout set in above function
			layoutPanels.add(panel);
			break;
		case slotsOutput:
			x = 135 + offsetX;
			y = 45;
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52);
			// SlotLayout set by Block
			// GuiContainerLayout set in above function
			layoutPanels.add(panel);
			break;
		case slotsSide:
			break;
		case tankInput:
		case tankOutput:
			x = 0;
			y = 45;
			panel = new GuiLayoutPanel(this, type, x, y, 40, 52);
			panel.setSlotLayout(SlotLayoutType.fixed, 2);
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case slotsInventory:
			x = 8;
			y = 116;
			panel = new GuiLayoutPanel(this, type, x, y, 222, 76);
			panel.setSlotLayout(SlotLayoutType.inventory, 0);
			// no draw required
			layoutPanels.add(panel);
			break;
		case worker:
			x = 106;
			y = 64 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 24, 16);
			// No slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case power:
			x = 150;
			y = 9 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 74, 18);
			panel.setSlotLayout(SlotLayoutType.fixed, 1);
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case heat:
			x = 0;
			y = 44 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 35, 54,15,54);
			panel.setSlotLayout(SlotLayoutType.fixed, 2);
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case lifespan:
			x = 8;
			y = 16 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 50, 8);
			//no slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		default:
			break;

		}
		reDoLayout();
		return panel;
	}

	public int getSlotIndex() {
		return slotIndex;
	}

	public void setSlotIndex(int val) {
		slotIndex = val;
	}

	public Iterator<Slot> getSlotsMachine(IInventory iinventory) {
		ArrayList<Slot> slots = new ArrayList<Slot>();
		Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
		while (it.hasNext()) {
			GuiLayoutPanel container = it.next();
			if (container.getSlotLayout() != null && !(container.getSlotLayout() instanceof SlotLayoutInventory)) {
				Slot[] containerSlots = container.getSlotLayout().getGuiContainerSlots(iinventory);
				for (int i = 0; i < containerSlots.length; i++)
					slots.add(containerSlots[i]);
			}
		}
		return slots.iterator();
	}

	public Iterator<Slot> getSlotsInventory(IInventory iinventory) {
		ArrayList<Slot> slots = new ArrayList<Slot>();
		Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
		while (it.hasNext()) {
			GuiLayoutPanel container = it.next();
			if (container.getSlotLayout() != null && (container.getSlotLayout() instanceof SlotLayoutInventory)) {
				Slot[] containerSlots = container.getSlotLayout().getGuiContainerSlots(iinventory);
				for (int i = 0; i < containerSlots.length; i++)
					slots.add(containerSlots[i]);
			}
		}
		return slots.iterator();
	}

	public void reDoLayout() {
		int widthScreen = 236;
		ArrayList<GuiLayoutPanel> panels = getOrganizedPanels();
		int totalWidth = 0;
		for (int i = 0; i < panels.size(); i++) {
			totalWidth += panels.get(i).getWidth();
		}
		int margin = (widthScreen - totalWidth) / (panels.size() + 1);
		totalWidth = 0;
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).setX(totalWidth + (i + 1) * margin);
			totalWidth += panels.get(i).getWidth();
		}
	}

	private ArrayList<GuiLayoutPanel> getOrganizedPanels() {
		ArrayList<GuiLayoutPanel> panels = new ArrayList<GuiLayoutPanel>();
		for (GuiLayoutPanelType type : new GuiLayoutPanelType[] { GuiLayoutPanelType.heat,GuiLayoutPanelType.tankInput, GuiLayoutPanelType.slotsInput, GuiLayoutPanelType.worker, GuiLayoutPanelType.slotsOutput, GuiLayoutPanelType.tankOutput }) {
			Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
			while (it.hasNext()) {
				GuiLayoutPanel panel = it.next();
				if (panel.type == type) {
					panels.add(panel);
				}
			}
		}
		return panels;
	}

	public void draw(Gui gui, Container container, int offsetX, int offsetY, int mouseX, int mouseY) {
		int typeIndex = 0;
		GuiLayoutPanelType type = null;
		for (int i = 0; i < layoutPanels.size(); i++) {
			GuiLayoutPanel panel = layoutPanels.get(i);
			GuiLayoutPanelType panelType = panel.type;
			if (type == null)
				type = panel.type;

			if (type != panelType) {
				if ((type == GuiLayoutPanelType.tankInput && panelType == GuiLayoutPanelType.tankOutput) || (type == GuiLayoutPanelType.tankOutput && panelType == GuiLayoutPanelType.tankInput)) {

				} else {
					typeIndex = 0;
					type = panelType;
				}
			}

			panel.draw(gui, container, typeIndex, offsetX, offsetY, mouseX, mouseY);

			typeIndex++;
		}
	}

	public void addSyncingHandlersToContainer(ContainerIP container, TileEntity tileEntity) {
		int typeIndex = 0;
		GuiLayoutPanelType type = null;
		for (int i = 0; i < layoutPanels.size(); i++) {
			GuiLayoutPanel panel = layoutPanels.get(i);
			GuiLayoutPanelType panelType = panel.type;

			if (type == null)
				type = panel.type;

			if (type != panelType) {
				if ((type == GuiLayoutPanelType.tankInput && panelType == GuiLayoutPanelType.tankOutput) || (type == GuiLayoutPanelType.tankOutput && panelType == GuiLayoutPanelType.tankInput)) {

				} else {
					typeIndex = 0;
					type = panelType;
				}
			}

			container.addHandlerToContainer(panelType, typeIndex);

			typeIndex++;
		}
	}

	public void drawFilledPanels(Rectangle rectangle, Gui gui, int mouseX,int mouseY,Recipe recipe, Block craftingBlock) {
		ArrayList<GuiLayoutPanel> panels = getOrganizedPanels();
		
		int typeIndex = 0;
		GuiLayoutPanelType type = null;
		int offset = 3;
		int x = rectangle.x + offset;
		int y = rectangle.y + offset;
		int ymax = 0;
		for (int i = 0; i < panels.size(); i++) {
			
			GuiLayoutPanel panel = panels.get(i);
			GuiLayoutPanelType panelType = panel.type;

			if (type == null)
				type = panel.type;

			if (type != panelType) {
				if ((type == GuiLayoutPanelType.tankInput && panelType == GuiLayoutPanelType.tankOutput) || (type == GuiLayoutPanelType.tankOutput && panelType == GuiLayoutPanelType.tankInput)) {

				} else {
					typeIndex = 0;
					type = panelType;
				}
			}
			
			if(panel.getHeight() > ymax)
				ymax = panel.getHeight();
			if(panel.getWidthReduced() + x > rectangle.x+rectangle.width){
				x = rectangle.x + offset;
				y= y+= ymax + offset;
				ymax = 0;
			}
			panel.drawFilledPanel(gui,typeIndex,x,y,recipe,mouseX,mouseY,craftingBlock);
			x +=  panel.getWidthReduced() + offset;
			
			typeIndex++;
		}
	}
}
