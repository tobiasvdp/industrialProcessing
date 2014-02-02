package ip.industrialProcessing.subMod.logic.client;

import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.subMod.logic.CommonProxy;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model.Box;
import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model.Frame;
import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model.Label;
import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model.Lit;
import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model.ModelMachineInterface;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.model.ModelDisplayPanel;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.model.ModelDisplayPost;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.Down;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownBottomCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownLeftCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownTopCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.East;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.North;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.South;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.Up;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpBottomCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpLeftCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpTopCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.West;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestTop;
import ip.industrialProcessing.subMod.logic.old.function.and.MDlogicAnd;
import ip.industrialProcessing.subMod.logic.old.function.or.MDlogicOr;
import ip.industrialProcessing.subMod.logic.old.transport.wired.cable.MDlogicCable;
import ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox.MDlogicSwitchBox;
import ip.industrialProcessing.utils.registry.MicroBlockModelRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public static int renderPass;
	private static final MDlogicSwitchBox MDlogicSwitchBox = new MDlogicSwitchBox();
	private static final MDlogicCable MDlogicCable = new MDlogicCable();
	private static final MDlogicAnd MDlogicAnd = new MDlogicAnd();
	private static final MDlogicOr MDlogicOr = new MDlogicOr();
	
	private static final ModelDisplayPanel modelDisplayPanel = new ModelDisplayPanel();
	private static final ModelDisplayPost modelDisplayPost = new ModelDisplayPost();
	private static final ModelMachineInterface modelMachineInterface = new ModelMachineInterface();

	@Override
	public void registerRenderers() {
		
	    //microblocks
		registerMicroblocks();

		ConfigRenderers.setRendererDisplayPost(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDisplayPost(), modelDisplayPost));
		
		ConfigRenderers.setRendererDisplayPanel(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDisplayPanel(), modelDisplayPanel));
		
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
	
	//databus
	private static final  ObjMesh[][] dataBusCenter = new ObjMesh[][] { {new Down(), new Up(), new North(), new South(), new West(), new East() }};
    private static final  ObjMesh[][] dataBusInternal = new ObjMesh[][] { { new DownLeft(), new DownRight(), new DownTop(), new DownBottom() }, { new UpLeft(), new UpRight(), new UpTop(), new UpBottom() }, { new NorthLeft(), new NorthRight(), new NorthTop(), new NorthBottom() }, { new SouthLeft(), new SouthRight(), new SouthTop(), new SouthBottom() }, { new WestLeft(), new WestRight(), new WestTop(), new WestBottom() }, { new EastLeft(), new EastRight(), new EastTop(), new EastBottom() } };
    private static final  ObjMesh[][] dataBusCorners = new ObjMesh[][]{{new DownLeftCorner(),new DownRightCorner(),new DownTopCorner(),new DownBottomCorner()},{new UpLeftCorner(),new UpRightCorner(),new UpTopCorner(),new UpBottomCorner()},{null,new NorthRightCorner(),null,null},{null,new SouthRightCorner(),null,null},{null,new WestRightCorner(),null,null},{null,new EastRightCorner(),null,null}};
    private static final  String[][] dataBusCenterIcons = new String[][]{{"blockWire","blockWire","blockWire","blockWire","blockWire","blockWire"}};
    private static final  String[][] dataBusInternalIcons = new String[][]{{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"}};
    private static final  String[][] dataBusCornersIcons = new String[][]{{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"}};
    //machine interface
    private static final ObjRotator box = new ObjRotator(new Box(), 0);
    private static final ObjRotator frame = new ObjRotator(new Frame(), 0);
    private static final ObjRotator label = new ObjRotator(new Label(), 0);
    private static final ObjRotator lit = new ObjRotator(new Lit(), 0);
    private static final ObjMesh[][] machineInterface = new ObjMesh[][]{{ null, null, box.getRotated(0), box.getRotated(2), box.getRotated(1), box.getRotated(3)},{ null, null, frame.getRotated(0), frame.getRotated(2), frame.getRotated(1), frame.getRotated(3) },{ null, null, label.getRotated(0), label.getRotated(2), label.getRotated(1), label.getRotated(3) },{ null, null, lit.getRotated(0), lit.getRotated(2), lit.getRotated(1), lit.getRotated(3) }};
    private static final String[][] MachineInterfaceCenterIcons= new String[][]{{null,null,"Orange","Orange","Orange","Orange"},{null,null,"Iron","Iron","Iron","Iron"},{null,null,"DataPanel","DataPanel","DataPanel","DataPanel"},{null,null,"Orange","Orange","Orange","Orange"}};
    
    private void registerMicroblocks() {
		MicroBlockModelRegistry.registerModel(ConfigLogic.getRendererMicroblockDataBus(), dataBusCenter, dataBusInternal, dataBusCorners,dataBusCenterIcons,dataBusInternalIcons,dataBusCornersIcons);
		MicroBlockModelRegistry.registerModel(ConfigLogic.getRendererMicroblockMachineInterface(), machineInterface, dataBusInternal, dataBusCorners,MachineInterfaceCenterIcons,dataBusInternalIcons,dataBusCornersIcons);
	}
}
