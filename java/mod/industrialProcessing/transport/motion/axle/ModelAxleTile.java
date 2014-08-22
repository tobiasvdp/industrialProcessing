package mod.industrialProcessing.transport.motion.axle;

import org.lwjgl.opengl.GL11;

import mod.industrialProcessing.client.rendering.tileEntity.ModelTileEntity;
import mod.industrialProcessing.transport.motion.ClusterItemMotion;
import mod.industrialProcessing.transport.motion.ClusterTileEntityMotion;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

public class ModelAxleTile extends ModelTileEntity {
	ModelRenderer plateShape3;

	public ModelAxleTile() {
		textureWidth = 64;
		textureHeight = 64;

		plateShape3 = new ModelRenderer(this, 0, 49);
		plateShape3.addBox(0F, 0F, 0F, 10, 1, 14);
		plateShape3.setRotationPoint(-5F, 17F, -7F);
		plateShape3.setTextureSize(64, 32);
		plateShape3.mirror = true;
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {

		if (tileEntity instanceof ClusterTileEntityMotion) {
			ClusterTileEntityMotion tem = (ClusterTileEntityMotion) tileEntity;
			GL11.glPushMatrix();
			ClusterItemMotion q = tem.getClusterItem();
			if (q != null)
				plateShape3.render(f);
			GL11.glPopMatrix();
		}

	}

}
