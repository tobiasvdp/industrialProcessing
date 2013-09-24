package ip.industrialProcessing.client.render;

import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.api.rendering.ModelMachine;

public abstract class ModelStateMachine extends ModelMachine  {
	public abstract void renderModel(TileEntity tileEntity, float f);

}
