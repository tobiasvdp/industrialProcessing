package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import net.minecraft.item.ItemStack;

public class MovingItemStack {
	public ItemStack stack;
	public LocalDirection source;
	public LocalDirection destination;
	public float progress;
	public boolean routed;
}
