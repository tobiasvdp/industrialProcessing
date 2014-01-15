package ip.industrialProcessing.items.guide.gui.machines.components;

import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.items.guide.gui.GuiGuide;

import java.awt.Rectangle;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public abstract class GuideMachineRecipeDetails extends Gui {

    private static int hoverColor = 0xffFF0000;
    private static int activeColor = 0xff00FF00;
    private static int idleColor = 0xff0000FF;
    protected Minecraft mc;
	protected static RenderItem itemRenderer = new RenderItem();

    public GuideMachineRecipeDetails() {

	this.mc = Minecraft.getMinecraft();
    }

    public void renderTabHeader(int x, int y, int mouseX, int mouseY, boolean active) {
	GL11.glPushMatrix();
	GL11.glTranslatef(0, 0, 10);
	Rectangle rect = new Rectangle(x, y, 18, 18);
	if (rect.contains(mouseX, mouseY)) {
	    // hover
	    drawRect(x, y, x + 18, y + 18, hoverColor);
	} else if (active) {
	    // active
	    drawRect(x, y, x + 18, y + 18, activeColor);
	} else {
	    // idle
	    drawRect(x, y, x + 18, y + 18, idleColor);
	}
	GL11.glPopMatrix();

    }

    protected void drawItem(int x, int y, Item item) {
	ItemStack stack = new ItemStack(item);
	drawStack(x, y, stack);

    }

    protected void drawBlock(int x, int y, Block block) {
	ItemStack stack = new ItemStack(block);
	drawStack(x, y, stack);
    } 

	public void drawStack(int x, int y,ItemStack stack) {
		RenderHelper.enableGUIStandardItemLighting();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		if(stack.stackSize == 1)
			drawItemStack(stack, x, y, "");
		else
			drawItemStack(stack, x, y, stack.stackSize + "");
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		RenderHelper.disableStandardItemLighting();
	}
	

    public void drawItemStack(ItemStack par1ItemStack, int par2, int par3, String par4Str)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
		itemRenderer .zLevel = 200.0F;
        FontRenderer font = null;
        if (par1ItemStack != null) font = par1ItemStack.getItem().getFontRenderer(par1ItemStack);
        if (font == null) font = mc.fontRenderer;
        itemRenderer.renderItemAndEffectIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3);
        itemRenderer.renderItemOverlayIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3, par4Str);
        this.zLevel = 0.0F;
        itemRenderer.zLevel = 0.0F;
    }

    protected boolean drawTooltipStack(int x, int y, ItemStack stack, int mouseX, int mouseY) {
	drawStack(x, y, stack);
	Rectangle rect = new Rectangle(x, y, 16, 16);
	if (rect.contains(mouseX, mouseY)) { 
	    return true;
	}
	return false;
    }

    public abstract void renderTabContents(int x, int y, int mouseX, int mouseY);
}
