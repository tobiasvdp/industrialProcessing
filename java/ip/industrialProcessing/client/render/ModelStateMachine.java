package ip.industrialProcessing.client.render;

import ip.industrialProcessing.api.rendering.ModelMachine;
import net.minecraft.tileentity.TileEntity;

public abstract class ModelStateMachine extends ModelMachine  {
	@Override
	public abstract void renderModel(TileEntity tileEntity, float f);

}
