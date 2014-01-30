package ip.industrialProcessing.gui3.framework.controls;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class SlotItemControl extends Control {

    private static final TextureReference DEFAULT_SLOT_TEXTURE = new TextureReference(new Size(72, 18), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Slots.png");;
    private static final Rect DEFAULT_SLOT_SECTION = new Rect(0, 0, 0.25f, 1);
    private ItemStack item;
    private Rect section;
    private TextureReference texture;

    public static SlotItemControl createSlot(ItemStack stack) {
	return new SlotItemControl(stack, DEFAULT_SLOT_TEXTURE, DEFAULT_SLOT_SECTION);
    }

    public static SlotItemControl createItemstack(ItemStack stack) {
	return new SlotItemControl(stack, null, null);
    }

    public SlotItemControl(ItemStack item, TextureReference texture, Rect section) {
	this.texture = texture;
	this.section = section;
	this.item = item;
	this.width = 18;
	this.height = 18;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (section != null && texture != null)
	    renderer.drawTexture(size, section, texture.resource);
	renderer.drawItemStack(size, this.item);
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (item != null) {
	    List lines = item.getTooltip(null, false);
	    if (lines != null) {
		String[] data = new String[lines.size()];
		for (int i = 0; i < lines.size(); i++) {
		    data[i] = (String) lines.get(i);
		}
		return new ToolTip(data);
	    }
	}
	return null;
    }
}
