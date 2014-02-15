package mod.industrialProcessing;

import net.minecraftforge.common.MinecraftForge;
import mod.industrialProcessing.blocks.ConfigBlocks;
import mod.industrialProcessing.blocks.ISetupBlocks;
import mod.industrialProcessing.client.ClientProxy;
import mod.industrialProcessing.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.fluids.ConfigFluids;
import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ConfigItems;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.damage.ISetupDamageSource;
import mod.industrialProcessing.utils.handlers.fluids.BucketHandler;
import mod.industrialProcessing.utils.handlers.worldGeneration.WorldGeneration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = IndustrialProcessing.MODID, version = IndustrialProcessing.VERSION)
public class IndustrialProcessing implements INamepace, ISetupCreativeTabs, ISetupItems, ISetupBlocks, ISetupFluids, ISetupDamageSource {
	public static final String MODID = "IndustrialProcessing";
	public static final String VERSION = "0.0.3";
	private static ModContainer container;
	
	@SidedProxy(clientSide = "mod.industrialProcessing.client.ClientProxy", serverSide = "mod.industrialProcessing.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		container = Loader.instance().activeModContainer();
		LanguageRegistry.instance().loadLanguagesFor(container, Side.SERVER);
		
		//register event handlers
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		//register renders
		proxy.registerRenderers();
		
		//register items
		ConfigItems.getInstance().registerItems();
		
		// register ores
		ConfigBlocks.getInstance().registerOres();
		
		// register blocks
		ConfigBlocks.getInstance().registerBlocks();
		
		//register fluids
		ConfigFluids.getInstance().registerFluids();
		
		//register worldGeneration
		GameRegistry.registerWorldGenerator(new WorldGeneration(), 100);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Instance("IndustrialProcessing")
	public static IndustrialProcessing instance;

	public static IndustrialProcessing instance() {
		return instance;
	}
}
