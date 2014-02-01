package ip.industrialProcessing.subMod.logic.client;

import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.api.rendering.RendererTileBlock;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.subMod.logic.CommonProxy;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.config.ISetupLogic;
import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model.ModelMachineInterface;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.model.ModelDisplayPanel;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.model.ModelDisplayPost;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.ModelWire;
import ip.industrialProcessing.subMod.logic.old.function.and.MDlogicAnd;
import ip.industrialProcessing.subMod.logic.old.function.and.TElogicAnd;
import ip.industrialProcessing.subMod.logic.old.function.or.MDlogicOr;
import ip.industrialProcessing.subMod.logic.old.function.or.TElogicOr;
import ip.industrialProcessing.subMod.logic.old.transport.wired.cable.MDlogicCable;
import ip.industrialProcessing.subMod.logic.old.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox.MDlogicSwitchBox;
import ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox.TElogicSwitchBox;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public static int renderPass;
	private static final MDlogicSwitchBox MDlogicSwitchBox = new MDlogicSwitchBox();
	private static final MDlogicCable MDlogicCable = new MDlogicCable();
	private static final MDlogicAnd MDlogicAnd = new MDlogicAnd();
	private static final MDlogicOr MDlogicOr = new MDlogicOr();
	
	private static final ModelWire modelWire = new ModelWire();
	private static final ModelDisplayPanel modelDisplayPanel = new ModelDisplayPanel();
	private static final ModelDisplayPost modelDisplayPost = new ModelDisplayPost();
	private static final ModelMachineInterface modelMachineInterface = new ModelMachineInterface();

	@Override
	public void registerRenderers() {

		ConfigRenderers.setRendererDisplayPost(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDisplayPost(), modelDisplayPost));
		
		ConfigRenderers.setRendererDisplayPanel(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDisplayPanel(), modelDisplayPanel));
		
		ConfigRenderers.setRendererDataBus(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDataBus(), modelWire));
		
		ConfigRenderers.setRendererMachineInterface(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMachineInterface(), modelMachineInterface));
		/*
		ClientRegistry.bindTileEntitySpecialRenderer(TElogicSwitchBox.class, new RendererLogic(ISetupLogic.BLlogicSwitchBox, "MDlogicSwitchBox", MDlogicSwitchBox));
		ConfigLogic.setRDlogicSwitchBox(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicSwitchBox(), new TElogicSwitchBox()));

		ClientRegistry.bindTileEntitySpecialRenderer(TElogicCable.class, new RendererLogic(ISetupLogic.BLlogicCable, "MDlogicCable", MDlogicCable));
		ConfigLogic.setRDlogicCable(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicCable(), new TElogicCable()));

		ClientRegistry.bindTileEntitySpecialRenderer(TElogicAnd.class, new RendererLogic(ISetupLogic.BLlogicAnd, "MDlogicAnd", MDlogicAnd));
		ConfigLogic.setRDlogicAnd(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicAnd(), new TElogicAnd()));

		ClientRegistry.bindTileEntitySpecialRenderer(TElogicOr.class, new RendererLogic(ISetupLogic.BLlogicOr, "MDlogicAnd", MDlogicOr));
		ConfigLogic.setRDlogicOr(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicOr(), new TElogicOr()));*/
	}
}
