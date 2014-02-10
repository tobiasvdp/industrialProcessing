package ip.industrialProcessing.transport.items.conveyorInput;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.utils.IExtractFilter;

public class ConveyorImportFilter implements IExtractFilter {

    private ItemStack[] slots;

    public ConveyorImportFilter(ItemStack[] slots) {
	this.slots = slots;
    }

    @Override
    public boolean canAcceptStack(ItemStack stack) {
	if (stack == null)
	    return false;
	boolean allEmpty = true;
	for (int i = 0; i < slots.length; i++) {
	    if (slots[i] != null) {
		allEmpty = false;
		if (slots[i].isItemEqual(stack))
		    return true;
	    }
	}

	return allEmpty;
    }

}
