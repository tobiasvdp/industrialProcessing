package ip.industrialProcessing.client.render;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;

public abstract class ModelConnectedFluid extends ModelConnected {

	public abstract void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon);

}
