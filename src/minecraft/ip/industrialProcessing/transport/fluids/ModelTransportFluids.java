package ip.industrialProcessing.transport.fluids;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;

public class ModelTransportFluids extends ModelConnectedFluid {

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {

	}

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
		fluidPercentage *= 0.9f;
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
	}

	private void renderUp(float f, Icon icon, float s) {
		drawXPlane(f, -2f * s, 8, -2f * s, 4 * s, 8 - 3f * s, icon);
		drawXPlane(f, 2f * s, 8, 2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, 2f * s, 8, -2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, -2f * s, 8, 2f * s, 4 * s, 8 - 3f * s, icon);

		drawYPlane(f, -2f * s, 8, -2f * s, 4f * s, 4f * s, icon);
		drawYPlane(f, 2f * s, 16f - 3f * s, -2f * s, -4f * s, 4f * s, icon);
	}

	private void renderDown(float f, Icon icon, float s) {
		drawXPlane(f, -2f * s, 16f + 3f * s, -2f * s, 4 * s, 8 - 3f * s, icon);
		drawXPlane(f, 2f * s, 16f + 3f * s, 2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, 2f * s, 16f + 3f * s, -2f * s, -4 * s, 8 - 3f * s, icon);
		drawZPlane(f, -2f * s, 16f + 3f * s, 2f * s, 4 * s, 8 - 3f * s, icon);

		drawYPlane(f, -2f * s, 16f + 3f * s, -2f * s, 4f * s, 4f * s, icon);
		drawYPlane(f, 2f * s, 24f, -2f * s, -4f * s, 4f * s, icon);
	}

	private void renderNorth(float f, Icon icon, float s) {
		drawXPlane(f, -2f * s, 16f - 2f * s, -8f, 8 - 3f * s, 4f * s, icon);
		drawXPlane(f, 2f * s, 16f + 2f * s, -8f, 8 - 3f * s, -4f * s, icon);
		drawYPlane(f, 2f * s, 16f - 2f * s, -3f * s, -4f * s, -8 + 3f * s, icon);
		drawYPlane(f, -2f * s, 16f + 2f * s, -3f * s, 4f * s, -8 + 3f * s, icon);

		drawZPlane(f, 2f * s, 16f - 2f * s, -8f, -4f * s, 4f * s, icon);
		drawZPlane(f, 2f * s, 16f + 2f * s, -3f * s, -4f * s, -4f * s, icon);
	}

	private void renderSouth(float f, Icon icon, float s) {
		drawXPlane(f, -2f * s, 16f - 2f * s, 3f * s, 8 - 3f * s, 4f * s, icon);
		drawXPlane(f, 2f * s, 16f + 2f * s, 3f * s, 8 - 3f * s, -4f * s, icon);
		drawYPlane(f, 2f * s, 16f - 2f * s, 8f, -4f * s, -8 + 3f * s, icon);
		drawYPlane(f, -2f * s, 16f + 2f * s, 8f, 4f * s, -8 + 3f * s, icon);

		drawZPlane(f, 2f * s, 16f - 2f * s, 3f * s, -4f * s, 4f * s, icon);
		drawZPlane(f, 2f * s, 16f + 2f * s, 8f, -4f * s, -4f * s, icon);
	}

	private void renderEast(float f, Icon icon, float s) {
		drawYPlane(f, -8, 16f - 2f * s, -2f * s, 8 - 3f * s, 4 * s, icon);
		drawYPlane(f, -8, 16f + 2f * s, 2f * s, 8 - 3f * s, -4 * s, icon);
		drawZPlane(f, -8f, 16f - 2f * s, 2f * s, 8 - 3f * s, 4 * s, icon);
		drawZPlane(f, -8f, 16f + 2f * s, -2f * s, 8 - 3f * s, -4 * s, icon);

		drawXPlane(f, -8f, 16f - 2f * s, -2f * s, 4f * s, 4f * s, icon);
		drawXPlane(f, -3f * s, 16f + 2f * s, -2f * s, 4f * s, -4f * s, icon);
	}

	private void renderWest(float f, Icon icon, float s) {
		drawYPlane(f, 3f * s, 16f - 2f * s, -2f * s, 8 - 3f * s, 4 * s, icon);
		drawYPlane(f, 3f * s, 16f + 2f * s, 2f * s, 8 - 3f * s, -4 * s, icon);
		drawZPlane(f, 3f * s, 16f - 2f * s, 2f * s, 8 - 3f * s, 4 * s, icon);
		drawZPlane(f, 3f * s, 16f + 2f * s, -2f * s, 8 - 3f * s, -4 * s, icon);

		drawXPlane(f, 3f * s, 16f - 2f * s, -2f * s, 4f * s, 4f * s, icon);
		drawXPlane(f, 8f, 16f + 2f * s, -2f * s, 4f * s, -4f * s, icon);
	}

	private void renderCap(float f, Icon icon, float s) {
		drawXPlane(f, -3f * s, 16f - 3f * s, -3f * s, 6f * s, 6f * s, icon);
		drawXPlane(f, 3f * s, 16f - 3f * s, 3f * s, -6f * s, 6f * s, icon);
		drawZPlane(f, 3f * s, 16f - 3f * s, -3f * s, -6f * s, 6f * s, icon);
		drawZPlane(f, -3f * s, 16f - 3f * s, 3f * s, 6f * s, 6f * s, icon);

		drawYPlane(f, -3f * s, 16f - 3f * s, -3f * s, 6f * s, 6f * s, icon);
		drawYPlane(f, 3f * s, 16f + 3f * s, -3f * s, -6f * s, 6f * s, icon);
	}

	private void renderStraightY(float f, Icon icon, float s) {
		drawXPlane(f, -2f * s, 8f, -2f * s, 4 * s, 16, icon);
		drawXPlane(f, 2f * s, 8f, 2f * s, -4 * s, 16, icon);
		drawZPlane(f, 2f * s, 8f, -2f * s, -4 * s, 16, icon);
		drawZPlane(f, -2f * s, 8f, 2f * s, 4 * s, 16, icon);

		drawYPlane(f, -2f * s, 8, -2f * s, 4f * s, 4f * s, icon);
		drawYPlane(f, 2f * s, 24, -2f * s, -4f * s, 4f * s, icon);
	}

	private void renderStraightZ(float f, Icon icon, float s) {
		drawXPlane(f, -2f * s, 16f - 2f * s, -8f, 16, 4f * s, icon);
		drawXPlane(f, 2f * s, 16f + 2f * s, -8f, 16, -4f * s, icon);
		drawYPlane(f, 2 * s, 16f - 2f * s, 8, -4f * s, -16, icon);
		drawYPlane(f, -2 * s, 16f + 2f * s, 8, 4f * s, -16, icon);

		drawZPlane(f, 2f * s, 16f - 2f * s, -8f, -4f * s, 4f * s, icon);
		drawZPlane(f, 2f * s, 16f + 2f * s, 8f, -4f * s, -4f * s, icon);
	}

	private void renderStraightX(float f, Icon icon, float s) {
		drawYPlane(f, -8, 16f - 2f * s, -2f * s, 16, 4 * s, icon);
		drawYPlane(f, -8, 16f + 2f * s, 2f * s, 16, -4 * s, icon);
		drawZPlane(f, -8f, 16f - 2f * s, 2f * s, 16, 4 * s, icon);
		drawZPlane(f, -8f, 16f + 2f * s, -2f * s, 16, -4 * s, icon);

		drawXPlane(f, -8f, 16f - 2f * s, -2f * s, 4f * s, 4f * s, icon);
		drawXPlane(f, 8f, 16f + 2f * s, -2f * s, 4f * s, -4f * s, icon);
	}

	private void drawYPlane(float f, float x, float y, float z, float width, float height, Icon icon) {
		Tessellator tessellator = Tessellator.instance;

		float uSize = (icon.getMaxU() - icon.getMinU());
		float vSize = (icon.getMaxV() - icon.getMinV());

		float uW = (16 - Math.abs(width)) / 2;
		float vH = (16 - Math.abs(height)) / 2;
		float uCorrect = uSize * uW / 16;
		float vCorrect = vSize * vH / 16;

		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) y * f, (double) (z + height) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + height) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.draw();
	}

	private void drawZPlane(float f, float x, float y, float z, float width, float height, Icon icon) {
		Tessellator tessellator = Tessellator.instance;

		float uSize = (icon.getMaxU() - icon.getMinU());
		float vSize = (icon.getMaxV() - icon.getMinV());

		float uW = (16 - Math.abs(width)) / 2;
		float vH = (16 - Math.abs(height)) / 2;
		float uCorrect = uSize * uW / 16;
		float vCorrect = vSize * vH / 16;

		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + width) * f, (double) (y + height) * f, (double) (z + 0) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) (y + height) * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.draw();
	}

	private void drawXPlane(float f, float x, float y, float z, float width, float height, Icon icon) {
		Tessellator tessellator = Tessellator.instance;

		float uSize = (icon.getMaxU() - icon.getMinU());
		float vSize = (icon.getMaxV() - icon.getMinV());

		float uW = (16 - Math.abs(width)) / 2;
		float vH = (16 - Math.abs(height)) / 2;
		float uCorrect = uSize * uW / 16;
		float vCorrect = vSize * vH / 16;

		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + width) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMinV() + vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) (y + height) * f, (double) (z + width) * f, (double) icon.getMaxU() - uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.addVertexWithUV((double) (x + 0) * f, (double) (y + height) * f, (double) (z + 0) * f, (double) icon.getMinU() + uCorrect, (double) icon.getMaxV() - vCorrect);
		tessellator.draw();
	}
}
