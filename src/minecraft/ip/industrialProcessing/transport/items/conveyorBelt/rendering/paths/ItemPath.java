package ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;

public abstract class ItemPath {
	protected static final float baseHeading = 90;
	public abstract PathState getPosition(MovingItemStack stack);
}
