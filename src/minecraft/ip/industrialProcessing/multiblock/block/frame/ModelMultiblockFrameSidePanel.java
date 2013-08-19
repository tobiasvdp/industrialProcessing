package ip.industrialProcessing.multiblock.block.frame;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ip.industrialProcessing.client.render.ModelMultiblock;

public class ModelMultiblockFrameSidePanel extends ModelMultiblock {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	private Entity entity;

	public ModelMultiblockFrameSidePanel() {
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(1F, -8F, -3F, 2, 16, 2);
		Shape1.setRotationPoint(0F, 16F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(-1F, -8F, -5F, 2, 16, 2);
		Shape2.setRotationPoint(0F, 16F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(-3F, -8F, -6F, 2, 16, 2);
		Shape3.setRotationPoint(0F, 16F, 0F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(-4F, -8F, -6F, 2, 16, 2);
		Shape4.setRotationPoint(0F, 16F, 0F);
		Shape4.setTextureSize(64, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 0);
		Shape5.addBox(-5F, -8F, -6F, 2, 16, 2);
		Shape5.setRotationPoint(0F, 16F, 0F);
		Shape5.setTextureSize(64, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(-6F, -8F, -7F, 2, 16, 2);
		Shape6.setRotationPoint(0F, 16F, 0F);
		Shape6.setTextureSize(64, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(-7F, -8F, -7F, 2, 16, 2);
		Shape7.setRotationPoint(0F, 16F, 0F);
		Shape7.setTextureSize(64, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(-8F, -8F, -7F, 2, 16, 2);
		Shape8.setRotationPoint(0F, 16F, 0F);
		Shape8.setTextureSize(64, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 0);
		Shape9.addBox(3F, -8F, -1F, 2, 16, 2);
		Shape9.setRotationPoint(0F, 16F, 0F);
		Shape9.setTextureSize(64, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 0, 0);
		Shape10.addBox(4F, -8F, 1F, 2, 16, 2);
		Shape10.setRotationPoint(0F, 16F, 0F);
		Shape10.setTextureSize(64, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 0, 0);
		Shape11.addBox(4F, -8F, 2F, 2, 16, 2);
		Shape11.setRotationPoint(0F, 16F, 0F);
		Shape11.setTextureSize(64, 64);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 0);
		Shape12.addBox(4F, -8F, 3F, 2, 16, 2);
		Shape12.setRotationPoint(0F, 16F, 0F);
		Shape12.setTextureSize(64, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 0, 0);
		Shape13.addBox(5F, -8F, 4F, 2, 16, 2);
		Shape13.setRotationPoint(0F, 16F, 0F);
		Shape13.setTextureSize(64, 64);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 0);
		Shape14.addBox(5F, -8F, 5F, 2, 16, 2);
		Shape14.setRotationPoint(0F, 16F, 0F);
		Shape14.setTextureSize(64, 64);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape15 = new ModelRenderer(this, 0, 0);
		Shape15.addBox(5F, -8F, 6F, 2, 16, 2);
		Shape15.setRotationPoint(0F, 16F, 0F);
		Shape15.setTextureSize(64, 64);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0F, 0F);
		Shape16 = new ModelRenderer(this, 0, 0);
		Shape16.addBox(0F, -8F, -4F, 2, 16, 2);
		Shape16.setRotationPoint(0F, 16F, 0F);
		Shape16.setTextureSize(64, 64);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0F, 0F);
		Shape17 = new ModelRenderer(this, 0, 0);
		Shape17.addBox(2F, -8F, -2F, 2, 16, 2);
		Shape17.setRotationPoint(0F, 16F, 0F);
		Shape17.setTextureSize(64, 64);
		Shape17.mirror = true;
		setRotation(Shape17, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModelSides(float f5, boolean sides[]) {
		GL11.glPushMatrix();
		if (sides[3] && sides[5]) {
		} else if (sides[2] && sides[5]) {
			GL11.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
		} else if (sides[3] && sides[4]) {
			GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
		} else if (sides[2] && sides[4]) {
			GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
		}
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		GL11.glPopMatrix();
	}
}
