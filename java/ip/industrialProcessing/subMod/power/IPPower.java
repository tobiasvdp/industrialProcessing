package ip.industrialProcessing.subMod.power;

import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.subMod.power.config.ConfigPower;
import ip.industrialProcessing.subMod.power.config.ISetupPower;
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

@Mod(modid = "IPPower", name = "Industrial Processing Power", version = "0.0.1", dependencies = "required-after:IndustrialProcessing")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { PacketHandler.channel }, packetHandler = PacketHandler.class)
public class IPPower implements ISetupPower {
	@Instance("IPPower")
	public static IPPower instance;
	public static Configuration config;

	public static CreativeTabs tabPower = new CreativeTabsIP(CreativeTabs.getNextID(), "tabPower");

	@SidedProxy(clientSide = "ip.industrialProcessing.subMod.power.client.ClientProxy", serverSide = "ip.industrialProcessing.subMod.power.CommonProxy")
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
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabPower2", "en_US", "IP Power");
		((CreativeTabsIP) tabPower).setIcon(new ItemStack(blockCreativeGenerator));

		// register machines
		ConfigPower.getInstance().register();

		proxy.registerRenderers();
		config.save();


	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
