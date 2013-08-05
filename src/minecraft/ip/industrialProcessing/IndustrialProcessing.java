package ip.industrialProcessing;

import ip.industrialProcessing.items.ItemIronLargeChunks;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
@Mod(modid="IndustrialProcessing", name="Industrial Processing", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class IndustrialProcessing {

	public static final String RESOURCE_PATH = "/assets/industrialprocessing/";
	public static final String TEXTURE_DIRECTORY = RESOURCE_PATH + "textures/";
	public static final String GUI_DIRECTORY = TEXTURE_DIRECTORY + "gui/";
	public static final String BLOCK_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "blocks/";
	public static final String ITEM_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "items/";
	public static final String MODEL_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "models/";
	public static final String TEXTURE_DOMAIN = "industrialprocessing";
	public static final String TEXTURE_NAME_PREFIX = TEXTURE_DOMAIN + ":";

	
        // The instance of your mod that Forge uses.
        @Instance("IndustrialProcessing")
        public static IndustrialProcessing instance;
        
        public static CreativeTabs tabMachines = new TabMachines(CreativeTabs.getNextID(),"industrialprocessing");
        
        //create items
        private final static ItemIronLargeChunks itemIronLargeChunks = new ItemIronLargeChunks();
        
        //create blocks
        public final static BlockCrusher blockCrusher = new BlockCrusher();
        public final static BlockFilter blockFilter = new BlockFilter();
        public final static BlockMagneticSeparator blockMageneticSeparator = new BlockMagneticSeparator();
	        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="ip.industrialProcessing.client.ClientProxy", serverSide="ip.industrialProcessing.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
        		LanguageRegistry.instance().addStringLocalization("itemGroup.tabMachines", "en_US", "Industrial Processing");
        	
                GameRegistry.registerBlock(blockCrusher, "BlockOreCrusher");
                MinecraftForge.setBlockHarvestLevel(blockCrusher, "pickaxe", 1);
                LanguageRegistry.addName(blockCrusher, "Ore Crusher");
                ModLoader.registerTileEntity(TileEntityCrusher.class, "OreCrusher");
                
                GameRegistry.registerBlock(blockFilter, "BlockOreFilter");
                MinecraftForge.setBlockHarvestLevel(blockFilter, "pickaxe", 1);
                LanguageRegistry.addName(blockFilter, "Ore Filter");                
                ModLoader.registerTileEntity(TileEntityFilter.class, "OreFilter");
                

                GameRegistry.registerBlock(blockMageneticSeparator, "BlockMagneticSeparator");
                MinecraftForge.setBlockHarvestLevel(blockMageneticSeparator, "pickaxe", 1);
                LanguageRegistry.addName(blockMageneticSeparator, "Magnetic Ore Separator");                
                ModLoader.registerTileEntity(TileEntityMagneticSeparator.class, "MagneticOreSeparator");

                NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
                
                //give items a name
                LanguageRegistry.addName(itemIronLargeChunks, "Large Iron Chunks");
                
                proxy.registerRenderers();
        }
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
