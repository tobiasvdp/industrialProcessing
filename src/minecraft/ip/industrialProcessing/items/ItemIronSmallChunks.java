package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIronSmallChunks extends Item {

	public ItemIronSmallChunks() {
		super(ConfigItems.ItemIronSmallChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemIronSmallChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemIronSmallChunks");
	}

}