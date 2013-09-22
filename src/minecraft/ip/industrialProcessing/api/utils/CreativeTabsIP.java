package ip.industrialProcessing.api.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsIP extends CreativeTabs {

	private int id;
	private String name;
	private ItemStack icon;

	public CreativeTabsIP(int id, String name) {
		super(id, name);
		this.id = id;
		this.name = name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return icon;
	}

	public String getTranslatedTabLabel() {
		return "IP.itemGroup." + name;
	}

	public void setIcon(ItemStack item) {
		icon = item;
	}
}
