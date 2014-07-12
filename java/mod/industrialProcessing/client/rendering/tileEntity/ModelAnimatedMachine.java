package mod.industrialProcessing.client.rendering.tileEntity;

import net.minecraft.tileentity.TileEntity;

public abstract class ModelAnimatedMachine extends ModelTileEntity {
	public abstract void renderModelAnimated(TileEntity tileEntity, float f, float[] progress);
}
