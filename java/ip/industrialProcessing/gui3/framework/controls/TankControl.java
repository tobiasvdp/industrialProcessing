package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.binding.ITankBinding;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class TankControl extends Control implements ITankBinding {

    private TextureReference texture;
    private int capacity;
    private int fluidAmount;
    private int fluidID;
    private Rect backgroundRegion;
    private Rect overlayRegion;
    private Thickness backgroundMargins;

    public static TankControl createTank() {
	return new TankControl(new TextureReference(new Size(36, 52), INamepace.TEXTURE_DOMAIN, "textures/gui/Tank.png"), new Rect(0, 0, 0.5f, 1), new Rect(0.5f, 0, 0.5f, 1), new Thickness(1, 1, 1, 1));
    }

    public TankControl(TextureReference texture, Rect backgroundRegion, Rect overlayRegion, Thickness backgroundMargins) {
	this.backgroundRegion = backgroundRegion;
	this.overlayRegion = overlayRegion;
	this.texture = texture;
	this.width = 18;
	this.height = 54;
	this.backgroundMargins = backgroundMargins;
	this.capacity = 10000;
	this.fluidAmount = 5000;
	this.fluidID = FluidRegistry.LAVA.getID();
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

	float progress = (float) fluidAmount / capacity;
	if (fluidID >= 0) {
	    progress = Math.max(0, Math.min(progress, 1));
	    Fluid fluid = FluidRegistry.getFluid(this.fluidID);
	    if (fluid != null) {
		Icon icon = fluid.getIcon();

		Rect fluidRegion = new Rect(icon);

		float fullHeight = (size.height - backgroundMargins.top - backgroundMargins.bottom);
		float progressHeight = fullHeight * progress;
		float offsetTop = fullHeight - progressHeight;

		Rect rectXY = new Rect(size.x + backgroundMargins.left, backgroundMargins.top + size.y + offsetTop, size.width - backgroundMargins.left - backgroundMargins.right, progressHeight);
		for (float y = 0; y < rectXY.height; y += rectXY.width) {

		    if (y + rectXY.width > rectXY.height) {

			float height = rectXY.height - y;
			Rect tile = new Rect(rectXY.x, rectXY.y + y, rectXY.width, height);
			float stretch = height / rectXY.width;
			renderer.drawTexture(tile, new Rect(fluidRegion.x, fluidRegion.y, fluidRegion.width, fluidRegion.height * stretch), TextureMap.locationBlocksTexture);

		    } else {
			Rect tile = new Rect(rectXY.x, rectXY.y + y, rectXY.width, rectXY.width);
			renderer.drawTexture(tile, fluidRegion, TextureMap.locationBlocksTexture);
		    }
		}
	    }
	}
	renderer.drawNineGrid(size, backgroundMargins, overlayRegion, texture);
    }

    @Override
    public void setCapacity(int capacity) {
	this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
	return capacity;
    }

    @Override
    public int getFluidAmount() {
	return fluidAmount;
    }

    @Override
    public void setFluidAmount(int amount) {
	this.fluidAmount = amount;
    }

    @Override
    public int getFluidID() {
	return this.fluidID;
    }

    @Override
    public void setFluidID(int fluidId) {
	this.fluidID = fluidId;
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (this.fluidID >= 0) {
	    Fluid fluid = FluidRegistry.getFluid(this.fluidID);
	    if (fluid != null) {
		return new ToolTip(fluid.getLocalizedName(), String.format("§7%s/%smB", this.fluidAmount, this.capacity));
	    } else
		return new ToolTip("NullPointerException: fluid");
	} else {
	    return new ToolTip("IP.Tank.Tooltip.Empty");
	}
    }
}
