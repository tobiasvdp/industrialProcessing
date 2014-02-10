package ip.industrialProcessing.client.render;

import ip.industrialProcessing.api.config.INamepace;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RendererLivingEntity extends RenderLiving{
	private ResourceLocation texture;
	private ModelingMultiblock model;
	private float par;
	public RendererLivingEntity(ModelBase model, float par, String texture) {
		super(model, par);
		this.texture = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/render/"+ texture +".png");
		this.model = (ModelingMultiblock) model;
		this.par = par;
	}
	
	@Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
