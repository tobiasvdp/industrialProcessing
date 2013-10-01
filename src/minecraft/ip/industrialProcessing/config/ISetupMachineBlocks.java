package ip.industrialProcessing.config;

import ip.industrialProcessing.logic.functions.and.BLlogicAnd;
import ip.industrialProcessing.logic.functions.or.BLlogicOr;
import ip.industrialProcessing.logic.transport.wired.bundle.BLlogicBundle;
import ip.industrialProcessing.logic.transport.wired.cable.BLlogicCable;
import ip.industrialProcessing.logic.transport.wired.displayBox.BLlogicDisplayBox;
import ip.industrialProcessing.logic.transport.wired.switchbox.BLlogicSwitchBox;
import ip.industrialProcessing.machines.blastFurnace.BlockBlastFurnace;
import ip.industrialProcessing.machines.classifier.BlockClassifier;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.diskFilter.BlockDiskFilter;
import ip.industrialProcessing.machines.dryer.BlockDryer;
import ip.industrialProcessing.machines.extruder.BlockExtruder;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.flotationCell.BlockFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.BlockHydroCyclone;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.oxygenFurnace.BlockOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.BlockPelletExtruder;
import ip.industrialProcessing.machines.thickener.BlockThickener;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.BLmultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.elevator.BLmultiblockElevator;
import ip.industrialProcessing.multiblock.core.block.hotPress.BLmultiblockHotPress;
import ip.industrialProcessing.multiblock.core.block.rollingPress.BLmultiblockRollingPress;
import ip.industrialProcessing.multiblock.core.block.weldingStation.BLmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.BLmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.BLmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.inventory.input.BLmultiblockInvInput;
import ip.industrialProcessing.multiblock.dummy.block.inventory.output.BLmultiblockInvOutput;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.BLmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.BLmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.BLmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.BLmultiblockToggleButton2;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.BLmultiblockWeldingTableExt;
import ip.industrialProcessing.multiblock.dummy.block.wheel.BLmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.BLmultiblockWheelConnector;
import ip.industrialProcessing.power.buildcraftGenerator.BlockBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.BlockManualGenerator;
import ip.industrialProcessing.power.meters.BlockAmpMeter;
import ip.industrialProcessing.power.meters.BlockVoltMeter;
import ip.industrialProcessing.power.plants.BlockBoiler;
import ip.industrialProcessing.power.plants.BlockGenerator;
import ip.industrialProcessing.power.plants.BlockSolidBurner;
import ip.industrialProcessing.power.plants.BlockTurbine;
import ip.industrialProcessing.power.storage.BlockEnergyCell;
import ip.industrialProcessing.power.wire.BlockWire;
import ip.industrialProcessing.transport.fluids.BlockManoMeter;
import ip.industrialProcessing.transport.fluids.BlockPump;
import ip.industrialProcessing.transport.fluids.BlockRainTank;
import ip.industrialProcessing.transport.fluids.BlockTank;
import ip.industrialProcessing.transport.fluids.BlockTransportFluids;
import ip.industrialProcessing.transport.fluids.BlockValve;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorInput.BlockConveyorInput;
import ip.industrialProcessing.transport.items.conveyorOutput.BlockConveyorOutput;

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

	// create generators
	public final static BlockManualGenerator blockManualGenerator = new BlockManualGenerator();
	public final static BlockBuildcraftGenerator blockBuildcraftGenerator = new BlockBuildcraftGenerator();
	public final static BlockGenerator blockGenerator = new BlockGenerator();

	// create wires
	public final static BlockWire blockWire = new BlockWire();
	public final static BlockVoltMeter blockVoltMeter = new BlockVoltMeter();
	public final static BlockAmpMeter blockAmpMeter = new BlockAmpMeter();
	public final static BlockEnergyCell blockEnergyCell = new BlockEnergyCell();
	public final static BlockSolidBurner blockSolidBurner = new BlockSolidBurner();
	public final static BlockBoiler blockBoiler = new BlockBoiler();
	public final static BlockTurbine blockTurbine = new BlockTurbine();

	// create fluidpipe
	public final static BlockTransportFluids blockTransportFluids = new BlockTransportFluids();
	public final static BlockPump blockPump = new BlockPump();
	public final static BlockTank blockTank = new BlockTank();
	public final static BlockRainTank blockRainTank = new BlockRainTank();
	public final static BlockManoMeter blockManometer = new BlockManoMeter();
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
	// transport
	public final static BlockConveyorBelt blockConveyorBelt = new BlockConveyorBelt();
	public final static BlockConveyorInput blockConveyorBeltInput = new BlockConveyorInput();
	public final static BlockConveyorOutput blockConveyorOutput = new BlockConveyorOutput();
}
