package ip.industrialProcessing.client.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public abstract class ModelConnectedFluid extends ModelConnected {

	public abstract void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon);

}
