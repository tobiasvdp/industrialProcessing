package ip.industrialProcessing.multiblock.dummy.block.liftDoor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.client.render.ModelingMultiblock;

public class MDmultiblockLiftDoor extends ModelingMultiblock {
	// fields
	ModelRenderer front;
	ModelRenderer back;
	ModelRenderer backpanel;
	ModelRenderer frin;
	ModelRenderer bckin;
	ModelRenderer inner;
	ModelRenderer frontpanel;
	private Entity entity;

	public MDmultiblockLiftDoor() {
		textureWidth = 64;
		textureHeight = 64;

		front = new ModelRenderer(this, 0, 46);
		front.addBox(-8F, -8F, -4.5F, 16, 16, 2);
		front.setRotationPoint(0F, 16F, 0F);
		front.setTextureSize(64, 64);
		front.mirror = true;
		setRotation(front, 0F, 0F, 0F);
		back = new ModelRenderer(this, 0, 46);
		back.addBox(-8F, -8F, 2.5F, 16, 16, 2);
		back.setRotationPoint(0F, 16F, 0F);
		back.setTextureSize(64, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		backpanel = new ModelRenderer(this, 0, 29);
		backpanel.addBox(-8F, -8F, 1.5F, 15, 16, 1);
		backpanel.setRotationPoint(0F, 16F, 0F);
		backpanel.setTextureSize(64, 64);
		backpanel.mirror = true;
		setRotation(backpanel, 0F, 0F, 0F);
		frin = new ModelRenderer(this, 0, 0);
		frin.addBox(-8F, -8F, -1.5F, 17, 16, 1);
		frin.setRotationPoint(0F, 16F, 0F);
		frin.setTextureSize(64, 64);
		frin.mirror = true;
		setRotation(frin, 0F, 0F, 0F);
		bckin = new ModelRenderer(this, 0, 0);
		bckin.addBox(-8F, -8F, 0.5F, 17, 16, 1);
		bckin.setRotationPoint(0F, 16F, 0F);
		bckin.setTextureSize(64, 64);
		bckin.mirror = true;
		setRotation(bckin, 0F, 0F, 0F);
		inner = new ModelRenderer(this, 0, 0);
		inner.addBox(-8F, -8F, -0.5F, 16, 16, 1);
		inner.setRotationPoint(0F, 16F, 0F);
		inner.setTextureSize(64, 64);
		inner.mirror = true;
		setRotation(inner, 0F, 0F, 0F);
		frontpanel = new ModelRenderer(this, 0, 29);
		frontpanel.addBox(-8F, -8F, -2.5F, 15, 16, 1);
		frontpanel.setRotationPoint(0F, 16F, 0F);
		frontpanel.setTextureSize(64, 64);
		frontpanel.mirror = true;
		setRotation(frontpanel, 0F, 0F, 0F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		
		GL11.glPushMatrix();
		if(((ENmultiblockLiftDoor)entity).getModelID() == 1){
			GL11.glRotatef(180, 0.0f, 1.0f, 0.0f);
		}else{
			
		}
		
		front.render(f5);
		back.render(f5);
		backpanel.render(f5);
		frin.render(f5);
		bckin.render(f5);
		inner.render(f5);
		frontpanel.render(f5);
		
		GL11.glPopMatrix();
		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		front.render(f5);
		back.render(f5);
		backpanel.render(f5);
		frin.render(f5);
		bckin.render(f5);
		inner.render(f5);
		frontpanel.render(f5);
	}

	public void renderModel(float f5, int connection) {
		GL11.glPushMatrix();
		if(connection == 1){
			GL11.glRotatef(180, 0.0f, 1.0f, 0.0f);
		}else{
			
		}
		front.render(f5);
		back.render(f5);
		backpanel.render(f5);
		frin.render(f5);
		bckin.render(f5);
		inner.render(f5);
		frontpanel.render(f5);
		GL11.glPopMatrix();
	}

}
