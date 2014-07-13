package ip.industrialProcessing.client.render;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;

public abstract class ModelAnimatedFluidMachine extends ModelAnimatedMachine {

    public abstract void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon);

}
