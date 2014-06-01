package mod.industrialProcessing.blockContainer;

import mod.industrialProcessing.blockContainer.multiblock.core.block.plants.storage.container.BlockContainer;
import mod.industrialProcessing.blockContainer.multiblock.dummy.block.containerWall.BlockContainerWall;
import mod.industrialProcessing.plants.decoration.light.hangingLamp.BlockPetrolLamp;
import mod.industrialProcessing.plants.decoration.light.torch.BlockTorch;
import mod.industrialProcessing.plants.machine.crusher.BlockCrusher;
import mod.industrialProcessing.plants.machine.filter.BlockFilter;
import mod.industrialProcessing.plants.machine.mixer.BlockMixer;
import mod.industrialProcessing.plants.power.generator.crankGenerator.BlockManualGenerator;
import mod.industrialProcessing.plants.power.generator.creative.BlockCreativeGenerator;
import mod.industrialProcessing.plants.power.meter.BlockVoltMeter;
import mod.industrialProcessing.plants.power.motor.electroMotor.BlockElectroMotor;
import mod.industrialProcessing.plants.power.storage.BlockEnergyCell;
import mod.industrialProcessing.plants.power.wire.BlockWire;
import mod.industrialProcessing.plants.transport.fluids.grate.BlockGrate;
import mod.industrialProcessing.plants.transport.fluids.manoMeter.BlockManoMeter;
import mod.industrialProcessing.plants.transport.fluids.pump.BlockPump;
import mod.industrialProcessing.plants.transport.fluids.rainTank.BlockRainTank;
import mod.industrialProcessing.plants.transport.fluids.tank.BlockTank;
import mod.industrialProcessing.plants.transport.fluids.valve.BlockValve;
import mod.industrialProcessing.plants.transport.items.ConveyorBeltPowerInput.BlockConveyorBeltPowerInput;
import mod.industrialProcessing.plants.transport.items.conveyorBelt.BlockConveyorBelt;
import mod.industrialProcessing.plants.transport.items.conveyorChute.BlockConveyorChute;
import mod.industrialProcessing.plants.transport.items.conveyorInput.BlockConveyorInput;
import mod.industrialProcessing.plants.transport.items.conveyorOutput.BlockConveyorOutput;
import mod.industrialProcessing.transport.fluids.block.BlockTransportFluids;
import mod.industrialProcessing.transport.fluids.block.BlockTransportFluidsStone;
import mod.industrialProcessing.transport.fluids.block.BlockTransportFluidsWood;

public interface ISetupBlockContainers {

    
    public final static BlockCrusher blockCrusher = new BlockCrusher();
    public final static BlockFilter blockFilter = new BlockFilter();
    public final static BlockMixer blockMixer = new BlockMixer();
    
    public final static BlockManualGenerator blockManualGenerator = new BlockManualGenerator();
    public final static BlockWire blockWire = new BlockWire();
    public final static BlockElectroMotor blockElectroMotor = new BlockElectroMotor();
    public final static BlockVoltMeter blockVoltMeter = new BlockVoltMeter();
    public final static BlockEnergyCell blockEnergyCell = new BlockEnergyCell();
    public final static BlockTorch blockTorch = new BlockTorch();
    public final static BlockPetrolLamp blockPetrolLamp = new BlockPetrolLamp();
    
    public final static BlockConveyorBelt  blockConveyorBelt = new BlockConveyorBelt();
    public final static BlockConveyorBeltPowerInput  blockConveyorBeltPowerInput = new BlockConveyorBeltPowerInput();
    public final static BlockConveyorChute  blockConveyorChute = new BlockConveyorChute();
    public final static BlockConveyorInput  blockConveyorInput = new BlockConveyorInput();
    public final static BlockConveyorOutput  blockConveyorOutput = new BlockConveyorOutput();
    
    public final static BlockCreativeGenerator  blockCreativeGenerator = new BlockCreativeGenerator();
    
    public final static BlockGrate  blockGrate = new BlockGrate();
    public final static BlockManoMeter  blockManoMeter = new BlockManoMeter();
    public final static BlockPump  blockPump = new BlockPump();
    public final static BlockRainTank  blockRainTank = new BlockRainTank();
    public final static BlockTank  blockTank = new BlockTank();
    public final static BlockTransportFluids  blockTransportFluids = new BlockTransportFluids();
    public final static BlockTransportFluidsStone  blockTransportFluidsStone = new BlockTransportFluidsStone();
    public final static BlockTransportFluidsWood  blockTransportFluidsWood = new BlockTransportFluidsWood();
    public final static BlockValve  blockValve = new BlockValve();
    
    public final static BlockContainer  blockContainer = new BlockContainer();
    public final static BlockContainerWall  blockContainerWall = new BlockContainerWall();
    
    /* machines
    public final static BlockFilter blockFilter = new BlockFilter();
    public final static BlockMagneticSeparator blockMageneticSeparator = new BlockMagneticSeparator();
    public final static BlockMixer blockMixer = new BlockMixer();
    public final static BlockDryer blockDryer = new BlockDryer();
    public final static BlockClassifier blockClassifier = new BlockClassifier();
    public final static BlockThickener blockThickener = new BlockThickener();
    public final static BlockFlotationCell blockFlotationCell = new BlockFlotationCell();
    public final static BlockHydroCyclone blockHydroCyclone = new BlockHydroCyclone();
    public final static BlockDiskFilter blockDiskFilter = new BlockDiskFilter();
    public final static BlockExtruder blockExtruder = new BlockExtruder();
    public final static BlockOxygenFurnace blockOxygenFurnace = new BlockOxygenFurnace();
    public final static BlockPelletExtruder blockPelletExtruder = new BlockPelletExtruder();
    public final static BlockIncubator blockIncubator = new BlockIncubator();
    public final static BlockTricklingFilter blockTricklingFilter = new BlockTricklingFilter();
    public final static BlockWaterTreatmentStation blockWaterTreatmentStation = new BlockWaterTreatmentStation();
    public final static BlockWireMill blockWireMill = new BlockWireMill();
    public final static BlockInsulator blockInsulator = new BlockInsulator();
    public final static BlockSpoolWindingMachine blockSpoolWindingMachine = new BlockSpoolWindingMachine();
    public final static BlockElectrolyser blockElectrolyser = new BlockElectrolyser();
    public final static BlockSourWaterStripper blockSourWaterStripper = new BlockSourWaterStripper();
    public final static BlockAlkylationUnit blockAlkylationUnit = new BlockAlkylationUnit();
    public final static BlockAsphaltBlower blockAsphaltBlower = new BlockAsphaltBlower();
    public final static BlockGasProcessor blockGasProcessor = new BlockGasProcessor();
    public final static BlockIsomerizationReactor blockIsomerizationReactor = new BlockIsomerizationReactor();
    public final static BlockSinter blockSinter = new BlockSinter();
    public final static BlockKiln blockKiln = new BlockKiln();
    public final static BlockSandCaster blockSandCaster = new BlockSandCaster();
    public final static BlockTurretLathe blockTurretLathe = new BlockTurretLathe();
    public final static BlockVacuumCaster blockVacuumCaster = new BlockVacuumCaster();
    public final static BlockCoolingUnit blockCoolingUnit = new BlockCoolingUnit();
    public final static BlockQuenchTank blockQuenchTank = new BlockQuenchTank();
    public final static BlockRoaster blockRoaster = new BlockRoaster();
    public final static BlockSmelter blockSmelter = new BlockSmelter();
    public final static BlockGrindingStone blockGrindingStone = new BlockGrindingStone();
    public final static BlockAnvil blockAnvil = new BlockAnvil();
    public final static BlockGarageDoor blockGarageDoor = new BlockGarageDoor();
    public final static BlockGarageDoorFrame blockGarageDoorFrame = new BlockGarageDoorFrame();
    public final static BlockGarageDoorDoor blockGarageDoorDoor = new BlockGarageDoorDoor();
    public final static BlockControlBox blockControlBox = new BlockControlBox();
    public final static BlockStorageRack blockStorageRack = new BlockStorageRack();
    public final static BlockStorageBox blockStorageBox = new BlockStorageBox();
    public final static BlockIronPole blockIronPole = new BlockIronPole();
    public final static BlockTorch blockTorch = new BlockTorch();

    // create generators
    public final static BlockManualGenerator blockManualGenerator = new BlockManualGenerator();
    public final static BlockBuildcraftGenerator blockBuildcraftGenerator = new BlockBuildcraftGenerator();
    public final static BlockGenerator blockGenerator = new BlockGenerator();
    public final static BlockPetrolLamp blockPetrolLamp = new BlockPetrolLamp();
    public final static BlockElectricLamp blockElectricLamp = new BlockElectricLamp();
    public final static BlockElectroMotor blockElectroMotor = new BlockElectroMotor();

    // create wires
    public final static BlockWire blockWire = new BlockWire();
    public final static BlockWireWood blockWireWood = new BlockWireWood();
    public final static BlockWireStone blockWireStone = new BlockWireStone();
    public final static BlockVoltMeter blockVoltMeter = new BlockVoltMeter();
    public final static BlockEnergyCell blockEnergyCell = new BlockEnergyCell();
    public final static BlockSolidBurner blockSolidBurner = new BlockSolidBurner();
    public final static BlockFuelBurner blockFuelBurner = new BlockFuelBurner();
    public final static BlockElectricHeater blockElectricHeater = new BlockElectricHeater();
    public final static BlockBoiler blockBoiler = new BlockBoiler();
    public final static BlockTurbine blockTurbine = new BlockTurbine();

    // create fluidpipe
    public final static BlockTransportFluids blockTransportFluids = new BlockTransportFluids();
    public final static BlockTransportFluidsWood blockTransportFluidsWood = new BlockTransportFluidsWood();
    public final static BlockTransportFluidsStone blockTransportFluidsStone = new BlockTransportFluidsStone();
    public final static BlockPump blockPump = new BlockPump();
    public final static BlockTank blockTank = new BlockTank();
    public final static BlockRainTank blockRainTank = new BlockRainTank();
    public final static BlockManoMeter blockManometer = new BlockManoMeter();
    public final static BlockGrate blockGrate = new BlockGrate();
    public final static BlockValve blockValve = new BlockValve();

    // multiblocks
    public final static BLmultiblockFrame BLmultiblockFrame = new BLmultiblockFrame();
    public final static BLmultiblockHotPress BLmultiblockHotPress = new BLmultiblockHotPress();
    public final static BlockMultiblockWeldingStation BLmultiblockWeldingStation = new BlockMultiblockWeldingStation();
    public final static BlockScreen BLmultiblockScreen = new BlockScreen();
    public final static BlockMultiblockWeldingTable BLmultiblockWeldingTableExt = new BlockMultiblockWeldingTable();
    public final static BLmultiblockInvInput BLmultiblockInvInput = new BLmultiblockInvInput();
    public final static BLmultiblockInvOutput BLmultiblockInvOutput = new BLmultiblockInvOutput();
    public final static BLmultiblockToggleButton BLmultiblockToggleButton = new BLmultiblockToggleButton();
    public final static BLmultiblockToggleButton2 BLmultiblockToggleButton2 = new BLmultiblockToggleButton2();
    public final static BLmultiblockElevator BLmultiblockElevator = new BLmultiblockElevator();
    public final static BLmultiblockLiftDoor BLmultiblockLiftDoor = new BLmultiblockLiftDoor();
    public final static BLmultiblockWheel BLmultiblockWheel = new BLmultiblockWheel();
    public final static BLmultiblockRollingPress BLmultiblockRollingPress = new BLmultiblockRollingPress();
    public final static BLmultiblockWheelConnector BLmultiblockWheelConnector = new BLmultiblockWheelConnector();
    public final static BLmultiblockDisplayPanel BLmultiblockDisplayPanel = new BLmultiblockDisplayPanel();
    public final static BLmultiblockBlastFurnace BLmultiblockBlastFurnace = new BLmultiblockBlastFurnace();
    public final static BLmultiblockBlastFurnaceTower BLmultiblockBlastFurnaceTower = new BLmultiblockBlastFurnaceTower();
    public final static BlockAtmosphericDestilationTower blockAtmosphericDestilationTower = new BlockAtmosphericDestilationTower();
    public final static BlockTankPlating blockTankPlating = new BlockTankPlating();
    public final static BlockDestilationTray blockDestilationTray = new BlockDestilationTray();
    public final static BlockAmineTreater blockAmineTreater = new BlockAmineTreater();
    public final static BlockCatalyticReformer blockCatalyticReformer = new BlockCatalyticReformer();
    public final static BlockClausSulfurPlant blockClausSulfurPlant = new BlockClausSulfurPlant();
    public final static BlockDelayedCoker blockDelayedCoker = new BlockDelayedCoker();
    public final static BlockFluidCatalyticCracker blockFluidCatalyticCracker = new BlockFluidCatalyticCracker();
    public final static BlockHydroCracker blockHydroCracker = new BlockHydroCracker();
    public final static BlockHydroTreater blockHydroTreater = new BlockHydroTreater();
    public final static BlockMeroxTreater blockMeroxTreater = new BlockMeroxTreater();
    public final static BlockVacuumDestilationTower blockVacuumDestilationTower = new BlockVacuumDestilationTower();
    public final static BlockContainer blockContainer = new BlockContainer();
    public final static BlockContainerWall blockContainerWall = new BlockContainerWall();
    public final static BlockSolderingStation blockSolderingStation = new BlockSolderingStation();

    // transport
    public final static BlockConveyorBelt blockConveyorBelt = new BlockConveyorBelt();
    public final static BlockConveyorInput blockConveyorBeltInput = new BlockConveyorInput();
    public final static BlockConveyorOutput blockConveyorOutput = new BlockConveyorOutput();
    public final static BlockConveyorSorter blockConveyorSorter = new BlockConveyorSorter();
    public final static BlockConveyorChute blockConveyorChute = new BlockConveyorChute();
    public final static BlockConveyorBeltPowerInput blockConveyorBeltPowerInput = new BlockConveyorBeltPowerInput();
    public final static BlockConveyorPacker blockConveyorPacker = new BlockConveyorPacker();

    public final static BlockManualTreeTap blockManualTreetap = new BlockManualTreeTap();
    public final static BlockAutomaticTreeTap blockAutomaticTreetap = new BlockAutomaticTreeTap();
    */
}
