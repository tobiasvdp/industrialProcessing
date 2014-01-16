package ip.industrialProcessing.items.guide.gui.machines.components;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.items.guide.gui.machines.GuideMachinePage;
import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuideMachineFurnaceRecipeDetails extends GuideMachineRecipeDetails {

	private ItemStack input;
	private ItemStack output;
	private ResourceLocation furnaceGridTexture;
	private ItemStack hover;

	public GuideMachineFurnaceRecipeDetails(Integer key, ItemStack value) {
		input = new ItemStack(key, 1, 0);
		output = value;
		this.furnaceGridTexture = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/FurnaceGrid.png");
	}

	@Override
	public void renderTabHeader(int x, int y, int mouseX, int mouseY, boolean active) {
		super.renderTabHeader(x, y, mouseX, mouseY, active);
		drawBlock(x + 1, y + 1, Block.workbench);
	}

	public void renderTabContents(Gui gui, int x, int y, int mouseX, int mouseY) {
		this.hover = null;

		mc.renderEngine.func_110577_a(this.furnaceGridTexture);
		drawTexturedRectangle(x - 1, y - 1, 120, 54);
		if (drawTooltipStack(x + 18, y + 0, input, mouseX, mouseY)) {
			((GuideMachinePage) gui).hoverToolTipStack = input;
		}
		ItemStack coal = new ItemStack(Item.coal);
		if (drawTooltipStack(x + 18, y + 36, coal, mouseX, mouseY)) {
			((GuideMachinePage) gui).hoverToolTipStack = coal;
		}
		if (drawTooltipStack(x + 102, y + 18, output, mouseX, mouseY)) {
			((GuideMachinePage) gui).hoverToolTipStack = output;
		}
		if (this.hover != null) {
			ToolTip tip = new ToolTip(this.hover.getDisplayName());
			ToolTip.renderToolTip(tip, mouseX + 16, mouseY, 10, mc.fontRenderer);
		}
	}

	private void drawTexturedRectangle(int x, int y, int w, int h) {

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x + 0, y + h, this.zLevel, 0, 1);
		tessellator.addVertexWithUV(x + w, y + h, this.zLevel, 1, 1);
		tessellator.addVertexWithUV(x + w, y + 0, this.zLevel, 1, 0);
		tessellator.addVertexWithUV(x + 0, y + 0, this.zLevel, 0, 0);
		tessellator.draw();
	}

	@Override
	public void renderTabContents(int x, int y, int mouseX, int mouseY) {
		// TODO Auto-generated method stub

	}

}
