package ip.industrialProcessing.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.filter.RendererFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RendererFilter());
    }
}
