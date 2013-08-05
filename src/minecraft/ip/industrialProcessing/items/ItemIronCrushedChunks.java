package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIronCrushedChunks extends Item {

	public ItemIronCrushedChunks() {
		super(ConfigItems.ItemIronCrushedChunksID());
		setMaxStackSize(64);
		setCreativeTab(IndustrialProcessing.tabMachines);
		setUnlocalizedName("ItemIronCrushedChunks");
		func_111206_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "ItemIronCrushedChunks");
	}

}
