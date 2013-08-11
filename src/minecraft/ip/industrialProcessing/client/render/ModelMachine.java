package ip.industrialProcessing.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.Icon;

public abstract class ModelMachine extends ModelBase {
    public abstract void renderModel(float f);

    protected void setRotation(ModelRenderer model, float x, float y, float z) {
	model.rotateAngleX = x;
	model.rotateAngleY = y;
	model.rotateAngleZ = z;
    }
}
