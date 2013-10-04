package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.ForgeDirection;

public abstract class GuidePanoramaPage extends GuidePage {

    private Rectangle rectangle;
    private int offsetX;
    private int offsetY;
    private Point location;
    private ResourceLocation textureLocation;
    private Random rnd = new Random(15665);
    private boolean drag;
    private int lastDragX;
    private int lastDragY;
    private boolean last;

    public GuidePanoramaPage(Rectangle rectangle, Point location) {
	this.rectangle = rectangle;
	this.location = location;
	this.textureLocation = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/GuideDropShadowOverlay.png");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {
	if (drag) {
	    if (last) {
		int dx = mouseX - lastDragX;
		int dy = mouseY - lastDragY;
		offsetX -= dx;
		offsetY -= dy;
	    }
	    lastDragX = mouseX;
	    lastDragY = mouseY;
	    last = true;
	}

	Minecraft mc = Minecraft.getMinecraft();
	ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	GL11.glScissor(scaleWidth(location.x + x + 1, res), scaleHeight(240 - (location.y + y - 1 + rectangle.height), res), scaleWidth(rectangle.width - 2, res), scaleHeight(rectangle.height - location.y + y + 2, res));
	this.zLevel = 0;
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glEnable(GL11.GL_SCISSOR_TEST);
	drawBackground(x, y);
	drawPane(mouseX - x - offsetX, mouseY - y - offsetY);
	mc.renderEngine.func_110577_a(this.textureLocation);
	GL11.glDisable(GL11.GL_ALPHA_TEST);
	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	this.zLevel = 10;
	GL11.glEnable(GL11.GL_BLEND);
	GL11.glDisable(GL11.GL_SCISSOR_TEST);
	drawTexturedModalRect(location.x + x, location.y + y + 10, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
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

    private void drawBackground(int x, int y) {
	y += rectangle.y + 30;
	x += rectangle.x + 10;
	rnd = new Random(150);
	Minecraft mc = Minecraft.getMinecraft();
	mc.renderEngine.func_110577_a(TextureMap.field_110575_b);
	Icon[] icons = new Icon[] { Block.dirt.getIcon(0, 0), Block.grass.getIcon(ForgeDirection.NORTH.ordinal(), 0), Block.stone.getIcon(0, 0), Block.oreCoal.getIcon(0, 0), Block.oreDiamond.getIcon(0, 0), Block.oreRedstone.getIcon(0, 0), Block.oreGold.getIcon(0, 0), Block.oreIron.getIcon(0, 0), Block.oreLapis.getIcon(0, 0) };
	int block = 2;
	int blockSize = 16;
	int blocksWidth = rectangle.width / blockSize + 1;
	int blocksHeight = rectangle.height / blockSize + 1;
	int blockOffsetX = offsetX / blockSize;
	int blockOffsetY = Math.max(0, offsetY / blockSize);
	for (int blockX = blockOffsetX; blockX < blocksWidth + blockOffsetX + 1; blockX++) {
	    for (int blockY = blockOffsetY; blockY < blocksHeight + blockOffsetY + 1; blockY++) {
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
	return i * res.getScaleFactor();
    }

    private int scaleHeight(int i, ScaledResolution res) {
	Minecraft mc = Minecraft.getMinecraft();
	return i * res.getScaleFactor();
    }

    protected abstract void drawPane(int mouseX, int mouseY);

}
