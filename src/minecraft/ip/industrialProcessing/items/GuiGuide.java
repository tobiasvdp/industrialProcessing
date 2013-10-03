package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.ToolTip;

import java.awt.Point;
import java.awt.Rectangle;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiGuide extends GuiScreen {

    private static final int X_SIZE = 256;
    private static final int Y_SIZE = 202;
    private static final Rectangle SOURCE_ACTIVE_TAB = new Rectangle(24, 202, 24, 26);
    private static final Rectangle SOURCE_INACTIVE_TAB = new Rectangle(0, 202, 24, 26);
    private static final GuidePage[] pages = new GuidePage[] { new GuideTreePage(), new GuideTreePage(), new GuideTreePage(), new GuideTreePage(), new GuideTreePage() };
    private static final int TAB_OFFSET = 3;
    private static final int TAB_WIDTH = 24;
    private static final int MARGIN_LEFT = 10;
    private static final int MARGIN_TOP = 10;

    private ResourceLocation textureLocation;
    private EntityPlayer player;

    private GuidePage page;

    public GuiGuide(EntityPlayer player) {
	this.player = player;
	this.textureLocation = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Guide.png");
    }

    @Override
    public void drawDefaultBackground() {
	drawBackground(0);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3) {
	drawDefaultBackground();
	super.drawScreen(mouseX, mouseY, par3);
	mc.renderEngine.func_110577_a(this.textureLocation);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
 
	int x = (width - X_SIZE) / 2;
	int y = (height - Y_SIZE - 23) / 2;
	for (int i = 0; i < pages.length; i++) {
	    Point icon = pages[i].getIconLocation();
	    boolean active = page == pages[i];
	    this.zLevel = active ? 10 : 0;
	    drawTab(SOURCE_INACTIVE_TAB, SOURCE_ACTIVE_TAB, new Point(TAB_OFFSET + i * TAB_WIDTH, 199), active);
	    this.drawTexturedModalRect(x+TAB_OFFSET + i * TAB_WIDTH+4, y+200 + (active ? 4 : 0), icon.x, icon.y, 16, 16);
	    this.zLevel=0;
	}
	
	this.drawTexturedModalRect(x, y, 0, 0, X_SIZE, Y_SIZE);


	int tab = hoverTab(mouseX, mouseY);
	if (tab >= 0) {
	    GuidePage page = pages[tab];
	    String title = page.getTitle();
	    drawHoverText(title, mouseX, mouseY);
	}
	if (this.page != null) {
	    GL11.glDisable(GL11.GL_LIGHTING);
	    GL11.glDisable(GL11.GL_DEPTH_TEST);
	    this.fontRenderer.drawString("IP Guide", x + MARGIN_LEFT, y + MARGIN_TOP, 0xffffff);
	    this.fontRenderer.drawString(this.page.getTitle(), x + MARGIN_LEFT, y + MARGIN_TOP + 10, 4210752);
	    GL11.glPushMatrix();
	    GL11.glTranslatef(x, y, 0);
	    this.page.drawScreen(mouseX - x, mouseY - y);
	    GL11.glPopMatrix();
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glEnable(GL11.GL_DEPTH_TEST);
	}
    }

    @Override
    protected void mouseClicked(int x, int y, int par3) {
	super.mouseClicked(x, y, par3);
	int tab = hoverTab(x, y);
	if (tab >= 0) {
	    this.page = pages[tab];
	    this.mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
	}

	x -= (width - X_SIZE) / 2;
	y -= (height - Y_SIZE - 23) / 2;
	this.page.mouseClicked(x, y, par3);
    }

    private int hoverTab(int x, int y) {
	int x0 = (width - X_SIZE) / 2;
	int y0 = (height - Y_SIZE - 23) / 2;
	int minY = y0 + 202;
	int maxY = minY + 24;
	for (int i = 0; i < pages.length; i++) {

	    int minX = x0 + TAB_OFFSET + TAB_WIDTH * i;
	    int maxX = x0 + TAB_OFFSET + TAB_WIDTH * (i + 1);
	    if (x > minX && x < maxX) {
		if (y > minY && y < maxY) {
		    return i;
		}
	    }
	}
	return -1;
    }

    private void drawHoverText(String text, int x, int y) {
	ToolTip tip = new ToolTip(text);
	ToolTip.renderToolTip(tip, x + 16, y, this.zLevel, fontRenderer);
    }

    @Override
    public void drawBackground(int par1) {
	drawWorldBackground(par1);
    }

    public void drawTab(Rectangle sourceInactive, Rectangle sourceActive, Point location, boolean active) {

	int x = (width - X_SIZE) / 2 + location.x;
	int y = (height - Y_SIZE - 23) / 2 + location.y;

	int sx = active ? sourceActive.x : sourceInactive.x;
	int sy = active ? sourceActive.y : sourceInactive.y;

	int w = active ? sourceActive.width : sourceInactive.width;
	int h = active ? sourceActive.height : sourceInactive.height;

	this.drawTexturedModalRect(x, y, sx, sy, w, h);
    }

}
