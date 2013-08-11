package ip.industrialProcessing.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public abstract class Model extends ModelBase{  
	public abstract void renderModelAnimated(float f, float progress);
	public void renderLiquid(float f, int tankSlot, float percentageFilled, Icon icon){}
	public void renderModel(TileEntity entity, float f5) {}
}
