package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperSmallChunks extends Item {

	public ItemCopperSmallChunks() {
		super(ConfigItems.ItemCopperSmallChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemCopperSmallChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemCopperSmallChunks");
	}

}
