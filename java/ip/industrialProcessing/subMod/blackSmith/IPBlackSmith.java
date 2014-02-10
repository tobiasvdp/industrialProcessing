package ip.industrialProcessing.subMod.blackSmith;

import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.utils.handler.PacketHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

//TODO @Mod(modid = "IPBlackSmith", name = "Industrial Processing BlackSmith", version = "0.0.1", dependencies = "required-after:IndustrialProcessing")
//TODO @NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { PacketHandler.channel }, packetHandler = PacketHandler.class)
public class IPBlackSmith implements ISetupBlackSmith {
	@Instance("IPBlackSmith")
	public static IPBlackSmith instance;
	public static Configuration config;

	public static CreativeTabs tabBlackSmith = new CreativeTabsIP(CreativeTabs.getNextID(), "tabBlackSmith");

	@SidedProxy(clientSide = "ip.industrialProcessing.subMod.blackSmith.client.ClientProxy", serverSide = "ip.industrialProcessing.subMod.blackSmith.CommonProxy")
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
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabBlackSmith", "en_US", "IP BlackSmith");
		((CreativeTabsIP) tabBlackSmith).setIcon(new ItemStack(blockBloomery));

		// register machines
		ConfigBlackSmith.getInstance().register();

		proxy.registerRenderers();
		config.save();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
