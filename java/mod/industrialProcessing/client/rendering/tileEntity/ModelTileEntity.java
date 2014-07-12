package mod.industrialProcessing.client.rendering.tileEntity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

public abstract class ModelTileEntity extends ModelBase {
	public abstract void renderModel(TileEntity tileEntity, float f);

	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
