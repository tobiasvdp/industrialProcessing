package ip.industrialProcessing.gui3.framework.controls;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public class TextBlock extends Control {

    private String text;
    private int color;

    public TextBlock(String text, float width, float height, int color) {
	this.text = text;
	this.width = width;
	this.height = height;
	this.color = color;
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	FontRenderer renderer = Minecraft.getMinecraft().fontRenderer;
	float width = renderer.getStringWidth(text);
	if (width > maxSize.width) {
	    return new Size(width, renderer.splitStringWidth(text, (int) width));
	} else {
	    return new Size(width, renderer.FONT_HEIGHT);
	}
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	renderer.drawString(size, this.text, this.color, true, true);
    }

}
