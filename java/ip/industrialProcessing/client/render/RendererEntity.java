package ip.industrialProcessing.client.render;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model.ModelBobcatMiner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererEntity extends Render{
	
	private ModelEntity model;
	private ResourceLocation texture;

	public RendererEntity(ModelEntity model, String texture) {
		super();
		this.texture = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/render/"+ texture +".png");
		this.model = (ModelEntity) model;
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		GL11.glPushMatrix();
        TextureManager texturemanager = this.renderManager.renderEngine;

        if (texturemanager != null)
        {
            texturemanager.bindTexture(texture);
        }
		GL11.glTranslatef((float)( d0), (float)( d1+0.5), (float) (d2));
		GL11.glRotatef((-entity.rotationYaw), 0, 1, 0);
		model.renderWorld(entity, d0, d1, d2, f, f1);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
