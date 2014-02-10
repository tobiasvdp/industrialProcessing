package ip.industrialProcessing.client.render;

import ip.industrialProcessing.machines.IRotateableEntity;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ModelConnectedOrientedFluid extends ModelConnectedFluid {

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
		ForgeDirection forward = ForgeDirection.UNKNOWN;
		if (tl instanceof IRotateableEntity) {
			IRotateableEntity rotate = (IRotateableEntity) tl;
			ForgeDirection tlForward = rotate.getForwardDirection();
			if(tlForward != null)
				forward = tlForward;
		}
		switch (forward) {
		default:
		case NORTH:
			renderModelConnectedOrientedFluid(tl, f, forward, south, east, north, west, up, down, tankSlot, fluidPercentage, icon);
			break;
		case EAST:
			renderModelConnectedOrientedFluid(tl, f, forward, east, north, west, south, up, down, tankSlot, fluidPercentage, icon);
			break;
		case SOUTH:
			renderModelConnectedOrientedFluid(tl, f, forward, north, west, south, east, up, down, tankSlot, fluidPercentage, icon);
			break;
		case WEST:
			renderModelConnectedOrientedFluid(tl, f, forward, west, south, east, north, up, down, tankSlot, fluidPercentage, icon);
			break;
		}
	}

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {
		ForgeDirection forward = ForgeDirection.UNKNOWN;
		if (tl instanceof IRotateableEntity) {
			IRotateableEntity rotate = (IRotateableEntity) tl;
			ForgeDirection tlForward = rotate.getForwardDirection();
			if(tlForward != null)
				forward = tlForward;
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

	protected abstract void renderModelConnectedOrientedFluid(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon);
}
