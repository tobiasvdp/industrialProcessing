package ip.industrialProcessing.items;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIP extends Item {

	public ItemIP(int ID,String name,CreativeTabs tab) {
		super(ID);
		setMaxStackSize(64);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		ItemRegistry.RegisterItem(this, ItemType.item);
	}
	
	public ItemIP(int ID,String name,CreativeTabs tab,ItemType... type) {
		super(ID);
		setMaxStackSize(64);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		ItemRegistry.RegisterItem(this, type);
	}

}
