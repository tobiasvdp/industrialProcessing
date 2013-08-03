package ip.industrialProcessing;

import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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

        // The instance of your mod that Forge uses.
        @Instance("IndustrialProcessing")
        public static IndustrialProcessing instance;
        
        public static CreativeTabs tabMachines = new TabMachines(CreativeTabs.getNextID(),"IndustrialProcessing");
        
        public final static BlockCrusher blockCrusher = new BlockCrusher();
        public final static BlockFilter blockFilter = new BlockFilter();
	        
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
                
                proxy.registerRenderers();
                NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
        }
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
