package ip.industrialProcessing.gui;

import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutComponent;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInput;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInventory;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerWorkerMachine;
import ip.industrialProcessing.machines.crusher.GuiContainerCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.slots.SlotBase;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
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
			y = 31;
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52);
			layoutPanels.add(panel);
			break;
		case slotsOutput:
			x = 135 + offsetX;
			y = 31;
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52);
			layoutPanels.add(panel);
			break;
		case slotsSide:
			break;
		case slotsInventory:
			panel = new GuiLayoutPanel(this, type, 8, 116, 222, 76);
			panel.setSlotLayout(SlotLayoutType.inventory, 0);
			layoutPanels.add(panel);
			break;
		case worker:
			x = 106;
			y = 50 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 24, 16);
			panel.setGuiContainerLayout(type).addDrawRectagle(72, 240, 24, 16);
			layoutPanels.add(panel);
			break;
		case power:
			x = 177;
			y = 6 + offsetY;
			panel = new GuiLayoutPanel(this, type, x, y, 54, 10);
			panel.setGuiContainerLayout(type).addDrawRectagle(18, 246, 54, 10);
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
		ArrayList<GuiLayoutPanel> panels = new ArrayList<GuiLayoutPanel>();
		for (GuiLayoutPanelType type : new GuiLayoutPanelType[] { GuiLayoutPanelType.slotsInput, GuiLayoutPanelType.worker, GuiLayoutPanelType.slotsOutput }) {
			Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
			while (it.hasNext()) {
				GuiLayoutPanel panel = it.next();
				if (panel.type == type) {
					panels.add(panel);
				}
			}
		}
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

	public void draw(Gui gui, Container container, int offsetX, int offsetY, int mouseX, int mouseY) {
		int typeIndex = 0;
		GuiLayoutPanelType type = null;
		for (int i = 0; i < layoutPanels.size(); i++) {
			GuiLayoutPanel panel = layoutPanels.get(i);
			GuiLayoutPanelType panelType = panel.type;
			if (type == null)
				type = panel.type;

			if (type != panelType) {
				typeIndex = 0;
				type = panelType;
			}

			panel.draw(gui, container, typeIndex, offsetX, offsetY,mouseX,mouseY);

			typeIndex++;
		}
	}

	public void addComponentsToContainer(Container container, TileEntity tileEntity) {
		int typeIndex = 0;
		GuiLayoutPanelType type = null;
		for (int i = 0; i < layoutPanels.size(); i++) {
			GuiLayoutPanel panel = layoutPanels.get(i);
			GuiLayoutPanelType panelType = panel.type;
			if (type == null)
				type = panel.type;

			if (type != panelType) {
				typeIndex = 0;
				type = panelType;
			}

			switch(panelType){
			case power:
				if(container instanceof ContainerPoweredWorkerMachine && tileEntity instanceof TileEntityPoweredWorkerMachine){
					((ContainerPoweredWorkerMachine)container).addPowerToContainer(((TileEntityPoweredWorkerMachine)tileEntity).getMainPowerStorage());
				}
				break;
			case tank:
				break;
			case worker:
				if(container instanceof ContainerWorkerMachine && tileEntity instanceof TileEntityWorkerMachine){
					((ContainerWorkerMachine)container).addWorkerToContainer(((TileEntityWorkerMachine)tileEntity).getWorker());
				}
				break;
			default:
				break;
			
			}

			typeIndex++;
		}
	}
}
