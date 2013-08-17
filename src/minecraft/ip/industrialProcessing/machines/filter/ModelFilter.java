package ip.industrialProcessing.machines.filter;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.client.render.ModelMachine;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModelFilter extends ModelAnimatedMachine {
    // fields
    ModelRenderer plateShape3;
    ModelRenderer plateShape4;
    ModelRenderer plateShape2;
    ModelRenderer plateShape1;
    ModelRenderer Shape5;
    ModelRenderer Shape25;
    ModelRenderer Shape6;
    ModelRenderer barShape4;
    ModelRenderer barShape2;
    ModelRenderer barShape3;
    ModelRenderer barShape1;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;

    public ModelFilter() {
	textureWidth = 64;
	textureHeight = 64;

	plateShape3 = new ModelRenderer(this, 0, 49);
	plateShape3.addBox(0F, 0F, 0F, 10, 1, 14);
	plateShape3.setRotationPoint(-5F, 17F, -7F);
	plateShape3.setTextureSize(64, 32);
	plateShape3.mirror = true;
	setRotation(plateShape3, 0.1745329F, 0F, -0.0523599F);
	plateShape4 = new ModelRenderer(this, 34, 1);
	plateShape4.addBox(0F, 0F, 0F, 1, 1, 14);
	plateShape4.setRotationPoint(-5F, 19.5F, -7F);
	plateShape4.setTextureSize(64, 32);
	plateShape4.mirror = true;
	setRotation(plateShape4, 0.1745329F, 0F, 0F);
	plateShape2 = new ModelRenderer(this, 0, 49);
	plateShape2.addBox(0F, 0F, 0F, 10, 1, 14);
	plateShape2.setRotationPoint(-5F, 14F, -7F);
	plateShape2.setTextureSize(64, 32);
	plateShape2.mirror = true;
	setRotation(plateShape2, 0.1745329F, 0F, -0.0523599F);
	plateShape1 = new ModelRenderer(this, 0, 49);
	plateShape1.addBox(0F, 0F, 0F, 10, 1, 14);
	plateShape1.setRotationPoint(-5F, 11F, -7F);
	plateShape1.setTextureSize(64, 32);
	plateShape1.mirror = true;
	setRotation(plateShape1, 0.1745329F, 0F, -0.0523599F);
	Shape5 = new ModelRenderer(this, 28, 16);
	Shape5.addBox(0F, 0F, 0F, 16, 2, 2);
	Shape5.setRotationPoint(-8F, 22F, 6F);
	Shape5.setTextureSize(64, 32);
	Shape5.mirror = true;
	setRotation(Shape5, 0F, 0F, 0F);
	Shape25 = new ModelRenderer(this, 58, 48);
	Shape25.addBox(0F, 0F, 0F, 1, 14, 2);
	Shape25.setRotationPoint(-5F, 8F, 6F);
	Shape25.setTextureSize(64, 32);
	Shape25.mirror = true;
	setRotation(Shape25, 0F, 0F, 0F);
	Shape6 = new ModelRenderer(this, 0, 23);
	Shape6.addBox(0F, 0F, 0F, 1, 10, 16);
	Shape6.setRotationPoint(6F, 12F, -8F);
	Shape6.setTextureSize(64, 32);
	Shape6.mirror = true;
	setRotation(Shape6, 0F, 0F, 0F);
	barShape4 = new ModelRenderer(this, 0, 49);
	barShape4.addBox(0F, 0F, 0F, 10, 1, 14);
	barShape4.setRotationPoint(-5F, 20F, -7F);
	barShape4.setTextureSize(64, 32);
	barShape4.mirror = true;
	setRotation(barShape4, 0.1745329F, 0F, -0.0523599F);
	barShape2 = new ModelRenderer(this, 34, 1);
	barShape2.addBox(0F, 0F, 0F, 1, 1, 14);
	barShape2.setRotationPoint(-5F, 13.5F, -7F);
	barShape2.setTextureSize(64, 32);
	barShape2.mirror = true;
	setRotation(barShape2, 0.1745329F, 0F, 0F);
	barShape3 = new ModelRenderer(this, 34, 1);
	barShape3.addBox(0F, 0F, 0F, 1, 1, 14);
	barShape3.setRotationPoint(-5F, 16.5F, -7F);
	barShape3.setTextureSize(64, 32);
	barShape3.mirror = true;
	setRotation(barShape3, 0.1745329F, 0F, 0F);
	barShape1 = new ModelRenderer(this, 34, 1);
	barShape1.addBox(0F, 0F, 0F, 1, 1, 14);
	barShape1.setRotationPoint(-5F, 10.5F, -7F);
	barShape1.setTextureSize(64, 32);
	barShape1.mirror = true;
	setRotation(barShape1, 0.1745329F, 0F, 0F);
	Shape11 = new ModelRenderer(this, 0, 19);
	Shape11.addBox(0F, 0F, 0F, 1, 14, 16);
	Shape11.setRotationPoint(-6F, 8F, -8F);
	Shape11.setTextureSize(64, 32);
	Shape11.mirror = true;
	setRotation(Shape11, 0F, 0F, 0F);
	Shape12 = new ModelRenderer(this, 10, 0);
	Shape12.addBox(0F, 0F, 0F, 1, 1, 14);
	Shape12.setRotationPoint(-5F, 8F, -6F);
	Shape12.setTextureSize(64, 32);
	Shape12.mirror = true;
	setRotation(Shape12, 0F, 0F, 0F);
	Shape13 = new ModelRenderer(this, 34, 52);
	Shape13.addBox(0F, 0F, 0F, 10, 1, 2);
	Shape13.setRotationPoint(-5F, 8.5F, -1F);
	Shape13.setTextureSize(64, 32);
	Shape13.mirror = true;
	setRotation(Shape13, 0F, 0F, 0F);
	Shape14 = new ModelRenderer(this, 0, 49);
	Shape14.addBox(0F, 0F, 0F, 10, 1, 14);
	Shape14.setRotationPoint(-5F, 21F, -7F);
	Shape14.setTextureSize(64, 32);
	Shape14.mirror = true;
	setRotation(Shape14, 0F, 0F, 0F);
	Shape15 = new ModelRenderer(this, 28, 16);
	Shape15.addBox(0F, 0F, 0F, 16, 2, 2);
	Shape15.setRotationPoint(-8F, 22F, -8F);
	Shape15.setTextureSize(64, 32);
	Shape15.mirror = true;
	setRotation(Shape15, 0F, 0F, 0F);
	Shape16 = new ModelRenderer(this, 58, 48);
	Shape16.addBox(0F, 0F, 0F, 1, 14, 2);
	Shape16.setRotationPoint(-5F, 8F, -8F);
	Shape16.setTextureSize(64, 32);
	Shape16.mirror = true;
	setRotation(Shape16, 0F, 0F, 0F);
	Shape17 = new ModelRenderer(this, 34, 55);
	Shape17.addBox(0F, 0F, 0F, 1, 1, 6);
	Shape17.setRotationPoint(-7F, 13F, -3F);
	Shape17.setTextureSize(64, 32);
	Shape17.mirror = true;
	setRotation(Shape17, 0F, 0F, -0.7853982F);
	Shape18 = new ModelRenderer(this, 0, 23);
	Shape18.addBox(0F, 0F, 0F, 2, 6, 6);
	Shape18.setRotationPoint(6F, 13F, -3F);
	Shape18.setTextureSize(64, 32);
	Shape18.mirror = true;
	setRotation(Shape18, 0F, 0F, 0F);
	Shape19 = new ModelRenderer(this, 34, 55);
	Shape19.addBox(0F, 0F, 0F, 3, 1, 6);
	Shape19.setRotationPoint(-8F, 13F, -3F);
	Shape19.setTextureSize(64, 32);
	Shape19.mirror = true;
	setRotation(Shape19, 0F, 0F, -0.7853982F);
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
	Shape23.addBox(0F, 0F, 0F, 2, 14, 16);
	Shape23.setRotationPoint(4F, 8F, -8F);
	Shape23.setTextureSize(64, 32);
	Shape23.mirror = true;
	setRotation(Shape23, 0F, 0F, 0F);
	Shape24 = new ModelRenderer(this, 20, 23);
	Shape24.addBox(0F, 0F, 0F, 2, 6, 6);
	Shape24.setRotationPoint(-8F, 13F, -3F);
	Shape24.setTextureSize(64, 32);
	Shape24.mirror = true;
	setRotation(Shape24, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	super.render(entity, f, f1, f2, f3, f4, f5);
	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	plateShape3.render(f5);
	plateShape4.render(f5);
	plateShape2.render(f5);
	plateShape1.render(f5);
	Shape5.render(f5);
	Shape6.render(f5);
	barShape4.render(f5);
	barShape2.render(f5);
	barShape3.render(f5);
	barShape1.render(f5);
	Shape11.render(f5);
	Shape12.render(f5);
	Shape13.render(f5);
	Shape14.render(f5);
	Shape15.render(f5);
	Shape16.render(f5);
	Shape17.render(f5);
	Shape18.render(f5);
	Shape19.render(f5);
	Shape20.render(f5);
	Shape21.render(f5);
	Shape22.render(f5);
	Shape23.render(f5);
	Shape24.render(f5);
    }
 
    @Override
    public void renderModel(float f1) {
	plateShape3.render(f1);
	plateShape4.render(f1);
	plateShape2.render(f1);
	plateShape1.render(f1);
	Shape5.render(f1);
	Shape6.render(f1);
	barShape4.render(f1);
	barShape2.render(f1);
	barShape3.render(f1);
	barShape1.render(f1);
	Shape11.render(f1);
	Shape12.render(f1);
	Shape13.render(f1);
	Shape14.render(f1);
	Shape15.render(f1);
	Shape16.render(f1);
	Shape17.render(f1);
	Shape18.render(f1);
	Shape19.render(f1);
	Shape20.render(f1);
	Shape21.render(f1);
	Shape22.render(f1);
	Shape23.render(f1);
	Shape24.render(f1);
    } 
    @Override
    public void renderModelAnimated(float f1, float animated) {
	float freq1 = 27;
	float freq2 = 23;
	float freq3 = 25;
	float freq4 = 20;

	float distance = 0.025f;

	animated = Math.max(0, Math.min(animated, 1));
	float a1 = (float) Math.sin((animated) * Math.PI * freq1) * distance;
	float a2 = (float) Math.sin((animated + 1) * Math.PI * freq2) * distance;
	float a3 = (float) Math.sin((animated + 2) * Math.PI * freq3) * distance;
	float a4 = (float) Math.sin((animated + 3) * Math.PI * freq4) * distance;

	GL11.glPushMatrix();
	GL11.glTranslatef(0, 0, a1);
	barShape3.render(f1); // 3
	plateShape3.render(f1); // 3
	GL11.glPopMatrix();

	GL11.glPushMatrix();
	GL11.glTranslatef(0, 0, a2);
	plateShape2.render(f1); // 2
	barShape2.render(f1); // 2
	GL11.glPopMatrix();

	GL11.glPushMatrix();
	GL11.glTranslatef(0, 0, a3);
	plateShape1.render(f1); // 1
	barShape1.render(f1); // 1
	GL11.glPopMatrix();

	GL11.glPushMatrix();
	GL11.glTranslatef(0, 0, a4);
	barShape4.render(f1); // 4
	plateShape4.render(f1); // 4
	GL11.glPopMatrix();

	Shape5.render(f1);
	Shape6.render(f1);
	Shape11.render(f1);
	Shape12.render(f1);
	Shape13.render(f1);
	Shape14.render(f1);
	Shape15.render(f1);
	Shape16.render(f1);
	Shape17.render(f1);
	Shape18.render(f1);
	Shape19.render(f1);
	Shape20.render(f1);
	Shape21.render(f1);
	Shape22.render(f1);
	Shape23.render(f1);
	Shape24.render(f1);
    } 

}
