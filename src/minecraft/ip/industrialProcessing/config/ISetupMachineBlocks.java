package ip.industrialProcessing.config;

import ip.industrialProcessing.decoration.light.BlockElectricLamp;
import ip.industrialProcessing.decoration.light.BlockPetrolLamp;
import ip.industrialProcessing.machines.blastFurnace.BlockBlastFurnace;
import ip.industrialProcessing.machines.classifier.BlockClassifier;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.diskFilter.BlockDiskFilter;
import ip.industrialProcessing.machines.dryer.BlockDryer;
import ip.industrialProcessing.machines.electrolyser.blockElectrolyser;
import ip.industrialProcessing.machines.extruder.BlockExtruder;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.flotationCell.BlockFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.BlockHydroCyclone;
import ip.industrialProcessing.machines.insulator.BlockInsulator;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.oxygenFurnace.BlockOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.BlockPelletExtruder;
import ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit.BlockAlkylationUnit;
import ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower.BlockAsphaltBlower;
import ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor.BlockGasProcessor;
import ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor.BlockIsomerizationReactor;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.BlockSourWaterStripper;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.BlockIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter.BlockTricklingFilter;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation.BlockWaterTreatmentStation;
import ip.industrialProcessing.machines.spoolWindingMachine.BlockSpoolWindingMachine;
import ip.industrialProcessing.machines.thickener.BlockThickener;
import ip.industrialProcessing.machines.treetap.BlockAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.BlockManualTreeTap;
import ip.industrialProcessing.machines.wireMill.BlockWireMill;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.BLmultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.elevator.BLmultiblockElevator;
import ip.industrialProcessing.multiblock.core.block.hotPress.BLmultiblockHotPress;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.CatalyticReformer.BlockCatalyticReformer;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater.BlockAmineTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.BlockAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.clausSulfurPlant.BlockClausSulfurPlant;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker.BlockDelayedCoker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.fluidCatalyticCracker.BlockFluidCatalyticCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker.BlockHydroCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater.BlockHydroTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater.BlockMeroxTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.BlockVacuumDestilationTower;
import ip.industrialProcessing.multiblock.core.block.rollingPress.BLmultiblockRollingPress;
import ip.industrialProcessing.multiblock.core.block.weldingStation.BLmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.blastFurnaceTower.BLmultiblockBlastFurnaceTower;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.BlockDestilationTray;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.BLmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.BLmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.inventory.input.BLmultiblockInvInput;
import ip.industrialProcessing.multiblock.dummy.block.inventory.output.BLmultiblockInvOutput;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.BLmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.BLmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.tankPlating.BlockTankPlating;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.BLmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.BLmultiblockToggleButton2;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.BLmultiblockWeldingTableExt;
import ip.industrialProcessing.multiblock.dummy.block.wheel.BLmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.BLmultiblockWheelConnector;
import ip.industrialProcessing.power.buildcraftGenerator.BlockBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.BlockManualGenerator;
import ip.industrialProcessing.power.meters.BlockAmpMeter;
import ip.industrialProcessing.power.meters.BlockVoltMeter;
import ip.industrialProcessing.power.motor.BlockElectroMotor;
import ip.industrialProcessing.power.plants.BlockBoiler;
import ip.industrialProcessing.power.plants.BlockGenerator;
import ip.industrialProcessing.power.plants.BlockSolidBurner;
import ip.industrialProcessing.power.plants.BlockTurbine;
import ip.industrialProcessing.power.storage.BlockEnergyCell;
import ip.industrialProcessing.power.wire.BlockWire;
import ip.industrialProcessing.power.wire.BlockWireStone;
import ip.industrialProcessing.power.wire.BlockWireWood;
import ip.industrialProcessing.transport.fluids.BlockGrate;
import ip.industrialProcessing.transport.fluids.BlockManoMeter;
import ip.industrialProcessing.transport.fluids.BlockPump;
import ip.industrialProcessing.transport.fluids.BlockRainTank;
import ip.industrialProcessing.transport.fluids.BlockTank;
import ip.industrialProcessing.transport.fluids.BlockTransportFluids;
import ip.industrialProcessing.transport.fluids.BlockTransportFluidsStone;
import ip.industrialProcessing.transport.fluids.BlockTransportFluidsWood;
import ip.industrialProcessing.transport.fluids.BlockValve;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorInput.BlockConveyorInput;
import ip.industrialProcessing.transport.items.conveyorOutput.BlockConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorSorter.BlockConveyorSorter;

public interface ISetupMachineBlocks {

    // machines
    public final static BlockCrusher blockCrusher = new BlockCrusher();
    public final static BlockFilter blockFilter = new BlockFilter();
    public final static BlockMagneticSeparator blockMageneticSeparator = new BlockMagneticSeparator();
    public final static BlockMixer blockMixer = new BlockMixer();
    public final static BlockDryer blockDryer = new BlockDryer();
    public final static BlockClassifier blockClassifier = new BlockClassifier();
    public final static BlockThickener blockThickener = new BlockThickener();
    public final static BlockFlotationCell blockFlotationCell = new BlockFlotationCell();
    public final static BlockHydroCyclone blockHydroCyclone = new BlockHydroCyclone();
    public final static BlockDiskFilter blockDiskFilter = new BlockDiskFilter();
    public final static BlockBlastFurnace blockBlastFurnace = new BlockBlastFurnace();
    public final static BlockExtruder blockExtruder = new BlockExtruder();
    public final static BlockOxygenFurnace blockOxygenFurnace = new BlockOxygenFurnace();
    public final static BlockPelletExtruder blockPelletExtruder = new BlockPelletExtruder();
    public final static BlockIncubator blockIncubator = new BlockIncubator();
    public final static BlockTricklingFilter blockTricklingFilter = new BlockTricklingFilter();
    public final static BlockWaterTreatmentStation blockWaterTreatmentStation = new BlockWaterTreatmentStation();
    public final static BlockWireMill blockWireMill = new BlockWireMill();
    public final static BlockInsulator blockInsulator = new BlockInsulator();
    public final static BlockSpoolWindingMachine blockSpoolWindingMachine = new BlockSpoolWindingMachine();
    public final static blockElectrolyser blockElectrolyser = new blockElectrolyser();
    public final static BlockSourWaterStripper blockSourWaterStripper = new BlockSourWaterStripper();
    public final static BlockAlkylationUnit blockAlkylationUnit = new BlockAlkylationUnit();
    public final static BlockAsphaltBlower blockAsphaltBlower = new BlockAsphaltBlower();
    public final static BlockGasProcessor blockGasProcessor = new BlockGasProcessor();
    public final static BlockIsomerizationReactor blockIsomerizationReactor = new BlockIsomerizationReactor();

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
    public final static BlockAmpMeter blockAmpMeter = new BlockAmpMeter();
    public final static BlockEnergyCell blockEnergyCell = new BlockEnergyCell();
    public final static BlockSolidBurner blockSolidBurner = new BlockSolidBurner();
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
    public final static BLmultiblockWeldingStation BLmultiblockWeldingStation = new BLmultiblockWeldingStation();
    public final static BLmultiblockScreen BLmultiblockScreen = new BLmultiblockScreen();
    public final static BLmultiblockWeldingTableExt BLmultiblockWeldingTableExt = new BLmultiblockWeldingTableExt();
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
    public final static BlockFluidCatalyticCracker blockFluidCatalyticCracker = new  BlockFluidCatalyticCracker();
    public final static BlockHydroCracker blockHydroCracker = new BlockHydroCracker();
    public final static BlockHydroTreater blockHydroTreater = new BlockHydroTreater();
    public final static BlockMeroxTreater blockMeroxTreater = new BlockMeroxTreater();
    public final static BlockVacuumDestilationTower blockVacuumDestilationTower = new BlockVacuumDestilationTower();
    
    
    // transport
    public final static BlockConveyorBelt blockConveyorBelt = new BlockConveyorBelt();
    public final static BlockConveyorInput blockConveyorBeltInput = new BlockConveyorInput();
    public final static BlockConveyorOutput blockConveyorOutput = new BlockConveyorOutput();
    public final static BlockConveyorSorter blockConveyorSorter = new BlockConveyorSorter();

    public final static BlockManualTreeTap blockManualTreetap = new BlockManualTreeTap();
    public final static BlockAutomaticTreeTap blockAutomaticTreetap = new BlockAutomaticTreeTap();
}
