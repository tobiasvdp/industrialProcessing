package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTinSmallChunks extends Item {

	public ItemTinSmallChunks() {
		super(ConfigItems.ItemTinSmallChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemTinSmallChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemTinSmallChunks");
	}

}
