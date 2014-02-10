package ip.industrialProcessing.machines.animation.conveyors;

import ip.industrialProcessing.LocalDirection;
import net.minecraft.item.ItemStack;

public interface IConveyorStack {
	LocalDirection getSource();

	LocalDirection getDestination();

	ItemStack getItemStack();

	float getProgress();
}
