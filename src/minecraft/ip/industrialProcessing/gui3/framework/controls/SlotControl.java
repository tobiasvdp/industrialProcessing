package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class SlotControl extends Control {
    // new TextureReference(new Size(24, 32), INamepace.TEXTURE_DOMAIN,
    // "textures/gui/Worker.png");
    private static final TextureReference DEFAULT_SLOT_TEXTURE = new TextureReference(new Size(72, 18), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Slots.png");;
    private static final Rect DEFAULT_SLOT_SECTION = new Rect(0, 0, 0.25f, 1);
    private static final Rect DEFAULT_SLOT_SECTION_POWER = new Rect(0.25f, 0, 0.25f, 1);
    private static final Rect DEFAULT_SLOT_SECTION_BUCKET = new Rect(0.5f, 0, 0.25f, 1);
    private static final Rect DEFAULT_SLOT_SECTION_FUEL = new Rect(0.75f, 0, 0.25f, 1);
    private TextureReference texture;
    private Rect section;

    public SlotControl(TextureReference texture, Rect rect) {
	this.width = 18;
	this.height = 18;
	this.texture = texture;
	this.section = rect;
	this.horizontalAlign = Alignment.MIN;
	this.verticalAlign = Alignment.MIN;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	renderer.drawRectangle(size, 0xFFFFFF00);
	renderer.drawRectangle(new Rect(1, 1, size.width - 2, size.height - 2), 0xFFFF0000);

	renderer.drawTexture(size, section, texture);
    }

    public static SlotControl createSlot() {
	return new SlotControl(DEFAULT_SLOT_TEXTURE, DEFAULT_SLOT_SECTION);
    }
    public static SlotControl createPowerSlot() {
	return new SlotControl(DEFAULT_SLOT_TEXTURE, DEFAULT_SLOT_SECTION_POWER);
    }
    public static SlotControl createBucketSlot() {
	return new SlotControl(DEFAULT_SLOT_TEXTURE, DEFAULT_SLOT_SECTION_BUCKET);
    }
    public static SlotControl createFuelSlot() {
	return new SlotControl(DEFAULT_SLOT_TEXTURE, DEFAULT_SLOT_SECTION_FUEL);
    }

}
