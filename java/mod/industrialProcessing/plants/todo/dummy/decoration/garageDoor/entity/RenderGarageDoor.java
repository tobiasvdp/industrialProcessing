package mod.industrialProcessing.plants.todo.dummy.decoration.garageDoor.entity;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;


public class RenderGarageDoor extends Render{

		ModelEntityGarageDoor model;
		private static final ResourceLocation texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/ModelGarage.png"); 
		
		@Override
		public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
			ForgeDirection forward= ((EntityGarageDoor)entity).getForwardDirection();
			int dir = BlockMachine.getMetadataFromForward(forward); 
			GL11.glPushMatrix();
			GL11.glTranslatef((float)(d0), (float)(d1+1.5), (float)(d2));
			GL11.glRotatef((dir * -90F), 0F, 1F, 0F);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			bindTexture(texture);
			model.render(entity, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glPopMatrix();
		}
		
		public RenderGarageDoor(ModelEntityGarageDoor model){
			this.model = model;
		}

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {
			return texture;
		}

}
