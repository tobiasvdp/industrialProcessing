package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.animation.conveyors.IConveyorStack;
import net.minecraft.item.ItemStack;

public class MovingItemStack implements IConveyorStack {
	public ItemStack stack;
	public LocalDirection source;
	public LocalDirection destination;
	public float progress;
	public boolean routed;

	@Override
	public LocalDirection getSource() {
		return source == null ? LocalDirection.UNKNOWN : source;
	}

	@Override
	public LocalDirection getDestination() {
		return destination == null ? LocalDirection.UNKNOWN : destination;
	}

	@Override
	public ItemStack getItemStack() {
		return stack;
	}

	@Override
	public float getProgress() {
		return progress;
	}
}
