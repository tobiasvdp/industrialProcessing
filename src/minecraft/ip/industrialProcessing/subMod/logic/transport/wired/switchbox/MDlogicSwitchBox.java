package ip.industrialProcessing.subMod.logic.transport.wired.switchbox;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.subMod.logic.client.ModelLogic;
import ip.industrialProcessing.subMod.logic.utils.UTBuffer;

public class MDlogicSwitchBox extends ModelLogic {
	// fields
	ModelRenderer Base;
	ModelRenderer Right1;
	ModelRenderer Right2;
	ModelRenderer Left1;
	ModelRenderer Left2;
	ModelRenderer Back1;
	ModelRenderer Back2;
	ModelRenderer Front1;
	ModelRenderer Front2;
	ModelRenderer Base2;
	ModelRenderer FrontLightConnected;
	ModelRenderer FrontLightValid;
	ModelRenderer FrontLightActivity;
	ModelRenderer RightLightConnected;
	ModelRenderer BackLightConnected;
	ModelRenderer LeftLightConnected;
	ModelRenderer RightLightValid;
	ModelRenderer BackLightValid;
	ModelRenderer LeftLightValid;
	ModelRenderer RightLightActivity;
	ModelRenderer BackLightActivity;
	ModelRenderer LeftLightActivity;
	private Entity entity;

	public MDlogicSwitchBox() {
		textureWidth = 64;
		textureHeight = 64;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(-5F, 5F, -5F, 10, 3, 10);
		Base.setRotationPoint(0F, 16F, 0F);
		Base.setTextureSize(64, 64);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Right1 = new ModelRenderer(this, 0, 0);
		Right1.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		Right1.setRotationPoint(0F, 16F, 0F);
		Right1.setTextureSize(64, 64);
		Right1.mirror = true;
		setRotation(Right1, 0F, 0F, 0F);
		Right2 = new ModelRenderer(this, 0, 0);
		Right2.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		Right2.setRotationPoint(0F, 16F, 0F);
		Right2.setTextureSize(64, 64);
		Right2.mirror = true;
		setRotation(Right2, 0F, 0F, 0F);
		Left1 = new ModelRenderer(this, 0, 0);
		Left1.addBox(4.5F, 6.5F, -1.5F, 1, 1, 3);
		Left1.setRotationPoint(0F, 16F, 0F);
		Left1.setTextureSize(64, 64);
		Left1.mirror = true;
		setRotation(Left1, 0F, 0F, 0F);
		Left2 = new ModelRenderer(this, 0, 0);
		Left2.addBox(4.5F, 7F, -1.5F, 1, 1, 3);
		Left2.setRotationPoint(0F, 16F, 0F);
		Left2.setTextureSize(64, 64);
		Left2.mirror = true;
		setRotation(Left2, 0F, 0F, 0F);
		Back1 = new ModelRenderer(this, 0, 0);
		Back1.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		Back1.setRotationPoint(0F, 16F, 0F);
		Back1.setTextureSize(64, 64);
		Back1.mirror = true;
		setRotation(Back1, 0F, 1.570796F, 0F);
		Back2 = new ModelRenderer(this, 0, 0);
		Back2.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		Back2.setRotationPoint(0F, 16F, 0F);
		Back2.setTextureSize(64, 64);
		Back2.mirror = true;
		setRotation(Back2, 0F, 1.570796F, 0F);
		Front1 = new ModelRenderer(this, 0, 0);
		Front1.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		Front1.setRotationPoint(0F, 16F, 0F);
		Front1.setTextureSize(64, 64);
		Front1.mirror = true;
		setRotation(Front1, 0F, -1.570796F, 0F);
		Front2 = new ModelRenderer(this, 0, 0);
		Front2.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		Front2.setRotationPoint(0F, 16F, 0F);
		Front2.setTextureSize(64, 64);
		Front2.mirror = true;
		setRotation(Front2, 0F, -1.570796F, 0F);
		Base2 = new ModelRenderer(this, 0, 21);
		Base2.addBox(-4.5F, 2F, -4.5F, 9, 3, 9);
		Base2.setRotationPoint(0F, 16F, 0F);
		Base2.setTextureSize(64, 64);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		FrontLightConnected = new ModelRenderer(this, 0, 13);
		FrontLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		FrontLightConnected.setRotationPoint(0F, 16F, 0F);
		FrontLightConnected.setTextureSize(64, 64);
		FrontLightConnected.mirror = true;
		setRotation(FrontLightConnected, 0F, 0F, 0F);
		FrontLightValid = new ModelRenderer(this, 4, 13);
		FrontLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		FrontLightValid.setRotationPoint(0F, 16F, 0F);
		FrontLightValid.setTextureSize(64, 64);
		FrontLightValid.mirror = true;
		setRotation(FrontLightValid, 0F, 0F, 0F);
		FrontLightActivity = new ModelRenderer(this, 8, 13);
		FrontLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		FrontLightActivity.setRotationPoint(0F, 16F, 0F);
		FrontLightActivity.setTextureSize(64, 64);
		FrontLightActivity.mirror = true;
		setRotation(FrontLightActivity, 0F, 0F, 0F);
		RightLightConnected = new ModelRenderer(this, 0, 15);
		RightLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		RightLightConnected.setRotationPoint(0F, 16F, 0F);
		RightLightConnected.setTextureSize(64, 64);
		RightLightConnected.mirror = true;
		setRotation(RightLightConnected, 0F, 1.570796F, 0F);
		BackLightConnected = new ModelRenderer(this, 0, 17);
		BackLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		BackLightConnected.setRotationPoint(0F, 16F, 0F);
		BackLightConnected.setTextureSize(64, 64);
		BackLightConnected.mirror = true;
		setRotation(BackLightConnected, 0F, 3.141593F, 0F);
		LeftLightConnected = new ModelRenderer(this, 0, 19);
		LeftLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		LeftLightConnected.setRotationPoint(0F, 16F, 0F);
		LeftLightConnected.setTextureSize(64, 64);
		LeftLightConnected.mirror = true;
		setRotation(LeftLightConnected, 0F, -1.570796F, 0F);
		RightLightValid = new ModelRenderer(this, 4, 15);
		RightLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		RightLightValid.setRotationPoint(0F, 16F, 0F);
		RightLightValid.setTextureSize(64, 64);
		RightLightValid.mirror = true;
		setRotation(RightLightValid, 0F, 1.570796F, 0F);
		BackLightValid = new ModelRenderer(this, 4, 17);
		BackLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		BackLightValid.setRotationPoint(0F, 16F, 0F);
		BackLightValid.setTextureSize(64, 64);
		BackLightValid.mirror = true;
		setRotation(BackLightValid, 0F, 3.141593F, 0F);
		LeftLightValid = new ModelRenderer(this, 4, 19);
		LeftLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		LeftLightValid.setRotationPoint(0F, 16F, 0F);
		LeftLightValid.setTextureSize(64, 64);
		LeftLightValid.mirror = true;
		setRotation(LeftLightValid, 0F, -1.570796F, 0F);
		RightLightActivity = new ModelRenderer(this, 8, 15);
		RightLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		RightLightActivity.setRotationPoint(0F, 16F, 0F);
		RightLightActivity.setTextureSize(64, 64);
		RightLightActivity.mirror = true;
		setRotation(RightLightActivity, 0F, 1.570796F, 0F);
		BackLightActivity = new ModelRenderer(this, 8, 17);
		BackLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		BackLightActivity.setRotationPoint(0F, 16F, 0F);
		BackLightActivity.setTextureSize(64, 64);
		BackLightActivity.mirror = true;
		setRotation(BackLightActivity, 0F, 3.141593F, 0F);
		LeftLightActivity = new ModelRenderer(this, 8, 19);
		LeftLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		LeftLightActivity.setRotationPoint(0F, 16F, 0F);
		LeftLightActivity.setTextureSize(64, 64);
		LeftLightActivity.mirror = true;
		setRotation(LeftLightActivity, 0F, -1.570796F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Base.render(f5);
		Right1.render(f5);
		Right2.render(f5);
		Left1.render(f5);
		Left2.render(f5);
		Back1.render(f5);
		Back2.render(f5);
		Front1.render(f5);
		Front2.render(f5);
		Base2.render(f5);
		FrontLightConnected.render(f5);
		FrontLightValid.render(f5);
		FrontLightActivity.render(f5);
		RightLightConnected.render(f5);
		BackLightConnected.render(f5);
		LeftLightConnected.render(f5);
		RightLightValid.render(f5);
		BackLightValid.render(f5);
		LeftLightValid.render(f5);
		RightLightActivity.render(f5);
		BackLightActivity.render(f5);
		LeftLightActivity.render(f5);
		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(float f5, boolean side[], boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels) {
		GL11.glPushMatrix();
		for(int i =0;i<6;i++){
			if(side[i]){
				switch (i) {
				case 2:
					GL11.glTranslatef(0.0f, 1.0f, 0.0f);
					GL11.glRotatef(-90, 1.0f, 0.0f, 0.0f);
					GL11.glTranslatef(0.0f, -1.0f, 0.0f);
					break;
				case 3:
					GL11.glTranslatef(0.0f, 1.0f, 0.0f);
					GL11.glRotatef(90, 1.0f, 0.0f, 0.0f);
					GL11.glTranslatef(0.0f, -1.0f, 0.0f);

					break;
				case 4:
					GL11.glTranslatef(0.0f, 1.0f, 0.0f);
					GL11.glRotatef(-90, 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, -1.0f, 0.0f);
					break;
				case 5:
					GL11.glTranslatef(0.0f, 1.0f, 0.0f);
					GL11.glRotatef(90, 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, -1.0f, 0.0f);
					break;
				case 0:
					GL11.glTranslatef(0.0f, 1.0f, 0.0f);
					GL11.glRotatef(180, 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, -1.0f, 0.0f);
					break;
				case 1:
					Right1.render(f5);
					Right2.render(f5);
					Left1.render(f5);
					Left2.render(f5);
					Back1.render(f5);
					Back2.render(f5);
					Front1.render(f5);
					Front2.render(f5);
					break;
				default:
					break;
				}
			}
		}
		Base.render(f5);
		Base2.render(f5);
		FrontLightConnected.render(f5);
		FrontLightValid.render(f5);
		FrontLightActivity.render(f5);
		RightLightConnected.render(f5);
		BackLightConnected.render(f5);
		LeftLightConnected.render(f5);
		RightLightValid.render(f5);
		BackLightValid.render(f5);
		LeftLightValid.render(f5);
		RightLightActivity.render(f5);
		BackLightActivity.render(f5);
		LeftLightActivity.render(f5);
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		Base.render(f5);
		Right1.render(f5);
		Right2.render(f5);
		Left1.render(f5);
		Left2.render(f5);
		Back1.render(f5);
		Back2.render(f5);
		Front1.render(f5);
		Front2.render(f5);
		Base2.render(f5);
		FrontLightConnected.render(f5);
		FrontLightValid.render(f5);
		FrontLightActivity.render(f5);
		RightLightConnected.render(f5);
		BackLightConnected.render(f5);
		LeftLightConnected.render(f5);
		RightLightValid.render(f5);
		BackLightValid.render(f5);
		LeftLightValid.render(f5);
		RightLightActivity.render(f5);
		BackLightActivity.render(f5);
		LeftLightActivity.render(f5);
	}

}
