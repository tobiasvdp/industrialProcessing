package ip.industrialProcessing.client;

import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;
import ip.industrialProcessing.client.render.ModelConnectedFluidAnimated;
import ip.industrialProcessing.client.render.ModelMachine;
import ip.industrialProcessing.client.render.ModelStateMachine;
import ip.industrialProcessing.client.render.ModelingMultiblock;
import ip.industrialProcessing.client.render.RendererLivingEntity;
import ip.industrialProcessing.client.render.RendererLogic;
import ip.industrialProcessing.client.render.RendererTileEntity;
import ip.industrialProcessing.client.render.RendererTileEntityAnimated;
import ip.industrialProcessing.client.render.RendererTileEntityConnected;
import ip.industrialProcessing.client.render.RendererTileEntityConnectedFluid;
import ip.industrialProcessing.client.render.RendererTileEntityConnectedFluidAnimated;
import ip.industrialProcessing.client.render.RendererTileEntityFluidWorker;
import ip.industrialProcessing.client.render.RendererTileEntityState;
import ip.industrialProcessing.client.render.RenderingMultiblock;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.logic.functions.and.MDlogicAnd;
import ip.industrialProcessing.logic.functions.and.TElogicAnd;
import ip.industrialProcessing.logic.transport.wired.cable.MDlogicCable;
import ip.industrialProcessing.logic.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.logic.transport.wired.switchbox.MDlogicSwitchBox;
import ip.industrialProcessing.logic.transport.wired.switchbox.TElogicSwitchBox;
import ip.industrialProcessing.machines.RendererBlock;
import ip.industrialProcessing.machines.blastFurnace.ModelBlastFurnace;
import ip.industrialProcessing.machines.blastFurnace.ModelBlastFurnaceTop;
import ip.industrialProcessing.machines.blastFurnace.TileEntityBlastFurnace;
import ip.industrialProcessing.machines.crusher.ModelCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.ModelDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.filter.ModelFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.magneticSeparator.ModelMagneticSeperator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.ModelMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.multiblock.core.block.weldingStation.MDmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.MDmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.TEmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFramePanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.TEmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.ENmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.MDmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.TEmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.MDmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.screen.TEmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.MDmultiblockToggleButton2;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.MDmultiblockWeldingTableExt;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.TEmultiblockWeldingTableExt;
import ip.industrialProcessing.multiblock.dummy.block.wheel.MDmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheel.TEmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.MDmultiblockWheelConnector;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.TEmultiblockWheelConnector;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.ModelCrankGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.ModelVoltMeter;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.plants.ModelBoiler;
import ip.industrialProcessing.power.plants.ModelSolidBurner;
import ip.industrialProcessing.power.plants.ModelTurbine;
import ip.industrialProcessing.power.plants.TileEntityBoiler;
import ip.industrialProcessing.power.plants.TileEntityGenerator;
import ip.industrialProcessing.power.plants.TileEntitySolidBurner;
import ip.industrialProcessing.power.plants.TileEntityTurbine;
import ip.industrialProcessing.power.storage.ModelEnergyCell;
import ip.industrialProcessing.power.storage.TileEntityEnergyCell;
import ip.industrialProcessing.power.wire.ModelWire;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.transport.fluids.ModelManoMeter;
import ip.industrialProcessing.transport.fluids.ModelPump;
import ip.industrialProcessing.transport.fluids.ModelRainTank;
import ip.industrialProcessing.transport.fluids.ModelTank;
import ip.industrialProcessing.transport.fluids.ModelTransportFluids;
import ip.industrialProcessing.transport.fluids.ModelValve;
import ip.industrialProcessing.transport.fluids.TileEntityManoMeter;
import ip.industrialProcessing.transport.fluids.TileEntityPump;
import ip.industrialProcessing.transport.fluids.TileEntityRainTank;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import ip.industrialProcessing.transport.fluids.TileEntityValve;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.ModelConveyorBelt;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public static int renderPass;
	private static final ModelFilter filter = new ModelFilter();
	private static final ModelMachine magneticSeparator = new ModelMagneticSeperator();
	private static final ModelAnimatedFluidMachine mixer = new ModelMixer();
	private static final ModelCrusher crusher = new ModelCrusher();
	private static final ModelAnimatedMachine diskFilter = new ModelDiskFilter();
	private static final ModelConnected wire = new ModelWire();
	private static final ModelAnimatedMachine voltMeter = new ModelVoltMeter(false);
	private static final ModelAnimatedMachine ampMeter = new ModelVoltMeter(true);
	private static final ModelAnimatedMachine manoMeter = new ModelManoMeter();
	private static final ModelAnimatedFluidMachine pump = new ModelPump();
	private static final ModelConnectedFluid transportFluids = new ModelTransportFluids();
	private static final ModelAnimatedMachine EnergyCell = new ModelEnergyCell();
	private static final ModelConnectedFluid rainTank = new ModelRainTank();
	private static final ModelConnectedFluidAnimated valve = new ModelValve();

	private static final ModelAnimatedMachine crankGenerator = new ModelCrankGenerator(true);
	private static final ModelAnimatedMachine buildcraftGenerator = new ModelCrankGenerator(false);
	private static final ModelStateMachine blastFurnace = new ModelBlastFurnace();
	private static final ModelStateMachine blastFurnaceTop = new ModelBlastFurnaceTop();
	private static final ModelConnectedFluid tank = new ModelTank();
	private static final ModelAnimatedFluidMachine boiler = new ModelBoiler();
	private static final ModelMachine solidBurner = new ModelSolidBurner();
	private static final ModelAnimatedFluidMachine turbine = new ModelTurbine();
	private static final ModelAnimatedMachine generator = new ModelCrankGenerator(false);
	private static final MDmultiblockWeldingStation MDmultiblockWeldingStation = new MDmultiblockWeldingStation();
	private static final MDmultiblockScreen MDmultiblockScreen = new MDmultiblockScreen();
	private static final MDmultiblockFrame MDmultiblockFrame = new MDmultiblockFrame();
	private static final MDmultiblockWeldingTableExt MDmultiblockWeldingTableExt = new MDmultiblockWeldingTableExt();
	private static final MDmultiblockFramePanel MDmultiblockFramePanel = new MDmultiblockFramePanel();
	private static final MDmultiblockLiftDoor MDmultiblockLiftDoor = new MDmultiblockLiftDoor();
	private static final MDmultiblockToggleButton2 MDmultiblockToggleButton2 = new MDmultiblockToggleButton2();
	private static final MDmultiblockWheel MDmultiblockWheel = new MDmultiblockWheel();
	private static final MDmultiblockWheelConnector MDmulitblockWheelConnector = new MDmultiblockWheelConnector();
	private static final MDmultiblockWheelConnector MDmultiblockWheelConnector = new MDmultiblockWheelConnector();
	private static final MDmultiblockDisplayPanel MDmultiblockDisplayPanel = new MDmultiblockDisplayPanel(); 
	private static final ModelConveyorBelt conveyorBelt = new ModelConveyorBelt();  
	private static final MDlogicSwitchBox MDlogicSwitchBox = new MDlogicSwitchBox();
	private static final MDlogicCable MDlogicCable = new MDlogicCable();
	private static final MDlogicAnd MDlogicAnd = new MDlogicAnd(); 
	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockFilter, "ModelFilter", filter));
		ConfigRenderers.setRendererFilterId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererFilterId(), new TileEntityFilter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagneticSeparator.class, new RendererTileEntity(IndustrialProcessing.blockMageneticSeparator, "ModelMagneticSeperator", magneticSeparator));
		ConfigRenderers.setRendererMagneticSeperatorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMagneticSeperatorId(), new TileEntityMagneticSeparator()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMixer.class, new RendererTileEntityFluidWorker(IndustrialProcessing.blockMixer, "ModelMixer", mixer));
		ConfigRenderers.setRendererMixerId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMixerId(), new TileEntityMixer()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrusher.class, new RendererTileEntityAnimated(IndustrialProcessing.blockCrusher, "ModelCrusher", crusher));
		ConfigRenderers.setRendererCrusherId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererCrusherId(), new TileEntityCrusher()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiskFilter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockDiskFilter, "ModelDiskFilter", diskFilter));
		ConfigRenderers.setRendererDiskFilterIdId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDiskFilterId(), new TileEntityDiskFilter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new RendererTileEntityConnected(IndustrialProcessing.blockWire, "ModelWire", wire));
		ConfigRenderers.setRendererWireId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererWireId(), new TileEntityWire()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoltMeter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockVoltMeter, "ModelVoltMeter", voltMeter));
		ConfigRenderers.setRendererVoltMeterId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererVoltMeterId(), new TileEntityVoltMeter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAmpMeter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockAmpMeter, "ModelAmpMeter", ampMeter));
		ConfigRenderers.setRendererAmpMeterId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAmpMeterId(), new TileEntityAmpMeter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTank.class, new RendererTileEntityConnectedFluid(IndustrialProcessing.blockTank, "ModelTank", tank));
		ConfigRenderers.setRendererTankId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTankId(), new TileEntityTank()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityValve.class, new RendererTileEntityConnectedFluidAnimated(IndustrialProcessing.blockValve, "ModelValve", valve));
		ConfigRenderers.setRendererValveId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererValveId(), new TileEntityValve()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransportFluids.class, new RendererTileEntityConnectedFluid(IndustrialProcessing.blockTransportFluids, "ModelTransportFluids", transportFluids));
		ConfigRenderers.setRendererTransportFluidsId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTransportFluidsId(), new TileEntityTransportFluids()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRainTank.class, new RendererTileEntityConnectedFluid(IndustrialProcessing.blockRainTank, "ModelRainTank", rainTank));
		ConfigRenderers.setRendererRainTankId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererRainTankId(), new TileEntityRainTank()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurbine.class, new RendererTileEntityFluidWorker(IndustrialProcessing.blockTurbine, "ModelTurbine", turbine));
		ConfigRenderers.setRendererTurbineId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTurbineId(), new TileEntityTurbine()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPump.class, new RendererTileEntityFluidWorker(IndustrialProcessing.blockPump, "ModelPump", pump));
		ConfigRenderers.setRendererPumpId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererPumpId(), new TileEntityPump()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoiler.class, new RendererTileEntityFluidWorker(IndustrialProcessing.blockBoiler, "ModelBoiler", boiler));
		ConfigRenderers.setRendererBoilerId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBoilerId(), new TileEntityBoiler()));

		// TODO: get proper model
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManoMeter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockManometer, "ModelManoMeter", manoMeter));
		ConfigRenderers.setRendererManometerId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererManometerId(), new TileEntityManoMeter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolidBurner.class, new RendererTileEntity(IndustrialProcessing.blockSolidBurner, "ModelSolidBurner", solidBurner));
		ConfigRenderers.setRendererSolidBurnerId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererSolidBurnerId(), new TileEntitySolidBurner()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCell.class, new RendererTileEntityAnimated(IndustrialProcessing.blockEnergyCell, "ModelBatteryBox", EnergyCell));
		ConfigRenderers.setRendererEnergyCellId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererEnergyCellId(), new TileEntityEnergyCell()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlastFurnace.class, new RendererTileEntityState(IndustrialProcessing.blockBlastFurnace, new String[] { "ModelBlastFurnace", "ModelBlastFurnaceTop" }, new ModelStateMachine[] { blastFurnace, blastFurnaceTop }));
		ConfigRenderers.setRendererBlastFurnaceId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBlastFurnaceId(), new TileEntityBlastFurnace()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManualGenerator.class, new RendererTileEntityAnimated(IndustrialProcessing.blockManualGenerator, "ModelCrankGenerator", crankGenerator));
		ConfigRenderers.setRendererCrankGeneratorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererCrankGeneratorId(), new TileEntityManualGenerator()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.class, new RendererTileEntityAnimated(IndustrialProcessing.blockGenerator, "ModelCrankGenerator", generator));
		ConfigRenderers.setRendererGeneratorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererGeneratorId(), new TileEntityGenerator()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBuildcraftGenerator.class, new RendererTileEntityAnimated(IndustrialProcessing.blockBuildcraftGenerator, "ModelCrankGenerator", buildcraftGenerator));
		ConfigRenderers.setRendererBCGeneratorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBCGeneratorId(), new TileEntityBuildcraftGenerator()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWeldingStation.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWeldingStation, new String[] { "ModelMultiblockWeldingStation" }, new ModelingMultiblock[] { MDmultiblockWeldingStation }));
		ConfigRenderers.setBLmultiblockWeldingStation(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingStation(), new TEmultiblockWeldingStation()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockScreen.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockScreen, new String[] { "ModelMultiblockScreen" }, new ModelingMultiblock[] { MDmultiblockScreen }));
		ConfigRenderers.setBLmultiblockScreen(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockScreen(), new TEmultiblockScreen()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockFrame.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockFrame, new String[] { "ModelMultiblockFrame", "MDmultiblockFramePanel", "MDmultiblockElevatorGroundPanel" }, new ModelingMultiblock[] { MDmultiblockFrame, MDmultiblockFramePanel, MDmultiblockFramePanel }));
		ConfigRenderers.setBLmultiblockFrame(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockFrame(), new TEmultiblockFrame()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWeldingTableExt.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWeldingTableExt, new String[] { "ModelMultiblockWeldingStation" }, new ModelingMultiblock[] { MDmultiblockWeldingTableExt }));
		ConfigRenderers.setBLmultiblockWeldingTableExt(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingTableExt(), new TEmultiblockWeldingTableExt()));

		// ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockLiftDoor.class,
		// new RenderingMultiblock(IndustrialProcessing.BLmultiblockLiftDoor,
		// new String[] {"ModelMultiblockLiftDoor"}, new ModelingMultiblock[] {
		// MDmultiblockLiftDoor,null}));
		ConfigRenderers.setBLmultiblockLiftDoor(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockLiftDoor(), new TEmultiblockLiftDoor()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockToggleButton.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockToggleButton2, new String[] { "ModelLiftButton" }, new ModelingMultiblock[] { MDmultiblockToggleButton2 }));
		ConfigRenderers.setBLmultiblockToggleButton2(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockToggleButton2(), new TEmultiblockToggleButton()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWheel.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWheel, new String[] { "ModelWheel" }, new ModelingMultiblock[] { MDmultiblockWheel }));
		ConfigRenderers.setBLmultiblockWheel(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWheel(), new TEmultiblockWheel()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWheelConnector.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWheelConnector, new String[] { "MDmultiblockWheelConnector" }, new ModelingMultiblock[] { MDmultiblockWheelConnector }));
		ConfigRenderers.setBLmultiblockWheelConnector(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWheelConnector(), new TEmultiblockWheelConnector()));

		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockDisplayPanel.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockDisplayPanel, new String[] { "MDmultiblockDisplayPanel" }, new ModelingMultiblock[] { MDmultiblockDisplayPanel }));
		ConfigRenderers.setBLmultiblockDisplayPanel(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockDisplayPanel(), new TEmultiblockDisplayPanel()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorBelt.class, new RendererTileEntityConnected(IndustrialProcessing.BLtransportConveyorBelt, "ModelConveyor", conveyorBelt));
		ConfigRenderers.setBLtransportConveyorBelt(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLtransportConveyorBelt(), new TileEntityConveyorBelt()));

		ClientRegistry.bindTileEntitySpecialRenderer(TElogicSwitchBox.class, new RendererLogic(IndustrialProcessing.BLlogicSwitchBox, "MDlogicSwitchBox", MDlogicSwitchBox));
		ConfigRenderers.setBLlogicSwitchBox(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLlogicSwitchBox(), new TElogicSwitchBox()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TElogicCable.class, new RendererLogic(IndustrialProcessing.BLlogicCable, "MDlogicCable", MDlogicCable));
		ConfigRenderers.setBLlogicCable(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLlogicCable(), new TElogicCable()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TElogicAnd.class, new RendererLogic(IndustrialProcessing.BLlogicAnd, "MDlogicAnd", MDlogicAnd));
		ConfigRenderers.setBLlogicAnd(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLlogicAnd(), new TElogicAnd()));
		
		RenderingRegistry.registerEntityRenderingHandler(ENmultiblockFrame.class, new RendererLivingEntity(new MDmultiblockFramePanel(), 1.0F, "MDmultiblockFramePanel"));
		RenderingRegistry.registerEntityRenderingHandler(ENmultiblockLiftDoor.class, new RendererLivingEntity(new MDmultiblockLiftDoor(), 1.0F, "ModelMultiblockLiftDoor"));
	}
}
