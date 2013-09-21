package ip.industrialProcessing.client.render;

import ip.industrialProcessing.machines.IRotateableEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public abstract class ModelConnectedOrientedFluidAnimated extends ModelConnectedFluidAnimated {

	@Override
	public void renderModelConnectedFluidAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon, float[] animation) {
		ForgeDirection forward = ForgeDirection.UNKNOWN;
		if (tl instanceof IRotateableEntity) {
			IRotateableEntity rotate = (IRotateableEntity) tl;
			ForgeDirection tlForward = rotate.getForwardDirection();
			if (tlForward != null)
				forward = tlForward;
		}
		switch (forward) {
		default:
		case NORTH:
			renderModelConnectedOrientedFluidAnimated(tl, f, forward, south, east, north, west, up, down, tankSlot, fluidPercentage, icon, animation);
			break;
		case EAST:
			renderModelConnectedOrientedFluidAnimated(tl, f, forward, east, north, west, south, up, down, tankSlot, fluidPercentage, icon, animation);
			break;
		case SOUTH:
			renderModelConnectedOrientedFluidAnimated(tl, f, forward, north, west, south, east, up, down, tankSlot, fluidPercentage, icon, animation);
			break;
		case WEST:
			renderModelConnectedOrientedFluidAnimated(tl, f, forward, west, south, east, north, up, down, tankSlot, fluidPercentage, icon, animation);
			break;
		}
	}

	@Override
	public void renderModelConnectedAnimated(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down, float[] animation) {
		ForgeDirection forward = ForgeDirection.UNKNOWN;
		if (tl instanceof IRotateableEntity) {
			IRotateableEntity rotate = (IRotateableEntity) tl;
			ForgeDirection tlForward = rotate.getForwardDirection();
			if (tlForward != null)
				forward = tlForward;
		}
		switch (forward) {
		default:
		case NORTH:
			renderModelConnectedOrientedAnimated(tl, f, forward, south, east, north, west, up, down, animation);
			break;
		case EAST:
			renderModelConnectedOrientedAnimated(tl, f, forward, east, north, west, south, up, down, animation);
			break;
		case SOUTH:
			renderModelConnectedOrientedAnimated(tl, f, forward, north, west, south, east, up, down, animation);
			break;
		case WEST:
			renderModelConnectedOrientedAnimated(tl, f, forward, west, south, east, north, up, down, animation);
			break;
		}
	}

	protected abstract void renderModelConnectedOrientedAnimated(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down, float[] animation);

	protected abstract void renderModelConnectedOrientedFluidAnimated(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon, float[] animation);
}
