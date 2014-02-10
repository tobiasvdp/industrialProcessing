package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedOriented;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ModelOrientedConveyorBase extends ModelConnectedOriented {

	@Override
	protected void renderModelConnectedOriented(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {

		if (front.isConnected() && (left.isConnected() != right.isConnected()) && !back.isConnected()) {
			if (left.isConnected()) {
				renderLeftToFrontBend(tl, f, forward, front, right, back, left, up, down);
			} else {
				renderRightToFrontBend(tl, f, forward, front, right, back, left, up, down);
			}
		} else {
			if (front.isConnected() && back.isConnected()) {
				renderStraight(tl, f, forward, front, right, back, left, up, down);
			} else {
				renderCenterPiece(tl, f, forward, front, right, back, left, up, down);
				if (back.isConnected())
					renderBack(tl, f, forward, front, right, back, left, up, down);
				if (front.isConnected())
					renderFront(tl, f, forward, front, right, back, left, up, down);
			}
			if (left.isConnected())
				renderLeft(tl, f, forward, front, right, back, left, up, down);
			if (right.isConnected())
				renderRight(tl, f, forward, front, right, back, left, up, down);
		}
		if (up.isConnected())
			renderUp(tl, f, forward, front, right, back, left, up, down);

		if (down.isConnected())
			renderDown(tl, f, forward, front, right, back, left, up, down);
	}

	protected abstract void renderDown(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderUp(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderLeft(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderRight(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderFront(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderBack(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderCenterPiece(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderLeftToFrontBend(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderRightToFrontBend(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

	protected abstract void renderStraight(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down);

}
