package mod.industrialProcessing.utils.handlers.crafting;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import mod.industrialProcessing.fluids.ItemIPBucket;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.items.ItemDamage;
import mod.industrialProcessing.utils.achievements.ISetupAchievements;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

	@SubscribeEvent
	public void ItemCraftedEvent(PlayerEvent event) {
		if (event instanceof ItemCraftedEvent) {
			ItemCraftedEvent itemCraftedEvent = (ItemCraftedEvent) event;
			EntityPlayer player = itemCraftedEvent.player;
			ItemStack crafting = itemCraftedEvent.crafting;
			IInventory craftMatrix = itemCraftedEvent.craftMatrix;

			for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
				ItemStack stack = craftMatrix.getStackInSlot(i);
				if (stack != null && stack.getItem() != null) {
					Item itemFromStack = stack.getItem();
					if (itemFromStack instanceof ItemDamage) {
						ItemStack damagedStack = new ItemStack(itemFromStack, 2, stack.getItemDamage() + 1);

						if (damagedStack.getItemDamage() >= damagedStack.getMaxDamage()) {
							damagedStack.stackSize--;
						}

						craftMatrix.setInventorySlotContents(i, damagedStack);
					}
					if (itemFromStack instanceof ItemIPBucket) {
						craftMatrix.setInventorySlotContents(i, new ItemStack(Items.bucket, 2));
					}
					if (itemFromStack != null) {
						checkAchievements(player, itemFromStack);
					}
				}
			}

		}

	}

	public void checkAchievements(EntityPlayer player, Item item) {
		if (item.equals(ISetupItems.itemHammer)) {
			player.addStat(ISetupAchievements.achHammer, 1);
		}
	}

}
