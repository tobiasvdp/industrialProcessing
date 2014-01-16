package ip.industrialProcessing.machines.plants.blacksmith.grindingStone.model;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelGrindingStoneAnimated extends ModelAnimatedMachine {
    // fields

    Wheel cillinder = new Wheel();

    public ModelGrindingStoneAnimated() {
    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progressAr) {
	float progress = 0;
	if (progressAr != null && progressAr.length > 0)
	    progress = progressAr[0]*16;

	Vector3f position = new Vector3f(0, 0, 0);
	GL11.glPushMatrix();
	GL11.glTranslatef(0, 1, 0);
	GL11.glRotatef(progress * 360, 1, 0, 0);
	if(tileEntity.getBlockType() != null){
		cillinder.renderMesh(tileEntity.getBlockType().getIcon(0, 0)); 
	}
	GL11.glPopMatrix();
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
    	renderModelAnimated(tileEntity, f, null);
    }

}
