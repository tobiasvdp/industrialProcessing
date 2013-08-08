package ip.industrialProcessing.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.MinecraftForgeClient;
import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.filter.RendererBlockFilter;
//import ip.industrialProcessing.machines.filter.RendererBlockFilter;
import ip.industrialProcessing.machines.filter.RendererFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;

public class ClientProxy extends CommonProxy {
	public static int renderPass; 

	@Override
    public void registerRenderers() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RendererFilter()); 
    	ConfigRenderers.setRendererFilterId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlockFilter(ConfigRenderers.getRendererFilterId()));

    } 
}
