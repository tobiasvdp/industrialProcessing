package ip.industrialProcessing.logic.functions.and;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ip.industrialProcessing.client.render.ModelLogic;
import ip.industrialProcessing.logic.utils.UTBuffer;

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
		textureWidth = 64;
		textureHeight = 64;

		Base = new ModelRenderer(this, 0, 22);
		Base.addBox(-3F, 5.2F, 2F, 1, 1, 1);
		Base.setRotationPoint(2.5F, 15F, 1.5F);
		Base.setTextureSize(64, 32);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(-5F, 5F, -5F, 10, 3, 10);
		Base.setRotationPoint(0F, 16F, 0F);
		Base.setTextureSize(64, 32);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Right1 = new ModelRenderer(this, 0, 0);
		Right1.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		Right1.setRotationPoint(0F, 16F, 0F);
		Right1.setTextureSize(64, 32);
		Right1.mirror = true;
		setRotation(Right1, 0F, 0F, 0F);
		Right2 = new ModelRenderer(this, 0, 0);
		Right2.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		Right2.setRotationPoint(0F, 16F, 0F);
		Right2.setTextureSize(64, 32);
		Right2.mirror = true;
		setRotation(Right2, 0F, 0F, 0F);
		Left1 = new ModelRenderer(this, 0, 0);
		Left1.addBox(4.5F, 6.5F, -1.5F, 1, 1, 3);
		Left1.setRotationPoint(0F, 16F, 0F);
		Left1.setTextureSize(64, 32);
		Left1.mirror = true;
		setRotation(Left1, 0F, 0F, 0F);
		Left2 = new ModelRenderer(this, 0, 0);
		Left2.addBox(4.5F, 7F, -1.5F, 1, 1, 3);
		Left2.setRotationPoint(0F, 16F, 0F);
		Left2.setTextureSize(64, 32);
		Left2.mirror = true;
		setRotation(Left2, 0F, 0F, 0F);
		Back1 = new ModelRenderer(this, 0, 0);
		Back1.addBox(-5.5F, 6.5F, -1.5F, 1, 1, 3);
		Back1.setRotationPoint(0F, 16F, 0F);
		Back1.setTextureSize(64, 32);
		Back1.mirror = true;
		setRotation(Back1, 0F, 1.570796F, 0F);
		Back2 = new ModelRenderer(this, 0, 0);
		Back2.addBox(-5.5F, 7F, -1.5F, 1, 1, 3);
		Back2.setRotationPoint(0F, 16F, 0F);
		Back2.setTextureSize(64, 32);
		Back2.mirror = true;
		setRotation(Back2, 0F, 1.570796F, 0F);
		IC = new ModelRenderer(this, 0, 13);
		IC.addBox(-3F, 5.1F, -4F, 7, 1, 8);
		IC.setRotationPoint(-0.5F, 15F, -0.5F);
		IC.setTextureSize(64, 32);
		IC.mirror = true;
		setRotation(IC, 0F, 0F, 0F);
		pin4 = new ModelRenderer(this, 0, 6);
		pin4.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin4.setRotationPoint(-1F, 15F, 2F);
		pin4.setTextureSize(64, 32);
		pin4.mirror = true;
		setRotation(pin4, 0F, 0F, 0F);
		pin2 = new ModelRenderer(this, 0, 6);
		pin2.addBox(-3F, 5.5F, -1F, 1, 1, 1);
		pin2.setRotationPoint(-1F, 15F, 2F);
		pin2.setTextureSize(64, 32);
		pin2.mirror = true;
		setRotation(pin2, 0F, 0F, 0F);
		pin1 = new ModelRenderer(this, 0, 6);
		pin1.addBox(-3F, 5.5F, -1F, 1, 1, 1);
		pin1.setRotationPoint(-1F, 15F, 3.5F);
		pin1.setTextureSize(64, 32);
		pin1.mirror = true;
		setRotation(pin1, 0F, 0F, 0F);
		pin5 = new ModelRenderer(this, 0, 6);
		pin5.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin5.setRotationPoint(-1F, 15F, 0.5F);
		pin5.setTextureSize(64, 32);
		pin5.mirror = true;
		setRotation(pin5, 0F, 0F, 0F);
		pin3 = new ModelRenderer(this, 0, 6);
		pin3.addBox(-3F, 5.5F, -6F, 1, 1, 1);
		pin3.setRotationPoint(-1F, 15F, 5.5F);
		pin3.setTextureSize(64, 32);
		pin3.mirror = true;
		setRotation(pin3, 0F, 0F, 0F);
		pin6 = new ModelRenderer(this, 0, 6);
		pin6.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin6.setRotationPoint(6F, 15F, 0.5F);
		pin6.setTextureSize(64, 32);
		pin6.mirror = true;
		setRotation(pin6, 0F, 0F, 0F);
		pin8 = new ModelRenderer(this, 0, 6);
		pin8.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin8.setRotationPoint(6F, 15F, 3.5F);
		pin8.setTextureSize(64, 32);
		pin8.mirror = true;
		setRotation(pin8, 0F, 0F, 0F);
		pin10 = new ModelRenderer(this, 0, 6);
		pin10.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin10.setRotationPoint(6F, 15F, 6.5F);
		pin10.setTextureSize(64, 32);
		pin10.mirror = true;
		setRotation(pin10, 0F, 0F, 0F);
		pin7 = new ModelRenderer(this, 0, 6);
		pin7.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin7.setRotationPoint(6F, 15F, 2F);
		pin7.setTextureSize(64, 32);
		pin7.mirror = true;
		setRotation(pin7, 0F, 0F, 0F);
		pin9 = new ModelRenderer(this, 0, 6);
		pin9.addBox(-3F, 5.5F, -4F, 1, 1, 1);
		pin9.setRotationPoint(6F, 15F, 5F);
		pin9.setTextureSize(64, 32);
		pin9.mirror = true;
		setRotation(pin9, 0F, 0F, 0F);
		IC1 = new ModelRenderer(this, 0, 24);
		IC1.addBox(-3F, 5.1F, 2F, 3, 1, 1);
		IC1.setRotationPoint(-0.5F, 15F, 1.5F);
		IC1.setTextureSize(64, 32);
		IC1.mirror = true;
		setRotation(IC1, 0F, 0F, 0F);
		IC2 = new ModelRenderer(this, 0, 24);
		IC2.addBox(-3F, 5.1F, 2F, 3, 1, 1);
		IC2.setRotationPoint(3.5F, 15F, 1.5F);
		IC2.setTextureSize(64, 32);
		IC2.mirror = true;
		setRotation(IC2, 0F, 0F, 0F);
		LaneLeft = new ModelRenderer(this, 0, 27);
		LaneLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		LaneLeft.setRotationPoint(-1.5F, 19.9F, -4.4F);
		LaneLeft.setTextureSize(64, 32);
		LaneLeft.mirror = true;
		setRotation(LaneLeft, 0F, 0F, 0F);
		LaneRight = new ModelRenderer(this, 0, 32);
		LaneRight.addBox(0F, 0F, 0F, 1, 1, 1);
		LaneRight.setRotationPoint(0.5F, 19.9F, -4.4F);
		LaneRight.setTextureSize(64, 32);
		LaneRight.mirror = true;
		setRotation(LaneRight, 0F, 0F, 0F);
		LaneFront = new ModelRenderer(this, 0, 37);
		LaneFront.addBox(0F, 0F, 0F, 1, 1, 1);
		LaneFront.setRotationPoint(-0.5F, 19.9F, 2.4F);
		LaneFront.setTextureSize(64, 32);
		LaneFront.mirror = true;
		setRotation(LaneFront, 0F, 0F, 0F);
		drawPane = new ModelRenderer(this, 9, 31);
		drawPane.addBox(0F, 0F, 0F, 5, 1, 6);
		drawPane.setRotationPoint(-2.5F, 19.8F, -3.5F);
		drawPane.setTextureSize(64, 32);
		drawPane.mirror = true;
		setRotation(drawPane, 0F, 0F, 0F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Base.render(f5);
		Base.render(f5);
		Right1.render(f5);
		Right2.render(f5);
		Left1.render(f5);
		Left2.render(f5);
		Back1.render(f5);
		Back2.render(f5);
		IC.render(f5);
		pin4.render(f5);
		pin2.render(f5);
		pin1.render(f5);
		pin5.render(f5);
		pin3.render(f5);
		pin6.render(f5);
		pin8.render(f5);
		pin10.render(f5);
		pin7.render(f5);
		pin9.render(f5);
		IC1.render(f5);
		IC2.render(f5);
		LaneLeft.render(f5);
		LaneRight.render(f5);
		LaneFront.render(f5);
		drawPane.render(f5);
		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
		Base.render(f5);
		Base.render(f5);
		Right1.render(f5);
		Right2.render(f5);
		Left1.render(f5);
		Left2.render(f5);
		Back1.render(f5);
		Back2.render(f5);
		IC.render(f5);
		pin4.render(f5);
		pin2.render(f5);
		pin1.render(f5);
		pin5.render(f5);
		pin3.render(f5);
		pin6.render(f5);
		pin8.render(f5);
		pin10.render(f5);
		pin7.render(f5);
		pin9.render(f5);
		IC1.render(f5);
		IC2.render(f5);
		drawPane.render(f5);
		System.out.println(levels[3].get().getClass());
		if (levels[3] != null &&  levels[3].get() instanceof Boolean && (Boolean) levels[3].get()) {
			LaneLeft.render(f5);
		}else{
			GL11.glPushMatrix();
			GL11.glColor3f(0.2f, 0.2f, 0.2f);
			LaneLeft.render(f5);
			GL11.glPopMatrix();
		}
		if (levels[4] != null &&  levels[4].get() instanceof Boolean && (Boolean) levels[4].get()) {
			LaneRight.render(f5);
		}else{
			GL11.glPushMatrix();
			GL11.glColor3f(0.2f, 0.2f, 0.2f);
			LaneRight.render(f5);
			GL11.glPopMatrix();
		}
		if (levels[2] != null &&  levels[2].get() instanceof Boolean && (Boolean) levels[2].get()) {
			LaneFront.render(f5);
		}else{
			GL11.glPushMatrix();
			GL11.glColor3f(0.2f, 0.2f, 0.2f);
			LaneFront.render(f5);
			GL11.glPopMatrix();
		}
		
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(float f5) {
		Base.render(f5);
		Base.render(f5);
		Right1.render(f5);
		Right2.render(f5);
		Left1.render(f5);
		Left2.render(f5);
		Back1.render(f5);
		Back2.render(f5);
		IC.render(f5);
		pin4.render(f5);
		pin2.render(f5);
		pin1.render(f5);
		pin5.render(f5);
		pin3.render(f5);
		pin6.render(f5);
		pin8.render(f5);
		pin10.render(f5);
		pin7.render(f5);
		pin9.render(f5);
		IC1.render(f5);
		IC2.render(f5);
		drawPane.render(f5);
		GL11.glPushMatrix();
		GL11.glColor3f(0.2f, 0.2f, 0.2f);
		LaneLeft.render(f5);
		LaneRight.render(f5);
		LaneFront.render(f5);
		GL11.glPopMatrix();
	}

}
