package ip.industrialProcessing.gui3.framework.rendering;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiRenderer {

    private Minecraft mc;
    private Tessellator tessellator;
    public int offsetX;
    public int offsetY;
    private static RenderItem itemRenderer = new RenderItem();

    public GuiRenderer() {
        this.mc = Minecraft.getMinecraft();
        this.tessellator = Tessellator.instance;
    }

    public void drawItemStack(Rect where, ItemStack stack) {
        int x = (int) (where.x + (where.width - 16) / 2);
        int y = (int) (where.y + (where.height - 16) / 2);

        TextureManager textureManager = mc.getTextureManager();

        FontRenderer font = null;
        if (stack != null) {
            Item it = stack.getItem();
            if (it != null) {
                font = it.getFontRenderer(stack);
            }
        }

        // GL11.glDisable(32826 /* GL_RESCALE_NORMAL_EXT */);
        // GL11.glDisable(2903 /* GL_COLOR_MATERIAL */);
        GL11.glEnable(GL11.GL_NORMALIZE);
        RenderHelper.enableGUIStandardItemLighting();
        if (font == null)
            font = mc.fontRenderer;
        if (stack.getItem() != null)
            itemRenderer.renderItemAndEffectIntoGUI(font, textureManager, stack, x, y);
        if (stack.stackSize != 1)
            itemRenderer.renderItemOverlayIntoGUI(font, textureManager, stack, x, y, stack.stackSize + "");
        RenderHelper.disableStandardItemLighting();

    }

    public void drawNineGrid(Rect where, Thickness thickness, Rect section, TextureReference texture) {

        float pixelWidth = 1 / texture.size.width;
        float pixelHeight = 1 / texture.size.height;

        float cornerUmin = pixelWidth * thickness.left;
        float cornerUmax = pixelWidth * thickness.right;
        float cornerVmin = pixelHeight * thickness.top;
        float cornerVmax = pixelHeight * thickness.bottom;

        float[] u = new float[4];
        float[] v = new float[4];
        float[] x = new float[4];
        float[] y = new float[4];

        u[0] = section.x;
        u[1] = section.x + cornerUmin;
        u[2] = section.x + section.width - cornerUmax;
        u[3] = section.x + section.width;

        v[0] = section.y;
        v[1] = section.y + cornerVmin;
        v[2] = section.y + section.height - cornerVmax;
        v[3] = section.y + section.height;

        x[0] = where.x;
        x[1] = where.x + thickness.left;
        x[2] = where.x + where.width - thickness.right;
        x[3] = where.x + where.width;

        y[0] = where.y;
        y[1] = where.y + thickness.top;
        y[2] = where.y + where.height - thickness.bottom;
        y[3] = where.y + where.height;

        mc.renderEngine.bindTexture(texture.resource);
        tessellator.startDrawingQuads();
        int minI = thickness.left == 0 ? 1 : 0;
        int maxI = thickness.right == 0 ? 2 : 3;
        int minJ = thickness.top == 0 ? 1 : 0;
        int maxJ = thickness.bottom == 0 ? 2 : 3;
        for (int i = minI; i < maxI; i++) {
            for (int j = minJ; j < maxJ; j++) {
                tessellator.addVertexWithUV(x[i], y[j + 1], 0, u[i], v[j + 1]);
                tessellator.addVertexWithUV(x[i + 1], y[j + 1], 0, u[i + 1], v[j + 1]);
                tessellator.addVertexWithUV(x[i + 1], y[j], 0, u[i + 1], v[j]);
                tessellator.addVertexWithUV(x[i], y[j], 0, u[i], v[j]);
            }
        }
        tessellator.draw();
    }

    public void drawTexture(Rect where, Rect segment, ResourceLocation texture) {

        float u0 = segment.x;
        float u1 = segment.x + segment.width;
        float v0 = segment.y;
        float v1 = segment.y + segment.height;

        float x0 = where.x;
        float x1 = where.x + where.width;
        float y0 = where.y;
        float y1 = where.y + where.height;

        mc.renderEngine.bindTexture(texture);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x0, y1, 0, u0, v1);
        tessellator.addVertexWithUV(x1, y1, 0, u1, v1);
        tessellator.addVertexWithUV(x1, y0, 0, u1, v0);
        tessellator.addVertexWithUV(x0, y0, 0, u0, v0);
        tessellator.draw();
    }

    public void drawString(Rect rect, String text, int color, boolean ellipsis, boolean wrap, boolean hasShadow) {
        String ellipsisChars = "...";
        int elipsisWidth = mc.fontRenderer.getStringWidth(ellipsisChars);
        int lastMargin = ellipsis ? elipsisWidth : 0;
        int width = (int) rect.width;
        int height = (int) rect.height;
        if (width < elipsisWidth)
            return;
        if (lastMargin >= width) {
            lastMargin = 0;
            ellipsis = false;
        }
        if (wrap) {
            if (mc.fontRenderer.getStringWidth(text) > width) {
                List parts = mc.fontRenderer.listFormattedStringToWidth(text, width);

                int maxStrings = height / mc.fontRenderer.FONT_HEIGHT;

                for (int i = 0; i < Math.min(parts.size(), maxStrings); i++) {
                    String line = (String) parts.get(i);
                    if (i == maxStrings - 1 && ellipsis && mc.fontRenderer.getStringWidth(line) > width) {
                        line = mc.fontRenderer.trimStringToWidth(line, width - lastMargin) + ellipsisChars;
                    }
                    mc.fontRenderer.drawString(line, (int) rect.x, (int) rect.y + mc.fontRenderer.FONT_HEIGHT * i, color, hasShadow);
                }

            } else
                mc.fontRenderer.drawString(text, (int) rect.x, (int) rect.y, color, hasShadow);
        } else {
            if (mc.fontRenderer.getStringWidth(text) > rect.width) {
                text = mc.fontRenderer.trimStringToWidth(text, (int) rect.width - lastMargin) + ellipsisChars;
            }
            mc.fontRenderer.drawString(text, (int) rect.x, (int) rect.y, color, hasShadow);
        }
        GL11.glColor4f(1, 1, 1, 1);
    }

    public void drawRectangle(Rect where, int i) {

        float x0 = where.x;
        float x1 = where.x + where.width;
        float y0 = where.y;
        float y1 = where.y + where.height;

        float a = ((i >> 24) & 0xff) / 255f;
        float r = ((i >> 16) & 0xff) / 255f;
        float g = ((i >> 8) & 0xff) / 255f;
        float b = ((i) & 0xff) / 255f;

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(r, g, b, a);
        tessellator.startDrawingQuads();
        tessellator.addVertex(x0, y1, 0);
        tessellator.addVertex(x1, y1, 0);
        tessellator.addVertex(x1, y0, 0);
        tessellator.addVertex(x0, y0, 0);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1, 1, 1, 1);
    }

    public void drawToolTip(ToolTip tooltip, int x, int y) {
        ToolTip.renderToolTip(tooltip, x, y, 0, this.mc.fontRenderer);
    }

    public void enableScissor(Rect absoluteBounds) {
        ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);

        float sSW = absoluteBounds.width;
        float sSH = absoluteBounds.height;
        float sSL = absoluteBounds.x + offsetX;
        float sST = absoluteBounds.y + offsetY;

        float sL = sSL * mc.displayWidth / res.getScaledWidth();
        float sT = mc.displayHeight - sST * mc.displayHeight / res.getScaledHeight();
        float sW = sSW * mc.displayWidth / res.getScaledWidth();
        float sH = sSH * mc.displayHeight / res.getScaledHeight();
        int x = (int) Math.floor(sL);
        int y = (int) Math.floor(sT);
        int w = (int) Math.ceil(sW);
        int h = (int) Math.ceil(sH);

        GL11.glScissor(x, y - h, w, h);
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
    }

    public void disableScissor() {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }

    public void drawModel(Rect size, ItemStack stack) {

        float scaleW = size.width / 16;
        float scaleH = size.height / 16;
        float scale = Math.min(scaleW, scaleH);
        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, 1);
        drawItemStack(new Rect(size.x / scale, size.y / scale, 16, 16), stack);
        GL11.glPopMatrix();
    }

    public void drawLine(Size p1, Size p2, float f, int i) {

        f = 0.5f;
        float rx = p2.width - p1.width;
        float ry = p2.height - p1.height;

        float l = (float) Math.sqrt(rx * rx + ry * ry);

        rx *= f / l;
        ry *= f / l;

        float x1l = p1.width - ry;
        float x1r = p1.width + ry;
        float x2l = p2.width - ry;
        float x2r = p2.width + ry;

        float y1l = p1.height + rx;
        float y1r = p1.height - rx;
        float y2l = p2.height + rx;
        float y2r = p2.height - rx;

        float a = ((i >> 24) & 0xff) / 255f;
        float r = ((i >> 16) & 0xff) / 255f;
        float g = ((i >> 8) & 0xff) / 255f;
        float b = ((i) & 0xff) / 255f;

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(r, g, b, a);
        tessellator.startDrawingQuads();
        tessellator.addVertex(x1l, y1l, 0);
        tessellator.addVertex(x2l, y2l, 0);
        tessellator.addVertex(x2r, y2r, 0);
        tessellator.addVertex(x1r, y1r, 0);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1, 1, 1, 1);
    }

}
