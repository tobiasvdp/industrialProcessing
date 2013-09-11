package ip.industrialProcessing.client.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public abstract class ModelAnimatedMachine extends ModelMachine {
	public abstract void renderModelAnimated(TileEntity tileEntity, float f, float[] progress);
}
