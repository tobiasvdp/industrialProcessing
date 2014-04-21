package ip.industrialProcessing.machines.diskFilter;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.machines.diskFilter.model.Cylinder;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelDiskFilter extends ModelAnimatedMachine {
    // fields

    Cylinder cillinder = new Cylinder();

    public ModelDiskFilter() {
    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progressAr) {
	float progress = 0;
	if (progressAr != null && progressAr.length > 0)
	    progress = progressAr[0];

	Vector3f position = new Vector3f(0, 0, 0);
	GL11.glPushMatrix();
	GL11.glRotatef(-90, 0, 1, 0);
	GL11.glTranslatef(0, 1, 0);
	GL11.glRotatef(progress * 360, 1, 0, 0);
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
		return (float)d0;
	    }
	    
	    @Override
	    public float getInterpolatedU(double d0) { 
		return (float)d0;
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
	cillinder.renderMesh(icon); 
	GL11.glPopMatrix();
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
	renderModelAnimated(tileEntity, f, null);
    }

}
