package ip.industrialProcessing.config;

import ip.industrialProcessing.CreativeTabsIP;
import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public interface ISetupCreativeTabs {
    public static CreativeTabs tabOreProcessing = new CreativeTabsIP(CreativeTabs.getNextID(), "tabOreExtraction");
    public static CreativeTabs tabOres = new CreativeTabsIP(CreativeTabs.getNextID(), "tabOres");
    public static CreativeTabs tabPower = new CreativeTabsIP(CreativeTabs.getNextID(), "tabPower");
    public static CreativeTabs tabMultiblocks = new CreativeTabsIP(CreativeTabs.getNextID(), "tabMultiblocks");

}
