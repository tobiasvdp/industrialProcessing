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
import ip.industrialProcessing.multiblock.core.block.weldingStation.MDmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
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
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.frame.MDmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.frame.TEmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.screen.MDmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.screen.TEmultiblockScreen;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.MDmultiblockWeldingTableExt;
import ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.TEmultiblockWeldingTableExt;

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
	private static final MDmultiblockWeldingStation MDmultiblockWeldingStation = new MDmultiblockWeldingStation();
	private static final MDmultiblockScreen MDmultiblockScreen = new MDmultiblockScreen();
	private static final MDmultiblockFrame MDmultiblockFrame = new MDmultiblockFrame();
	private static final MDmultiblockWeldingTableExt MDmultiblockWeldingTableExt = new MDmultiblockWeldingTableExt();
	
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
		
		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWeldingStation.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWeldingStation, new String[] { "ModelMultiblockWeldingStation" }, new ModelingMultiblock[] { MDmultiblockWeldingStation }));
		ConfigRenderers.setBLmultiblockWeldingStation(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingStation(), new TEmultiblockWeldingStation()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockScreen.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockScreen, new String[] { "ModelMultiblockScreen" }, new ModelingMultiblock[] { MDmultiblockScreen }));
		ConfigRenderers.setBLmultiblockScreen(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockScreen(), new TEmultiblockScreen()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockFrame.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockFrame, new String[] { "ModelMultiblockFrame" }, new ModelingMultiblock[] { MDmultiblockFrame }));
		ConfigRenderers.setBLmultiblockFrame(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockFrame(), new TEmultiblockFrame()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TEmultiblockWeldingTableExt.class, new RenderingMultiblock(IndustrialProcessing.BLmultiblockWeldingTableExt, new String[] { "ModelMultiblockWeldingStation" }, new ModelingMultiblock[] { MDmultiblockWeldingTableExt }));
		ConfigRenderers.setBLmultiblockWeldingTableExt(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(ConfigRenderers.getBLmultiblockWeldingTableExt(), new TEmultiblockWeldingTableExt()));
	}
}
