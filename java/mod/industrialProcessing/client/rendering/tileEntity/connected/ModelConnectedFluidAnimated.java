package mod.industrialProcessing.client.rendering.tileEntity.connected;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public abstract class ModelConnectedFluidAnimated extends ModelConnectedFluid {
	public abstract void renderModelConnectedFluidAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, IIcon icon, float[] animation);

	public abstract void renderModelConnectedAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, float[] animation);

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) {
		renderModelConnectedAnimated(null, f, north, east, south, west, up, down, null);
	}

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, IIcon icon) {
		renderModelConnectedFluidAnimated(null, f, north, east, south, west, up, down, tankSlot, fluidPercentage, icon, null);
	}
}
