package mod.industrialProcessing.plants.industrialAge.windMill.model;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.tileEntity.ModelTileEntity;
import mod.industrialProcessing.plants.industrialAge.windMill.dummy.TileEntitySails;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class ModelSail extends ModelTileEntity {

	ObjRotator sails = new ObjRotator(new Sail(), 0);
	ObjRotator rot = new ObjRotator(new Rot(), 0);

	IIcon woodtexture = new IIcon() {
		@Override
		public float getMinV() {
		return 0.0f;
		}
		@Override
		public float getMinU() {
		return 0.0f;
		}
		@Override
		public float getMaxV() {
		return 0.5f;
		}
		@Override
		public float getMaxU() {
		return 0.5f;
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
		// TODO Auto-generated method stub
		return 0;
		}
		@Override
		public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
		}
	};
	IIcon sailTexture = new IIcon() {
		@Override
		public float getMinV() {
		return 0.5f;
		}
		@Override
		public float getMinU() {
		return 0.0f;
		}
		@Override
		public float getMaxV() {
		return 1;
		}
		@Override
		public float getMaxU() {
		return 0.5f;
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
		// TODO Auto-generated method stub
		return 0;
		}
		@Override
		public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
		}
	};

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		TileEntitySails tileEntitySails = (TileEntitySails) tileEntity;
		ForgeDirection forward = tileEntitySails.getForwardDirection();
		int dir = BlockContainerIP.getMetadataFromForward(forward);
		switch(forward){
		case NORTH:
			break;
		case SOUTH:
			break;
		case EAST:
			GL11.glRotatef(180, 0.0f, 1.0f,0.0f);
			break;
		case WEST:
			GL11.glRotatef(180, 0.0f, 1.0f,0.0f);
			break;
		}
		GL11.glTranslated(0.0f, 1f, 0.0f);
		GL11.glRotatef(tileEntitySails.rot, 0.0f, 0.0f, 1.0f);
		GL11.glTranslated(0.0f, 0.5f, 0.0f);
		GL11.glPushMatrix();
		rot.getRotated(0).renderMesh(woodtexture);
		sails.getRotated(0).renderMesh(sailTexture);
		GL11.glPopMatrix();
	}
	
	

}
