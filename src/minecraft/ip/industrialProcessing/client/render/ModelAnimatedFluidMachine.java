package ip.industrialProcessing.client.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public abstract class ModelAnimatedFluidMachine extends ModelAnimatedMachine {

    public abstract void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon);

}
