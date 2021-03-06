package ip.industrialProcessing.gui;

import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.components.GuiLayoutPanelTypeClass;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui.container.slot.layout.components.SlotLayoutInventory;
import ip.industrialProcessing.recipes.Recipe;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Rect;

import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class GuiLayout {

	ArrayList<GuiLayoutPanel> layoutPanels;
	int slotIndex = 0;

	public int multipleLines = 1;
	public boolean useMargin = true;
	public int minMargin = 25;
	public boolean drawTitel = true;
	public boolean drawInventoryTitel = true;
	private boolean autoSortByID = false;
	private int[] sortOrder;
	GuiLayoutPanelType[] sortingOrder = new GuiLayoutPanelType[] { GuiLayoutPanelType.singlebutton ,GuiLayoutPanelType.heat, GuiLayoutPanelType.simpleHeat, GuiLayoutPanelType.simpleTankInput, GuiLayoutPanelType.tankInput, GuiLayoutPanelType.slotsInput, GuiLayoutPanelType.image, GuiLayoutPanelType.worker, GuiLayoutPanelType.slotsOutput, GuiLayoutPanelType.tankOutput, GuiLayoutPanelType.simpleTankOutput };

	public GuiLayout() {
		this(true);
	}

	public GuiLayout(boolean drawPlayerInventory) {
		layoutPanels = new ArrayList<GuiLayoutPanel>();
		if (drawPlayerInventory)
			addLayoutPanel(GuiLayoutPanelType.slotsInventory);
		slotIndex = 0;
	}

	public GuiLayoutPanel addLayoutPanel(GuiLayoutPanelType type, int... location) {
		GuiLayoutPanel panel = null;
		int x = 0;
		int y = 0;
		int offsetX = 0;
		int offsetY = 0;
		boolean fixed = false;
		if (location.length == 2) {
			fixed = true;
		}
		for (int i = 0; i < layoutPanels.size(); i++) {
			if (layoutPanels.get(i).type == type) {
				offsetX += 2 + layoutPanels.get(i).getWidth();
				offsetY += 2 + layoutPanels.get(i).getHeight();
			}
		}

		switch (type) {
		case slotsInput:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 47 + offsetX;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52, fixed);
			// SlotLayout set by Block
			// GuiContainerLayout set in above function
			layoutPanels.add(panel);
			break;
		case slotsOutput:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 135 + offsetX;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 52, 52, fixed);
			// SlotLayout set by Block
			// GuiContainerLayout set in above function
			layoutPanels.add(panel);
			break;
		case slotsSide:
			break;
		case tankInput:
		case tankOutput:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 0;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 40, 52, fixed);
			panel.setSlotLayout(SlotLayoutType.fixed, 2);
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case simpleTankInput:
		case simpleTankOutput:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 0;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 18, 52, fixed);
			panel.setGuiContainerLayout(type);
			// no draw required
			layoutPanels.add(panel);
			break;
		case slotsInventory:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8;
				y = 116;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 222, 76, fixed);
			panel.setSlotLayout(SlotLayoutType.inventory, 0);
			// no draw required
			layoutPanels.add(panel);
			break;
		case worker:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 106;
				y = 59 + offsetY;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 24, 16, fixed);
			// No slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case power:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 150;
				y = 9 + offsetY;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 74, 18, fixed);
			panel.setSlotLayout(SlotLayoutType.fixed, 1);
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case heat:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 0;
				y = 39 + offsetY;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 35, 54, fixed, 15, 54);
			panel.setSlotLayout(SlotLayoutType.fixed, 2);
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case simpleHeat:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8;
				y = 39 + offsetY;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 15, 54, fixed);
			// no slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case lifespan:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8;
				y = 16 + offsetY;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 50, 8, fixed);
			// no slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case image:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8 + offsetX;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 1, 1, fixed);
			// no slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case singlebutton:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8 + offsetX;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 1, 1, fixed);
			// no slotLayout
			panel.setGuiContainerLayout(type);
			layoutPanels.add(panel);
			break;
		case spinnerButton:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8 + offsetX;
				y = 40;
			}
	
			panel = new GuiLayoutPanel(this, type, x, y, 18, 58, true);
			
			//button1
			this.addLayoutPanel(GuiLayoutPanelType.singlebutton,x,y).setButtonSize(18, 20).setButtonStateNames("Count up").setButtonIcons(new Rectangle(36,224,11,7)).setButtonIconsCentered().setButtonLayoutTexture();
			//button2
			this.addLayoutPanel(GuiLayoutPanelType.singlebutton,x,y+38).setButtonSize(18, 20).setButtonStateNames("Count down").setButtonIcons(new Rectangle(36,231,11,7)).setButtonIconsCentered().setButtonLayoutTexture();
			//dataview
			this.addLayoutPanel(GuiLayoutPanelType.dataview,x,y+20);
			
			layoutPanels.add(panel);
			break;
		case dataview:
			if (location.length == 2) {
				x = location[0];
				y = location[1];
			} else {
				x = 8 + offsetX;
				y = 40;
			}
			panel = new GuiLayoutPanel(this, type, x, y, 18, 18, fixed);
			// no slotLayout
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

	public Iterator<Slot> getSlotsInventory(IInventory iinventory, Entity player) {
		ArrayList<Slot> slots = new ArrayList<Slot>();
		Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
		while (it.hasNext()) {
			GuiLayoutPanel container = it.next();
			if (container.getSlotLayout() != null && (container.getSlotLayout() instanceof SlotLayoutInventory)) {
				Slot[] containerSlots = container.getSlotLayout().getGuiContainerSlots(iinventory, player);
				for (int i = 0; i < containerSlots.length; i++)
					slots.add(containerSlots[i]);
			}
		}
		return slots.iterator();
	}

	public void reDoLayout() {
		int widthScreen = 236;
		ArrayList<Rectangle> fixedPanelAreas = getFixedPanelAreas();
		for (int j = 0; j < multipleLines; j++) {
			ArrayList<GuiLayoutPanel> panels = getOrganizedPanels(j + 1);
			int widthPanels = 0;
			int previousIntersect = 0;
			int previousIntersectLocation = 0;
			for (int i = 0; i < panels.size(); i++) {
				widthPanels += panels.get(i).getWidth();
			}
			int margin = (widthScreen - widthPanels) / (panels.size() + 1);
			int totalWidth = 0;
			if (useMargin) {
				totalWidth = margin;
				for (int i = 0; i < panels.size(); i++) {
					panels.get(i).setX(totalWidth);
					totalWidth += panels.get(i).getWidth() + margin;
					if (multipleLines > 1) {
						panels.get(i).setY(j * 56 + 5);
					}
					Rectangle intersect = panelOverlapsFixedPanel(fixedPanelAreas, panels.get(i).getRect());
					if (intersect != null) {
						int newI = 0;
						ArrayList<GuiLayoutPanel> subSetPanels = new ArrayList<GuiLayoutPanel>();
						int newWidth = 0;
						for (int z = previousIntersect; margin > minMargin && z < panels.size(); z++) {
							margin = (int) (intersect.getX() - newWidth) / (z + 2);
							if (margin > minMargin) {
								subSetPanels.add(panels.get(z));
								newWidth += panels.get(z).getWidth();
								i = z;
							}

						}
						redoPartialLayout(subSetPanels, previousIntersectLocation, (int) intersect.getX());
						previousIntersectLocation = (int) (intersect.getX() + intersect.getWidth());
						newWidth = 0;
						for (int z = i + 1; z < panels.size(); z++) {
							newWidth += panels.get(z).getWidth();
						}
						margin = (int) (widthScreen - previousIntersectLocation - newWidth) / (panels.size() - i);
						if (i == 0)
							margin = (int) (widthScreen - previousIntersectLocation - newWidth) / (panels.size() + 2);
						totalWidth = (int) (intersect.getX() + intersect.getWidth() + margin);
						previousIntersect = i;
						if (i == 0)
							i--;
					}
				}
			} else {
				totalWidth = (widthScreen - totalWidth) / 2;
				for (int i = 0; i < panels.size(); i++) {
					panels.get(i).setX(totalWidth);
					totalWidth += panels.get(i).getWidth() + 2;
					if (multipleLines > 1) {
						panels.get(i).setY(j * 56 + 5);
					}
				}

			}
		}
	}

	private void redoPartialLayout(ArrayList<GuiLayoutPanel> subSetPanels, int x0, int x1) {
		int widthPanels = 0;
		int widthScreen = x1 - x0;
		for (int i = 0; i < subSetPanels.size(); i++) {
			widthPanels += subSetPanels.get(i).getWidth();
		}
		int margin = (widthScreen - widthPanels) / (subSetPanels.size() + 1);
		int totalWidth = 0;
		if (useMargin) {
			totalWidth = x0 + margin;
			for (int i = 0; i < subSetPanels.size(); i++) {
				subSetPanels.get(i).setX(totalWidth);
				totalWidth += subSetPanels.get(i).getWidth() + margin;
			}
		} else {
			totalWidth = x0 + (widthScreen - totalWidth) / 2;
			for (int i = 0; i < subSetPanels.size(); i++) {
				subSetPanels.get(i).setX(totalWidth);
				totalWidth += subSetPanels.get(i).getWidth() + 2;
			}
		}
	}

	private Rectangle panelOverlapsFixedPanel(ArrayList<Rectangle> fixedPanelAreas, Rectangle rect) {
		Iterator<Rectangle> it = fixedPanelAreas.iterator();
		while (it.hasNext()) {
			Rectangle fixedPanel = it.next();
			if (fixedPanel.intersects(rect))
				return fixedPanel;
		}
		return null;
	}

	private ArrayList<Rectangle> getFixedPanelAreas() {
		ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
		Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
		while (it.hasNext()) {
			GuiLayoutPanel panel = it.next();
			if (panel.isFixed()) {
				rect.add(panel.getRect());
			}
		}
		return rect;
	}

	public void setSortingOrder(GuiLayoutPanelType... types) {
		sortingOrder = new GuiLayoutPanelType[types.length];
		for (int i = 0; i < types.length; i++) {
			sortingOrder[i] = types[i];
		}
	}

	/*
	 * Sets the autolayout to draw the panels in an order by their id (added
	 * pannel number) the ID starts from 1 if the players inventory is bound!!!
	 */
	public void setSortingOrderByPanelID(int... ids) {
		autoSortByID = true;
		sortOrder = ids;
	}

	private ArrayList<GuiLayoutPanel> getOrganizedPanels(int line) {
		ArrayList<GuiLayoutPanel> panels = new ArrayList<GuiLayoutPanel>();
		if (autoSortByID) {
			for (int i = 0; i < sortOrder.length; i++) {
				if (sortOrder[i] < this.layoutPanels.size()) {
					GuiLayoutPanel panel = layoutPanels.get(sortOrder[i]);
					if (panel.line == line && !panel.isFixed()) {
						panels.add(panel);
					}
				}
			}
		} else {
			for (GuiLayoutPanelType type : sortingOrder) {
				Iterator<GuiLayoutPanel> it = layoutPanels.iterator();
				while (it.hasNext()) {
					GuiLayoutPanel panel = it.next();
					if (panel.type == type && panel.line == line && !panel.isFixed()) {
						panels.add(panel);
					}
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
				if (isSameTypeClass(type, panelType)) {

				} else {
					typeIndex = 0;
					type = panelType;
				}
			}

			panel.draw(gui, container, typeIndex, offsetX, offsetY, mouseX, mouseY);

			typeIndex++;
		}
	}
	
	public void drawForeGround(Gui gui, Container container, int offsetX, int offsetY, int mouseX, int mouseY) {
		int typeIndex = 0;
		GuiLayoutPanelType type = null;
		for (int i = 0; i < layoutPanels.size(); i++) {
			GuiLayoutPanel panel = layoutPanels.get(i);
			GuiLayoutPanelType panelType = panel.type;
			if (type == null)
				type = panel.type;

			if (type != panelType) {
				if (isSameTypeClass(type, panelType)) {

				} else {
					typeIndex = 0;
					type = panelType;
				}
			}

			panel.drawForeGround(gui, container, typeIndex, offsetX, offsetY, mouseX, mouseY);

			typeIndex++;
		}
	}

	private boolean isSameTypeClass(GuiLayoutPanelType type, GuiLayoutPanelType panelType) {
		GuiLayoutPanelTypeClass typeClass1 = getTypeClass(type);
		GuiLayoutPanelTypeClass typeClass2 = getTypeClass(panelType);
		return typeClass1 == typeClass2;
	}

	private GuiLayoutPanelTypeClass getTypeClass(GuiLayoutPanelType type) {
		switch (type) {
		case heat:
			return GuiLayoutPanelTypeClass.heat;
		case lifespan:
			return GuiLayoutPanelTypeClass.live;
		case power:
			return GuiLayoutPanelTypeClass.power;
		case simpleHeat:
			return GuiLayoutPanelTypeClass.heat;
		case simpleTankInput:
			return GuiLayoutPanelTypeClass.tank;
		case simpleTankOutput:
			return GuiLayoutPanelTypeClass.tank;
		case slotsInput:
			return GuiLayoutPanelTypeClass.slots;
		case slotsInventory:
			return GuiLayoutPanelTypeClass.slots;
		case slotsOutput:
			return GuiLayoutPanelTypeClass.slots;
		case slotsSide:
			return GuiLayoutPanelTypeClass.slots;
		case tankInput:
			return GuiLayoutPanelTypeClass.tank;
		case tankOutput:
			return GuiLayoutPanelTypeClass.tank;
		case worker:
			return GuiLayoutPanelTypeClass.worker;
		case image:
			return GuiLayoutPanelTypeClass.image;
		case singlebutton:
			return GuiLayoutPanelTypeClass.button;
		default:
			return GuiLayoutPanelTypeClass.other;
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

				if (isSameTypeClass(type, panelType)) {

				} else {
					typeIndex = 0;
					type = panelType;
				}
			}
			container.addHandlerToContainer(panelType, typeIndex);

			typeIndex++;
		}
	}

	public void drawFilledPanels(Rectangle rectangle, Gui gui, int mouseX, int mouseY, Recipe recipe, Block craftingBlock) {
		ArrayList<GuiLayoutPanel> panels = getOrganizedPanels(1);

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

				if ((type.isTankInput() && panelType.isTankOutput()) || (type.isTankOutput() && panelType.isTankInput())) {
				} else {
					typeIndex = 0;
					type = panelType;
				}
			}

			if (panel.getHeight() > ymax)
				ymax = panel.getHeight();
			if (panel.getWidthReduced() + x > rectangle.x + rectangle.width) {
				x = rectangle.x + offset;
				y = y += ymax + offset;
				ymax = 0;
			}
			panel.drawFilledPanel(gui, typeIndex, x, y, recipe, mouseX, mouseY, craftingBlock);
			x += panel.getWidthReduced() + offset;

			typeIndex++;
		}
	}

	public void guiButtonTriggered(int id) {
		
	}

	public ArrayList<GuiButton> getGuiButtons(int offsetX,int offsetY) {
		ArrayList<GuiButton> buttons = new ArrayList<GuiButton>();
		for (int i = 0; i < layoutPanels.size(); i++) {
			GuiLayoutPanel panel = layoutPanels.get(i);
			if(getTypeClass(panel.type) == GuiLayoutPanelTypeClass.button){
				buttons.addAll(panel.getGuiButtons(offsetX,offsetY));
			}
		}
		for(int i = 0;i<buttons.size();i++){
			buttons.get(i).id = i;
		}
		return buttons;
	}
}
