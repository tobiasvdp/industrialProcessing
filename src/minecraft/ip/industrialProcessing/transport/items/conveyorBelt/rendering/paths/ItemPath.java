package ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;

import org.lwjgl.util.vector.Vector3f;

public abstract class ItemPath {
	protected static final float baseHeading = 90;
	public abstract PathState getPosition(MovingItemStack stack);
}
