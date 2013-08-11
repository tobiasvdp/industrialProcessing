package ip.industrialProcessing.power.meters;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import ip.industrialProcessing.client.render.ModelAnimatedMachine;

public class ModelVoltMeter extends ModelAnimatedMachine {
    // fields
    ModelRenderer Support1;
    ModelRenderer Support2;
    ModelRenderer Back;
    ModelRenderer Body;
    ModelRenderer Viewer;
    ModelRenderer ConnectorPower;
    ModelRenderer Needle;

    public ModelVoltMeter() {
	textureWidth = 64;
	textureHeight = 64;

	Support1 = new ModelRenderer(this, 28, 30);
	Support1.addBox(0F, 0F, 0F, 16, 2, 2);
	Support1.setRotationPoint(-8F, 22F, 6F);
	Support1.setTextureSize(64, 64);
	Support1.mirror = true;
	setRotation(Support1, 0F, 0F, 0F);
	Support2 = new ModelRenderer(this, 28, 30);
	Support2.addBox(0F, 0F, 0F, 16, 2, 2);
	Support2.setRotationPoint(-8F, 22F, -8F);
	Support2.setTextureSize(64, 64);
	Support2.mirror = true;
	setRotation(Support2, 0F, 0F, 0F);
	Back = new ModelRenderer(this, 0, 6);
	Back.addBox(0F, 0F, 0F, 1, 12, 14);
	Back.setRotationPoint(-7F, 9F, -7F);
	Back.setTextureSize(64, 64);
	Back.mirror = true;
	setRotation(Back, 0F, 0F, 0F);
	Body = new ModelRenderer(this, 6, 34);
	Body.addBox(0F, 0F, 0F, 12, 14, 16);
	Body.setRotationPoint(-6F, 8F, -8F);
	Body.setTextureSize(64, 64);
	Body.mirror = true;
	setRotation(Body, 0F, 0F, 0F);
	Viewer = new ModelRenderer(this, 0, 6);
	Viewer.addBox(0F, 0F, 0F, 1, 12, 14);
	Viewer.setRotationPoint(6F, 9F, -7F);
	Viewer.setTextureSize(64, 64);
	Viewer.mirror = true;
	setRotation(Viewer, 0F, 0F, 0F);
	ConnectorPower = new ModelRenderer(this, 0, 13);
	ConnectorPower.addBox(0F, 0F, 0F, 6, 6, 1);
	ConnectorPower.setRotationPoint(-7F, 13F, -3F);
	ConnectorPower.setTextureSize(64, 64);
	ConnectorPower.mirror = true;
	setRotation(ConnectorPower, 0F, -1.570796F, 0F);
	Needle = new ModelRenderer(this, 16, 9);
	Needle.addBox(-0.5F, -10F, -0.5F, 1, 10, 1);
	Needle.setRotationPoint(5.75F, 20F, 0F);
	Needle.setTextureSize(64, 64);
	Needle.mirror = true;
	setRotation(Needle, 0F, 0.7853982F, 0F);
    }

    @Override
    public void renderModelAnimated(float f5, float progress) {
	progress = 1 - progress;
	Support1.render(f5);
	Support2.render(f5);
	Back.render(f5);
	Body.render(f5);
	Viewer.render(f5);
	ConnectorPower.render(f5);
	float center = 1.2f;
	GL11.glPushMatrix();
	GL11.glTranslatef(0, center, 0);
	GL11.glRotatef(progress * 90 - 45, 1, 0, 0);
	GL11.glTranslatef(0, -center, 0);
	Needle.render(f5);
	GL11.glPopMatrix();
    }

    @Override
    public void renderModel(float f5) {
	Support1.render(f5);
	Support2.render(f5);
	Back.render(f5);
	Body.render(f5);
	Viewer.render(f5);
	ConnectorPower.render(f5);
	Needle.render(f5);

    }

}
