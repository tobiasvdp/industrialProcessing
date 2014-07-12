package mod.industrialProcessing.items;

import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import mod.industrialProcessing.utils.registry.ItemType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDamage extends ItemIP {

	public ItemDamage() {
		super();
		setMaxStackSize(1);
		setMaxDamage(15);
		setNoRepair();

	}

	public ItemDamage(int maxDamage) {
		super();
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setNoRepair();
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;

	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return itemStack;
	}

}
