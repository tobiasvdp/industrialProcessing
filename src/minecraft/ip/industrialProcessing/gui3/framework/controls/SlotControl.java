package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public class SlotControl extends Control {

    public SlotControl() {
	this.width = 18;
	this.height = 18;
	this.horizontalAlign = Alignment.MIN;
	this.verticalAlign = Alignment.MIN;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	renderer.drawRectangle(size, 0xFFFFFF00);
	renderer.drawRectangle(new Rect(1, 1, size.width - 2, size.height - 2), 0xFFFF0000);
    }

}
