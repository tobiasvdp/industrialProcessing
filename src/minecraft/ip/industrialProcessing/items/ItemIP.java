package ip.industrialProcessing.items;

import ip.industrialProcessing.config.INamepace;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIP extends Item {

	public ItemIP(int ID,String name,CreativeTabs tab) {
		super(ID);
		setMaxStackSize(64);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		func_111206_d(INamepace.TEXTURE_NAME_PREFIX + name);
	}

}
