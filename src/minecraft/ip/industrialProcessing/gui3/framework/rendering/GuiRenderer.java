package ip.industrialProcessing.gui3.framework.rendering;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;

public class GuiRenderer {

    private Minecraft mc;
    private Tessellator tessellator;

    public GuiRenderer() {
	this.mc = Minecraft.getMinecraft();
	this.tessellator = Tessellator.instance;
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

	mc.renderEngine.func_110577_a(texture.resource);
	tessellator.startDrawingQuads();
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		tessellator.addVertexWithUV(x[i], y[j + 1], 0, u[i], v[j + 1]);
		tessellator.addVertexWithUV(x[i + 1], y[j + 1], 0, u[i + 1], v[j + 1]);
		tessellator.addVertexWithUV(x[i + 1], y[j], 0, u[i + 1], v[j]);
		tessellator.addVertexWithUV(x[i], y[j], 0, u[i], v[j]);
	    }
	}
	tessellator.draw();
    }

    public void drawTexture(Rect where, Rect segment, TextureReference texture) {

	float u0 = segment.x;
	float u1 = segment.x + segment.width;
	float v0 = segment.y;
	float v1 = segment.y + segment.height;

	float x0 = where.x;
	float x1 = where.x + where.width;
	float y0 = where.y;
	float y1 = where.y + where.height;

	mc.renderEngine.func_110577_a(texture.resource);
	tessellator.startDrawingQuads();
	tessellator.addVertexWithUV(x0, y1, 0, u0, v1);
	tessellator.addVertexWithUV(x1, y1, 0, u1, v1);
	tessellator.addVertexWithUV(x1, y0, 0, u1, v0);
	tessellator.addVertexWithUV(x0, y0, 0, u0, v0);
	tessellator.draw();
    }

    public void drawString(Rect rect, String text, int color, boolean ellipsis, boolean wrap) {
	String ellipsisChars = "...";
	int lastMargin = ellipsis ? mc.fontRenderer.getStringWidth(ellipsisChars) : 0;
	int width = (int) rect.width;
	int height = (int) rect.height;
	if (lastMargin >= width) {
	    lastMargin = 0;
	    ellipsis = false;
	}
	if (wrap) {
	    if (mc.fontRenderer.getStringWidth(text) > width) {
		List parts = mc.fontRenderer.listFormattedStringToWidth(text, width);

		int maxStrings = height / mc.fontRenderer.FONT_HEIGHT;

		for (int i = 0; i < maxStrings; i++) {
		    String line = (String) parts.get(i);
		    if (i == maxStrings - 1 && ellipsis) {
			line = mc.fontRenderer.trimStringToWidth(line, width - lastMargin) + ellipsisChars;
		    }
		    mc.fontRenderer.drawString(text, (int) rect.x + mc.fontRenderer.FONT_HEIGHT * i, (int) rect.y, color);
		}

	    } else
		mc.fontRenderer.drawString(text, (int) rect.x, (int) rect.y, color);
	} else {
	    if (mc.fontRenderer.getStringWidth(text) > rect.width) {
		text = mc.fontRenderer.trimStringToWidth(text, (int) rect.width - lastMargin) + ellipsisChars;
	    }
	    mc.fontRenderer.drawString(text, (int) rect.x, (int) rect.y, color);
	}
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

}
