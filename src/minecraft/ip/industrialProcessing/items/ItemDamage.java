package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDamage extends Item {

	public ItemDamage(int ID, String name, CreativeTabs tab) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(15);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);

	}
	public ItemDamage(int ID, String name, CreativeTabs tab, int maxDamage) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);

	}
	public ItemDamage(int ID,int maxDamage, String name, CreativeTabs tab) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);

	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;

	}
	
	@Override
	 public ItemStack getContainerItemStack(ItemStack itemStack) {
	     	return itemStack;
	     	
	    }

}
