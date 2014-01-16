package ip.industrialProcessing.machines.classifier;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class ModelClassifier extends ModelAnimatedFluidMachine {

	// fields
	ModelRenderer Support1;
	ModelRenderer Support2;
	ModelRenderer TiltedPlate;
	ModelRenderer SideBack;
	ModelRenderer BottomPlate;
	ModelRenderer SideRight;
	ModelRenderer SideFront;
	ModelRenderer SideLeft;
	ModelRenderer ConnectorBottom;
	ModelRenderer ConnectorTop;
	ModelRenderer ConnectorBack;
	ModelRenderer ConnectorFront;
	ModelRenderer ConnectorLeft;
	ModelRenderer SupportTop2;
	ModelRenderer ClassifierMover;
	ModelRenderer SupportTop1;
	ModelRenderer SupportTop8;
	ModelRenderer SupportTop5;
	ModelRenderer SupportTop4;
	ModelRenderer SupportTop3;
	ModelRenderer SupportTop6;
	ModelRenderer SupportTop7;
	ModelRenderer ConnectorRight;

	public ModelClassifier() {
		textureWidth = 64;
		textureHeight = 32;

		Support1 = new ModelRenderer(this, 0, 0);
		Support1.addBox(0F, 0F, 0F, 2, 16, 2);
		Support1.setRotationPoint(-8F, 24F, 6F);
		Support1.setTextureSize(64, 32);
		Support1.mirror = true;
		setRotation(Support1, 0F, 0F, -1.570796F);
		Support2 = new ModelRenderer(this, 0, 0);
		Support2.addBox(0F, 0F, 0F, 2, 16, 2);
		Support2.setRotationPoint(-8F, 24F, -8F);
		Support2.setTextureSize(64, 32);
		Support2.mirror = true;
		setRotation(Support2, 0F, 0F, -1.570796F);
		TiltedPlate = new ModelRenderer(this, 38, 0);
		TiltedPlate.addBox(-6F, -7F, 0F, 12, 13, 1);
		TiltedPlate.setRotationPoint(0F, 19F, 0F);
		TiltedPlate.setTextureSize(64, 32);
		TiltedPlate.mirror = true;
		setRotation(TiltedPlate, 1.22173F, 0F, 0F);
		SideBack = new ModelRenderer(this, 8, 0);
		SideBack.addBox(-7F, -7F, 0F, 14, 10, 1);
		SideBack.setRotationPoint(0F, 19F, 7F);
		SideBack.setTextureSize(64, 32);
		SideBack.mirror = true;
		setRotation(SideBack, 0F, 3.141593F, 0F);
		BottomPlate = new ModelRenderer(this, 12, 11);
		BottomPlate.addBox(-6F, -6F, 0F, 12, 12, 1);
		BottomPlate.setRotationPoint(0F, 23F, 0F);
		BottomPlate.setTextureSize(64, 32);
		BottomPlate.mirror = true;
		setRotation(BottomPlate, 1.570796F, 0F, 0F);
		SideRight = new ModelRenderer(this, 38, 14);
		SideRight.addBox(-6F, -7F, 0F, 12, 10, 1);
		SideRight.setRotationPoint(-7F, 19F, 0F);
		SideRight.setTextureSize(64, 32);
		SideRight.mirror = true;
		setRotation(SideRight, 0F, 1.570796F, 0F);
		SideFront = new ModelRenderer(this, 8, 0);
		SideFront.addBox(-7F, -7F, 0F, 14, 10, 1);
		SideFront.setRotationPoint(0F, 19F, -7F);
		SideFront.setTextureSize(64, 32);
		SideFront.mirror = true;
		setRotation(SideFront, 0F, 0F, 0F);
		SideLeft = new ModelRenderer(this, 38, 14);
		SideLeft.addBox(-6F, -7F, 0F, 12, 10, 1);
		SideLeft.setRotationPoint(6F, 19F, 0F);
		SideLeft.setTextureSize(64, 32);
		SideLeft.mirror = true;
		setRotation(SideLeft, 0F, 1.570796F, 0F);
		ConnectorBottom = new ModelRenderer(this, 50, 25);
		ConnectorBottom.addBox(-3F, -3F, 0F, 6, 6, 1);
		ConnectorBottom.setRotationPoint(0F, 23F, 0F);
		ConnectorBottom.setTextureSize(64, 32);
		ConnectorBottom.mirror = true;
		setRotation(ConnectorBottom, -1.570796F, 0F, 0F);
		ConnectorTop = new ModelRenderer(this, 22, 25);
		ConnectorTop.addBox(-3F, -3F, 0F, 6, 6, 1);
		ConnectorTop.setRotationPoint(0F, 9F, 0F);
		ConnectorTop.setTextureSize(64, 32);
		ConnectorTop.mirror = true;
		setRotation(ConnectorTop, 1.570796F, 0F, 0F);
		ConnectorBack = new ModelRenderer(this, 22, 25);
		ConnectorBack.addBox(-3F, -3F, 0F, 6, 6, 1);
		ConnectorBack.setRotationPoint(0F, 16F, 7F);
		ConnectorBack.setTextureSize(64, 32);
		ConnectorBack.mirror = true;
		setRotation(ConnectorBack, 0F, 0F, 0F);
		ConnectorFront = new ModelRenderer(this, 22, 25);
		ConnectorFront.addBox(-3F, -3F, 0F, 6, 6, 1);
		ConnectorFront.setRotationPoint(0F, 16F, -8F);
		ConnectorFront.setTextureSize(64, 32);
		ConnectorFront.mirror = true;
		setRotation(ConnectorFront, 0F, 0F, 0F);
		ConnectorLeft = new ModelRenderer(this, 8, 25);
		ConnectorLeft.addBox(-3F, -3F, 0F, 6, 6, 1);
		ConnectorLeft.setRotationPoint(8F, 16F, 0F);
		ConnectorLeft.setTextureSize(64, 32);
		ConnectorLeft.mirror = true;
		setRotation(ConnectorLeft, 0F, -1.570796F, 0F);
		SupportTop2 = new ModelRenderer(this, 4, 18);
		SupportTop2.addBox(-0.5F, -6.5F, -0.5F, 1, 13, 1);
		SupportTop2.setRotationPoint(0F, 12F, -2F);
		SupportTop2.setTextureSize(64, 32);
		SupportTop2.mirror = true;
		setRotation(SupportTop2, 0F, 0F, 1.570796F);
		ClassifierMover = new ModelRenderer(this, 0, 19);
		ClassifierMover.addBox(-0.5F, -6F, -0.5F, 1, 12, 1);
		ClassifierMover.setRotationPoint(0F, 17F, 0F);
		ClassifierMover.setTextureSize(64, 32);
		ClassifierMover.mirror = true;
		setRotation(ClassifierMover, 0F, 0F, 1.570796F);
		SupportTop1 = new ModelRenderer(this, 4, 18);
		SupportTop1.addBox(-0.5F, -6.5F, -0.5F, 1, 13, 1);
		SupportTop1.setRotationPoint(0F, 12F, 2F);
		SupportTop1.setTextureSize(64, 32);
		SupportTop1.mirror = true;
		setRotation(SupportTop1, 0F, 0F, 1.570796F);
		SupportTop8 = new ModelRenderer(this, 4, 18);
		SupportTop8.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportTop8.setRotationPoint(-2.5F, 12.5F, -1.5F);
		SupportTop8.setTextureSize(64, 32);
		SupportTop8.mirror = true;
		setRotation(SupportTop8, 1.570796F, 0F, 0F);
		SupportTop5 = new ModelRenderer(this, 4, 18);
		SupportTop5.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportTop5.setRotationPoint(1.5F, 9F, 1.5F);
		SupportTop5.setTextureSize(64, 32);
		SupportTop5.mirror = true;
		setRotation(SupportTop5, 0F, 0F, 0F);
		SupportTop4 = new ModelRenderer(this, 4, 18);
		SupportTop4.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportTop4.setRotationPoint(-2.5F, 9F, 1.5F);
		SupportTop4.setTextureSize(64, 32);
		SupportTop4.mirror = true;
		setRotation(SupportTop4, 0F, 0F, 0F);
		SupportTop3 = new ModelRenderer(this, 4, 18);
		SupportTop3.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportTop3.setRotationPoint(-2.5F, 9F, -2.5F);
		SupportTop3.setTextureSize(64, 32);
		SupportTop3.mirror = true;
		setRotation(SupportTop3, 0F, 0F, 0F);
		SupportTop6 = new ModelRenderer(this, 4, 18);
		SupportTop6.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportTop6.setRotationPoint(1.5F, 9F, -2.5F);
		SupportTop6.setTextureSize(64, 32);
		SupportTop6.mirror = true;
		setRotation(SupportTop6, 0F, 0F, 0F);
		SupportTop7 = new ModelRenderer(this, 4, 18);
		SupportTop7.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportTop7.setRotationPoint(1.5F, 12.5F, -1.5F);
		SupportTop7.setTextureSize(64, 32);
		SupportTop7.mirror = true;
		setRotation(SupportTop7, 1.570796F, 0F, 0F);
		ConnectorRight = new ModelRenderer(this, 50, 25);
		ConnectorRight.addBox(-3F, -3F, 0F, 6, 6, 1);
		ConnectorRight.setRotationPoint(-7F, 16F, 0F);
		ConnectorRight.setTextureSize(64, 32);
		ConnectorRight.mirror = true;
		setRotation(ConnectorRight, 0F, -1.570796F, 0F);
	}

	@Override
	public void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon) {
		if (tankSlot == 0) {
			float par1 = -6.5f;
			float par2 = -6.5f;
			float par3 = 15f + 5f * (1 - percentageFilled);
			int par4 = 13;
			int par5 = 13;
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMinU(), icon.getMinV());
			tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMaxU(), icon.getMinV());
			tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMaxU(), icon.getMaxV());
			tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMinU(), icon.getMaxV());
			tessellator.draw();
		}
	}

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progress) {
		Support1.render(f5);
		Support2.render(f5);
		TiltedPlate.render(f5);
		SideBack.render(f5);
		BottomPlate.render(f5);
		SideRight.render(f5);
		SideFront.render(f5);
		SideLeft.render(f5);
		ConnectorBottom.render(f5);
		ConnectorTop.render(f5);
		ConnectorBack.render(f5);
		ConnectorFront.render(f5);
		ConnectorLeft.render(f5);
		SupportTop2.render(f5);
		ClassifierMover.render(f5);
		SupportTop1.render(f5);
		SupportTop8.render(f5);
		SupportTop5.render(f5);
		SupportTop4.render(f5);
		SupportTop3.render(f5);
		SupportTop6.render(f5);
		SupportTop7.render(f5);
		ConnectorRight.render(f5);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(tileEntity, f, null);
	}

}
