package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.item.Item;

public class ItemIP extends Item {

	public ItemIP(int ID,String name) {
		super(ID);
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabOreProcessing);
		setUnlocalizedName(name);
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);
	}

}
