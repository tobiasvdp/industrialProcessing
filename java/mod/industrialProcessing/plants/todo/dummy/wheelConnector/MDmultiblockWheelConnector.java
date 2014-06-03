package mod.industrialProcessing.plants.todo.dummy.wheelConnector;

import ip.industrialProcessing.client.render.ModelingMultiblock;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class MDmultiblockWheelConnector extends ModelingMultiblock {

	// fields
	ModelRenderer base;
	ModelRenderer Bottom;
	ModelRenderer bottomright;
	ModelRenderer top;
	ModelRenderer extratopleft;
	ModelRenderer extratopright;
	ModelRenderer extrqtop;
	ModelRenderer bottomleft;
	ModelRenderer Shape1;
	private Entity entity;

	public MDmultiblockWheelConnector() {
		textureWidth = 64;
		textureHeight = 32;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(-8F, 0F, 2F, 16, 16, 6);
		base.setRotationPoint(0F, 8F, 0F);
		base.setTextureSize(64, 32);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		Bottom = new ModelRenderer(this, 44, 0);
		Bottom.addBox(-3F, 1F, 0F, 6, 12, 2);
		Bottom.setRotationPoint(0F, 11F, 0F);
		Bottom.setTextureSize(64, 32);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		bottomright = new ModelRenderer(this, 60, 0);
		bottomright.addBox(-4F, 1F, 1F, 1, 13, 1);
		bottomright.setRotationPoint(0F, 10F, 0F);
		bottomright.setTextureSize(64, 32);
		bottomright.mirror = true;
		setRotation(bottomright, 0F, 0F, 0F);
		top = new ModelRenderer(this, 0, 22);
		top.addBox(-3F, 1F, 0F, 6, 1, 1);
		top.setRotationPoint(0F, 10F, 1F);
		top.setTextureSize(64, 32);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		extratopleft = new ModelRenderer(this, 0, 24);
		extratopleft.addBox(3F, 1F, 1F, 1, 3, 1);
		extratopleft.setRotationPoint(0F, 7F, 0F);
		extratopleft.setTextureSize(64, 32);
		extratopleft.mirror = true;
		setRotation(extratopleft, 0F, 0F, 0F);
		extratopright = new ModelRenderer(this, 0, 24);
		extratopright.addBox(-4F, 1F, 1F, 1, 3, 1);
		extratopright.setRotationPoint(0F, 7F, 0F);
		extratopright.setTextureSize(64, 32);
		extratopright.mirror = true;
		setRotation(extratopright, 0F, 0F, 0F);
		extrqtop = new ModelRenderer(this, 5, 26);
		extrqtop.addBox(-3F, 1F, 0F, 6, 4, 2);
		extrqtop.setRotationPoint(0F, 7F, 0F);
		extrqtop.setTextureSize(64, 32);
		extrqtop.mirror = true;
		setRotation(extrqtop, 0F, 0F, 0F);
		bottomleft = new ModelRenderer(this, 60, 0);
		bottomleft.addBox(3F, 1F, 1F, 1, 13, 1);
		bottomleft.setRotationPoint(0F, 10F, 0F);
		bottomleft.setTextureSize(64, 32);
		bottomleft.mirror = true;
		setRotation(bottomleft, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 0);
	      Shape1.addBox(-1F, -1F, -0.5F, 2, 2, 1);
	      Shape1.setRotationPoint(0F, 16F, 0F);
	      Shape1.setTextureSize(64, 32);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		base.render(f5);
		Bottom.render(f5);
		bottomright.render(f5);
		top.render(f5);
		extratopleft.render(f5);
		extratopright.render(f5);
		extrqtop.render(f5);
		bottomleft.render(f5);
		Shape1.render(f5);
		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		base.render(f5);
		Bottom.render(f5);
		bottomright.render(f5);
		top.render(f5);
		extratopleft.render(f5);
		extratopright.render(f5);
		extrqtop.render(f5);
		bottomleft.render(f5);
		Shape1.render(f5);
	}

	@Override
	public void renderModel(float f5, int connection) {
		GL11.glPushMatrix();
		GL11.glRotatef(90f, 0.0f, 1.0f, 0.0f);

		base.render(f5);
		Bottom.render(f5);
		bottomright.render(f5);
		top.render(f5);
		bottomleft.render(f5);
		Shape1.render(f5);
		if (connection == 1) {
			extratopleft.render(f5);
			extratopright.render(f5);
			extrqtop.render(f5);
		}
		GL11.glPopMatrix();
	}
	@Override
	public void renderModel(float f5, int connection, float[] animation) {
		GL11.glPushMatrix();
		GL11.glRotatef(180f, 0.0f, 1.0f, 0.0f);

		base.render(f5);
		Bottom.render(f5);
		bottomright.render(f5);
		top.render(f5);
		bottomleft.render(f5);
		if (connection == 1) {
			extratopleft.render(f5);
			extratopright.render(f5);
			extrqtop.render(f5);
		}
		
		
		
		GL11.glTranslatef(0.0f, 1.0f, 0.0f);
		float angle = (animation[0]);
		if(connection == 0){
			GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f);
		}else{
			GL11.glRotatef(-angle, 0.0f, 0.0f, 1.0f);
		}
		GL11.glTranslatef(0.0f, -1.0f, 0.0f);
		Shape1.render(f5);
		GL11.glPopMatrix();
	}
}
