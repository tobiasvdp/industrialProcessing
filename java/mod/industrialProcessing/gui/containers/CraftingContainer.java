package mod.industrialProcessing.gui.containers;

import java.util.Random;

import mod.industrialProcessing.blockContainer.machine.crafter.TileEntityMachineCrafter;
import mod.industrialProcessing.gui.framework.slots.SlotOutput;
import mod.industrialProcessing.utils.inventory.InventoryUtils;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class CraftingContainer extends LayoutContainer {

	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	TileEntityMachineCrafter te;

	public CraftingContainer(TileEntity tileEntity) {
		if (tileEntity instanceof TileEntityMachineCrafter)
			te = (TileEntityMachineCrafter) tileEntity;
	}

	public void onCraftMatrixChanged(TileEntityMachineCrafter te) {
		this.getSlotFromInventory(te, 0).putStack(te.getOutputForInput(te));
	}

	private void onProduceOutput(TileEntityMachineCrafter te2, EntityPlayer par4EntityPlayer) {
		te.onProduceOutput(te, par4EntityPlayer);
	}

	@Override
	public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
		ItemStack stack = null;
		if (par1 >= 0 && getSlot(par1).getHasStack() && getSlot(par1).getStack().stackSize == 0) {
		} else {
			stack = super.slotClick(par1, par2, par3, par4EntityPlayer);
		}
		if (par1 >= 0 && getSlot(par1) instanceof SlotOutput) {
			onProduceOutput(te, par4EntityPlayer);
			onCraftMatrixChanged(te);
		} else if (te != null) {
			onCraftMatrixChanged(te);
		}
		return stack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (te != null) {
			return !te.needsToClose();
		}
		return false;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		IInventory inventory = (IInventory) te;

		if(!te.getWorldObj().isRemote){
		
		Random rand = new Random();
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);
			if (item != null && item.stackSize > 0) {
				inventory.setInventorySlotContents(i, null);
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(te.getWorldObj(), te.xCoord + rx, te.yCoord + ry, te.zCoord + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				te.getWorldObj().spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
		super.onContainerClosed(par1EntityPlayer);
		}
	}

}
