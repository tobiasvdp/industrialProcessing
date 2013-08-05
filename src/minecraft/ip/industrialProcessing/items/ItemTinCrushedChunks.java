package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTinCrushedChunks extends Item {

	public ItemTinCrushedChunks() {
		super(ConfigItems.ItemTinCrushedChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemTinCrushedChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemTinCrushedChunks");
	}

}
