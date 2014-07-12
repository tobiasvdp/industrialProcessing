package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class ModelSandCaster extends ModelAnimatedMachine {
    // fields

    private SandCast sand = new SandCast();
    private Icon icon;

    public ModelSandCaster() {
	this.icon = new Icon() {

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
		return "";
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
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f5) {
	renderModelAnimated(tileEntity, f5, new float[] { 0 });
    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f, float[] progressAr) {

	float progress = 0;
	if (progressAr != null && progressAr.length > 0)
	    progress = progressAr[0];

	if (progress >= 0) {
	    GL11.glPushMatrix();
	    GL11.glRotatef(180, 1, 0, 0);
	    GL11.glTranslatef(0, -1, 0);
	    sand.renderMesh(icon);
	    GL11.glPopMatrix();
	}
    }

}
