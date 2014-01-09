package ip.industrialProcessing.utils.handler.crafting;

import ip.industrialProcessing.config.ISetupAchievements;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.fluids.ContainerFluid;
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
                    ItemStack damagedStack = new ItemStack(itemFromStack, 2, stack.getItemDamage() + 1);

                    if (damagedStack.getItemDamage() >= damagedStack.getMaxDamage()) {
                        damagedStack.stackSize--;
                    }

                    craftMatrix.setInventorySlotContents(i, damagedStack);
                }
                if (itemFromStack instanceof ContainerFluid) {
                    craftMatrix.setInventorySlotContents(i, new ItemStack(Item.bucketEmpty,2));
                }
            }
        }
        if (item != null && item.itemID != 0) {
            checkAchievements(player, item);
        }

    }

    public void checkAchievements(EntityPlayer player, ItemStack item) {
        if (item.itemID == ISetupItems.itemHammer.itemID) {
            player.addStat(ISetupAchievements.achHammer, 1);
        }
    }

    @Override
    public void onSmelting(EntityPlayer player, ItemStack item) {
        // TODO Auto-generated method stub

    }

}
