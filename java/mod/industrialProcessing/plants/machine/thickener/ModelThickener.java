package ip.industrialProcessing.machines.thickener;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;

import javax.swing.Icon;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class ModelThickener extends ModelAnimatedFluidMachine {

    // fields 
    ModelRenderer ThickenerMixer; 

    public ModelThickener() {

	textureWidth = 64;
	textureHeight = 32;
 
	ThickenerMixer = new ModelRenderer(this, 52, 0);
	ThickenerMixer.addBox(-0.5F, -7F, -0.5F, 5, 11, 1);
	ThickenerMixer.setRotationPoint(0F, 17F, 0F);
	ThickenerMixer.setTextureSize(64, 32);
	ThickenerMixer.mirror = true;
	setRotation(ThickenerMixer, 0F, 0F, 1.570796F); 
    }

    @Override
    public void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon) {

    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progresses) {

	float progress = progresses == null || progresses.length < 1 ? 0 : progresses[0];
 
	GL11.glPushMatrix();
	GL11.glRotatef(progress * 360, 0, 1, 0);
	ThickenerMixer.render(f5);
	GL11.glPopMatrix(); 
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
	renderModelAnimated(tileEntity, f, null);
    }

}
