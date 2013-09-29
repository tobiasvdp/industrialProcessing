package ip.industrialProcessing.machines.animation.conveyors;

import ip.industrialProcessing.LocalDirection;
import net.minecraft.item.ItemStack;

public interface IConveyor {

	int getStackCount();
	IConveyorStack getStack(int index);
	void clearStacks();
	void addStack(ItemStack stack, LocalDirection destination, LocalDirection source, float progress); 
}
