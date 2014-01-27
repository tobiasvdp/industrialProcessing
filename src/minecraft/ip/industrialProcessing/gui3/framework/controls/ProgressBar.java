package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

import java.util.Random;

import net.minecraftforge.fluids.FluidTankInfo;

public class ProgressBar extends Control {

    private static final TextureReference DEFAULT_VERTICAL_GENERIC_TEXTURE = new TextureReference(new Size(36, 52), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/ProgressBarVertical.png");
    private static final Rect DEFAULT_VERTICAL_GENERIC_RECT_BACKGROUND = new Rect(0, 0, 0.25f, 1);
    private static final Rect DEFAULT_VERTICAL_GENERIC_RECT_FOREGROUND_1 = new Rect(0.25f, 0, 0.25f, 1);
    private static final Rect DEFAULT_VERTICAL_GENERIC_RECT_FOREGROUND_2 = new Rect(0.5f, 0, 0.25f, 1);
    private static final Rect DEFAULT_VERTICAL_GENERIC_RECT_FOREGROUND_3 = new Rect(0.75f, 0, 0.25f, 1);

    private static final TextureReference DEFAULT_HORIZONTAL_GENERIC_TEXTURE = new TextureReference(new Size(52, 36), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/ProgressBarHorizontal.png");
    private static final Rect DEFAULT_HORIZONTAL_GENERIC_RECT_BACKGROUND = new Rect(0, 0, 1, 0.25f);
    private static final Rect DEFAULT_HORIZONTAL_GENERIC_RECT_FOREGROUND_1 = new Rect(0, 0.25f, 1, 0.25f);
    private static final Rect DEFAULT_HORIZONTAL_GENERIC_RECT_FOREGROUND_2 = new Rect(0, 0.5f, 1, 0.25f);
    private static final Rect DEFAULT_HORIZONTAL_GENERIC_RECT_FOREGROUND_3 = new Rect(0, 0.75f, 1, 0.25f);

    private static final TextureReference DEFAULT_THERMOMETER_TEXTURE = new TextureReference(new Size(30, 54), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Thermometer.png");
    private static final Rect DEFAULT_THERMOMETER_BACKGROUND = new Rect(0, 0, 0.5f, 1);
    private static final Rect DEFAULT_THERMOMETER_FOREGROUND = new Rect(0.5f, 0, 0.5f, 1);
    private static final Thickness DEFAULT_THICKNESS = new Thickness(1, 1, 1, 1);
    private static final Thickness DEFAULT_THERMOMETER_THICKNESS = new Thickness(1, 5, 18, 5);
    private static final Rect DEFAULT_WORKER_VERTICAL_BACKGROUND = new Rect(0, 0, 1f, 0.5f);
    private static final Rect DEFAULT_WORKER_VERTICAL_FOREGROUND = new Rect(0, 0.5f, 1f, 0.5f);
    private static final Thickness DEFAULT_WORKER_THICKNESS = new Thickness(0, 0, 0, 0);

    public static ProgressBar createVertical1() {
	ProgressBar bar = new ProgressBar(DEFAULT_VERTICAL_GENERIC_TEXTURE, DEFAULT_VERTICAL_GENERIC_RECT_BACKGROUND, DEFAULT_VERTICAL_GENERIC_RECT_FOREGROUND_1, Orientation.VERTICAL, DEFAULT_THICKNESS);
	bar.width = 9;
	bar.height = 54;
	return bar;
    }

    public static ProgressBar createVertical2() {
	ProgressBar bar = new ProgressBar(DEFAULT_VERTICAL_GENERIC_TEXTURE, DEFAULT_VERTICAL_GENERIC_RECT_BACKGROUND, DEFAULT_VERTICAL_GENERIC_RECT_FOREGROUND_2, Orientation.VERTICAL, DEFAULT_THICKNESS);
	bar.width = 9;
	bar.height = 54;
	return bar;
    }

    public static ProgressBar createVertical3() {
	ProgressBar bar = new ProgressBar(DEFAULT_VERTICAL_GENERIC_TEXTURE, DEFAULT_VERTICAL_GENERIC_RECT_BACKGROUND, DEFAULT_VERTICAL_GENERIC_RECT_FOREGROUND_3, Orientation.VERTICAL, DEFAULT_THICKNESS);
	bar.width = 9;
	bar.height = 54;
	return bar;
    }

    public static ProgressBar createHorizontal1() {
	ProgressBar bar = new ProgressBar(DEFAULT_HORIZONTAL_GENERIC_TEXTURE, DEFAULT_HORIZONTAL_GENERIC_RECT_BACKGROUND, DEFAULT_HORIZONTAL_GENERIC_RECT_FOREGROUND_1, Orientation.HORIZONTAL, DEFAULT_THICKNESS);
	bar.width = 54;
	bar.height = 9;
	return bar;
    }

    public static ProgressBar createHorizontal2() {
	ProgressBar bar = new ProgressBar(DEFAULT_HORIZONTAL_GENERIC_TEXTURE, DEFAULT_HORIZONTAL_GENERIC_RECT_BACKGROUND, DEFAULT_HORIZONTAL_GENERIC_RECT_FOREGROUND_2, Orientation.HORIZONTAL, DEFAULT_THICKNESS);
	bar.width = 54;
	bar.height = 9;
	return bar;
    }

    public static ProgressBar createHorizontal3() {
	ProgressBar bar = new ProgressBar(DEFAULT_HORIZONTAL_GENERIC_TEXTURE, DEFAULT_HORIZONTAL_GENERIC_RECT_BACKGROUND, DEFAULT_HORIZONTAL_GENERIC_RECT_FOREGROUND_3, Orientation.HORIZONTAL, DEFAULT_THICKNESS);
	bar.width = 54;
	bar.height = 9;
	return bar;
    }

    public static ProgressBar createTemperature() {
	ProgressBar bar = new ProgressBar(DEFAULT_THERMOMETER_TEXTURE, DEFAULT_THERMOMETER_BACKGROUND, DEFAULT_THERMOMETER_FOREGROUND, Orientation.VERTICAL, DEFAULT_THERMOMETER_THICKNESS);
	bar.width = 15;
	bar.height = 54;
	bar.tooltip = "%.2f/%.2f°C";
	return bar;
    }

    public static ProgressBar createWork(TextureReference texture) {
	ProgressBar bar = new ProgressBar(texture, DEFAULT_WORKER_VERTICAL_BACKGROUND, DEFAULT_WORKER_VERTICAL_FOREGROUND, Orientation.VERTICAL, DEFAULT_WORKER_THICKNESS);
	bar.width = 15;
	bar.height = 54;
	bar.tooltip = "%.2f/%.2f";
	return bar;
    }

    private TextureReference texture;
    public FluidTankInfo tank = new FluidTankInfo(null, 10000);
    private Rect backgroundRegion;
    private Rect overlayRegion;
    private Orientation orientation = Orientation.HORIZONTAL;
    private Thickness backgroundThickness;
    public float value = 0;
    public float maxValue = 1;
    public String tooltip = "%.2f/%.2f";

    public ProgressBar(TextureReference texture, Rect backgroundRegion, Rect overlayRegion, Orientation orientation, Thickness backgroundThickness) {
	this.backgroundRegion = backgroundRegion;
	this.overlayRegion = overlayRegion;
	this.texture = texture;
	this.orientation = orientation;
	this.backgroundThickness = backgroundThickness;
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	Size size = super.measureOverride(maxSize);
	return size;
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	Size size = super.arrangeOverride(maxSize);
	return size;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	renderer.drawNineGrid(size, this.backgroundThickness, backgroundRegion, texture);
	float progress = this.value / this.maxValue;

	progress = Math.max(0, Math.min(progress, 1));
	float uPixel = 1 / texture.size.width;
	float vPixel = 1 / texture.size.height;
	Rect rectXY;
	Rect rectUV;
	switch (orientation) {
	case HORIZONTAL:
	    float progressWidth = (size.width - backgroundThickness.left - backgroundThickness.right) * progress;
	    float leftU = backgroundThickness.left * uPixel;
	    float rightU = backgroundThickness.right * uPixel;
	    float uWidth = (this.overlayRegion.width - leftU - rightU) * progress;

	    rectXY = new Rect(backgroundThickness.left + size.x, size.y, progressWidth, size.height);
	    rectUV = new Rect(leftU + this.overlayRegion.x, this.overlayRegion.y, uWidth, this.overlayRegion.height);

	    break;
	default:
	    float fullHeight = (size.height - backgroundThickness.top - backgroundThickness.bottom);
	    float progressHeight = fullHeight * progress;

	    float offsetTop = fullHeight - progressHeight;
	    float topV = backgroundThickness.top * vPixel;
	    float bottomV = backgroundThickness.bottom * vPixel;
	    float fullVHeight = (this.overlayRegion.height - topV - bottomV);
	    float vHeight = fullVHeight * progress;
	    float offsetVTop = fullVHeight - vHeight;

	    rectXY = new Rect(size.x, backgroundThickness.top + size.y + offsetTop, size.width, progressHeight);
	    rectUV = new Rect(this.overlayRegion.x, this.overlayRegion.y + topV + offsetVTop, this.overlayRegion.width, vHeight);

	    break;
	}

	renderer.drawTexture(rectXY, rectUV, texture);
    }

}
