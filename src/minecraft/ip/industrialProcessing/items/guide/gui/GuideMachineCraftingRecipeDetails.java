package ip.industrialProcessing.items.guide.gui;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.ResourceLocation;

public class GuideMachineCraftingRecipeDetails extends GuideMachineRecipeDetails {

    private IRecipe recipe;
    private ResourceLocation craftingGridTexture;
    private ItemStack hover;

    public GuideMachineCraftingRecipeDetails(IRecipe recipe) {
	this.recipe = recipe;
	this.craftingGridTexture = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/CraftingGrid.png");
    }

    @Override
    public void renderTabHeader(int x, int y, int mouseX, int mouseY, boolean active) {
	super.renderTabHeader(x, y, mouseX, mouseY, active);
	drawBlock(x + 1, y + 1, Block.workbench);
    }

    @Override
    public void renderTabContents(int x, int y, int mouseX, int mouseY) {
	this.hover = null;
	if (recipe instanceof ShapedRecipes) {
	    ShapedRecipes shaped = (ShapedRecipes) recipe;

	    mc.renderEngine.func_110577_a(this.craftingGridTexture);
	    drawTexturedRectangle(x - 1, y - 1, 54, 54);
	    for (int i = 0; i < shaped.recipeItems.length; i++) {
		ItemStack stack = shaped.recipeItems[i];
		if (stack != null) {
		    if (drawTooltipStack(x + 18 * (i / 3), y + 18 * (i % 3), stack, mouseX, mouseY)) {
			this.hover = stack;
		    }
		}
	    }
	}
	if (this.hover != null) { 
	    ToolTip tip = new ToolTip(this.hover.getDisplayName());
	    ToolTip.renderToolTip(tip, mouseX + 16, mouseY, 10, mc.fontRenderer);
	}
    }

    private void drawTexturedRectangle(int x, int y, int w, int h) {

	Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	tessellator.addVertexWithUV((double) (x + 0), (double) (y + h), (double) this.zLevel, 0, 1);
	tessellator.addVertexWithUV((double) (x + w), (double) (y + h), (double) this.zLevel, 1, 1);
	tessellator.addVertexWithUV((double) (x + w), (double) (y + 0), (double) this.zLevel, 1, 0);
	tessellator.addVertexWithUV((double) (x + 0), (double) (y + 0), (double) this.zLevel, 0, 0);
	tessellator.draw();
    }
}
