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
import ip.industrialProcessing.multiblock.block.frame.TileEntityMachineFrame;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvInput;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvOutput;
import ip.industrialProcessing.multiblock.block.tank.TileEntityMultiblockTankInput;
import ip.industrialProcessing.multiblock.block.tank.TileEntityMultiblockTankOutput;
import ip.industrialProcessing.multiblock.machine.blastFurnace.TileEntityMultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.machine.crusher.TileEntityMultiblockCrusher;
import ip.industrialProcessing.multiblock.machine.mixer.TileEntityMultiblockMixer;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.storage.TileEntityBatteryBox;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.transport.fluids.TileEntityPump;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
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

	private int machineFrameBlockID = 600;
	private int multiMachineInputBlockID = 601;
	private int multiMachineOutputBlockID = 602;
	private int BlockMultiblockTankInputID = 603;
	private int BlockMultiblockTankOutputID = 604;
	private int largeCrusherBlockID = 700;
	private int largeMixerBlockID = 701;
	private int BlockMultiblockBlastFurnaceID = 702;

	private int manualGeneratorBlockID = 800; // Crank Generator
	private int buildcraftGeneratorBlockID = 801; // Buildcraft Joule converter

	private int wireBlockID = 900;
	private int voltMeterBlockID = 901;
	private int ampMeterBlockID = 902;
	private int batteryBoxBlockID = 903; 

	public void registerMachineBlocks() {
		//machines
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

		//transport
		registerMachineBlock(IndustrialProcessing.blockTransportFluids, "IP.Transport.Fluids", "Fluid pipe", TileEntityTransportFluids.class);
		registerMachineBlock(IndustrialProcessing.blockPump, "IP.Transport.Fluids.Pump", "Fluid pump", TileEntityPump.class);
		registerMachineBlock(IndustrialProcessing.blockTank, "IP.Transport.Fluids.Tank", "Fluid Tank", TileEntityTank.class);
		
		//power
		registerMachineBlock(IndustrialProcessing.blockWire, "IP.Wire", "Wire", TileEntityWire.class);
		registerMachineBlock(IndustrialProcessing.blockVoltMeter, "IP.Meter.Volt", "Volt Meter", TileEntityVoltMeter.class);
		registerMachineBlock(IndustrialProcessing.blockAmpMeter, "IP.Meter.Amp", "Amp Meter", TileEntityAmpMeter.class);
		registerMachineBlock(IndustrialProcessing.blockBatteryBox, "IP.BatteryBox", "Battery Box", TileEntityBatteryBox.class);
		
		//multiblocks
		registerMachineBlock(IndustrialProcessing.blockMultiMachineInput, "MultiBlockInvIn", "Multiblock import", TileEntityMultiblockInvInput.class);
		registerMachineBlock(IndustrialProcessing.blockMultiMachineOutput, "MultiBlockInvOut", "Multiblock export", TileEntityMultiblockInvOutput.class);
		registerMachineBlock(IndustrialProcessing.blockMachineFrame, "MultiBlockFrame", "Multiblock Frame", TileEntityMachineFrame.class);
		registerMachineBlock(IndustrialProcessing.blockMultiblockTankInput, "MultiBlockTankIn", "Multiblock tank hatch", TileEntityMultiblockTankInput.class);
		registerMachineBlock(IndustrialProcessing.blockMultiblockTankOutput, "MultiBlockTankOut", "Multiblock tank drain", TileEntityMultiblockTankOutput.class);
		registerMachineBlock(IndustrialProcessing.blockLargeCrusher, "IP.Machine.Multi.Crusher", "Large Crusher", TileEntityMultiblockCrusher.class);
		registerMachineBlock(IndustrialProcessing.blockMultiblockMixer, "IP.Machine.Multi.Mixer", "Large mixer", TileEntityMultiblockMixer.class);
		registerMachineBlock(IndustrialProcessing.blockMultiblockBlastFurnace, "IP.Machine.Multi.Blast", "Large blast furnace", TileEntityMultiblockBlastFurnace.class);
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

	public static int getMachineFrameBlockID() {
		return getInstance().machineFrameBlockID;
	}

	public static int getLargeCrusherBlockID() {
		return getInstance().largeCrusherBlockID;
	}

	public static int getDryerBlockID() {
		return getInstance().dryerBlockID;
	}

	public static int getMultiMachineInputBlockID() {
		return getInstance().multiMachineInputBlockID;
	}
	
	public static int getMultiMachineOutputBlockID() {
		return getInstance().multiMachineOutputBlockID;
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
	public static int getBatteryBoxBlockID() {
		return getInstance().batteryBoxBlockID;
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
	public static int getBlockMultiblockTankInputID() {
		return getInstance().BlockMultiblockTankInputID;
	}
	public static int getBlockMultiblockTankOutputID() {
		return getInstance().BlockMultiblockTankOutputID;
	} 
	public static int getlargeMixerBlockID() {
		return getInstance().largeMixerBlockID;
	} 
	public static int getBlockMultiblockBlastFurnaceID() {
		return getInstance().BlockMultiblockBlastFurnaceID;
	}

}
