package ip.industrialProcessing.subMod.blackSmith.plant.forge.model;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.TileEntityForgeCore;

public class ModelForgeAnimated extends ModelAnimatedMachine {

	ObjMesh coal = new Coal();
	EntityItem entity;
	EntityItem entityOutput;

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f, float[] progressAr) {
		float progress = 0;
		if (progressAr != null && progressAr.length > 0)
			progress = progressAr[0];
		TileEntityForgeCore core = (TileEntityForgeCore) tileEntity;
		if (core.getState() == MultiblockState.COMPLETED) {
			
			Vector3f position = new Vector3f(0, 0, 0);
			GL11.glPushMatrix();
			GL11.glRotatef(-180, 0, 0, 1);
			GL11.glTranslatef(0f, 0, -0.1f);
			GL11.glTranslatef(0, (float) Math.min(Math.max(-0.3, (core.burnTime - 20000) / (float) 20000 * 0.3f), 0f), 0);
			Icon icon = new Icon() {

				@Override
				public float getMinV() {
					return 0;
				}

				@Override
				public float getMinU() {
					return 0;
				}

				@Override
				public float getMaxV() {
					return 1;
				}

				@Override
				public float getMaxU() {
					return 1;
				}

				@Override
				public float getInterpolatedV(double d0) {
					return (float) d0;
				}

				@Override
				public float getInterpolatedU(double d0) {
					return (float) d0;
				}

				@Override
				public String getIconName() {
					return "Booh";
				}

				@Override
				public int getIconWidth() {
					return 0;
				}

				@Override
				public int getIconHeight() {
					return 0;
				}
			};
			coal.renderMesh(icon);
			ItemStack stack = core.getStackInSlot(0);
			if(stack != null){
				if(entity == null){
					entity = new EntityItem(tileEntity.worldObj,tileEntity.xCoord,tileEntity.yCoord,tileEntity.zCoord);
				}
				entity.age = 0;
				entity.setEntityItemStack(stack);
				RenderItem itemrenderer = (RenderItem) RenderManager.instance.getEntityClassRenderObject(EntityItem.class);
				float scale = 1.5f;
				float oneOverScale = 1f / scale;
				GL11.glPushMatrix();
				GL11.glScalef(oneOverScale, oneOverScale, oneOverScale);
				GL11.glRotatef(180, 1, 0, 0);
				itemrenderer.doRenderItem(entity, 0, 0f, 0, 0, f);
				GL11.glPopMatrix();
			}
			
			stack = core.getStackInSlot(1);
			if(stack != null){
				if(entityOutput == null){
					entityOutput = new EntityItem(tileEntity.worldObj,tileEntity.xCoord,tileEntity.yCoord,tileEntity.zCoord);
				}
				entityOutput.setEntityItemStack(stack);
				entityOutput.age = 0;
				RenderItem itemrenderer = (RenderItem) RenderManager.instance.getEntityClassRenderObject(EntityItem.class);
				float scale = 1f;
				float oneOverScale = 1f / scale;
				GL11.glPushMatrix();
				GL11.glScalef(oneOverScale, oneOverScale, oneOverScale);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(0f, -0.5f, 0.0f);
				itemrenderer.doRenderItem(entityOutput, 0, 0f, 0, 0, f);
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(tileEntity, f, null);
	}

}
