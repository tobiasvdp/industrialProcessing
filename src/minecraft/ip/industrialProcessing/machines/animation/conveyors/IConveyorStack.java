package ip.industrialProcessing.machines.animation.conveyors;

import ip.industrialProcessing.LocalDirection;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public interface IConveyorStack {
	LocalDirection getSource();

	LocalDirection getDestination();

	ItemStack getItemStack();

	float getProgress();
}
