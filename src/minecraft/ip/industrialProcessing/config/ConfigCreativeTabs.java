package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ip.industrialProcessing.CreativeTabsIP;

public class ConfigCreativeTabs {

	public void addToLanguageRegistry(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.IPOreProc", "en_US", "IP Ore extraction");
		((CreativeTabsIP) IndustrialProcessing.tabOreProcessing).setIcon(new ItemStack(IndustrialProcessing.blockFilter));
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabOres", "en_US", "IP ores");
		((CreativeTabsIP) IndustrialProcessing.tabOres).setIcon(new ItemStack(IndustrialProcessing.itemIronCrushedChunks));
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabPower", "en_US", "IP Power");
		((CreativeTabsIP) IndustrialProcessing.tabPower).setIcon(new ItemStack(IndustrialProcessing.blockWire));
	}
	
	public ConfigCreativeTabs() {
	}
	
	private static ConfigCreativeTabs instance = new ConfigCreativeTabs();
	
	public static ConfigCreativeTabs getInstance(){
		return instance;
	}

}
