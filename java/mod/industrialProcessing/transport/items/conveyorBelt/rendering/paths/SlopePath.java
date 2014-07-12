package mod.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;
import mod.industrialProcessing.utils.IPMath;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.util.vector.Vector2f;

public class SlopePath extends ItemPath {

	private Vector2f start;
	private Vector2f end;
	private Vector2f mid;
	private float startAngle;
	private float endAngle;

	public SlopePath(TileEntity tl, ConnectionState front, ConnectionState back) {

		float startHeight = 0;
		float endHeight = 0;

		if (tl instanceof TileEntityConveyorConnectionsBase) {
			TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) tl;
			startHeight = -belt.getSlope(LocalDirection.FRONT).getHeight() / 2f;
			endHeight = -belt.getSlope(LocalDirection.BACK).getHeight() / 2f;
		}
		start = new Vector2f(startHeight, -0.5f);
		mid = new Vector2f(0, 0);
		end = new Vector2f(endHeight, 0.5f);
		startAngle = 90 * startHeight;
		endAngle = 90 * -endHeight;
	}

	@Override
	public PathState getPosition(MovingItemStack stack) {

		Vector2f pos = IPMath.bezier(start, mid, end, stack.progress);

		PathState state = new PathState();
		state.x = 0;
		state.y = pos.x;
		state.z = pos.y;
		state.heading = 90 - baseHeading;
		state.pitch = IPMath.lerp(startAngle, endAngle, stack.progress);
		return state;
	}

}
