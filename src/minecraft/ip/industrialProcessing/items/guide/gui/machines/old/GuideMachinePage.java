package ip.industrialProcessing.items.guide.gui.machines.old;

import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.items.guide.gui.GuiGuide;
import ip.industrialProcessing.items.guide.gui.GuidePanoramaPage;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.registry.BlockRegistry;
import ip.industrialProcessing.utils.registry.RecipeRegistry;

import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuideMachinePage extends GuidePanoramaPage {

    private Block[] machines = BlockRegistry.getMachinesArray();
    private Block hover;
    private GuideMachineDetailsFrame selectedMachine;

    public GuideMachinePage() {
	super(new Rectangle(0, 0, 72, 178), new Point(5, 18));
	Arrays.sort(machines, new Comparator<Block>() {
	    public int compare(Block o1, Block o2) {
		return o1.getLocalizedName().compareTo(o2.getLocalizedName());
	    }
	});
	this.allowHorizontalDrag = false;
	this.allowVerticalDrag = true;
	this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/GuideDropShadowOverlayNarrow.png");
    }

    @Override
    public Point getIconLocation() {
	return null;
    }

    @Override
    public String getTitle() {
	return "Crafting";
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {
	super.drawScreen(mouseX, mouseY, x, y);

	
	
	if (this.selectedMachine != null) {
	    GL11.glPushMatrix();
	    GL11.glTranslatef(x+72, y+24, 0);
	    this.selectedMachine.drawFrame(mouseX-x-72, mouseY-y-24);
	    GL11.glPopMatrix();
	}
	if (this.hover != null) {
	    ToolTip tip = new ToolTip(this.hover.getLocalizedName());
	    ToolTip.renderToolTip(tip, mouseX + 16, mouseY, 10, mc.fontRenderer);
	}
    }

    private void drawMachine(int mouseX, int mouseY, Block block, int x, int y, boolean allowHover, boolean drawBackground) {
	ItemStack stack = new ItemStack(block);
	GL11.glEnable(GL11.GL_LIGHTING);
	GL11.glEnable(GL11.GL_DEPTH_TEST);

	if (drawBackground) {
	    RenderHelper.disableStandardItemLighting();
	    GL11.glPushMatrix();
	    GL11.glTranslatef(0, 0, 1);
	    drawRect(x, y, x + 16, y + 16, FILL_COLOR);
	    GL11.glTranslatef(1, 1, -1);
	    drawRect(x, y, x + 16, y + 16, SHADOW_COLOR);
	    GL11.glPopMatrix();
	}
	RenderHelper.enableGUIStandardItemLighting();
	GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);

	Rectangle rect = new Rectangle(x, y, 16, 16);
	if (rect.contains(mouseX, mouseY) && allowHover) {
	    this.hover = block;
	}
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glDisable(GL11.GL_LIGHTING);
	RenderHelper.disableStandardItemLighting();
    }

    @Override
    public ItemStack getIconStack() {
	return new ItemStack(Block.workbench);
    }

    @Override
    public void mouseClicked(int d, int e, int par3) {
	super.mouseClicked(d, e, par3);

	if (this.hover != null) {
	    this.selectedMachine = new GuideMachineDetailsFrame(this.hover);
	}
    }

    @Override
    protected void drawPane(int mouseX, int mouseY, boolean mouseInside) {
	this.hover = null;
	int marginX = 8;
	int marginY = 8;
	for (int i = 0; i < machines.length; i++) {
	    int dx = i % 2 * 24;
	    int dy = i / 2 * 24;
	    drawMachine(mouseX, mouseY, machines[i], marginX + dx, marginY + dy, mouseInside, true);
	}
    }

}
