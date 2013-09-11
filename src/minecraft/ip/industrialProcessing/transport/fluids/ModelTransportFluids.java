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

	// fields
	ModelRenderer Center;
	ModelRenderer Down;
	ModelRenderer Up;
	ModelRenderer South;
	ModelRenderer East;
	ModelRenderer West;
	ModelRenderer North;
	ModelRenderer DownConnector;
	ModelRenderer EastConnector;
	ModelRenderer WestConnector;
	ModelRenderer NorthConnector;
	ModelRenderer SouthConnector;
	ModelRenderer UpConnector;
	ModelRenderer EastWest;
	ModelRenderer NorthSouth;
	ModelRenderer UpDown;

	public ModelTransportFluids() {
		textureWidth = 32;
		textureHeight = 32;

		Center = new ModelRenderer(this, 0, 0);
		Center.addBox(-3F, -3F, -3F, 6, 6, 6);
		Center.setRotationPoint(0F, 16F, 0F);
		Center.setTextureSize(32, 32);
		Center.mirror = true;
		setRotation(Center, 0F, 0F, 0F);
		Down = new ModelRenderer(this, 0, 17);
		Down.addBox(-2F, -8F, -2F, 4, 5, 4);
		Down.setRotationPoint(0F, 16F, 0F);
		Down.setTextureSize(32, 32);
		Down.mirror = true;
		setRotation(Down, 3.141593F, 0F, 0F);
		Up = new ModelRenderer(this, 0, 17);
		Up.addBox(-2F, -8F, -2F, 4, 5, 4);
		Up.setRotationPoint(0F, 16F, 0F);
		Up.setTextureSize(32, 32);
		Up.mirror = true;
		setRotation(Up, 0F, 0F, 0F);
		South = new ModelRenderer(this, 0, 17);
		South.addBox(-2F, -8F, -2F, 4, 5, 4);
		South.setRotationPoint(0F, 16F, 0F);
		South.setTextureSize(32, 32);
		South.mirror = true;
		setRotation(South, -1.570796F, 0F, 0F);
		East = new ModelRenderer(this, 0, 17);
		East.addBox(-2F, -8F, -2F, 4, 5, 4);
		East.setRotationPoint(0F, 16F, 0F);
		East.setTextureSize(32, 32);
		East.mirror = true;
		setRotation(East, 0F, 0F, 1.570796F);
		West = new ModelRenderer(this, 0, 17);
		West.addBox(-2F, -8F, -2F, 4, 5, 4);
		West.setRotationPoint(0F, 16F, 0F);
		West.setTextureSize(32, 32);
		West.mirror = true;
		setRotation(West, 0F, 0F, -1.570796F);
		North = new ModelRenderer(this, 0, 17);
		North.addBox(-2F, -8F, -2F, 4, 5, 4);
		North.setRotationPoint(0F, 16F, 0F);
		North.setTextureSize(32, 32);
		North.mirror = true;
		setRotation(North, 1.570796F, 0F, 0F);
		DownConnector = new ModelRenderer(this, 0, 26);
		DownConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
		DownConnector.setRotationPoint(0F, 16F, 0F);
		DownConnector.setTextureSize(32, 32);
		DownConnector.mirror = true;
		setRotation(DownConnector, 0F, 0F, 3.141593F);
		EastConnector = new ModelRenderer(this, 0, 26);
		EastConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
		EastConnector.setRotationPoint(0F, 16F, 0F);
		EastConnector.setTextureSize(32, 32);
		EastConnector.mirror = true;
		setRotation(EastConnector, 0F, 0F, 1.570796F);
		WestConnector = new ModelRenderer(this, 0, 26);
		WestConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
		WestConnector.setRotationPoint(0F, 16F, 0F);
		WestConnector.setTextureSize(32, 32);
		WestConnector.mirror = true;
		setRotation(WestConnector, 0F, 0F, -1.570796F);
		NorthConnector = new ModelRenderer(this, 0, 26);
		NorthConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
		NorthConnector.setRotationPoint(0F, 16F, 0F);
		NorthConnector.setTextureSize(32, 32);
		NorthConnector.mirror = true;
		setRotation(NorthConnector, 1.570796F, 0F, 0F);
		SouthConnector = new ModelRenderer(this, 0, 26);
		SouthConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
		SouthConnector.setRotationPoint(0F, 16F, 0F);
		SouthConnector.setTextureSize(32, 32);
		SouthConnector.mirror = true;
		setRotation(SouthConnector, -1.570796F, 0F, 0F);
		UpConnector = new ModelRenderer(this, 0, 26);
		UpConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
		UpConnector.setRotationPoint(0F, 16F, 0F);
		UpConnector.setTextureSize(32, 32);
		UpConnector.mirror = true;
		setRotation(UpConnector, 0F, 0F, 0F);
		EastWest = new ModelRenderer(this, 16, 12);
		EastWest.addBox(-2F, -8F, -2F, 4, 15, 4);
		EastWest.setRotationPoint(0F, 16F, 0F);
		EastWest.setTextureSize(32, 32);
		EastWest.mirror = true;
		setRotation(EastWest, 0F, 0F, 1.570796F);
		NorthSouth = new ModelRenderer(this, 16, 12);
		NorthSouth.addBox(-2F, -8F, -2F, 4, 15, 4);
		NorthSouth.setRotationPoint(0F, 16F, 0F);
		NorthSouth.setTextureSize(32, 32);
		NorthSouth.mirror = true;
		setRotation(NorthSouth, 1.570796F, 0F, 0F);
		UpDown = new ModelRenderer(this, 16, 12);
		UpDown.addBox(-2F, -8F, -2F, 4, 15, 4);
		UpDown.setRotationPoint(0F, 16F, 0F);
		UpDown.setTextureSize(32, 32);
		UpDown.mirror = true;
		setRotation(UpDown, 0F, 0F, 0F);
	}

	@Override
	public void renderModelConnected(float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {
		boolean hideCenter = false;
		hideCenter |= renderStraigh(f, NorthSouth, NorthConnector, SouthConnector, north, south, east, west, up, down);
		hideCenter |= renderStraigh(f, EastWest, EastConnector, WestConnector, east, west, north, south, up, down);
		hideCenter |= renderStraigh(f, UpDown, UpConnector, DownConnector, up, down, east, west, north, south);
		render(Up, UpConnector, up, f);
		render(Down, DownConnector, down, f);
		render(North, NorthConnector, north, f);
		render(West, WestConnector, west, f);
		render(South, SouthConnector, south, f);
		render(East, EastConnector, east, f);
		if (!hideCenter)
			Center.render(f);
	}

	private boolean renderStraigh(float f, ModelRenderer northSouth2, ModelRenderer northConnector2, ModelRenderer southConnector2, ConnectionState north2, ConnectionState south2, ConnectionState east2, ConnectionState west2, ConnectionState up2, ConnectionState down2) {
		if (north2 == ConnectionState.DISCONNECTED)
			return false;
		if (south2 == ConnectionState.DISCONNECTED)
			return false;
		if (west2 != ConnectionState.DISCONNECTED)
			return false;
		if (east2 != ConnectionState.DISCONNECTED)
			return false;
		if (up2 != ConnectionState.DISCONNECTED)
			return false;
		if (down2 != ConnectionState.DISCONNECTED)
			return false;

		northSouth2.render(f);
		if (north2 == ConnectionState.PLUGGED)
			northConnector2.render(f);
		if (south2 == ConnectionState.PLUGGED)
			southConnector2.render(f);
		return true;
	}

	@Override
	public void renderModelConnectedFluid(float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
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
