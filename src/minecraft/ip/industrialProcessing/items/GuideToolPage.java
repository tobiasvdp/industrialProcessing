package ip.industrialProcessing.items;

import ic2.api.item.Items;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.GuiTools;

import java.awt.Point;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class GuideToolPage extends GuidePage {

    @Override
    public Point getIconLocation() {
	return null;
    }

    @Override
    public String getTitle() {
	return "Tools";
    }

    @Override
    public void drawScreen(int mouseX, int mouseY) {
	int i = 0;
	drawItemStack(new ItemStack(IndustrialProcessing.itemWrench), 10, ++i * 26 + 10, "Used to rotate machines");
	drawItemStack(new ItemStack(IndustrialProcessing.itemHexKey), 10, ++i * 26 + 10, "Used to modify machines");
	drawItemStack(new ItemStack(IndustrialProcessing.itemBlowingTorch), 10, ++i * 26 + 10, "Used in the welding table");
	drawItemStack(new ItemStack(IndustrialProcessing.itemHammer), 10, ++i * 26 + 10, "Used to do stuff");
    }

    private void drawItemStack(ItemStack stack, int x, int y, String description) {
	Minecraft mc = Minecraft.getMinecraft();
	GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.func_110434_K());

	GL11.glDisable(GL11.GL_LIGHTING);
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	mc.fontRenderer.drawString(stack.getDisplayName(), x + 24, y + 4, -1);

	mc.fontRenderer.drawString(description, x + 24, y + 16, 4210752);
	GL11.glEnable(GL11.GL_LIGHTING);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    @Override
    public ItemStack getIconStack() {
	return new ItemStack(IndustrialProcessing.itemWrench);
    }

}
