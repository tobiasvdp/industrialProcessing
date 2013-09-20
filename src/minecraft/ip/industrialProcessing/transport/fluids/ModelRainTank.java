package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedOrientedFluid;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class ModelRainTank extends ModelConnectedOrientedFluid {

	// fields
	ModelRenderer FloorPlate;
	ModelRenderer WallRight;
	ModelRenderer WallBack;
	ModelRenderer DrainRight;
	ModelRenderer WallLeft;
	ModelRenderer WallFront;
	ModelRenderer DrainBottom;
	ModelRenderer DrainFront;
	ModelRenderer DrainLeft;
	ModelRenderer DrainBack;
	ModelRenderer DrainPipeFront;
	ModelRenderer DrainPipeCenter;
	ModelRenderer DrainPipeLeft;
	ModelRenderer DrainPipeBack;
	ModelRenderer DrainPipeTop;
	ModelRenderer DrainPipeRight;
	ModelRenderer DrainPipeBottom;
	ModelRenderer Corner3;
	ModelRenderer Corner1;
	ModelRenderer Corner4;
	ModelRenderer Corner2;
	ModelRenderer SupportBottomFront;
	ModelRenderer SupportBottomBack;
	ModelRenderer SupportBotomLeft;
	ModelRenderer SupportBottomRight;
	ModelRenderer SupportDiagonalBack1;
	ModelRenderer SupportDiagonalRight2;
	ModelRenderer SupportDiagonalFront2;
	ModelRenderer SupportDiagonalLeft1;
	ModelRenderer DrainGrate;
	ModelRenderer SupportDiagonalRight1;
	ModelRenderer SupportDiagonalFront1;
	ModelRenderer SupportDiagonalLeft2;
	ModelRenderer SupportDiagonalBack2;

	public ModelRainTank() {
		textureWidth = 64;
		textureHeight = 32;

		FloorPlate = new ModelRenderer(this, 0, 0);
		FloorPlate.addBox(-8F, -8F, 0F, 16, 16, 1);
		FloorPlate.setRotationPoint(0F, 13F, 0F);
		FloorPlate.setTextureSize(64, 32);
		FloorPlate.mirror = true;
		setRotation(FloorPlate, 1.570796F, 0F, 0F);
		WallRight = new ModelRenderer(this, 0, 17);
		WallRight.addBox(-8F, 0F, 7F, 16, 4, 1);
		WallRight.setRotationPoint(0F, 8F, 0F);
		WallRight.setTextureSize(64, 32);
		WallRight.mirror = true;
		setRotation(WallRight, 0F, -1.570796F, 0F);
		WallBack = new ModelRenderer(this, 0, 17);
		WallBack.addBox(-8F, 0F, 7F, 16, 4, 1);
		WallBack.setRotationPoint(0F, 8F, 0F);
		WallBack.setTextureSize(64, 32);
		WallBack.mirror = true;
		setRotation(WallBack, 0F, 0F, 0F);
		DrainRight = new ModelRenderer(this, 0, 22);
		DrainRight.addBox(-3F, -3F, 7F, 6, 6, 1);
		DrainRight.setRotationPoint(0F, 16F, 0F);
		DrainRight.setTextureSize(64, 32);
		DrainRight.mirror = true;
		setRotation(DrainRight, 0F, -1.570796F, 0F);
		WallLeft = new ModelRenderer(this, 0, 17);
		WallLeft.addBox(-8F, 0F, 7F, 16, 4, 1);
		WallLeft.setRotationPoint(0F, 8F, 0F);
		WallLeft.setTextureSize(64, 32);
		WallLeft.mirror = true;
		setRotation(WallLeft, 0F, 1.570796F, 0F);
		WallFront = new ModelRenderer(this, 0, 17);
		WallFront.addBox(-8F, 0F, 7F, 16, 4, 1);
		WallFront.setRotationPoint(0F, 8F, 0F);
		WallFront.setTextureSize(64, 32);
		WallFront.mirror = true;
		setRotation(WallFront, 0F, 3.141593F, 0F);
		DrainBottom = new ModelRenderer(this, 0, 22);
		DrainBottom.addBox(-3F, -3F, 7F, 6, 6, 1);
		DrainBottom.setRotationPoint(0F, 16F, 0F);
		DrainBottom.setTextureSize(64, 32);
		DrainBottom.mirror = true;
		setRotation(DrainBottom, -1.570796F, 0F, 0F);
		DrainFront = new ModelRenderer(this, 0, 22);
		DrainFront.addBox(-3F, -3F, 7F, 6, 6, 1);
		DrainFront.setRotationPoint(0F, 16F, 0F);
		DrainFront.setTextureSize(64, 32);
		DrainFront.mirror = true;
		setRotation(DrainFront, 0F, 3.141593F, 0F);
		DrainLeft = new ModelRenderer(this, 0, 22);
		DrainLeft.addBox(-3F, -3F, 7F, 6, 6, 1);
		DrainLeft.setRotationPoint(0F, 16F, 0F);
		DrainLeft.setTextureSize(64, 32);
		DrainLeft.mirror = true;
		setRotation(DrainLeft, 0F, 1.570796F, 0F);
		DrainBack = new ModelRenderer(this, 0, 22);
		DrainBack.addBox(-3F, -3F, 7F, 6, 6, 1);
		DrainBack.setRotationPoint(0F, 16F, 0F);
		DrainBack.setTextureSize(64, 32);
		DrainBack.mirror = true;
		setRotation(DrainBack, 0F, 0F, 0F);
		DrainPipeFront = new ModelRenderer(this, 30, 22);
		DrainPipeFront.addBox(-2F, 2F, -2F, 4, 5, 4);
		DrainPipeFront.setRotationPoint(0F, 16F, 0F);
		DrainPipeFront.setTextureSize(64, 32);
		DrainPipeFront.mirror = true;
		setRotation(DrainPipeFront, -1.570796F, 0F, 0F);
		DrainPipeCenter = new ModelRenderer(this, 14, 22);
		DrainPipeCenter.addBox(-2F, -2F, -2F, 4, 4, 4);
		DrainPipeCenter.setRotationPoint(0F, 16F, 0F);
		DrainPipeCenter.setTextureSize(64, 32);
		DrainPipeCenter.mirror = true;
		setRotation(DrainPipeCenter, 0F, 0F, 0F);
		DrainPipeLeft = new ModelRenderer(this, 30, 22);
		DrainPipeLeft.addBox(-2F, 2F, -2F, 4, 5, 4);
		DrainPipeLeft.setRotationPoint(0F, 16F, 0F);
		DrainPipeLeft.setTextureSize(64, 32);
		DrainPipeLeft.mirror = true;
		setRotation(DrainPipeLeft, 0F, 0F, -1.570796F);
		DrainPipeBack = new ModelRenderer(this, 30, 22);
		DrainPipeBack.addBox(-2F, 2F, -2F, 4, 5, 4);
		DrainPipeBack.setRotationPoint(0F, 16F, 0F);
		DrainPipeBack.setTextureSize(64, 32);
		DrainPipeBack.mirror = true;
		setRotation(DrainPipeBack, 1.570796F, 0F, 0F);
		DrainPipeTop = new ModelRenderer(this, 30, 22);
		DrainPipeTop.addBox(-2F, 2F, -2F, 4, 1, 4);
		DrainPipeTop.setRotationPoint(0F, 16F, 0F);
		DrainPipeTop.setTextureSize(64, 32);
		DrainPipeTop.mirror = true;
		setRotation(DrainPipeTop, 0F, 0F, 3.141593F);
		DrainPipeRight = new ModelRenderer(this, 30, 22);
		DrainPipeRight.addBox(-2F, 2F, -2F, 4, 5, 4);
		DrainPipeRight.setRotationPoint(0F, 16F, 0F);
		DrainPipeRight.setTextureSize(64, 32);
		DrainPipeRight.mirror = true;
		setRotation(DrainPipeRight, 0F, 0F, 1.570796F);
		DrainPipeBottom = new ModelRenderer(this, 30, 22);
		DrainPipeBottom.addBox(-2F, 2F, -2F, 4, 5, 4);
		DrainPipeBottom.setRotationPoint(0F, 16F, 0F);
		DrainPipeBottom.setTextureSize(64, 32);
		DrainPipeBottom.mirror = true;
		setRotation(DrainPipeBottom, 0F, 0F, 0F);
		Corner3 = new ModelRenderer(this, 34, 0);
		Corner3.addBox(7F, 0F, 7F, 1, 11, 1);
		Corner3.setRotationPoint(0F, 13F, 0F);
		Corner3.setTextureSize(64, 32);
		Corner3.mirror = true;
		setRotation(Corner3, 0F, 1.570796F, 0F);
		Corner1 = new ModelRenderer(this, 34, 0);
		Corner1.addBox(7F, 0F, 7F, 1, 11, 1);
		Corner1.setRotationPoint(0F, 13F, 0F);
		Corner1.setTextureSize(64, 32);
		Corner1.mirror = true;
		setRotation(Corner1, 0F, -1.570796F, 0F);
		Corner4 = new ModelRenderer(this, 34, 0);
		Corner4.addBox(7F, 0F, 7F, 1, 11, 1);
		Corner4.setRotationPoint(0F, 13F, 0F);
		Corner4.setTextureSize(64, 32);
		Corner4.mirror = true;
		setRotation(Corner4, 0F, 3.141593F, 0F);
		Corner2 = new ModelRenderer(this, 34, 0);
		Corner2.addBox(7F, 0F, 7F, 1, 11, 1);
		Corner2.setRotationPoint(0F, 13F, 0F);
		Corner2.setTextureSize(64, 32);
		Corner2.mirror = true;
		setRotation(Corner2, 0F, 0F, 0F);
		SupportBottomFront = new ModelRenderer(this, 0, 30);
		SupportBottomFront.addBox(-7F, 0F, 7F, 14, 1, 1);
		SupportBottomFront.setRotationPoint(0F, 23F, 0F);
		SupportBottomFront.setTextureSize(64, 32);
		SupportBottomFront.mirror = true;
		setRotation(SupportBottomFront, 0F, 3.141593F, 0F);
		SupportBottomBack = new ModelRenderer(this, 0, 30);
		SupportBottomBack.addBox(-7F, 0F, 7F, 14, 1, 1);
		SupportBottomBack.setRotationPoint(0F, 23F, 0F);
		SupportBottomBack.setTextureSize(64, 32);
		SupportBottomBack.mirror = true;
		setRotation(SupportBottomBack, 0F, 0F, 0F);
		SupportBotomLeft = new ModelRenderer(this, 0, 30);
		SupportBotomLeft.addBox(-7F, 0F, 7F, 14, 1, 1);
		SupportBotomLeft.setRotationPoint(0F, 23F, 0F);
		SupportBotomLeft.setTextureSize(64, 32);
		SupportBotomLeft.mirror = true;
		setRotation(SupportBotomLeft, 0F, 1.570796F, 0F);
		SupportBottomRight = new ModelRenderer(this, 0, 30);
		SupportBottomRight.addBox(-7F, 0F, 7F, 14, 1, 1);
		SupportBottomRight.setRotationPoint(0F, 23F, 0F);
		SupportBottomRight.setTextureSize(64, 32);
		SupportBottomRight.mirror = true;
		setRotation(SupportBottomRight, 0F, -1.570796F, 0F);
		SupportDiagonalBack1 = new ModelRenderer(this, 38, 0);
		SupportDiagonalBack1.addBox(0F, 0F, -1F, 1, 13, 1);
		SupportDiagonalBack1.setRotationPoint(-7F, 13F, 8F);
		SupportDiagonalBack1.setTextureSize(64, 32);
		SupportDiagonalBack1.mirror = true;
		setRotation(SupportDiagonalBack1, 0.6457718F, 1.570796F, 0F);
		SupportDiagonalRight2 = new ModelRenderer(this, 38, 0);
		SupportDiagonalRight2.addBox(-1F, 0F, -1F, 1, 13, 1);
		SupportDiagonalRight2.setRotationPoint(-8F, 13F, 7F);
		SupportDiagonalRight2.setTextureSize(64, 32);
		SupportDiagonalRight2.mirror = true;
		setRotation(SupportDiagonalRight2, 0.6457718F, 3.141593F, 0F);
		SupportDiagonalFront2 = new ModelRenderer(this, 38, 0);
		SupportDiagonalFront2.addBox(-1F, 0F, -1F, 1, 13, 1);
		SupportDiagonalFront2.setRotationPoint(7F, 13F, -7F);
		SupportDiagonalFront2.setTextureSize(64, 32);
		SupportDiagonalFront2.mirror = true;
		setRotation(SupportDiagonalFront2, 0.6457718F, -1.570796F, 0F);
		SupportDiagonalLeft1 = new ModelRenderer(this, 38, 0);
		SupportDiagonalLeft1.addBox(0F, 0F, -1F, 1, 13, 1);
		SupportDiagonalLeft1.setRotationPoint(7F, 13F, -7F);
		SupportDiagonalLeft1.setTextureSize(64, 32);
		SupportDiagonalLeft1.mirror = true;
		setRotation(SupportDiagonalLeft1, 0.6457718F, 0F, 0F);
		DrainGrate = new ModelRenderer(this, 42, 27);
		DrainGrate.addBox(-2F, 3.5F, -2F, 4, 1, 4);
		DrainGrate.setRotationPoint(0F, 16F, 0F);
		DrainGrate.setTextureSize(64, 32);
		DrainGrate.mirror = true;
		setRotation(DrainGrate, 0F, 0F, 3.141593F);
		SupportDiagonalRight1 = new ModelRenderer(this, 38, 0);
		SupportDiagonalRight1.addBox(0F, 0F, -1F, 1, 13, 1);
		SupportDiagonalRight1.setRotationPoint(-8F, 13F, -7F);
		SupportDiagonalRight1.setTextureSize(64, 32);
		SupportDiagonalRight1.mirror = true;
		setRotation(SupportDiagonalRight1, 0.6457718F, 0F, 0F);
		SupportDiagonalFront1 = new ModelRenderer(this, 38, 0);
		SupportDiagonalFront1.addBox(0F, 0F, -1F, 1, 13, 1);
		SupportDiagonalFront1.setRotationPoint(-7F, 13F, -7F);
		SupportDiagonalFront1.setTextureSize(64, 32);
		SupportDiagonalFront1.mirror = true;
		setRotation(SupportDiagonalFront1, 0.6457718F, 1.570796F, 0F);
		SupportDiagonalLeft2 = new ModelRenderer(this, 38, 0);
		SupportDiagonalLeft2.addBox(-1F, 0F, -1F, 1, 13, 1);
		SupportDiagonalLeft2.setRotationPoint(7F, 13F, 7F);
		SupportDiagonalLeft2.setTextureSize(64, 32);
		SupportDiagonalLeft2.mirror = true;
		setRotation(SupportDiagonalLeft2, 0.6457718F, 3.141593F, 0F);
		SupportDiagonalBack2 = new ModelRenderer(this, 38, 0);
		SupportDiagonalBack2.addBox(-1F, 0F, -1F, 1, 13, 1);
		SupportDiagonalBack2.setRotationPoint(7F, 13F, 8F);
		SupportDiagonalBack2.setTextureSize(64, 32);
		SupportDiagonalBack2.mirror = true;
		setRotation(SupportDiagonalBack2, 0.6457718F, -1.570796F, 0F);
	}

	@Override
	public void renderModelConnectedOrientedFluid(TileEntity tl, float f, ForgeDirection forward, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
		if (tankSlot == 0) {

			float x = -8f;
			float z = -8f;

			float height = 3.5f * fluidPercentage;
			float y = 12.0f - height;
			int w = 16;
			int h = 16;
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU(), (double) icon.getMinV());
			tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMaxU(), (double) icon.getMinV());
			tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h) * f, (double) icon.getMaxU(), (double) icon.getMaxV());
			tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h) * f, (double) icon.getMinU(), (double) icon.getMaxV());
			tessellator.draw();

		}
	}

	@Override
	public void renderModelConnectedOriented(TileEntity tl, float f5, ForgeDirection forward, ConnectionState south, ConnectionState west, ConnectionState north, ConnectionState east, ConnectionState up, ConnectionState down) {

		boolean connectedPipe = false;
		FloorPlate.render(f5);

		if (south != ConnectionState.CONNECTED) {
			WallBack.render(f5);
		}
		if (east != ConnectionState.CONNECTED) {
			WallRight.render(f5);
		}
		if (west != ConnectionState.CONNECTED) {
			WallLeft.render(f5);
		}
		if (north != ConnectionState.CONNECTED) {
			WallFront.render(f5);
		}

		if (down == ConnectionState.PLUGGED) {
			connectedPipe = true;
			DrainBottom.render(f5);
			DrainPipeBottom.render(f5);
		}
		if (south == ConnectionState.PLUGGED) {
			connectedPipe = true;
			DrainBack.render(f5);
			DrainPipeBack.render(f5);
		}
		if (north == ConnectionState.PLUGGED) {
			connectedPipe = true;
			DrainFront.render(f5);
			DrainPipeFront.render(f5);
		}
		if (west == ConnectionState.PLUGGED) {
			connectedPipe = true;
			DrainLeft.render(f5);
			DrainPipeLeft.render(f5);
		}
		if (east == ConnectionState.PLUGGED) {
			connectedPipe = true;
			DrainRight.render(f5);
			DrainPipeRight.render(f5);
		}

		if (connectedPipe) {
			DrainPipeCenter.render(f5);
			DrainPipeTop.render(f5);
			DrainGrate.render(f5);
		}

		Corner3.render(f5);
		Corner1.render(f5);
		Corner4.render(f5);
		Corner2.render(f5);

		SupportBottomFront.render(f5);
		SupportBottomBack.render(f5);
		SupportBotomLeft.render(f5);
		SupportBottomRight.render(f5);

		SupportDiagonalBack1.render(f5);
		SupportDiagonalRight2.render(f5);
		SupportDiagonalFront2.render(f5);
		SupportDiagonalLeft1.render(f5);
		SupportDiagonalRight1.render(f5);
		SupportDiagonalFront1.render(f5);
		SupportDiagonalLeft2.render(f5);
		SupportDiagonalBack2.render(f5);
	}

}
