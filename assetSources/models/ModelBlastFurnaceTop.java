// Date: 13-Aug-13 1:58:33 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelModel extends ModelBase
{
  //fields
    ModelRenderer ouputLeft;
    ModelRenderer outputBottom;
    ModelRenderer outputRight;
    ModelRenderer outputBack;
    ModelRenderer barRight;
    ModelRenderer barBottom;
    ModelRenderer barBack;
    ModelRenderer barLeft;
    ModelRenderer barLeftUnder;
    ModelRenderer barRightUnder;
    ModelRenderer barBackUnder;
  
  public ModelModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      ouputLeft = new ModelRenderer(this, 14, 10);
      ouputLeft.addBox(0F, 0F, 0F, 1, 6, 6);
      ouputLeft.setRotationPoint(7F, 13F, -3F);
      ouputLeft.setTextureSize(64, 64);
      ouputLeft.mirror = true;
      setRotation(ouputLeft, 0F, 0F, 0F);
      outputBottom = new ModelRenderer(this, 8, 0);
      outputBottom.addBox(0F, 0F, 0F, 6, 1, 6);
      outputBottom.setRotationPoint(-3F, 23F, -3F);
      outputBottom.setTextureSize(64, 64);
      outputBottom.mirror = true;
      setRotation(outputBottom, 0F, 0F, 0F);
      outputRight = new ModelRenderer(this, 0, 10);
      outputRight.addBox(0F, 0F, 0F, 1, 6, 6);
      outputRight.setRotationPoint(-8F, 13F, -3F);
      outputRight.setTextureSize(64, 64);
      outputRight.mirror = true;
      setRotation(outputRight, 0F, 0F, 0F);
      outputBack = new ModelRenderer(this, 0, 22);
      outputBack.addBox(0F, 0F, 0F, 6, 6, 1);
      outputBack.setRotationPoint(-3F, 13F, 7F);
      outputBack.setTextureSize(64, 64);
      outputBack.mirror = true;
      setRotation(outputBack, 0F, 0F, 0F);
      barRight = new ModelRenderer(this, 0, 0);
      barRight.addBox(-1F, 0F, -1F, 2, 8, 2);
      barRight.setRotationPoint(0.5F, 17F, 0F);
      barRight.setTextureSize(64, 64);
      barRight.mirror = true;
      setRotation(barRight, 0F, 0F, 1.745329F);
      barBottom = new ModelRenderer(this, 0, 0);
      barBottom.addBox(-1F, 0F, -1F, 2, 6, 2);
      barBottom.setRotationPoint(0F, 17F, 0F);
      barBottom.setTextureSize(64, 64);
      barBottom.mirror = true;
      setRotation(barBottom, 0F, 0F, 0F);
      barBack = new ModelRenderer(this, 0, 0);
      barBack.addBox(-1F, 0F, -1F, 2, 8, 2);
      barBack.setRotationPoint(0F, 17F, -0.5F);
      barBack.setTextureSize(64, 64);
      barBack.mirror = true;
      setRotation(barBack, 1.745329F, 0F, 0F);
      barLeft = new ModelRenderer(this, 0, 0);
      barLeft.addBox(-1F, 0F, -1F, 2, 8, 2);
      barLeft.setRotationPoint(-0.5F, 17F, 0F);
      barLeft.setTextureSize(64, 64);
      barLeft.mirror = true;
      setRotation(barLeft, 0F, 0F, -1.745329F);
      barLeftUnder = new ModelRenderer(this, 0, 0);
      barLeftUnder.addBox(-1F, 0F, -1F, 1, 9, 2);
      barLeftUnder.setRotationPoint(7F, 16F, 0F);
      barLeftUnder.setTextureSize(64, 64);
      barLeftUnder.mirror = true;
      setRotation(barLeftUnder, 0F, 0F, 0F);
      barRightUnder = new ModelRenderer(this, 0, 0);
      barRightUnder.addBox(-1F, 0F, -1F, 1, 9, 2);
      barRightUnder.setRotationPoint(-6F, 16F, 0F);
      barRightUnder.setTextureSize(64, 64);
      barRightUnder.mirror = true;
      setRotation(barRightUnder, 0F, 0F, 0F);
      barBackUnder = new ModelRenderer(this, 0, 0);
      barBackUnder.addBox(-1F, 0F, -1F, 2, 9, 1);
      barBackUnder.setRotationPoint(0F, 16F, 7F);
      barBackUnder.setTextureSize(64, 64);
      barBackUnder.mirror = true;
      setRotation(barBackUnder, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    ouputLeft.render(f5);
    outputBottom.render(f5);
    outputRight.render(f5);
    outputBack.render(f5);
    barRight.render(f5);
    barBottom.render(f5);
    barBack.render(f5);
    barLeft.render(f5);
    barLeftUnder.render(f5);
    barRightUnder.render(f5);
    barBackUnder.render(f5);
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