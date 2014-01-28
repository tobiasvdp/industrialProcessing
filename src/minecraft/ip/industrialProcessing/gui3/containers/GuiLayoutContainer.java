package ip.industrialProcessing.gui3.containers;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.gui3.framework.UIRoot;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiLayoutContainer extends GuiContainer {

    private UIRoot layout;

    public GuiLayoutContainer(LayoutContainer container, Decorator root) {
	super(container);
	this.layout = new UIRoot(root);
	this.ySize = 300;
	this.xSize = 400;
    }

    @Override
    protected void mouseMovedOrUp(int par1, int par2, int par3) {
	super.mouseMovedOrUp(par1, par2, par3);
	if (par3 >= 0) {
	    MouseButton button = MouseButton.getButton(par3);
	    if (button != null) {
		this.layout.mouseUp(par1, par2, button);
	    }
	} else
	    this.layout.mouseMoved(par1, par2);
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {

	super.mouseClicked(par1, par2, par3);
	MouseButton button = MouseButton.getButton(par3);
	if (button != null) {
	    this.layout.mouseDown(par1, par2, button);
	}
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int mouseX, int mouseY) { 
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
	int x = (width - xSize) / 2;
	int y = (height - ySize) / 2;
	this.layout.render(xSize, ySize, x, y, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) { 
	// TODO: tooltips
    }
}
