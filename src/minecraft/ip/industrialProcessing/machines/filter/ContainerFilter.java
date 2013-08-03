package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.IContainerTranster;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFilter extends Container implements IContainerTranster,
		IContainerAdd {

	protected TileEntityFilter tileEntity;

	Slot inputSlot;
	Slot outputSmallSlot;
	Slot outputBigSlot;

	public ContainerFilter(InventoryPlayer inventoryPlayer,
			TileEntityFilter tileEntity) {
		inputSlot = new Slot(tileEntity, 0, 16, 16);
		outputSmallSlot = new Slot(tileEntity, 2, 48, 16);
		outputBigSlot = new Slot(tileEntity, 1, 32, 32);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSmallSlot);
		addSlotToContainer(outputBigSlot);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this); 
		this.tileEntity = tileEntity;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		return ContainerUtils.TransferStackInSlot(player, slotIndex,
				tileEntity, this);
	}

	@Override
	public boolean containerMergeItemStack(ItemStack par1ItemStack, int par2,
			int par3, boolean par4) {
		return mergeItemStack(par1ItemStack, par2, par3, par4);
	}

	@Override
	public Slot containerGetSlot(int slot) {
		return (Slot) this.inventorySlots.get(slot);
	}

	@Override
	public void containerAddSlot(Slot slot) {
		this.addSlotToContainer(slot);
	}

}
