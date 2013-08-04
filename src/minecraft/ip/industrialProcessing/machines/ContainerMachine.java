package ip.industrialProcessing.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

public class ContainerMachine extends VerifyingContainer implements
		IContainerAdd {

	private TileEntityMachine tileEntity;

	public ContainerMachine(InventoryPlayer inventoryPlayer,
			TileEntityMachine tileEntity) {
		this.tileEntity = tileEntity;
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

	@Override
	protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
		int index = slot.getSlotIndex();
		return this.tileEntity.canInsertItem(index, stack, stack.stackSize);
	}

	@Override
	public void containerAddSlot(Slot slot) {
		this.addSlotToContainer(slot);
	}
}
