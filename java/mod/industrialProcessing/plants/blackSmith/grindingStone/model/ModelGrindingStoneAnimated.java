package mod.industrialProcessing.plants.blackSmith.grindingStone.model;

import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelGrindingStoneAnimated extends ModelAnimatedMachine {
    // fields

    Wheel cillinder = new Wheel();

    public ModelGrindingStoneAnimated() {
    }
    
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
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progressAr) {
	float progress = 0;
	if (progressAr != null && progressAr.length > 0)
	    progress = progressAr[0]*16;

	Vector3f position = new Vector3f(0, 0, 0);
	GL11.glPushMatrix();
	GL11.glTranslatef(0, 1, 0);
	GL11.glRotatef(progress * 360, 1, 0, 0);
		cillinder.renderMesh(icon); 
	GL11.glPopMatrix();
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
    	renderModelAnimated(tileEntity, f, null);
    }

}
