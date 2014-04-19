package mod.industrialProcessing;

import mod.industrialProcessing.block.ConfigBlocks;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.blockContainer.ConfigBlockContainers;
import mod.industrialProcessing.blockContainer.ISetupBlockContainers;
import mod.industrialProcessing.fluids.ConfigFluids;
import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ConfigItems;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.utils.damage.ISetupDamageSource;
import mod.industrialProcessing.utils.handlers.fluids.BucketHandler;
import mod.industrialProcessing.utils.handlers.gui.GuiHandler;
import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.SyncAnimationPacket;
import mod.industrialProcessing.utils.handlers.packet.packets.TankAnimationPacket;
import mod.industrialProcessing.utils.handlers.worldGeneration.WorldGeneration;
import mod.industrialProcessing.utils.registry.BucketRegistery;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = IndustrialProcessing.MODID, version = IndustrialProcessing.VERSION)
public class IndustrialProcessing implements INamepace, ISetupCreativeTabs, ISetupItems, ISetupBlocks, ISetupFluids, ISetupDamageSource, ISetupBlockContainers {
	public static final String MODID = "IndustrialProcessing";
	public static final String VERSION = "0.0.3";
	private static ModContainer container;
	
	@SidedProxy(clientSide = "mod.industrialProcessing.client.ClientProxy", serverSide = "mod.industrialProcessing.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		container = Loader.instance().activeModContainer();
		LanguageRegistry.instance().loadLanguagesFor(container, Side.SERVER);
		
		//register event handler
		mod.industrialProcessing.utils.handlers.event.EventHandler.getInstance().register();
		
		//register event handlers
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
			
		//register items
		ConfigItems.getInstance().registerItems();
		
		// register ores
		ConfigBlocks.getInstance().registerOres();
		
		// register blocks
		ConfigBlocks.getInstance().registerBlocks();
		ConfigBlockContainers.getInstance().registerBlocks();
		
		//register fluids
		ConfigFluids.getInstance().registerFluids();
		
		//register worldGeneration
		GameRegistry.registerWorldGenerator(new WorldGeneration(), 100);
		
		//register guihandler
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance,new GuiHandler());		
		
		//register renders
		proxy.registerRenderers();
		
		
		FluidContainerRegistry.registerFluidContainer(new FluidStack(FluidRegistry.WATER, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.water_bucket),new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(new FluidStack(FluidRegistry.LAVA, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.lava_bucket),new ItemStack(Items.bucket));

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		//register packet handler
		PacketHandler.getInstance().initialise();
		PacketHandler.getInstance().registerPacket(SyncAnimationPacket.class);
		PacketHandler.getInstance().registerPacket(TankAnimationPacket.class);
		//PacketHandler.getInstance().register();
	}

	@EventHandler
	public void init(FMLPostInitializationEvent event) {
		//register packet handler
		PacketHandler.getInstance().postInitialise();
	}
	

	@Instance("IndustrialProcessing")
	public static IndustrialProcessing instance;

	public static IndustrialProcessing instance() {
		return instance;
	}
}
