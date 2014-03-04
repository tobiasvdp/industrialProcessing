package ip.industrialProcessing.gui3.containers;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.UIRoot;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

import org.lwjgl.opengl.GL11;

public class GuiLayoutContainer extends GuiContainer {

    private UIRoot layout;
    private ArrayList<Binder> binders = new ArrayList<Binder>();

    public void addBinding(Binder binding) {
        binders.add(binding);
    }

    public GuiLayoutContainer(LayoutContainer container, UIElement root) {
        super(container);
        this.layout = new UIRoot(root);
        this.ySize = 300;
        this.xSize = 400;
    }
    
    @Override
    public void drawScreen(int par1, int par2, float par3) {
        List list = this.inventorySlots.inventorySlots;
         for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Slot slot = (Slot) iterator.next();
            slot.xDisplayPosition = this.width;
            slot.yDisplayPosition = this.height;
        }
        super.drawScreen(par1, par2, par3);
    }

    @Override
    protected void mouseMovedOrUp(int par1, int par2, int par3) {
        super.mouseMovedOrUp(par1, par2, par3);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        if (par3 >= 0) {
            MouseButton button = MouseButton.getButton(par3);
            if (button != null) {
                this.layout.mouseUp(x, y, par1, par2, button);
            }
        } else
            this.layout.mouseMoved(x, y, par1, par2);
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {

        super.mouseClicked(par1, par2, par3);
        MouseButton button = MouseButton.getButton(par3);
        if (button != null) {
            int x = (width - xSize) / 2;
            int y = (height - ySize) / 2;
            this.layout.mouseDown(x, y, par1, par2, button);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        for (Binder binder : this.binders) {
            binder.updateBinding();
        }
        this.layout.render(xSize, ySize, x, y, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.layout.renderForeground(x, y, mouseX, mouseY);
    }
}
