package ip.industrialProcessing.client.render;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.Entity;

public abstract class ModelEntity extends ModelBase{
	public abstract boolean renderWorld(Entity entity, double d0, double d1, double d2, float f, float f1);
}
