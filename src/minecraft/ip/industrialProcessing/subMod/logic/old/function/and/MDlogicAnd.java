package ip.industrialProcessing.subMod.logic.old.function.and;

import ip.industrialProcessing.subMod.logic.client.ModelLogic;
import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class MDlogicAnd extends ModelLogic {
	// fields
	ModelRenderer Base;
	ModelRenderer Right1;
	ModelRenderer Right2;
	ModelRenderer Left1;
	ModelRenderer Left2;
	ModelRenderer Back1;
	ModelRenderer Back2;
	ModelRenderer IC;
	ModelRenderer pin4;
	ModelRenderer pin2;
	ModelRenderer pin1;
	ModelRenderer pin5;
	ModelRenderer pin3;
	ModelRenderer pin6;
	ModelRenderer pin8;
	ModelRenderer pin10;
	ModelRenderer pin7;
	ModelRenderer pin9;
	ModelRenderer IC1;
	ModelRenderer IC2;
	ModelRenderer LaneLeft;
	ModelRenderer LaneRight;
	ModelRenderer LaneFront;
	ModelRenderer drawPane;
	private Entity entity;

	public MDlogicAnd() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Base = new ModelRenderer(this, 0, 22);
		this.Base.addBox(-3F, 5.2F, 2F, 1, 1, 1);
		this.Base.setRotationPoint(2.5F, 15F, 1.5F);
		this.Base.setTextureSize(64, 32);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(-5F, 5F, -5F, 10, 3, 10);
		this.Base.setRotationPoint(0F, 16F, 0F);
		this.Base.setTextureSize(64, 32);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);
		this.Right1 = new ModelRenderer(this, 0, 0);
		this.Right1.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		this.Right1.setRotationPoint(0F, 16F, 0F);
		this.Right1.setTextureSize(64, 32);
		this.Right1.mirror = true;
		this.setRotation(this.Right1, 0F, 0F, 0F);
		this.Right2 = new ModelRenderer(this, 0, 0);
		this.Right2.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Right2.setRotationPoint(0F, 16F, 0F);
		this.Right2.setTextureSize(64, 32);
		this.Right2.mirror = true;
		this.setRotation(this.Right2, 0F, 0F, 0F);
		this.Left1 = new ModelRenderer(this, 0, 0);
		this.Left1.addBox(4.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Left1.setRotationPoint(0F, 16F, 0F);
		this.Left1.setTextureSize(64, 32);
		this.Left1.mirror = true;
		this.setRotation(this.Left1, 0F, 0F, 0F);
		this.Left2 = new ModelRenderer(this, 0, 0);
		this.Left2.addBox(4.5F, 7F, -1.5F, 1, 1, 3);
		this.Left2.setRotationPoint(0F, 16F, 0F);
		this.Left2.setTextureSize(64, 32);
		this.Left2.mirror = true;
		this.setRotation(this.Left2, 0F, 0F, 0F);
		this.Back1 = new ModelRenderer(this, 0, 0);
		this.Back1.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		this.Back1.setRotationPoint(0F, 16F, 0F);
		this.Back1.setTextureSize(64, 32);
		this.Back1.mirror = true;
		this.setRotation(this.Back1, 0F, 1.570796F, 0F);
		this.Back2 = new ModelRenderer(this, 0, 0);
		this.Back2.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		this.Back2.setRotationPoint(0F, 16F, 0F);
		this.Back2.setTextureSize(64, 32);
		this.Back2.mirror = true;
		this.setRotation(this.Back2, 0F, 1.570796F, 0F);
		this.IC = new ModelRenderer(this, 0, 13);
		this.IC.addBox(-3F, 5.1F, -4F, 7, 1, 8);
		this.IC.setRotationPoint(-0.5F, 15F, -0.5F);
		this.IC.setTextureSize(64, 32);
		this.IC.mirror = true;
		this.setRotation(this.IC, 0F, 0F, 0F);
		this.pin4 = new ModelRenderer(this, 0, 6);
		this.pin4.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin4.setRotationPoint(-1F, 15F, 2F);
		this.pin4.setTextureSize(64, 32);
		this.pin4.mirror = true;
		this.setRotation(this.pin4, 0F, 0F, 0F);
		this.pin2 = new ModelRenderer(this, 0, 6);
		this.pin2.addBox(-3F, 5.5F, -1F, 1, 1, 1);
		this.pin2.setRotationPoint(-1F, 15F, 2F);
		this.pin2.setTextureSize(64, 32);
		this.pin2.mirror = true;
		this.setRotation(this.pin2, 0F, 0F, 0F);
		this.pin1 = new ModelRenderer(this, 0, 6);
		this.pin1.addBox(-3F, 5.5F, -1F, 1, 1, 1);
		this.pin1.setRotationPoint(-1F, 15F, 3.5F);
		this.pin1.setTextureSize(64, 32);
		this.pin1.mirror = true;
		this.setRotation(this.pin1, 0F, 0F, 0F);
		this.pin5 = new ModelRenderer(this, 0, 6);
		this.pin5.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin5.setRotationPoint(-1F, 15F, 0.5F);
		this.pin5.setTextureSize(64, 32);
		this.pin5.mirror = true;
		this.setRotation(this.pin5, 0F, 0F, 0F);
		this.pin3 = new ModelRenderer(this, 0, 6);
		this.pin3.addBox(-3F, 5.5F, -6F, 1, 1, 1);
		this.pin3.setRotationPoint(-1F, 15F, 5.5F);
		this.pin3.setTextureSize(64, 32);
		this.pin3.mirror = true;
		this.setRotation(this.pin3, 0F, 0F, 0F);
		this.pin6 = new ModelRenderer(this, 0, 6);
		this.pin6.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin6.setRotationPoint(6F, 15F, 0.5F);
		this.pin6.setTextureSize(64, 32);
		this.pin6.mirror = true;
		this.setRotation(this.pin6, 0F, 0F, 0F);
		this.pin8 = new ModelRenderer(this, 0, 6);
		this.pin8.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin8.setRotationPoint(6F, 15F, 3.5F);
		this.pin8.setTextureSize(64, 32);
		this.pin8.mirror = true;
		this.setRotation(this.pin8, 0F, 0F, 0F);
		this.pin10 = new ModelRenderer(this, 0, 6);
		this.pin10.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin10.setRotationPoint(6F, 15F, 6.5F);
		this.pin10.setTextureSize(64, 32);
		this.pin10.mirror = true;
		this.setRotation(this.pin10, 0F, 0F, 0F);
		this.pin7 = new ModelRenderer(this, 0, 6);
		this.pin7.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin7.setRotationPoint(6F, 15F, 2F);
		this.pin7.setTextureSize(64, 32);
		this.pin7.mirror = true;
		this.setRotation(this.pin7, 0F, 0F, 0F);
		this.pin9 = new ModelRenderer(this, 0, 6);
		this.pin9.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		this.pin9.setRotationPoint(6F, 15F, 5F);
		this.pin9.setTextureSize(64, 32);
		this.pin9.mirror = true;
		this.setRotation(this.pin9, 0F, 0F, 0F);
		this.IC1 = new ModelRenderer(this, 0, 24);
		this.IC1.addBox(-3F, 5.1F, 2F, 3, 1, 1);
		this.IC1.setRotationPoint(-0.5F, 15F, 1.5F);
		this.IC1.setTextureSize(64, 32);
		this.IC1.mirror = true;
		this.setRotation(this.IC1, 0F, 0F, 0F);
		this.IC2 = new ModelRenderer(this, 0, 24);
		this.IC2.addBox(-3F, 5.1F, 2F, 3, 1, 1);
		this.IC2.setRotationPoint(3.5F, 15F, 1.5F);
		this.IC2.setTextureSize(64, 32);
		this.IC2.mirror = true;
		this.setRotation(this.IC2, 0F, 0F, 0F);
		this.LaneLeft = new ModelRenderer(this, 0, 27);
		this.LaneLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		this.LaneLeft.setRotationPoint(-1.5F, 19.9F, -4.4F);
		this.LaneLeft.setTextureSize(64, 32);
		this.LaneLeft.mirror = true;
		this.setRotation(this.LaneLeft, 0F, 0F, 0F);
		this.LaneRight = new ModelRenderer(this, 0, 32);
		this.LaneRight.addBox(0F, 0F, 0F, 1, 1, 1);
		this.LaneRight.setRotationPoint(0.5F, 19.9F, -4.4F);
		this.LaneRight.setTextureSize(64, 32);
		this.LaneRight.mirror = true;
		this.setRotation(this.LaneRight, 0F, 0F, 0F);
		this.LaneFront = new ModelRenderer(this, 0, 37);
		this.LaneFront.addBox(0F, 0F, 0F, 1, 1, 1);
		this.LaneFront.setRotationPoint(-0.5F, 19.9F, 2.4F);
		this.LaneFront.setTextureSize(64, 32);
		this.LaneFront.mirror = true;
		this.setRotation(this.LaneFront, 0F, 0F, 0F);
		this.drawPane = new ModelRenderer(this, 9, 31);
		this.drawPane.addBox(0F, 0F, 0F, 5, 1, 6);
		this.drawPane.setRotationPoint(-2.5F, 19.8F, -3.5F);
		this.drawPane.setTextureSize(64, 32);
		this.drawPane.mirror = true;
		this.setRotation(this.drawPane, 0F, 0F, 0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5);
		this.Base.render(f5);
		this.Base.render(f5);
		this.Right1.render(f5);
		this.Right2.render(f5);
		this.Left1.render(f5);
		this.Left2.render(f5);
		this.Back1.render(f5);
		this.Back2.render(f5);
		this.IC.render(f5);
		this.pin4.render(f5);
		this.pin2.render(f5);
		this.pin1.render(f5);
		this.pin5.render(f5);
		this.pin3.render(f5);
		this.pin6.render(f5);
		this.pin8.render(f5);
		this.pin10.render(f5);
		this.pin7.render(f5);
		this.pin9.render(f5);
		this.IC1.render(f5);
		this.IC2.render(f5);
		this.LaneLeft.render(f5);
		this.LaneRight.render(f5);
		this.LaneFront.render(f5);
		this.drawPane.render(f5);
		this.entity = entity;
	}

	@Override
	public void renderModel(float f5, boolean[] side, boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels) {
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
					break;
				default:
					break;
				}
			}
		}
		this.Base.render(f5);
		this.Base.render(f5);
		this.Right1.render(f5);
		this.Right2.render(f5);
		this.Left1.render(f5);
		this.Left2.render(f5);
		this.Back1.render(f5);
		this.Back2.render(f5);
		this.IC.render(f5);
		this.pin4.render(f5);
		this.pin2.render(f5);
		this.pin1.render(f5);
		this.pin5.render(f5);
		this.pin3.render(f5);
		this.pin6.render(f5);
		this.pin8.render(f5);
		this.pin10.render(f5);
		this.pin7.render(f5);
		this.pin9.render(f5);
		this.IC1.render(f5);
		this.IC2.render(f5);
		this.drawPane.render(f5);
		System.out.println(levels[3].get().getClass());
		/*
		 * if (levels[3] != null && levels[3].get() instanceof Boolean &&
		 * (Boolean) levels[3].get()) { LaneLeft.render(f5); }else{
		 * GL11.glPushMatrix(); GL11.glColor3f(0.2f, 0.2f, 0.2f);
		 * LaneLeft.render(f5); GL11.glPopMatrix(); } if (levels[4] != null &&
		 * levels[4].get() instanceof Boolean && (Boolean) levels[4].get()) {
		 * LaneRight.render(f5); }else{ GL11.glPushMatrix();
		 * GL11.glColor3f(0.2f, 0.2f, 0.2f); LaneRight.render(f5);
		 * GL11.glPopMatrix(); } if (levels[2] != null && levels[2].get()
		 * instanceof Boolean && (Boolean) levels[2].get()) {
		 * LaneFront.render(f5); }else{ GL11.glPushMatrix();
		 * GL11.glColor3f(0.2f, 0.2f, 0.2f); LaneFront.render(f5);
		 * GL11.glPopMatrix(); }
		 */

		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		this.Base.render(f5);
		this.Base.render(f5);
		this.Right1.render(f5);
		this.Right2.render(f5);
		this.Left1.render(f5);
		this.Left2.render(f5);
		this.Back1.render(f5);
		this.Back2.render(f5);
		this.IC.render(f5);
		this.pin4.render(f5);
		this.pin2.render(f5);
		this.pin1.render(f5);
		this.pin5.render(f5);
		this.pin3.render(f5);
		this.pin6.render(f5);
		this.pin8.render(f5);
		this.pin10.render(f5);
		this.pin7.render(f5);
		this.pin9.render(f5);
		this.IC1.render(f5);
		this.IC2.render(f5);
		this.drawPane.render(f5);
		GL11.glPushMatrix();
		GL11.glColor3f(0.2f, 0.2f, 0.2f);
		this.LaneLeft.render(f5);
		this.LaneRight.render(f5);
		this.LaneFront.render(f5);
		GL11.glPopMatrix();
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, this.entity);
	}

}
