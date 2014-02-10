package ip.industrialProcessing.multiblock.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.IContainerTransfer;

public class ContainerMultiblockInv extends ContainerMultiblock implements IContainerAdd, IContainerTransfer{

	private TileEntityMultiblockCoreInv core;

	public ContainerMultiblockInv(InventoryPlayer inventory,TileEntityMultiblockCoreInv core) {
		super(inventory,core);
		this.core = core;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		if(super.canInteractWith(entityplayer)){
			return this.core.isUseableByPlayer(entityplayer);
		}
		return false;
	}

	@Override
	protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
		int index = slot.getSlotIndex();
		return this.core.canInsertItem(index, stack, stack.stackSize);
	}

	@Override
	public void containerAddSlot(Slot slot) {
		this.addSlotToContainer(slot);
	}

	@Override
	public boolean containerMergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4) {
		return this.mergeItemStack(par1ItemStack, par2, par3, par4);
	}

	@Override
	public Slot containerGetSlot(int slot) {
		return getSlot(slot);
	}

}
