package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class Image extends Control {

    private TextureReference texture;
    private Rect section;

    public Image(TextureReference texture, Rect section) {
	this.texture = texture;
	this.section = section;
	this.width = texture.size.width * section.width;
	this.height = texture.size.height * section.height;
	this.horizontalAlign = Alignment.CENTER;
	this.verticalAlign = Alignment.CENTER;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) { 
	renderer.drawTexture(size, this.section, this.texture.resource);
    }

    public static Image createImage(TextureReference texture, Rect rect) {
	return new Image(texture, rect);
    }

    public static Image createImage(TextureReference reference) {
	return new Image(reference, new Rect(0, 0, 1, 1));
    }
    
    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) { 
        return null;
    }
}
