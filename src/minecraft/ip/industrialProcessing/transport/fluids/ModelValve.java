package ip.industrialProcessing.transport.fluids;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedFluidAnimated;
import ip.industrialProcessing.machines.BlockMachine;

public class ModelValve extends ModelConnectedFluidAnimated {

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

	ModelRenderer ValveRod12;
	ModelRenderer ValveRod5;
	ModelRenderer ValveRod6;
	ModelRenderer ValveRod7;
	ModelRenderer ValveRod8;
	ModelRenderer ValveRod9;
	ModelRenderer ValveRod10;
	ModelRenderer ValveRod11;
	ModelRenderer ValveRod1;
	ModelRenderer ValveRod2;
	ModelRenderer ValveRod3;
	ModelRenderer ValveRod4;
	ModelRenderer ValveAxle;

	public ModelValve() {
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
		ValveRod12 = new ModelRenderer(this, 22, 0);
		ValveRod12.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod12.setRotationPoint(0F, 16F, -5F);
		ValveRod12.setTextureSize(32, 32);
		ValveRod12.mirror = true;
		setRotation(ValveRod12, 0F, 0F, -0.7853982F);
		ValveRod5 = new ModelRenderer(this, 22, 4);
		ValveRod5.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod5.setRotationPoint(0F, 16F, -5F);
		ValveRod5.setTextureSize(32, 32);
		ValveRod5.mirror = true;
		setRotation(ValveRod5, 0F, 0F, 0F);
		ValveRod6 = new ModelRenderer(this, 22, 0);
		ValveRod6.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod6.setRotationPoint(0F, 16F, -5F);
		ValveRod6.setTextureSize(32, 32);
		ValveRod6.mirror = true;
		setRotation(ValveRod6, 0F, 0F, 0.7853982F);
		ValveRod7 = new ModelRenderer(this, 22, 0);
		ValveRod7.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod7.setRotationPoint(0F, 16F, -5F);
		ValveRod7.setTextureSize(32, 32);
		ValveRod7.mirror = true;
		setRotation(ValveRod7, 0F, 0F, 1.570796F);
		ValveRod8 = new ModelRenderer(this, 22, 0);
		ValveRod8.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod8.setRotationPoint(0F, 16F, -5F);
		ValveRod8.setTextureSize(32, 32);
		ValveRod8.mirror = true;
		setRotation(ValveRod8, 0F, 0F, 2.356194F);
		ValveRod9 = new ModelRenderer(this, 22, 4);
		ValveRod9.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod9.setRotationPoint(0F, 16F, -5F);
		ValveRod9.setTextureSize(32, 32);
		ValveRod9.mirror = true;
		setRotation(ValveRod9, 0F, 0F, 3.141593F);
		ValveRod10 = new ModelRenderer(this, 22, 0);
		ValveRod10.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod10.setRotationPoint(0F, 16F, -5F);
		ValveRod10.setTextureSize(32, 32);
		ValveRod10.mirror = true;
		setRotation(ValveRod10, 0F, 0F, -2.356194F);
		ValveRod11 = new ModelRenderer(this, 22, 0);
		ValveRod11.addBox(-2F, -4.8285F, 0F, 4, 1, 1);
		ValveRod11.setRotationPoint(0F, 16F, -5F);
		ValveRod11.setTextureSize(32, 32);
		ValveRod11.mirror = true;
		setRotation(ValveRod11, 0F, 0F, -1.570796F);
		ValveRod1 = new ModelRenderer(this, 22, 2);
		ValveRod1.addBox(0F, -0.5F, 0F, 4, 1, 1);
		ValveRod1.setRotationPoint(0F, 16F, -5F);
		ValveRod1.setTextureSize(32, 32);
		ValveRod1.mirror = true;
		setRotation(ValveRod1, 0F, 0F, -1.570796F);
		ValveRod2 = new ModelRenderer(this, 22, 0);
		ValveRod2.addBox(0F, -0.5F, 0F, 4, 1, 1);
		ValveRod2.setRotationPoint(0F, 16F, -5F);
		ValveRod2.setTextureSize(32, 32);
		ValveRod2.mirror = true;
		setRotation(ValveRod2, 0F, 0F, 0F);
		ValveRod3 = new ModelRenderer(this, 21, 2);
		ValveRod3.addBox(0F, -0.5F, 0F, 4, 1, 1);
		ValveRod3.setRotationPoint(0F, 16F, -5F);
		ValveRod3.setTextureSize(32, 32);
		ValveRod3.mirror = true;
		setRotation(ValveRod3, 0F, 0F, 1.570796F);
		ValveRod4 = new ModelRenderer(this, 21, 0);
		ValveRod4.addBox(0F, -0.5F, 0F, 4, 1, 1);
		ValveRod4.setRotationPoint(0F, 16F, -5F);
		ValveRod4.setTextureSize(32, 32);
		ValveRod4.mirror = true;
		setRotation(ValveRod4, 0F, 0F, 3.141593F);
		ValveAxle = new ModelRenderer(this, 24, 6);
		ValveAxle.addBox(-1F, 0.3333333F, -1F, 2, 4, 2);
		ValveAxle.setRotationPoint(0F, 16F, -6F);
		ValveAxle.setTextureSize(32, 32);
		ValveAxle.mirror = true;
		setRotation(ValveAxle, 1.570796F, 0F, 0F);
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

	@Override
	public void renderModelConnectedFluidAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon, float[] animation) {
		fluidPercentage *= 0.9f;

		if (north != ConnectionState.DISCONNECTED && tankSlot == ForgeDirection.NORTH.ordinal())
			renderNorth(f, icon, fluidPercentage);
		if (east != ConnectionState.DISCONNECTED && tankSlot == ForgeDirection.EAST.ordinal())
			renderEast(f, icon, fluidPercentage);
		if (south != ConnectionState.DISCONNECTED && tankSlot == ForgeDirection.SOUTH.ordinal())
			renderSouth(f, icon, fluidPercentage);
		if (west != ConnectionState.DISCONNECTED && tankSlot == ForgeDirection.WEST.ordinal())
			renderWest(f, icon, fluidPercentage);
		if (up != ConnectionState.DISCONNECTED && tankSlot == ForgeDirection.UP.ordinal())
			renderUp(f, icon, fluidPercentage);
		if (down != ConnectionState.DISCONNECTED && tankSlot == ForgeDirection.DOWN.ordinal())
			renderDown(f, icon, fluidPercentage);
	}

	@Override
	public void renderModelConnectedAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down, float[] animation) {
		render(Up, UpConnector, up, f);
		render(Down, DownConnector, down, f);
		render(North, NorthConnector, north, f);
		render(West, WestConnector, west, f);
		render(South, SouthConnector, south, f);
		render(East, EastConnector, east, f);
		Center.render(f);

		int dir = 0;
		if (tl instanceof TileEntityValve) {
			TileEntityValve valve = (TileEntityValve) tl;
			dir = BlockMachine.getMetadataFromForward(valve.getForwardDirection());
		}

		if (animation != null) {
			float ani = animation[0];
			GL11.glPushMatrix();
			float translate = 1f;
			GL11.glTranslatef(0, translate, 0);
			GL11.glRotatef(ani * 270f, 0, 0, 1);
			GL11.glTranslatef(0, -translate, 0);
			GL11.glRotatef(dir * 90, 0, 1, 0);
			ValveAxle.render(f);
			ValveRod1.render(f);
			ValveRod2.render(f);
			ValveRod3.render(f);
			ValveRod4.render(f);
			ValveRod5.render(f);
			ValveRod6.render(f);
			ValveRod7.render(f);
			ValveRod8.render(f);
			ValveRod9.render(f);
			ValveRod10.render(f);
			ValveRod11.render(f);
			ValveRod12.render(f);
			GL11.glPopMatrix();
		}
	}

}
