// Date: 9/08/2013 16:07:14
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelMixer extends ModelBase
{
  //fields
    ModelRenderer SupportBeamRightBottom;
    ModelRenderer SupportBeamLeftBottom;
    ModelRenderer WallFront;
    ModelRenderer WallBack;
    ModelRenderer WallRight;
    ModelRenderer WallLeft;
    ModelRenderer BottomPlate;
    ModelRenderer SupportBeamLeftFront;
    ModelRenderer SupportBeamRightFront;
    ModelRenderer SupportBeamLeftBack;
    ModelRenderer SupportBeamRightBack;
    ModelRenderer Liquid;
    ModelRenderer BottomPipe;
    ModelRenderer SupportBeamTop;
    ModelRenderer WaterInput;
    ModelRenderer PowerInput;
    ModelRenderer Mixer;
    ModelRenderer ChunksInput;
    ModelRenderer MixedOutput;
    ModelRenderer MixAxle;
  
  public ModelMixer()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      SupportBeamRightBottom = new ModelRenderer(this, 14, 46);
      SupportBeamRightBottom.addBox(0F, 0F, 0F, 2, 2, 16);
      SupportBeamRightBottom.setRotationPoint(-8F, 22F, -6F);
      SupportBeamRightBottom.setTextureSize(64, 64);
      SupportBeamRightBottom.mirror = true;
      setRotation(SupportBeamRightBottom, 0F, 1.570796F, 0F);
      SupportBeamLeftBottom = new ModelRenderer(this, 14, 46);
      SupportBeamLeftBottom.addBox(0F, 0F, 0F, 2, 2, 16);
      SupportBeamLeftBottom.setRotationPoint(-8F, 22F, 8F);
      SupportBeamLeftBottom.setTextureSize(64, 64);
      SupportBeamLeftBottom.mirror = true;
      setRotation(SupportBeamLeftBottom, 0F, 1.570796F, 0F);
      WallFront = new ModelRenderer(this, 0, 48);
      WallFront.addBox(0F, 0F, 0F, 14, 13, 1);
      WallFront.setRotationPoint(-7F, 9F, -7F);
      WallFront.setTextureSize(64, 64);
      WallFront.mirror = true;
      setRotation(WallFront, 0F, 0F, 0F);
      WallBack = new ModelRenderer(this, 0, 48);
      WallBack.addBox(0F, 0F, 0F, 14, 13, 1);
      WallBack.setRotationPoint(-7F, 9F, 6F);
      WallBack.setTextureSize(64, 64);
      WallBack.mirror = true;
      setRotation(WallBack, 0F, 0F, 0F);
      WallRight = new ModelRenderer(this, 36, 37);
      WallRight.addBox(0F, 0F, 0F, 1, 13, 12);
      WallRight.setRotationPoint(-7F, 9F, -6F);
      WallRight.setTextureSize(64, 64);
      WallRight.mirror = true;
      setRotation(WallRight, 0F, 0F, 0F);
      WallLeft = new ModelRenderer(this, 36, 37);
      WallLeft.addBox(0F, 0F, 0F, 1, 13, 12);
      WallLeft.setRotationPoint(6F, 9F, -6F);
      WallLeft.setTextureSize(64, 64);
      WallLeft.mirror = true;
      setRotation(WallLeft, 0F, 0F, 0F);
      BottomPlate = new ModelRenderer(this, 0, 33);
      BottomPlate.addBox(0F, 0F, 0F, 12, 1, 12);
      BottomPlate.setRotationPoint(-6F, 20F, -6F);
      BottomPlate.setTextureSize(64, 64);
      BottomPlate.mirror = true;
      setRotation(BottomPlate, 0F, 0F, 0F);
      SupportBeamLeftFront = new ModelRenderer(this, 44, 30);
      SupportBeamLeftFront.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamLeftFront.setRotationPoint(5F, 8F, -8F);
      SupportBeamLeftFront.setTextureSize(64, 64);
      SupportBeamLeftFront.mirror = true;
      setRotation(SupportBeamLeftFront, 0F, 0F, 0F);
      SupportBeamRightFront = new ModelRenderer(this, 44, 29);
      SupportBeamRightFront.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamRightFront.setRotationPoint(-6F, 8F, -8F);
      SupportBeamRightFront.setTextureSize(64, 64);
      SupportBeamRightFront.mirror = true;
      setRotation(SupportBeamRightFront, 0F, 0F, 0F);
      SupportBeamLeftBack = new ModelRenderer(this, 44, 30);
      SupportBeamLeftBack.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamLeftBack.setRotationPoint(5F, 8F, 7F);
      SupportBeamLeftBack.setTextureSize(64, 64);
      SupportBeamLeftBack.mirror = true;
      setRotation(SupportBeamLeftBack, 0F, 0F, 0F);
      SupportBeamRightBack = new ModelRenderer(this, 44, 29);
      SupportBeamRightBack.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamRightBack.setRotationPoint(-6F, 8F, 7F);
      SupportBeamRightBack.setTextureSize(64, 64);
      SupportBeamRightBack.mirror = true;
      setRotation(SupportBeamRightBack, 0F, 0F, 0F);
      Liquid = new ModelRenderer(this, -13, 0);
      Liquid.addBox(-6.5F, -0.4666667F, -6.5F, 13, 0, 13);
      Liquid.setRotationPoint(0F, 11F, 0F);
      Liquid.setTextureSize(64, 64);
      Liquid.mirror = true;
      setRotation(Liquid, 0F, 0F, 0F);
      BottomPipe = new ModelRenderer(this, 24, 27);
      BottomPipe.addBox(0F, 0F, 0F, 4, 2, 4);
      BottomPipe.setRotationPoint(-2F, 21F, -2F);
      BottomPipe.setTextureSize(64, 64);
      BottomPipe.mirror = true;
      setRotation(BottomPipe, 0F, 0F, 0F);
      SupportBeamTop = new ModelRenderer(this, 34, 13);
      SupportBeamTop.addBox(-1F, 0F, -6.5F, 2, 1, 13);
      SupportBeamTop.setRotationPoint(0F, 8.5F, 0F);
      SupportBeamTop.setTextureSize(64, 64);
      SupportBeamTop.mirror = true;
      setRotation(SupportBeamTop, 0F, 0F, 0F);
      WaterInput = new ModelRenderer(this, 50, 37);
      WaterInput.addBox(0F, 0F, 0F, 1, 6, 6);
      WaterInput.setRotationPoint(-7F, 13F, 3F);
      WaterInput.setTextureSize(64, 64);
      WaterInput.mirror = true;
      setRotation(WaterInput, 0F, 3.141593F, 0F);
      PowerInput = new ModelRenderer(this, 50, 37);
      PowerInput.addBox(0F, 0F, 0F, 1, 6, 6);
      PowerInput.setRotationPoint(8F, 13F, 3F);
      PowerInput.setTextureSize(64, 64);
      PowerInput.mirror = true;
      setRotation(PowerInput, 0F, 3.141593F, 0F);
      Mixer = new ModelRenderer(this, 0, 17);
      Mixer.addBox(-4.5F, -0.4666667F, -0.5F, 9, 8, 1);
      Mixer.setRotationPoint(0F, 10F, 0F);
      Mixer.setTextureSize(64, 64);
      Mixer.mirror = true;
      setRotation(Mixer, 0F, 0F, 0F);
      ChunksInput = new ModelRenderer(this, 0, 26);
      ChunksInput.addBox(0F, 0F, 0F, 6, 1, 6);
      ChunksInput.setRotationPoint(-3F, 8F, -3F);
      ChunksInput.setTextureSize(64, 64);
      ChunksInput.mirror = true;
      setRotation(ChunksInput, 0F, 0F, 0F);
      MixedOutput = new ModelRenderer(this, 0, 26);
      MixedOutput.addBox(0F, 0F, 0F, 6, 1, 6);
      MixedOutput.setRotationPoint(-3F, 23F, -3F);
      MixedOutput.setTextureSize(64, 64);
      MixedOutput.mirror = true;
      setRotation(MixedOutput, 0F, 0F, 0F);
      MixAxle = new ModelRenderer(this, 44, 29);
      MixAxle.addBox(-0.5F, -0.4666667F, -0.5F, 1, 11, 1);
      MixAxle.setRotationPoint(0F, 9F, 0F);
      MixAxle.setTextureSize(64, 64);
      MixAxle.mirror = true;
      setRotation(MixAxle, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    SupportBeamRightBottom.render(f5);
    SupportBeamLeftBottom.render(f5);
    WallFront.render(f5);
    WallBack.render(f5);
    WallRight.render(f5);
    WallLeft.render(f5);
    BottomPlate.render(f5);
    SupportBeamLeftFront.render(f5);
    SupportBeamRightFront.render(f5);
    SupportBeamLeftBack.render(f5);
    SupportBeamRightBack.render(f5);
    Liquid.render(f5);
    BottomPipe.render(f5);
    SupportBeamTop.render(f5);
    WaterInput.render(f5);
    PowerInput.render(f5);
    Mixer.render(f5);
    ChunksInput.render(f5);
    MixedOutput.render(f5);
    MixAxle.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
