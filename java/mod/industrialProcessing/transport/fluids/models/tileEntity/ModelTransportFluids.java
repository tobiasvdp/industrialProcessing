package mod.industrialProcessing.transport.fluids.models.tileEntity;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.client.rendering.tileEntity.connected.ModelConnectedFluid;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;

public class ModelTransportFluids extends ModelConnectedFluid {

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {

	}

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, IIcon icon) {
		fluidPercentage *= 0.9f; 
		Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        int lightLevel = tl.blockType.getMixedBrightnessForBlock(tl.getWorldObj(), tl.xCoord, tl.yCoord, tl.zCoord);
        tessellator.setBrightness(lightLevel); 
        tessellator.setColorOpaque(255, 255, 255);  
        GL11.glEnable(GL11.GL_BLEND); 
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		boolean renderCap = (up != ConnectionState.DISCONNECTED) != (down != ConnectionState.DISCONNECTED) || (west != ConnectionState.DISCONNECTED) != (east != ConnectionState.DISCONNECTED) || (south != ConnectionState.DISCONNECTED) != (north != ConnectionState.DISCONNECTED) || (north == south && south == east && east == west && west == up && up == down && down == ConnectionState.DISCONNECTED);
		if (up != ConnectionState.DISCONNECTED && down != ConnectionState.DISCONNECTED)
			renderStraightY(f, icon, fluidPercentage);
		else {
			if (up != ConnectionState.DISCONNECTED)
				renderUp(f, icon, fluidPercentage);
			else if (down != ConnectionState.DISCONNECTED)
				renderDown(f, icon, fluidPercentage);
		}
		if (west != ConnectionState.DISCONNECTED && east != ConnectionState.DISCONNECTED)
			renderStraightX(f, icon, fluidPercentage);
		else {
			if (east != ConnectionState.DISCONNECTED)
				renderEast(f, icon, fluidPercentage);
			else if (west != ConnectionState.DISCONNECTED)
				renderWest(f, icon, fluidPercentage);
		}
		if (north != ConnectionState.DISCONNECTED && south != ConnectionState.DISCONNECTED)
			renderStraightZ(f, icon, fluidPercentage);
		else {
			if (north != ConnectionState.DISCONNECTED)
				renderNorth(f, icon, fluidPercentage);
			else if (south != ConnectionState.DISCONNECTED)
				renderSouth(f, icon, fluidPercentage);
		}

		if (renderCap) {
			renderCap(f, icon, fluidPercentage);
		}
		tessellator.draw();
 
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void renderUp(float f, IIcon icon, float s) {
		drawXPlane(f, -2f * s, 8, -2f * s, 4 * s, 8 - 3f * s, icon);
		drawXPlane(f, 2f * s, 8, 2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, 2f * s, 8, -2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, -2f * s, 8, 2f * s, 4 * s, 8 - 3f * s, icon);

		drawYPlane(f, -2f * s, 8, -2f * s, 4f * s, 4f * s, icon);
		drawYPlane(f, 2f * s, 16f - 3f * s, -2f * s, -4f * s, 4f * s, icon);
	}

	private void renderDown(float f, IIcon icon, float s) {
		drawXPlane(f, -2f * s, 16f + 3f * s, -2f * s, 4 * s, 8 - 3f * s, icon);
		drawXPlane(f, 2f * s, 16f + 3f * s, 2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, 2f * s, 16f + 3f * s, -2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, -2f * s, 16f + 3f * s, 2f * s, 4 * s, 8 - 3f * s, icon);

		drawYPlane(f, -2f * s, 16f + 3f * s, -2f * s, 4f * s, 4f * s, icon);
		drawYPlane(f, 2f * s, 24f, -2f * s, -4f * s, 4f * s, icon);
	}

	private void renderNorth(float f, IIcon icon, float s) {
		drawXPlane(f, -2f * s, 16f - 2f * s, -8f, 8 - 3f * s, 4f * s, icon);
		drawXPlane(f, 2f * s, 16f + 2f * s, -8f, 8 - 3f * s, -4f * s, icon);
		drawYPlane(f, 2f * s, 16f - 2f * s, -3f * s, -4f * s, -8 + 3f * s, icon);
		drawYPlane(f, -2f * s, 16f + 2f * s, -3f * s, 4f * s, -8 + 3f * s, icon);

		drawZPlane(f, 2f * s, 16f - 2f * s, -8f, -4f * s, 4f * s, icon);
		drawZPlane(f, 2f * s, 16f + 2f * s, -3f * s, -4f * s, -4f * s, icon);
	}

	private void renderSouth(float f, IIcon icon, float s) {
		drawXPlane(f, -2f * s, 16f - 2f * s, 3f * s, 8 - 3f * s, 4f * s, icon);
		drawXPlane(f, 2f * s, 16f + 2f * s, 3f * s, 8 - 3f * s, -4f * s, icon);
		drawYPlane(f, 2f * s, 16f - 2f * s, 8f, -4f * s, -8 + 3f * s, icon);
		drawYPlane(f, -2f * s, 16f + 2f * s, 8f, 4f * s, -8 + 3f * s, icon);

		drawZPlane(f, 2f * s, 16f - 2f * s, 3f * s, -4f * s, 4f * s, icon);
		drawZPlane(f, 2f * s, 16f + 2f * s, 8f, -4f * s, -4f * s, icon);
	}

	private void renderEast(float f, IIcon icon, float s) {
		drawYPlane(f, -8, 16f - 2f * s, -2f * s, 8 - 3f * s, 4 * s, icon);
		drawYPlane(f, -8, 16f + 2f * s, 2f * s, 8 - 3f * s, -4 * s, icon);
		drawZPlane(f, -8f, 16f - 2f * s, 2f * s, 8 - 3f * s, 4 * s, icon);
		drawZPlane(f, -8f, 16f + 2f * s, -2f * s, 8 - 3f * s, -4 * s, icon);

		drawXPlane(f, -8f, 16f - 2f * s, -2f * s, 4f * s, 4f * s, icon);
		drawXPlane(f, -3f * s, 16f + 2f * s, -2f * s, 4f * s, -4f * s, icon);
	}

	private void renderWest(float f, IIcon icon, float s) {
		drawYPlane(f, 3f * s, 16f - 2f * s, -2f * s, 8 - 3f * s, 4 * s, icon);
		drawYPlane(f, 3f * s, 16f + 2f * s, 2f * s, 8 - 3f * s, -4 * s, icon);
		drawZPlane(f, 3f * s, 16f - 2f * s, 2f * s, 8 - 3f * s, 4 * s, icon);
		drawZPlane(f, 3f * s, 16f + 2f * s, -2f * s, 8 - 3f * s, -4 * s, icon);

		drawXPlane(f, 3f * s, 16f - 2f * s, -2f * s, 4f * s, 4f * s, icon);
		drawXPlane(f, 8f, 16f + 2f * s, -2f * s, 4f * s, -4f * s, icon);
	}

	private void renderCap(float f, IIcon icon, float s) {
		drawXPlane(f, -3f * s, 16f - 3f * s, -3f * s, 6f * s, 6f * s, icon);
		drawXPlane(f, 3f * s, 16f - 3f * s, 3f * s, -6f * s, 6f * s, icon);
		drawZPlane(f, 3f * s, 16f - 3f * s, -3f * s, -6f * s, 6f * s, icon);
		drawZPlane(f, -3f * s, 16f - 3f * s, 3f * s, 6f * s, 6f * s, icon);

		drawYPlane(f, -3f * s, 16f - 3f * s, -3f * s, 6f * s, 6f * s, icon);
		drawYPlane(f, 3f * s, 16f + 3f * s, -3f * s, -6f * s, 6f * s, icon);
	}

	private void renderStraightY(float f, IIcon icon, float s) {
		drawXPlane(f, -2f * s, 8f, -2f * s, 4 * s, 16, icon);
		drawXPlane(f, 2f * s, 8f, 2f * s, -4 * s, 16, icon);
		drawZPlane(f, 2f * s, 8f, -2f * s, -4 * s, 16, icon);
		drawZPlane(f, -2f * s, 8f, 2f * s, 4 * s, 16, icon);

		drawYPlane(f, -2f * s, 8, -2f * s, 4f * s, 4f * s, icon);
		drawYPlane(f, 2f * s, 24, -2f * s, -4f * s, 4f * s, icon);
	}

	private void renderStraightZ(float f, IIcon icon, float s) {
		drawXPlane(f, -2f * s, 16f - 2f * s, -8f, 16, 4f * s, icon);
		drawXPlane(f, 2f * s, 16f + 2f * s, -8f, 16, -4f * s, icon);
		drawYPlane(f, 2 * s, 16f - 2f * s, 8, -4f * s, -16, icon);
		drawYPlane(f, -2 * s, 16f + 2f * s, 8, 4f * s, -16, icon);

		drawZPlane(f, 2f * s, 16f - 2f * s, -8f, -4f * s, 4f * s, icon);
		drawZPlane(f, 2f * s, 16f + 2f * s, 8f, -4f * s, -4f * s, icon);
	}

	private void renderStraightX(float f, IIcon icon, float s) {
		drawYPlane(f, -8, 16f - 2f * s, -2f * s, 16, 4 * s, icon);
		drawYPlane(f, -8, 16f + 2f * s, 2f * s, 16, -4 * s, icon);
		drawZPlane(f, -8f, 16f - 2f * s, 2f * s, 16, 4 * s, icon);
		drawZPlane(f, -8f, 16f + 2f * s, -2f * s, 16, -4 * s, icon);

		drawXPlane(f, -8f, 16f - 2f * s, -2f * s, 4f * s, 4f * s, icon);
		drawXPlane(f, 8f, 16f + 2f * s, -2f * s, 4f * s, -4f * s, icon);
	}

	private void drawYPlane(float f, float x, float y, float z, float width, float height, IIcon icon) {
		Tessellator tessellator = Tessellator.instance;

		float uSize = (icon.getMaxU() - icon.getMinU());
		float vSize = (icon.getMaxV() - icon.getMinV());

		float uW = (16 - Math.abs(width)) / 2;
		float vH = (16 - Math.abs(height)) / 2;
		float uCorrect = uSize * uW / 16;
		float vCorrect = vSize * vH / 16;

		int sign = (int)Math.signum(width * height);		
        tessellator.setNormal(0, -sign, 0);
        
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) y * f, (double) (z + height) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + height) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMaxV() - vCorrect);
		
	}

	private void drawZPlane(float f, float x, float y, float z, float width, float height, IIcon icon) {
		Tessellator tessellator = Tessellator.instance;

		float uSize = (icon.getMaxU() - icon.getMinU());
		float vSize = (icon.getMaxV() - icon.getMinV());

		float uW = (16 - Math.abs(width)) / 2;
		float vH = (16 - Math.abs(height)) / 2;
		float uCorrect = uSize * uW / 16;
		float vCorrect = vSize * vH / 16;

        int sign = (int)Math.signum(width * height);
        tessellator.setNormal(0, 0, -sign);
        
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) (y + height) * f, (double) (z + 0) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) (y + height) * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMaxV() - vCorrect);
		
	}

	private void drawXPlane(float f, float x, float y, float z, float width, float height, IIcon icon) {
		Tessellator tessellator = Tessellator.instance;

		float uSize = (icon.getMaxU() - icon.getMinU());
		float vSize = (icon.getMaxV() - icon.getMinV());

		float uW = (16 - Math.abs(width)) / 2;
		float vH = (16 - Math.abs(height)) / 2;
		float uCorrect = uSize * uW / 16;
		float vCorrect = vSize * vH / 16;

        int sign = (int)Math.signum(width * height);        
		tessellator.setNormal(-sign, 0, 0);
		
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + width) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) (y + height) * f, (double) (z + width) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) (y + height) * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMaxV() - vCorrect);
	 
	}
}
