package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIronLargeChunks extends Item {

	public ItemIronLargeChunks() {
		super(ConfigItems.ItemIronLargeChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemIronLargeChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemIronLargeChunks");
	}

}
