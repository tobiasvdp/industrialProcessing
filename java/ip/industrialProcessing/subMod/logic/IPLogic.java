package ip.industrialProcessing.subMod.logic;

import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.config.ISetupLogic;
import ip.industrialProcessing.subMod.logic.utils.handler.logicLine.LogicPathHandler;
import ip.industrialProcessing.utils.registry.HandlerRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

//TODO@Mod(modid = "IPLogic", name = "Industrial Processing Logic", version = "0.0.1", dependencies = "required-after:IndustrialProcessing")
//TODO@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { PacketHandler.channel, PacketHandler.DISPLAY_GET_NODES, PacketHandler.DISPLAY_GET_DATA }, packetHandler = PacketHandler.class)
public class IPLogic implements ISetupLogic {
	@Instance("IPLogic")
	public static IPLogic instance;
	public static Configuration config;

	public static CreativeTabs tabLogic = new CreativeTabsIP(CreativeTabs.getNextID(), "tabLogic");

	@SidedProxy(clientSide = "ip.industrialProcessing.subMod.logic.client.ClientProxy", serverSide = "ip.industrialProcessing.subMod.logic.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		ConfigLogic.getInstance().register();
		proxy.registerRenderers();
		config.save();

		// register the gui handler
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		//register new logic line handler
		HandlerRegistry.registerLogicLineHandler(new LogicPathHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		config.get(Configuration.CATEGORY_GENERAL, "useConfig", true).getBoolean(true);

		MinecraftForge.EVENT_BUS.register(this);
	}

}
