package ip.industrialProcessing.config;

import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ip.industrialProcessing.machines.classifier.BlockClassifier;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.diskFilter.BlockDiskFilter;
import ip.industrialProcessing.machines.dryer.BlockDryer;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.flotationCell.BlockFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.BlockHydroCyclone;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.multiblock.crusher.BlockLargeCrusher;
import ip.industrialProcessing.machines.multiblock.inventory.BlockMultiMachineInput;
import ip.industrialProcessing.machines.multiblock.machineFrame.BlockMachineFrame;
import ip.industrialProcessing.machines.thickener.BlockThickener;
import ip.industrialProcessing.power.buildcraftGenerator.BlockBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.BlockManualGenerator;
import ip.industrialProcessing.power.meters.BlockAmpMeter;
import ip.industrialProcessing.power.meters.BlockVoltMeter;
import ip.industrialProcessing.power.wire.BlockWire;
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

	// create generators
	public final static BlockManualGenerator blockManualGenerator = new BlockManualGenerator();
	public final static BlockBuildcraftGenerator blockBuildcraftGenerator = new BlockBuildcraftGenerator();

	// create wires
	public final static BlockWire blockWire = new BlockWire();
	public final static BlockVoltMeter blockVoltMeter = new BlockVoltMeter();
	public final static BlockAmpMeter blockAmpMeter = new BlockAmpMeter();

	// create Multiblock Machines
	public final static BlockMultiMachineInput blockMultiMachineInput = new BlockMultiMachineInput();
	public final static BlockMachineFrame blockMachineFrame = new BlockMachineFrame();
	public final static BlockLargeCrusher blockLargeCrusher = new BlockLargeCrusher();
	
	// create fluidpipe
	public final static BlockTransportFluids blockTransportFluids = new BlockTransportFluids();
}