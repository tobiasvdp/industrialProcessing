package ip.industrialProcessing.subMod.blackSmith.client;

import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.client.render.RendererTileEntityFluidWorker;
import ip.industrialProcessing.subMod.blackSmith.CommonProxy;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.model.ModelBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model.ModelIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.model.ModelBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.TileEntityWaterBasinCore;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.TileEntityWaterBasinDummy;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.model.ModelWaterBasin;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.model.ModelWaterBasinAnimated;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
    private static final ModelBloomery modelBloomery = new ModelBloomery();
    private static final ModelBellows modelBellows = new ModelBellows();
    private static final ModelIronBowl modelIronBowl = new ModelIronBowl();
    private static final ModelWaterBasin modelWaterBasin = new ModelWaterBasin();
    private static final ModelAnimatedFluidMachine modelWaterBasinAnimated =  new ModelWaterBasinAnimated();
	
	@Override
	public void registerRenderers() {
		ConfigBlackSmith.setRendererBloomeryId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererBloomeryId(), modelBloomery));
        
        ConfigBlackSmith.setRendererIronBowlId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererIronBowlId(), modelIronBowl));
        
        ConfigBlackSmith.setRendererBellowsId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererBellowsId(), modelBellows));
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterBasinCore.class, new RendererTileEntityFluidWorker(ISetupBlackSmith.blockWaterBasin, "", modelWaterBasinAnimated));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterBasinDummy.class, new RendererTileEntityFluidWorker(ISetupBlackSmith.blockWaterBasin, "", modelWaterBasinAnimated));
        ConfigBlackSmith.setRendererWaterBasinId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererWaterBasinId(), modelWaterBasin));
	}
}
