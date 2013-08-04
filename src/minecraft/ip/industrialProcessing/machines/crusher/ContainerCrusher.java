package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrusher extends ContainerMachine{

	protected TileEntityCrusher tileEntityCrusher;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntityCrusher.isUseableByPlayer(entityplayer);
	}
	
	public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileEntityCrusher) {
		super(inventoryPlayer, tileEntityCrusher);
		this.tileEntityCrusher = tileEntityCrusher;
		
        addSlotToContainer(new Slot(tileEntityCrusher, 0, 44, 33));
        addSlotToContainer(new Slot(tileEntityCrusher, 1, 8, 33));

        ContainerUtils.BindPlayerInventory(inventoryPlayer,this,0);
		
		
	}
	

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            //null checks and checks if the item can be stacked (maxStackSize > 1)
            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    //merges the item into player inventory since its in the tileEntity
                    if (slot < 9) {
                            if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
                                    return null;
                            }
                    }
                    //places it into the tileEntity if possible 
                    else if (!this.mergeItemStackSeperator(stackInSlot, 0, 9, false)) {
                            return null;
            		}
                    if (stackInSlot.stackSize == 0) {
                            slotObject.putStack(null);
                    } else {
                            slotObject.onSlotChanged();
                    }

                    if (stackInSlot.stackSize == stack.stackSize) {
                            return null;
                    }
                    slotObject.onPickupFromSlot(player, stackInSlot);
            }
            return stack;
    }

    protected boolean mergeItemStackSeperator(ItemStack par1ItemStack, int par2, int par3, boolean par4)
    {
        boolean flag1 = false;
        int k = par2;

        if (par4)
        {
            k = par3 - 1;
        }

        Slot slot;
        ItemStack itemstack1;

        if (par1ItemStack.isStackable())
        {
            while (par1ItemStack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2))
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (itemstack1 != null && itemstack1.itemID == par1ItemStack.itemID && (!par1ItemStack.getHasSubtypes() || par1ItemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1))
                {
                    int l = itemstack1.stackSize + par1ItemStack.stackSize;

                    if (l <= par1ItemStack.getMaxStackSize())
                    {
                    	if (tileEntityCrusher.isItemValidForSlot(k, par1ItemStack)){
	                        par1ItemStack.stackSize = 0;
	                        itemstack1.stackSize = l;
	                        slot.onSlotChanged();
	                        flag1 = true;
                    	}
                    }
                    else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize())
                    {
                    	if (tileEntityCrusher.isItemValidForSlot(k, par1ItemStack)){
	                        par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;
	                        itemstack1.stackSize = par1ItemStack.getMaxStackSize();
	                        slot.onSlotChanged();
	                        flag1 = true;
                    	}
                    }
                }

                if (par4)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }

        if (par1ItemStack.stackSize > 0)
        {
            if (par4)
            {
                k = par3 - 1;
            }
            else
            {
                k = par2;
            }

            while (!par4 && k < par3 || par4 && k >= par2)
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (itemstack1 == null)
                {
                	if (tileEntityCrusher.isItemValidForSlot(k, par1ItemStack)){
	                    slot.putStack(par1ItemStack.copy());
	                    slot.onSlotChanged();
	                    par1ItemStack.stackSize = 0;
	                    flag1 = true;
	                    break;
                	}
                }

                if (par4)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }

        return flag1;
    }

	@Override
	public void containerAddSlot(Slot slot) { 
		this.addSlotToContainer(slot);
	}



}
