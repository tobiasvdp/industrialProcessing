package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTinLargeChunks extends Item {

	public ItemTinLargeChunks() {
		super(ConfigItems.ItemTinLargeChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemTinLargeChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemTinLargeChunks");
	}

}
