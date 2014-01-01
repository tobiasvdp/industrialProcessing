package ip.industrialProcessing.items.guide.gui;

import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;

import java.awt.Rectangle;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public abstract class GuideMachineRecipeDetails extends Gui {

    private static int hoverColor = 0xffFF0000;
    private static int activeColor = 0xff00FF00;
    private static int idleColor = 0xff0000FF;
    protected Minecraft mc;

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

    protected void drawStack(int x, int y, ItemStack stack) {
	GL11.glEnable(GL11.GL_LIGHTING);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	RenderHelper.enableGUIStandardItemLighting();
	GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glDisable(GL11.GL_LIGHTING);
	RenderHelper.disableStandardItemLighting();
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
