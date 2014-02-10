package ip.industrialProcessing.config;

import ip.industrialProcessing.api.utils.CreativeTabsIP;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigCreativeTabs {

	public void addToLanguageRegistry(){
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabOreExtraction", "en_US", "IP Ore extraction");
		((CreativeTabsIP) ISetupCreativeTabs.tabOreProcessing).setIcon(new ItemStack(ISetupMachineBlocks.blockFilter));
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabOres", "en_US", "IP ores");
		((CreativeTabsIP) ISetupCreativeTabs.tabOres).setIcon(new ItemStack(ISetupItems.itemIronCrushedChunks));
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabPower", "en_US", "IP Power");
		((CreativeTabsIP) ISetupCreativeTabs.tabPower).setIcon(new ItemStack(ISetupMachineBlocks.blockEnergyCell));
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabMultiblocks", "en_US", "IP Multiblocks");
		((CreativeTabsIP) ISetupCreativeTabs.tabMultiblocks).setIcon(new ItemStack(ISetupMachineBlocks.BLmultiblockDisplayPanel));
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabFluid", "en_US", "IP Fluids");
		((CreativeTabsIP) ISetupCreativeTabs.tabFluid).setIcon(new ItemStack(ISetupMachineBlocks.blockManometer));
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabMachineParts", "en_US", "IP machine parts");
		((CreativeTabsIP) ISetupCreativeTabs.tabMachineParts).setIcon(new ItemStack(ISetupBlocks.blockMachineBlock));
	}
	
	public ConfigCreativeTabs() {
	}
	
	private static ConfigCreativeTabs instance = new ConfigCreativeTabs();
	
	public static ConfigCreativeTabs getInstance(){
		return instance;
	}

}
