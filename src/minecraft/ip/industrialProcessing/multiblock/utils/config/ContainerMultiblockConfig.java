package ip.industrialProcessing.multiblock.utils.config;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RendererBlock;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;

public class ContainerMultiblockConfig extends ContainerMultiblockCoreInv {

	private TileEntityMultiblockCoreInv tileEntity;

	public ContainerMultiblockConfig(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv entity) {
		super(inventoryPlayer, entity);
		tileEntity = entity;
		//RendererBlock blockrender = new RendererBlock(ConfigRenderers.getRendererCrusherId(),new TileEntityCrusher());
		//blockrender.
		Holder placeholder = new Holder();
		
		Slot[] slots = new Slot[1];
		slots[0] = new Slot(placeholder, 0, 84-4, 152-10);
		slots[0].putStack(new ItemStack(IndustrialProcessing.blockCrusher));
		
		addSlotToContainer(slots[0]);
	}
	public class Holder implements IInventory{
		ItemStack[] stacks = new ItemStack[1];
		@Override
		public int getSizeInventory() {
			return stacks.length;
		}

		@Override
		public ItemStack getStackInSlot(int i) {
			return stacks[i];
		}

		@Override
		public ItemStack decrStackSize(int i, int j) {
			return null;
		}

		@Override
		public ItemStack getStackInSlotOnClosing(int i) {
			return null;
		}

		@Override
		public void setInventorySlotContents(int i, ItemStack itemstack) {
			stacks[i] = itemstack;
		}

		@Override
		public String getInvName() {
			return null;
		}

		@Override
		public boolean isInvNameLocalized() {
			return false;
		}

		@Override
		public int getInventoryStackLimit() {
			return 0;
		}

		@Override
		public void onInventoryChanged() {
		}

		@Override
		public boolean isUseableByPlayer(EntityPlayer entityplayer) {
			return false;
		}

		@Override
		public void openChest() {
		}

		@Override
		public void closeChest() {	
		}

		@Override
		public boolean isItemValidForSlot(int i, ItemStack itemstack) {
			return true;
		}
		
	}
}
