package ip.industrialProcessing.machines.crusher;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.machines.Model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrusher extends Model {
    // fields
    ModelRenderer SupportBeamRight;
    ModelRenderer SupportBeamLeft;
    ModelRenderer CrusherPlate1;
    ModelRenderer CrusherPlate2;
    ModelRenderer FrontBox;
    ModelRenderer BackPlate;
    ModelRenderer SideRight;
    ModelRenderer SideLeft;
    ModelRenderer BottomPlate;
    ModelRenderer InputTop;
    ModelRenderer OutputBottom;
    ModelRenderer PowerConnector;

    public ModelCrusher() {
	textureWidth = 64;
	textureHeight = 64;

	SupportBeamRight = new ModelRenderer(this, 14, 46);
	SupportBeamRight.addBox(0F, 0F, 0F, 2, 2, 16);
	SupportBeamRight.setRotationPoint(-8F, 22F, -6F);
	SupportBeamRight.setTextureSize(64, 64);
	SupportBeamRight.mirror = true;
	setRotation(SupportBeamRight, 0F, 1.570796F, 0F);
	SupportBeamLeft = new ModelRenderer(this, 14, 46);
	SupportBeamLeft.addBox(0F, 0F, 0F, 2, 2, 16);
	SupportBeamLeft.setRotationPoint(-8F, 22F, 8F);
	SupportBeamLeft.setTextureSize(64, 64);
	SupportBeamLeft.mirror = true;      
	setRotation(SupportBeamLeft, 0F, 1.570796F, 0F);
	CrusherPlate1 = new ModelRenderer(this, 34, 47);
	CrusherPlate1.addBox(0F, 0F, 0F, 9, 13, 2);
	CrusherPlate1.setRotationPoint(-1F, 21F, 6F);
	CrusherPlate1.setTextureSize(64, 64);
	CrusherPlate1.mirror = true;
	setRotation(CrusherPlate1, -2.879793F, 1.570796F, 0F);
	CrusherPlate2 = new ModelRenderer(this, 34, 47);
	CrusherPlate2.addBox(0F, 0F, 0F, 9, 13, 2);
	CrusherPlate2.setRotationPoint(1F, 21F, -3F);
	CrusherPlate2.setTextureSize(64, 64);
	CrusherPlate2.mirror = true;
	setRotation(CrusherPlate2, -2.879793F, -1.570796F, 0F);
	FrontBox = new ModelRenderer(this, 0, 28);
	FrontBox.addBox(0F, 0F, 0F, 14, 14, 4);
	FrontBox.setRotationPoint(-7F, 8F, -7F);
	FrontBox.setTextureSize(64, 64);
	FrontBox.mirror = true;
	setRotation(FrontBox, 0F, 0F, 0F);
	BackPlate = new ModelRenderer(this, 0, 47);
	BackPlate.addBox(0F, 0F, 0F, 14, 14, 1);
	BackPlate.setRotationPoint(-7F, 8F, 6F);
	BackPlate.setTextureSize(64, 64);
	BackPlate.mirror = true;
	setRotation(BackPlate, 0F, 0F, 0F);
	SideRight = new ModelRenderer(this, 0, 0);
	SideRight.addBox(0F, 0F, 0F, 9, 11, 1);
	SideRight.setRotationPoint(-7F, 11F, 6F);
	SideRight.setTextureSize(64, 64);
	SideRight.mirror = true;
	setRotation(SideRight, 0F, 1.570796F, 0F);
	SideLeft = new ModelRenderer(this, 0, 0);
	SideLeft.addBox(0F, 0F, 0F, 9, 11, 1);
	SideLeft.setRotationPoint(6F, 11F, 6F);
	SideLeft.setTextureSize(64, 64);
	SideLeft.mirror = true;
	setRotation(SideLeft, 0F, 1.570796F, 0F);
	BottomPlate = new ModelRenderer(this, 2, 15);
	BottomPlate.addBox(0F, 0F, 0F, 12, 1, 12);
	BottomPlate.setRotationPoint(-6F, 22F, -6F);
	BottomPlate.setTextureSize(64, 64);
	BottomPlate.mirror = true;
	setRotation(BottomPlate, 0F, 0F, 0F);
	InputTop = new ModelRenderer(this, 0, 20);
	InputTop.addBox(0F, 0F, 0F, 6, 6, 1);
	InputTop.setRotationPoint(-3F, 9F, -3F);
	InputTop.setTextureSize(64, 64);
	InputTop.mirror = true;
	setRotation(InputTop, 1.570796F, 0F, 0F);
	OutputBottom = new ModelRenderer(this, 0, 20);
	OutputBottom.addBox(0F, 0F, 0F, 6, 6, 1);
	OutputBottom.setRotationPoint(-3F, 24F, -3F);
	OutputBottom.setTextureSize(64, 64);
	OutputBottom.mirror = true;
	setRotation(OutputBottom, 1.570796F, 0F, 0F);
	PowerConnector = new ModelRenderer(this, 0, 13);
	PowerConnector.addBox(0F, 0F, 0F, 6, 6, 1);
	PowerConnector.setRotationPoint(7F, 13F, 3F);
	PowerConnector.setTextureSize(64, 64);
	PowerConnector.mirror = true;
	setRotation(PowerConnector, 0F, 1.570796F, 0F);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	super.render(entity, f, f1, f2, f3, f4, f5);
	super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	SupportBeamRight.render(f5);
	SupportBeamLeft.render(f5);
	CrusherPlate1.render(f5);
	CrusherPlate2.render(f5);
	FrontBox.render(f5);
	BackPlate.render(f5);
	SideRight.render(f5);
	SideLeft.render(f5);
	BottomPlate.render(f5);
	InputTop.render(f5);
	OutputBottom.render(f5);
	PowerConnector.render(f5);

    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
	model.rotateAngleX = x;
	model.rotateAngleY = y;
	model.rotateAngleZ = z;
    }

    @Override
    public void renderModel(float scale) {
	SupportBeamRight.render(scale);
	SupportBeamLeft.render(scale);
	CrusherPlate1.render(scale);
	CrusherPlate2.render(scale);
	FrontBox.render(scale);
	BackPlate.render(scale);
	SideRight.render(scale);
	SideLeft.render(scale);
	BottomPlate.render(scale);
	InputTop.render(scale);
	OutputBottom.render(scale);
	PowerConnector.render(scale);
    }

    @Override
    public void renderModelAnimated(float scale, float progress) {
	float angle = (float) Math.cos(progress * Math.PI * 6) * 1;
	SupportBeamRight.render(scale);
	SupportBeamLeft.render(scale);

	float translate = 1.3f;

	GL11.glPushMatrix();
	GL11.glTranslatef(0, translate, 0);
	GL11.glRotated(angle, 0, 0, 1);
	GL11.glTranslatef(0, -translate, 0);
	CrusherPlate1.render(scale);
	GL11.glPopMatrix();
	GL11.glPushMatrix();
	GL11.glTranslatef(0, translate, 0);
	GL11.glRotated(-angle, 0, 0, 1);
	GL11.glTranslatef(0, -translate, 0);
	CrusherPlate2.render(scale);
	GL11.glPopMatrix();
	FrontBox.render(scale);
	BackPlate.render(scale);
	SideRight.render(scale);
	SideLeft.render(scale);
	BottomPlate.render(scale);
	InputTop.render(scale);
	OutputBottom.render(scale);
	PowerConnector.render(scale);
    }
}
