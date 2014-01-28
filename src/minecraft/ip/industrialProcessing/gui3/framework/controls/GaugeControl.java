package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

import org.lwjgl.opengl.GL11;

public class GaugeControl extends Control implements IProgressBinding {

    public static final TextureReference DEFAULT_TEXTURE = new TextureReference(new Size(54, 54), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Gauge.png");
    public static final Rect DEFAULT_SECTION_GAUGE = new Rect(0, 0, 1, 2 / 3f);
    public static final Rect DEFAULT_SECTION_NEEDLE = new Rect(0, 2 / 3f, 1, 1 / 3f);
    private TextureReference texture;
    private Rect gauge;
    private Rect needle;
    private float value = 0.5f;
    private float maxValue = 1;

    public GaugeControl(TextureReference texture, Rect gaugeSection, Rect needleSection) {
	this.texture = texture;
	this.gauge = gaugeSection;
	this.needle = needleSection;
	this.width = 54;
	this.height = 32;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) { 
	size.height += 4;
	renderer.drawTexture(size, gauge, texture);

	float centerX = size.x + size.width / 2;
	float centerY = size.y + size.height * 3 / 2;

	float progress = (value) / (maxValue);
	if (progress < 0)
	    progress = 0;
	if (progress > 1)
	    progress = 1;

	float minAngle = 25;
	float angle = minAngle - progress * 50;
	GL11.glPushMatrix();
	GL11.glTranslatef(centerX, centerY, 0);
	GL11.glRotatef(270 - angle, 0, 0, 1);
	float w = texture.size.width * needle.width;
	float h = texture.size.height * needle.height;
	renderer.drawTexture(new Rect(0, -h / 2, w, h), needle, texture);
	GL11.glPopMatrix();
    }

    public static GaugeControl createGauge() {
	return new GaugeControl(DEFAULT_TEXTURE, DEFAULT_SECTION_GAUGE, DEFAULT_SECTION_NEEDLE);
    }

    @Override
    public void setValue(float value) {
	this.value = value;
    }

    @Override
    public float getValue() { 
	return this.value;
    }

    @Override
    public void setMaxValue(float value) {
	this.maxValue = value;
    }

    @Override
    public float getMaxValue() { 
	return this.maxValue;
    }

}
