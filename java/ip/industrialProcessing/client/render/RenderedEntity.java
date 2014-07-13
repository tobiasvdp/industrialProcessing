package ip.industrialProcessing.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderedEntity extends Render{
	    private static final ResourceLocation texture = new ResourceLocation("yourmod:textures/entity/yourtexture.png");  //refers to:assets/yourmod/textures/entity/yourtexture.png

		@Override
		public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
			
		}

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {
			return texture;
		}

}
