package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import net.minecraftforge.fluids.FluidTankInfo;

public class TankControl extends Control {

    private TextureReference texture;
    public FluidTankInfo tank = new FluidTankInfo(null, 10000);
    private Rect backgroundRegion;
    private Rect overlayRegion;
    private Thickness backgroundMargins;

    public static TankControl createTank() {
	return new TankControl(new TextureReference(new Size(36, 52), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Tank.png"), new Rect(0, 0, 0.5f, 1), new Rect(0.5f, 0, 0.5f, 1), new Thickness(1, 1, 1, 1));
    }

    public TankControl(TextureReference texture, Rect backgroundRegion, Rect overlayRegion, Thickness backgroundMargins) {
	this.backgroundRegion = backgroundRegion;
	this.overlayRegion = overlayRegion;
	this.texture = texture;
	this.width = 18;
	this.height = 54;
	this.backgroundMargins = backgroundMargins;
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
	renderer.drawNineGrid(size, backgroundMargins, backgroundRegion, texture);
	renderer.drawNineGrid(size, backgroundMargins, overlayRegion, texture);
    }

}
