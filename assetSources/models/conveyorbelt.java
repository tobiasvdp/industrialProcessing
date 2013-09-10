// Date: 10-Sep-13 4:06:16 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelNew extends ModelBase
{
  //fields
    ModelRenderer Front;
    ModelRenderer Back;
    ModelRenderer Left;
    ModelRenderer Right;
    ModelRenderer Front-Back;
    ModelRenderer Left-Right;
    ModelRenderer Right-Front1;
    ModelRenderer Right-Front2;
    ModelRenderer Right-Front3;
    ModelRenderer Right-Front4;
    ModelRenderer Right-Front5;
    ModelRenderer Right-Back1;
    ModelRenderer Right-Back2;
    ModelRenderer Right-Back3;
    ModelRenderer Right-Back4;
    ModelRenderer Right-Back5;
    ModelRenderer Left-Back1;
    ModelRenderer Left-Back2;
    ModelRenderer Left-Back3;
    ModelRenderer Left-Back4;
    ModelRenderer Left-Back5;
    ModelRenderer FrontLeft1;
    ModelRenderer FrontLeft2;
    ModelRenderer FrontLeft3;
    ModelRenderer FrontLeft4;
    ModelRenderer FrontLeft5;
  
  public ModelNew()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Front = new ModelRenderer(this, 0, 0);
      Front.addBox(-2F, 7F, -8F, 4, 1, 4);
      Front.setRotationPoint(0F, 16F, 0F);
      Front.setTextureSize(64, 32);
      Front.mirror = true;
      setRotation(Front, 0F, 0F, 0F);
      Back = new ModelRenderer(this, 0, 0);
      Back.addBox(-2F, 7F, 4F, 4, 1, 4);
      Back.setRotationPoint(0F, 16F, 0F);
      Back.setTextureSize(64, 32);
      Back.mirror = true;
      setRotation(Back, 0F, 0F, 0F);
      Left = new ModelRenderer(this, 0, 0);
      Left.addBox(4F, 7F, -2F, 4, 1, 4);
      Left.setRotationPoint(0F, 16F, 0F);
      Left.setTextureSize(64, 32);
      Left.mirror = true;
      setRotation(Left, 0F, 0F, 0F);
      Right = new ModelRenderer(this, 0, 0);
      Right.addBox(-8F, 7F, -2F, 4, 1, 4);
      Right.setRotationPoint(0F, 16F, 0F);
      Right.setTextureSize(64, 32);
      Right.mirror = true;
      setRotation(Right, 0F, 0F, 0F);
      Front-Back = new ModelRenderer(this, 0, 0);
      Front-Back.addBox(-2F, 7F, -3F, 4, 1, 6);
      Front-Back.setRotationPoint(0F, 24F, 0F);
      Front-Back.setTextureSize(64, 32);
      Front-Back.mirror = true;
      setRotation(Front-Back, 0F, 0F, 0F);
      Left-Right = new ModelRenderer(this, 0, 0);
      Left-Right.addBox(-3F, 7F, -2F, 6, 1, 4);
      Left-Right.setRotationPoint(0F, 24F, 0F);
      Left-Right.setTextureSize(64, 32);
      Left-Right.mirror = true;
      setRotation(Left-Right, 0F, 0F, 0F);
      Right-Front1 = new ModelRenderer(this, 0, 0);
      Right-Front1.addBox(-1F, -1F, 1F, 2, 1, 4);
      Right-Front1.setRotationPoint(-3F, 24F, -3F);
      Right-Front1.setTextureSize(64, 32);
      Right-Front1.mirror = true;
      setRotation(Right-Front1, 0F, 0F, 0F);
      Right-Front2 = new ModelRenderer(this, 0, 0);
      Right-Front2.addBox(-1F, -1F, 1F, 2, 1, 4);
      Right-Front2.setRotationPoint(-3F, 24F, -3F);
      Right-Front2.setTextureSize(64, 32);
      Right-Front2.mirror = true;
      setRotation(Right-Front2, 0F, 1.570796F, 0F);
      Right-Front3 = new ModelRenderer(this, 0, 0);
      Right-Front3.addBox(-1F, -1F, 1F, 2, 1, 4);
      Right-Front3.setRotationPoint(-3F, 24F, -3F);
      Right-Front3.setTextureSize(64, 32);
      Right-Front3.mirror = true;
      setRotation(Right-Front3, 0F, 0.3926991F, 0F);
      Right-Front4 = new ModelRenderer(this, 0, 0);
      Right-Front4.addBox(-1F, -1F, 1F, 2, 1, 4);
      Right-Front4.setRotationPoint(-3F, 24F, -3F);
      Right-Front4.setTextureSize(64, 32);
      Right-Front4.mirror = true;
      setRotation(Right-Front4, 0F, 0.7853982F, 0F);
      Right-Front5 = new ModelRenderer(this, 0, 0);
      Right-Front5.addBox(-1F, -1F, 1F, 2, 1, 4);
      Right-Front5.setRotationPoint(-3F, 24F, -3F);
      Right-Front5.setTextureSize(64, 32);
      Right-Front5.mirror = true;
      setRotation(Right-Front5, 0F, 1.178097F, 0F);
      Right-Back1 = new ModelRenderer(this, 0, 0);
      Right-Back1.addBox(-1F, -1F, -5F, 2, 1, 4);
      Right-Back1.setRotationPoint(-3F, 24F, 3F);
      Right-Back1.setTextureSize(64, 32);
      Right-Back1.mirror = true;
      setRotation(Right-Back1, 0F, 0F, 0F);
      Right-Back2 = new ModelRenderer(this, 0, 0);
      Right-Back2.addBox(-1F, -1F, -5F, 2, 1, 4);
      Right-Back2.setRotationPoint(-3F, 24F, 3F);
      Right-Back2.setTextureSize(64, 32);
      Right-Back2.mirror = true;
      setRotation(Right-Back2, 0F, -1.570796F, 0F);
      Right-Back3 = new ModelRenderer(this, 0, 0);
      Right-Back3.addBox(-1F, -1F, -5F, 2, 1, 4);
      Right-Back3.setRotationPoint(-3F, 24F, 3F);
      Right-Back3.setTextureSize(64, 32);
      Right-Back3.mirror = true;
      setRotation(Right-Back3, 0F, -0.3926991F, 0F);
      Right-Back4 = new ModelRenderer(this, 0, 0);
      Right-Back4.addBox(-1F, -1F, -5F, 2, 1, 4);
      Right-Back4.setRotationPoint(-3F, 24F, 3F);
      Right-Back4.setTextureSize(64, 32);
      Right-Back4.mirror = true;
      setRotation(Right-Back4, 0F, -0.7853982F, 0F);
      Right-Back5 = new ModelRenderer(this, 0, 0);
      Right-Back5.addBox(-1F, -1F, -5F, 2, 1, 4);
      Right-Back5.setRotationPoint(-3F, 24F, 3F);
      Right-Back5.setTextureSize(64, 32);
      Right-Back5.mirror = true;
      setRotation(Right-Back5, 0F, -1.178097F, 0F);
      Left-Back1 = new ModelRenderer(this, 0, 0);
      Left-Back1.addBox(-1F, -1F, -5F, 2, 1, 4);
      Left-Back1.setRotationPoint(3F, 24F, 3F);
      Left-Back1.setTextureSize(64, 32);
      Left-Back1.mirror = true;
      setRotation(Left-Back1, 0F, 0F, 0F);
      Left-Back2 = new ModelRenderer(this, 0, 0);
      Left-Back2.addBox(-1F, -1F, -5F, 2, 1, 4);
      Left-Back2.setRotationPoint(3F, 24F, 3F);
      Left-Back2.setTextureSize(64, 32);
      Left-Back2.mirror = true;
      setRotation(Left-Back2, 0F, 1.570796F, 0F);
      Left-Back3 = new ModelRenderer(this, 0, 0);
      Left-Back3.addBox(-1F, -1F, -5F, 2, 1, 4);
      Left-Back3.setRotationPoint(3F, 24F, 3F);
      Left-Back3.setTextureSize(64, 32);
      Left-Back3.mirror = true;
      setRotation(Left-Back3, 0F, 0.3926991F, 0F);
      Left-Back4 = new ModelRenderer(this, 0, 0);
      Left-Back4.addBox(-1F, -1F, -5F, 2, 1, 4);
      Left-Back4.setRotationPoint(3F, 24F, 3F);
      Left-Back4.setTextureSize(64, 32);
      Left-Back4.mirror = true;
      setRotation(Left-Back4, 0F, 0.7853982F, 0F);
      Left-Back5 = new ModelRenderer(this, 0, 0);
      Left-Back5.addBox(-1F, -1F, -5F, 2, 1, 4);
      Left-Back5.setRotationPoint(3F, 24F, 3F);
      Left-Back5.setTextureSize(64, 32);
      Left-Back5.mirror = true;
      setRotation(Left-Back5, 0F, 1.178097F, 0F);
      FrontLeft1 = new ModelRenderer(this, 0, 0);
      FrontLeft1.addBox(-1F, -1F, 1F, 2, 1, 4);
      FrontLeft1.setRotationPoint(3F, 24F, -3F);
      FrontLeft1.setTextureSize(64, 32);
      FrontLeft1.mirror = true;
      setRotation(FrontLeft1, 0F, 0F, 0F);
      FrontLeft2 = new ModelRenderer(this, 0, 0);
      FrontLeft2.addBox(-1F, -1F, 1F, 2, 1, 4);
      FrontLeft2.setRotationPoint(3F, 24F, -3F);
      FrontLeft2.setTextureSize(64, 32);
      FrontLeft2.mirror = true;
      setRotation(FrontLeft2, 0F, -1.570796F, 0F);
      FrontLeft3 = new ModelRenderer(this, 0, 0);
      FrontLeft3.addBox(-1F, -1F, 1F, 2, 1, 4);
      FrontLeft3.setRotationPoint(3F, 24F, -3F);
      FrontLeft3.setTextureSize(64, 32);
      FrontLeft3.mirror = true;
      setRotation(FrontLeft3, 0F, -0.3926991F, 0F);
      FrontLeft4 = new ModelRenderer(this, 0, 0);
      FrontLeft4.addBox(-1F, -1F, 1F, 2, 1, 4);
      FrontLeft4.setRotationPoint(3F, 24F, -3F);
      FrontLeft4.setTextureSize(64, 32);
      FrontLeft4.mirror = true;
      setRotation(FrontLeft4, 0F, -0.7853982F, 0F);
      FrontLeft5 = new ModelRenderer(this, 0, 0);
      FrontLeft5.addBox(-1F, -1F, 1F, 2, 1, 4);
      FrontLeft5.setRotationPoint(3F, 24F, -3F);
      FrontLeft5.setTextureSize(64, 32);
      FrontLeft5.mirror = true;
      setRotation(FrontLeft5, 0F, -1.178097F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Front.render(f5);
    Back.render(f5);
    Left.render(f5);
    Right.render(f5);
    Front-Back.render(f5);
    Left-Right.render(f5);
    Right-Front1.render(f5);
    Right-Front2.render(f5);
    Right-Front3.render(f5);
    Right-Front4.render(f5);
    Right-Front5.render(f5);
    Right-Back1.render(f5);
    Right-Back2.render(f5);
    Right-Back3.render(f5);
    Right-Back4.render(f5);
    Right-Back5.render(f5);
    Left-Back1.render(f5);
    Left-Back2.render(f5);
    Left-Back3.render(f5);
    Left-Back4.render(f5);
    Left-Back5.render(f5);
    FrontLeft1.render(f5);
    FrontLeft2.render(f5);
    FrontLeft3.render(f5);
    FrontLeft4.render(f5);
    FrontLeft5.render(f5);
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
