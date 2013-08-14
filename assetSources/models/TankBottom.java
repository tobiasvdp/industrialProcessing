// Date: 14/08/2013 22:24:17
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelTank extends ModelBase
{
  //fields
    ModelRenderer TankBottom;
    ModelRenderer Support2;
    ModelRenderer Support1;
    ModelRenderer ViewerBottom4b;
    ModelRenderer ViewerBottom1b;
    ModelRenderer ViewerBottom2b;
    ModelRenderer ViewerBottom3b;
    ModelRenderer ViewerBottom3;
    ModelRenderer ViewerBottom2;
    ModelRenderer ViewerBottom1;
    ModelRenderer ViewerBottom4;
  
  public ModelTank()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      TankBottom = new ModelRenderer(this, 0, 4);
      TankBottom.addBox(0F, 0F, 0F, 14, 15, 14);
      TankBottom.setRotationPoint(-7F, 8F, -7F);
      TankBottom.setTextureSize(64, 64);
      TankBottom.mirror = true;
      setRotation(TankBottom, 0F, 0F, 0F);
      Support2 = new ModelRenderer(this, 0, 0);
      Support2.addBox(0F, 0F, 0F, 16, 2, 2);
      Support2.setRotationPoint(6F, 22F, 8F);
      Support2.setTextureSize(64, 64);
      Support2.mirror = true;
      setRotation(Support2, 0F, 1.570796F, 0F);
      Support1 = new ModelRenderer(this, 0, 0);
      Support1.addBox(0F, 0F, 0F, 16, 2, 2);
      Support1.setRotationPoint(-8F, 22F, 8F);
      Support1.setTextureSize(64, 64);
      Support1.mirror = true;
      setRotation(Support1, 0F, 1.570796F, 0F);
      ViewerBottom4b = new ModelRenderer(this, 0, 4);
      ViewerBottom4b.addBox(0F, 0F, 0F, 4, 1, 1);
      ViewerBottom4b.setRotationPoint(-2F, 22F, -8F);
      ViewerBottom4b.setTextureSize(64, 64);
      ViewerBottom4b.mirror = true;
      setRotation(ViewerBottom4b, 0F, 0F, 0F);
      ViewerBottom1b = new ModelRenderer(this, 42, 0);
      ViewerBottom1b.addBox(0F, 0F, 0F, 1, 15, 1);
      ViewerBottom1b.setRotationPoint(2F, 8F, -8F);
      ViewerBottom1b.setTextureSize(64, 64);
      ViewerBottom1b.mirror = true;
      setRotation(ViewerBottom1b, 0F, 0F, 0F);
      ViewerBottom2b = new ModelRenderer(this, 42, 0);
      ViewerBottom2b.addBox(0F, 0F, 0F, 1, 15, 1);
      ViewerBottom2b.setRotationPoint(-3F, 8F, -8F);
      ViewerBottom2b.setTextureSize(64, 64);
      ViewerBottom2b.mirror = true;
      setRotation(ViewerBottom2b, 0F, 0F, 0F);
      ViewerBottom3b = new ModelRenderer(this, 58, 18);
      ViewerBottom3b.addBox(0F, 0F, 0F, 4, 14, 1);
      ViewerBottom3b.setRotationPoint(-2F, 8F, -8F);
      ViewerBottom3b.setTextureSize(64, 64);
      ViewerBottom3b.mirror = true;
      setRotation(ViewerBottom3b, 0F, 0F, 0F);
      ViewerBottom3 = new ModelRenderer(this, 58, 18);
      ViewerBottom3.addBox(0F, 0F, 0F, 4, 14, 1);
      ViewerBottom3.setRotationPoint(2F, 8F, 8F);
      ViewerBottom3.setTextureSize(64, 64);
      ViewerBottom3.mirror = true;
      setRotation(ViewerBottom3, 0F, 3.141593F, 0F);
      ViewerBottom2 = new ModelRenderer(this, 42, 0);
      ViewerBottom2.addBox(0F, 0F, 0F, 1, 15, 1);
      ViewerBottom2.setRotationPoint(-3F, 8F, 7F);
      ViewerBottom2.setTextureSize(64, 64);
      ViewerBottom2.mirror = true;
      setRotation(ViewerBottom2, 0F, 0F, 0F);
      ViewerBottom1 = new ModelRenderer(this, 42, 0);
      ViewerBottom1.addBox(0F, 0F, 0F, 1, 15, 1);
      ViewerBottom1.setRotationPoint(2F, 8F, 7F);
      ViewerBottom1.setTextureSize(64, 64);
      ViewerBottom1.mirror = true;
      setRotation(ViewerBottom1, 0F, 0F, 0F);
      ViewerBottom4 = new ModelRenderer(this, 0, 4);
      ViewerBottom4.addBox(0F, 0F, 0F, 4, 1, 1);
      ViewerBottom4.setRotationPoint(-2F, 22F, 7F);
      ViewerBottom4.setTextureSize(64, 64);
      ViewerBottom4.mirror = true;
      setRotation(ViewerBottom4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    TankBottom.render(f5);
    Support2.render(f5);
    Support1.render(f5);
    ViewerBottom4b.render(f5);
    ViewerBottom1b.render(f5);
    ViewerBottom2b.render(f5);
    ViewerBottom3b.render(f5);
    ViewerBottom3.render(f5);
    ViewerBottom2.render(f5);
    ViewerBottom1.render(f5);
    ViewerBottom4.render(f5);
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
