package ip.industrialProcessing.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.api.rendering.ModelMachine;
import ip.industrialProcessing.api.rendering.RendererBlock;
import ip.industrialProcessing.api.rendering.RendererInterfaceBlock;
import ip.industrialProcessing.api.rendering.RendererTileBlock;
import ip.industrialProcessing.api.rendering.RendererTileEntity;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;
import ip.industrialProcessing.client.render.ModelConnectedFluidAnimated;
import ip.industrialProcessing.client.render.ModelingMultiblock;
import ip.industrialProcessing.client.render.RendererEntity;
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
import ip.industrialProcessing.decoration.doors.emergency.model.ModelDoorEmergency;
import ip.industrialProcessing.decoration.light.hangingLamp.model.ModelPetrolLamp;
import ip.industrialProcessing.decoration.platforms.ModelPlatform;
import ip.industrialProcessing.decoration.platforms.ModelStairs;
import ip.industrialProcessing.machines.classifier.ModelClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.classifier.model.ModelClassifierBlock;
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
import ip.industrialProcessing.machines.flotationCell.model.ModelFlotationCellBlock;
import ip.industrialProcessing.machines.hydroCyclone.model.ModelHydroCycloneBlock;
import ip.industrialProcessing.machines.mixer.ModelMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.TileEntitySandCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model.ModelSandCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model.ModelSandCasterBlock;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.ModelMagneticSeperator;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.plants.storage.storageBox.model.ModelStorageBox;
import ip.industrialProcessing.machines.plants.storage.storageRack.TileEntityStorageRack;
import ip.industrialProcessing.machines.plants.storage.storageRack.model.ModelStorageRack;
import ip.industrialProcessing.machines.plants.storage.storageRack.model.ModelStorageRackAnimated;
import ip.industrialProcessing.machines.sinter.model.ModelSinterBlock;
import ip.industrialProcessing.machines.thickener.ModelThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.machines.thickener.model.ModelThickenerBlock;
import ip.industrialProcessing.machines.treetap.model.ModelAutomaticTreeTapBlock;
import ip.industrialProcessing.machines.treetap.model.ModelManualTreeTapBlock;
import ip.industrialProcessing.microBlock.rendering.ModelMicroBlock;
import ip.industrialProcessing.multiblock.core.block.SolderingStation.model.ModelSolderingStation;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.model.ModelBlastFurnaceCoreBlock;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.model.ModelBlastFurnaceTopBlock;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.model.ModelAtmosphericDestillationTowerBlock;
import ip.industrialProcessing.multiblock.core.block.plants.storage.container.model.ModelContainer;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.ModelWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.containerWall.model.ModelContainerWall;
import ip.industrialProcessing.multiblock.dummy.block.controlBox.model.ModelControlBox;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.EntityGarageDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.ModelEntityGarageDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.RenderGarageDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.modelDoor.ModelGarageDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.modelFrame.ModelGarageDoorFrame;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.model.ModelDistillationElementBlock;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.MDmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.TEmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFramePanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.TEmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.ironPole.model.ModelIronPole;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.ENmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.MDmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.TEmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.model.ModelScreen;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.MDmultiblockToggleButton2;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.model.ModelWeldingTable;
import ip.industrialProcessing.multiblock.dummy.block.wheel.MDmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheel.TEmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.MDmultiblockWheelConnector;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.TEmultiblockWheelConnector;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.ModelCrankGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.ModelVoltMeter;
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
import ip.industrialProcessing.power.storage.model.ModelEnergyCellBlock;
import ip.industrialProcessing.power.wire.models.ModelWireBlock;
import ip.industrialProcessing.subMod.blackSmith.plant.anvil.model.ModelAnvil;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.model.ModelBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model.ModelIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.model.ModelBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.grindingStone.TileEntityGrindingStone;
import ip.industrialProcessing.subMod.blackSmith.plant.grindingStone.model.ModelGrindingStone;
import ip.industrialProcessing.subMod.blackSmith.plant.grindingStone.model.ModelGrindingStoneAnimated;
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
import ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.EntityBobcatMiner;
import ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model.ModelBobcatMiner;
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
import ip.industrialProcessing.transport.items.conveyorInput.model.ModelConveyorInputBlock;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorBeltBlock;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorChuteBlock;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorOutputBlock;
import ip.industrialProcessing.transport.items.conveyorOutput.ModelConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorOutput.TileEntityConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorPacker.model.ModelConveyorPackerBlock;
import ip.industrialProcessing.transport.items.conveyorSorter.ModelConveyorSorter;
import ip.industrialProcessing.transport.items.conveyorSorter.ModelConveyorSorterBlock;
import ip.industrialProcessing.transport.items.conveyorSorter.TileEntityConveyorSorter;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.EntityFloatingCart;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.ModelFloatingCart;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.RenderFloatingCart;
import ip.industrialProcessing.utils.registry.MicroBlockModelRegistry;
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
    private static final ModelClassifierBlock modelClassifierBlock = new ModelClassifierBlock();
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
    private static final ModelThickenerBlock modelThickenerBlock = new ModelThickenerBlock();
    private static final ModelEnergyCellBlock modelEnergyCellBlock = new ModelEnergyCellBlock();

    private static final ModelDistillationElementBlock destillationElementBlock = new ModelDistillationElementBlock();
    private static final ModelAtmosphericDestillationTowerBlock destillationTowerBlock = new ModelAtmosphericDestillationTowerBlock();
    private static final ModelFlotationCellBlock flotationCellBlock = new ModelFlotationCellBlock();
    private static final ModelHydroCycloneBlock hydroCycloneBlock = new ModelHydroCycloneBlock();

    private static final ModelAnvil modelAnvil = new ModelAnvil();
    private static final ModelGrindingStone modelGrindingStone = new ModelGrindingStone();
    private static final ModelGrindingStoneAnimated modelGrindingStoneAnimated = new ModelGrindingStoneAnimated();
    private static final ModelPetrolLamp modelPetrolLamp = new ModelPetrolLamp();
    private static final ModelMachineBlock modelMachineBlock = new ModelMachineBlock();
    private static final ModelContainerWall modelContainerWall = new ModelContainerWall();
    private static final ModelContainer modelContainer = new ModelContainer();
    private static final ModelScreen modelScreen = new ModelScreen();
    private static final ModelWeldingStation modelWeldingStation = new ModelWeldingStation();
    private static final ModelWeldingTable modelWeldingTable = new ModelWeldingTable();
    private static final ModelSolderingStation modelSolderingStation = new ModelSolderingStation();
    private static final ModelGarageDoor modelGarageDoor = new ModelGarageDoor();
    private static final ModelGarageDoorFrame modelGarageDoorFrame = new ModelGarageDoorFrame();
    private static final ModelControlBox modelControlBox = new ModelControlBox();
    private static final ModelStorageRack modelStorageRack = new ModelStorageRack();
    private static final ModelStorageRackAnimated modelStorageRackAnimated = new ModelStorageRackAnimated();
    private static final ModelStorageBox modelStorageBox = new ModelStorageBox();
    private static final ModelBlock modelConveyorPacker = new ModelConveyorPackerBlock();
    private static final ModelBlock modelConveyorInput = new ModelConveyorInputBlock();
    private static final ModelIronPole modelIronPole = new ModelIronPole();
    private static final ModelDoorEmergency modelDoorEmergency = new ModelDoorEmergency();
    private static final ModelSinterBlock modelSinter = new ModelSinterBlock();
    private static final ModelSandCasterBlock modelSandCasterBlock = new ModelSandCasterBlock();
    private static final ModelSandCaster modelSandCaster = new ModelSandCaster();

    private static final ModelMicroBlock modelMicroBlock = new ModelMicroBlock();

    @Override
    public void registerRenderers() {

        // microblocks
        registerMicroblocks();

        // smart rendering interface
        ConfigRenderers.setRendererInterface(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererInterfaceBlock(ConfigRenderers.getRendererInterface()));

        // smart rendering tile entities
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySandCaster.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockSandCaster, "ModelSandCaster", modelSandCaster));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockGenerator, "ModelGenerator", generator));

        // 100% block
        ConfigRenderers.setRendererCrystalId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererCrystalId(), crystal));

        ConfigRenderers.setRendererSinterId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererSinterId(), modelSinter));

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

        ConfigRenderers.setRendererDestilationTray(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDestilationTray(), destillationElementBlock));

        ConfigRenderers.setRendererAtmosphericDestilationTower(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAtmosphericDestilationTower(), destillationTowerBlock));

        ConfigRenderers.setRendererAnvilId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAnvilId(), modelAnvil));

        ConfigRenderers.setRendererPetrolLampId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererPetrolLampId(), modelPetrolLamp));

        ConfigRenderers.setRendererMultiblockBlastFurnaceID(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererMultiblockBlastFurnaceID(), MDmultiblockBlastFurnace));

        ConfigRenderers.setRendererMultiblockBlastFurnaceTowerID(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererMultiblockBlastFurnaceTowerID(), MDmultiblockBlastFurnaceTower));

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

        ConfigRenderers.setRendererSolderingStation(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererSolderingStation(), modelSolderingStation));

        ConfigRenderers.setRendererGarageDoor(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererGarageDoor(), modelGarageDoor));

        ConfigRenderers.setRendererFlotationCellId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererFlotationCellId(), flotationCellBlock));

        ConfigRenderers.setRendererHydroCycloneId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererHydroCycloneId(), hydroCycloneBlock));

        ConfigRenderers.setRendererGarageDoorFrame(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererGarageDoorFrame(), modelGarageDoorFrame));

        ConfigRenderers.setRendererControlBox(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererControlBox(), modelControlBox));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStorageRack.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockStorageRack, "ModelStorageRack", modelStorageRackAnimated));
        ConfigRenderers.setRendererStorageRack(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererStorageRack(), modelStorageRack));

        ConfigRenderers.setRendererStorageBox(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererStorageBox(), modelStorageBox));

        ConfigRenderers.setRendererConveyorPackerID(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererConveyorPackerID(), modelConveyorPacker));

        ConfigRenderers.setRendererConveyorInputID(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererConveyorInputID(), modelConveyorInput));

        ConfigRenderers.setRendererIronPole(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererIronPole(), modelIronPole));

        ConfigRenderers.setRendererDoorEmergency(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDoorEmergency(), modelDoorEmergency));

        // block & tile entity

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClassifier.class, new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockClassifier, "ModelClassifier", classifier));
        ConfigRenderers.setRendererClassifierId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererClassifierId(), modelClassifierBlock));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindingStone.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockGrindingStone, "GrindingStone", modelGrindingStoneAnimated));
        ConfigRenderers.setRendererGrindingStoneId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererGrindingStoneId(), modelGrindingStone));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiskFilter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockDiskFilter, "ModelDiskFilter", diskFilter));
        ConfigRenderers.setRendererDiskFilterIdId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDiskFilterId(), diskFilterBlock));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyorSorter.class, new RendererTileEntityConnected(ISetupMachineBlocks.blockConveyorSorter, "ModelConveyor", conveyorSorter));

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

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectroMotor.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockElectroMotor, "ModelGenerator", modelElectroMotorTile));
        ConfigRenderers.setRendererElectroMotorId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererElectroMotorId(), modelElectroMotorBlock));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPump.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockPump, "ModelPump", pump));
        ConfigRenderers.setRendererPumpId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererPumpId(), modelPumpBlock));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoiler.class, new RendererTileEntityFluidWorker(ISetupMachineBlocks.blockBoiler, "ModelBoiler", boiler));
        ConfigRenderers.setRendererBoilerId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBoilerId(), modelBoilerBlock));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityThickener.class, new RendererTileEntity(ISetupMachineBlocks.blockThickener, "ModelThickener", thickener));
        ConfigRenderers.setRendererThickenerId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererThickenerId(), modelThickenerBlock));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCell.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockEnergyCell, "battery", EnergyCell));
        ConfigRenderers.setRendererEnergyCellId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererEnergyCellId(), modelEnergyCellBlock));

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

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoltMeter.class, new RendererTileEntityAnimated(ISetupMachineBlocks.blockVoltMeter, "ModelVoltMeter", voltMeter));
        ConfigRenderers.setRendererVoltMeterId(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererTileBlock(ConfigRenderers.getRendererVoltMeterId(), new TileEntityVoltMeter()));

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

        // register entities
        RenderingRegistry.registerEntityRenderingHandler(ENmultiblockFrame.class, new RendererLivingEntity(new MDmultiblockFramePanel(), 1.0F, "MDmultiblockFramePanel"));
        RenderingRegistry.registerEntityRenderingHandler(ENmultiblockLiftDoor.class, new RendererLivingEntity(new MDmultiblockLiftDoor(), 1.0F, "ModelMultiblockLiftDoor"));

        RenderingRegistry.registerEntityRenderingHandler(EntityFloatingCart.class, new RenderFloatingCart(new ModelFloatingCart(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGarageDoor.class, new RenderGarageDoor(new ModelEntityGarageDoor()));

        RenderingRegistry.registerEntityRenderingHandler(EntityBobcatMiner.class, new RendererEntity(new ModelBobcatMiner(), "ModelBobcatMinerHull"));

    }

    private void registerMicroblocks() {
        ConfigRenderers.setRendererMicroBlock(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMicroBlock(), modelMicroBlock));
    }
}
