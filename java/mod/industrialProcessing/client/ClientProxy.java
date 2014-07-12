package mod.industrialProcessing.client;

import mod.industrialProcessing.CommonProxy;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.block.crystals.ModelCrystal;
import mod.industrialProcessing.block.doors.emergency.model.ModelDoorEmergency;
import mod.industrialProcessing.block.platforms.ModelPlatform;
import mod.industrialProcessing.block.platforms.ModelStairs;
import mod.industrialProcessing.blockContainer.ISetupBlockContainers;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.tileEntity.ModelTileEntity;
import mod.industrialProcessing.plants.grinding.crusher.ModelCrusher;
import mod.industrialProcessing.utils.registry.RenderRegistry;

public class ClientProxy extends CommonProxy {
	public static int renderPass;

	/*
	 * private static final ModelFilter filter = new ModelFilter(); private
	 * static final ModelMachine magneticSeparator = new
	 * ModelMagneticSeperator(); private static final ModelAnimatedFluidMachine
	 * mixer = new ModelMixer(); private static final ModelCrusher crusher = new
	 * ModelCrusher(); private static final ModelAnimatedMachine diskFilter =
	 * new ModelDiskFilter(); private static final ModelDiskFilterBlock
	 * diskFilterBlock = new ModelDiskFilterBlock(); private static final
	 * ModelClassifierBlock modelClassifierBlock = new ModelClassifierBlock();
	 * private static final ModelMachine dryer = new ModelDryer(); private
	 * static final ModelAnimatedFluidMachine classifier = new
	 * ModelClassifier(); private static final ModelAnimatedFluidMachine
	 * thickener = new ModelThickener(); private static final ModelMachine
	 * flotationCell = new ModelFlotationCell(); private static final ModelBlock
	 * wire = new ModelWireBlock(); private static final ModelAnimatedMachine
	 * voltMeter = new ModelVoltMeter(false); private static final
	 * ModelAnimatedMachine ampMeter = new ModelVoltMeter(true); private static
	 * final ModelAnimatedMachine manoMeter = new ModelManoMeter(); private
	 * static final ModelAnimatedMachine pump = new ModelPump(); private static
	 * final ModelBlock modelPumpBlock = new ModelPumpBlock(); private static
	 * final ModelConnectedFluid transportFluids = new ModelTransportFluids();
	 * private static final ModelAnimatedMachine EnergyCell = new
	 * ModelEnergyCell(); private static final ModelConnectedFluid rainTank =
	 * new ModelRainTank(); private static final ModelBlock rainTankBlock = new
	 * ModelRainTankBlock(); private static final ModelConnectedFluidAnimated
	 * valveTile = new ModelValve(); private static final ModelBlock valveBlock
	 * = new ModelValveBlock();
	 * 
	 * private static final ModelAnimatedMachine crankGenerator = new
	 * ModelCrankGenerator(true); private static final ModelAnimatedMachine
	 * buildcraftGenerator = new ModelCrankGenerator(false); private static
	 * final ModelConnectedFluid tankEntity = new ModelTank(); private static
	 * final ModelBlock tankBlock = new ModelTankBlock(); private static final
	 * ModelBlock pipeBlock = new ModelPipeBlock(); private static final
	 * ModelAnimatedFluidMachine boiler = new ModelBoiler(); private static
	 * final ModelMachine solidBurner = new ModelSolidBurner(); private static
	 * final ModelAnimatedFluidMachine turbine = new ModelTurbine(); private
	 * static final ModelBlastFurnaceCoreBlock MDmultiblockBlastFurnace = new
	 * ModelBlastFurnaceCoreBlock(); private static final
	 * ModelBlastFurnaceTopBlock MDmultiblockBlastFurnaceTower = new
	 * ModelBlastFurnaceTopBlock(); private static final MDmultiblockFrame
	 * MDmultiblockFrame = new MDmultiblockFrame(); private static final
	 * MDmultiblockFramePanel MDmultiblockFramePanel = new
	 * MDmultiblockFramePanel(); private static final MDmultiblockLiftDoor
	 * MDmultiblockLiftDoor = new MDmultiblockLiftDoor(); private static final
	 * MDmultiblockToggleButton2 MDmultiblockToggleButton2 = new
	 * MDmultiblockToggleButton2(); private static final MDmultiblockWheel
	 * MDmultiblockWheel = new MDmultiblockWheel(); private static final
	 * MDmultiblockWheelConnector MDmulitblockWheelConnector = new
	 * MDmultiblockWheelConnector(); private static final
	 * MDmultiblockWheelConnector MDmultiblockWheelConnector = new
	 * MDmultiblockWheelConnector(); private static final
	 * MDmultiblockDisplayPanel MDmultiblockDisplayPanel = new
	 * MDmultiblockDisplayPanel(); private static final ModelConnected
	 * conveyorBelt = new ModelConveyorBeltTile(); private static final
	 * ModelBlock conveyorBeltBlock = new ModelConveyorBeltBlock(); private
	 * static final ModelBlock conveyorOutputBlock = new
	 * ModelConveyorOutputBlock(); private static final ModelBlock
	 * conveyorSorterBlock = new ModelConveyorSorterBlock(); private static
	 * final ModelBlock conveyorChuteBlock = new ModelConveyorChuteBlock();
	 * private static final ModelConnected conveyorOutput = new
	 * ModelConveyorOutput(); private static final ModelConnected conveyorSorter
	 * = new ModelConveyorSorter(); private static final ModelBlock platform =
	 * new ModelPlatform(); private static final ModelBlock stairs = new
	 * ModelStairs(); private static final ModelBlock manometerBlock = new
	 * ModelManometerBlock(); private static final ModelBlock
	 * automaticTreeTapBlock = new ModelAutomaticTreeTapBlock(); private static
	 * final ModelBlock manualTreeTapBlock = new ModelManualTreeTapBlock();
	 * private static final ModelBlock modelTurbineBlock = new
	 * ModelTurbineBlock();
	 * 
	 * private static final ModelAnimatedMachine generator = new
	 * ModelGenerator(); private static final ModelBlock modelGeneratorBlock =
	 * new ModelGeneratorBlock();
	 * 
	 * private static final ModelAnimatedMachine modelElectroMotorTile = new
	 * ModelElectroMotorTile(); private static final ModelBlock
	 * modelElectroMotorBlock = new ModelElectroMotorBlock();
	 * 
	 * private static final ModelSolidBurnerBlock solidBurnerBlock = new
	 * ModelSolidBurnerBlock(); private static final ModelBoilerBlock
	 * modelBoilerBlock = new ModelBoilerBlock(); private static final
	 * ModelThickenerBlock modelThickenerBlock = new ModelThickenerBlock();
	 * private static final ModelEnergyCellBlock modelEnergyCellBlock = new
	 * ModelEnergyCellBlock();
	 * 
	 * private static final ModelDistillationElementBlock
	 * destillationElementBlock = new ModelDistillationElementBlock(); private
	 * static final ModelAtmosphericDestillationTowerBlock
	 * destillationTowerBlock = new ModelAtmosphericDestillationTowerBlock();
	 * private static final ModelFlotationCellBlock flotationCellBlock = new
	 * ModelFlotationCellBlock(); private static final ModelHydroCycloneBlock
	 * hydroCycloneBlock = new ModelHydroCycloneBlock();
	 * 
	 * private static final ModelAnvil modelAnvil = new ModelAnvil(); private
	 * static final ModelGrindingStone modelGrindingStone = new
	 * ModelGrindingStone(); private static final ModelGrindingStoneAnimated
	 * modelGrindingStoneAnimated = new ModelGrindingStoneAnimated(); private
	 * static final ModelPetrolLamp modelPetrolLamp = new ModelPetrolLamp();
	 * private static final ModelMachineBlock modelMachineBlock = new
	 * ModelMachineBlock(); private static final ModelContainerWall
	 * modelContainerWall = new ModelContainerWall(); private static final
	 * ModelContainer modelContainer = new ModelContainer(); private static
	 * final ModelScreen modelScreen = new ModelScreen(); private static final
	 * ModelWeldingStation modelWeldingStation = new ModelWeldingStation();
	 * private static final ModelWeldingTable modelWeldingTable = new
	 * ModelWeldingTable(); private static final ModelSolderingStation
	 * modelSolderingStation = new ModelSolderingStation(); private static final
	 * ModelGarageDoor modelGarageDoor = new ModelGarageDoor(); private static
	 * final ModelGarageDoorFrame modelGarageDoorFrame = new
	 * ModelGarageDoorFrame(); private static final ModelControlBox
	 * modelControlBox = new ModelControlBox(); private static final
	 * ModelStorageRack modelStorageRack = new ModelStorageRack(); private
	 * static final ModelStorageRackAnimated modelStorageRackAnimated = new
	 * ModelStorageRackAnimated(); private static final ModelStorageBox
	 * modelStorageBox = new ModelStorageBox(); private static final ModelBlock
	 * modelConveyorPacker = new ModelConveyorPackerBlock(); private static
	 * final ModelBlock modelConveyorInput = new ModelConveyorInputBlock();
	 * private static final ModelIronPole modelIronPole = new ModelIronPole();
	 * private static final ModelDoorEmergency modelDoorEmergency = new
	 * ModelDoorEmergency(); private static final ModelSinterBlock modelSinter =
	 * new ModelSinterBlock(); private static final ModelSandCasterBlock
	 * modelSandCasterBlock = new ModelSandCasterBlock(); private static final
	 * ModelSandCaster modelSandCaster = new ModelSandCaster();
	 * 
	 * private static final ModelMicroBlock modelMicroBlock = new
	 * ModelMicroBlock();
	 */

	@Override
	public void registerRenderers() {


		/*
		 * // microblocks registerMicroblocks();
		 * 
		 * // smart rendering interface
		 * ConfigRenderers.setRendererInterface(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererInterfaceBlock(ConfigRenderers.getRendererInterface()));
		 * 
		 * // smart rendering tile entities
		 * ClientRegistry.bindTileEntitySpecialRenderer
		 * (TileEntitySandCaster.class, new
		 * RendererTileEntityAnimated(ISetupMachineBlocks.blockSandCaster,
		 * "ModelSandCaster", modelSandCaster));
		 * ClientRegistry.bindTileEntitySpecialRenderer
		 * (TileEntityGenerator.class, new
		 * RendererTileEntityAnimated(ISetupMachineBlocks.blockGenerator,
		 * "ModelGenerator", generator));
		 * 
		 * // 100% block ConfigRenderers.setRendererCrystalId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererCrystalId(), crystal));
		 * 
		 * ConfigRenderers.setRendererSinterId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererSinterId(), modelSinter));
		 * 
		 * ConfigRenderers.setRendererPlatformId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererPlatformId(), platform));
		 * 
		 * ConfigRenderers.setRendererStairsId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererStairsId(), stairs));
		 * 
		 * ConfigRenderers.setRendererWireId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererWireId(), wire));
		 * 
		 * ConfigRenderers.setRendererAutomaticTreeTapID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererAutomaticTreeTapID(),
		 * automaticTreeTapBlock));
		 * 
		 * ConfigRenderers.setRendererManualTreeTapID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererManualTreeTapID(),
		 * manualTreeTapBlock));
		 * 
		 * ConfigRenderers.setRendererDestilationTray(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererDestilationTray(),
		 * destillationElementBlock));
		 * 
		 * ConfigRenderers.setRendererAtmosphericDestilationTower(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers
		 * .getRendererAtmosphericDestilationTower(), destillationTowerBlock));
		 * 
		 * ConfigRenderers.setRendererAnvilId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererAnvilId(), modelAnvil));
		 * 
		 * ConfigRenderers.setRendererPetrolLampId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererPetrolLampId(),
		 * modelPetrolLamp));
		 * 
		 * ConfigRenderers.setRendererMultiblockBlastFurnaceID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getrendererMultiblockBlastFurnaceID(),
		 * MDmultiblockBlastFurnace));
		 * 
		 * ConfigRenderers.setRendererMultiblockBlastFurnaceTowerID(
		 * RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers
		 * .getrendererMultiblockBlastFurnaceTowerID(),
		 * MDmultiblockBlastFurnaceTower));
		 * 
		 * ConfigRenderers.setRendererMachineBlockId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererMachineBlockId(),
		 * modelMachineBlock));
		 * 
		 * ConfigRenderers.setRendererContainerWall(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererContainerWall(),
		 * modelContainerWall));
		 * 
		 * ConfigRenderers.setRendererContainer(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererContainer(),
		 * modelContainer));
		 * 
		 * ConfigRenderers.setBLmultiblockScreen(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getBLmultiblockScreen(), modelScreen));
		 * 
		 * ConfigRenderers.setBLmultiblockWeldingStation(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getBLmultiblockWeldingStation(),
		 * modelWeldingStation));
		 * 
		 * ConfigRenderers.setBLmultiblockWeldingTableExt(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getBLmultiblockWeldingTableExt(),
		 * modelWeldingTable));
		 * 
		 * ConfigRenderers.setRendererSolderingStation(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererSolderingStation(),
		 * modelSolderingStation));
		 * 
		 * ConfigRenderers.setRendererGarageDoor(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererGarageDoor(),
		 * modelGarageDoor));
		 * 
		 * ConfigRenderers.setRendererFlotationCellId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererFlotationCellId(),
		 * flotationCellBlock));
		 * 
		 * ConfigRenderers.setRendererHydroCycloneId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererHydroCycloneId(),
		 * hydroCycloneBlock));
		 * 
		 * ConfigRenderers.setRendererGarageDoorFrame(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererGarageDoorFrame(),
		 * modelGarageDoorFrame));
		 * 
		 * ConfigRenderers.setRendererControlBox(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererControlBox(),
		 * modelControlBox));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStorageRack.class
		 * , new
		 * RendererTileEntityAnimated(ISetupMachineBlocks.blockStorageRack,
		 * "ModelStorageRack", modelStorageRackAnimated));
		 * ConfigRenderers.setRendererStorageRack
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererStorageRack(),
		 * modelStorageRack));
		 * 
		 * ConfigRenderers.setRendererStorageBox(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererStorageBox(),
		 * modelStorageBox));
		 * 
		 * ConfigRenderers.setRendererConveyorPackerID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererConveyorPackerID(),
		 * modelConveyorPacker));
		 * 
		 * ConfigRenderers.setRendererConveyorInputID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererConveyorInputID(),
		 * modelConveyorInput));
		 * 
		 * ConfigRenderers.setRendererIronPole(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererIronPole(), modelIronPole));
		 * 
		 * ConfigRenderers.setRendererDoorEmergency(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererDoorEmergency(),
		 * modelDoorEmergency));
		 * 
		 * // block & tile entity
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClassifier.class
		 * , new
		 * RendererTileEntityFluidWorker(ISetupMachineBlocks.blockClassifier,
		 * "ModelClassifier", classifier));
		 * ConfigRenderers.setRendererClassifierId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererClassifierId(),
		 * modelClassifierBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindingStone.
		 * class, new
		 * RendererTileEntityAnimated(ISetupMachineBlocks.blockGrindingStone,
		 * "GrindingStone", modelGrindingStoneAnimated));
		 * ConfigRenderers.setRendererGrindingStoneId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererGrindingStoneId(),
		 * modelGrindingStone));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiskFilter.class
		 * , new RendererTileEntityAnimated(ISetupMachineBlocks.blockDiskFilter,
		 * "ModelDiskFilter", diskFilter));
		 * ConfigRenderers.setRendererDiskFilterIdId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererDiskFilterId(),
		 * diskFilterBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorSorter.
		 * class, new
		 * RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorSorter,
		 * "ModelConveyor", conveyorSorter));
		 * 
		 * ConfigRenderers.setRendererConveyorSorterID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererConveyorSorterID(),
		 * conveyorSorterBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTank.class,
		 * new RendererTileEntityConnectedFluid(ISetupMachineBlocks.blockTank,
		 * "ModelTank", tankEntity));
		 * 
		 * ConfigRenderers.setRendererTankId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererTankId(), tankBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorBelt.class
		 * , new
		 * RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorBelt,
		 * "ModelConveyor", conveyorBelt));
		 * 
		 * ConfigRenderers.setRendererConveyorBeltID(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererConveyorBeltID(),
		 * conveyorBeltBlock));
		 * 
		 * // Conveyor Output
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorOutput
		 * .class, new
		 * RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorOutput,
		 * "ModelConveyor", conveyorOutput));
		 * ConfigRenderers.setRendererConveyorOutputID
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererConveyorOutputID(),
		 * conveyorOutputBlock));
		 * 
		 * // Conveyor Chute
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorOutput
		 * .class, new
		 * RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorChute,
		 * "ModelConveyor", conveyorOutput));
		 * ConfigRenderers.setRendererConveyorChuteID
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererConveyorChuteID(),
		 * conveyorChuteBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransportFluids
		 * .class, new
		 * RendererTileEntityConnectedFluid(ISetupMachineBlocks.blockTransportFluids
		 * , "ModelTransportFluids", transportFluids));
		 * ConfigRenderers.setRendererTransportFluidsId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererTransportFluidsId(),
		 * pipeBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityValve.class,
		 * new
		 * RendererTileEntityConnectedFluidAnimated(ISetupMachineBlocks.blockValve
		 * , "ModelValve", valveTile));
		 * 
		 * ConfigRenderers.setRendererValveId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererValveId(), valveBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManoMeter.class
		 * , new RendererTileEntityAnimated(ISetupMachineBlocks.blockManometer,
		 * "ModelManoMeter", manoMeter));
		 * 
		 * ConfigRenderers.setRendererManometerId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererManometerId(),
		 * manometerBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRainTank.class,
		 * new
		 * RendererTileEntityConnectedFluid(ISetupMachineBlocks.blockRainTank,
		 * "ModelRainTank", rainTank));
		 * ConfigRenderers.setRendererRainTankId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererRainTankId(),
		 * rainTankBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurbine.class,
		 * new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockTurbine,
		 * "ModelTurbine", turbine));
		 * ConfigRenderers.setRendererTurbineId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererTurbineId(),
		 * modelTurbineBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectroMotor.class
		 * , new
		 * RendererTileEntityAnimated(ISetupMachineBlocks.blockElectroMotor,
		 * "ModelGenerator", modelElectroMotorTile));
		 * ConfigRenderers.setRendererElectroMotorId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererElectroMotorId(),
		 * modelElectroMotorBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPump.class,
		 * new RendererTileEntityAnimated(ISetupMachineBlocks.blockPump,
		 * "ModelPump", pump));
		 * ConfigRenderers.setRendererPumpId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererPumpId(), modelPumpBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoiler.class,
		 * new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockBoiler,
		 * "ModelBoiler", boiler));
		 * ConfigRenderers.setRendererBoilerId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererBoilerId(),
		 * modelBoilerBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityThickener.class
		 * , new RendererTileEntity(ISetupMachineBlocks.blockThickener,
		 * "ModelThickener", thickener));
		 * ConfigRenderers.setRendererThickenerId(
		 * RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererThickenerId(),
		 * modelThickenerBlock));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCell.class
		 * , new RendererTileEntityAnimated(ISetupMachineBlocks.blockEnergyCell,
		 * "battery", EnergyCell));
		 * ConfigRenderers.setRendererEnergyCellId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererBlock(ConfigRenderers.getRendererEnergyCellId(),
		 * modelEnergyCellBlock));
		 * 
		 * // 100% tile entity
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class,
		 * new RendererTileEntityAnimated(ISetupMachineBlocks.blockFilter,
		 * "ModelFilter", filter));
		 * ConfigRenderers.setRendererFilterId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererFilterId(), new
		 * TileEntityFilter()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagneticSeparator
		 * .class, new
		 * RendererTileEntity(ISetupMachineBlocks.blockMageneticSeparator,
		 * "ModelMagneticSeperator", magneticSeparator));
		 * ConfigRenderers.setRendererMagneticSeperatorId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererMagneticSeperatorId(),
		 * new TileEntityMagneticSeparator()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMixer.class,
		 * new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockMixer,
		 * "ModelMixer", mixer));
		 * ConfigRenderers.setRendererMixerId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererMixerId(), new
		 * TileEntityMixer()));
		 * 
		 * 
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDryer.class,
		 * new RendererTileEntity(ISetupMachineBlocks.blockDryer, "ModelDryer",
		 * dryer)); ConfigRenderers.setRendererDryerId(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererDryerId(), new
		 * TileEntityDryer()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoltMeter.class
		 * , new RendererTileEntityAnimated(ISetupMachineBlocks.blockVoltMeter,
		 * "ModelVoltMeter", voltMeter));
		 * ConfigRenderers.setRendererVoltMeterId(
		 * RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererVoltMeterId(), new
		 * TileEntityVoltMeter()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManualGenerator
		 * .class, new
		 * RendererTileEntityAnimated(ISetupMachineBlocks.blockManualGenerator,
		 * "ModelCrankGenerator", crankGenerator));
		 * ConfigRenderers.setRendererCrankGeneratorId
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererCrankGeneratorId(), new
		 * TileEntityManualGenerator()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(
		 * TileEntityBuildcraftGenerator.class, new
		 * RendererTileEntityAnimated(ISetupMachineBlocks
		 * .blockBuildcraftGenerator, "ModelCrankGenerator",
		 * buildcraftGenerator));
		 * ConfigRenderers.setRendererBCGeneratorId(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getRendererBCGeneratorId(), new
		 * TileEntityBuildcraftGenerator()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockFrame.class,
		 * new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockFrame, new
		 * String[] { "ModelMultiblockFrame", "MDmultiblockFramePanel",
		 * "MDmultiblockElevatorGroundPanel" }, new ModelingMultiblock[] {
		 * MDmultiblockFrame, MDmultiblockFramePanel, MDmultiblockFramePanel
		 * })); ConfigRenderers.setBLmultiblockFrame(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getBLmultiblockFrame(), new
		 * TEmultiblockFrame()));
		 * 
		 * ConfigRenderers.setBLmultiblockLiftDoor(RenderingRegistry.
		 * getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getBLmultiblockLiftDoor(), new
		 * TEmultiblockLiftDoor()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockToggleButton.
		 * class, new
		 * RenderingMultiblock(ISetupMachineBlocks.BLmultiblockToggleButton2,
		 * new String[] { "ModelLiftButton" }, new ModelingMultiblock[] {
		 * MDmultiblockToggleButton2 }));
		 * ConfigRenderers.setBLmultiblockToggleButton2
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getBLmultiblockToggleButton2(), new
		 * TEmultiblockToggleButton()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWheel.class,
		 * new RenderingMultiblock(ISetupMachineBlocks.BLmultiblockWheel, new
		 * String[] { "ModelWheel" }, new ModelingMultiblock[] {
		 * MDmultiblockWheel }));
		 * ConfigRenderers.setBLmultiblockWheel(RenderingRegistry
		 * .getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getBLmultiblockWheel(), new
		 * TEmultiblockWheel()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWheelConnector
		 * .class, new
		 * RenderingMultiblock(ISetupMachineBlocks.BLmultiblockWheelConnector,
		 * new String[] { "MDmultiblockWheelConnector" }, new
		 * ModelingMultiblock[] { MDmultiblockWheelConnector }));
		 * ConfigRenderers
		 * .setBLmultiblockWheelConnector(RenderingRegistry.getNextAvailableRenderId
		 * ()); RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getBLmultiblockWheelConnector(),
		 * new TEmultiblockWheelConnector()));
		 * 
		 * ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockDisplayPanel.
		 * class, new
		 * RenderingMultiblock(ISetupMachineBlocks.BLmultiblockDisplayPanel, new
		 * String[] { "MDmultiblockDisplayPanel" }, new ModelingMultiblock[] {
		 * MDmultiblockDisplayPanel }));
		 * ConfigRenderers.setBLmultiblockDisplayPanel
		 * (RenderingRegistry.getNextAvailableRenderId());
		 * RenderingRegistry.registerBlockHandler(new
		 * RendererTileBlock(ConfigRenderers.getBLmultiblockDisplayPanel(), new
		 * TEmultiblockDisplayPanel()));
		 * 
		 * // register entities
		 * RenderingRegistry.registerEntityRenderingHandler(
		 * ENmultiblockFrame.class, new RendererLivingEntity(new
		 * MDmultiblockFramePanel(), 1.0F, "MDmultiblockFramePanel"));
		 * RenderingRegistry
		 * .registerEntityRenderingHandler(ENmultiblockLiftDoor.class, new
		 * RendererLivingEntity(new MDmultiblockLiftDoor(), 1.0F,
		 * "ModelMultiblockLiftDoor"));
		 * 
		 * RenderingRegistry.registerEntityRenderingHandler(EntityFloatingCart.class
		 * , new RenderFloatingCart(new ModelFloatingCart(), 0.5F));
		 * RenderingRegistry
		 * .registerEntityRenderingHandler(EntityGarageDoor.class, new
		 * RenderGarageDoor(new ModelEntityGarageDoor()));
		 * 
		 * RenderingRegistry.registerEntityRenderingHandler(EntityBobcatMiner.class
		 * , new RendererEntity(new ModelBobcatMiner(),
		 * "ModelBobcatMinerHull"));
		 */
	}

	private void registerMicroblocks() {
		// ConfigRenderers.setRendererMicroBlock(RenderingRegistry.getNextAvailableRenderId());
		// RenderingRegistry.registerBlockHandler(new
		// RendererBlock(ConfigRenderers.getRendererMicroBlock(),
		// modelMicroBlock));
	}
}
