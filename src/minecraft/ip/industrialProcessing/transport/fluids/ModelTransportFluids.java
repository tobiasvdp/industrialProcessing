package ip.industrialProcessing.transport.fluids;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.machines.Model;

public class ModelTransportFluids extends Model{

	    ModelRenderer Shape1;
	    ModelRenderer Shape2;
	    ModelRenderer Shape3;
	    ModelRenderer Shape4;
	    ModelRenderer Shape5;
	    ModelRenderer Shape6;
	    ModelRenderer Shape7;
	    ModelRenderer Shape8;
	    ModelRenderer Shape9;
	    ModelRenderer Shape10;
	    ModelRenderer Shape11;
	    ModelRenderer Shape12;
	    ModelRenderer Shape13;
	    ModelRenderer Shape14;
	    ModelRenderer Shape15;
	    ModelRenderer Shape16;
	    ModelRenderer Shape17;
	    
	    Entity entity;
	  
	  public ModelTransportFluids()
	  {
	    textureWidth = 64;
	    textureHeight = 64;
	    
	      Shape1 = new ModelRenderer(this, 0, 0);
	      Shape1.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
	      Shape1.setRotationPoint(0F, 16F, 0F);
	      Shape1.setTextureSize(64, 32);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0.7853982F, 0F, 0F);
	      Shape2 = new ModelRenderer(this, 0, 0);
	      Shape2.addBox(-1.5F, -1.5F, -1.5F, 7, 3, 3);
	      Shape2.setRotationPoint(2.5F, 16F, 0F);
	      Shape2.setTextureSize(64, 32);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0.7853982F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 0, 0);
	      Shape3.addBox(-1.5F, -1.5F, -1.5F, 7, 3, 3);
	      Shape3.setRotationPoint(-6.5F, 16F, 0F);
	      Shape3.setTextureSize(64, 32);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0.7853982F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 0, 0);
	      Shape4.addBox(-1.5F, -1.5F, -1.5F, 3, 7, 3);
	      Shape4.setRotationPoint(0F, 18.5F, 0F);
	      Shape4.setTextureSize(64, 32);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0.7853982F, 0F);
	      Shape5 = new ModelRenderer(this, 0, 0);
	      Shape5.addBox(-1.5F, -1.5F, -1.5F, 3, 7, 3);
	      Shape5.setRotationPoint(0F, 9.5F, 0F);
	      Shape5.setTextureSize(64, 32);
	      Shape5.mirror = true;
	      setRotation(Shape5, 0F, 0.7853982F, 0F);
	      Shape6 = new ModelRenderer(this, 0, 0);
	      Shape6.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 7);
	      Shape6.setRotationPoint(0F, 16F, 2.5F);
	      Shape6.setTextureSize(64, 32);
	      Shape6.mirror = true;
	      setRotation(Shape6, 0F, 0F, 0.7853982F);
	      Shape7 = new ModelRenderer(this, 0, 0);
	      Shape7.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 7);
	      Shape7.setRotationPoint(0F, 16F, -6.5F);
	      Shape7.setTextureSize(64, 32);
	      Shape7.mirror = true;
	      setRotation(Shape7, 0F, 0F, 0.7853982F);
	      Shape8 = new ModelRenderer(this, 0, 0);
	      Shape8.addBox(-1.5F, -1.5F, -1.5F, 1, 6, 6);
	      Shape8.setRotationPoint(-6.5F, 14.5F, -1.5F);
	      Shape8.setTextureSize(64, 32);
	      Shape8.mirror = true;
	      setRotation(Shape8, 0F, 0F, 0F);
	      Shape9 = new ModelRenderer(this, 0, 0);
	      Shape9.addBox(-1.5F, -1.5F, -1.5F, 1, 5, 5);
	      Shape9.setRotationPoint(-6F, 15F, -1F);
	      Shape9.setTextureSize(64, 32);
	      Shape9.mirror = true;
	      setRotation(Shape9, 0F, 0F, 0F);
	      Shape10 = new ModelRenderer(this, 0, 0);
	      Shape10.addBox(-1.5F, -1.5F, -1.5F, 1, 1, 3);
	      Shape10.setRotationPoint(-7.5F, 13.5F, 0F);
	      Shape10.setTextureSize(64, 32);
	      Shape10.mirror = true;
	      setRotation(Shape10, 0F, 0F, 0F);
	      Shape11 = new ModelRenderer(this, 0, 0);
	      Shape11.addBox(-1.5F, -1.5F, -1.5F, 1, 3, 1);
	      Shape11.setRotationPoint(-7.5F, 16F, 4.5F);
	      Shape11.setTextureSize(64, 32);
	      Shape11.mirror = true;
	      setRotation(Shape11, 0F, 0F, 0F);
	      Shape12 = new ModelRenderer(this, 0, 0);
	      Shape12.addBox(-1.5F, -1.5F, -1.5F, 1, 1, 3);
	      Shape12.setRotationPoint(-7.5F, 20.5F, 0F);
	      Shape12.setTextureSize(64, 32);
	      Shape12.mirror = true;
	      setRotation(Shape12, 0F, 0F, 0F);
	      Shape13 = new ModelRenderer(this, 0, 0);
	      Shape13.addBox(-1.5F, -1.5F, -1.5F, 1, 3, 1);
	      Shape13.setRotationPoint(-7.5F, 16F, -2.5F);
	      Shape13.setTextureSize(64, 32);
	      Shape13.mirror = true;
	      setRotation(Shape13, 0F, 0F, 0F);
	      Shape14 = new ModelRenderer(this, 0, 0);
	      Shape14.addBox(-1.5F, -1.5F, -1.5F, 1, 1, 3);
	      Shape14.setRotationPoint(-8F, 14.5F, 0F);
	      Shape14.setTextureSize(64, 32);
	      Shape14.mirror = true;
	      setRotation(Shape14, 0F, 0F, 0.7853982F);
	      Shape15 = new ModelRenderer(this, 0, 0);
	      Shape15.addBox(-1.5F, -1.5F, -1.5F, 1, 1, 3);
	      Shape15.setRotationPoint(-8F, 20.5F, 0F);
	      Shape15.setTextureSize(64, 32);
	      Shape15.mirror = true;
	      setRotation(Shape15, 0F, 0F, 0.7853982F);
	      Shape16 = new ModelRenderer(this, 0, 0);
	      Shape16.addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1);
	      Shape16.setRotationPoint(-8F, 16F, -3F);
	      Shape16.setTextureSize(64, 32);
	      Shape16.mirror = true;
	      setRotation(Shape16, 0F, 0.7853982F, 0F);
	      Shape17 = new ModelRenderer(this, 0, 0);
	      Shape17.addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1);
	      Shape17.setRotationPoint(-8F, 16F, 3F);
	      Shape17.setTextureSize(64, 32);
	      Shape17.mirror = true;
	      setRotation(Shape17, 0F, 0.7853982F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape11.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape14.render(f5);
	    Shape15.render(f5);
	    Shape16.render(f5);
	    Shape17.render(f5);
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

	@Override
	public void renderModel(World world,int x,int y,int z,float f5) {
		if (world != null){
		TileEntityTransportFluids te = (TileEntityTransportFluids) world.getBlockTileEntity(x, y, z);

		te.senseSides(world);
		ForgeDirection dir = te.getForward();
		
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
	    if (te.isSideConnected(dir.getOpposite())){
	    	Shape6.render(f5);
	    }
	    if (te.isSideConnected(dir)){
	    	Shape7.render(f5);
	    }
	    Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape11.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape14.render(f5);
	    Shape15.render(f5);
	    Shape16.render(f5);
	    Shape17.render(f5);
		}else{
		    Shape1.render(f5);
		    Shape2.render(f5);
		    Shape3.render(f5);
		    Shape8.render(f5);
		    Shape9.render(f5);
		    Shape10.render(f5);
		    Shape11.render(f5);
		    Shape12.render(f5);
		    Shape13.render(f5);
		    Shape14.render(f5);
		    Shape15.render(f5);
		    Shape16.render(f5);
		    Shape17.render(f5);
		}
	}

	@Override
	public void renderModelAnimated(float f5, float progress) {
	}

}
