package ip.industrialProcessing.config;

import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
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
import ip.industrialProcessing.multiblock.block.frame.BlockMachineFrame;
import ip.industrialProcessing.multiblock.block.inventory.BlockMultiblockInvInput;
import ip.industrialProcessing.multiblock.block.inventory.BlockMultiblockInvOutput;
import ip.industrialProcessing.multiblock.block.power.BlockMultiblockPowerInput;
import ip.industrialProcessing.multiblock.block.tank.BlockMultiblockTankInput;
import ip.industrialProcessing.multiblock.block.tank.BlockMultiblockTankOutput;
import ip.industrialProcessing.multiblock.block.weldingStation.BlockMultiblockWeldingStationRight;
import ip.industrialProcessing.multiblock.block.weldingStation.BlockMultiblockWeldingStationScreen;
import ip.industrialProcessing.multiblock.core.block.HotPress.BLmultiblockHotPress;
import ip.industrialProcessing.multiblock.dummy.block.BLmultiblockFrame;
import ip.industrialProcessing.multiblock.machine.blastFurnace.BlockMultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.machine.crusher.BlockMultiblockCrusher;
import ip.industrialProcessing.multiblock.machine.mixer.BlockMultiblockMixer;
import ip.industrialProcessing.multiblock.machine.weldingStation.BlockMultiblockWeldingStation;
import ip.industrialProcessing.power.buildcraftGenerator.BlockBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.BlockManualGenerator;
import ip.industrialProcessing.power.meters.BlockAmpMeter;
import ip.industrialProcessing.power.meters.BlockVoltMeter;
import ip.industrialProcessing.power.storage.BlockEnergyCell;
import ip.industrialProcessing.power.wire.BlockWire;
import ip.industrialProcessing.transport.fluids.BlockPump;
import ip.industrialProcessing.transport.fluids.BlockTank;
import ip.industrialProcessing.transport.fluids.BlockTransportFluids;

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

	// create wires
	public final static BlockWire blockWire = new BlockWire();
	public final static BlockVoltMeter blockVoltMeter = new BlockVoltMeter();
	public final static BlockAmpMeter blockAmpMeter = new BlockAmpMeter();
	public final static BlockEnergyCell blockEnergyCell = new BlockEnergyCell();

	// create Multiblock Machines
	public final static BlockMultiblockInvInput blockMultiMachineInput = new BlockMultiblockInvInput();
	public final static BlockMultiblockInvOutput blockMultiMachineOutput = new BlockMultiblockInvOutput();
	public final static BlockMultiblockTankInput blockMultiblockTankInput = new BlockMultiblockTankInput();
	public final static BlockMultiblockTankOutput blockMultiblockTankOutput = new BlockMultiblockTankOutput();
	public final static BlockMachineFrame blockMachineFrame = new BlockMachineFrame();
	public final static BlockMultiblockCrusher blockLargeCrusher = new BlockMultiblockCrusher();
	public final static BlockMultiblockMixer blockMultiblockMixer = new BlockMultiblockMixer();
	public final static BlockMultiblockBlastFurnace blockMultiblockBlastFurnace = new BlockMultiblockBlastFurnace();
	public final static BlockMultiblockWeldingStation blockMultiblockWeldingStation = new BlockMultiblockWeldingStation();
	public final static BlockMultiblockWeldingStationScreen blockMultiblockWeldingStationScreen = new BlockMultiblockWeldingStationScreen();
	public final static BlockMultiblockWeldingStationRight blockMultiblockWeldingStationRight = new BlockMultiblockWeldingStationRight();
	public final static BlockMultiblockPowerInput blockMultiblockPowerInput = new BlockMultiblockPowerInput();
	
	// create fluidpipe
	public final static BlockTransportFluids blockTransportFluids = new BlockTransportFluids();
	public final static BlockPump blockPump = new BlockPump();
	public final static BlockTank blockTank = new BlockTank();
	
	//new multiblocks
	public final static BLmultiblockFrame BLmultiblockFrame = new BLmultiblockFrame();
	public final static BLmultiblockHotPress BLmultiblockHotPress = new BLmultiblockHotPress();
}
