package ip.industrialProcessing.items.guide.gui;

import java.awt.Point;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;

public abstract class GuidePage extends Gui {
    protected FontRenderer fontRenderer;
    protected Minecraft mc;

    public static final int FILL_COLOR = 0xffc6c6c6;
    public static final int HIGHLIGT_COLOR = 0xffffffff;
    public static final int SHADOW_COLOR = 0x88000000;
    
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
