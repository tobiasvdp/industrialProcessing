package ip.industrialProcessing.machines;

import net.minecraft.client.model.ModelBase;

public abstract class Model extends ModelBase{  
	public abstract void renderModel(float f) ;
	public abstract void renderModelAnimated(float f, float progress);
}
