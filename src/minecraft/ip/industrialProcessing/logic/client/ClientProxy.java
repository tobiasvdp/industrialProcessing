package ip.industrialProcessing.logic.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import ip.industrialProcessing.api.rendering.RendererTileBlock;
import ip.industrialProcessing.logic.CommonProxy;
import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.functions.and.MDlogicAnd;
import ip.industrialProcessing.logic.functions.and.TElogicAnd;
import ip.industrialProcessing.logic.functions.or.MDlogicOr;
import ip.industrialProcessing.logic.functions.or.TElogicOr;
import ip.industrialProcessing.logic.transport.wired.cable.MDlogicCable;
import ip.industrialProcessing.logic.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.logic.transport.wired.switchbox.MDlogicSwitchBox;
import ip.industrialProcessing.logic.transport.wired.switchbox.TElogicSwitchBox;

public class ClientProxy extends CommonProxy {
	public static int renderPass;
	private static final MDlogicSwitchBox MDlogicSwitchBox = new MDlogicSwitchBox();
	private static final MDlogicCable MDlogicCable = new MDlogicCable();
	private static final MDlogicAnd MDlogicAnd = new MDlogicAnd();
	private static final MDlogicOr MDlogicOr = new MDlogicOr();
	
	@Override
	public void registerRenderers() {
	ClientRegistry.bindTileEntitySpecialRenderer(TElogicSwitchBox.class, new RendererLogic(IPLogic.BLlogicSwitchBox, "MDlogicSwitchBox", MDlogicSwitchBox));
	ConfigLogic.setRDlogicSwitchBox(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicSwitchBox(), new TElogicSwitchBox()));

	ClientRegistry.bindTileEntitySpecialRenderer(TElogicCable.class, new RendererLogic(IPLogic.BLlogicCable, "MDlogicCable", MDlogicCable));
	ConfigLogic.setRDlogicCable(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicCable(), new TElogicCable()));

	ClientRegistry.bindTileEntitySpecialRenderer(TElogicAnd.class, new RendererLogic(IPLogic.BLlogicAnd, "MDlogicAnd", MDlogicAnd));
	ConfigLogic.setRDlogicAnd(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicAnd(), new TElogicAnd()));

	ClientRegistry.bindTileEntitySpecialRenderer(TElogicOr.class, new RendererLogic(IPLogic.BLlogicOr, "MDlogicAnd", MDlogicOr));
	ConfigLogic.setRDlogicOr(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicOr(), new TElogicOr()));
	}
}
