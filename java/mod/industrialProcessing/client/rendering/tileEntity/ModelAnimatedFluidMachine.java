package mod.industrialProcessing.client.rendering.tileEntity;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public abstract class ModelAnimatedFluidMachine extends ModelAnimatedMachine{
	public abstract void renderModelAnimated(TileEntity tileEntity, float f, float[] progress);
	public abstract void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, IIcon icon);
}
