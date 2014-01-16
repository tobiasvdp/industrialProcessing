package ip.industrialProcessing.machines.classifier;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.machines.classifier.model.ClassifierSpiral;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class ModelClassifier extends ModelAnimatedFluidMachine {

    private ClassifierSpiral spiral;

    // fields

    public ModelClassifier() {
	textureWidth = 64;
	textureHeight = 32;

	this.spiral = new ClassifierSpiral();
    }

    @Override
    public void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon) {
	if (tankSlot == 0) {
	    float par1 = -6.5f;
	    float par2 = -6.5f;
	    float par3 = 15f + 5f * (1 - percentageFilled);
	    int par4 = 13;
	    int par5 = 13;
	    Tessellator tessellator = Tessellator.instance;
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0, -1, 0);
	    tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMinU(), icon.getMinV());
	    tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMaxU(), icon.getMinV());
	    tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMaxU(), icon.getMaxV());
	    tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMinU(), icon.getMaxV());
	    tessellator.draw();
	}
    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progressAr) {

	Icon icon = new Icon() {

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
		return "Booh";
	    }
	};
	float progress = 0;
	if (progressAr != null && progressAr.length > 0)
	    progress = progressAr[0];
	GL11.glPushMatrix();
	GL11.glTranslatef(0, 17/16f, 0);
	GL11.glRotatef(-180, 0, 1, 0);
	GL11.glRotatef(10, 1, 0, 0);
	GL11.glRotated(progress * 3600, 0, 0, 1);
	GL11.glTranslatef(0, -1/16f, 0);
	spiral.renderMesh(icon);
	GL11.glPopMatrix();
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
	renderModelAnimated(tileEntity, f, null);
    }

}
