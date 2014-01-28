package ip.industrialProcessing.gui3.containers;

import ip.industrialProcessing.utils.containers.IContainerAdd;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class LayoutContainer extends Container implements IContainerAdd {
 
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) { 
	return true;
    }

    @Override
    public void containerAddSlot(Slot slot) {
	this.addSlotToContainer(slot);
    }

}
