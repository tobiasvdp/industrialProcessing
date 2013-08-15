package ip.industrialProcessing.client.render;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.Icon;

public abstract class ModelConnectedFluid extends ModelConnected {

    public abstract void renderModelConnectedFluid(float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon);

}
