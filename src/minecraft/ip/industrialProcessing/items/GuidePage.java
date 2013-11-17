package ip.industrialProcessing.items;

import java.awt.Point;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;

public abstract class GuidePage extends Gui {
    protected FontRenderer fontRenderer;
    protected Minecraft mc;

    public GuidePage() {
	this.mc = Minecraft.getMinecraft();
	this.fontRenderer = mc.fontRenderer;
    }

    public abstract Point getIconLocation();

    public abstract String getTitle();

    public abstract void drawScreen(int mouseX, int mouseY, int x, int y);

    public void mouseClicked(int d, int e, int par3) {
    }

    public abstract ItemStack getIconStack();

    public void mouseUp(int x, int y, int par3) { 
    }
}
