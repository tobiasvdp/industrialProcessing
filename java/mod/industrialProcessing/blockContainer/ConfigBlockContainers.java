package mod.industrialProcessing.blockContainer;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.machine.crusher.ModelCrusher;
import mod.industrialProcessing.blockContainer.machine.crusher.TileEntityCrusher;
import mod.industrialProcessing.plants.decoration.light.hangingLamp.TileEntityPetrolLamp;
import mod.industrialProcessing.plants.decoration.light.hangingLamp.model.ModelPetrolLamp;
import mod.industrialProcessing.plants.decoration.light.torch.TileEntityTorch;
import mod.industrialProcessing.plants.power.generator.crankGenerator.ModelCrankGenerator;
import mod.industrialProcessing.plants.power.generator.crankGenerator.TileEntityManualGenerator;
import mod.industrialProcessing.plants.power.meter.ModelVoltMeter;
import mod.industrialProcessing.plants.power.meter.TileEntityVoltMeter;
import mod.industrialProcessing.plants.power.motor.electroMotor.TileEntityElectroMotor;
import mod.industrialProcessing.plants.power.motor.electroMotor.models.ModelElectroMotorBlock;
import mod.industrialProcessing.plants.power.motor.electroMotor.models.ModelElectroMotorTile;
import mod.industrialProcessing.plants.power.storage.TileEntityEnergyCell;
import mod.industrialProcessing.plants.power.storage.model.ModelEnergyCellBlock;
import mod.industrialProcessing.plants.power.storage.model.ModelEnergyCellTile;
import mod.industrialProcessing.utils.registry.BlockRegistry;

public class ConfigBlockContainers {

    private ConfigBlockContainers() {

    }

    private static ConfigBlockContainers instance = new ConfigBlockContainers();
   
    public void registerBlocks() {
    	
    	BlockRegistry.registerMachine(IndustrialProcessing.blockCrusher, TileEntityCrusher.class, "IP.machine.crusher",new ModelCrusher());
    	BlockRegistry.registerMachine(IndustrialProcessing.blockManualGenerator, TileEntityManualGenerator.class, "IP.generator.manual",new ModelCrankGenerator(true));
    	BlockRegistry.registerMachine(IndustrialProcessing.blockElectroMotor, TileEntityElectroMotor.class, "IP.motor.electro",new ModelElectroMotorBlock(),new ModelElectroMotorTile());
    	BlockRegistry.registerMachine(IndustrialProcessing.blockVoltMeter, TileEntityVoltMeter.class, "IP.meter.volt",new ModelVoltMeter(false));
    	BlockRegistry.registerMachine(IndustrialProcessing.blockEnergyCell, TileEntityEnergyCell.class, "IP.storage.energy",new ModelEnergyCellBlock(), new ModelEnergyCellTile());
    	BlockRegistry.registerMachine(IndustrialProcessing.blockPetrolLamp, TileEntityPetrolLamp.class, "IP.light.hanging",new ModelPetrolLamp());
    	BlockRegistry.registerMachine(IndustrialProcessing.blockTorch, TileEntityTorch.class, "IP.light.torch");
    	/*
        registerMachineBlock(ISetupMachineBlocks.blockTorch, "IP.Machine.Torch", "Torch", TileEntityTorch.class, BlockType.decoration);
        registerMachineBlock(ISetupMachineBlocks.blockAlkylationUnit, "IP.Machine.AlkUnit", "Alkylation unit", TileEntityAlkylationUnit.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockGasProcessor, "IP.Machine.GasProc", "Gas processor", TileEntityGasProcessor.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockAsphaltBlower, "IP.Machine.AspBlow", "Asphalt blower", TileEntityAsphaltBlower.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockIsomerizationReactor, "IP.Machine.IsoReac", "Isomerization reactor", TileEntityIsomerizationReactor.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockSourWaterStripper, "IP.Machine.SRstrip", "Sour water Stripper", TileEntitySourWaterStripper.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockElectrolyser, "IP.Machine.Ellyser", "Electrolyser", TileEntityElectrolyser.class, BlockType.Machine, BlockType.Refinary);

        registerMachineBlock(ISetupMachineBlocks.blockVacuumCaster, "IP.Machine.VacCast", "Vacuum caster", TileEntityVacuumCaster.class);
        registerMachineBlock(ISetupMachineBlocks.blockSandCaster, "IP.Machine.SandCast", "Sand caster", TileEntitySandCaster.class);
        registerMachineBlock(ISetupMachineBlocks.blockTurretLathe, "IP.Machine.TurrLat", "Turret lathe", TileEntityTurretLathe.class);
        registerMachineBlock(ISetupMachineBlocks.blockCoolingUnit, "IP.Machine.CoolUn", "Cooling unit", TileEntityCoolingUnit.class);
        registerMachineBlock(ISetupMachineBlocks.blockSmelter, "IP.Machine.Smelt", "Smelter", TileEntitySmelter.class);
        registerMachineBlock(ISetupMachineBlocks.blockRoaster, "IP.Machine.Roast", "Roaster", TileEntityRoaster.class);
        registerMachineBlock(ISetupMachineBlocks.blockQuenchTank, "IP.Machine.Quench", "QuenchTank", TileEntityQuenchTank.class);
        registerMachineBlock(ISetupMachineBlocks.blockGrindingStone, "IP.Machine.GrStone", "Grinding stone", TileEntityGrindingStone.class, BlockType.Machine, BlockType.assemble);
        registerMachineBlock(ISetupMachineBlocks.blockStorageRack, "IP.Machine.StorRack", "Storage rack", TileEntityStorageRack.class, BlockType.Storage);
        registerMachineBlock(ISetupMachineBlocks.blockStorageBox, ItemStorageBox.class, "IP.Machine.StorBox", "Storage box", TileEntityStorageBox.class, BlockType.Storage);

        registerMachineBlock(ISetupMachineBlocks.blockConveyorBelt, "IP.Trans.CBelt", "Conveyor belt", TileEntityConveyorBelt.class, BlockType.Machine, BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorBeltInput, "IP.Trans.CBInput", "Conveyor belt import", TileEntityConveyorInput.class, BlockType.Machine, BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorOutput, "IP.Trans.CBOutput", "Conveyor belt export", TileEntityConveyorOutput.class, BlockType.Machine, BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorSorter, "IP.Trans.CBSorter", "Conveyor belt sorter", TileEntityConveyorSorter.class, BlockType.Machine, BlockType.Transport);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorChute, "IP.Trans.CBShute", "Conveyor shute", TileEntityConveyorChute.class, BlockType.Machine, BlockType.Transport);

        // multiblocks
        registerMachineBlock(ISetupMachineBlocks.blockContainerWall, "IP.MBD.Cont", "Container wall", TileEntityContainerWall.class, BlockType.Machine, BlockType.Storage, BlockType.Dummy);
        registerMachineBlock(ISetupMachineBlocks.blockContainer, "IP.MBC.Cont", "Container", TileEntityContainer.class, BlockType.Machine, BlockType.Storage);
        registerMachineBlock(ISetupMachineBlocks.blockAmineTreater, "IP.MBC.AmTr", "Amine treater", TileEntityAmineTreater.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockCatalyticReformer, "IP.MBC.CatRef", "Catalytic reformer", TileEntityCatalyticReformer.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockClausSulfurPlant, "IP.MBC.ClSulf", "Claus sulfur plant", TileEntityClausSulfurPlant.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockDelayedCoker, "IP.MBC.DelCoke", "Delayed coker", TileEntityDelayedCoker.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockFluidCatalyticCracker, "IP.MBc.CatCrack", "Fluid catalytic cracker", TileEntityFluidCatalyticCracker.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockHydroCracker, "IP.MBC.HydrCrack", "Hydro cracker", TileEntityHydroCracker.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockHydroTreater, "IP.MBC.HydrTr", "Hydro treater", TileEntityHydroTreater.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockMeroxTreater, "IP.MBC.MerTr", "Merox Treater", TileEntityMeroxTreater.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockVacuumDestilationTower, "IP.MBC.VacDest", "Vacuum Destilation base", TileEntityVacuumDestilationTower.class, BlockType.Machine, BlockType.Refinary);

        registerMachineBlock(ISetupMachineBlocks.blockTankPlating, "IP.MBD.TPlat", "Tank plating", TileEntityTankPlating.class, BlockType.Machine, BlockType.Refinary, BlockType.Dummy);
        registerMachineBlock(ISetupMachineBlocks.blockDestilationTray, "IP.MBD.DestTray", "Destilation Tray", TileEntityDestilationTray.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.blockAtmosphericDestilationTower, "IP.MBC.AtmDest", "Atmospheric Destilation base", TileEntityAtmosphericDestilationTower.class, BlockType.Machine, BlockType.Refinary);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockBlastFurnaceTower, "IP.MBD.BlastTow", "Blast furnace tower", TEmultiblockBlastFurnaceTower.class, BlockType.Machine, BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockBlastFurnace, "IP.MBC.BlastFur", "Blast furnace", TEmultiblockBlastFurnace.class, BlockType.Machine, BlockType.Smelting);
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
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockWeldingTableExt, "IP.MBD.WeldingTableExt", "Table", TileEntityMultiblockWeldingTable.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockWheel, "IP.MBD.Wheel", "Rolling wheel", TEmultiblockWheel.class);
        registerMachineBlock(ISetupMachineBlocks.BLmultiblockRollingPress, "IP.MBC.RollingPress", "Rolling press", TEmultiblockRollingPress.class);
        registerMachineBlock(ISetupMachineBlocks.blockSolderingStation, "IP.MBC.Solder", "Soldering station", TileEntitySolderingStation.class, BlockType.assemble);
        registerMachineBlock(ISetupMachineBlocks.blockGarageDoor, "IP.MBC.Garage", "Garage door gearbox", TileEntityGarageDoor.class, BlockType.decoration);
        registerMachineBlock(ISetupMachineBlocks.blockGarageDoorFrame, "IP.MBD.GarageF", "Garage door frame", TileEntityGarageDoorFrame.class, BlockType.decoration);
        registerMachineBlock(ISetupMachineBlocks.blockGarageDoorDoor, "IP.MBD.GarageD", "Garage door", TileEntityGarageDoorDoor.class, BlockType.decoration);
        registerMachineBlock(ISetupMachineBlocks.blockControlBox, "IP.MBD.CtrlB", "Control box", TileEntityControlBox.class, BlockType.decoration);
        registerMachineBlock(ISetupMachineBlocks.blockIronPole, "IP.MBD.IronP", "Iron pole", TileEntityIronPole.class, BlockType.decoration);

        // register entitys associated with multiblocks

        // machines
        registerMachineBlock(ISetupMachineBlocks.blockIncubator, "IP.Machine.Incubator", "Incubator", TileEntityIncubator.class);
        registerMachineBlock(ISetupMachineBlocks.blockTricklingFilter, "IP.Machine.Trickler", "Trickling Filter", TileEntityTricklingFilter.class);
        registerMachineBlock(ISetupMachineBlocks.blockWaterTreatmentStation, "IP.Machine.Treatment", "Water treatment station", TileEntityWaterTreatmentStation.class);
        registerMachineBlock(ISetupMachineBlocks.blockWireMill, "IP.Machine.WireMill", "Wire mill", TileEntityWireMill.class, BlockType.Machine, BlockType.assemble);

        registerMachineBlock(ISetupMachineBlocks.blockCrusher, "IP.Machine.Crusher", "Ore Crusher", TileEntityCrusher.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockFilter, "IP.Machine.Filter", "Ore Filter", TileEntityFilter.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockMageneticSeparator, "IP.Machine.Separator", "Magnetic Separator", TileEntityMagneticSeparator.class);
        registerMachineBlock(ISetupMachineBlocks.blockMixer, "IP.Machine.Mixer", "Mixer", TileEntityMixer.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockDryer, "IP.Machine.Dryer", "Dryer", TileEntityDryer.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockClassifier, "IP.Machine.Classifier", "Classifier", TileEntityClassifier.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockThickener, "IP.Machine.Thickener", "Thickener", TileEntityThickener.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockFlotationCell, "IP.Machine.FlotationCell", "Flotation Cell", TileEntityFlotationCell.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockHydroCyclone, "IP.Machine.HydroCyclone", "Hydro Cyclone Separator", TileEntityHydroCyclone.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockDiskFilter, "IP.Machine.DiskFilter", "Disk Filter", TileEntityDiskFilter.class, BlockType.Machine, BlockType.Ore_Processing);
        registerMachineBlock(ISetupMachineBlocks.blockExtruder, "IP.Machine.Extruder", "Extruder", TileEntityExtruder.class, BlockType.Machine, BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.blockOxygenFurnace, "IP.Machine.OxygenFurnace", "Oxygen Furnace", TileEntityOxygenFurnace.class, BlockType.Machine, BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.blockPelletExtruder, "IP.Machine.PelletExtruder", "Pellet Extruder", TileEntityPelletExtruder.class, BlockType.Machine, BlockType.Smelting);
        registerMachineBlock(ISetupMachineBlocks.blockInsulator, "IP.Machine.Insulator", "Insulator", TileEntityInsulator.class);
        registerMachineBlock(ISetupMachineBlocks.blockSpoolWindingMachine, "IP.Machine.SpoolWinding", "Spool winding machine", TileEntitySpoolWindingMachine.class);

        registerMachineBlock(ISetupMachineBlocks.blockManualGenerator, "IP.Generator.Manual", "Crank Generator", TileEntityManualGenerator.class, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockBuildcraftGenerator, "IP.Generator.Buildcraft", "Buildcraft Generator", TileEntityBuildcraftGenerator.class, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockGenerator, "IP.Generator", "Generator", TileEntityGenerator.class, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockPetrolLamp, "IP.Lamp.Petrol", "Hanging Lamp", TileEntityPetrolLamp.class);
        registerMachineBlock(ISetupMachineBlocks.blockElectricLamp, "IP.Lamp.Electric", "Electric Lamp", TileEntityElectricLamp.class);
        registerMachineBlock(ISetupMachineBlocks.blockSinter, "IP.Machine.Sinter", "Sinter", TileEntitySinter.class);
        registerMachineBlock(ISetupMachineBlocks.blockKiln, "IP.Machine.kiln", "Kiln", TileEntityKiln.class);

        // transport
        registerMachineBlock(ISetupMachineBlocks.blockTransportFluids, "IP.Transport.Fluids", "Fluid Pipe", TileEntityTransportFluids.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockTransportFluidsWood, ItemBlockWithMetadata.class, "IP.Transport.Fluids.Wood", "Wood-embedded Fluid Pipe", TileEntityTransportFluidsWood.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockTransportFluidsStone, ItemBlockWithMetadata.class, "IP.Transport.Fluids.Stone", "Stone-embedded Fluid Pipe", TileEntityTransportFluidsStone.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockPump, "IP.Transport.Fluids.Pump", "Fluid pump", TileEntityPump.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockTank, "IP.Transport.Fluids.Tank", "Fluid Tank", TileEntityTank.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockManometer, "IP.Transport.Fluids.Manometer", "Manometer", TileEntityManoMeter.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockGrate, "IP.Transport.Fluids.Grate", "Grate", TileEntityGrate.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockRainTank, "IP.Transport.Fluids.RainTank", "Rain Collector", TileEntityRainTank.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockValve, "IP.Transport.Fluids.Valve", "Valve", TileEntityValve.class, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockConveyorBeltPowerInput, "IP.Transport.Power.CBPI", "Conveyor belt power connector", TileEntityConveyorBeltPowerInput.class, BlockType.Transport, BlockType.Power);

        registerMachineBlock(ISetupMachineBlocks.blockConveyorPacker, "IP.Transport.Packer", "Conveyor packing machine", TileEntityConveyorPacker.class, BlockType.Transport);

        // power
        registerMachineBlock(ISetupMachineBlocks.blockWire, "IP.Wire", "Wire", TileEntityWire.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockWireWood, ItemBlockWithMetadata.class, "IP.Wire.Wood", "Wood-embedded Wire", TileEntityWire.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockWireStone, ItemBlockWithMetadata.class, "IP.Wire.Stone", "Stone-embedded Wire", TileEntityWire.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockVoltMeter, "IP.Meter.Volt", "Volt Meter", TileEntityVoltMeter.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockEnergyCell, "IP.EnergyCell", "Battery Box", TileEntityEnergyCell.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockSolidBurner, "IP.SolidBurner", "Solid Burner", TileEntitySolidBurner.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockFuelBurner, "IP.FuelBurner", "Fuel Burner", TileEntityFuelBurner.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockElectricHeater, "IP.ElectricHeater", "Electric Heater", TileEntityElectricHeater.class, BlockType.Machine, BlockType.Power);
        registerMachineBlock(ISetupMachineBlocks.blockBoiler, "IP.Boiler", "Boiler", TileEntityBoiler.class, BlockType.Machine, BlockType.Power, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockTurbine, "IP.Turbine", "Turbine", TileEntityTurbine.class, BlockType.Machine, BlockType.Power, BlockType.fluid);
        registerMachineBlock(ISetupMachineBlocks.blockElectroMotor, "IP.Motor.Electric", "Electro Motor", TileEntityElectroMotor.class, BlockType.Machine, BlockType.Power);

        registerMachineBlock(ISetupMachineBlocks.blockManualTreetap, "IP.TreeTap.Manual", "Manual Treetap", TileEntityManualTreeTap.class, BlockType.Machine, BlockType.assemble);
        registerMachineBlock(ISetupMachineBlocks.blockAutomaticTreetap, "IP.TreeTap.Automatic", "Automatic Treetap", TileEntityAutomaticTreeTap.class, BlockType.Machine, BlockType.assemble);
        */
    }

    public static ConfigBlockContainers getInstance() {
        return instance;
    }
}
