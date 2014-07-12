package mod.industrialProcessing.gui.guide;

import mod.industrialProcessing.gui.framework.UIRoot;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuideScreen extends GuiScreen {

    private GuideRoot guideRoot;
    private UIRoot uiRoot;

    public GuideScreen(EntityPlayer player) {
	this.guideRoot = new GuideRoot();
	this.uiRoot = new UIRoot(guideRoot);
    }

    @Override
    protected void mouseMovedOrUp(int par1, int par2, int par3) {
	super.mouseMovedOrUp(par1, par2, par3);
	if (par3 >= 0) {
	    MouseButton button = MouseButton.getButton(par3);
	    if (button != null) {
		this.uiRoot.mouseUp(0, 0, par1, par2, button);
	    }
	} else
	    this.uiRoot.mouseMoved(0, 0, par1, par2);
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {

	super.mouseClicked(par1, par2, par3);
	MouseButton button = MouseButton.getButton(par3);
	if (button != null) {
	    this.uiRoot.mouseDown(0, 0, par1, par2, button);
	}
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
	this.uiRoot.render(this.width, this.height, 0, 0, par1, par2);
	this.uiRoot.renderForeground(0, 0, par1, par2);
    }
}
