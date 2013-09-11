package ip.industrialProcessing.transport.fluids;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;
import ip.industrialProcessing.client.render.ModelMachine;
import ip.industrialProcessing.client.render.ModelStateMachine;

public class ModelTank extends ModelConnectedFluid {

	ModelRenderer Support2;
	ModelRenderer Support1;

	// fields Center
	ModelRenderer TankCenter;
	ModelRenderer ViewerCenter3b;
	ModelRenderer ViewerCenter2b;
	ModelRenderer ViewerCenter1b;
	ModelRenderer ViewerCenter3;
	ModelRenderer ViewerCenter2;
	ModelRenderer ViewerCenter1;

	// fields Single
	ModelRenderer TankSingleTop;
	ModelRenderer ViewerSingle5b;
	ModelRenderer ViewerSingle1b;
	ModelRenderer ViewerSingle2b;
	ModelRenderer ViewerSingle3b;
	ModelRenderer ViewerSingle3;
	ModelRenderer ViewerSingle2;
	ModelRenderer ViewerSingle1;
	ModelRenderer ViewerSingle5;
	ModelRenderer TankSingleBottom;
	ModelRenderer ViewerSingle4b;
	ModelRenderer ViewerSingle4;

	// fields Top
	ModelRenderer TankTop;
	ModelRenderer ViewerTop4b;
	ModelRenderer ViewerTop1b;
	ModelRenderer ViewerTop2b;
	ModelRenderer ViewerTop3b;
	ModelRenderer ViewerTop3;
	ModelRenderer ViewerTop2;
	ModelRenderer ViewerTop1;
	ModelRenderer ViewerTop4;

	// fields Bottom
	ModelRenderer TankBottom;
	ModelRenderer ViewerBottom4b;
	ModelRenderer ViewerBottom1b;
	ModelRenderer ViewerBottom2b;
	ModelRenderer ViewerBottom3b;
	ModelRenderer ViewerBottom3;
	ModelRenderer ViewerBottom2;
	ModelRenderer ViewerBottom1;
	ModelRenderer ViewerBottom4;

	public ModelTank() {

		textureWidth = 64;
		textureHeight = 64;
		// CENTER
		TankCenter = new ModelRenderer(this, 8, 34);
		TankCenter.addBox(0F, 0F, 0F, 14, 16, 14);
		TankCenter.setRotationPoint(-7F, 8F, -7F);
		TankCenter.setTextureSize(64, 64);
		TankCenter.mirror = true;
		setRotation(TankCenter, 0F, 0F, 0F);
		ViewerCenter3b = new ModelRenderer(this, -5, 34);
		ViewerCenter3b.addBox(0F, 0F, 0F, 4, 16, 1);
		ViewerCenter3b.setRotationPoint(2F, 8F, -7F);
		ViewerCenter3b.setTextureSize(64, 64);
		ViewerCenter3b.mirror = true;
		setRotation(ViewerCenter3b, 0F, 3.141593F, 0F);
		ViewerCenter2b = new ModelRenderer(this, 42, 0);
		ViewerCenter2b.addBox(0F, 0F, 0F, 1, 16, 1);
		ViewerCenter2b.setRotationPoint(-3F, 8F, -8F);
		ViewerCenter2b.setTextureSize(64, 64);
		ViewerCenter2b.mirror = true;
		setRotation(ViewerCenter2b, 0F, 0F, 0F);
		ViewerCenter1b = new ModelRenderer(this, 42, 0);
		ViewerCenter1b.addBox(0F, 0F, 0F, 1, 16, 1);
		ViewerCenter1b.setRotationPoint(2F, 8F, -8F);
		ViewerCenter1b.setTextureSize(64, 64);
		ViewerCenter1b.mirror = true;
		setRotation(ViewerCenter1b, 0F, 0F, 0F);
		ViewerCenter3 = new ModelRenderer(this, -5, 34);
		ViewerCenter3.addBox(0F, 0F, 0F, 4, 16, 1);
		ViewerCenter3.setRotationPoint(-2F, 8F, 7F);
		ViewerCenter3.setTextureSize(64, 64);
		ViewerCenter3.mirror = true;
		setRotation(ViewerCenter3, 0F, 0F, 0F);
		ViewerCenter2 = new ModelRenderer(this, 42, 0);
		ViewerCenter2.addBox(0F, 0F, 0F, 1, 16, 1);
		ViewerCenter2.setRotationPoint(-3F, 8F, 7F);
		ViewerCenter2.setTextureSize(64, 64);
		ViewerCenter2.mirror = true;
		setRotation(ViewerCenter2, 0F, 0F, 0F);
		ViewerCenter1 = new ModelRenderer(this, 42, 0);
		ViewerCenter1.addBox(0F, 0F, 0F, 1, 16, 1);
		ViewerCenter1.setRotationPoint(2F, 8F, 7F);
		ViewerCenter1.setTextureSize(64, 64);
		ViewerCenter1.mirror = true;
		setRotation(ViewerCenter1, 0F, 0F, 0F);
		// SINGLE

		TankSingleTop = new ModelRenderer(this, 0, 4);
		TankSingleTop.addBox(0F, 0F, 0F, 14, 7, 14);
		TankSingleTop.setRotationPoint(7F, 16F, -7F);
		TankSingleTop.setTextureSize(64, 64);
		TankSingleTop.mirror = true;
		setRotation(TankSingleTop, 0F, 0F, 3.141593F);
		Support2 = new ModelRenderer(this, 0, 0);
		Support2.addBox(0F, 0F, 0F, 16, 2, 2);
		Support2.setRotationPoint(6F, 22F, 8F);
		Support2.setTextureSize(64, 64);
		Support2.mirror = true;
		setRotation(Support2, 0F, 1.570796F, 0F);
		Support1 = new ModelRenderer(this, 0, 0);
		Support1.addBox(0F, 0F, 0F, 16, 2, 2);
		Support1.setRotationPoint(-8F, 22F, 8F);
		Support1.setTextureSize(64, 64);
		Support1.mirror = true;
		setRotation(Support1, 0F, 1.570796F, 0F);
		ViewerSingle5b = new ModelRenderer(this, 0, 4);
		ViewerSingle5b.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerSingle5b.setRotationPoint(-2F, 9F, -8F);
		ViewerSingle5b.setTextureSize(64, 64);
		ViewerSingle5b.mirror = true;
		setRotation(ViewerSingle5b, 0F, 0F, 0F);
		ViewerSingle1b = new ModelRenderer(this, 42, 0);
		ViewerSingle1b.addBox(0F, 0F, 0F, 1, 14, 1);
		ViewerSingle1b.setRotationPoint(2F, 9F, -8F);
		ViewerSingle1b.setTextureSize(64, 64);
		ViewerSingle1b.mirror = true;
		setRotation(ViewerSingle1b, 0F, 0F, 0F);
		ViewerSingle2b = new ModelRenderer(this, 42, 0);
		ViewerSingle2b.addBox(0F, 0F, 0F, 1, 14, 1);
		ViewerSingle2b.setRotationPoint(-3F, 9F, -8F);
		ViewerSingle2b.setTextureSize(64, 64);
		ViewerSingle2b.mirror = true;
		setRotation(ViewerSingle2b, 0F, 0F, 0F);
		ViewerSingle3b = new ModelRenderer(this, 58, 34);
		ViewerSingle3b.addBox(0F, 0F, 0F, 4, 12, 1);
		ViewerSingle3b.setRotationPoint(-2F, 10F, -8F);
		ViewerSingle3b.setTextureSize(64, 64);
		ViewerSingle3b.mirror = true;
		setRotation(ViewerSingle3b, 0F, 0F, 0F);
		ViewerSingle3 = new ModelRenderer(this, 58, 34);
		ViewerSingle3.addBox(0F, 0F, 0F, 4, 12, 1);
		ViewerSingle3.setRotationPoint(2F, 10F, 8F);
		ViewerSingle3.setTextureSize(64, 64);
		ViewerSingle3.mirror = true;
		setRotation(ViewerSingle3, 0F, 3.141593F, 0F);
		ViewerSingle2 = new ModelRenderer(this, 42, 0);
		ViewerSingle2.addBox(0F, 0F, 0F, 1, 14, 1);
		ViewerSingle2.setRotationPoint(-3F, 9F, 7F);
		ViewerSingle2.setTextureSize(64, 64);
		ViewerSingle2.mirror = true;
		setRotation(ViewerSingle2, 0F, 0F, 0F);
		ViewerSingle1 = new ModelRenderer(this, 42, 0);
		ViewerSingle1.addBox(0F, 0F, 0F, 1, 14, 1);
		ViewerSingle1.setRotationPoint(2F, 9F, 7F);
		ViewerSingle1.setTextureSize(64, 64);
		ViewerSingle1.mirror = true;
		setRotation(ViewerSingle1, 0F, 0F, 0F);
		ViewerSingle5 = new ModelRenderer(this, 0, 4);
		ViewerSingle5.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerSingle5.setRotationPoint(-2F, 9F, 7F);
		ViewerSingle5.setTextureSize(64, 64);
		ViewerSingle5.mirror = true;
		setRotation(ViewerSingle5, 0F, 0F, 0F);
		TankSingleBottom = new ModelRenderer(this, 0, 4);
		TankSingleBottom.addBox(0F, 0F, 0F, 14, 7, 14);
		TankSingleBottom.setRotationPoint(-7F, 16F, -7F);
		TankSingleBottom.setTextureSize(64, 64);
		TankSingleBottom.mirror = true;
		setRotation(TankSingleBottom, 0F, 0F, 0F);
		ViewerSingle4b = new ModelRenderer(this, 0, 4);
		ViewerSingle4b.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerSingle4b.setRotationPoint(-2F, 22F, -8F);
		ViewerSingle4b.setTextureSize(64, 64);
		ViewerSingle4b.mirror = true;
		setRotation(ViewerSingle4b, 0F, 0F, 0F);
		ViewerSingle4 = new ModelRenderer(this, 0, 4);
		ViewerSingle4.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerSingle4.setRotationPoint(-2F, 22F, 7F);
		ViewerSingle4.setTextureSize(64, 64);
		ViewerSingle4.mirror = true;
		setRotation(ViewerSingle4, 0F, 0F, 0F);
		// TOP
		TankTop = new ModelRenderer(this, 0, 4);
		TankTop.addBox(0F, 0F, 0F, 14, 15, 14);
		TankTop.setRotationPoint(7F, 24F, -7F);
		TankTop.setTextureSize(64, 64);
		TankTop.mirror = true;
		setRotation(TankTop, 0F, 0F, 3.141593F);
		ViewerTop4b = new ModelRenderer(this, 0, 4);
		ViewerTop4b.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerTop4b.setRotationPoint(-2F, 9F, -8F);
		ViewerTop4b.setTextureSize(64, 64);
		ViewerTop4b.mirror = true;
		setRotation(ViewerTop4b, 0F, 0F, 0F);
		ViewerTop1b = new ModelRenderer(this, 42, 0);
		ViewerTop1b.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerTop1b.setRotationPoint(2F, 9F, -8F);
		ViewerTop1b.setTextureSize(64, 64);
		ViewerTop1b.mirror = true;
		setRotation(ViewerTop1b, 0F, 0F, 0F);
		ViewerTop2b = new ModelRenderer(this, 42, 0);
		ViewerTop2b.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerTop2b.setRotationPoint(-3F, 9F, -8F);
		ViewerTop2b.setTextureSize(64, 64);
		ViewerTop2b.mirror = true;
		setRotation(ViewerTop2b, 0F, 0F, 0F);
		ViewerTop3b = new ModelRenderer(this, 58, 0);
		ViewerTop3b.addBox(0F, 0F, 0F, 4, 14, 1);
		ViewerTop3b.setRotationPoint(-2F, 10F, -8F);
		ViewerTop3b.setTextureSize(64, 64);
		ViewerTop3b.mirror = true;
		setRotation(ViewerTop3b, 0F, 0F, 0F);
		ViewerTop3 = new ModelRenderer(this, 58, 0);
		ViewerTop3.addBox(0F, 0F, 0F, 4, 14, 1);
		ViewerTop3.setRotationPoint(2F, 10F, 8F);
		ViewerTop3.setTextureSize(64, 64);
		ViewerTop3.mirror = true;
		setRotation(ViewerTop3, 0F, 3.141593F, 0F);
		ViewerTop2 = new ModelRenderer(this, 42, 0);
		ViewerTop2.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerTop2.setRotationPoint(-3F, 9F, 7F);
		ViewerTop2.setTextureSize(64, 64);
		ViewerTop2.mirror = true;
		setRotation(ViewerTop2, 0F, 0F, 0F);
		ViewerTop1 = new ModelRenderer(this, 42, 0);
		ViewerTop1.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerTop1.setRotationPoint(2F, 9F, 7F);
		ViewerTop1.setTextureSize(64, 64);
		ViewerTop1.mirror = true;
		setRotation(ViewerTop1, 0F, 0F, 0F);
		ViewerTop4 = new ModelRenderer(this, 0, 4);
		ViewerTop4.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerTop4.setRotationPoint(-2F, 9F, 7F);
		ViewerTop4.setTextureSize(64, 64);
		ViewerTop4.mirror = true;
		setRotation(ViewerTop4, 0F, 0F, 0F);
		// BOTTOM

		TankBottom = new ModelRenderer(this, 0, 4);
		TankBottom.addBox(0F, 0F, 0F, 14, 15, 14);
		TankBottom.setRotationPoint(-7F, 8F, -7F);
		TankBottom.setTextureSize(64, 64);
		TankBottom.mirror = true;
		setRotation(TankBottom, 0F, 0F, 0F);
		ViewerBottom4b = new ModelRenderer(this, 0, 4);
		ViewerBottom4b.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerBottom4b.setRotationPoint(-2F, 22F, -8F);
		ViewerBottom4b.setTextureSize(64, 64);
		ViewerBottom4b.mirror = true;
		setRotation(ViewerBottom4b, 0F, 0F, 0F);
		ViewerBottom1b = new ModelRenderer(this, 42, 0);
		ViewerBottom1b.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerBottom1b.setRotationPoint(2F, 8F, -8F);
		ViewerBottom1b.setTextureSize(64, 64);
		ViewerBottom1b.mirror = true;
		setRotation(ViewerBottom1b, 0F, 0F, 0F);
		ViewerBottom2b = new ModelRenderer(this, 42, 0);
		ViewerBottom2b.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerBottom2b.setRotationPoint(-3F, 8F, -8F);
		ViewerBottom2b.setTextureSize(64, 64);
		ViewerBottom2b.mirror = true;
		setRotation(ViewerBottom2b, 0F, 0F, 0F);
		ViewerBottom3b = new ModelRenderer(this, 58, 18);
		ViewerBottom3b.addBox(0F, 0F, 0F, 4, 14, 1);
		ViewerBottom3b.setRotationPoint(-2F, 8F, -8F);
		ViewerBottom3b.setTextureSize(64, 64);
		ViewerBottom3b.mirror = true;
		setRotation(ViewerBottom3b, 0F, 0F, 0F);
		ViewerBottom3 = new ModelRenderer(this, 58, 18);
		ViewerBottom3.addBox(0F, 0F, 0F, 4, 14, 1);
		ViewerBottom3.setRotationPoint(2F, 8F, 8F);
		ViewerBottom3.setTextureSize(64, 64);
		ViewerBottom3.mirror = true;
		setRotation(ViewerBottom3, 0F, 3.141593F, 0F);
		ViewerBottom2 = new ModelRenderer(this, 42, 0);
		ViewerBottom2.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerBottom2.setRotationPoint(-3F, 8F, 7F);
		ViewerBottom2.setTextureSize(64, 64);
		ViewerBottom2.mirror = true;
		setRotation(ViewerBottom2, 0F, 0F, 0F);
		ViewerBottom1 = new ModelRenderer(this, 42, 0);
		ViewerBottom1.addBox(0F, 0F, 0F, 1, 15, 1);
		ViewerBottom1.setRotationPoint(2F, 8F, 7F);
		ViewerBottom1.setTextureSize(64, 64);
		ViewerBottom1.mirror = true;
		setRotation(ViewerBottom1, 0F, 0F, 0F);
		ViewerBottom4 = new ModelRenderer(this, 0, 4);
		ViewerBottom4.addBox(0F, 0F, 0F, 4, 1, 1);
		ViewerBottom4.setRotationPoint(-2F, 22F, 7F);
		ViewerBottom4.setTextureSize(64, 64);
		ViewerBottom4.mirror = true;
		setRotation(ViewerBottom4, 0F, 0F, 0F);

	}

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) {

		if (up == ConnectionState.CONNECTED && down == ConnectionState.CONNECTED)
			renderCenter(f);
		else if (up != ConnectionState.CONNECTED && down != ConnectionState.CONNECTED)
			renderSingle(f);
		else if (up != ConnectionState.CONNECTED && down == ConnectionState.CONNECTED)
			renderTop(f);
		else if (up == ConnectionState.CONNECTED && down != ConnectionState.CONNECTED)
			renderBottom(f);

		// TODO: connectors
	}

	private void renderBottom(float f5) {
		TankBottom.render(f5);
		Support2.render(f5);
		Support1.render(f5);
		ViewerBottom4b.render(f5);
		ViewerBottom1b.render(f5);
		ViewerBottom2b.render(f5);
		ViewerBottom3b.render(f5);
		ViewerBottom3.render(f5);
		ViewerBottom2.render(f5);
		ViewerBottom1.render(f5);
		ViewerBottom4.render(f5);
	}

	private void renderTop(float f5) {
		TankTop.render(f5);
		ViewerTop4b.render(f5);
		ViewerTop1b.render(f5);
		ViewerTop2b.render(f5);
		ViewerTop3b.render(f5);
		ViewerTop3.render(f5);
		ViewerTop2.render(f5);
		ViewerTop1.render(f5);
		ViewerTop4.render(f5);

	}

	private void renderSingle(float f5) {
		TankSingleTop.render(f5);
		Support2.render(f5);
		Support1.render(f5);
		ViewerSingle5b.render(f5);
		ViewerSingle1b.render(f5);
		ViewerSingle2b.render(f5);
		ViewerSingle3b.render(f5);
		ViewerSingle3.render(f5);
		ViewerSingle2.render(f5);
		ViewerSingle1.render(f5);
		ViewerSingle5.render(f5);
		TankSingleBottom.render(f5);
		ViewerSingle4b.render(f5);
		ViewerSingle4.render(f5);
	}

	private void renderCenter(float f5) {
		TankCenter.render(f5);
		ViewerCenter3b.render(f5);
		ViewerCenter2b.render(f5);
		ViewerCenter1b.render(f5);
		ViewerCenter3.render(f5);
		ViewerCenter2.render(f5);
		ViewerCenter1.render(f5);
	}

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
		if (tankSlot == 0) {
			int bottom = down == ConnectionState.CONNECTED ? 0 : 1;
			int top = up == ConnectionState.CONNECTED ? 0 : 1;

			float x = -7f;
			float z = -7f;
			float depth = (16 - bottom - top) * (1 - fluidPercentage);
			float y = 8 + top + depth;
			int w = 14;
			int h = 14;
			float yBot = 8 - bottom + 16; 
			Tessellator tessellator = Tessellator.instance;
			if (up == ConnectionState.CONNECTED || fluidPercentage < 1) {
				tessellator.startDrawingQuads();

				tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMinU(), (double) icon.getMinV());
				tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + 0) * f, (double) icon.getMaxU(), (double) icon.getMinV());
				tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h) * f, (double) icon.getMaxU(), (double) icon.getMaxV());
				tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h) * f, (double) icon.getMinU(), (double) icon.getMaxV());
				tessellator.draw();
			}
			float vOffset = (icon.getMaxV() - icon.getMinV()) * (1 - fluidPercentage);
			float uOffset = 4f / 16f * (icon.getMaxU() - icon.getMinU());
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV((double) (x + 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, (double) icon.getMinV() + vOffset);
			tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMinV() + vOffset);
			tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMaxV());
			tessellator.addVertexWithUV((double) (x + 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, (double) icon.getMaxV());
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (y) * f, (double) (z) * f, (double) icon.getMinU() + uOffset, (double) icon.getMinV() + vOffset);
			tessellator.addVertexWithUV((double) (x + 4) * f, (double) (y) * f, (double) (z) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMinV() + vOffset);
			tessellator.addVertexWithUV((double) (x + 4) * f, (double) (yBot) * f, (double) (z) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMaxV());
			tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (yBot) * f, (double) (z) * f, (double) icon.getMinU() + uOffset, (double) icon.getMaxV());
			tessellator.draw();

		}
	}

}
