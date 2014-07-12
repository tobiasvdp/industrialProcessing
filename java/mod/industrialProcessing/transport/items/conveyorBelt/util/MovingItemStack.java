package mod.industrialProcessing.transport.items.conveyorBelt.util;

import mod.industrialProcessing.client.rendering.tileEntity.animation.conveyors.IConveyorStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
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
