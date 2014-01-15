package ip.industrialProcessing.items.guide.gui.machines.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.items.guide.gui.machines.GuideMachinePage;
import ip.industrialProcessing.items.guide.gui.machines.old.GuideMachineRecipeDetails;
import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
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

	public void renderTabContents(Gui gui, int x, int y, int mouseX, int mouseY) {
		this.hover = null;
		if (recipe instanceof ShapedRecipes) {
			ShapedRecipes shaped = (ShapedRecipes) recipe;

			mc.renderEngine.func_110577_a(this.craftingGridTexture);
			drawTexturedRectangle(x - 1, y - 1, 120, 54);
			for (int i = 0; i < shaped.recipeItems.length; i++) {
				ItemStack stack = shaped.recipeItems[i];
				if (stack != null) {
					if (drawTooltipStack(x + 18 * (i % 3), y + 18 * (i / 3), stack, mouseX, mouseY)) {
						((GuideMachinePage) gui).hoverToolTipStack = stack;
					}
				}
			}
			ItemStack stack = shaped.getRecipeOutput();
			if (drawTooltipStack(x + 102 , y + 18 , stack, mouseX, mouseY)) {
				((GuideMachinePage) gui).hoverToolTipStack = stack;
			}
			
		}
		if (recipe instanceof ShapelessRecipes) {
			ShapelessRecipes shaped = (ShapelessRecipes) recipe;
			
			mc.renderEngine.func_110577_a(this.craftingGridTexture);
			drawTexturedRectangle(x - 1, y - 1, 120, 54);
			for (int i = 0; i < shaped.recipeItems.size(); i++) {
				ItemStack stack = (ItemStack) shaped.recipeItems.get(i);
				if (stack != null) {
					if (drawTooltipStack(x + 18 * (i % 3), y + 18 * (i / 3), stack, mouseX, mouseY)) {
						((GuideMachinePage) gui).hoverToolTipStack = stack;
					}
				}
			}
			ItemStack stack = shaped.getRecipeOutput();
			if (drawTooltipStack(x + 102 , y + 18 , stack, mouseX, mouseY)) {
				((GuideMachinePage) gui).hoverToolTipStack = stack;
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

	@Override
	public void renderTabContents(int x, int y, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}
}
