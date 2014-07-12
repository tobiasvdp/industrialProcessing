package mod.industrialProcessing.transport.fluids.models.tileEntity;

import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class ModelManoMeter extends ModelAnimatedMachine {

	// fields
	ModelRenderer Needle1;
	ModelRenderer Needle2;

	public ModelManoMeter() {
		textureWidth = 64;
		textureHeight = 32;

		Needle1 = new ModelRenderer(this, 32, 6);
		Needle1.addBox(-0.5F, -7F, -0.5F, 1, 7, 1);
		Needle1.setRotationPoint(-0.6F, 20F, 0F);
		Needle1.setTextureSize(64, 32);
		Needle1.mirror = true;
		setRotation(Needle1, 0F, 0.7853982F, 0F);
		Needle2 = new ModelRenderer(this, 32, 6);
		Needle2.addBox(-0.5F, -7F, -0.5F, 1, 7, 1);
		Needle2.setRotationPoint(0.6F, 20F, 0F);
		Needle2.setTextureSize(64, 32);
		Needle2.mirror = true;
		setRotation(Needle2, 0F, 0.7853982F, 0F);
	}

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progress) {
		GL11.glPushMatrix();
		GL11.glRotatef(90, 0, 1, 0);
		float center = 1.2f;
		GL11.glTranslatef(0, center, 0);
		GL11.glRotatef(progress[0] * 90 - 45, 1, 0, 0);
		GL11.glTranslatef(0, -center, 0);
		Needle1.render(f5);

		GL11.glTranslatef(0, center, 0);
		GL11.glRotatef((progress[0] * 90 - 45) * -2, 1, 0, 0);
		GL11.glTranslatef(0, -center, 0);
		Needle2.render(f5);
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(null, f, new float[] { 0.5f });
	}

}
