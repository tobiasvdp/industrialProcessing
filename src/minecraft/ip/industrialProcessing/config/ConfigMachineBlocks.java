package ip.industrialProcessing.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.decoration.light.TileEntityElectricLamp;
import ip.industrialProcessing.decoration.light.PetrolLamp.TileEntityPetrolLamp;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.electrolyser.TileEntityElectrolyser;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.flotationCell.TileEntityFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.TileEntityHydroCyclone;
import ip.industrialProcessing.machines.insulator.TileEntityInsulator;
import ip.industrialProcessing.machines.kiln.TileEntityKiln;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.oxygenFurnace.TileEntityOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;
import ip.industrialProcessing.machines.plants.blacksmith.grindingStone.TileEntityGrindingStone;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.TileEntityExtruder;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.TileEntitySandCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.turretLathe.TileEntityTurretLathe;
import ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster.TileEntityVacuumCaster;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank.TileEntityQuenchTank;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster.TileEntityRoaster;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter.TileEntitySmelter;
import ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit.TileEntityAlkylationUnit;
import ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower.TileEntityAsphaltBlower;
import ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor.TileEntityGasProcessor;
import ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor.TileEntityIsomerizationReactor;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.TileEntitySourWaterStripper;
import ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit.TileEntityCoolingUnit;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.TileEntityIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter.TileEntityTricklingFilter;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation.TileEntityWaterTreatmentStation;
import ip.industrialProcessing.machines.sinter.TileEntitySinter;
import ip.industrialProcessing.machines.spoolWindingMachine.TileEntitySpoolWindingMachine;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.machines.treetap.TileEntityAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.TileEntityManualTreeTap;
import ip.industrialProcessing.machines.wireMill.TileEntityWireMill;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.TEmultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.core.block.hotPress.TEmultiblockHotPress;
import ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery.TileEntityBloomery;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.CatalyticReformer.TileEntityCatalyticReformer;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater.TileEntityAmineTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.TileEntityAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.clausSulfurPlant.TileEntityClausSulfurPlant;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker.TileEntityDelayedCoker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.fluidCatalyticCracker.TileEntityFluidCatalyticCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker.TileEntityHydroCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater.TileEntityHydroTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater.TileEntityMeroxTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.TileEntityVacuumDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.storage.container.TileEntityContainer;
import ip.industrialProcessing.multiblock.core.block.rollingPress.TEmultiblockRollingPress;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.bellows.TileEntityBellows;
import ip.industrialProcessing.multiblock.dummy.block.blastFurnaceTower.TEmultiblockBlastFurnaceTower;
import ip.industrialProcessing.multiblock.dummy.block.containerWall.TileEntityContainerWall;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.TileEntityDestilationTray;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.TEmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.dummy.block.frame.TEmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.inventory.input.TEmultiblockInvInput;
import ip.industrialProcessing.multiblock.dummy.block.inventory.output.TEmultiblockInvOutput;
import ip.industrialProcessing.multiblock.dummy.block.ironBowl.TileEntityIronBowl;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.TEmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.dummy.block.screen.TileEntityScreen;
import ip.industrialProcessing.multiblock.dummy.block.tankPlating.TileEntityTankPlating;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.TileEntityMultiblockWeldingTable;
import ip.industrialProcessing.multiblock.dummy.block.wheel.TEmultiblockWheel;
import ip.industrialProcessing.multiblock.dummy.block.wheelConnector.TEmultiblockWheelConnector;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.motor.TileEntityElectroMotor;
import ip.industrialProcessing.power.plants.TileEntityBoiler;
import ip.industrialProcessing.power.plants.TileEntityGenerator;
import ip.industrialProcessing.power.plants.TileEntitySolidBurner;
import ip.industrialProcessing.power.plants.TileEntityTurbine;
import ip.industrialProcessing.power.storage.TileEntityEnergyCell;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.transport.fluids.TileEntityGrate;
import ip.industrialProcessing.transport.fluids.TileEntityManoMeter;
import ip.industrialProcessing.transport.fluids.TileEntityPump;
import ip.industrialProcessing.transport.fluids.TileEntityRainTank;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluidsStone;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluidsWood;
import ip.industrialProcessing.transport.fluids.TileEntityValve;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorChute.TileEntityConveyorChute;
import ip.industrialProcessing.transport.items.conveyorInput.TileEntityConveyorInput;
import ip.industrialProcessing.transport.items.conveyorOutput.TileEntityConveyorOutput;
import ip.industrialProcessing.transport.items.conveyorSorter.TileEntityConveyorSorter;
import ip.industrialProcessing.utils.registry.BlockRegistry;
import ip.industrialProcessing.utils.registry.BlockType;
import ip.industrialProcessing.utils.registry.RecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidStack;
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
    private int sinterBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "sinterBlockID", 510).getInt();
    private int kilnBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "kilnBlockID", 511).getInt();
    private int vacuumCasterBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "vacuumCasterBlockID", 512).getInt();
    private int turretLatheBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "turretLatheBlockID", 513).getInt();
    private int sandCasterBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "sandCasterBlockID", 514).getInt();
    private int coolingUnitBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "coolingUnitBlockID", 515).getInt();
    private int roasterBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "roasterBlockID", 516).getInt();
    private int smelterBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "smelterBlockID", 517).getInt();
    private int quenchTankBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "quenchTankBlockID", 518).getInt();
    private int grindingStoneBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "grindingStoneBlockID", 519).getInt();
    private int anvilBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "anvilBlockID", 520).getInt();
    private int bellowsBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "bellowsBlockID", 521).getInt();
    private int bloomeryBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "bloomeryBlockID", 522).getInt();
    private int ironBowlBlockID= IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "ironBowlBlockID", 523).getInt();
    
    private int blastFurnaceID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "BlastFurnaceID", 550).getInt();
    private int extruderID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "ExtruderID", 551).getInt();
    private int oxygenFurnaceID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "OxygenFurnaceID", 552).getInt();
    private int pelletExtruderID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "PelletExtruderID", 553).getInt();
    private int incubatorID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "incubatorID", 554).getInt();
    private int tricklingFilterID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "tricklingFilterID", 555).getInt();
    private int waterTreatmentStationID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "waterTreatmentStationID", 556).getInt();
    private int wireMillBlockID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "wireMillBlockID", 557).getInt();
    private int insulatorBlockID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "insulatorBlockID", 558).getInt();
    private int spoolWindingMachineBlockID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "spoolWindingMachineBlockID", 559).getInt();
    private int electrolyserBlockID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "electrolyserBlockID", 560).getInt();
    private int sourWaterStripperID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "sourWaterStripperBlockID", 561).getInt();
    private int alkylationUnitID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "alkylationUnitID", 562).getInt();
    private int asphaltBlowerID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "asphaltBlowerID", 563).getInt();
    private int gasProcessorID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "gasProcessorID", 564).getInt();
    private int isomerizationReactorID = IndustrialProcessing.config.get(ConfigCategories.machineSmelting.toString(), "isomerizationReactorID", 565).getInt();

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
    private int wireWoodBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "WireWoodID", 906).getInt();
    private int wireStoneBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "WireStoneID", 907).getInt();
    private int electroMotorBlockID = IndustrialProcessing.config.get(ConfigCategories.power.toString(), "ElectroMotorID", 908).getInt();

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
    private int blockAtmosphericDestilationTowerID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockAtmosphericDestilationTowerID", 752).getInt();
    private int blockDestilationTrayID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockDestilationTrayID", 753).getInt();
    private int blockTankPlatingID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockTankPlatingID", 754).getInt();
    private int blockAmineTreaterID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockAmineTreaterID", 755).getInt();
    private int blockCatalyticReformerID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockCatalyticReformerID", 756).getInt();
    private int blockClausSulfurPlantID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockClausSulfurPlantID", 757).getInt();
    private int blockDelayedCokerID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockDelayedCokerID", 758).getInt();
    private int blockFluidCatalyticCrackerID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockFluidCatalyticCrackerID", 759).getInt();
    private int blockHydroCrackerID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockHydroCrackerID", 760).getInt();
    private int blockHydroTreaterID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockHydroTreaterID", 761).getInt();
    private int blockMeroxTreaterID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockMeroxTreaterID", 762).getInt();
    private int blockVacuumDestilationTowerID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "blockVacuumDestilationTowerID", 763).getInt();
    private int containerBlockID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "containerBlockID", 764).getInt();
    private int containerWallBlockID = IndustrialProcessing.config.get(ConfigCategories.multiblocks.toString(), "containerWallBlockID", 765).getInt();

    private int BLtransportConveyorBelt = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltID", 735).getInt();
    private int BLtransportConveyorBeltInput = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltInputID", 736).getInt();
    private int BLtransportConveyorBeltOutput = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltOutputID", 737).getInt();
    private int BLtransportConveyorBeltSorter = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorBeltSorterID", 744).getInt();
    private int BLtransportConveyorShute = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "ConveyorShuteID", 745).getInt();

    public void registerMachineBlocks() {
    	registerMachineBlock(ISetupMachineBlocks.blockAlkylationUnit, "IP.Machine.AlkUnit", "Alkylation unit", TileEntityAlkylationUnit.class, BlockType.Machine,BlockType.Refinary);
    	registerMachineBlock(ISetupMachineBlocks.blockGasProcessor, "IP.Machine.GasProc", "Gas processor", TileEntityGasProcessor.class, BlockType.Machine,BlockType.Refinary);
    	registerMachineBlock(ISetupMachineBlocks.blockAsphaltBlower, "IP.Machine.AspBlow", "Asphalt blower", TileEntityAsphaltBlower.class, BlockType.Machine,BlockType.Refinary);
    	registerMachineBlock(ISetupMachineBlocks.blockIsomerizationReactor, "IP.Machine.IsoReac", "Isomerization reactor", TileEntityIsomerizationReactor.class, BlockType.Machine,BlockType.Refinary);
    	registerMachineBlock(ISetupMachineBlocks.blockSourWaterStripper, "IP.Machine.SRstrip", "Sour water Stripper", TileEntitySourWaterStripper.class, BlockType.Machine,BlockType.Refinary);
    	registerMachineBlock(ISetupMachineBlocks.blockElectrolyser, "IP.Machine.Ellyser", "Electrolyser", TileEntityElectrolyser.class, BlockType.Machine,BlockType.Refinary);
    	
    	registerMachineBlock(ISetupMachineBlocks.blockVacuumCaster, "IP.Machine.VacCast", "Vacuum caster", TileEntityVacuumCaster.class);
    	registerMachineBlock(ISetupMachineBlocks.blockSandCaster, "IP.Machine.SandCast", "Sand caster", TileEntitySandCaster.class);
    	registerMachineBlock(ISetupMachineBlocks.blockTurretLathe, "IP.Machine.TurrLat", "Turret lathe", TileEntityTurretLathe.class);
    	registerMachineBlock(ISetupMachineBlocks.blockCoolingUnit, "IP.Machine.CoolUn", "Cooling unit", TileEntityCoolingUnit.class);
    	registerMachineBlock(ISetupMachineBlocks.blockSmelter, "IP.Machine.Smelt", "Smelter", TileEntitySmelter.class);
    	registerMachineBlock(ISetupMachineBlocks.blockRoaster, "IP.Machine.Roast", "Roaster", TileEntityRoaster.class);
    	registerMachineBlock(ISetupMachineBlocks.blockQuenchTank, "IP.Machine.Quench", "QuenchTank", TileEntityQuenchTank.class);
    	registerMachineBlock(ISetupMachineBlocks.blockGrindingStone, "IP.Machine.GrStone", "Grinding stone", TileEntityGrindingStone.class,BlockType.Machine,BlockType.assemble);
    	registerMachineBlock(ISetupMachineBlocks.blockBellows, "IP.MBD.Bellow", "Bellows", TileEntityBellows.class,BlockType.Machine,BlockType.assemble);
    	registerMachineBlock(ISetupMachineBlocks.blockBloomery, "IP.MBC.Bloom", "Bloomery", TileEntityBloomery.class,BlockType.Machine,BlockType.assemble);
    	registerMachineBlock(ISetupMachineBlocks.blockIronBowl, "IP.MBD.IBowl", "Iron bowl", TileEntityIronBowl.class,BlockType.Machine,BlockType.assemble);
    	

        registerMachineBlock(ISetupMachineBlocks.blockConveyorBelt, "IP.Trans.CBelt", "Conveyor belt", TileEntityConveyorBelt.class,BlockType.Machine,BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorBeltInput, "IP.Trans.CBInput", "Conveyor belt import", TileEntityConveyorInput.class,BlockType.Machine,BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorOutput, "IP.Trans.CBOutput", "Conveyor belt export", TileEntityConveyorOutput.class,BlockType.Machine,BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorSorter, "IP.Trans.CBSorter", "Conveyor belt sorter", TileEntityConveyorSorter.class,BlockType.Machine,BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorChute, "IP.Trans.CBShute", "Conveyor shute", TileEntityConveyorChute.class,BlockType.Machine,BlockType.Transport);
        
        // multiblocks
        registerMachineBlock(ISetupMachineBlocks.blockContainerWall, "IP.MBD.Cont", "Container wall", TileEntityContainerWall.class, BlockType.Machine,BlockType.Storage,BlockType.Dummy);
        registerMachineBlock(ISetupMachineBlocks.blockContainer, "IP.MBC.Cont", "Container", TileEntityContainer.class, BlockType.Machine,BlockType.Storage);
        registerMachineBlock(ISetupMachineBlocks.blockAmineTreater, "IP.MBC.AmTr", "Amine treater", TileEntityAmineTreater.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockCatalyticReformer, "IP.MBC.CatRef", "Catalytic reformer", TileEntityCatalyticReformer.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockClausSulfurPlant, "IP.MBC.ClSulf", "Claus sulfur plant", TileEntityClausSulfurPlant.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockDelayedCoker, "IP.MBC.DelCoke", "Delayed coker", TileEntityDelayedCoker.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockFluidCatalyticCracker, "IP.MBc.CatCrack", "Fluid catalytic cracker", TileEntityFluidCatalyticCracker.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockHydroCracker, "IP.MBC.HydrCrack", "Hydro cracker", TileEntityHydroCracker.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockHydroTreater, "IP.MBC.HydrTr", "Hydro treater", TileEntityHydroTreater.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockMeroxTreater, "IP.MBC.MerTr", "Merox Treater", TileEntityMeroxTreater.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockVacuumDestilationTower, "IP.MBC.VacDest", "Vacuum Destilation base", TileEntityVacuumDestilationTower.class, BlockType.Machine,BlockType.Refinary);
        
        registerMachineBlock(ISetupMachineBlocks.blockTankPlating, "IP.MBD.TPlat", "Tank plating", TileEntityTankPlating.class, BlockType.Machine,BlockType.Refinary, BlockType.Dummy);
        registerMachineBlock(ISetupMachineBlocks.blockDestilationTray, "IP.MBD.DestTray", "Destilation Tray", TileEntityDestilationTray.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockAtmosphericDestilationTower, "IP.MBC.AtmDest", "Atmospheric Destilation base", TileEntityAtmosphericDestilationTower.class, BlockType.Machine,BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockBlastFurnaceTower, "IP.MBD.BlastTow", "Blast furnace tower", TEmultiblockBlastFurnaceTower.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockBlastFurnace, "IP.MBC.BlastFur", "Blast furnace", TEmultiblockBlastFurnace.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockDisplayPanel, "IP.MBD.Display", "Display panel", TEmultiblockDisplayPanel.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockWheelConnector, "IP.MBD.WheelCon", "Wheel connector", TEmultiblockWheelConnector.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockLiftDoor, "IP.MBD.LiftDoor", "Lift door", TEmultiblockLiftDoor.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockElevator, "IP.MBC.Elevator", "Elevator", TEmultiblockElevator.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockToggleButton, "IP.MBD.Toggle", "Control panel", TEmultiblockToggleButton.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockToggleButton2, "IP.MBD.Toggle2", "Lift call button", TEmultiblockToggleButton.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockInvInput, "IP.MBD.InvInput", "Item input", TEmultiblockInvInput.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockInvOutput, "IP.MBD.InvOutput", "Item output", TEmultiblockInvOutput.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockScreen, "IP.MBD.Screen", "Screen", TileEntityScreen.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockFrame, "IP.MBD.Frame", "Frame", TEmultiblockFrame.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockHotPress, "IP.MBC.HotPress", "Hot press", TEmultiblockHotPress.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockWeldingStation, "IP.MBC.WeldingStation", "Welding station", TileEntityMultiblockWeldingStation.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockWeldingTableExt, "IP.MBD.WeldingTableExt", "Welding table", TileEntityMultiblockWeldingTable.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockWheel, "IP.MBD.Wheel", "Rolling wheel", TEmultiblockWheel.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockRollingPress, "IP.MBC.RollingPress", "Rolling press", TEmultiblockRollingPress.class);

        // register entitys associated with multiblocks

        // machines
        registerMachineBlock(ISetupMachineBlocks.blockIncubator, "IP.Machine.Incubator", "Incubator", TileEntityIncubator.class);
        registerMachineBlock(ISetupMachineBlocks.blockTricklingFilter, "IP.Machine.Trickler", "Trickling Filter", TileEntityTricklingFilter.class);
        registerMachineBlock(ISetupMachineBlocks.blockWaterTreatmentStation, "IP.Machine.Treatment", "Water treatment station", TileEntityWaterTreatmentStation.class);
        registerMachineBlock(ISetupMachineBlocks.blockWireMill, "IP.Machine.WireMill", "Wire mill", TileEntityWireMill.class,BlockType.Machine,BlockType.assemble);

        registerMachineBlock(ISetupMachineBlocks.blockCrusher, "IP.Machine.Crusher", "Ore Crusher", TileEntityCrusher.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockFilter, "IP.Machine.Filter", "Ore Filter", TileEntityFilter.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockMageneticSeparator, "IP.Machine.Separator", "Magnetic Separator", TileEntityMagneticSeparator.class);
        registerMachineBlock(ISetupMachineBlocks.blockMixer, "IP.Machine.Mixer", "Mixer", TileEntityMixer.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockDryer, "IP.Machine.Dryer", "Dryer", TileEntityDryer.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockClassifier, "IP.Machine.Classifier", "Classifier", TileEntityClassifier.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockThickener, "IP.Machine.Thickener", "Thickener", TileEntityThickener.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockFlotationCell, "IP.Machine.FlotationCell", "Flotation Cell", TileEntityFlotationCell.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockHydroCyclone, "IP.Machine.HydroCyclone", "Hydro Cyclone Separator", TileEntityHydroCyclone.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockDiskFilter, "IP.Machine.DiskFilter", "Disk Filter", TileEntityDiskFilter.class, BlockType.Machine,BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockExtruder, "IP.Machine.Extruder", "Extruder", TileEntityExtruder.class, BlockType.Machine,BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.blockOxygenFurnace, "IP.Machine.OxygenFurnace", "Oxygen Furnace", TileEntityOxygenFurnace.class, BlockType.Machine,BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.blockPelletExtruder, "IP.Machine.PelletExtruder", "Pellet Extruder", TileEntityPelletExtruder.class, BlockType.Machine,BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.blockInsulator, "IP.Machine.Insulator", "Insulator", TileEntityInsulator.class);
        registerMachineBlock(ISetupMachineBlocks.blockSpoolWindingMachine, "IP.Machine.SpoolWinding", "Spool winding machine", TileEntitySpoolWindingMachine.class);

        registerMachineBlock(ISetupMachineBlocks.blockManualGenerator, "IP.Generator.Manual", "Crank Generator", TileEntityManualGenerator.class);
        registerMachineBlock(ISetupMachineBlocks.blockBuildcraftGenerator, "IP.Generator.Buildcraft", "Buildcraft Generator", TileEntityBuildcraftGenerator.class);
        registerMachineBlock(ISetupMachineBlocks.blockGenerator, "IP.Generator", "Generator", TileEntityGenerator.class);
        registerMachineBlock(ISetupMachineBlocks.blockPetrolLamp, "IP.Lamp.Petrol", "Hanging Lamp", TileEntityPetrolLamp.class);
        registerMachineBlock(ISetupMachineBlocks.blockElectricLamp, "IP.Lamp.Electric", "Electric Lamp", TileEntityElectricLamp.class);
        registerMachineBlock(ISetupMachineBlocks.blockSinter, "IP.Machine.Sinter", "Sinter", TileEntitySinter.class);
        registerMachineBlock(ISetupMachineBlocks.blockKiln, "IP.Machine.kiln", "Kiln", TileEntityKiln.class);

        // transport
        registerMachineBlock(ISetupMachineBlocks.blockTransportFluids, "IP.Transport.Fluids", "Fluid Pipe", TileEntityTransportFluids.class);
        registerMachineBlock(ISetupMachineBlocks.blockTransportFluidsWood, ItemBlockWithMetadata.class, "IP.Transport.Fluids.Wood", "Wood-embedded Fluid Pipe", TileEntityTransportFluidsWood.class);
        registerMachineBlock(ISetupMachineBlocks.blockTransportFluidsStone, ItemBlockWithMetadata.class, "IP.Transport.Fluids.Stone", "Stone-embedded Fluid Pipe", TileEntityTransportFluidsStone.class);
        registerMachineBlock(ISetupMachineBlocks.blockPump, "IP.Transport.Fluids.Pump", "Fluid pump", TileEntityPump.class);
        registerMachineBlock(ISetupMachineBlocks.blockTank, "IP.Transport.Fluids.Tank", "Fluid Tank", TileEntityTank.class);
        registerMachineBlock(ISetupMachineBlocks.blockManometer, "IP.Transport.Fluids.Manometer", "Manometer", TileEntityManoMeter.class);
        registerMachineBlock(ISetupMachineBlocks.blockGrate, "IP.Transport.Fluids.Grate", "Grate", TileEntityGrate.class);
        registerMachineBlock(ISetupMachineBlocks.blockRainTank, "IP.Transport.Fluids.RainTank", "Rain Collector", TileEntityRainTank.class);
        registerMachineBlock(ISetupMachineBlocks.blockValve, "IP.Transport.Fluids.Valve", "Valve", TileEntityValve.class);

        // power
        registerMachineBlock(ISetupMachineBlocks.blockWire, "IP.Wire", "Wire", TileEntityWire.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockWireWood, ItemBlockWithMetadata.class, "IP.Wire.Wood", "Wood-embedded Wire", TileEntityWire.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockWireStone, ItemBlockWithMetadata.class, "IP.Wire.Stone", "Stone-embedded Wire", TileEntityWire.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockVoltMeter, "IP.Meter.Volt", "Volt Meter", TileEntityVoltMeter.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockAmpMeter, "IP.Meter.Amp", "Amp Meter", TileEntityAmpMeter.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockEnergyCell, "IP.EnergyCell", "Battery Box", TileEntityEnergyCell.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockSolidBurner, "IP.SolidBurner", "Solid Burner", TileEntitySolidBurner.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockBoiler, "IP.Boiler", "Boiler", TileEntityBoiler.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockTurbine, "IP.Turbine", "Turbine", TileEntityTurbine.class,BlockType.Machine,BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockElectroMotor, "IP.Motor.Electric", "Electro Motor", TileEntityElectroMotor.class,BlockType.Machine,BlockType.Power);

        registerMachineBlock(ISetupMachineBlocks.blockManualTreetap, "IP.TreeTap.Manual", "Manual Treetap", TileEntityManualTreeTap.class,BlockType.Machine,BlockType.assemble);
        registerMachineBlock(ISetupMachineBlocks.blockAutomaticTreetap, "IP.TreeTap.Automatic", "Automatic Treetap", TileEntityAutomaticTreeTap.class,BlockType.Machine,BlockType.assemble);
    }

    @Deprecated
    private void registerMachineBlock(Block block, String uniqueId, String displayName, Class tileEntity) {
        GameRegistry.registerBlock(block, uniqueId);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
        LanguageRegistry.addName(block, displayName);
        ModLoader.registerTileEntity(tileEntity, uniqueId);
        BlockRegistry.RegisterBlock(block, new BlockType[]{BlockType.Machine});
		try {
			Field[] declaredFields = tileEntity.getFields();
			for(Field field:declaredFields){
				RecipesMachine recipes = new RecipesMachine();
				Object recipe = field.get(recipes);
				if(recipe instanceof RecipesMachine){
					RecipeRegistry.registerMachinesRecipes((RecipesMachine) recipe, block);
				}
			}
		} catch (IllegalArgumentException e) {
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
		}
    }
    
    private void registerMachineBlock(Block block, String uniqueId, String displayName, Class tileEntity, BlockType... type) {
        GameRegistry.registerBlock(block, uniqueId);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
        LanguageRegistry.addName(block, displayName);
        ModLoader.registerTileEntity(tileEntity, uniqueId);
        BlockRegistry.RegisterBlock(block, type);
		try {
			Field[] declaredFields = tileEntity.getFields();
			for(Field field:declaredFields){
				RecipesMachine recipes = new RecipesMachine();
				Object recipe = field.get(recipes);
				if(recipe instanceof RecipesMachine){
					RecipeRegistry.registerMachinesRecipes((RecipesMachine) recipe, block);
				}
			}
		} catch (IllegalArgumentException e) {
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
		}
    }

    @Deprecated
    private void registerMachineBlock(Block block, Class<? extends ItemBlock> itemBlock, String uniqueId, String displayName, Class tileEntity) {
        GameRegistry.registerBlock(block, itemBlock, uniqueId);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
        LanguageRegistry.addName(block, displayName);
        ModLoader.registerTileEntity(tileEntity, uniqueId);
        BlockRegistry.RegisterBlock(block, new BlockType[]{BlockType.Machine});
		try {
			Field[] declaredFields = tileEntity.getFields();
			for(Field field:declaredFields){
				RecipesMachine recipes = new RecipesMachine();
				Object recipe = field.get(recipes);
				if(recipe instanceof RecipesMachine){
					RecipeRegistry.registerMachinesRecipes((RecipesMachine) recipe, block);
				}
			}
		} catch (IllegalArgumentException e) {
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
		}
    }
    
    private void registerMachineBlock(Block block, Class<? extends ItemBlock> itemBlock, String uniqueId, String displayName, Class tileEntity, BlockType... type) {
        GameRegistry.registerBlock(block, itemBlock, uniqueId);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
        LanguageRegistry.addName(block, displayName);
        ModLoader.registerTileEntity(tileEntity, uniqueId);
        BlockRegistry.RegisterBlock(block, type);
		try {
			Field[] declaredFields = tileEntity.getFields();
			for(Field field:declaredFields){
				RecipesMachine recipes = new RecipesMachine();
				Object recipe = field.get(recipes);
				if(recipe instanceof RecipesMachine){
					RecipeRegistry.registerMachinesRecipes((RecipesMachine) recipe, block);
				}
			}
		} catch (IllegalArgumentException e) {
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
		}
    }

    public static ConfigMachineBlocks getInstance() {
        return instance;
    }

    public static int getBlockIronBowlID() {
        return getInstance().ironBowlBlockID;
    }
    public static int getBlockBloomeryID() {
        return getInstance().bloomeryBlockID;
    }
    public static int getBlockContainerWallID() {
        return getInstance().containerWallBlockID;
    }
    public static int getBlockBellowsID() {
        return getInstance().bellowsBlockID;
    }
    public static int getBlockGrindingStoneID() {
        return getInstance().grindingStoneBlockID;
    }
    public static int getBlockAnvilID() {
        return getInstance().anvilBlockID;
    }
    public static int getBlockSmelterID() {
        return getInstance().smelterBlockID;
    }
    public static int getBlockRoasterID() {
        return getInstance().roasterBlockID;
    }
    public static int getBlockQuenchTankID() {
        return getInstance().quenchTankBlockID;
    }
    public static int getBlockCoolingUnitID() {
        return getInstance().coolingUnitBlockID;
    }
    public static int getBlockVacuumCasterID() {
        return getInstance().vacuumCasterBlockID;
    }
    
    public static int getBlockTurretLatheID() {
        return getInstance().turretLatheBlockID;
    }
    
    public static int getBlockSandCasterID() {
        return getInstance().sandCasterBlockID;
    }
    
    public static int getBlockAmineTreaterID() {
        return getInstance().blockAmineTreaterID;
    }
    
    public static int getBlockCatalyticReformerID() {
        return getInstance().blockCatalyticReformerID;
    }
    
    public static int getBlockClausSulfurPlantID() {
        return getInstance().blockClausSulfurPlantID;
    }
    
    public static int getBlockDelayedCokerID() {
        return getInstance().blockDelayedCokerID;
    }
    
    public static int getBlockFluidCatalyticCrackerID() {
        return getInstance().blockFluidCatalyticCrackerID;
    }
    
    public static int getBlockHydroCrackerID() {
        return getInstance().blockHydroCrackerID;
    }
    
    public static int getBlockHydroTreaterID() {
        return getInstance().blockHydroTreaterID;
    }
    
    public static int getBlockMeroxTreaterID() {
        return getInstance().blockMeroxTreaterID;
    }
    
    public static int getBlockVacuumDestilationTowerID() {
        return getInstance().blockVacuumDestilationTowerID;
    }

    public static int getBlockTankPlatingID() {
        return getInstance().blockTankPlatingID;
    }
    public static int getBlockDestilationTrayID() {
        return getInstance().blockDestilationTrayID;
    }
    public static int getBlockAtmosphericDestilationTowerID() {
        return getInstance().blockAtmosphericDestilationTowerID;
    }
    public static int getAlkylationUnitBlockID() {
        return getInstance().alkylationUnitID;
    }
    public static int getAsphaltBlowerBlockID() {
        return getInstance().asphaltBlowerID;
    }
    public static int getGasProcessorBlockID() {
        return getInstance().gasProcessorID;
    }
    public static int getIsomerizationReactorBlockID() {
        return getInstance().isomerizationReactorID;
    }
    
    public static int getSourWaterStripperBlockID() {
        return getInstance().sourWaterStripperID;
    }
    
    public static int getElectrolyserBlockID() {
        return getInstance().electrolyserBlockID;
    }
    public static int getInsulatorBlockID() {
        return getInstance().insulatorBlockID;
    }
    
    public static int getSpoolWindingMachineBlockID() {
        return getInstance().spoolWindingMachineBlockID;
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
    
    public static int getBLtransportConveyorShute() {
        return getInstance().BLtransportConveyorShute;
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

    public static int getSinterBlockID() {
        return getInstance().sinterBlockID;
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

    public static int getElectroMotorBlockID() {
        return getInstance().electroMotorBlockID;
    }

    public static int getWireStoneBlockID() {
        return getInstance().wireStoneBlockID;
    }

    public static int getWireWoodBlockID() {
        return getInstance().wireWoodBlockID;
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
    public static int getKilnBlockID() {
        return getInstance().kilnBlockID;
    }

	public static int getBlockContainerID() {
		return getInstance().containerBlockID;
	}
}
