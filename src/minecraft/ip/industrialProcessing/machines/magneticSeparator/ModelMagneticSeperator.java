package ip.industrialProcessing.machines.magneticSeparator;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ip.industrialProcessing.machines.Model;

public class ModelMagneticSeperator extends Model {

	Entity entity;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape18;
	ModelRenderer Shape20;
	ModelRenderer Shape21;
	ModelRenderer Shape22;
	ModelRenderer Shape23;
	ModelRenderer Shape24;
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	ModelRenderer Shape19;

	public ModelMagneticSeperator() {
		textureWidth = 64;
		textureHeight = 64;

		Shape5 = new ModelRenderer(this, 28, 16);
		Shape5.addBox(0F, 0F, 0F, 16, 2, 2);
		Shape5.setRotationPoint(-8F, 22F, 6F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 23);
		Shape6.addBox(0F, 0F, 0F, 1, 10, 16);
		Shape6.setRotationPoint(6F, 12F, -8F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 49);
		Shape14.addBox(0F, 0F, 0F, 12, 1, 14);
		Shape14.setRotationPoint(-8F, 21F, -7F);
		Shape14.setTextureSize(64, 32);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape15 = new ModelRenderer(this, 28, 16);
		Shape15.addBox(0F, 0F, 0F, 16, 2, 2);
		Shape15.setRotationPoint(-8F, 22F, -8F);
		Shape15.setTextureSize(64, 32);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0F, 0F);
		Shape18 = new ModelRenderer(this, 0, 23);
		Shape18.addBox(0F, 0F, 0F, 1, 6, 6);
		Shape18.setRotationPoint(7F, 13F, -3F);
		Shape18.setTextureSize(64, 32);
		Shape18.mirror = true;
		setRotation(Shape18, 0F, 0F, 0F);
		Shape20 = new ModelRenderer(this, 0, 0);
		Shape20.addBox(0F, 0F, 0F, 6, 1, 6);
		Shape20.setRotationPoint(-3F, 8F, -3F);
		Shape20.setTextureSize(64, 32);
		Shape20.mirror = true;
		setRotation(Shape20, 0F, 0F, 0F);
		Shape21 = new ModelRenderer(this, 0, 7);
		Shape21.addBox(0F, 0F, 0F, 6, 1, 6);
		Shape21.setRotationPoint(-3F, 23F, -3F);
		Shape21.setTextureSize(64, 32);
		Shape21.mirror = true;
		setRotation(Shape21, 0F, 0F, 0F);
		Shape22 = new ModelRenderer(this, 32, 20);
		Shape22.addBox(0F, 0F, 0F, 8, 1, 8);
		Shape22.setRotationPoint(-4F, 22F, -4F);
		Shape22.setTextureSize(64, 32);
		Shape22.mirror = true;
		setRotation(Shape22, 0F, 0F, 0F);
		Shape23 = new ModelRenderer(this, 0, 19);
		Shape23.addBox(0F, 0F, 0F, 2, 13, 16);
		Shape23.setRotationPoint(4F, 9F, -8F);
		Shape23.setTextureSize(64, 32);
		Shape23.mirror = true;
		setRotation(Shape23, 0F, 0F, 0F);
		Shape24 = new ModelRenderer(this, 20, 23);
		Shape24.addBox(0F, 0F, 0F, 1, 6, 6);
		Shape24.setRotationPoint(-8F, 13F, -3F);
		Shape24.setTextureSize(64, 32);
		Shape24.mirror = true;
		setRotation(Shape24, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 48, 0);
		Shape1.addBox(0F, 0F, 0F, 6, 1, 2);
		Shape1.setRotationPoint(-4F, 13F, -1F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 54);
		Shape2.addBox(0F, 0F, 0F, 3, 1, 2);
		Shape2.setRotationPoint(1F, 18F, -1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 48, 3);
		Shape3.addBox(0F, 0F, 0F, 6, 1, 2);
		Shape3.setRotationPoint(-4F, 19F, -1F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 54);
		Shape4.addBox(0F, 0F, 0F, 3, 1, 2);
		Shape4.setRotationPoint(1F, 14F, -1F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 57);
		Shape7.addBox(0F, 0F, 0F, 2, 3, 2);
		Shape7.setRotationPoint(2F, 15F, -1F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 25, 50);
		Shape8.addBox(0F, 0F, 0F, 4, 0, 13);
		Shape8.setRotationPoint(-5F, 17F, -7F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 60, 51);
		Shape9.addBox(0F, 0F, 0F, 1, 12, 1);
		Shape9.setRotationPoint(-8F, 9F, -7F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 46, 56);
		Shape10.addBox(0F, 0F, 0F, 4, 4, 3);
		Shape10.setRotationPoint(-5F, 17F, -7F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 44, 42);
		Shape11.addBox(0F, 0F, 0F, 1, 2, 4);
		Shape11.setRotationPoint(-8F, 19F, -2F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 50);
		Shape12.addBox(0F, 0F, 0F, 3, 0, 4);
		Shape12.setRotationPoint(-8F, 17F, -2F);
		Shape12.setTextureSize(64, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 46, 50);
		Shape13.addBox(0F, 0F, 0F, 4, 4, 2);
		Shape13.setRotationPoint(-5F, 11F, 4F);
		Shape13.setTextureSize(64, 32);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape16 = new ModelRenderer(this, 54, 42);
		Shape16.addBox(0F, 0F, 0F, 1, 4, 4);
		Shape16.setRotationPoint(-8F, 9F, -2F);
		Shape16.setTextureSize(64, 32);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0F, 0F);
		Shape17 = new ModelRenderer(this, 11, 1);
		Shape17.addBox(0F, 0F, 0F, 12, 2, 13);
		Shape17.setRotationPoint(-8F, 9F, -7F);
		Shape17.setTextureSize(64, 32);
		Shape17.mirror = true;
		setRotation(Shape17, 0F, 0F, 0F);
		Shape19 = new ModelRenderer(this, 36, 29);
		Shape19.addBox(0F, 0F, 0F, 12, 12, 1);
		Shape19.setRotationPoint(-8F, 9F, 6F);
		Shape19.setTextureSize(64, 32);
		Shape19.mirror = true;
		setRotation(Shape19, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape18.render(f5);
		Shape20.render(f5);
		Shape21.render(f5);
		Shape22.render(f5);
		Shape23.render(f5);
		Shape24.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		Shape19.render(f5);
		this.entity = entity;
	}

	@Override
	public void renderModel(float f) {
		Shape5.render(f);
		Shape6.render(f);
		Shape14.render(f);
		Shape15.render(f);
		Shape18.render(f);
		Shape20.render(f);
		Shape21.render(f);
		Shape22.render(f);
		Shape23.render(f);
		Shape24.render(f);
		Shape1.render(f);
		Shape2.render(f);
		Shape3.render(f);
		Shape4.render(f);
		Shape7.render(f);
		Shape8.render(f);
		Shape9.render(f);
		Shape10.render(f);
		Shape11.render(f);
		Shape12.render(f);
		Shape13.render(f);
		Shape16.render(f);
		Shape17.render(f);
		Shape19.render(f);
	}

	@Override
	public void renderModelAnimated(float f, float progress) {
		Shape5.render(f);
		Shape6.render(f);
		Shape14.render(f);
		Shape15.render(f);
		Shape18.render(f);
		Shape20.render(f);
		Shape21.render(f);
		Shape22.render(f);
		Shape23.render(f);
		Shape24.render(f);
		Shape1.render(f);
		Shape2.render(f);
		Shape3.render(f);
		Shape4.render(f);
		Shape7.render(f);
		Shape8.render(f);
		Shape9.render(f);
		Shape10.render(f);
		Shape11.render(f);
		Shape12.render(f);
		Shape13.render(f);
		Shape16.render(f);
		Shape17.render(f);
		Shape19.render(f); 
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
