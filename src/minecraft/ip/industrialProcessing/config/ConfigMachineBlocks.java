package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.blastFurnace.TileEntityBlastFurnace;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.extruder.TileEntityExtruder;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.flotationCell.TileEntityFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.TileEntityHydroCyclone;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.oxygenFurnace.TileEntityOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.core.block.hotPress.TEmultiblockHotPress;
import ip.industrialProcessing.multiblock.core.block.rollingPress.TEmultiblockRollingPress;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.TEmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.TEmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.inventory.input.TEmultiblockInvInput;
import ip.industrialProcessing.multiblock.dummy.block.inventory.output.TEmultiblockInvOutput;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.TEmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.TEmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.TEmultiblockWeldingTableExt;
import ip.industrialProcessing.multiblock.dummy.block.wheel.TEmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.TEmultiblockWheelConnector;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.plants.TileEntityBoiler;
import ip.industrialProcessing.power.plants.TileEntityGenerator;
import ip.industrialProcessing.power.plants.TileEntitySolidBurner;
import ip.industrialProcessing.power.plants.TileEntityTurbine;
import ip.industrialProcessing.power.storage.TileEntityEnergyCell;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.transport.fluids.TileEntityManoMeter;
import ip.industrialProcessing.transport.fluids.TileEntityPump;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import ip.industrialProcessing.transport.items.TEtransportConveyorBelt;
import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigMachineBlocks {

	private ConfigMachineBlocks() {

	}

	private static ConfigMachineBlocks instance = new ConfigMachineBlocks();
	private int crusherBlockID = 500;
	private int filterBlockId = 501;
	private int magneticSeparatorBlockID = 502;
	private int mixerBlockID = 503;
	private int dryerBlockID = 504;
	private int classifierBlockID = 505;
	private int thickenerBlockID = 506;
	private int flotationCellBlockID = 507;
	private int hydroCycloneBlockID = 508;
	private int diskFilterBlockID = 509;

	private int blastFurnaceID = 550;
	private int extruderID = 551;
	private int oxygenFurnaceID = 552;
	private int pelletExtruderID = 553;

	private int manualGeneratorBlockID = 800; // Crank Generator
	private int buildcraftGeneratorBlockID = 801; // Buildcraft Joule converter
	private int solidBurnerBlockID = 802;
	private int boilerBlockID = 803;
	private int steamTurbineBlockID = 804;
	private int generatorBlockID = 805;

	private int wireBlockID = 900;
	private int voltMeterBlockID = 901;
	private int ampMeterBlockID = 902;
	private int EnergyCellBlockID = 903;

	// new multiblocks
	private int BLmultiblockFrame = 720;
	private int BLmultiblockHotPress = 721;
	private int BLmultiblockWeldingStation = 722;
	private int BLmultiblockScreen = 723;
	private int BLmultiblockWeldingStationExt = 724;
	private int BLmultiblockInvInput = 725;
	private int BLmultiblockInvOutput = 726;
	private int BLmultiblockToggleButton = 727;
	private int BLmultiblockElevator = 728;
	private int BLmultiblockToggleButton2 = 729;
	private int BLmultiblockLiftDoor = 730;
	private int BLmultiblockWheel = 731;
	private int BLmultiblockRollingPress = 732;
	private int BLmultiblockWheelConnector = 733;
	private int BLmultiblockDisplayPanel = 734;
	
	private int BLtransportConveyorBelt = 735;

	public void registerMachineBlocks() {
		
		registerMachineBlock(IndustrialProcessing.BLtransportConveyorBelt, "IP.Trans.CBelt", "Conveyor belt", TEtransportConveyorBelt.class);
		
		// multiblocks
		registerMachineBlock(IndustrialProcessing.BLmultiblockDisplayPanel, "IP.MBD.Display", "Display panel", TEmultiblockDisplayPanel.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockWheelConnector, "IP.MBD.WheelCon", "Wheel connector", TEmultiblockWheelConnector.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockLiftDoor, "IP.MBD.LiftDoor", "Lift door", TEmultiblockLiftDoor.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockElevator, "IP.MBC.Elevator", "Elevator", TEmultiblockElevator.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockToggleButton, "IP.MBD.Toggle", "Control panel", TEmultiblockToggleButton.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockToggleButton2, "IP.MBD.Toggle2", "Lift call button", TEmultiblockToggleButton.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockInvInput, "IP.MBD.InvInput", "Item input", TEmultiblockInvInput.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockInvOutput, "IP.MBD.InvOutput", "Item output", TEmultiblockInvOutput.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockScreen, "IP.MBD.Screen", "Screen", TEmultiblockScreen.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockFrame, "IP.MBD.Frame", "Frame", TEmultiblockFrame.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockHotPress, "IP.MBC.HotPress", "Hot press", TEmultiblockHotPress.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockWeldingStation, "IP.MBC.WeldingStation", "Welding station", TEmultiblockWeldingStation.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockWeldingTableExt, "IP.MBD.WeldingTableExt", "Welding station extention", TEmultiblockWeldingTableExt.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockWheel, "IP.MBD.Wheel", "Rolling wheel", TEmultiblockWheel.class);
		registerMachineBlock(IndustrialProcessing.BLmultiblockRollingPress, "IP.MBC.RollingPress", "Rolling press", TEmultiblockRollingPress.class);

		// register entitys associated with multiblocks

		// machines
		registerMachineBlock(IndustrialProcessing.blockCrusher, "IP.Machine.Crusher", "Ore Crusher", TileEntityCrusher.class);
		registerMachineBlock(IndustrialProcessing.blockFilter, "IP.Machine.Filter", "Ore Filter", TileEntityFilter.class);
		registerMachineBlock(IndustrialProcessing.blockMageneticSeparator, "IP.Machine.Separator", "Magnetic Separator", TileEntityMagneticSeparator.class);
		registerMachineBlock(IndustrialProcessing.blockMixer, "IP.Machine.Mixer", "Mixer", TileEntityMixer.class);
		registerMachineBlock(IndustrialProcessing.blockDryer, "IP.Machine.Dryer", "Dryer", TileEntityDryer.class);
		registerMachineBlock(IndustrialProcessing.blockClassifier, "IP.Machine.Classifier", "Classifier", TileEntityClassifier.class);
		registerMachineBlock(IndustrialProcessing.blockThickener, "IP.Machine.Thickener", "Thickener", TileEntityThickener.class);
		registerMachineBlock(IndustrialProcessing.blockFlotationCell, "IP.Machine.FlotationCell", "Flotation Cell", TileEntityFlotationCell.class);
		registerMachineBlock(IndustrialProcessing.blockHydroCyclone, "IP.Machine.HydroCyclone", "Hydro Cyclone Separator", TileEntityHydroCyclone.class);
		registerMachineBlock(IndustrialProcessing.blockDiskFilter, "IP.Machine.DiskFilter", "Disk Filter", TileEntityDiskFilter.class);
		registerMachineBlock(IndustrialProcessing.blockBlastFurnace, "IP.Machine.BlastFurnace", "Blast Furnace", TileEntityBlastFurnace.class);
		registerMachineBlock(IndustrialProcessing.blockExtruder, "IP.Machine.Extruder", "Extruder", TileEntityExtruder.class);
		registerMachineBlock(IndustrialProcessing.blockOxygenFurnace, "IP.Machine.OxygenFurnace", "Oxygen Furnace", TileEntityOxygenFurnace.class);
		registerMachineBlock(IndustrialProcessing.blockPelletExtruder, "IP.Machine.PelletExtruder", "Pellet Extruder", TileEntityPelletExtruder.class);

		registerMachineBlock(IndustrialProcessing.blockManualGenerator, "IP.Generator.Manual", "Crank Generator", TileEntityManualGenerator.class);
		registerMachineBlock(IndustrialProcessing.blockBuildcraftGenerator, "IP.Generator.Buildcraft", "Buildcraft Generator", TileEntityBuildcraftGenerator.class);
		registerMachineBlock(IndustrialProcessing.blockGenerator, "IP.Generator", "Generator", TileEntityGenerator.class);

		// transport
		registerMachineBlock(IndustrialProcessing.blockTransportFluids, "IP.Transport.Fluids", "Fluid pipe", TileEntityTransportFluids.class);
		registerMachineBlock(IndustrialProcessing.blockPump, "IP.Transport.Fluids.Pump", "Fluid pump", TileEntityPump.class);
		registerMachineBlock(IndustrialProcessing.blockTank, "IP.Transport.Fluids.Tank", "Fluid Tank", TileEntityTank.class);
		registerMachineBlock(IndustrialProcessing.blockManometer, "IP.Transport.Fluids.Manometer", "Manometer", TileEntityManoMeter.class);

		// power
		registerMachineBlock(IndustrialProcessing.blockWire, "IP.Wire", "Wire", TileEntityWire.class);
		registerMachineBlock(IndustrialProcessing.blockVoltMeter, "IP.Meter.Volt", "Volt Meter", TileEntityVoltMeter.class);
		registerMachineBlock(IndustrialProcessing.blockAmpMeter, "IP.Meter.Amp", "Amp Meter", TileEntityAmpMeter.class);
		registerMachineBlock(IndustrialProcessing.blockEnergyCell, "IP.EnergyCell", "Battery Box", TileEntityEnergyCell.class);
		registerMachineBlock(IndustrialProcessing.blockSolidBurner, "IP.SolidBurner", "Solid Burner", TileEntitySolidBurner.class);
		registerMachineBlock(IndustrialProcessing.blockBoiler, "IP.Boiler", "Boiler", TileEntityBoiler.class);
		registerMachineBlock(IndustrialProcessing.blockTurbine, "IP.Turbine", "Turbine", TileEntityTurbine.class);
	}

	private void registerMachineBlock(Block block, String uniqueId, String displayName, Class tileEntity) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		ModLoader.registerTileEntity(tileEntity, uniqueId);
	}

	public static ConfigMachineBlocks getInstance() {
		return instance;
	}

	public static int getBLtransportConveyorBelt() {
		return getInstance().BLtransportConveyorBelt;
	}
	public static int getBLmultiblockDisplayPanel() {
		return getInstance().BLmultiblockDisplayPanel;
	}

	public static int getBLmultiblockWheelConnector() {
		return getInstance().BLmultiblockWheelConnector;
	}

	public static int getBLmultiblockRollingPress() {
		return getInstance().BLmultiblockRollingPress;
	}

	public static int getBLmultiblockWheel() {
		return getInstance().BLmultiblockWheel;
	}

	public static int getBLmultiblockLiftDoor() {
		return getInstance().BLmultiblockLiftDoor;
	}

	public static int getBLmultiblockElevator() {
		return getInstance().BLmultiblockElevator;
	}

	public static int getBLmultiblockToggleButton2() {
		return getInstance().BLmultiblockToggleButton2;
	}

	public static int getBLmultiblockToggleButton() {
		return getInstance().BLmultiblockToggleButton;
	}

	public static int getBLmultiblockInvInput() {
		return getInstance().BLmultiblockInvInput;
	}

	public static int getBLmultiblockInvOutput() {
		return getInstance().BLmultiblockInvOutput;
	}

	public static int getBLmultiblockWeldingStationExt() {
		return getInstance().BLmultiblockWeldingStationExt;
	}

	public static int getBLmultiblockScreen() {
		return getInstance().BLmultiblockScreen;
	}

	public static int getBLmultiblockWeldingStation() {
		return getInstance().BLmultiblockWeldingStation;
	}

	public static int getBLmultiblockHotPress() {
		return getInstance().BLmultiblockHotPress;
	}

	public static int getBLmultiblockFrame() {
		return getInstance().BLmultiblockFrame;
	}

	public static int getFilterBlockID() {
		return getInstance().filterBlockId;
	}

	public static int getCrusherBlockID() {
		return getInstance().crusherBlockID;
	}

	public static int getMagneticSeparatorBlockID() {

		return getInstance().magneticSeparatorBlockID;
	}

	public static int getMixerBlockID() {
		return getInstance().mixerBlockID;
	}

	public static int getDryerBlockID() {
		return getInstance().dryerBlockID;
	}

	public static int getClassifierBlockID() {
		return getInstance().classifierBlockID;
	}

	public static int getThickenerBlockID() {
		return getInstance().thickenerBlockID;
	}

	public static int getFlotationCellBlockID() {
		return getInstance().flotationCellBlockID;
	}

	public static int getHydroCycloneBlockID() {
		return getInstance().hydroCycloneBlockID;
	}

	public static int getDiskFilterBlockID() {
		return getInstance().diskFilterBlockID;
	}

	public static int getManualGeneratorBlockID() {
		return getInstance().manualGeneratorBlockID;
	}

	public static int getBuildcraftGeneratorBlockID() {
		return getInstance().buildcraftGeneratorBlockID;
	}

	public static int getWireBlockID() {
		return getInstance().wireBlockID;
	}

	public static int getVoltMeterBlockID() {
		return getInstance().voltMeterBlockID;
	}

	public static int getAmpMeterBlockID() {
		return getInstance().ampMeterBlockID;
	}

	public static int getEnergyCellBlockID() {
		return getInstance().EnergyCellBlockID;
	}

	public static int getPelletExtruderID() {
		return getInstance().pelletExtruderID;
	}

	public static int getExtruderID() {
		return getInstance().extruderID;
	}

	public static int getBlastFurnaceID() {
		return getInstance().blastFurnaceID;
	}

	public static int getOxygenFurnaceID() {
		return getInstance().oxygenFurnaceID;
	}

	public static int getSolidBurnerBlockID() {
		return getInstance().solidBurnerBlockID;
	}

	public static int getBoilerBlockID() {
		return getInstance().boilerBlockID;
	}

	public static int getSteamTurbineBlockID() {
		return getInstance().steamTurbineBlockID;
	}

	public static int getGeneratorBlockID() {
		return getInstance().generatorBlockID;
	}
}
