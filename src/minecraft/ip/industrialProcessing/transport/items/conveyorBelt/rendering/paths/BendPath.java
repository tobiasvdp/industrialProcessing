package ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;

public class BendPath extends ItemPath {

	private boolean left;

	public BendPath(boolean left) {
		this.left = left;

	}

	@Override
	public PathState getPosition(MovingItemStack stack) {
		PathState pos = new PathState();

		float angleProgress = stack.progress * (float) Math.PI / 2;

		if (left) {
			pos.x = -0.5f + (float) Math.sin(angleProgress) * 0.5f;
			pos.z = 0.5f - (float) Math.cos(angleProgress) * 0.5f; 
			pos.heading = ItemPath.baseHeading - 180 + angleProgress / (float) Math.PI * 180;
		}else
		{
			pos.x = 0.5f - (float) Math.sin(angleProgress) * 0.5f;
			pos.z = 0.5f - (float) Math.cos(angleProgress) * 0.5f; 
			pos.heading = ItemPath.baseHeading - angleProgress / (float) Math.PI * 180;			
		}
		return pos;
	}
}
