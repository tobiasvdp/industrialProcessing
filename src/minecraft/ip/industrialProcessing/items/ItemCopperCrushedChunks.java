package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperCrushedChunks extends Item {

	public ItemCopperCrushedChunks() {
		super(ConfigItems.ItemCopperCrushedChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemCopperCrushedChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemCopperCrushedChunks");
	}

}
