package ip.industrialProcessing.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.MinecraftForgeClient;
import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RendererBlock;
import ip.industrialProcessing.machines.RendererTileEntity;
import ip.industrialProcessing.machines.filter.ModelFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.magneticSeparator.ModelMagneticSeperator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.ModelMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class ClientProxy extends CommonProxy {
	public static int renderPass; 

	@Override
    public void registerRenderers() { 
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RendererTileEntity(IndustrialProcessing.blockFilter,"ModelFilter",new ModelFilter())); 
    	ConfigRenderers.setRendererFilterId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererFilterId(),new TileEntityFilter()));
        
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagneticSeparator.class, new RendererTileEntity(IndustrialProcessing.blockMageneticSeparator, "ModelMagneticSeperator",new ModelMagneticSeperator())); 
    	ConfigRenderers.setRendererMagneticSeperatorId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMagneticSeperatorId(),new TileEntityMagneticSeparator()));
        

    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMixer.class, new RendererTileEntity(IndustrialProcessing.blockMixer,"ModelMixer",new ModelMixer())); 
    	ConfigRenderers.setRendererMixerId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMixerId(),new TileEntityMixer()));
    } 
}
