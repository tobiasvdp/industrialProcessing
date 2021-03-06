package ip.industrialProcessing.transport.steve.railway.suspended.cart;

import ip.industrialProcessing.IndustrialProcessing;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFloatingCart extends Render{

	ModelFloatingCart model;
	private static final ResourceLocation texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/ModelWheel.png"); 
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d0, (float)d1+1f, (float)d2);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		bindTexture(texture);
		model.render(entity, 0, 0, 0, 0, 0, 0.0625F);
		GL11.glPopMatrix();
	}
	
	public RenderFloatingCart(ModelFloatingCart model, float shadow){
		this.model = model;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
