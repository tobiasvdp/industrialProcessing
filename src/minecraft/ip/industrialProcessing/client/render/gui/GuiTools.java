package ip.industrialProcessing.client.render.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public class GuiTools {
    public static void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6, float zLevel) {
	float f = (float) (par5 >> 24 & 255) / 255.0F;
	float f1 = (float) (par5 >> 16 & 255) / 255.0F;
	float f2 = (float) (par5 >> 8 & 255) / 255.0F;
	float f3 = (float) (par5 & 255) / 255.0F;
	float f4 = (float) (par6 >> 24 & 255) / 255.0F;
	float f5 = (float) (par6 >> 16 & 255) / 255.0F;
	float f6 = (float) (par6 >> 8 & 255) / 255.0F;
	float f7 = (float) (par6 & 255) / 255.0F;
	GL11.glDisable(GL11.GL_TEXTURE_2D);
	GL11.glEnable(GL11.GL_BLEND);
	GL11.glDisable(GL11.GL_ALPHA_TEST);
	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	GL11.glShadeModel(GL11.GL_SMOOTH);
	Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	tessellator.setColorRGBA_F(f1, f2, f3, f);
	tessellator.addVertex((double) par3, (double) par2, (double) zLevel);
	tessellator.addVertex((double) par1, (double) par2, (double) zLevel);
	tessellator.setColorRGBA_F(f5, f6, f7, f4);
	tessellator.addVertex((double) par1, (double) par4, (double) zLevel);
	tessellator.addVertex((double) par3, (double) par4, (double) zLevel);
	tessellator.draw();
	GL11.glShadeModel(GL11.GL_FLAT);
	GL11.glDisable(GL11.GL_BLEND);
	GL11.glEnable(GL11.GL_ALPHA_TEST);
	GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public static void drawItemStack(ItemStack par1ItemStack, int par2, int par3, String par4Str, RenderItem itemRenderer, FontRenderer fontRenderer, TextureManager textureManager) {
	GL11.glTranslatef(0.0F, 0.0F, 16.0F);
	FontRenderer font = null;
	if (par1ItemStack != null)
	    font = par1ItemStack.getItem().getFontRenderer(par1ItemStack);
	if (font == null)
	    font = fontRenderer;
	itemRenderer.renderItemAndEffectIntoGUI(font, textureManager, par1ItemStack, par2, par3);
	//itemRenderer.renderItemOverlayIntoGUI(font, textureManager, par1ItemStack, par2, par3, par4Str);

    }
}
