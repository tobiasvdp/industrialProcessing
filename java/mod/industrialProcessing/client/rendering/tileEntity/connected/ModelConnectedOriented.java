package mod.industrialProcessing.client.rendering.tileEntity.connected;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ModelConnectedOriented extends ModelConnected {

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {
		ForgeDirection forward = ForgeDirection.UNKNOWN;
		if (tl instanceof IRotateableEntity) {
			IRotateableEntity rotate = (IRotateableEntity) tl;
			forward = rotate.getForwardDirection();
		}
		switch (forward) {
		default:
		case NORTH:
			renderModelConnectedOriented(tl, f, forward, south, east, north, west, up, down);
			break;
		case EAST:
			renderModelConnectedOriented(tl, f, forward, east, north, west, south, up, down);
			break;
		case SOUTH:
			renderModelConnectedOriented(tl, f, forward, north, west, south, east, up, down);
			break;
		case WEST:
			renderModelConnectedOriented(tl, f, forward, west, south, east, north, up, down);
			break;
		}
	}

	protected abstract void renderModelConnectedOriented(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);
}
