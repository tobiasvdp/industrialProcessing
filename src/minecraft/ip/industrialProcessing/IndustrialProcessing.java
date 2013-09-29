package ip.industrialProcessing;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bouncycastle.crypto.util.Pack;

import net.minecraftforge.common.Configuration;
import ip.industrialProcessing.client.render.RendererLivingEntity;
import ip.industrialProcessing.config.ConfigAchievements;
import ip.industrialProcessing.config.ConfigBaseRecipes;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigCreativeTabs;
import ip.industrialProcessing.config.ConfigDamageSource;
import ip.industrialProcessing.config.ConfigFluids;
import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupAchievements;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.config.ISetupDamageSource;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.fluids.BlockFluid;
import ip.industrialProcessing.fluids.BucketHandler;
import ip.industrialProcessing.fluids.ContainerFluid;
import ip.industrialProcessing.fluids.ItemFluid;
import ip.industrialProcessing.items.*;
import ip.industrialProcessing.machines.classifier.BlockClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.BlockDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.dryer.BlockDryer;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.flotationCell.BlockFlotationCell;
import ip.industrialProcessing.machines.flotationCell.TileEntityFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.BlockHydroCyclone;
import ip.industrialProcessing.machines.hydroCyclone.TileEntityHydroCyclone;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.thickener.BlockThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.multiblock.core.block.hotPress.TEmultiblockHotPress;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFramePanel;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.ENmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.power.buildcraftGenerator.BlockBuildcraftGenerator;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.BlockManualGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.BlockAmpMeter;
import ip.industrialProcessing.power.meters.BlockVoltMeter;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.wire.BlockWire;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.transport.fluids.BlockTransportFluids;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import ip.industrialProcessing.utils.DamageSourceIP;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
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
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "IndustrialProcessing", name = "Industrial Processing", version = "0.0.1", dependencies = "after:NotEnoughItems")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { PacketHandler.ANIMATION_SYNC, PacketHandler.TANK_SYNC, PacketHandler.CONVEYOR_SYNC, PacketHandler.BUTTON_PRESSED, PacketHandler.SYNC_CLIENT, PacketHandler.SEND_INFO, PacketHandler.SCREEN_PRESSED, PacketHandler.IP_ELEVATOR_BUTTON, PacketHandler.IP_LOGIC_SYNCSIDE }, packetHandler = PacketHandler.class)
public class IndustrialProcessing implements ISetupCreativeTabs, INamepace, ISetupMachineBlocks, ISetupItems, ISetupBlocks, ISetupFluids, ISetupAchievements, ISetupDamageSource {
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
	public static WorldGeneration worldGen = new WorldGeneration();

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "ip.industrialProcessing.client.ClientProxy", serverSide = "ip.industrialProcessing.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
		// register listeners for events
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new EventHookContainerClass());
		

		log = event.getModLog();
		
		//load config file
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		boolean useConfig = config.get(Configuration.CATEGORY_GENERAL, "useConfig", true).getBoolean(true);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		// register new crafting handler
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		// register worldgenerator
		GameRegistry.registerWorldGenerator(worldGen);

		// register machines, power, transport
		ConfigMachineBlocks.getInstance().registerMachineBlocks();

		// register ores
		ConfigBlocks.getInstance().registerOres();

		// register item name's
		ConfigItems.getInstance().addToLanguageRegistry();

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
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
