package mod.industrialProcessing.gui.framework.controls;

import net.minecraft.client.gui.FontRenderer;

import org.lwjgl.opengl.GL11;

public class ToolTip {
	private String[] lines;

	public ToolTip(String... lines) {
		this.lines = lines;
	} 
	public static void renderToolTip(ToolTip tip, int x, int y, float z, FontRenderer fontRenderer) { 
		int lineHeight = 8;
		int padding = 4;
		int length = 0;
		int height = -padding;
		z += 300f;
		y -= height + padding;
		if (tip.lines != null && tip.lines.length > 0) {
			for (int i = 0; i < tip.lines.length; i++) {
				length = Math.max(length, fontRenderer.getStringWidth(tip.lines[i]));
				height += lineHeight + padding;
			}

			int var14 = height;

			int var15 = -267386864;
			GuiTools.drawGradientRect(x - 3, y - 4, x + length + 3, y - 3, var15, var15, z);
			GuiTools.drawGradientRect(x - 3, y + var14 + 3, x + length + 3, y + var14 + 4, var15, var15, z);
			GuiTools.drawGradientRect(x - 3, y - 3, x + length + 3, y + var14 + 3, var15, var15, z);
			GuiTools.drawGradientRect(x - 4, y - 3, x - 3, y + var14 + 3, var15, var15, z);
			GuiTools.drawGradientRect(x + length + 3, y - 3, x + length + 4, y + var14 + 3, var15, var15, z);
			int var16 = 1347420415;
			int var17 = (var16 & 16711422) >> 1 | var16 & -16777216;
			GuiTools.drawGradientRect(x - 3, y - 3 + 1, x - 3 + 1, y + var14 + 3 - 1, var16, var17, z);
			GuiTools.drawGradientRect(x + length + 2, y - 3 + 1, x + length + 3, y + var14 + 3 - 1, var16, var17, z);
			GuiTools.drawGradientRect(x - 3, y - 3, x + length + 3, y - 3 + 1, var16, var16, z);
			GuiTools.drawGradientRect(x - 3, y + var14 + 2, x + length + 3, y + var14 + 3, var17, var17, z);

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			for (int i = 0; i < tip.lines.length; i++) {
				String line = tip.lines[i];
				fontRenderer.drawStringWithShadow(line, x, y + i * (lineHeight + padding), 16777215);
			} 
		}
	}
}
