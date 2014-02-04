package ip.industrialProcessing.subMod.blackSmith.client;

import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.subMod.blackSmith.CommonProxy;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.model.ModelBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model.ModelIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.model.ModelBloomery;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
    private static final ModelBloomery modelBloomery = new ModelBloomery();
    private static final ModelBellows modelBellows = new ModelBellows();
    private static final ModelIronBowl modelIronBowl = new ModelIronBowl();
	
	@Override
	public void registerRenderers() {
		ConfigBlackSmith.setRendererBloomeryId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererBloomeryId(), modelBloomery));
        
        ConfigBlackSmith.setRendererIronBowlId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererIronBowlId(), modelIronBowl));
        
        ConfigBlackSmith.setRendererBellowsId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererBellowsId(), modelBellows));
	}
}
