package ip.industrialProcessing.power.manualGenerator;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class ModelCrankGenerator extends ModelAnimatedMachine {

    // fields
    ModelRenderer SupportLeft;
    ModelRenderer SupportRight;
    ModelRenderer Rotor162;
    ModelRenderer Rotor144;
    ModelRenderer Rotor0;
    ModelRenderer Rotor126;
    ModelRenderer Rotor18m;
    ModelRenderer Rotor108;
    ModelRenderer Rotor36m;
    ModelRenderer Rotor90;
    ModelRenderer Rotor54m;
    ModelRenderer Rotor72;
    ModelRenderer Rotor90m;
    ModelRenderer Rotor36;
    ModelRenderer Rotor72m;
    ModelRenderer Rotor54;
    ModelRenderer Rotor108m;
    ModelRenderer Rotor18;
    ModelRenderer Rotor126m;
    ModelRenderer Rotor180;
    ModelRenderer Rotor144m;
    ModelRenderer Rotor162m;
    ModelRenderer Octagon1;
    ModelRenderer Octagon2;
    ModelRenderer Octagon3;
    ModelRenderer Octagon4;
    ModelRenderer Octagon5;
    ModelRenderer Octagon6;
    ModelRenderer Octagon7;
    ModelRenderer Octagon8;
    ModelRenderer Octagon9;
    ModelRenderer Octagon11;
    ModelRenderer Octagon12;
    ModelRenderer Octagon13;
    ModelRenderer Octagon14;
    ModelRenderer Octagon15;
    ModelRenderer Octagon16;
    ModelRenderer Octagon17;
    ModelRenderer TopBox;
    ModelRenderer BottomBox;
    ModelRenderer Corner1;
    ModelRenderer Corner2;
    ModelRenderer Corner3;
    ModelRenderer Corner4;
    ModelRenderer Corner5;
    ModelRenderer Corner6;
    ModelRenderer Corner7;
    ModelRenderer Corner8;
    ModelRenderer PowerConnector;
    ModelRenderer Crank2;
    ModelRenderer Crank3;
    ModelRenderer Crank1;
    private boolean crank;

    public ModelCrankGenerator(boolean crank) {
	this.crank = crank;
	textureWidth = 64;
	textureHeight = 32;

	SupportLeft = new ModelRenderer(this, 4, 0);
	SupportLeft.addBox(0F, 0F, 0F, 16, 2, 2);
	SupportLeft.setRotationPoint(-8F, 22F, 8F);
	SupportLeft.setTextureSize(64, 32);
	SupportLeft.mirror = true;
	setRotation(SupportLeft, 0F, 1.570796F, 0F);
	SupportRight = new ModelRenderer(this, 4, 0);
	SupportRight.addBox(0F, 0F, 0F, 16, 2, 2);
	SupportRight.setRotationPoint(6F, 22F, 8F);
	SupportRight.setTextureSize(64, 32);
	SupportRight.mirror = true;
	setRotation(SupportRight, 0F, 1.570796F, 0F);
	Rotor162 = new ModelRenderer(this, 0, 0);
	Rotor162.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor162.setRotationPoint(0F, 16F, 0F);
	Rotor162.setTextureSize(64, 32);
	Rotor162.mirror = true;
	setRotation(Rotor162, 0F, 2.827433F, 0F);
	Rotor144 = new ModelRenderer(this, 0, 0);
	Rotor144.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor144.setRotationPoint(0F, 16F, 0F);
	Rotor144.setTextureSize(64, 32);
	Rotor144.mirror = true;
	setRotation(Rotor144, 0F, 2.513274F, 0F);
	Rotor0 = new ModelRenderer(this, 0, 0);
	Rotor0.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor0.setRotationPoint(0F, 16F, 0F);
	Rotor0.setTextureSize(64, 32);
	Rotor0.mirror = true;
	setRotation(Rotor0, 0F, 0F, 0F);
	Rotor126 = new ModelRenderer(this, 0, 0);
	Rotor126.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor126.setRotationPoint(0F, 16F, 0F);
	Rotor126.setTextureSize(64, 32);
	Rotor126.mirror = true;
	setRotation(Rotor126, 0F, 2.199115F, 0F);
	Rotor18m = new ModelRenderer(this, 0, 0);
	Rotor18m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor18m.setRotationPoint(0F, 16F, 0F);
	Rotor18m.setTextureSize(64, 32);
	Rotor18m.mirror = true;
	setRotation(Rotor18m, 0F, -0.3141593F, 0F);
	Rotor108 = new ModelRenderer(this, 0, 0);
	Rotor108.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor108.setRotationPoint(0F, 16F, 0F);
	Rotor108.setTextureSize(64, 32);
	Rotor108.mirror = true;
	setRotation(Rotor108, 0F, 1.884956F, 0F);
	Rotor36m = new ModelRenderer(this, 0, 0);
	Rotor36m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor36m.setRotationPoint(0F, 16F, 0F);
	Rotor36m.setTextureSize(64, 32);
	Rotor36m.mirror = true;
	setRotation(Rotor36m, 0F, -0.6283185F, 0F);
	Rotor90 = new ModelRenderer(this, 0, 0);
	Rotor90.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor90.setRotationPoint(0F, 16F, 0F);
	Rotor90.setTextureSize(64, 32);
	Rotor90.mirror = true;
	setRotation(Rotor90, 0F, 1.570796F, 0F);
	Rotor54m = new ModelRenderer(this, 0, 0);
	Rotor54m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor54m.setRotationPoint(0F, 16F, 0F);
	Rotor54m.setTextureSize(64, 32);
	Rotor54m.mirror = true;
	setRotation(Rotor54m, 0F, -0.9424778F, 0F);
	Rotor72 = new ModelRenderer(this, 0, 0);
	Rotor72.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor72.setRotationPoint(0F, 16F, 0F);
	Rotor72.setTextureSize(64, 32);
	Rotor72.mirror = true;
	setRotation(Rotor72, 0F, 1.256637F, 0F);
	Rotor90m = new ModelRenderer(this, 0, 0);
	Rotor90m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor90m.setRotationPoint(0F, 16F, 0F);
	Rotor90m.setTextureSize(64, 32);
	Rotor90m.mirror = true;
	setRotation(Rotor90m, 0F, -1.570796F, 0F);
	Rotor36 = new ModelRenderer(this, 0, 0);
	Rotor36.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor36.setRotationPoint(0F, 16F, 0F);
	Rotor36.setTextureSize(64, 32);
	Rotor36.mirror = true;
	setRotation(Rotor36, 0F, 0.6283185F, 0F);
	Rotor72m = new ModelRenderer(this, 0, 0);
	Rotor72m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor72m.setRotationPoint(0F, 16F, 0F);
	Rotor72m.setTextureSize(64, 32);
	Rotor72m.mirror = true;
	setRotation(Rotor72m, 0F, -1.256637F, 0F);
	Rotor54 = new ModelRenderer(this, 0, 0);
	Rotor54.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor54.setRotationPoint(0F, 16F, 0F);
	Rotor54.setTextureSize(64, 32);
	Rotor54.mirror = true;
	setRotation(Rotor54, 0F, 0.9424778F, 0F);
	Rotor108m = new ModelRenderer(this, 0, 0);
	Rotor108m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor108m.setRotationPoint(0F, 16F, 0F);
	Rotor108m.setTextureSize(64, 32);
	Rotor108m.mirror = true;
	setRotation(Rotor108m, 0F, -1.884956F, 0F);
	Rotor18 = new ModelRenderer(this, 0, 0);
	Rotor18.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor18.setRotationPoint(0F, 16F, 0F);
	Rotor18.setTextureSize(64, 32);
	Rotor18.mirror = true;
	setRotation(Rotor18, 0F, 0.3141593F, 0F);
	Rotor126m = new ModelRenderer(this, 0, 0);
	Rotor126m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor126m.setRotationPoint(0F, 16F, 0F);
	Rotor126m.setTextureSize(64, 32);
	Rotor126m.mirror = true;
	setRotation(Rotor126m, 0F, -2.199115F, 0F);
	Rotor180 = new ModelRenderer(this, 0, 0);
	Rotor180.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor180.setRotationPoint(0F, 16F, 0F);
	Rotor180.setTextureSize(64, 32);
	Rotor180.mirror = true;
	setRotation(Rotor180, 0F, 3.141593F, 0F);
	Rotor144m = new ModelRenderer(this, 0, 0);
	Rotor144m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor144m.setRotationPoint(0F, 16F, 0F);
	Rotor144m.setTextureSize(64, 32);
	Rotor144m.mirror = true;
	setRotation(Rotor144m, 0F, -2.478368F, 0.0174533F);
	Rotor162m = new ModelRenderer(this, 0, 0);
	Rotor162m.addBox(4F, -2F, -0.5F, 1, 4, 1);
	Rotor162m.setRotationPoint(0F, 16F, 0F);
	Rotor162m.setTextureSize(64, 32);
	Rotor162m.mirror = true;
	setRotation(Rotor162m, 0F, -2.827433F, 0F);
	Octagon1 = new ModelRenderer(this, 4, 4);
	Octagon1.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon1.setRotationPoint(0F, 13F, 0F);
	Octagon1.setTextureSize(64, 32);
	Octagon1.mirror = true;
	setRotation(Octagon1, 0F, 0.7853982F, 0F);
	Octagon2 = new ModelRenderer(this, 4, 4);
	Octagon2.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon2.setRotationPoint(0F, 13F, 0F);
	Octagon2.setTextureSize(64, 32);
	Octagon2.mirror = true;
	setRotation(Octagon2, 0F, -0.7853982F, 0F);
	Octagon3 = new ModelRenderer(this, 4, 4);
	Octagon3.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon3.setRotationPoint(0F, 13F, 0F);
	Octagon3.setTextureSize(64, 32);
	Octagon3.mirror = true;
	setRotation(Octagon3, 0F, -2.356194F, 0F);
	Octagon4 = new ModelRenderer(this, 4, 4);
	Octagon4.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon4.setRotationPoint(0F, 13F, 0F);
	Octagon4.setTextureSize(64, 32);
	Octagon4.mirror = true;
	setRotation(Octagon4, 0F, 1.570796F, 0F);
	Octagon5 = new ModelRenderer(this, 4, 4);
	Octagon5.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon5.setRotationPoint(0F, 13F, 0F);
	Octagon5.setTextureSize(64, 32);
	Octagon5.mirror = true;
	setRotation(Octagon5, 0F, 0F, 0F);
	Octagon6 = new ModelRenderer(this, 4, 4);
	Octagon6.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon6.setRotationPoint(0F, 13F, 0F);
	Octagon6.setTextureSize(64, 32);
	Octagon6.mirror = true;
	setRotation(Octagon6, 0F, 3.141593F, 0F);
	Octagon7 = new ModelRenderer(this, 4, 4);
	Octagon7.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon7.setRotationPoint(0F, 13F, 0F);
	Octagon7.setTextureSize(64, 32);
	Octagon7.mirror = true;
	setRotation(Octagon7, 0F, 2.356194F, 0F);
	Octagon8 = new ModelRenderer(this, 4, 4);
	Octagon8.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon8.setRotationPoint(0F, 18F, 0F);
	Octagon8.setTextureSize(64, 32);
	Octagon8.mirror = true;
	setRotation(Octagon8, 0F, -2.356194F, 0F);
	Octagon9 = new ModelRenderer(this, 4, 4);
	Octagon9.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon9.setRotationPoint(0F, 18F, 0F);
	Octagon9.setTextureSize(64, 32);
	Octagon9.mirror = true;
	setRotation(Octagon9, 0F, -1.570796F, 0F);
	Octagon11 = new ModelRenderer(this, 4, 4);
	Octagon11.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon11.setRotationPoint(0F, 13F, 0F);
	Octagon11.setTextureSize(64, 32);
	Octagon11.mirror = true;
	setRotation(Octagon11, 0F, -1.570796F, 0F);
	Octagon12 = new ModelRenderer(this, 4, 4);
	Octagon12.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon12.setRotationPoint(0F, 18F, 0F);
	Octagon12.setTextureSize(64, 32);
	Octagon12.mirror = true;
	setRotation(Octagon12, 0F, -0.7853982F, 0F);
	Octagon13 = new ModelRenderer(this, 4, 4);
	Octagon13.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon13.setRotationPoint(0F, 18F, 0F);
	Octagon13.setTextureSize(64, 32);
	Octagon13.mirror = true;
	setRotation(Octagon13, 0F, 0F, 0F);
	Octagon14 = new ModelRenderer(this, 4, 4);
	Octagon14.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon14.setRotationPoint(0F, 18F, 0F);
	Octagon14.setTextureSize(64, 32);
	Octagon14.mirror = true;
	setRotation(Octagon14, 0F, 0.7853982F, 0F);
	Octagon15 = new ModelRenderer(this, 4, 4);
	Octagon15.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon15.setRotationPoint(0F, 18F, 0F);
	Octagon15.setTextureSize(64, 32);
	Octagon15.mirror = true;
	setRotation(Octagon15, 0F, 1.570796F, 0F);
	Octagon16 = new ModelRenderer(this, 4, 4);
	Octagon16.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon16.setRotationPoint(0F, 18F, 0F);
	Octagon16.setTextureSize(64, 32);
	Octagon16.mirror = true;
	setRotation(Octagon16, 0F, 2.356194F, 0F);
	Octagon17 = new ModelRenderer(this, 4, 4);
	Octagon17.addBox(-2.5F, 0F, 3.035535F, 5, 1, 3);
	Octagon17.setRotationPoint(0F, 18F, 0F);
	Octagon17.setTextureSize(64, 32);
	Octagon17.mirror = true;
	setRotation(Octagon17, 0F, 3.141593F, 0F);
	TopBox = new ModelRenderer(this, 6, 7);
	TopBox.addBox(0F, 0F, 0F, 14, 4, 14);
	TopBox.setRotationPoint(7F, 13.5F, -7F);
	TopBox.setTextureSize(64, 32);
	TopBox.mirror = true;
	setRotation(TopBox, 0F, 0F, 3.141593F);
	BottomBox = new ModelRenderer(this, 6, 7);
	BottomBox.addBox(0F, 0F, 0F, 14, 4, 14);
	BottomBox.setRotationPoint(-7F, 18.5F, -7F);
	BottomBox.setTextureSize(64, 32);
	BottomBox.mirror = true;
	setRotation(BottomBox, 0F, 0F, 0F);
	Corner1 = new ModelRenderer(this, 12, 13);
	Corner1.addBox(0F, 0F, 0F, 1, 5, 3);
	Corner1.setRotationPoint(-7F, 13.5F, 7F);
	Corner1.setTextureSize(64, 32);
	Corner1.mirror = true;
	setRotation(Corner1, 0F, 1.570796F, 0F);
	Corner2 = new ModelRenderer(this, 6, 15);
	Corner2.addBox(0F, 0F, 0F, 2, 5, 1);
	Corner2.setRotationPoint(7F, 13.5F, -6F);
	Corner2.setTextureSize(64, 32);
	Corner2.mirror = true;
	setRotation(Corner2, 0F, -1.570796F, 0F);
	Corner3 = new ModelRenderer(this, 12, 13);
	Corner3.addBox(0F, 0F, 0F, 1, 5, 3);
	Corner3.setRotationPoint(7F, 13.5F, -7F);
	Corner3.setTextureSize(64, 32);
	Corner3.mirror = true;
	setRotation(Corner3, 0F, -1.570796F, 0F);
	Corner4 = new ModelRenderer(this, 12, 13);
	Corner4.addBox(0F, 0F, 0F, 1, 5, 3);
	Corner4.setRotationPoint(-7F, 13.5F, -7F);
	Corner4.setTextureSize(64, 32);
	Corner4.mirror = true;
	setRotation(Corner4, 0F, 0F, 0F);
	Corner5 = new ModelRenderer(this, 12, 13);
	Corner5.addBox(0F, 0F, 0F, 1, 5, 3);
	Corner5.setRotationPoint(7F, 13.5F, 7F);
	Corner5.setTextureSize(64, 32);
	Corner5.mirror = true;
	setRotation(Corner5, 0F, 3.141593F, 0F);
	Corner6 = new ModelRenderer(this, 6, 15);
	Corner6.addBox(0F, 0F, 0F, 2, 5, 1);
	Corner6.setRotationPoint(6F, 13.5F, 7F);
	Corner6.setTextureSize(64, 32);
	Corner6.mirror = true;
	setRotation(Corner6, 0F, 3.141593F, 0F);
	Corner7 = new ModelRenderer(this, 6, 15);
	Corner7.addBox(0F, 0F, 0F, 2, 5, 1);
	Corner7.setRotationPoint(-7F, 13.5F, 6F);
	Corner7.setTextureSize(64, 32);
	Corner7.mirror = true;
	setRotation(Corner7, 0F, 1.570796F, 0F);
	Corner8 = new ModelRenderer(this, 6, 15);
	Corner8.addBox(0F, 0F, 0F, 2, 5, 1);
	Corner8.setRotationPoint(-6F, 13.5F, -7F);
	Corner8.setTextureSize(64, 32);
	Corner8.mirror = true;
	setRotation(Corner8, 0F, 0F, 0F);
	PowerConnector = new ModelRenderer(this, 0, 8);
	PowerConnector.addBox(-3F, -3F, 0F, 6, 6, 1);
	PowerConnector.setRotationPoint(0F, 16F, 7F);
	PowerConnector.setTextureSize(64, 32);
	PowerConnector.mirror = true;
	setRotation(PowerConnector, 0F, 0F, 0F);
	Crank2 = new ModelRenderer(this, 17, 5);
	Crank2.addBox(-0.5F, 0F, -0.5F, 6, 1, 1);
	Crank2.setRotationPoint(1F, 6.5F, 0F);
	Crank2.setTextureSize(64, 32);
	Crank2.mirror = true;
	setRotation(Crank2, 0F, 0F, 0F);
	Crank3 = new ModelRenderer(this, 14, 8);
	Crank3.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
	Crank3.setRotationPoint(6F, 3.5F, 0F);
	Crank3.setTextureSize(64, 32);
	Crank3.mirror = true;
	setRotation(Crank3, 0F, 0F, 0F);
	Crank1 = new ModelRenderer(this, 14, 8);
	Crank1.addBox(-0.5F, 0F, -0.5F, 1, 3, 1);
	Crank1.setRotationPoint(0F, 6.5F, 0F);
	Crank1.setTextureSize(64, 32);
	Crank1.mirror = true;

    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progress) {
	float angle = progress[0] * 360;
	SupportLeft.render(f5);
	SupportRight.render(f5);
	GL11.glPushMatrix();
	GL11.glRotatef(angle, 0, 1, 0);
	Rotor162.render(f5);
	Rotor144.render(f5);
	Rotor0.render(f5);
	Rotor126.render(f5);
	Rotor18m.render(f5);
	Rotor108.render(f5);
	Rotor36m.render(f5);
	Rotor90.render(f5);
	Rotor54m.render(f5);
	Rotor72.render(f5);
	Rotor90m.render(f5);
	Rotor36.render(f5);
	Rotor72m.render(f5);
	Rotor54.render(f5);
	Rotor108m.render(f5);
	Rotor18.render(f5);
	Rotor126m.render(f5);
	Rotor180.render(f5);
	Rotor144m.render(f5);
	Rotor162m.render(f5);
	if (crank) {
	    Crank2.render(f5);
	    Crank3.render(f5);
	    Crank1.render(f5);
	}
	GL11.glPopMatrix();
	Octagon1.render(f5);
	Octagon2.render(f5);
	Octagon3.render(f5);
	Octagon4.render(f5);
	Octagon5.render(f5);
	Octagon6.render(f5);
	Octagon7.render(f5);
	Octagon8.render(f5);
	Octagon9.render(f5);
	Octagon11.render(f5);
	Octagon12.render(f5);
	Octagon13.render(f5);
	Octagon14.render(f5);
	Octagon15.render(f5);
	Octagon16.render(f5);
	Octagon17.render(f5);
	TopBox.render(f5);
	BottomBox.render(f5);
	Corner1.render(f5);
	Corner2.render(f5);
	Corner3.render(f5);
	Corner4.render(f5);
	Corner5.render(f5);
	Corner6.render(f5);
	Corner7.render(f5);
	Corner8.render(f5);
	PowerConnector.render(f5);
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
	renderModelAnimated(null, f, new float[]{0.36f});
    }

}
