package ip.industrialProcessing.gui.guiContainer.layout.components;

import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.guiContainer.layout.GuiContainerLayout;
import ip.industrialProcessing.recipes.Recipe;
import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;

public class GuiContainerLayoutSlot extends GuiContainerLayout {

	@Override
	public void drawFilled(Gui gui, SlotLayout slotLayout, Recipe recipe, int index, int x, int y, int mouseX, int mouseY,Block craftingBlock) {

		for (int i = 0; i < rect.size(); i++) {
			GuiContainerDrawRectagle rectangle = rect.get(i);
			gui.drawTexturedModalRect(rectangle.destination.x + x, rectangle.destination.y + y, rectangle.origin.x, rectangle.origin.y, rectangle.origin.width, rectangle.origin.height);
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