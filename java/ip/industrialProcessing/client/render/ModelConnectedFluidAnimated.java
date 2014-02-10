package ip.industrialProcessing.client.render;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;

public abstract class ModelConnectedFluidAnimated extends ModelConnectedFluid {
	public abstract void renderModelConnectedFluidAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon, float[] animation);

	public abstract void renderModelConnectedAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, float[] animation);

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) {
		renderModelConnectedAnimated(null, f, north, east, south, west, up, down, null);
	}

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
		renderModelConnectedFluidAnimated(null, f, north, east, south, west, up, down, tankSlot, fluidPercentage, icon, null);
	}
}
