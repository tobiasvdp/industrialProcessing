package ip.industrialProcessing.items.guide.gui;

import java.awt.Rectangle;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class GuideMachineIPRecipeDetails extends GuideMachineRecipeDetails {

    private Block block;
    private Recipe recipe;

    public GuideMachineIPRecipeDetails(Block block, Recipe recipe) {
	this.block = block;
	this.recipe = recipe;
    }

    @Override
    public void renderTabHeader(int i, int j, int mouseX, int mouseY, boolean active) {
	super.renderTabHeader(i, j, mouseX, mouseY, active);
	drawBlock(i + 1, j + 1, block);
    }

    @Override
    public void renderTabContents(int x, int y, int mouseX, int mouseY) {

	int px = 0;
	int py = 48;
	for (int i = 0; i < this.recipe.inputs.length; i++) {
	    RecipeInputSlot input = this.recipe.inputs[i];
	    if (input.type != RecipeSlotType.TANK) {
		drawStack(px, py, new ItemStack(input.itemId, input.metadata, 1));
		px += 18;
	    }
	}
	px += 24;
	for (int i = 0; i < this.recipe.outputs.length; i++) {
	    RecipeOutputSlot input = this.recipe.outputs[i];
	    if (input.type != RecipeSlotType.TANK) {
		drawStack(px, py, new ItemStack(input.itemId, input.metadata, input.maxAmount));
		px += 18;
	    }
	}
    }
}
