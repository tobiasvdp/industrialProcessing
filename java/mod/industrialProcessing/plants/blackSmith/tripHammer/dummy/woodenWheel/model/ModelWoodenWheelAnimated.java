package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenWheel.model;

import org.lwjgl.opengl.GL11;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenWheel.TileEntityWoodenWheel;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelWoodenWheelAnimated extends ModelAnimatedMachine {

	ObjMesh wheel1 = new WheelPart1();
	ObjMesh wheel2 = new WheelPart2();
	ObjMesh wheel3 = new WheelPart3();
	ObjMesh wheel4 = new WheelPart4();
	
	IIcon icon = new IIcon() {

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
			return 1f;
		}

		@Override
		public float getMaxU() {
			return 1f;
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
	public void renderModelAnimated(TileEntity tileEntity, float f, float[] progress) {

		if (((TileEntityMultiblockDummy) tileEntity).getState() == MultiblockState.COMPLETED) {
			
			GL11.glPushMatrix();

			ForgeDirection forward = BlockContainerIP.getForwardFromEntity(tileEntity);
			int renderConnection = ((TileEntityMultiblockDummy) tileEntity).getModelConnection();

			IIcon iconWood = icon;
			ForgeDirection dir = ((TileEntityMultiblockDummy) tileEntity).getForwardDirection();
			
			GL11.glPushMatrix();
			
			
			int turnFactor = -1;
			if(dir == ForgeDirection.WEST || dir == ForgeDirection.EAST){
				GL11.glTranslatef(0, 0f, -1.0f);
				turnFactor = 1;
			}
			
			GL11.glPushMatrix();
			
			if (renderConnection == 2) {
				
				GL11.glTranslatef(1f, 1.0f, 0.5f);
				GL11.glRotatef(((TileEntityWoodenWheel)tileEntity).getRotation()*turnFactor, 1.0f, 0, 0);
				GL11.glTranslatef(-1f, -1.0f, -0.5f);
				
				GL11.glTranslatef(0, 1.5f, 1.0f);
				wheel3.renderMesh(iconWood);
				GL11.glTranslatef(0, 0, -1.0f);
				wheel4.renderMesh(iconWood);
				GL11.glTranslatef(0, -1.0f, 0);
				wheel1.renderMesh(iconWood);
				GL11.glTranslatef(0, 0, 1.0f);
				wheel2.renderMesh(iconWood);
			}	
			if (renderConnection == 6) {
				GL11.glTranslatef(0f, 0.0f, 1f);
				GL11.glRotatef(180, 0, 1.0f, 0);
				
				GL11.glTranslatef(1f, 1.0f, 0.5f);
				GL11.glRotatef(-((TileEntityWoodenWheel)tileEntity).getRotation()*turnFactor, 1.0f, 0, 0);
				GL11.glTranslatef(-1f, -1.0f, -0.5f);
				
				GL11.glTranslatef(0, 1.5f, 1.0f);
				wheel3.renderMesh(iconWood);
				GL11.glTranslatef(0, 0, -1.0f);
				wheel4.renderMesh(iconWood);
				GL11.glTranslatef(0, -1.0f, 0);
				wheel1.renderMesh(iconWood);
				GL11.glTranslatef(0, 0, 1.0f);
				wheel2.renderMesh(iconWood);
			}
			
			GL11.glPopMatrix();
			GL11.glPopMatrix();

			GL11.glPopMatrix();

		}

	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		// TODO Auto-generated method stub

	}

}
