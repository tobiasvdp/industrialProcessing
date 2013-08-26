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
				
//		ItemStack[][][] layout = entity.getItemStackLayout();
//		
//		int size = layout.length * layout[0].length * layout[0][0].length;
//		int xbase = (3-layout.length)/2;
//		int ybase = (3-layout[0].length)/2;
//		int zbase = (3-layout[0][0].length)/2;
//		placeholder.setStackSize(size);
//		slots = new Slot[size];
//		
//		int count = 0;
//		for (int i = 0; i < layout.length; i++) {
//			for (int j = 0; j < layout[0].length; j++) {
//				for (int k = 0; k < layout[0][0].length; k++) {
//					ItemStack stack =  layout[i][j][k];
//					if (stack != null) {
//						slots[count] = new Slot(placeholder, count, 54+((i+xbase)*12)+((k+zbase)*12), 126-((j+ybase)*52)-((k+zbase)*8)+((i+xbase)*8));
//						slots[count].putStack(stack);
//						addSlotToContainer(slots[count]);
//					}
//					else{
//						slots[count] = new Slot(placeholder, count, 54+((i+xbase)*12)+((k+zbase)*12), 126-((j+ybase)*52)-((k+zbase)*8)+((i+xbase)*8));
//						addSlotToContainer(slots[count]);
//					}
//					count++;
//				}
//			}
//		}
	}
	public class Holder implements IInventory{
		ItemStack[] stacks = new ItemStack[1];
		@Override
		public int getSizeInventory() {
			return stacks.length;
		}

		public void setStackSize(int size) {
			stacks = new ItemStack[size];
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
