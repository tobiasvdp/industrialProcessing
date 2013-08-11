package ip.industrialProcessing.client.render;

import net.minecraft.util.Icon;

public abstract class ModelAnimatedFluidMachine extends ModelAnimatedMachine {

    public abstract void renderLiquid(float f, int tankSlot, float percentageFilled, Icon icon);

}
