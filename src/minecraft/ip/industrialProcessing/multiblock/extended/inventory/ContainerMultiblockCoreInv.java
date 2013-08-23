package ip.industrialProcessing.multiblock.extended.inventory;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.VerifyingContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerMultiblockCoreInv extends VerifyingContainer {

	protected TileEntityMultiblockCoreInv tileEntity;
	protected Slot[] slots;

	public ContainerMultiblockCoreInv(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity) {
		this.tileEntity = tileEntity;
	}

	public void BindPlayerInventory(InventoryPlayer inventoryPlayer, Container container, int offset) {

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + offset + i * 18, 142));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9;
				addSlotToContainer(new Slot(inventoryPlayer, o, 8 + offset + j * 18, 84 + i * 18));
			}
		}
	}
	public void BindPlayerInventory(InventoryPlayer inventoryPlayer, Container container, int offsetx, int offsety) {

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + offsetx + i * 18, 142+offsety));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9;
				addSlotToContainer(new Slot(inventoryPlayer, o, 8 + offsetx + j * 18, 84+offsety + i * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

	public void containerAddSlot(Slot slot) {
		this.addSlotToContainer(slot);
	}

	public boolean containerMergeItemStack(ItemStack par1ItemStack, int par2,
			int par3, boolean par4) {
		return this.mergeItemStack(par1ItemStack, par2, par3, par4);
	}

	public Slot containerGetSlot(int slot) {
		return getSlot(slot);
	}

	@Override
	protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
		int index = slot.getSlotIndex();
		return this.tileEntity.canInsertItem(index, stack, stack.stackSize);
	}
}
