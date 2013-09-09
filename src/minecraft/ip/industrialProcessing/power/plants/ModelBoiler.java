package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;

public class ModelBoiler extends ModelAnimatedFluidMachine {

	// fields
	ModelRenderer BackPlate;
	ModelRenderer TopPlate;
	ModelRenderer BottomPlate;
	ModelRenderer LeftPlate;
	ModelRenderer Tube1;
	ModelRenderer Tube2;
	ModelRenderer Tube3;
	ModelRenderer Tube4;
	ModelRenderer Tube5;
	ModelRenderer Tube6;
	ModelRenderer Tube7;
	ModelRenderer FrontPlateLeft;
	ModelRenderer Tube8;
	ModelRenderer Tube9;
	ModelRenderer Tube10;
	ModelRenderer Tube11;
	ModelRenderer Tube12;
	ModelRenderer Tube13;
	ModelRenderer Tube14;
	ModelRenderer Tube15;
	ModelRenderer Tube16;
	ModelRenderer Tube17;
	ModelRenderer Tube18;
	ModelRenderer Tube19;
	ModelRenderer Tube20;
	ModelRenderer Tube21;
	ModelRenderer Tube22;
	ModelRenderer RightPlate;
	ModelRenderer FrontGaugeBottom;
	ModelRenderer FrontPlateRight;
	ModelRenderer FrontGaugeGlass;
	ModelRenderer FrontGaugeTop;
	ModelRenderer WaterIn;
	ModelRenderer SteamOut;

	public ModelBoiler() {
		textureWidth = 64;
		textureHeight = 32;

		BackPlate = new ModelRenderer(this, 0, 13);
		BackPlate.addBox(-6F, -7F, 0F, 12, 13, 1);
		BackPlate.setRotationPoint(-6F, 16F, 0F);
		BackPlate.setTextureSize(64, 32);
		BackPlate.mirror = true;
		setRotation(BackPlate, 3.141593F, 1.570796F, 0F);
		TopPlate = new ModelRenderer(this, 0, 0);
		TopPlate.addBox(-6F, -6F, 0F, 12, 12, 1);
		TopPlate.setRotationPoint(0F, 9F, 0F);
		TopPlate.setTextureSize(64, 32);
		TopPlate.mirror = true;
		setRotation(TopPlate, -1.570796F, 0F, 0F);
		BottomPlate = new ModelRenderer(this, 0, 0);
		BottomPlate.addBox(-6F, -6F, 0F, 12, 12, 1);
		BottomPlate.setRotationPoint(0F, 24F, 0F);
		BottomPlate.setTextureSize(64, 32);
		BottomPlate.mirror = true;
		setRotation(BottomPlate, 1.570796F, 0F, 0F);
		LeftPlate = new ModelRenderer(this, 0, 13);
		LeftPlate.addBox(-6F, -7F, 0F, 12, 13, 1);
		LeftPlate.setRotationPoint(0F, 17F, 6F);
		LeftPlate.setTextureSize(64, 32);
		LeftPlate.mirror = true;
		setRotation(LeftPlate, 0F, 0F, 0F);
		Tube1 = new ModelRenderer(this, 26, 13);
		Tube1.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube1.setRotationPoint(-4F, 10F, -4F);
		Tube1.setTextureSize(64, 32);
		Tube1.mirror = true;
		setRotation(Tube1, 0F, 0F, 0F);
		Tube2 = new ModelRenderer(this, 26, 13);
		Tube2.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube2.setRotationPoint(-2F, 10F, 3F);
		Tube2.setTextureSize(64, 32);
		Tube2.mirror = true;
		setRotation(Tube2, 0F, 0F, 0F);
		Tube3 = new ModelRenderer(this, 26, 13);
		Tube3.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube3.setRotationPoint(-4F, 10F, 0F);
		Tube3.setTextureSize(64, 32);
		Tube3.mirror = true;
		setRotation(Tube3, 0F, 0F, 0F);
		Tube4 = new ModelRenderer(this, 26, 13);
		Tube4.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube4.setRotationPoint(-4F, 10F, 4F);
		Tube4.setTextureSize(64, 32);
		Tube4.mirror = true;
		setRotation(Tube4, 0F, 0F, 0F);
		Tube5 = new ModelRenderer(this, 26, 13);
		Tube5.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube5.setRotationPoint(-2F, 10F, -3F);
		Tube5.setTextureSize(64, 32);
		Tube5.mirror = true;
		setRotation(Tube5, 0F, 0F, 0F);
		Tube6 = new ModelRenderer(this, 26, 13);
		Tube6.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube6.setRotationPoint(-2F, 10F, 1F);
		Tube6.setTextureSize(64, 32);
		Tube6.mirror = true;
		setRotation(Tube6, 0F, 0F, 0F);
		Tube7 = new ModelRenderer(this, 26, 13);
		Tube7.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube7.setRotationPoint(-2F, 10F, -1F);
		Tube7.setTextureSize(64, 32);
		Tube7.mirror = true;
		setRotation(Tube7, 0F, 0F, 0F);
		FrontPlateLeft = new ModelRenderer(this, 30, 13);
		FrontPlateLeft.addBox(0F, 0F, 0F, 4, 13, 1);
		FrontPlateLeft.setRotationPoint(7F, 10F, 2F);
		FrontPlateLeft.setTextureSize(64, 32);
		FrontPlateLeft.mirror = true;
		setRotation(FrontPlateLeft, 0F, -1.570796F, 0F);
		Tube8 = new ModelRenderer(this, 26, 13);
		Tube8.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube8.setRotationPoint(4F, 10F, -4F);
		Tube8.setTextureSize(64, 32);
		Tube8.mirror = true;
		setRotation(Tube8, 0F, 0F, 0F);
		Tube9 = new ModelRenderer(this, 26, 13);
		Tube9.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube9.setRotationPoint(4F, 10F, 4F);
		Tube9.setTextureSize(64, 32);
		Tube9.mirror = true;
		setRotation(Tube9, 0F, 0F, 0F);
		Tube10 = new ModelRenderer(this, 26, 13);
		Tube10.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube10.setRotationPoint(0F, 10F, -4F);
		Tube10.setTextureSize(64, 32);
		Tube10.mirror = true;
		setRotation(Tube10, 0F, 0F, 0F);
		Tube11 = new ModelRenderer(this, 26, 13);
		Tube11.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube11.setRotationPoint(4F, 10F, -2F);
		Tube11.setTextureSize(64, 32);
		Tube11.mirror = true;
		setRotation(Tube11, 0F, 0F, 0F);
		Tube12 = new ModelRenderer(this, 26, 13);
		Tube12.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube12.setRotationPoint(4F, 10F, 2F);
		Tube12.setTextureSize(64, 32);
		Tube12.mirror = true;
		setRotation(Tube12, 0F, 0F, 0F);
		Tube13 = new ModelRenderer(this, 26, 13);
		Tube13.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube13.setRotationPoint(-4F, 10F, -2F);
		Tube13.setTextureSize(64, 32);
		Tube13.mirror = true;
		setRotation(Tube13, 0F, 0F, 0F);
		Tube14 = new ModelRenderer(this, 26, 13);
		Tube14.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube14.setRotationPoint(-4F, 10F, 2F);
		Tube14.setTextureSize(64, 32);
		Tube14.mirror = true;
		setRotation(Tube14, 0F, 0F, 0F);
		Tube15 = new ModelRenderer(this, 26, 13);
		Tube15.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube15.setRotationPoint(2F, 10F, 3F);
		Tube15.setTextureSize(64, 32);
		Tube15.mirror = true;
		setRotation(Tube15, 0F, 0F, 0F);
		Tube16 = new ModelRenderer(this, 26, 13);
		Tube16.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube16.setRotationPoint(2F, 10F, 1F);
		Tube16.setTextureSize(64, 32);
		Tube16.mirror = true;
		setRotation(Tube16, 0F, 0F, 0F);
		Tube17 = new ModelRenderer(this, 26, 13);
		Tube17.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube17.setRotationPoint(2F, 10F, -1F);
		Tube17.setTextureSize(64, 32);
		Tube17.mirror = true;
		setRotation(Tube17, 0F, 0F, 0F);
		Tube18 = new ModelRenderer(this, 26, 13);
		Tube18.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube18.setRotationPoint(2F, 10F, -3F);
		Tube18.setTextureSize(64, 32);
		Tube18.mirror = true;
		setRotation(Tube18, 0F, 0F, 0F);
		Tube19 = new ModelRenderer(this, 26, 13);
		Tube19.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube19.setRotationPoint(0F, 10F, 4F);
		Tube19.setTextureSize(64, 32);
		Tube19.mirror = true;
		setRotation(Tube19, 0F, 0F, 0F);
		Tube20 = new ModelRenderer(this, 26, 13);
		Tube20.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube20.setRotationPoint(0F, 10F, 2F);
		Tube20.setTextureSize(64, 32);
		Tube20.mirror = true;
		setRotation(Tube20, 0F, 0F, 0F);
		Tube21 = new ModelRenderer(this, 26, 13);
		Tube21.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube21.setRotationPoint(0F, 10F, 0F);
		Tube21.setTextureSize(64, 32);
		Tube21.mirror = true;
		setRotation(Tube21, 0F, 0F, 0F);
		Tube22 = new ModelRenderer(this, 26, 13);
		Tube22.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
		Tube22.setRotationPoint(0F, 10F, -2F);
		Tube22.setTextureSize(64, 32);
		Tube22.mirror = true;
		setRotation(Tube22, 0F, 0F, 0F);
		RightPlate = new ModelRenderer(this, 0, 13);
		RightPlate.addBox(-6F, -7F, 0F, 12, 13, 1);
		RightPlate.setRotationPoint(0F, 16F, -6F);
		RightPlate.setTextureSize(64, 32);
		RightPlate.mirror = true;
		setRotation(RightPlate, 3.141593F, 0F, 0F);
		FrontGaugeBottom = new ModelRenderer(this, 30, 27);
		FrontGaugeBottom.addBox(0F, 0F, 0F, 4, 1, 1);
		FrontGaugeBottom.setRotationPoint(6F, 22F, 2F);
		FrontGaugeBottom.setTextureSize(64, 32);
		FrontGaugeBottom.mirror = true;
		setRotation(FrontGaugeBottom, 0F, 1.570796F, 0F);
		FrontPlateRight = new ModelRenderer(this, 30, 13);
		FrontPlateRight.addBox(0F, 0F, 0F, 4, 13, 1);
		FrontPlateRight.setRotationPoint(6F, 10F, -2F);
		FrontPlateRight.setTextureSize(64, 32);
		FrontPlateRight.mirror = true;
		setRotation(FrontPlateRight, 0F, 1.570796F, 0F);
		FrontGaugeGlass = new ModelRenderer(this, 30, 0);
		FrontGaugeGlass.addBox(0F, 0F, 0F, 4, 11, 1);
		FrontGaugeGlass.setRotationPoint(6F, 11F, 2F);
		FrontGaugeGlass.setTextureSize(64, 32);
		FrontGaugeGlass.mirror = true;
		setRotation(FrontGaugeGlass, 0F, 1.570796F, 0F);
		FrontGaugeTop = new ModelRenderer(this, 30, 27);
		FrontGaugeTop.addBox(0F, 0F, 0F, 4, 1, 1);
		FrontGaugeTop.setRotationPoint(6F, 10F, 2F);
		FrontGaugeTop.setTextureSize(64, 32);
		FrontGaugeTop.mirror = true;
		setRotation(FrontGaugeTop, 0F, 1.570796F, 0F);
		WaterIn = new ModelRenderer(this, 40, 0);
		WaterIn.addBox(-3F, -3F, 0F, 6, 6, 1);
		WaterIn.setRotationPoint(-7F, 16F, 0F);
		WaterIn.setTextureSize(64, 32);
		WaterIn.mirror = true;
		setRotation(WaterIn, 0F, -1.570796F, 0F);
		SteamOut = new ModelRenderer(this, 40, 7);
		SteamOut.addBox(-3F, -3F, 0F, 6, 6, 1);
		SteamOut.setRotationPoint(0F, 9F, 0F);
		SteamOut.setTextureSize(64, 32);
		SteamOut.mirror = true;
		setRotation(SteamOut, 1.570796F, 1.570796F, 0F);
	}

	@Override
	public void renderLiquid(float f, int tankSlot, float percentageFilled, Icon icon) {
		float par1 = -6f;
		float par2 = tankSlot == 0 ? -6f : 6f;
		
		float height = 13f / 2 * percentageFilled ;
		//float par3 = tankSlot == 0 ? 23 - 13/2 + height : 10f + height;
		
		float par3 = tankSlot == 0 ? 23 - height : 10 + height;
		
		int par4 = 12;
		int par5 = tankSlot == 0 ? 12 : -12;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();

		tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + 0) * f, (double) icon.getMinU(), (double) icon.getMinV());
		tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + 0) * f, (double) icon.getMaxU(), (double) icon.getMinV());
		tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + par5) * f, (double) icon.getMaxU(), (double) icon.getMaxV());
		tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + par5) * f, (double) icon.getMinU(), (double) icon.getMaxV());
		tessellator.draw();
		
		if(tankSlot == 1)
			height = -height;
		
		
		float offsetV = percentageFilled * (icon.getMaxV() - icon.getMinV());
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + 0) * f, (double) icon.getMinU(), (double) icon.getMinV()+offsetV);
		tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) (par3 + height) * f, (double) (par2 + 0) * f, (double) icon.getMaxU(), (double) icon.getMinV()+offsetV);
		tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) (par3 + height) * f, (double) (par2 + par5) * f, (double) icon.getMaxU(), (double) icon.getMaxV());
		tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + par5) * f, (double) icon.getMinU(), (double) icon.getMaxV());
		tessellator.draw();
	}

	@Override
	public void renderModelAnimated(float f5, float[] progress) {

		BackPlate.render(f5);
		TopPlate.render(f5);
		BottomPlate.render(f5);
		LeftPlate.render(f5);
		Tube1.render(f5);
		Tube2.render(f5);
		Tube3.render(f5);
		Tube4.render(f5);
		Tube5.render(f5);
		Tube6.render(f5);
		Tube7.render(f5);
		FrontPlateLeft.render(f5);
		Tube8.render(f5);
		Tube9.render(f5);
		Tube10.render(f5);
		Tube11.render(f5);
		Tube12.render(f5);
		Tube13.render(f5);
		Tube14.render(f5);
		Tube15.render(f5);
		Tube16.render(f5);
		Tube17.render(f5);
		Tube18.render(f5);
		Tube19.render(f5);
		Tube20.render(f5);
		Tube21.render(f5);
		Tube22.render(f5);
		RightPlate.render(f5);
		FrontGaugeBottom.render(f5);
		FrontPlateRight.render(f5);
		FrontGaugeGlass.render(f5);
		FrontGaugeTop.render(f5);
		WaterIn.render(f5);
		SteamOut.render(f5);
	}

	@Override
	public void renderModel(float f) {
		renderModelAnimated(f, null);
	}

}
