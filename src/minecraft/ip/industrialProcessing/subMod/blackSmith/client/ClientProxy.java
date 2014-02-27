package ip.industrialProcessing.subMod.blackSmith.client;

import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.client.render.RendererTileEntityAnimated;
import ip.industrialProcessing.client.render.RendererTileEntityFluidWorker;
import ip.industrialProcessing.subMod.blackSmith.CommonProxy;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.model.ModelBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model.ModelIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.model.ModelBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.TileEntityForgeCore;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.model.ModelForge;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.model.ModelForgeAnimated;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenBar.model.ModelWoodenBar;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenHammer.model.ModelWoodenHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenWheel.model.ModelWoodenWheel;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.model.ModelTripHamer;
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
    private static final ModelWoodenBar modelWoodenBar = new ModelWoodenBar();
    private static final ModelWoodenHammer modelWoodenHammer = new ModelWoodenHammer();
    private static final ModelWoodenWheel modelWoodenWheel = new ModelWoodenWheel();
    private static final ModelTripHamer modelTripHamer = new ModelTripHamer();
    private static final ModelForge modelForge = new ModelForge();
    private static final ModelForgeAnimated modelForgeAnimated = new ModelForgeAnimated();
    
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
        
        ConfigBlackSmith.setRendererWoodenBarId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererWoodenBarId(), modelWoodenBar));
        
        ConfigBlackSmith.setRendererWoodenHammerId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererWoodenHammerId(), modelWoodenHammer));
        
        ConfigBlackSmith.setRendererWoodenWheelId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererWoodenWheelId(), modelWoodenWheel));
        
        ConfigBlackSmith.setRendererTripHammerId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererTripHammerId(), modelTripHamer));
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityForgeCore.class, new RendererTileEntityAnimated(ISetupBlackSmith.blockForge, "coal_block", modelForgeAnimated));
        ConfigBlackSmith.setRendererForgeId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigBlackSmith.getRendererForgeId(), modelForge));
	}
}
