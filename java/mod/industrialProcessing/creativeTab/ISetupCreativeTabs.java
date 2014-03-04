package mod.industrialProcessing.creativeTab;

import net.minecraft.creativetab.CreativeTabs;

public interface ISetupCreativeTabs {
	public static CreativeTabs tabOres = new CreativeTabsIP(CreativeTabs.getNextID(), "ores", null);
	public static CreativeTabs tabBlocks = new CreativeTabsIP(CreativeTabs.getNextID(), "blocks", null);
	public static CreativeTabs tabMachineParts = new CreativeTabsIP(CreativeTabs.getNextID(), "machineParts", null);
	public static CreativeTabs tabItems = new CreativeTabsIP(CreativeTabs.getNextID(), "items", null);
	public static CreativeTabs tabFluids = new CreativeTabsIP(CreativeTabs.getNextID(), "fluids", null);
	public static CreativeTabs tabMachines = new CreativeTabsIP(CreativeTabs.getNextID(), "machines", null);

	public static CreativeTabs[] allIPTabs = new CreativeTabs[] { tabOres,tabBlocks, tabMachineParts,tabItems,tabFluids,tabMachines };
}
