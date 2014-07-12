package mod.industrialProcessing.gui.framework.controls;

import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;
import net.minecraft.item.ItemStack;

public class BlockModelControl extends Control {
	public ItemStack model;

	public BlockModelControl(ItemStack model) {
		this.model = model;
	}

	@Override
	protected void renderOverride(Rect size, GuiRenderer renderer) { 
		renderer.drawRectangle(size, 0xff000000);
		if (model != null)
			renderer.drawModel(size, model);
	}

	@Override
	protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
		return null;
	}

}
