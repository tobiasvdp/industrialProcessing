package mod.industrialProcessing.client.rendering.tileEntity.connected;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import net.minecraft.tileentity.TileEntity;

public abstract class ModelConnectedFluid extends ModelConnected {

	public abstract void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon);

}
