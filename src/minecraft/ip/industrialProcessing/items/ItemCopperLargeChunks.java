package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperLargeChunks extends Item {

	public ItemCopperLargeChunks() {
		super(ConfigItems.ItemCopperLargeChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemCopperLargeChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemCopperLargeChunks");
	}

}
