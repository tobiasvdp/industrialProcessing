package ip.industrialProcessing.items.guide.gui.machines.old;

import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.items.guide.gui.GuiGuide;
import ip.industrialProcessing.multiblock.recipes.IRecipeMultiblock;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.registry.RecipeRegistry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import org.lwjgl.opengl.GL11;

public class GuideMachineDetailsFrame extends Gui {

	private Block machineBlock;
	private Minecraft mc;
	private ArrayList<GuideMachineRecipeDetails> recipeDetails = new ArrayList<GuideMachineRecipeDetails>();
	private GuideMachineRecipeDetails activeTab;

	public GuideMachineDetailsFrame(Block hover) {
		this.machineBlock = hover;
		this.mc = Minecraft.getMinecraft();

		ArrayList<Recipe> recipes = RecipeRegistry.FindRecipeForOutput(new ItemStack(this.machineBlock));
		for (int i = 0; i < recipes.size(); i++) {
			Recipe recipe = recipes.get(i);
			Block block = RecipeRegistry.getBlockForRecipe(recipe);
			this.recipeDetails.add(new GuideMachineIPRecipeDetails(block, recipe));
		}

		List list = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < list.size(); i++) {
			Object listItem = list.get(i);
			if (listItem instanceof IRecipe) {
				IRecipe recipe = (IRecipe) listItem;
				ItemStack output = recipe.getRecipeOutput();
				if (output != null && output.itemID == this.machineBlock.blockID) {
					this.recipeDetails.add(new GuideMachineCraftingRecipeDetails(recipe));
				}
			}

		}

		if (!this.recipeDetails.isEmpty())
			this.activeTab = this.recipeDetails.get(0);
	}

	public void drawFrame(int mouseX, int mouseY) {

		drawMachine(this.machineBlock, 0, 0);
		RenderHelper.disableStandardItemLighting();
		mc.fontRenderer.drawString(this.machineBlock.getLocalizedName(), 16 + 4, 4, 0x00404040);
		for (int i = 0; i < recipeDetails.size(); i++) {
			GuideMachineRecipeDetails detailTab = this.recipeDetails.get(i);
			detailTab.renderTabHeader(18 * i, 20, mouseX, mouseY, this.activeTab == detailTab);
		}
		if (this.activeTab != null)
			this.activeTab.renderTabContents(0, 48, mouseX, mouseY);
	}

	private void drawMachine(Block block, int x, int y) {
		ItemStack stack = new ItemStack(block);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		RenderHelper.enableGUIStandardItemLighting();
		GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		RenderHelper.disableStandardItemLighting();
	}
}
