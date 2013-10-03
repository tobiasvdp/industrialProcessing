package ip.industrialProcessing.items;

import java.awt.Point;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
 
public abstract class GuidePage extends Gui {
    private FontRenderer fontRenderer;
    private Minecraft mc;

    public GuidePage() {
	this.mc = Minecraft.getMinecraft();
	this.fontRenderer = mc.fontRenderer;
    }

    public abstract Point getIconLocation();

    public abstract String getTitle();

    public abstract void drawScreen(int i, int j);

    public void mouseClicked(double d, double e, int par3) {
    }
}
