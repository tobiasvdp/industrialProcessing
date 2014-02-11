package mod.industrialProcessing;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.transformers.ForgeAccessTransformer;
import mod.industrialProcessing.blocks.BlockIP;
import mod.industrialProcessing.blocks.ConfigBlocks;
import mod.industrialProcessing.blocks.ISetupBlocks;
import mod.industrialProcessing.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.utils.INamepace;
import cpw.mods.fml.common.InjectedModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = IndustrialProcessing.MODID, version = IndustrialProcessing.VERSION)
public class IndustrialProcessing implements INamepace, ISetupCreativeTabs,
		ISetupBlocks {
	public static final String MODID = "IndustrialProcessing";
	public static final String VERSION = "0.0.3";
	private static ModContainer container;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		container = Loader.instance().activeModContainer();
		LanguageRegistry.instance().loadLanguagesFor(container, Side.SERVER);

		// register ores
		ConfigBlocks.getInstance().registerOres();

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
