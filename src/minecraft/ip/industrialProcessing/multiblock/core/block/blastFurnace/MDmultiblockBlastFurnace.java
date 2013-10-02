package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.client.render.ModelingMultiblock;

public class MDmultiblockBlastFurnace extends ModelingMultiblock {
	// fields
		ModelRenderer footBack;
		ModelRenderer panelLeft;
		ModelRenderer panelBottom;
		ModelRenderer footFront;
		ModelRenderer ouputLeft;
		ModelRenderer outputTop;
		ModelRenderer outputBottom;
		ModelRenderer ouputBottomExp;
		ModelRenderer outputRight;
		ModelRenderer panelTop;
		ModelRenderer panelRight;
		ModelRenderer panelFront;
		ModelRenderer panelBack;
		ModelRenderer outputBack;

		public MDmultiblockBlastFurnace() {
			textureWidth = 64;
			textureHeight = 64;

			footBack = new ModelRenderer(this, 28, 7);
			footBack.addBox(0F, 0F, 0F, 16, 2, 2);
			footBack.setRotationPoint(-8F, 22F, 6F);
			footBack.setTextureSize(64, 64);
			footBack.mirror = true;
			setRotation(footBack, 0F, 0F, 0F);
			panelLeft = new ModelRenderer(this, 0, 0);
			panelLeft.addBox(0F, 0F, 0F, 1, 13, 13);
			panelLeft.setRotationPoint(6F, 9F, -7F);
			panelLeft.setTextureSize(64, 64);
			panelLeft.mirror = true;
			setRotation(panelLeft, 0F, 0F, 0F);
			panelBottom = new ModelRenderer(this, 0, 49);
			panelBottom.addBox(0F, 0F, 0F, 12, 1, 14);
			panelBottom.setRotationPoint(-6F, 21F, -7F);
			panelBottom.setTextureSize(64, 64);
			panelBottom.mirror = true;
			setRotation(panelBottom, 0F, 0F, 0F);
			footFront = new ModelRenderer(this, 28, 8);
			footFront.addBox(0F, 0F, 0F, 16, 2, 2);
			footFront.setRotationPoint(-8F, 22F, -8F);
			footFront.setTextureSize(64, 64);
			footFront.mirror = true;
			setRotation(footFront, 0F, 0F, 0F);
			ouputLeft = new ModelRenderer(this, 0, 50);
			ouputLeft.addBox(0F, 0F, 0F, 1, 6, 6);
			ouputLeft.setRotationPoint(7F, 13F, -3F);
			ouputLeft.setTextureSize(64, 64);
			ouputLeft.mirror = true;
			setRotation(ouputLeft, 0F, 0F, 0F);
			outputTop = new ModelRenderer(this, 40, 0);
			outputTop.addBox(0F, 0F, 0F, 6, 1, 6);
			outputTop.setRotationPoint(-3F, 8F, -3F);
			outputTop.setTextureSize(64, 64);
			outputTop.mirror = true;
			setRotation(outputTop, 0F, 0F, 0F);
			outputBottom = new ModelRenderer(this, 28, 42);
			outputBottom.addBox(0F, 0F, 0F, 6, 1, 6);
			outputBottom.setRotationPoint(-3F, 23F, -3F);
			outputBottom.setTextureSize(64, 64);
			outputBottom.mirror = true;
			setRotation(outputBottom, 0F, 0F, 0F);
			ouputBottomExp = new ModelRenderer(this, 32, 12);
			ouputBottomExp.addBox(0F, 0F, 0F, 8, 1, 8);
			ouputBottomExp.setRotationPoint(-4F, 22F, -4F);
			ouputBottomExp.setTextureSize(64, 64);
			ouputBottomExp.mirror = true;
			setRotation(ouputBottomExp, 0F, 0F, 0F);
			outputRight = new ModelRenderer(this, 38, 50);
			outputRight.addBox(0F, 0F, 0F, 1, 6, 6);
			outputRight.setRotationPoint(-8F, 13F, -3F);
			outputRight.setTextureSize(64, 64);
			outputRight.mirror = true;
			setRotation(outputRight, 0F, 0F, 0F);
			panelTop = new ModelRenderer(this, 0, 49);
			panelTop.addBox(0F, 0F, 0F, 12, 1, 14);
			panelTop.setRotationPoint(-6F, 9F, -7F);
			panelTop.setTextureSize(64, 64);
			panelTop.mirror = true;
			setRotation(panelTop, 0F, 0F, 0F);
			panelRight = new ModelRenderer(this, 0, 23);
			panelRight.addBox(0F, 0F, 0F, 1, 13, 13);
			panelRight.setRotationPoint(-7F, 9F, -7F);
			panelRight.setTextureSize(64, 64);
			panelRight.mirror = true;
			setRotation(panelRight, 0F, 0F, 0F);
			panelFront = new ModelRenderer(this, 38, 21);
			panelFront.addBox(0F, 0F, 0F, 12, 11, 1);
			panelFront.setRotationPoint(-6F, 10F, -7F);
			panelFront.setTextureSize(64, 64);
			panelFront.mirror = true;
			setRotation(panelFront, 0F, 0F, 0F);
			panelBack = new ModelRenderer(this, 38, 33);
			panelBack.addBox(0F, 0F, 0F, 12, 11, 1);
			panelBack.setRotationPoint(-6F, 10F, 6F);
			panelBack.setTextureSize(64, 64);
			panelBack.mirror = true;
			setRotation(panelBack, 0F, 0F, 0F);
			outputBack = new ModelRenderer(this, 50, 49);
			outputBack.addBox(0F, 0F, 0F, 6, 6, 1);
			outputBack.setRotationPoint(-3F, 13F, 7F);
			outputBack.setTextureSize(64, 64);
			outputBack.mirror = true;
			setRotation(outputBack, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			footBack.render(f5);
			panelLeft.render(f5);
			panelBottom.render(f5);
			footFront.render(f5);
			ouputLeft.render(f5);
			outputTop.render(f5);
			outputBottom.render(f5);
			ouputBottomExp.render(f5);
			outputRight.render(f5);
			panelTop.render(f5);
			panelRight.render(f5);
			panelFront.render(f5);
			panelBack.render(f5);
			outputBack.render(f5);
		}

		
		public void renderModel(float f5, int connection) {
			
			footBack.render(f5);
			panelLeft.render(f5);
			panelBottom.render(f5);
			footFront.render(f5);
			ouputLeft.render(f5);
			outputTop.render(f5);
			outputBottom.render(f5);
			ouputBottomExp.render(f5);
			outputRight.render(f5);
			panelTop.render(f5);
			panelRight.render(f5);
			panelFront.render(f5);
			panelBack.render(f5);
			outputBack.render(f5);
		}

		@Override
		public void renderModel(TileEntity tileEntity, float f5) {
			footBack.render(f5);
			panelLeft.render(f5);
			panelBottom.render(f5);
			footFront.render(f5);
			ouputLeft.render(f5);
			outputTop.render(f5);
			outputBottom.render(f5);
			ouputBottomExp.render(f5);
			outputRight.render(f5);
			panelTop.render(f5);
			panelRight.render(f5);
			panelFront.render(f5);
			panelBack.render(f5);
			outputBack.render(f5);
		}
}
