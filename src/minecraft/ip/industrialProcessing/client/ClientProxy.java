package ip.industrialProcessing.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.MinecraftForgeClient;
import ip.industrialProcessing.CommonProxy;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;
import ip.industrialProcessing.client.render.ModelMachine;
import ip.industrialProcessing.client.render.ModelMultiblock;
import ip.industrialProcessing.client.render.ModelStateMachine;
import ip.industrialProcessing.client.render.ModelingMultiblock;
import ip.industrialProcessing.client.render.RendererMultiblock;
import ip.industrialProcessing.client.render.RendererTileEntity;
import ip.industrialProcessing.client.render.RendererTileEntityConnected;
import ip.industrialProcessing.client.render.RendererTileEntityConnectedFluid;
import ip.industrialProcessing.client.render.RendererTileEntityFluidWorker;
import ip.industrialProcessing.client.render.RendererTileEntityAnimated;
import ip.industrialProcessing.client.render.RendererTileEntityState;
import ip.industrialProcessing.client.render.RenderingMultiblock;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RendererBlock;
import ip.industrialProcessing.machines.blastFurnace.ModelBlastFurnace;
import ip.industrialProcessing.machines.blastFurnace.ModelBlastFurnaceTop;
import ip.industrialProcessing.machines.blastFurnace.TileEntityBlastFurnace;
import ip.industrialProcessing.machines.crusher.ModelCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.ModelDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.filter.ModelFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.magneticSeparator.ModelMagneticSeperator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.ModelMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.multiblock.block.frame.BlockMachineFrame;
import ip.industrialProcessing.multiblock.block.frame.ModelMultiblockFrame;
import ip.industrialProcessing.multiblock.block.frame.ModelMultiblockFrameConnected;
import ip.industrialProcessing.multiblock.block.frame.ModelMultiblockFrameSidePanel;
import ip.industrialProcessing.multiblock.block.frame.ModelMultiblockFrameTower;
import ip.industrialProcessing.multiblock.block.frame.TileEntityMachineFrame;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvInput;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvOutput;
import ip.industrialProcessing.multiblock.block.weldingStation.ModelMultiblockWeldingStationScreen;
import ip.industrialProcessing.multiblock.block.weldingStation.TileEntityMultiblockWeldingStationRight;
import ip.industrialProcessing.multiblock.block.weldingStation.TileEntityMultiblockWeldingStationScreen;
import ip.industrialProcessing.multiblock.core.block.weldingStation.MDmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.machine.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.utils.ModelMultiblockIO;
import ip.industrialProcessing.multiblock.utils.ModelMultiblockWeldingStation;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.ModelCrankGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.ModelVoltMeter;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.storage.ModelEnergyCell;
import ip.industrialProcessing.power.storage.TileEntityEnergyCell;
import ip.industrialProcessing.power.wire.ModelWire;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.transport.fluids.ModelTank;
import ip.industrialProcessing.transport.fluids.ModelTransportFluids;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;

public class ClientProxy extends CommonProxy {
	public static int renderPass;
	private static final ModelFilter filter = new ModelFilter();
	private static final ModelMachine magneticSeparator = new ModelMagneticSeperator();
	private static final ModelAnimatedFluidMachine mixer = new ModelMixer();
	private static final ModelCrusher crusher = new ModelCrusher();
	private static final ModelAnimatedMachine diskFilter = new ModelDiskFilter();
	private static final ModelConnected wire = new ModelWire();
	private static final ModelAnimatedMachine voltMeter = new ModelVoltMeter(false);
	private static final ModelAnimatedMachine ampMeter = new ModelVoltMeter(true);
	private static final ModelConnected transportFluids = new ModelTransportFluids();
	private static final ModelAnimatedMachine EnergyCell = new ModelEnergyCell();
	private static final ModelAnimatedMachine crankGenerator = new ModelCrankGenerator(true);
	private static final ModelAnimatedMachine buildcraftGenerator = new ModelCrankGenerator(false);
	private static final ModelStateMachine blastFurnace = new ModelBlastFurnace();
	private static final ModelStateMachine blastFurnaceTop = new ModelBlastFurnaceTop();
	private static final ModelConnectedFluid tank = new ModelTank();
	private static final ModelMultiblockFrame multiblockFrame = new ModelMultiblockFrame();
	private static final ModelMultiblockIO multiblockIO = new ModelMultiblockIO();
	private static final ModelMultiblockFrameConnected modelMultiblockFrameConnected = new ModelMultiblockFrameConnected();
	private static final ModelMultiblockFrameSidePanel modelMultiblockFrameSidePanel = new ModelMultiblockFrameSidePanel();
	private static final ModelMultiblockFrameTower modelMultiblockFrameTower = new ModelMultiblockFrameTower();
	public static final ModelMultiblockWeldingStation modelMultiblockWeldingStation = new ModelMultiblockWeldingStation();
	private static final ModelMultiblockWeldingStationScreen modelMultiblockWeldingStationScreen = new ModelMultiblockWeldingStationScreen();
	private static final MDmultiblockWeldingStation MDmultiblockWeldingStation = new MDmultiblockWeldingStation();
	
	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockFilter, "ModelFilter", filter));
		ConfigRenderers.setRendererFilterId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererFilterId(), new TileEntityFilter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagneticSeparator.class, new RendererTileEntity(IndustrialProcessing.blockMageneticSeparator, "ModelMagneticSeperator", magneticSeparator));
		ConfigRenderers.setRendererMagneticSeperatorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMagneticSeperatorId(), new TileEntityMagneticSeparator()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMixer.class, new RendererTileEntityFluidWorker(IndustrialProcessing.blockMixer, "ModelMixer", mixer));
		ConfigRenderers.setRendererMixerId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererMixerId(), new TileEntityMixer()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrusher.class, new RendererTileEntityAnimated(IndustrialProcessing.blockCrusher, "ModelCrusher", crusher));
		ConfigRenderers.setRendererCrusherId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererCrusherId(), new TileEntityCrusher()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiskFilter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockDiskFilter, "ModelDiskFilter", diskFilter));
		ConfigRenderers.setRendererDiskFilterIdId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererDiskFilterId(), new TileEntityDiskFilter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new RendererTileEntityConnected(IndustrialProcessing.blockWire, "ModelWire", wire));
		ConfigRenderers.setRendererWireId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererWireId(), new TileEntityWire()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoltMeter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockVoltMeter, "ModelVoltMeter", voltMeter));
		ConfigRenderers.setRendererVoltMeterId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererVoltMeterId(), new TileEntityVoltMeter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAmpMeter.class, new RendererTileEntityAnimated(IndustrialProcessing.blockAmpMeter, "ModelAmpMeter", ampMeter));
		ConfigRenderers.setRendererAmpMeterId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererAmpMeterId(), new TileEntityAmpMeter()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransportFluids.class, new RendererTileEntityConnected(IndustrialProcessing.blockTransportFluids, "ModelTransportFluids", transportFluids));
		ConfigRenderers.setRendererTransportFluidsId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTransportFluidsId(), new TileEntityTransportFluids()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTank.class, new RendererTileEntityConnectedFluid(IndustrialProcessing.blockTank, "ModelTank", tank));
		ConfigRenderers.setRendererTankId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererTankId(), new TileEntityTank()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCell.class, new RendererTileEntityAnimated(IndustrialProcessing.blockEnergyCell, "ModelBatteryBox", EnergyCell));
		ConfigRenderers.setRendererEnergyCellId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererEnergyCellId(), new TileEntityEnergyCell()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlastFurnace.class, new RendererTileEntityState(IndustrialProcessing.blockBlastFurnace, new String[] { "ModelBlastFurnace", "ModelBlastFurnaceTop" }, new ModelStateMachine[] { blastFurnace, blastFurnaceTop }));
		ConfigRenderers.setRendererBlastFurnaceId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBlastFurnaceId(), new TileEntityBlastFurnace()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManualGenerator.class, new RendererTileEntityAnimated(IndustrialProcessing.blockManualGenerator, "ModelCrankGenerator", crankGenerator));
		ConfigRenderers.setRendererCrankGeneratorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererCrankGeneratorId(), new TileEntityManualGenerator()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBuildcraftGenerator.class, new RendererTileEntityAnimated(IndustrialProcessing.blockBuildcraftGenerator, "ModelCrankGenerator", buildcraftGenerator));
		ConfigRenderers.setRendererBCGeneratorId(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBCGeneratorId(), new TileEntityBuildcraftGenerator()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineFrame.class, new RendererMultiblock(IndustrialProcessing.blockMachineFrame, new String[] { "MultiblockBlock", "MultiblockBlock", "MultiblockBlock", "MultiblockBlock", "MultiblockBlock" }, new ModelMultiblock[] { modelMultiblockFrameConnected, multiblockFrame, modelMultiblockFrameSidePanel, null, modelMultiblockFrameTower }));
		ConfigRenderers.setRendererBlockMachineFrameID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getRendererBlockMachineFrameID(), new TileEntityMachineFrame()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMultiblockWeldingStation.class, new RendererMultiblock(IndustrialProcessing.blockMultiblockWeldingStation, new String[] { "ModelMultiblockWeldingStation" }, new ModelMultiblock[] { modelMultiblockWeldingStation }));
		ConfigRenderers.setrendererBlockMultiblockWeldingStationID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererBlockMultiblockWeldingStationID(), new TileEntityMultiblockWeldingStation()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMultiblockWeldingStationRight.class, new RendererMultiblock(IndustrialProcessing.blockMultiblockWeldingStationRight, new String[] { "ModelMultiblockWeldingStation" }, new ModelMultiblock[] { modelMultiblockWeldingStation }));
		ConfigRenderers.setrendererBlockMultiblockWeldingStationRightID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererBlockMultiblockWeldingStationRightID(), new TileEntityMultiblockWeldingStationRight()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMultiblockWeldingStationScreen.class, new RendererMultiblock(IndustrialProcessing.blockMultiblockWeldingStationScreen, new String[] { "ModelMultiblockWeldingStationScreen" }, new ModelMultiblock[] { modelMultiblockWeldingStationScreen }));
		ConfigRenderers.setrendererBlockMultiblockWeldingStationScreenID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getrendererBlockMultiblockWeldingStationScreenID(), new TileEntityMultiblockWeldingStationScreen()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWeldingStation.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWeldingStation, new String[] { "ModelMultiblockWeldingStation" }, new ModelingMultiblock[] { MDmultiblockWeldingStation }));
		ConfigRenderers.setBLmultiblockWeldingStation(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingStation(), new TEmultiblockWeldingStation()));
	}
}
