package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.CornerState;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;
import ip.industrialProcessing.utils.IPMath;

import java.util.Iterator;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.omg.PortableInterceptor.DISCARDING;

@Deprecated
public abstract class ModelConveyorBase extends ModelConnected {

	public ModelConveyorBase() {
	}

	@Override
	public void renderModelConnected(TileEntity tl, float f5, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {

		GL11.glPushMatrix();
		GL11.glTranslatef(0, -0.5f, 0);
		if (tl != null) {

			if (tl instanceof TileEntityConveyorBelt) {

				TileEntityConveyorBelt belt = (TileEntityConveyorBelt) tl;

				SlopeState back = belt.getSlope(LocalDirection.FRONT);
				SlopeState front = belt.getSlope(LocalDirection.BACK);
				CornerState cornerState = null;

				ForgeDirection forward = BlockMachine.getForwardFromEntity(tl);
				if (forward != null) {
					if (back == SlopeState.FLAT && front == SlopeState.FLAT) {
						switch (forward) {
						case NORTH:
							cornerState = drawConnections(tl, east, north, west, south, up, down, f5);
							break;
						case EAST:
							cornerState = drawConnections(tl, north, west, south, east, up, down, f5);
							break;
						case SOUTH:
							cornerState = drawConnections(tl, west, south, east, north, up, down, f5);
							break;
						case WEST:
							cornerState = drawConnections(tl, south, east, north, west, up, down, f5);
							break;
						default:
							cornerState = new CornerState();
							break;
						}

						GL11.glTranslatef(0, 0.5f, 0);
						if (up == ConnectionState.PLUGGED) {
							drawUpPlug(f5, north, east, south, west, up, down);
						}
						if (down == ConnectionState.PLUGGED) {

							drawDownPlug(f5, north, east, south, west, up, down);
						}
						GL11.glTranslatef(0, -0.5f, 0);
					} else {
						switch (forward) {
						case NORTH:
							drawSpline(tl, front, back, south, north, f5);
							break;
						case EAST:
							drawSpline(tl, front, back, east, west, f5);
							break;
						case SOUTH:
							drawSpline(tl, front, back, north, south, f5);
							break;
						case WEST:
							drawSpline(tl, front, back, west, east, f5);
							break;
						default:
							break;
						}
					}
				}
				drawItems(belt, f5, cornerState, front, back);
			}
		}
		GL11.glPopMatrix();
	}

	protected abstract void drawItems(TileEntityConveyorTransportBase belt, float f5, CornerState cornerState, SlopeState front, SlopeState back);

	protected abstract void drawUpPlug(float f5, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down);

	protected abstract void drawDownPlug(float f5, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down);

	protected abstract void drawSpline(TileEntity tl, SlopeState frontSlope, SlopeState backSlope, ConnectionState frontState, ConnectionState backState, float f);

	private CornerState drawConnections(TileEntity tl, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState front, ConnectionState top, ConnectionState bottom, float f5) {
		boolean turn = false;
		CornerState state = new CornerState();
		if (right != ConnectionState.DISCONNECTED && left == ConnectionState.DISCONNECTED && back == ConnectionState.DISCONNECTED) {
			if (top != ConnectionState.DISCONNECTED || bottom != ConnectionState.DISCONNECTED)
				drawCornerRight(f5);
			else {
				drawTurnRight(f5);
				state.rightBend = true;
			}
			turn = true;
		} else if (right == ConnectionState.DISCONNECTED && left != ConnectionState.DISCONNECTED && back == ConnectionState.DISCONNECTED) {
			if (top != ConnectionState.DISCONNECTED || bottom != ConnectionState.DISCONNECTED)
				drawCornerLeft(f5);
			else {
				drawTurnLeft(f5);
				state.leftBend = true;
			}
			turn = true;
		} else {

			if (back != ConnectionState.DISCONNECTED && front != ConnectionState.DISCONNECTED) {
				drawStraightConnection(f5);
			} else {
				drawCenterPiece(f5);
				if (back != ConnectionState.DISCONNECTED) {
					drawBackConnection(f5);
				} else if (front != ConnectionState.DISCONNECTED) {
					drawFrontConnection(f5);
				}
			}

			if (left != ConnectionState.DISCONNECTED) {
				drawLeftConnection(f5);
			}
			if (right != ConnectionState.DISCONNECTED) {
				drawRightConnection(f5);
			}
		}

		if (back == ConnectionState.PLUGGED) {
			drawBackPlug(f5);
		}

		if (left == ConnectionState.PLUGGED) {
			drawLeftPlug(f5);
		}

		if (right == ConnectionState.PLUGGED) {
			drawRightPlug(f5);
		}

		if (front == ConnectionState.PLUGGED) {
			drawFrontPlug(f5);
		}

		return state;
	}

	protected abstract void drawBackPlug(float f5);

	protected abstract void drawFrontPlug(float f5);

	protected abstract void drawLeftPlug(float f5);

	protected abstract void drawRightPlug(float f5);

	protected abstract void drawCenterPiece(float f5);

	protected abstract void drawStraightConnection(float f5);

	protected abstract void drawFrontConnection(float f5);

	protected abstract void drawBackConnection(float f5);

	protected abstract void drawLeftConnection(float f5);

	protected abstract void drawRightConnection(float f5);

	protected abstract void drawCornerLeft(float f5);

	protected abstract void drawCornerRight(float f5);

	protected abstract void drawTurnLeft(float f5);

	protected abstract void drawTurnRight(float f5);
}
