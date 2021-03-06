package ip.industrialProcessing.items;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;
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
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		ItemRegistry.RegisterItem(this, ItemType.damage);

	}
	
	public ItemDamage(int ID, String name, CreativeTabs tab, ItemType... type) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(15);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		ItemRegistry.RegisterItem(this, type);

	}
	public ItemDamage(int ID, String name, CreativeTabs tab, int maxDamage) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		ItemRegistry.RegisterItem(this, ItemType.damage);

	}
	public ItemDamage(int ID, String name, CreativeTabs tab, int maxDamage, ItemType... type) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		ItemRegistry.RegisterItem(this, type);
	}
	public ItemDamage(int ID,int maxDamage, String name, CreativeTabs tab) {
		super(ID);
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setNoRepair();
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);

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
