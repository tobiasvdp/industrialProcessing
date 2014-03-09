package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.api.rendering.ModelMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

public class ModelSolidBurner extends ModelTileEntity {

	// fields
	ModelRenderer Support2;
	ModelRenderer Support1;
	ModelRenderer Hull;
	ModelRenderer Input;
	ModelRenderer TopGrate1;
	ModelRenderer FrontGrate6;
	ModelRenderer FrontGrate7;
	ModelRenderer FrontGrate1;
	ModelRenderer FrontGrate2;
	ModelRenderer FrontGrate3;
	ModelRenderer FrontGrate4;
	ModelRenderer FrontGrate5;
	ModelRenderer FrontGrate8;
	ModelRenderer TopGrate7;
	ModelRenderer TopGrate8;
	ModelRenderer TopGrate6;
	ModelRenderer TopGrate5;
	ModelRenderer TopGrate4;
	ModelRenderer TopGrate3;
	ModelRenderer TopGrate2;

	public ModelSolidBurner() {
		textureWidth = 64;
		textureHeight = 32;

		Support2 = new ModelRenderer(this, 0, 0);
		Support2.addBox(0F, 0F, 0F, 16, 2, 2);
		Support2.setRotationPoint(-8F, 22F, -8F);
		Support2.setTextureSize(64, 32);
		Support2.mirror = true;
		setRotation(Support2, 0F, 0F, 0F);
		Support1 = new ModelRenderer(this, 0, 0);
		Support1.addBox(0F, 0F, 0F, 16, 2, 2);
		Support1.setRotationPoint(-8F, 22F, 6F);
		Support1.setTextureSize(64, 32);
		Support1.mirror = true;
		setRotation(Support1, 0F, 0F, 0F);
		Hull = new ModelRenderer(this, 0, 4);
		Hull.addBox(0F, 0F, 0F, 14, 14, 14);
		Hull.setRotationPoint(-7F, 8F, 7F);
		Hull.setTextureSize(64, 32);
		Hull.mirror = true;
		setRotation(Hull, -1.570796F, 0F, 0F);
		Input = new ModelRenderer(this, 0, 4);
		Input.addBox(0F, 0F, 0F, 6, 6, 1);
		Input.setRotationPoint(7F, 13F, 3F);
		Input.setTextureSize(64, 32);
		Input.mirror = true;
		setRotation(Input, 0F, 1.570796F, 0F);
		TopGrate1 = new ModelRenderer(this, 36, 2);
		TopGrate1.addBox(0F, 0.5F, 0F, 10, 1, 1);
		TopGrate1.setRotationPoint(-5F, 7F, -6F);
		TopGrate1.setTextureSize(64, 32);
		TopGrate1.mirror = true;
		setRotation(TopGrate1, 0F, 0F, 0F);
		FrontGrate6 = new ModelRenderer(this, 42, 4);
		FrontGrate6.addBox(0F, 0F, 0F, 1, 6, 1);
		FrontGrate6.setRotationPoint(-8F, 12F, -4.5F);
		FrontGrate6.setTextureSize(64, 32);
		FrontGrate6.mirror = true;
		setRotation(FrontGrate6, 0F, 1.570796F, 0F);
		FrontGrate7 = new ModelRenderer(this, 36, 2);
		FrontGrate7.addBox(0F, 0F, 0F, 11, 1, 1);
		FrontGrate7.setRotationPoint(-8F, 18F, 5.5F);
		FrontGrate7.setTextureSize(64, 32);
		FrontGrate7.mirror = true;
		setRotation(FrontGrate7, 0F, 1.570796F, 0F);
		FrontGrate1 = new ModelRenderer(this, 42, 4);
		FrontGrate1.addBox(0F, 0F, 0F, 1, 6, 1);
		FrontGrate1.setRotationPoint(-8F, 12F, 5.5F);
		FrontGrate1.setTextureSize(64, 32);
		FrontGrate1.mirror = true;
		setRotation(FrontGrate1, 0F, 1.570796F, 0F);
		FrontGrate2 = new ModelRenderer(this, 46, 4);
		FrontGrate2.addBox(0F, 0F, 0F, 1, 6, 1);
		FrontGrate2.setRotationPoint(-7.5F, 12F, 3.5F);
		FrontGrate2.setTextureSize(64, 32);
		FrontGrate2.mirror = true;
		setRotation(FrontGrate2, 0F, 1.570796F, 0F);
		FrontGrate3 = new ModelRenderer(this, 50, 4);
		FrontGrate3.addBox(0F, 0F, 0F, 1, 6, 1);
		FrontGrate3.setRotationPoint(-7.5F, 12F, 1.5F);
		FrontGrate3.setTextureSize(64, 32);
		FrontGrate3.mirror = true;
		setRotation(FrontGrate3, 0F, 1.570796F, 0F);
		FrontGrate4 = new ModelRenderer(this, 54, 4);
		FrontGrate4.addBox(0F, 0F, 0F, 1, 6, 1);
		FrontGrate4.setRotationPoint(-7.5F, 12F, -0.5F);
		FrontGrate4.setTextureSize(64, 32);
		FrontGrate4.mirror = true;
		setRotation(FrontGrate4, 0F, 1.570796F, 0F);
		FrontGrate5 = new ModelRenderer(this, 58, 4);
		FrontGrate5.addBox(0F, 0F, 0F, 1, 6, 1);
		FrontGrate5.setRotationPoint(-7.5F, 12F, -2.5F);
		FrontGrate5.setTextureSize(64, 32);
		FrontGrate5.mirror = true;
		setRotation(FrontGrate5, 0F, 1.570796F, 0F);
		FrontGrate8 = new ModelRenderer(this, 36, 2);
		FrontGrate8.addBox(0F, 0F, 0F, 11, 1, 1);
		FrontGrate8.setRotationPoint(-8F, 11F, 5.5F);
		FrontGrate8.setTextureSize(64, 32);
		FrontGrate8.mirror = true;
		setRotation(FrontGrate8, 0F, 1.570796F, 0F);
		TopGrate7 = new ModelRenderer(this, 36, 2);
		TopGrate7.addBox(0F, 0.5F, 0F, 12, 1, 1);
		TopGrate7.setRotationPoint(-6F, 7F, 6F);
		TopGrate7.setTextureSize(64, 32);
		TopGrate7.mirror = true;
		setRotation(TopGrate7, 0F, 1.570796F, 0F);
		TopGrate8 = new ModelRenderer(this, 36, 2);
		TopGrate8.addBox(0F, 0.5F, 0F, 12, 1, 1);
		TopGrate8.setRotationPoint(5F, 7F, 6F);
		TopGrate8.setTextureSize(64, 32);
		TopGrate8.mirror = true;
		setRotation(TopGrate8, 0F, 1.570796F, 0F);
		TopGrate6 = new ModelRenderer(this, 36, 2);
		TopGrate6.addBox(0F, 0.5F, 0F, 10, 1, 1);
		TopGrate6.setRotationPoint(-5F, 7F, 5F);
		TopGrate6.setTextureSize(64, 32);
		TopGrate6.mirror = true;
		setRotation(TopGrate6, 0F, 0F, 0F);
		TopGrate5 = new ModelRenderer(this, 36, 2);
		TopGrate5.addBox(0F, 0.5F, 0F, 10, 1, 1);
		TopGrate5.setRotationPoint(-5F, 7F, 3F);
		TopGrate5.setTextureSize(64, 32);
		TopGrate5.mirror = true;
		setRotation(TopGrate5, 0F, 0F, 0F);
		TopGrate4 = new ModelRenderer(this, 36, 2);
		TopGrate4.addBox(0F, 0.5F, 0F, 10, 1, 1);
		TopGrate4.setRotationPoint(-5F, 7F, 1F);
		TopGrate4.setTextureSize(64, 32);
		TopGrate4.mirror = true;
		setRotation(TopGrate4, 0F, 0F, 0F);
		TopGrate3 = new ModelRenderer(this, 36, 2);
		TopGrate3.addBox(0F, 0.5F, 0F, 10, 1, 1);
		TopGrate3.setRotationPoint(-5F, 7F, -2F);
		TopGrate3.setTextureSize(64, 32);
		TopGrate3.mirror = true;
		setRotation(TopGrate3, 0F, 0F, 0F);
		TopGrate2 = new ModelRenderer(this, 36, 2);
		TopGrate2.addBox(0F, 0.5F, 0F, 10, 1, 1);
		TopGrate2.setRotationPoint(-5F, 7F, -4F);
		TopGrate2.setTextureSize(64, 32);
		TopGrate2.mirror = true;
		setRotation(TopGrate2, 0F, 0F, 0F);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
	    Support2.render(f5);
	    Support1.render(f5);
	    Hull.render(f5);
	    Input.render(f5);
	    TopGrate1.render(f5);
	    FrontGrate6.render(f5);
	    FrontGrate7.render(f5);
	    FrontGrate1.render(f5);
	    FrontGrate2.render(f5);
	    FrontGrate3.render(f5);
	    FrontGrate4.render(f5);
	    FrontGrate5.render(f5);
	    FrontGrate8.render(f5);
	    TopGrate7.render(f5);
	    TopGrate8.render(f5);
	    TopGrate6.render(f5);
	    TopGrate5.render(f5);
	    TopGrate4.render(f5);
	    TopGrate3.render(f5);
	    TopGrate2.render(f5);
	}

}
