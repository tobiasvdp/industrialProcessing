package ip.industrialProcessing.subMod.logic.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import ip.industrialProcessing.api.rendering.RendererTileBlock;
import ip.industrialProcessing.subMod.logic.CommonProxy;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.config.ISetupLogic;
import ip.industrialProcessing.subMod.logic.function.and.MDlogicAnd;
import ip.industrialProcessing.subMod.logic.function.and.TElogicAnd;
import ip.industrialProcessing.subMod.logic.function.or.MDlogicOr;
import ip.industrialProcessing.subMod.logic.function.or.TElogicOr;
import ip.industrialProcessing.subMod.logic.transport.wired.cable.MDlogicCable;
import ip.industrialProcessing.subMod.logic.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.subMod.logic.transport.wired.switchbox.MDlogicSwitchBox;
import ip.industrialProcessing.subMod.logic.transport.wired.switchbox.TElogicSwitchBox;

public class ClientProxy extends CommonProxy {
	public static int renderPass;
	private static final MDlogicSwitchBox MDlogicSwitchBox = new MDlogicSwitchBox();
	private static final MDlogicCable MDlogicCable = new MDlogicCable();
	private static final MDlogicAnd MDlogicAnd = new MDlogicAnd();
	private static final MDlogicOr MDlogicOr = new MDlogicOr();
	
	@Override
	public void registerRenderers() {
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
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigLogic.getRDlogicOr(), new TElogicOr()));
	}
}