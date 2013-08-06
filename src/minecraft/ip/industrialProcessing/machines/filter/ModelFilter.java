	package ip.industrialProcessing.machines.filter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
	public class ModelFilter extends ModelBase
	{
	  //fields
	    ModelRenderer Shape1;
	    ModelRenderer Shape3;
	    ModelRenderer Shape5;
	    ModelRenderer Shape6;
	    ModelRenderer Shape7;
	    ModelRenderer Shape9;
	    ModelRenderer Shape10;
	    ModelRenderer Shape11;
	    ModelRenderer Shape2;
	    ModelRenderer Shape12;
	    ModelRenderer Shape13;
	    ModelRenderer Shape4;
	    ModelRenderer Shape14;
	    
	    Entity entity;
	  
	  public ModelFilter()
	  {
	    textureWidth = 64;
	    textureHeight = 64;
	    
	      Shape1 = new ModelRenderer(this, 0, 43);
	      Shape1.addBox(0F, 0F, 0F, 2, 8, 2);
	      Shape1.setRotationPoint(-8F, 15F, 5F);
	      Shape1.setTextureSize(64, 64);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 0, 44);
	      Shape3.addBox(0F, 0F, 0F, 12, 11, 9);
	      Shape3.setRotationPoint(-6F, 13F, -1F);
	      Shape3.setTextureSize(64, 64);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape5 = new ModelRenderer(this, 0, 24);
	      Shape5.addBox(0F, 0F, 0F, 12, 1, 2);
	      Shape5.setRotationPoint(-6F, 23F, -6F);
	      Shape5.setTextureSize(64, 64);
	      Shape5.mirror = true;
	      setRotation(Shape5, 0F, 0F, 0F);
	      Shape6 = new ModelRenderer(this, 8, 27);
	      Shape6.addBox(0F, 0F, 0F, 2, 1, 16);
	      Shape6.setRotationPoint(-8F, 23F, -8F);
	      Shape6.setTextureSize(64, 64);
	      Shape6.mirror = true;
	      setRotation(Shape6, 0F, 0F, 0F);
	      Shape7 = new ModelRenderer(this, 8, 27);
	      Shape7.addBox(0F, 0F, 0F, 2, 1, 16);
	      Shape7.setRotationPoint(6F, 23F, -8F);
	      Shape7.setTextureSize(64, 64);
	      Shape7.mirror = true;
	      setRotation(Shape7, 0F, 0F, 0F);
	      Shape9 = new ModelRenderer(this, 0, 12);
	      Shape9.addBox(0F, 0F, 0F, 11, 5, 7);
	      Shape9.setRotationPoint(-5.5F, 17F, -7.5F);
	      Shape9.setTextureSize(64, 64);
	      Shape9.mirror = true;
	      setRotation(Shape9, 0.2268928F, 0F, 0F);
	      Shape10 = new ModelRenderer(this, 0, 41);
	      Shape10.addBox(0F, 0F, 0F, 11, 1, 1);
	      Shape10.setRotationPoint(-5.5F, 15.66667F, -1.533333F);
	      Shape10.setTextureSize(64, 64);
	      Shape10.mirror = true;
	      setRotation(Shape10, 0.8748334F, 0F, 0F);
	      Shape11 = new ModelRenderer(this, 0, 43);
	      Shape11.addBox(0F, 0F, 0F, 2, 4, 2);
	      Shape11.setRotationPoint(5.5F, 19F, -6F);
	      Shape11.setTextureSize(64, 64);
	      Shape11.mirror = true;
	      setRotation(Shape11, 0F, 0F, 0F);
	      Shape2 = new ModelRenderer(this, 0, 43);
	      Shape2.addBox(0F, 0F, 0F, 2, 8, 2);
	      Shape2.setRotationPoint(6F, 15F, 5F);
	      Shape2.setTextureSize(64, 64);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape12 = new ModelRenderer(this, 0, 43);
	      Shape12.addBox(0F, 0F, 0F, 2, 4, 2);
	      Shape12.setRotationPoint(-7.5F, 19F, -6F);
	      Shape12.setTextureSize(64, 64);
	      Shape12.mirror = true;
	      setRotation(Shape12, 0F, 0F, 0F);
	      Shape13 = new ModelRenderer(this, 0, 36);
	      Shape13.addBox(0F, 0F, 0F, 10, 4, 1);
	      Shape13.setRotationPoint(-5F, 17F, -7.5F);
	      Shape13.setTextureSize(64, 64);
	      Shape13.mirror = true;
	      setRotation(Shape13, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 0, 29);
	      Shape4.addBox(0F, 0F, 0F, 6, 1, 6);
	      Shape4.setRotationPoint(-3F, 8F, -3F);
	      Shape4.setTextureSize(64, 64);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	      Shape14 = new ModelRenderer(this, 28, 33);
	      Shape14.addBox(0F, 0F, 0F, 4, 6, 4);
	      Shape14.setRotationPoint(-2F, 9F, -2F);
	      Shape14.setTextureSize(64, 64);
	      Shape14.mirror = true;
	      setRotation(Shape14, 0.2443461F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    Shape1.render(f5);
	    Shape3.render(f5);
	    Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape11.render(f5);
	    Shape2.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape4.render(f5);
	    Shape14.render(f5);
	    
	    this.entity = entity;
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	  }
	  public void renderModel(float f1){
		    Shape1.render(f1);
		    Shape2.render(f1);
		    Shape3.render(f1);
		    Shape4.render(f1);
		    Shape5.render(f1);
		    Shape6.render(f1);
		    Shape7.render(f1);
		    Shape9.render(f1);
		    Shape10.render(f1);
		    Shape11.render(f1);
		    Shape12.render(f1);
		    Shape13.render(f1);
		    Shape14.render(f1);
		    
	  }
	}



