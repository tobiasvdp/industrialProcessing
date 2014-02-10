package ip.industrialProcessing.subMod.power.client;

import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.subMod.power.CommonProxy;
import ip.industrialProcessing.subMod.power.config.ConfigPower;
import ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel.model.ModelStandingSolarPanel;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy  extends CommonProxy{
	 private static final ModelStandingSolarPanel modelStandingSolarPanel = new ModelStandingSolarPanel();
	@Override
	public void registerRenderers() {
		super.registerRenderers();
		ConfigPower.setRendererStandingSolarPanel(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigPower.getRendererStandingSolarPanel(),modelStandingSolarPanel));
	}
}
