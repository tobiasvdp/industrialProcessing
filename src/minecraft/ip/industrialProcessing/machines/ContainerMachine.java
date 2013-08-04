package ip.industrialProcessing.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.IContainerTransfer;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

public class ContainerMachine extends VerifyingContainer implements
		IContainerAdd, IContainerTransfer {

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
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
    	return ContainerUtils.TransferStackInSlot(player, slot, tileEntity, this);
    }

	@Override
	public boolean containerMergeItemStack(ItemStack par1ItemStack, int par2,
			int par3, boolean par4) {
		return this.mergeItemStack(par1ItemStack, par2, par3, par4);
	}

	@Override
	public Slot containerGetSlot(int slot) {
		return getSlot(slot);
	}
}
