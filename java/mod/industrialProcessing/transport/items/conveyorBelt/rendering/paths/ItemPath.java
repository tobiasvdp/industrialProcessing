package mod.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;

public abstract class ItemPath {
	protected static final float baseHeading = 90;
	public abstract PathState getPosition(MovingItemStack stack);
}
