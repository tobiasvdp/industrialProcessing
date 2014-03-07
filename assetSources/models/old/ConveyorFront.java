// Date: 12/09/2013 14:35:29
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelConveyor extends ModelBase
{
  //fields
    ModelRenderer InputLeftElev;
    ModelRenderer InputRight;
    ModelRenderer InputRightElev;
    ModelRenderer InputLeft;
    ModelRenderer Forward;
    ModelRenderer ConnectorFront;
    ModelRenderer ConnectorFrontSide1;
    ModelRenderer ConnectorFrontSide3;
    ModelRenderer ConnectorFrontSide2;
    ModelRenderer ConnectorFrontSide5;
    ModelRenderer ConnectorFrontSide6;
    ModelRenderer ConnectorFrontSide4;
  
  public ModelConveyor()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      InputLeftElev = new ModelRenderer(this, 0, 24);
      InputLeftElev.addBox(-4F, -3F, 0F, 8, 3, 1);
      InputLeftElev.setRotationPoint(6F, 24F, 0F);
      InputLeftElev.setTextureSize(64, 32);
      InputLeftElev.mirror = true;
      setRotation(InputLeftElev, 1.047198F, 1.570796F, 0F);
      InputRight = new ModelRenderer(this, 0, 21);
      InputRight.addBox(-4F, -8F, 0F, 8, 2, 1);
      InputRight.setRotationPoint(0F, 24F, 0F);
      InputRight.setTextureSize(64, 32);
      InputRight.mirror = true;
      setRotation(InputRight, 1.570796F, 1.570796F, 0F);
      InputRightElev = new ModelRenderer(this, 0, 17);
      InputRightElev.addBox(-4F, -3F, 0F, 8, 3, 1);
      InputRightElev.setRotationPoint(-6F, 24F, 0F);
      InputRightElev.setTextureSize(64, 32);
      InputRightElev.mirror = true;
      setRotation(InputRightElev, 1.047198F, -1.570796F, 0F);
      InputLeft = new ModelRenderer(this, 0, 28);
      InputLeft.addBox(-4F, -8F, 0F, 8, 2, 1);
      InputLeft.setRotationPoint(0F, 24F, 0F);
      InputLeft.setTextureSize(64, 32);
      InputLeft.mirror = true;
      setRotation(InputLeft, 1.570796F, -1.570796F, 0F);
      Forward = new ModelRenderer(this, 0, 0);
      Forward.addBox(-4F, 0F, 0F, 8, 16, 1);
      Forward.setRotationPoint(0F, 24F, -8F);
      Forward.setTextureSize(64, 32);
      Forward.mirror = true;
      setRotation(Forward, 1.570796F, 0F, 0F);
      ConnectorFront = new ModelRenderer(this, 18, 3);
      ConnectorFront.addBox(-3F, -3F, -3F, 6, 6, 6);
      ConnectorFront.setRotationPoint(0F, 16F, 5F);
      ConnectorFront.setTextureSize(64, 32);
      ConnectorFront.mirror = true;
      setRotation(ConnectorFront, 0F, 0F, 0F);
      ConnectorFrontSide1 = new ModelRenderer(this, 18, 15);
      ConnectorFrontSide1.addBox(0F, 0F, 0F, 6, 4, 1);
      ConnectorFrontSide1.setRotationPoint(-4F, 14F, 8F);
      ConnectorFrontSide1.setTextureSize(64, 32);
      ConnectorFrontSide1.mirror = true;
      setRotation(ConnectorFrontSide1, 0F, 1.570796F, 0F);
      ConnectorFrontSide3 = new ModelRenderer(this, 18, 20);
      ConnectorFrontSide3.addBox(0F, 0F, 0F, 8, 4, 1);
      ConnectorFrontSide3.setRotationPoint(-4F, 14F, 1F);
      ConnectorFrontSide3.setTextureSize(64, 32);
      ConnectorFrontSide3.mirror = true;
      setRotation(ConnectorFrontSide3, 0F, 0F, 0F);
      ConnectorFrontSide2 = new ModelRenderer(this, 18, 15);
      ConnectorFrontSide2.addBox(0F, 0F, 0F, 6, 4, 1);
      ConnectorFrontSide2.setRotationPoint(3F, 14F, 8F);
      ConnectorFrontSide2.setTextureSize(64, 32);
      ConnectorFrontSide2.mirror = true;
      setRotation(ConnectorFrontSide2, 0F, 1.570796F, 0F);
      ConnectorFrontSide5 = new ModelRenderer(this, 36, 3);
      ConnectorFrontSide5.addBox(0F, 0F, 0F, 4, 5, 1);
      ConnectorFrontSide5.setRotationPoint(-4F, 18F, 8F);
      ConnectorFrontSide5.setTextureSize(64, 32);
      ConnectorFrontSide5.mirror = true;
      setRotation(ConnectorFrontSide5, 0F, 1.570796F, 0F);
      ConnectorFrontSide6 = new ModelRenderer(this, 34, 27);
      ConnectorFrontSide6.addBox(0F, 0F, 0F, 6, 4, 1);
      ConnectorFrontSide6.setRotationPoint(3F, 19F, 8F);
      ConnectorFrontSide6.setTextureSize(64, 32);
      ConnectorFrontSide6.mirror = true;
      setRotation(ConnectorFrontSide6, 0F, 3.141593F, 0F);
      ConnectorFrontSide4 = new ModelRenderer(this, 36, 3);
      ConnectorFrontSide4.addBox(0F, 0F, 0F, 4, 5, 1);
      ConnectorFrontSide4.setRotationPoint(3F, 18F, 8F);
      ConnectorFrontSide4.setTextureSize(64, 32);
      ConnectorFrontSide4.mirror = true;
      setRotation(ConnectorFrontSide4, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    InputLeftElev.render(f5);
    InputRight.render(f5);
    InputRightElev.render(f5);
    InputLeft.render(f5);
    Forward.render(f5);
    ConnectorFront.render(f5);
    ConnectorFrontSide1.render(f5);
    ConnectorFrontSide3.render(f5);
    ConnectorFrontSide2.render(f5);
    ConnectorFrontSide5.render(f5);
    ConnectorFrontSide6.render(f5);
    ConnectorFrontSide4.render(f5);
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