package ip.industrialProcessing;

import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.items.*;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
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
        
        //create creative tab
        public static CreativeTabs tabMachines = new TabMachines(CreativeTabs.getNextID(),"industrialprocessing");
        
        //create worldgen
        public static WorldGeneration worldGen = new WorldGeneration();
        
        //create items
        public final static ItemIronLargeChunks itemIronLargeChunks = new ItemIronLargeChunks();
        public final static ItemCopperLargeChunks itemCopperLargeChunks = new ItemCopperLargeChunks();
        public final static ItemTinLargeChunks itemTinLargeChunks = new ItemTinLargeChunks();
        public final static ItemIronSmallChunks itemIronSmallChunks = new ItemIronSmallChunks();
        public final static ItemCopperSmallChunks itemCopperSmallChunks = new ItemCopperSmallChunks();
        public final static ItemTinSmallChunks itemTinSmallChunks = new ItemTinSmallChunks();
        public final static ItemIronCrushedChunks itemIronCrushedChunks = new ItemIronCrushedChunks();
        public final static ItemCopperCrushedChunks itemCopperCrushedChunks = new ItemCopperCrushedChunks();
        public final static ItemTinCrushedChunks itemTinCrushedChunks = new ItemTinCrushedChunks();
        
        //create ores
        public static final Block blockCopperOre = (new BlockOre(ConfigBlocks.BlockCopperOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockCopperOre").func_111022_d(TEXTURE_NAME_PREFIX+"blockCopperOre").setCreativeTab(IndustrialProcessing.tabMachines);;
        public static final Block blockTinOre = (new BlockOre(ConfigBlocks.BlockTinOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockTinOre").func_111022_d(TEXTURE_NAME_PREFIX+"blockTinOre").setCreativeTab(IndustrialProcessing.tabMachines);;
        
        //create Machines
        public final static BlockCrusher blockCrusher = new BlockCrusher();
        public final static BlockFilter blockFilter = new BlockFilter();
        public final static BlockMagneticSeparator blockMageneticSeparator = new BlockMagneticSeparator();
        public final static BlockMixer blockMixer = new BlockMixer();
	        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="ip.industrialProcessing.client.ClientProxy", serverSide="ip.industrialProcessing.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
        		GameRegistry.registerWorldGenerator(worldGen);   
        	
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

                GameRegistry.registerBlock(blockMixer, "BlockMixer");
                MinecraftForge.setBlockHarvestLevel(blockMixer, "pickaxe", 1);
                LanguageRegistry.addName(blockMixer, "Ore Mixer");                
                ModLoader.registerTileEntity(TileEntityMixer.class, "OreMixer");
                
                
                NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
                
                //register blocks
                GameRegistry.registerBlock(blockCopperOre, "blockCopperOre");
                MinecraftForge.setBlockHarvestLevel(blockCopperOre, "pickaxe", 1);
                GameRegistry.registerBlock(blockTinOre, "blockTinOre");
                MinecraftForge.setBlockHarvestLevel(blockTinOre, "pickaxe", 1);
                
                //give blocks a name
                LanguageRegistry.addName(blockCopperOre, "Copper");
                LanguageRegistry.addName(blockTinOre, "Tin");
                
                //register ore to oredirectory
                OreDictionary.registerOre("oreCopper", new ItemStack(blockCopperOre));
                OreDictionary.registerOre("oreTin", new ItemStack(blockTinOre));
                
                //give items a name
                LanguageRegistry.addName(itemIronLargeChunks, "Large Iron Chunks");
                LanguageRegistry.addName(itemCopperLargeChunks, "Large Copper Chunks");
                LanguageRegistry.addName(itemTinLargeChunks, "Large Tin Chunks");
                LanguageRegistry.addName(itemIronSmallChunks, "Small Iron Chunks");
                LanguageRegistry.addName(itemCopperSmallChunks, "Small Copper Chunks");
                LanguageRegistry.addName(itemTinSmallChunks, "Small Tin Chunks");
                LanguageRegistry.addName(itemIronCrushedChunks, "Crushed Iron Chunks");
                LanguageRegistry.addName(itemCopperCrushedChunks, "Crushed Copper Chunks");
                LanguageRegistry.addName(itemTinCrushedChunks, "Crushed Tin Chunks");
                
                proxy.registerRenderers();
        }
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
