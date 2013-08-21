package ip.industrialProcessing;

import ip.industrialProcessing.items.ItemDamage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
			ItemStack stack = craftMatrix.getStackInSlot(i);
			if (stack != null && stack.getItem() != null) {
				Item itemFromStack = stack.getItem();
				if (itemFromStack instanceof ItemDamage) {
					ItemStack damagedStack = new ItemStack(itemFromStack,stack.stackSize,stack.getItemDamage()+1);
					
					if(damagedStack.getItemDamage() >= damagedStack.getMaxDamage()){
						damagedStack.stackSize--;
					}
					
					craftMatrix.setInventorySlotContents(i, damagedStack);
				}
			}
		}

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub

	}

}
