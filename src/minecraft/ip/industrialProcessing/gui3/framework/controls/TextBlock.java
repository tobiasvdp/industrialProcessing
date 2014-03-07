package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.utils.Language;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class TextBlock extends Control {

    private String text;
    public int color;
    public boolean allowEllipsis = true;
    public boolean allowWrap = true;
    public boolean hasShadow = false;
    private Size textSize;

    public void setUnlocalizedText(String text) {
        this.text = Language.getLocalizedString(text);
    }

    public String getLocalizedText() {
        return text;
    }

    public TextBlock(String text, int color) {
        this.text = Language.getLocalizedString(text);
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.color = color;
    }

    @Override
    protected Size measureOverride(Size maxSize) {
        Size size = new Size(0, 0);
        FontRenderer renderer = Minecraft.getMinecraft().fontRenderer;
        if (maxSize.width < renderer.getStringWidth("...")) {
            size = new Size(0, 0);
        } else {
            float width = renderer.getStringWidth(text);
            if (width > maxSize.width) {
                size = new Size(maxSize.width, renderer.splitStringWidth(text, (int) maxSize.width));
            } else {
                size = new Size(width, renderer.FONT_HEIGHT);
            }
        }
        Size minSize = super.measureOverride(maxSize);

        return this.textSize = new Size(Math.max(minSize.width, size.width), Math.max(minSize.height, size.height));
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {

        Size size = measureOverride(maxSize);
        return size;
        // return super.arrangeOverride(this.textSize);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
        renderer.drawString(size, this.text, this.color, allowEllipsis, true, hasShadow);
    }

    public static TextBlock createTextBlock() {
        return new TextBlock("", 0xFFFFFFFF);
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
        return null;
    }

    public static TextBlock createText(String text) {
        return new TextBlock(text, 4210752);
    }

    public static TextBlock createText(String text, int color) {
        return new TextBlock(text, color);
    }

    public void setText(String text) {
        this.text = text;
    }
}
