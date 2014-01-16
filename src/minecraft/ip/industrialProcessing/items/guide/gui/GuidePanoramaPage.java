package ip.industrialProcessing.items.guide.gui;

import ip.industrialProcessing.config.INamepace;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

public abstract class GuidePanoramaPage extends GuidePage {

	protected Rectangle rectangle;
    protected int offsetX;
    protected int offsetY;
    protected Point location;
    protected ResourceLocation textureLocation;
    protected Random rnd = new Random(15665);
    protected boolean drag;
    protected int lastDragX;
    protected int lastDragY;
    protected boolean last;
    protected boolean allowHorizontalDrag;
    protected boolean allowVerticalDrag;

    public GuidePanoramaPage(Rectangle rectangle, Point location) {
	this.rectangle = rectangle;
	this.location = location;
	this.allowHorizontalDrag = true;
	this.allowVerticalDrag = true;
	this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/GuideDropShadowOverlay.png");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {
	if (drag && this.rectangle.contains(new Point(mouseX-x,mouseY-y))) {
	    if (last) {
		int dx = allowHorizontalDrag ? mouseX - lastDragX : 0;
		int dy = allowVerticalDrag ? mouseY - lastDragY : 0;
		offsetX -= dx;
		offsetY -= dy;
	    }
	    lastDragX = mouseX;
	    lastDragY = mouseY;
	    last = true;
	}

	int scale = 1;

	offsetY = Math.max(0, offsetY);
	offsetX = Math.max(0, offsetX);

	Minecraft mc = Minecraft.getMinecraft();
	ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);

	int sSW = rectangle.width - 8;
	int sSH = rectangle.height - 8;
	int sSL = location.x + x + 4;
	int sST = location.y + y + 4 + sSH;

	int sL = sSL * mc.displayWidth / res.getScaledWidth();
	int sT = mc.displayHeight - sST * mc.displayHeight / res.getScaledHeight();
	int sW = sSW * mc.displayWidth / res.getScaledWidth();
	int sH = sSH * mc.displayHeight / res.getScaledHeight();
	GL11.glScissor(sL, sT, sW, sH);
	this.zLevel = 0;

	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glEnable(GL11.GL_SCISSOR_TEST);
	GL11.glPushMatrix();
	GL11.glScalef(1f / scale, 1f / scale, 1);

	int dx = -offsetX + (x + location.x + 5) * scale;
	int dy = -offsetY + (y + location.y + 5) * scale;

	Rectangle containment = new Rectangle(location.x + 5 + x, location.y + 5 + y, rectangle.width - 10, rectangle.height - 10);
	boolean mouseInside = containment.contains(mouseX, mouseY);

	drawBackground((x + location.x + 5) / scale, (y + location.y + 5) / scale);
	GL11.glTranslatef(dx, dy, 0);
	drawPane(mouseX - dx, mouseY - dy, mouseInside);
	GL11.glPopMatrix();
	mc.renderEngine.func_110577_a(this.textureLocation);
	GL11.glDisable(GL11.GL_ALPHA_TEST);
	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	this.zLevel = 10;
	GL11.glEnable(GL11.GL_BLEND);
	GL11.glDisable(GL11.GL_SCISSOR_TEST);
	drawTexturedModalRect(location.x + x, location.y + y, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	GL11.glDisable(GL11.GL_BLEND);
	GL11.glEnable(GL11.GL_ALPHA_TEST);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	this.zLevel = 0;
    }

    @Override
    public void mouseClicked(int x, int y, int par3) {
	super.mouseClicked(x, y, par3);
	drag = true;
	last = false;
	lastDragX = x;
	lastDragY = y;
    }

    @Override
    public void mouseUp(int x, int y, int par3) {
	super.mouseUp(x, y, par3);
	drag = false;
    }

    public void drawBackground(int x, int y) {
    	drawMinecraftBackground(x,y);
    }

    private void drawMinecraftBackground(int x, int y) {
    	rnd = new Random(150);
    	Minecraft mc = Minecraft.getMinecraft();
    	mc.renderEngine.func_110577_a(TextureMap.field_110575_b);
    	Icon[] icons = new Icon[] { Block.dirt.getIcon(0, 0), Block.grass.getIcon(ForgeDirection.NORTH.ordinal(), 0), Block.stone.getIcon(0, 0), Block.oreCoal.getIcon(0, 0), Block.oreDiamond.getIcon(0, 0), Block.oreRedstone.getIcon(0, 0), Block.oreGold.getIcon(0, 0), Block.oreIron.getIcon(0, 0), Block.oreLapis.getIcon(0, 0) };
    	int block = 2;
    	int blockSize = 16;
    	int blocksWidth = rectangle.width / blockSize + 1;
    	int blocksHeight = rectangle.height / blockSize + 1;

    	int left = offsetX - mc.displayWidth;
    	int top = offsetY - mc.displayHeight;
    	int bottom = offsetY + rectangle.height + mc.displayHeight;
    	int right = offsetX + rectangle.width + mc.displayWidth;

    	int blockOffsetX = left / blockSize - 1;
    	int blockOffsetY = top / blockSize - 1;

    	int blockRight = right / blockSize + 1;
    	int blockBottom = bottom / blockSize + 1;
    	for (int blockX = blockOffsetX; blockX <= blockRight; blockX++) {
    	    for (int blockY = blockOffsetY; blockY < blockBottom; blockY++) {
    		Random rnd = new Random(blockX + 100 * blockY);

    		double gaussian = Math.abs(rnd.nextGaussian());
    		int iconId = 2;
    		if (blockY == 0) {
    		    iconId = 1;
    		} else if (gaussian + 1 > blockY / 2f) {
    		    iconId = 0;
    		} else if (gaussian > 2f) {
    		    iconId = 2 + rnd.nextInt(icons.length - 3);
    		}
    		Icon icon = icons[iconId];

    		drawTexturedModelRectFromIcon(blockX * blockSize - offsetX + x, blockY * blockSize - offsetY + y, icon, blockSize, blockSize);
    	    }
    	}
	}

	private int scaleWidth(int i, ScaledResolution res) {
	Minecraft mc = Minecraft.getMinecraft();
	return i * mc.displayWidth / res.getScaledWidth();
    }

    private int scaleHeight(int i, ScaledResolution res) {
	Minecraft mc = Minecraft.getMinecraft();
	return i * mc.displayHeight / res.getScaledHeight();
    }

    protected abstract void drawPane(int mouseX, int mouseY, boolean mouseInside);

}
