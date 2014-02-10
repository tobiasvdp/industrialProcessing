package ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox;

import ip.industrialProcessing.subMod.logic.client.ModelLogic;
import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

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
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(-5F, 5F, -5F, 10, 3, 10);
		this.Base.setRotationPoint(0F, 16F, 0F);
		this.Base.setTextureSize(64, 64);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);
		this.Right1 = new ModelRenderer(this, 0, 0);
		this.Right1.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		this.Right1.setRotationPoint(0F, 16F, 0F);
		this.Right1.setTextureSize(64, 64);
		this.Right1.mirror = true;
		this.setRotation(this.Right1, 0F, 0F, 0F);
		this.Right2 = new ModelRenderer(this, 0, 0);
		this.Right2.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Right2.setRotationPoint(0F, 16F, 0F);
		this.Right2.setTextureSize(64, 64);
		this.Right2.mirror = true;
		this.setRotation(this.Right2, 0F, 0F, 0F);
		this.Left1 = new ModelRenderer(this, 0, 0);
		this.Left1.addBox(4.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Left1.setRotationPoint(0F, 16F, 0F);
		this.Left1.setTextureSize(64, 64);
		this.Left1.mirror = true;
		this.setRotation(this.Left1, 0F, 0F, 0F);
		this.Left2 = new ModelRenderer(this, 0, 0);
		this.Left2.addBox(4.5F, 7F, -1.5F, 1, 1, 3);
		this.Left2.setRotationPoint(0F, 16F, 0F);
		this.Left2.setTextureSize(64, 64);
		this.Left2.mirror = true;
		this.setRotation(this.Left2, 0F, 0F, 0F);
		this.Back1 = new ModelRenderer(this, 0, 0);
		this.Back1.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Back1.setRotationPoint(0F, 16F, 0F);
		this.Back1.setTextureSize(64, 64);
		this.Back1.mirror = true;
		this.setRotation(this.Back1, 0F, 1.570796F, 0F);
		this.Back2 = new ModelRenderer(this, 0, 0);
		this.Back2.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		this.Back2.setRotationPoint(0F, 16F, 0F);
		this.Back2.setTextureSize(64, 64);
		this.Back2.mirror = true;
		this.setRotation(this.Back2, 0F, 1.570796F, 0F);
		this.Front1 = new ModelRenderer(this, 0, 0);
		this.Front1.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Front1.setRotationPoint(0F, 16F, 0F);
		this.Front1.setTextureSize(64, 64);
		this.Front1.mirror = true;
		this.setRotation(this.Front1, 0F, -1.570796F, 0F);
		this.Front2 = new ModelRenderer(this, 0, 0);
		this.Front2.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		this.Front2.setRotationPoint(0F, 16F, 0F);
		this.Front2.setTextureSize(64, 64);
		this.Front2.mirror = true;
		this.setRotation(this.Front2, 0F, -1.570796F, 0F);
		this.Base2 = new ModelRenderer(this, 0, 21);
		this.Base2.addBox(-4.5F, 2F, -4.5F, 9, 3, 9);
		this.Base2.setRotationPoint(0F, 16F, 0F);
		this.Base2.setTextureSize(64, 64);
		this.Base2.mirror = true;
		this.setRotation(this.Base2, 0F, 0F, 0F);
		this.FrontLightConnected = new ModelRenderer(this, 0, 13);
		this.FrontLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		this.FrontLightConnected.setRotationPoint(0F, 16F, 0F);
		this.FrontLightConnected.setTextureSize(64, 64);
		this.FrontLightConnected.mirror = true;
		this.setRotation(this.FrontLightConnected, 0F, 0F, 0F);
		this.FrontLightValid = new ModelRenderer(this, 4, 13);
		this.FrontLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		this.FrontLightValid.setRotationPoint(0F, 16F, 0F);
		this.FrontLightValid.setTextureSize(64, 64);
		this.FrontLightValid.mirror = true;
		this.setRotation(this.FrontLightValid, 0F, 0F, 0F);
		this.FrontLightActivity = new ModelRenderer(this, 8, 13);
		this.FrontLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		this.FrontLightActivity.setRotationPoint(0F, 16F, 0F);
		this.FrontLightActivity.setTextureSize(64, 64);
		this.FrontLightActivity.mirror = true;
		this.setRotation(this.FrontLightActivity, 0F, 0F, 0F);
		this.RightLightConnected = new ModelRenderer(this, 0, 15);
		this.RightLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		this.RightLightConnected.setRotationPoint(0F, 16F, 0F);
		this.RightLightConnected.setTextureSize(64, 64);
		this.RightLightConnected.mirror = true;
		this.setRotation(this.RightLightConnected, 0F, 1.570796F, 0F);
		this.BackLightConnected = new ModelRenderer(this, 0, 17);
		this.BackLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		this.BackLightConnected.setRotationPoint(0F, 16F, 0F);
		this.BackLightConnected.setTextureSize(64, 64);
		this.BackLightConnected.mirror = true;
		this.setRotation(this.BackLightConnected, 0F, 3.141593F, 0F);
		this.LeftLightConnected = new ModelRenderer(this, 0, 19);
		this.LeftLightConnected.addBox(-1.5F, 3F, -4.8F, 1, 1, 1);
		this.LeftLightConnected.setRotationPoint(0F, 16F, 0F);
		this.LeftLightConnected.setTextureSize(64, 64);
		this.LeftLightConnected.mirror = true;
		this.setRotation(this.LeftLightConnected, 0F, -1.570796F, 0F);
		this.RightLightValid = new ModelRenderer(this, 4, 15);
		this.RightLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		this.RightLightValid.setRotationPoint(0F, 16F, 0F);
		this.RightLightValid.setTextureSize(64, 64);
		this.RightLightValid.mirror = true;
		this.setRotation(this.RightLightValid, 0F, 1.570796F, 0F);
		this.BackLightValid = new ModelRenderer(this, 4, 17);
		this.BackLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		this.BackLightValid.setRotationPoint(0F, 16F, 0F);
		this.BackLightValid.setTextureSize(64, 64);
		this.BackLightValid.mirror = true;
		this.setRotation(this.BackLightValid, 0F, 3.141593F, 0F);
		this.LeftLightValid = new ModelRenderer(this, 4, 19);
		this.LeftLightValid.addBox(-0.5F, 3F, -4.8F, 1, 1, 1);
		this.LeftLightValid.setRotationPoint(0F, 16F, 0F);
		this.LeftLightValid.setTextureSize(64, 64);
		this.LeftLightValid.mirror = true;
		this.setRotation(this.LeftLightValid, 0F, -1.570796F, 0F);
		this.RightLightActivity = new ModelRenderer(this, 8, 15);
		this.RightLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		this.RightLightActivity.setRotationPoint(0F, 16F, 0F);
		this.RightLightActivity.setTextureSize(64, 64);
		this.RightLightActivity.mirror = true;
		this.setRotation(this.RightLightActivity, 0F, 1.570796F, 0F);
		this.BackLightActivity = new ModelRenderer(this, 8, 17);
		this.BackLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		this.BackLightActivity.setRotationPoint(0F, 16F, 0F);
		this.BackLightActivity.setTextureSize(64, 64);
		this.BackLightActivity.mirror = true;
		this.setRotation(this.BackLightActivity, 0F, 3.141593F, 0F);
		this.LeftLightActivity = new ModelRenderer(this, 8, 19);
		this.LeftLightActivity.addBox(0.5F, 3F, -4.8F, 1, 1, 1);
		this.LeftLightActivity.setRotationPoint(0F, 16F, 0F);
		this.LeftLightActivity.setTextureSize(64, 64);
		this.LeftLightActivity.mirror = true;
		this.setRotation(this.LeftLightActivity, 0F, -1.570796F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5);
		this.Base.render(f5);
		this.Right1.render(f5);
		this.Right2.render(f5);
		this.Left1.render(f5);
		this.Left2.render(f5);
		this.Back1.render(f5);
		this.Back2.render(f5);
		this.Front1.render(f5);
		this.Front2.render(f5);
		this.Base2.render(f5);
		this.FrontLightConnected.render(f5);
		this.FrontLightValid.render(f5);
		this.FrontLightActivity.render(f5);
		this.RightLightConnected.render(f5);
		this.BackLightConnected.render(f5);
		this.LeftLightConnected.render(f5);
		this.RightLightValid.render(f5);
		this.BackLightValid.render(f5);
		this.LeftLightValid.render(f5);
		this.RightLightActivity.render(f5);
		this.BackLightActivity.render(f5);
		this.LeftLightActivity.render(f5);
		this.entity = entity;
	}

	@Override
	public void renderModel(float f5, boolean side[], boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels) {
		GL11.glPushMatrix();
		for (int i = 0; i < 6; i++) {
			if (side[i]) {
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
					this.Right1.render(f5);
					this.Right2.render(f5);
					this.Left1.render(f5);
					this.Left2.render(f5);
					this.Back1.render(f5);
					this.Back2.render(f5);
					this.Front1.render(f5);
					this.Front2.render(f5);
					break;
				default:
					break;
				}
			}
		}
		this.Base.render(f5);
		this.Base2.render(f5);
		this.FrontLightConnected.render(f5);
		this.FrontLightValid.render(f5);
		this.FrontLightActivity.render(f5);
		this.RightLightConnected.render(f5);
		this.BackLightConnected.render(f5);
		this.LeftLightConnected.render(f5);
		this.RightLightValid.render(f5);
		this.BackLightValid.render(f5);
		this.LeftLightValid.render(f5);
		this.RightLightActivity.render(f5);
		this.BackLightActivity.render(f5);
		this.LeftLightActivity.render(f5);
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		this.Base.render(f5);
		this.Right1.render(f5);
		this.Right2.render(f5);
		this.Left1.render(f5);
		this.Left2.render(f5);
		this.Back1.render(f5);
		this.Back2.render(f5);
		this.Front1.render(f5);
		this.Front2.render(f5);
		this.Base2.render(f5);
		this.FrontLightConnected.render(f5);
		this.FrontLightValid.render(f5);
		this.FrontLightActivity.render(f5);
		this.RightLightConnected.render(f5);
		this.BackLightConnected.render(f5);
		this.LeftLightConnected.render(f5);
		this.RightLightValid.render(f5);
		this.BackLightValid.render(f5);
		this.LeftLightValid.render(f5);
		this.RightLightActivity.render(f5);
		this.BackLightActivity.render(f5);
		this.LeftLightActivity.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, this.entity);
	}

}
