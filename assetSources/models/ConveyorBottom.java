// Date: 12/09/2013 16:14:54
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
    ModelRenderer ConnectorBottomCenter;
    ModelRenderer ConnectorBottom;
    ModelRenderer ConnectorBotomEdge1;
    ModelRenderer ConnectorBotomEdge4;
    ModelRenderer ConnectorBotomEdge2;
    ModelRenderer ConnectorBotomEdge3;
    ModelRenderer ConnectorBotomSupport3;
    ModelRenderer ConnectorBotomSupport4;
    ModelRenderer ConnectorBotomSupport2;
    ModelRenderer ConnectorBotomSupport1;
  
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
      ConnectorBottomCenter = new ModelRenderer(this, 18, 3);
      ConnectorBottomCenter.addBox(-3F, -6F, -3F, 6, 3, 6);
      ConnectorBottomCenter.setRotationPoint(0F, 21F, 0F);
      ConnectorBottomCenter.setTextureSize(64, 32);
      ConnectorBottomCenter.mirror = true;
      setRotation(ConnectorBottomCenter, 0F, 0F, 0F);
      ConnectorBottom = new ModelRenderer(this, 18, 3);
      ConnectorBottom.addBox(-3F, -3F, -3F, 6, 1, 6);
      ConnectorBottom.setRotationPoint(0F, 20.8F, 0F);
      ConnectorBottom.setTextureSize(64, 32);
      ConnectorBottom.mirror = true;
      setRotation(ConnectorBottom, 0F, 0F, 3.141593F);
      ConnectorBotomEdge1 = new ModelRenderer(this, 18, 20);
      ConnectorBotomEdge1.addBox(-4F, 0F, 0F, 8, 1, 1);
      ConnectorBotomEdge1.setRotationPoint(-3F, 16F, 0F);
      ConnectorBotomEdge1.setTextureSize(64, 32);
      ConnectorBotomEdge1.mirror = true;
      setRotation(ConnectorBotomEdge1, 0F, -1.570796F, 0F);
      ConnectorBotomEdge4 = new ModelRenderer(this, 18, 15);
      ConnectorBotomEdge4.addBox(-3F, 0F, 0F, 6, 1, 1);
      ConnectorBotomEdge4.setRotationPoint(0F, 16F, 3F);
      ConnectorBotomEdge4.setTextureSize(64, 32);
      ConnectorBotomEdge4.mirror = true;
      setRotation(ConnectorBotomEdge4, 0F, 0F, 0F);
      ConnectorBotomEdge2 = new ModelRenderer(this, 18, 15);
      ConnectorBotomEdge2.addBox(-3F, 0F, 0F, 6, 1, 1);
      ConnectorBotomEdge2.setRotationPoint(0F, 16F, -4F);
      ConnectorBotomEdge2.setTextureSize(64, 32);
      ConnectorBotomEdge2.mirror = true;
      setRotation(ConnectorBotomEdge2, 0F, 0F, 0F);
      ConnectorBotomEdge3 = new ModelRenderer(this, 18, 20);
      ConnectorBotomEdge3.addBox(-4F, 0F, 0F, 8, 1, 1);
      ConnectorBotomEdge3.setRotationPoint(3F, 16F, 0F);
      ConnectorBotomEdge3.setTextureSize(64, 32);
      ConnectorBotomEdge3.mirror = true;
      setRotation(ConnectorBotomEdge3, 0F, 1.570796F, 0F);
      ConnectorBotomSupport3 = new ModelRenderer(this, 40, 15);
      ConnectorBotomSupport3.addBox(-0.5F, 0.5F, -0.5F, 1, 7, 1);
      ConnectorBotomSupport3.setRotationPoint(-4F, 16F, -4F);
      ConnectorBotomSupport3.setTextureSize(64, 32);
      ConnectorBotomSupport3.mirror = true;
      setRotation(ConnectorBotomSupport3, 0F, 0F, 0F);
      ConnectorBotomSupport4 = new ModelRenderer(this, 40, 15);
      ConnectorBotomSupport4.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
      ConnectorBotomSupport4.setRotationPoint(4F, 16.5F, -4F);
      ConnectorBotomSupport4.setTextureSize(64, 32);
      ConnectorBotomSupport4.mirror = true;
      setRotation(ConnectorBotomSupport4, 0F, 0F, 0F);
      ConnectorBotomSupport2 = new ModelRenderer(this, 40, 15);
      ConnectorBotomSupport2.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
      ConnectorBotomSupport2.setRotationPoint(-4F, 16.5F, 4F);
      ConnectorBotomSupport2.setTextureSize(64, 32);
      ConnectorBotomSupport2.mirror = true;
      setRotation(ConnectorBotomSupport2, 0F, 0F, 0F);
      ConnectorBotomSupport1 = new ModelRenderer(this, 40, 15);
      ConnectorBotomSupport1.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
      ConnectorBotomSupport1.setRotationPoint(4F, 16.5F, 4F);
      ConnectorBotomSupport1.setTextureSize(64, 32);
      ConnectorBotomSupport1.mirror = true;
      setRotation(ConnectorBotomSupport1, 0F, 0F, 0F);
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
    ConnectorBottomCenter.render(f5);
    ConnectorBottom.render(f5);
    ConnectorBotomEdge1.render(f5);
    ConnectorBotomEdge4.render(f5);
    ConnectorBotomEdge2.render(f5);
    ConnectorBotomEdge3.render(f5);
    ConnectorBotomSupport3.render(f5);
    ConnectorBotomSupport4.render(f5);
    ConnectorBotomSupport2.render(f5);
    ConnectorBotomSupport1.render(f5);
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