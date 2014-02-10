package ip.industrialProcessing.subMod.mine;

import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.subMod.mine.config.ConfigMine;
import ip.industrialProcessing.subMod.mine.config.ISetupMine;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

//TODO@Mod(modid = "IPMine", name = "Industrial Processing Mine", version = "0.0.1", dependencies = "required-after:IndustrialProcessing")
//TODO@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { PacketHandler.channel,PacketHandler.destroyBlock, PacketHandler.move }, packetHandler = PacketHandler.class)
public class IPMine implements ISetupMine {
	@Instance("IPMine")
	public static IPMine instance;
	public static Configuration config;

	public static CreativeTabs tabMine = new CreativeTabsIP(CreativeTabs.getNextID(), "tabMine");

	@SidedProxy(clientSide = "ip.industrialProcessing.subMod.mine.client.ClientProxy", serverSide = "ip.industrialProcessing.subMod.mine.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		boolean useConfig = config.get(Configuration.CATEGORY_GENERAL, "useConfig", true).getBoolean(true);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		// register tab
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabMine", "en_US", "IP Mining");
		//((CreativeTabsIP) tabMine).setIcon(new ItemStack(blockCreativeGenerator));

		// register machines
		ConfigMine.getInstance().register();

		proxy.registerRenderers();
		config.save();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
