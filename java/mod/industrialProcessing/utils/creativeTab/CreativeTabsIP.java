package mod.industrialProcessing.utils.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabsIP extends CreativeTabs {

	private int id;
	private String name;
	private ItemStack icon;
	private Item item;

	public CreativeTabsIP(int id, String name, Item itemTabIcon) {
		super(id, name);
		this.id = id;
		this.name = name;
		this.item = itemTabIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return icon;
	}

	@Override
	public String getTranslatedTabLabel() {
		return "IP.itemGroup." + name;
	}

	public void setIcon(ItemStack item) {
		icon = item;
	}

	@Override
	public Item getTabIconItem() {
		return item;
	}
}
