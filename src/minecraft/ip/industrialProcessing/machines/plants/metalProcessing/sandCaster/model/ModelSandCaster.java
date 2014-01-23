package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class ModelSandCaster extends ModelAnimatedMachine {
    // fields

    private SandCast sand = new SandCast();
    private Icon icon;

    public ModelSandCaster() {
	this.icon = new Icon() {

	    @Override
	    public int getOriginY() {
		return 0;
	    }

	    @Override
	    public int getOriginX() {
		return 0;
	    }

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
	};
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f5) {
	sand.renderMesh(icon);
    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f, float[] progress) {
	sand.renderMesh(icon);
    }

}
