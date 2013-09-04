package ip.industrialProcessing.client.render;

import java.lang.ProcessBuilder.Redirect;

import org.lwjgl.opengl.GL11;

import buildcraft.core.render.RenderEntityBlock;
import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RendererLivingEntity extends RenderLiving{
	private static final ResourceLocation texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/MDmultiblockFramePanel.png");
	private ModelingMultiblock model;
	private float par;
	public RendererLivingEntity(ModelBase model, float par) {
		super(model, par);
		this.model = (ModelingMultiblock) model;
		this.par = par;
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}
}
