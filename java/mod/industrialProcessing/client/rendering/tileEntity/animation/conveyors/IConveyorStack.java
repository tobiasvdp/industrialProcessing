package mod.industrialProcessing.client.rendering.tileEntity.animation.conveyors;

import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.ItemStack;

public interface IConveyorStack {
	LocalDirection getSource();

	LocalDirection getDestination();

	ItemStack getItemStack();

	float getProgress();
}
