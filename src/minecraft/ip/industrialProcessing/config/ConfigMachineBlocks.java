package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.decoration.light.TileEntityElectricLamp;
import ip.industrialProcessing.decoration.light.TileEntityPetrolLamp;
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
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.TileEntityIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter.TileEntityTricklingFilter;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation.TileEntityWaterTreatmentStation;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.machines.treetap.TileEntityAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.TileEntityManualTreeTap;
import ip.industrialProcessing.machines.wireMill.TileEntityWireMill;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.TEmultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.core.block.hotPress.TEmultiblockHotPress;
import ip.industrialProcessing.multiblock.core.block.rollingPress.TEmultiblockRollingPress;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.blastFurnaceTower.TEmultiblockBlastFurnaceTower;
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
import ip.industrialProcessing.transport.fluids.TileEntityGrate;
import ip.industrialProcessing.transport.fluids.TileEntityManoMeter;
import ip.industrialProcessing.transport.fluids.TileEntityPump;
import ip.industrialProcessing.transport.fluids.TileEntityRainTank;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import ip.industrialProcessing.transport.fluids.TileEntityValve;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorInput.TileEntityConveyorInput;
import ip.industrialProcessing.transport.items.conveyorOutput.TileEntityConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorSorter.TileEntityConveyorSorter;
import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigMachineBlocks {

    private ConfigMachineBlocks() {

    }

    private static ConfigMachineBlocks instance = new ConfigMachineBlocks();
    private int crusherBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "CrusherID", 500).getInt();
    private int filterBlockId = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "FilterID", 501).getInt();
    private int magneticSeparatorBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "MagneticSeparatorID", 502).getInt();
    private int mixerBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "MixerID", 503).getInt();
    private int dryerBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "DryerID", 504).getInt();
    private int classifierBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "ClassifierID", 505).getInt();
    private int thickenerBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "ThickenerID", 506).getInt();
    private int flotationCellBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "FlotationCellID", 507).getInt();
    private int hydroCycloneBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "HydroCycloneID", 508).getInt();
    private int diskFilterBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "DiskFilterID", 509).getInt();

    private int blastFurnaceID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "BlastFurnaceID", 550).getInt();
    private int extruderID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "ExtruderID", 551).getInt();
    private int oxygenFurnaceID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "OxygenFurnaceID", 552).getInt();
    private int pelletExtruderID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "PelletExtruderID", 553).getInt();
    private int incubatorID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "incubatorID", 554).getInt();
    private int tricklingFilterID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "tricklingFilterID", 555).getInt();
    private int waterTreatmentStationID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "waterTreatmentStationID", 556).getInt();
    private int wireMillBlockID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "wireMillBlockID", 557).getInt();

    private int manualGeneratorBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "ManualGeneratorID", 800).getInt();
    private int buildcraftGeneratorBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "BCGeneratorID", 801).getInt();
    private int solidBurnerBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "SolidBurnerID", 802).getInt();
    private int boilerBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "BoilerID", 803).getInt();
    private int steamTurbineBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "SteamTurbineID", 804).getInt();
    private int generatorBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "GeneratorID", 805).getInt();
    private int petrolLampBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "PetrolLampID", 806).getInt();
    private int electricLampBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "ElectricLampID", 807).getInt();

    private int wireBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "WireID", 900).getInt();
    private int voltMeterBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "VoltMeterID", 901).getInt();
    private int ampMeterBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "AmpMeterID", 902).getInt();
    private int EnergyCellBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "EnergyCellID", 903).getInt();

    private int manualTreeTapID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ManualTreeTapId", 904).getInt();
    private int automaticTreeTapID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "AutomaticTreeTapId", 905).getInt();
    // new multiblocks
    private int BLmultiblockFrame = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "FrameID", 720).getInt();
    private int BLmultiblockHotPress = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "HotPressID", 721).getInt();
    private int BLmultiblockWeldingStation = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "WeldingStationID", 722).getInt();
    private int BLmultiblockScreen = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "ScreenID", 723).getInt();
    private int BLmultiblockWeldingStationExt = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "WeldingStationExtID", 724).getInt();
    private int BLmultiblockInvInput = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "InvInputID", 725).getInt();
    private int BLmultiblockInvOutput = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "InvOutputID", 726).getInt();
    private int BLmultiblockToggleButton = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "ToggleButtonID", 727).getInt();
    private int BLmultiblockElevator = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "ElevatorID", 728).getInt();
    private int BLmultiblockToggleButton2 = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "ToggleButton2ID", 729).getInt();
    private int BLmultiblockLiftDoor = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "LiftDoorID", 730).getInt();
    private int BLmultiblockWheel = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "WheelID", 731).getInt();
    private int BLmultiblockRollingPress = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "RollingPressID", 732).getInt();
    private int BLmultiblockWheelConnector = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "WheelConnectorID", 733).getInt();
    private int BLmultiblockDisplayPanel = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "DisplayPanelID", 734).getInt();
    private int BLmultiblockBlastFurnace = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "BLmultiblockBlastFurnace", 750).getInt();
    private int BLmultiblockBlastFurnaceTower = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "BLmultiblockBlastFurnaceTower", 751).getInt();

    private int BLtransportConveyorBelt = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltID", 735).getInt();
    private int BLtransportConveyorBeltInput = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltInputID", 736).getInt();
    private int BLtransportConveyorBeltOutput = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltOutputID", 737).getInt();
    private int BLtransportConveyorBeltSorter = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltSorterID", 744).getInt();

    public void registerMachineBlocks() {

        registerMachineBlock(IndustrialProcessing.blockConveyorBelt, "IP.Trans.CBelt", "Conveyor belt", TileEntityConveyorBelt.class);
        registerMachineBlock(IndustrialProcessing.blockConveyorBeltInput, "IP.Trans.CBInput", "Conveyor belt import", TileEntityConveyorInput.class);
        registerMachineBlock(IndustrialProcessing.blockConveyorOutput, "IP.Trans.CBOutput", "Conveyor belt export", TileEntityConveyorOutput.class);
        registerMachineBlock(IndustrialProcessing.blockConveyorSorter, "IP.Trans.CBSorter", "Conveyor belt sorter", TileEntityConveyorSorter.class);

        // multiblocks
        registerMachineBlock(IndustrialProcessing.BLmultiblockBlastFurnaceTower, "IP.MBD.BlastTow", "Blast furnace tower", TEmultiblockBlastFurnaceTower.class);
        registerMachineBlock(IndustrialProcessing.BLmultiblockBlastFurnace, "IP.MBC.BlastFur", "Blast furnace", TEmultiblockBlastFurnace.class);
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
        registerMachineBlock(IndustrialProcessing.BLmultiblockWeldingTableExt, "IP.MBD.WeldingTableExt", "Welding table", TEmultiblockWeldingTableExt.class);
        registerMachineBlock(IndustrialProcessing.BLmultiblockWheel, "IP.MBD.Wheel", "Rolling wheel", TEmultiblockWheel.class);
        registerMachineBlock(IndustrialProcessing.BLmultiblockRollingPress, "IP.MBC.RollingPress", "Rolling press", TEmultiblockRollingPress.class);

        // register entitys associated with multiblocks

        // machines
        registerMachineBlock(IndustrialProcessing.blockIncubator, "IP.Machine.Incubator", "Incubator", TileEntityIncubator.class);
        registerMachineBlock(IndustrialProcessing.blockTricklingFilter, "IP.Machine.Trickler", "Trickling Filter", TileEntityTricklingFilter.class);
        registerMachineBlock(IndustrialProcessing.blockWaterTreatmentStation, "IP.Machine.Treatment", "Water treatment station", TileEntityWaterTreatmentStation.class);

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
        registerMachineBlock(IndustrialProcessing.blockWireMill, "IP.Machine.WireMill", "Wire mill", TileEntityWireMill.class);

        registerMachineBlock(IndustrialProcessing.blockManualGenerator, "IP.Generator.Manual", "Crank Generator", TileEntityManualGenerator.class);
        registerMachineBlock(IndustrialProcessing.blockBuildcraftGenerator, "IP.Generator.Buildcraft", "Buildcraft Generator", TileEntityBuildcraftGenerator.class);
        registerMachineBlock(IndustrialProcessing.blockGenerator, "IP.Generator", "Generator", TileEntityGenerator.class);
        registerMachineBlock(IndustrialProcessing.blockPetrolLamp, "IP.Lamp.Petrol", "Petrol Lamp", TileEntityPetrolLamp.class);
        registerMachineBlock(IndustrialProcessing.blockElectricLamp, "IP.Lamp.Electric", "Electric Lamp", TileEntityElectricLamp.class);

        // transport
        registerMachineBlock(IndustrialProcessing.blockTransportFluids, "IP.Transport.Fluids", "Fluid pipe", TileEntityTransportFluids.class);
        registerMachineBlock(IndustrialProcessing.blockPump, "IP.Transport.Fluids.Pump", "Fluid pump", TileEntityPump.class);
        registerMachineBlock(IndustrialProcessing.blockTank, "IP.Transport.Fluids.Tank", "Fluid Tank", TileEntityTank.class);
        registerMachineBlock(IndustrialProcessing.blockManometer, "IP.Transport.Fluids.Manometer", "Manometer", TileEntityManoMeter.class);
        registerMachineBlock(IndustrialProcessing.blockGrate, "IP.Transport.Fluids.Grate", "Grate", TileEntityGrate.class);
        registerMachineBlock(IndustrialProcessing.blockRainTank, "IP.Transport.Fluids.RainTank", "Rain Collector", TileEntityRainTank.class);
        registerMachineBlock(IndustrialProcessing.blockValve, "IP.Transport.Fluids.Valve", "Valve", TileEntityValve.class);

        // power
        registerMachineBlock(IndustrialProcessing.blockWire, "IP.Wire", "Wire", TileEntityWire.class);
        registerMachineBlock(IndustrialProcessing.blockVoltMeter, "IP.Meter.Volt", "Volt Meter", TileEntityVoltMeter.class);
        registerMachineBlock(IndustrialProcessing.blockAmpMeter, "IP.Meter.Amp", "Amp Meter", TileEntityAmpMeter.class);
        registerMachineBlock(IndustrialProcessing.blockEnergyCell, "IP.EnergyCell", "Battery Box", TileEntityEnergyCell.class);
        registerMachineBlock(IndustrialProcessing.blockSolidBurner, "IP.SolidBurner", "Solid Burner", TileEntitySolidBurner.class);
        registerMachineBlock(IndustrialProcessing.blockBoiler, "IP.Boiler", "Boiler", TileEntityBoiler.class);
        registerMachineBlock(IndustrialProcessing.blockTurbine, "IP.Turbine", "Turbine", TileEntityTurbine.class);

        registerMachineBlock(IndustrialProcessing.blockManualTreetap, "IP.TreeTap.Manual", "Manual Treetap", TileEntityManualTreeTap.class);
        registerMachineBlock(IndustrialProcessing.blockAutomaticTreetap, "IP.TreeTap.Automatic", "Automatic Treetap", TileEntityAutomaticTreeTap.class);
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

    public static int getIncubatorID() {
        return getInstance().incubatorID;
    }

    public static int getTricklingFilterID() {
        return getInstance().tricklingFilterID;
    }

    public static int getWaterTreatmentStationID() {
        return getInstance().waterTreatmentStationID;
    }

    public static int getBLmultiblockBlastFurnaceTower() {
        return getInstance().BLmultiblockBlastFurnaceTower;
    }

    public static int getBLmultiblockBlastFurnace() {
        return getInstance().BLmultiblockBlastFurnace;
    }

    public static int getBLtransportConveyorBeltInput() {
        return getInstance().BLtransportConveyorBeltInput;
    }

    public static int getBLtransportConveyorBeltOutput() {
        return getInstance().BLtransportConveyorBeltOutput;
    }

    public static int getBLtransportConveyorBeltSorter() {
        return getInstance().BLtransportConveyorBeltSorter;
    }

    public static int getBlockTransportConveyorBelt() {
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

    public static int getAutomaticTreeTapBlockID() {
        return getInstance().automaticTreeTapID;
    }

    public static int getManualTreeTapBlockID() {
        return getInstance().manualTreeTapID;
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

    public static int getBlockPetrolLamp() {
        return getInstance().petrolLampBlockID;
    }

    public static int getBlockElectricLamp() {
        return getInstance().electricLampBlockID;
    }

    public static int getWireMillBlockID() {
	return getInstance().wireMillBlockID;
    }  
}
