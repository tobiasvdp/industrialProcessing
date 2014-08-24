package mod.industrialProcessing.plants.middleAge.tripHammer.dummy.woodenBar.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import mod.industrialProcessing.plants.middleAge.tripHammer.dummy.woodenBar.TileEntityWoodenBar;

public class ModelWoodenBarAnimated extends ModelAnimatedMachine {

	Bar bar = new Bar();
	
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
		GL11.glPushMatrix();
		int renderConnection = ((TileEntityMultiblockDummy) tileEntity).getModelConnection();
		ForgeDirection dir = ((TileEntityMultiblockDummy) tileEntity).getForwardDirection();
		int turnFactor = -1;
		if(dir == ForgeDirection.WEST || dir == ForgeDirection.EAST){
			turnFactor = 1;
		}else{
			GL11.glRotatef(180,1,0,0);
		}
		
		switch(renderConnection){
		case 0:GL11.glTranslatef(0.0f, 0.0f, 0.0f);break;
		case 1:GL11.glTranslatef(0.0f, 0.0f, 1.0f);break;
		case 2:GL11.glTranslatef(0.0f, 0.0f, 2.0f);break;
		}
		
		GL11.glRotatef(((TileEntityWoodenBar) tileEntity).getRotation()*turnFactor, 1.0f, 0, 0);
		
		switch(renderConnection){
		case 0:GL11.glTranslatef(0.0f, 0.0f, -0.0f);break;
		case 1:GL11.glTranslatef(0.0f, 0.0f, -1.0f);break;
		case 2:GL11.glTranslatef(0.0f, 0.0f, -2.0f);break;
		}
		if(dir == ForgeDirection.WEST || dir == ForgeDirection.EAST){
			GL11.glTranslatef(0f, 1.2f, 0f);
		}else{
			GL11.glTranslatef(0f, -0.95f, 0f);
		}
		
		
		if (((TileEntityMultiblockDummy) tileEntity).getState() == MultiblockState.COMPLETED) {
			
			bar.renderMesh(icon);
			
		}
		
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		// TODO Auto-generated method stub

	}

}
