package ip.industrialProcessing.client;

import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.api.rendering.ModelMachine;
import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.api.rendering.RendererTileBlock;
import ip.industrialProcessing.api.rendering.RendererTileEntity;
import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;
import ip.industrialProcessing.client.render.ModelConnectedFluidAnimated;
import ip.industrialProcessing.client.render.ModelingMultiblock;
import ip.industrialProcessing.client.render.RendererLivingEntity;
import ip.industrialProcessing.client.render.RendererTileEntityAnimated;
import ip.industrialProcessing.client.render.RendererTileEntityConnected;
import ip.industrialProcessing.client.render.RendererTileEntityConnectedFluid;
import ip.industrialProcessing.client.render.RendererTileEntityConnectedFluidAnimated;
import ip.industrialProcessing.client.render.RendererTileEntityFluidWorker;
import ip.industrialProcessing.client.render.RenderingMultiblock;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.decoration.block.machineBlock.model.ModelMachineBlock;
import ip.industrialProcessing.decoration.crystals.ModelCrystal;
import ip.industrialProcessing.decoration.light.PetrolLamp.model.ModelPetrolLamp;
import ip.industrialProcessing.decoration.platforms.ModelPlatform;
import ip.industrialProcessing.decoration.platforms.ModelStairs;
import ip.industrialProcessing.machines.classifier.ModelClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.ModelCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.ModelDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.diskFilter.model.ModelDiskFilterBlock;
import ip.industrialProcessing.machines.dryer.ModelDryer;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.filter.ModelFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.flotationCell.ModelFlotationCell;
import ip.industrialProcessing.machines.flotationCell.TileEntityFlotationCell;
import ip.industrialProcessing.machines.flotationCell.model.ModelFlotationCellBlock;
import ip.industrialProcessing.machines.mixer.ModelMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.plants.blacksmith.anvil.model.ModelAnvil;
import ip.industrialProcessing.machines.plants.blacksmith.grindingStone.model.ModelGrindingStone;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.ModelMagneticSeperator;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.thickener.ModelThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.machines.treetap.model.ModelAutomaticTreeTapBlock;
import ip.industrialProcessing.machines.treetap.model.ModelManualTreeTapBlock;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.model.ModelBlastFurnaceCoreBlock;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.model.ModelBlastFurnaceTopBlock;
import ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery.model.ModelBloomery;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.model.ModelAtmosphericDestillationTowerBlock;
import ip.industrialProcessing.multiblock.core.block.plants.storage.container.model.ModelContainer;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.ModelWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.bellows.model.ModelBellows;
import ip.industrialProcessing.multiblock.dummy.block.containerWall.model.ModelContainerWall;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.model.ModelDistillationElementBlock;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.MDmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.TEmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFramePanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.TEmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.ironBowl.model.ModelIronBowl;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.ENmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.MDmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.TEmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.TileEntityScreen;
import ip.industrialProcessing.multiblock.dummy.block.screen.model.ModelScreen;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.MDmultiblockToggleButton2;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.TileEntityMultiblockWeldingTable;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.model.ModelWeldingTable;
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
import ip.industrialProcessing.power.motor.TileEntityElectroMotor;
import ip.industrialProcessing.power.motor.models.ModelElectroMotorBlock;
import ip.industrialProcessing.power.motor.models.ModelElectroMotorTile;
import ip.industrialProcessing.power.plants.ModelBoiler;
import ip.industrialProcessing.power.plants.ModelGenerator;
import ip.industrialProcessing.power.plants.ModelSolidBurner;
import ip.industrialProcessing.power.plants.ModelTurbine;
import ip.industrialProcessing.power.plants.TileEntityBoiler;
import ip.industrialProcessing.power.plants.TileEntityGenerator;
import ip.industrialProcessing.power.plants.TileEntityTurbine;
import ip.industrialProcessing.power.plants.models.ModelGeneratorBlock;
import ip.industrialProcessing.power.plants.models.ModelTurbineBlock;
import ip.industrialProcessing.power.plants.models.boiler.ModelBoilerBlock;
import ip.industrialProcessing.power.plants.models.solidBurner.ModelSolidBurnerBlock;
import ip.industrialProcessing.power.storage.ModelEnergyCell;
import ip.industrialProcessing.power.storage.TileEntityEnergyCell;
import ip.industrialProcessing.power.wire.models.ModelWireBlock;
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
import ip.industrialProcessing.transport.fluids.models.ModelTankBlock;
import ip.industrialProcessing.transport.fluids.models.meter.ModelManometerBlock;
import ip.industrialProcessing.transport.fluids.models.pipe.ModelPipeBlock;
import ip.industrialProcessing.transport.fluids.models.pipe.ModelValveBlock;
import ip.industrialProcessing.transport.fluids.models.pump.ModelPumpBlock;
import ip.industrialProcessing.transport.fluids.models.raintank.ModelRainTankBlock;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.ModelConveyorBeltTile;
import ip.industrialProcessing.transport.items.conveyorInput.ModelConveyorInput;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorBeltBlock;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorChuteBlock;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorOutputBlock;
import ip.industrialProcessing.transport.items.conveyorOutput.ModelConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorOutput.TileEntityConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorSorter.ModelConveyorSorter;
import ip.industrialProcessing.transport.items.conveyorSorter.ModelConveyorSorterBlock;
import ip.industrialProcessing.transport.items.conveyorSorter.TileEntityConveyorSorter;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.EntityFloatingCart;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.ModelFloatingCart;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.RenderFloatingCart;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    public static int renderPass;
    private static final ModelFilter filter = new ModelFilter();
    private static final ModelMachine magneticSeparator = new ModelMagneticSeperator();
    private static final ModelAnimatedFluidMachine mixer = new ModelMixer();
    private static final ModelCrusher crusher = new ModelCrusher();
    private static final ModelAnimatedMachine diskFilter = new ModelDiskFilter();
    private static final ModelDiskFilterBlock diskFilterBlock = new ModelDiskFilterBlock();
    private static final ModelMachine dryer = new ModelDryer();
    private static final ModelAnimatedFluidMachine classifier = new ModelClassifier();
    private static final ModelAnimatedFluidMachine thickener = new ModelThickener();
    private static final ModelMachine flotationCell = new ModelFlotationCell();
    private static final ModelBlock wire = new ModelWireBlock();
    private static final ModelAnimatedMachine voltMeter = new ModelVoltMeter(false);
    private static final ModelAnimatedMachine ampMeter = new ModelVoltMeter(true);
    private static final ModelAnimatedMachine manoMeter = new ModelManoMeter();
    private static final ModelAnimatedMachine pump = new ModelPump();
    private static final ModelBlock modelPumpBlock = new ModelPumpBlock();
    private static final ModelConnectedFluid transportFluids = new ModelTransportFluids();
    private static final ModelAnimatedMachine EnergyCell = new ModelEnergyCell();
    private static final ModelConnectedFluid rainTank = new ModelRainTank();
    private static final ModelBlock rainTankBlock = new ModelRainTankBlock();
    private static final ModelConnectedFluidAnimated valveTile = new ModelValve();
    private static final ModelBlock valveBlock = new ModelValveBlock();

    private static final ModelAnimatedMachine crankGenerator = new ModelCrankGenerator(true);
    private static final ModelAnimatedMachine buildcraftGenerator = new ModelCrankGenerator(false);
    private static final ModelConnectedFluid tankEntity = new ModelTank();
    private static final ModelBlock tankBlock = new ModelTankBlock();
    private static final ModelBlock pipeBlock = new ModelPipeBlock();
    private static final ModelAnimatedFluidMachine boiler = new ModelBoiler();
    private static final ModelMachine solidBurner = new ModelSolidBurner();
    private static final ModelAnimatedFluidMachine turbine = new ModelTurbine();
    private static final ModelBlastFurnaceCoreBlock MDmultiblockBlastFurnace = new ModelBlastFurnaceCoreBlock();
    private static final ModelBlastFurnaceTopBlock MDmultiblockBlastFurnaceTower = new ModelBlastFurnaceTopBlock();
    private static final MDmultiblockFrame MDmultiblockFrame = new MDmultiblockFrame();
    private static final MDmultiblockFramePanel MDmultiblockFramePanel = new MDmultiblockFramePanel();
    private static final MDmultiblockLiftDoor MDmultiblockLiftDoor = new MDmultiblockLiftDoor();
    private static final MDmultiblockToggleButton2 MDmultiblockToggleButton2 = new MDmultiblockToggleButton2();
    private static final MDmultiblockWheel MDmultiblockWheel = new MDmultiblockWheel();
    private static final MDmultiblockWheelConnector MDmulitblockWheelConnector = new MDmultiblockWheelConnector();
    private static final MDmultiblockWheelConnector MDmultiblockWheelConnector = new MDmultiblockWheelConnector();
    private static final MDmultiblockDisplayPanel MDmultiblockDisplayPanel = new MDmultiblockDisplayPanel();
    private static final ModelConnected conveyorBelt = new ModelConveyorBeltTile();
    private static final ModelBlock conveyorBeltBlock = new ModelConveyorBeltBlock();
    private static final ModelBlock conveyorOutputBlock = new ModelConveyorOutputBlock();
    private static final ModelBlock conveyorSorterBlock = new ModelConveyorSorterBlock();
    private static final ModelBlock conveyorChuteBlock = new ModelConveyorChuteBlock();
    private static final ModelConnected conveyorInput = new ModelConveyorInput();
    private static final ModelConnected conveyorOutput = new ModelConveyorOutput();
    private static final ModelConnected conveyorSorter = new ModelConveyorSorter();
    private static final ModelBlock platform = new ModelPlatform();
    private static final ModelBlock stairs = new ModelStairs();
    private static final ModelBlock crystal = new ModelCrystal();
    private static final ModelBlock manometerBlock = new ModelManometerBlock();
    private static final ModelBlock automaticTreeTapBlock = new ModelAutomaticTreeTapBlock();
    private static final ModelBlock manualTreeTapBlock = new ModelManualTreeTapBlock();
    private static final ModelBlock modelTurbineBlock = new ModelTurbineBlock();

    private static final ModelAnimatedMachine generator = new ModelGenerator();
    private static final ModelBlock modelGeneratorBlock = new ModelGeneratorBlock();

    private static final ModelAnimatedMachine modelElectroMotorTile = new ModelElectroMotorTile();
    private static final ModelBlock modelElectroMotorBlock = new ModelElectroMotorBlock();

    private static final ModelSolidBurnerBlock solidBurnerBlock = new ModelSolidBurnerBlock();
    private static final ModelBoilerBlock modelBoilerBlock = new ModelBoilerBlock();

    private static final ModelDistillationElementBlock destillationElementBlock = new ModelDistillationElementBlock();
    private static final ModelAtmosphericDestillationTowerBlock destillationTowerBlock = new ModelAtmosphericDestillationTowerBlock();
    private static final ModelFlotationCellBlock flotationCellBlock = new ModelFlotationCellBlock();

    private static final ModelAnvil modelAnvil = new ModelAnvil();
    private static final ModelGrindingStone modelGrindingStone = new ModelGrindingStone();
    private static final ModelPetrolLamp modelPetrolLamp = new ModelPetrolLamp();
    private static final ModelBellows modelBellows = new ModelBellows();
    private static final ModelBloomery modelBloomery = new ModelBloomery();
    private static final ModelIronBowl modelIronBowl = new ModelIronBowl();
    private static final ModelMachineBlock modelMachineBlock = new ModelMachineBlock();
    private static final ModelContainerWall modelContainerWall = new ModelContainerWall();
    private static final ModelContainer modelContainer = new ModelContainer();
    private static final ModelScreen modelScreen = new ModelScreen();
    private static final ModelWeldingStation modelWeldingStation = new ModelWeldingStation();
    private static final ModelWeldingTable modelWeldingTable = new ModelWeldingTable(); 

    @Override
    public void registerRenderers() {
	// 100% block
	ConfigRenderers.setRendererCrystalId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererCrystalId(), crystal));

	ConfigRenderers.setRendererPlatformId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererPlatformId(), platform));

	ConfigRenderers.setRendererStairsId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererStairsId(), stairs));

	ConfigRenderers.setRendererWireId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererWireId(), wire));

	ConfigRenderers.setRendererAutomaticTreeTapID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAutomaticTreeTapID(), automaticTreeTapBlock));

	ConfigRenderers.setRendererManualTreeTapID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererManualTreeTapID(), manualTreeTapBlock));

	ConfigRenderers.setRendererSolidBurnerId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererSolidBurnerId(), solidBurnerBlock));

	ConfigRenderers.setRendererDestilationTray(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDestilationTray(), destillationElementBlock));

	ConfigRenderers.setRendererAtmosphericDestilationTower(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAtmosphericDestilationTower(), destillationTowerBlock));

	ConfigRenderers.setRendererAnvilId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAnvilId(), modelAnvil));

	ConfigRenderers.setRendererGrindingStoneId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererGrindingStoneId(), modelGrindingStone));

	ConfigRenderers.setRendererPetrolLampId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererPetrolLampId(), modelPetrolLamp));

	ConfigRenderers.setRendererBellowsId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBellowsId(), modelBellows));

	ConfigRenderers.setRendererBloomeryId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBloomeryId(), modelBloomery));

	ConfigRenderers.setRendererMultiblockBlastFurnaceID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererMultiblockBlastFurnaceID(), MDmultiblockBlastFurnace));

	ConfigRenderers.setRendererMultiblockBlastFurnaceTowerID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererMultiblockBlastFurnaceTowerID(), MDmultiblockBlastFurnaceTower));
	
	ConfigRenderers.setRendererIronBowlId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererIronBowlId(), modelIronBowl));
	
	ConfigRenderers.setRendererMachineBlockId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMachineBlockId(), modelMachineBlock));

	ConfigRenderers.setRendererContainerWall(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererContainerWall(), modelContainerWall));
	
	ConfigRenderers.setRendererContainer(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererContainer(), modelContainer));
	
	ConfigRenderers.setBLmultiblockScreen(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockScreen(), modelScreen));

	ConfigRenderers.setBLmultiblockWeldingStation(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingStation(), modelWeldingStation));
	
	ConfigRenderers.setBLmultiblockWeldingTableExt(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingTableExt(), modelWeldingTable));
	
	// block & tile entity
 
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiskFilter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockDiskFilter, "ModelDiskFilter", diskFilter));
	ConfigRenderers.setRendererDiskFilterIdId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDiskFilterId(), diskFilterBlock));

	
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlotationCell.class, new RendererTileEntity(ISetupMachineBlocks.blockFlotationCell, "ModelFlotationCell", flotationCell));

	ConfigRenderers.setRendererFlotationCellId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererFlotationCellId(), flotationCellBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorSorter.class, new RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorSorter, "ModelConveyorSorter", conveyorSorter));

	ConfigRenderers.setRendererConveyorSorterID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererConveyorSorterID(), conveyorSorterBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTank.class, new RendererTileEntityConnectedFluid(ISetupMachineBlocks.blockTank, "ModelTank", tankEntity));

	ConfigRenderers.setRendererTankId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTankId(), tankBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorBelt.class, new RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorBelt, "ModelConveyor", conveyorBelt));

	ConfigRenderers.setRendererConveyorBeltID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererConveyorBeltID(), conveyorBeltBlock));

	// Conveyor Output
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorOutput.class, new RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorOutput, "ModelConveyor", conveyorOutput));
	ConfigRenderers.setRendererConveyorOutputID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererConveyorOutputID(), conveyorOutputBlock));

	// Conveyor Chute
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorOutput.class, new RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorChute, "ModelConveyor", conveyorOutput));
	ConfigRenderers.setRendererConveyorChuteID(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererConveyorChuteID(), conveyorChuteBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransportFluids.class, new RendererTileEntityConnectedFluid(ISetupMachineBlocks.blockTransportFluids, "ModelTransportFluids", transportFluids));
	ConfigRenderers.setRendererTransportFluidsId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTransportFluidsId(), pipeBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityValve.class, new RendererTileEntityConnectedFluidAnimated(ISetupMachineBlocks.blockValve, "ModelValve", valveTile));

	ConfigRenderers.setRendererValveId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererValveId(), valveBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManoMeter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockManometer, "ModelManoMeter", manoMeter));

	ConfigRenderers.setRendererManometerId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererManometerId(), manometerBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRainTank.class, new RendererTileEntityConnectedFluid(ISetupMachineBlocks.blockRainTank, "ModelRainTank", rainTank));
	ConfigRenderers.setRendererRainTankId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererRainTankId(), rainTankBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurbine.class, new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockTurbine, "ModelTurbine", turbine));
	ConfigRenderers.setRendererTurbineId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTurbineId(), modelTurbineBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockGenerator, "ModelGenerator", generator));
	ConfigRenderers.setRendererGeneratorId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererGeneratorId(), modelGeneratorBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectroMotor.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockElectroMotor, "ModelGenerator", modelElectroMotorTile));
	ConfigRenderers.setRendererElectroMotorId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererElectroMotorId(), modelElectroMotorBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPump.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockPump, "ModelPump", pump));
	ConfigRenderers.setRendererPumpId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererPumpId(), modelPumpBlock));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoiler.class, new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockBoiler, "ModelBoiler", boiler));
	ConfigRenderers.setRendererBoilerId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBoilerId(), modelBoilerBlock));

	// 100% tile entity

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockFilter, "ModelFilter", filter));
	ConfigRenderers.setRendererFilterId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererFilterId(), new TileEntityFilter()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagneticSeparator.class, new RendererTileEntity(ISetupMachineBlocks.blockMageneticSeparator, "ModelMagneticSeperator", magneticSeparator));
	ConfigRenderers.setRendererMagneticSeperatorId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererMagneticSeperatorId(), new TileEntityMagneticSeparator()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMixer.class, new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockMixer, "ModelMixer", mixer));
	ConfigRenderers.setRendererMixerId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererMixerId(), new TileEntityMixer()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrusher.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockCrusher, "ModelCrusher", crusher));
	ConfigRenderers.setRendererCrusherId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererCrusherId(), new TileEntityCrusher()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDryer.class, new RendererTileEntity(ISetupMachineBlocks.blockDryer, "ModelDryer", dryer));
	ConfigRenderers.setRendererDryerId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererDryerId(), new TileEntityDryer()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityThickener.class, new RendererTileEntity(ISetupMachineBlocks.blockThickener, "ModelThickener", thickener));
	ConfigRenderers.setRendererThickenerId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererThickenerId(), new TileEntityThickener()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClassifier.class, new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockClassifier, "ModelClassifier", classifier));
	ConfigRenderers.setRendererClassifierId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererClassifierId(), new TileEntityClassifier()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoltMeter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockVoltMeter, "ModelVoltMeter", voltMeter));
	ConfigRenderers.setRendererVoltMeterId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererVoltMeterId(), new TileEntityVoltMeter()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAmpMeter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockAmpMeter, "ModelAmpMeter", ampMeter));
	ConfigRenderers.setRendererAmpMeterId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererAmpMeterId(), new TileEntityAmpMeter()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCell.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockEnergyCell, "ModelBatteryBox", EnergyCell));
	ConfigRenderers.setRendererEnergyCellId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererEnergyCellId(), new TileEntityEnergyCell()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManualGenerator.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockManualGenerator, "ModelCrankGenerator", crankGenerator));
	ConfigRenderers.setRendererCrankGeneratorId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererCrankGeneratorId(), new TileEntityManualGenerator()));

	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBuildcraftGenerator.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockBuildcraftGenerator, "ModelCrankGenerator", buildcraftGenerator));
	ConfigRenderers.setRendererBCGeneratorId(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererBCGeneratorId(), new TileEntityBuildcraftGenerator()));

	ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockFrame.class, new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockFrame, new String[] { "ModelMultiblockFrame", "MDmultiblockFramePanel", "MDmultiblockElevatorGroundPanel" }, new ModelingMultiblock[] { MDmultiblockFrame, MDmultiblockFramePanel, MDmultiblockFramePanel }));
	ConfigRenderers.setBLmultiblockFrame(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getBLmultiblockFrame(), new TEmultiblockFrame()));

	ConfigRenderers.setBLmultiblockLiftDoor(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getBLmultiblockLiftDoor(), new TEmultiblockLiftDoor()));

	ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockToggleButton.class, new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockToggleButton2, new String[] { "ModelLiftButton" }, new ModelingMultiblock[] { MDmultiblockToggleButton2 }));
	ConfigRenderers.setBLmultiblockToggleButton2(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getBLmultiblockToggleButton2(), new TEmultiblockToggleButton()));

	ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWheel.class, new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockWheel, new String[] { "ModelWheel" }, new ModelingMultiblock[] { MDmultiblockWheel }));
	ConfigRenderers.setBLmultiblockWheel(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getBLmultiblockWheel(), new TEmultiblockWheel()));

	ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWheelConnector.class, new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockWheelConnector, new String[] { "MDmultiblockWheelConnector" }, new ModelingMultiblock[] { MDmultiblockWheelConnector }));
	ConfigRenderers.setBLmultiblockWheelConnector(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getBLmultiblockWheelConnector(), new TEmultiblockWheelConnector()));

	ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockDisplayPanel.class, new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockDisplayPanel, new String[] { "MDmultiblockDisplayPanel" }, new ModelingMultiblock[] { MDmultiblockDisplayPanel }));
	ConfigRenderers.setBLmultiblockDisplayPanel(RenderingRegistry.getNextAvailableRenderId());
	RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getBLmultiblockDisplayPanel(), new TEmultiblockDisplayPanel()));

	RenderingRegistry.registerEntityRenderingHandler(ENmultiblockFrame.class, new RendererLivingEntity(new MDmultiblockFramePanel(), 1.0F, "MDmultiblockFramePanel"));
	RenderingRegistry.registerEntityRenderingHandler(ENmultiblockLiftDoor.class, new RendererLivingEntity(new MDmultiblockLiftDoor(), 1.0F, "ModelMultiblockLiftDoor"));

	RenderingRegistry.registerEntityRenderingHandler(EntityFloatingCart.class, new RenderFloatingCart(new ModelFloatingCart(), 0.5F));

    }
}
