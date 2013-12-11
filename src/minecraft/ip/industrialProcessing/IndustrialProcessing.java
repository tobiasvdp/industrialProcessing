package ip.industrialProcessing;

import ip.industrialProcessing.config.ConfigAchievements;
import ip.industrialProcessing.config.ConfigBaseRecipes;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigCreativeTabs;
import ip.industrialProcessing.config.ConfigDamageSource;
import ip.industrialProcessing.config.ConfigFluids;
import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupAchievements;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.config.ISetupDamageSource;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.config.ISetupTransportBlocks;
import ip.industrialProcessing.decoration.trees.EventBonemealIndustrialTree;
import ip.industrialProcessing.fluids.BucketHandler;
import ip.industrialProcessing.fluids.ContainerHandler;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.ENmultiblockLiftDoor;
import ip.industrialProcessing.utils.EventEntityRightClick;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "IndustrialProcessing", name = "Industrial Processing", version = "0.0.1", dependencies = "after:NotEnoughItems")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { PacketHandler.ANIMATION_SYNC, PacketHandler.TANK_SYNC, PacketHandler.CONVEYOR_SYNC, PacketHandler.BUTTON_PRESSED, PacketHandler.SYNC_CLIENT, PacketHandler.SEND_INFO, PacketHandler.SCREEN_PRESSED, PacketHandler.IP_ELEVATOR_BUTTON, PacketHandler.IP_LOGIC_SYNCSIDE, PacketHandler.IP_ENTITY_INTERACT }, packetHandler = PacketHandler.class)
public class IndustrialProcessing implements ISetupCreativeTabs, INamepace, ISetupMachineBlocks, ISetupItems, ISetupBlocks, ISetupFluids, ISetupAchievements, ISetupDamageSource, ISetupTransportBlocks {
    // The instance of your mod that Forge uses.
    @Instance("IndustrialProcessing")
    public static IndustrialProcessing instance;

    public static boolean invertShift;
    public static Logger log;

    public static Configuration config;

    public static void logInfo(String message, Object... params) {
        log.log(Level.INFO, String.format(message, params));
    }

    public static void logWarning(String message, Object... params) {
        log.log(Level.WARNING, String.format(message, params));
    }

    public static void logSevere(String message, Object... params) {
        log.log(Level.SEVERE, String.format(message, params));
    }

    // create namespaces: INamespace
    // create items: ISetupItems
    // create fluids: ISetupFluids
    // create ores: ISetupBlocks
    // create Machines, power, etc: ISetupMachineBlocks
    // create achievements: ISetupAchievements
    // create damagesources: ISetupDamageSource
    // create creative tab: ISetupCreativeTabs

    // create worldgen
    public static WorldGeneration worldGen;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "ip.industrialProcessing.client.ClientProxy", serverSide = "ip.industrialProcessing.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        // register listeners for events
        MinecraftForge.EVENT_BUS.register(ContainerHandler.INSTANCE);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventEntityRightClick()); 
        MinecraftForge.EVENT_BUS.register(new EventBonemealIndustrialTree());

        log = event.getModLog();

        // load config file
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        boolean useConfig = config.get(Configuration.CATEGORY_GENERAL, "useConfig", true).getBoolean(true);

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

        // register new crafting handler
        GameRegistry.registerCraftingHandler(new CraftingHandler());
        
        //register new fuel handler
        GameRegistry.registerFuelHandler(new FuelHandler());

        // register machines, power, transport
        ConfigMachineBlocks.getInstance().registerMachineBlocks();
        
        //register transport
        ConfigTransportBlocks.getInstance().register();

        // register ores
        ConfigBlocks.getInstance().registerOres();

        ConfigItems.getInstance();
        // register item name's
        ConfigItems.addToLanguageRegistry();

        // add death display messages
        ConfigDamageSource.getInstance().addToLanguageRegistry();

        // register achievements
        ConfigAchievements.getInstance().registerAchievments();

        // register fluid
        ConfigFluids.getInstance().registerFluids();

        // register the gui handler
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

        // register creative tabs
        ConfigCreativeTabs.getInstance().addToLanguageRegistry();

        // register renders
        proxy.registerRenderers();

        // register basic crafting recipes
        ConfigBaseRecipes.getInstance().addBaseRecipes();

        EntityRegistry.registerModEntity(ENmultiblockFrame.class, "Platform", 0, IndustrialProcessing.instance, 80, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.Platform.name", "en_US", "Platform");

        EntityRegistry.registerModEntity(ENmultiblockLiftDoor.class, "LiftDoor", 1, IndustrialProcessing.instance, 80, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.LiftDoor.name", "en_US", "Lift door");

        config.save();

        // register worldgenerator
        worldGen = new WorldGeneration();
        GameRegistry.registerWorldGenerator(worldGen);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
