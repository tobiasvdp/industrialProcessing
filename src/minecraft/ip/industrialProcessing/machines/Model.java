package ip.industrialProcessing.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public abstract class Model extends ModelBase{  
	public abstract void renderModelAnimated(float f, float progress);
	public void renderLiquid(float f, int tankSlot, float percentageFilled, Icon icon){}
	public void renderModel(World world,int x,int y,int z, float f5) {}
}
