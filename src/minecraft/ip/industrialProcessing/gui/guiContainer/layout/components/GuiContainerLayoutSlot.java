package ip.industrialProcessing.gui.guiContainer.layout.components;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import buildcraft.core.gui.slots.SlotBase;
import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.components.GuiLayoutPanel;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.syncing.info.InfoHeat;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.items.guide.gui.machines.GuideMachinePage;
import ip.industrialProcessing.recipes.Recipe;

public class GuiContainerLayoutSlot extends GuiContainerLayout {

	@Override
	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY,Block craftingBlock) {

		for (int i = 0; i < rect.size(); i++) {
			GuiContainerDrawRectagle rectangle = rect.get(i);
			gui.drawTexturedModalRect(rectangle.destination.x + x, rectangle.destination.y + y, rectangle.origin.x, rectangle.origin.y, rectangle.origin.width, rectangle.origin.height);
		}
		if (gui instanceof GuideMachinePage) {
			Slot[] slots = slotLayout.getGuiContainerLayout();
			int i = 0;
			for (Slot slot:slots){
				ItemStack stack = hasIndex(slot.getSlotIndex(),recipe);
				if(stack != null){
					GuiContainerDrawRectagle rectangle = rect.get(i);
					((GuideMachinePage) gui).drawItemstack(stack, rectangle.destination.x + x +1, rectangle.destination.y + y + 1);
					Rectangle target = new Rectangle(rectangle.destination.x + x +1, rectangle.destination.y + y + 1, 16, 16);
					if (target.contains(mouseX, mouseY)) {
						((GuideMachinePage) gui).hoverToolTipStack = stack;
					}
				}
				i++;
			}
					
			((GuideMachinePage) gui).setTextureLayout();
		}
	}
	
	public ItemStack hasIndex(int index, Recipe recipe){
		for(int i =0;i<recipe.inputs.length;i++){
			if(recipe.inputs[i].index == index)
				return new ItemStack(recipe.inputs[i].itemId,recipe.inputs[i].amount,recipe.inputs[i].metadata);
		}
		for(int i =0;i<recipe.outputs.length;i++){
			if(recipe.outputs[i].index == index)
				return new ItemStack(recipe.outputs[i].itemId,recipe.outputs[i].maxAmount,recipe.outputs[i].metadata);
		}
		return null;
	}

}