package mod.industrialProcessing.items;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.plants.logic.adaptor.TileEntityInterfaceAdaptor;
import mod.industrialProcessing.plants.logic.wire.cable.TileEntityLogicCable;
import mod.industrialProcessing.plants.logic.wire.cable.model.ModelCable;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import mod.industrialProcessing.utils.registry.MicroBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class ConfigItems {

	public static void registerItems() {
		ItemRegistry.registerItem(ISetupItems.itemIronBracket, "IP.item.ironBracket");
		ItemRegistry.registerItem(ISetupItems.paintBrush, "IP.item.paintBrush");
		ItemRegistry.registerItem(ISetupItems.itemCopperBar, "IP.item.copperBar");
		ItemRegistry.registerItem(ISetupItems.itemIronBowl, "IP.item.ironBowl");
		ItemRegistry.registerItem(ISetupItems.itemRemote, "IP.item.remote");
		ItemRegistry.registerItem(ISetupItems.itemTurbineBlades, "IP.item.turbineBlades");
		ItemRegistry.registerItem(ISetupItems.itemIronBlade, "IP.item.ironBlade");
		ItemRegistry.registerItem(ISetupItems.itemLeadIngot, "IP.item.leadIngot");
		ItemRegistry.registerItem(ISetupItems.itemFilterTray, "IP.item.filterTray");
		ItemRegistry.registerItem(ISetupItems.itemMotorPoleAxis, "IP.item.magneticPoles");
		ItemRegistry.registerItem(ISetupItems.itemSmallEngine, "IP.item.smallEngine");
		ItemRegistry.registerItem(ISetupItems.itemGuide, "IP.item.guide");
		ItemRegistry.registerItem(ISetupItems.itemRedstoneCircuitry, "IP.item.redstoneCircuitry");
		ItemRegistry.registerItem(ISetupItems.itemSolderAlloyIngot, "IP.item.solderAlloyIngot");
		ItemRegistry.registerItem(ISetupItems.itemSolderAlloyWire, "IP.item.solderAlloyWire");
		ItemRegistry.registerItem(ISetupItems.itemnhardenedIsolationBoard, "IP.item.unhardenedIsolationBoard");
		ItemRegistry.registerItem(ISetupItems.itemFiberGlass, "IP.item.fiberGlass");
		ItemRegistry.registerItem(ISetupItems.itemAluminumDust, "IP.item.aluminumDust");
		ItemRegistry.registerItem(ISetupItems.itemHardenedSandDust, "IP.item.hardenedSandDust");
		ItemRegistry.registerItem(ISetupItems.itemCopperBoard, "IP.item.copperBoard");
		ItemRegistry.registerItem(ISetupItems.itemElectricComponents, "IP.item.electronicComponents");
		ItemRegistry.registerItem(ISetupItems.itemIsolationBoard, "IP.item.isolationBoard");
		ItemRegistry.registerItem(ISetupItems.itemPCBoard, "IP.item.pcb");
		ItemRegistry.registerItem(ISetupItems.itemPCBoardWired, "IP.item.pcbCircuit");
		ItemRegistry.registerItem(ISetupItems.itemSolder, "IP.item.solder");
		ItemRegistry.registerItem(ISetupItems.itemSolderEmpty, "IP.item.emptySolderRing");
		ItemRegistry.registerItem(ISetupItems.itemSolderingIron, "IP.item.solderingIron");
		ItemRegistry.registerItem(ISetupItems.itemStripBoard, "IP.item.stripBoard");
		ItemRegistry.registerItem(ISetupItems.itemStripBoardWired, "IP.item.stripboardCircuit");
		ItemRegistry.registerItem(ISetupItems.itemCopperPlate, "IP.item.copperPlate");
		ItemRegistry.registerItem(ISetupItems.itemCastingMulsh, "IP.item.castingMulsh");
		ItemRegistry.registerItem(ISetupItems.itemSandCast, "IP.item.sandCast");
		ItemRegistry.registerItem(ISetupItems.itemSandCastIngot, "IP.item.sandCastIngot");
		ItemRegistry.registerItem(ISetupItems.itemFlask, "IP.item.flask");
		ItemRegistry.registerItem(ISetupItems.itemCokePellet, "IP.item.cokePellet");
		ItemRegistry.registerItem(ISetupItems.itemLimestoneDust, "IP.item.limestoneDust");
		ItemRegistry.registerItem(ISetupItems.itemScreen, "IP.item.screen");
		ItemRegistry.registerItem(ISetupItems.itemFrame, "IP.item.frame");
		ItemRegistry.registerItem(ISetupItems.itemWovenPatern, "IP.item.wovenPattern");
		ItemRegistry.registerItem(ISetupItems.itemMixingHook, "IP.item.mixingHook");
		ItemRegistry.registerItem(ISetupItems.itemHeatingElement, "IP.item.heatingElement");
		ItemRegistry.registerItem(ISetupItems.itemTumbler, "IP.item.tumbler");
		ItemRegistry.registerItem(ISetupItems.itemRakeArm, "IP.item.rakeArm");
		ItemRegistry.registerItem(ISetupItems.itemDisk, "IP.item.disk");
		ItemRegistry.registerItem(ISetupItems.itemPestle, "IP.item.pestle");
		ItemRegistry.registerItem(ISetupItems.itemDrawPlate, "IP.item.drawPlate");
		ItemRegistry.registerItem(ISetupItems.itemSlipRing, "IP.item.slipRing");
		ItemRegistry.registerItem(ISetupItems.itemCarbonBrush, "IP.item.carbonBrush");
		ItemRegistry.registerItem(ISetupItems.itemIronT, "IP.item.ironTShape");
		ItemRegistry.registerItem(ISetupItems.itemIronRod, "IP.item.ironRod");
		ItemRegistry.registerItem(ISetupItems.itemIronBar, "IP.item.ironBar");
		ItemRegistry.registerItem(ISetupItems.itemMotorStator, "IP.item.motorStator");
		ItemRegistry.registerItem(ISetupItems.itemMotorRotor, "IP.item.motorRotor");
		ItemRegistry.registerItem(ISetupItems.itemMotorFrame, "IP.item.motorFrame");
		ItemRegistry.registerItem(ISetupItems.itemElectroMagnet, "IP.item.electroMagnet");
		ItemRegistry.registerItem(ISetupItems.itemCopperWireInsulated, "IP.item.insulatedCopperWire");
		ItemRegistry.registerItem(ISetupItems.itemCopperCoil, "IP.item.copperCoil");
		ItemRegistry.registerItem(ISetupItems.itemCopperWire, "IP.item.copperWire");
		ItemRegistry.registerItem(ISetupItems.itemCrankWheel, "IP.item.crankWheel");
		ItemRegistry.registerItem(ISetupItems.itemCopperIngot, "IP.item.copperIngot");
		ItemRegistry.registerItem(ISetupItems.itemTinIngot, "IP.item.tinIngot");
		ItemRegistry.registerItem(ISetupItems.itemSilverIngot, "IP.item.silverIngot");
		ItemRegistry.registerItem(ISetupItems.itemCinnebarSmallCrushedCrystals, "IP.item.smallCrushedCinnebarCrystals");
		ItemRegistry.registerItem(ISetupItems.itemCinnebarLargeCrushedCrystals, "IP.item.largeCrushedCinnebarCrystals");
		ItemRegistry.registerItem(ISetupItems.itemActiveCoal, "IP.item.activatedCoal");
		ItemRegistry.registerItem(ISetupItems.itemCoalDust, "IP.item.coalDust");
		ItemRegistry.registerItem(ISetupItems.itemGrownCulture, "IP.item.grownCulture");
		ItemRegistry.registerItem(ISetupItems.itemWrench, "IP.item.wrench");
		ItemRegistry.registerItem(ISetupItems.itemBattery, "IP.item.battery");
		ItemRegistry.registerItem(ISetupItems.itemHexKey, "IP.item.hexKey");
		ItemRegistry.registerItem(ISetupItems.itemSmallMachineCasing, "IP.item.smallMachineCasing");
		ItemRegistry.registerItem(ISetupItems.itemInputPort, "IP.item.inputPort");
		ItemRegistry.registerItem(ISetupItems.itemOutputPort, "IP.item.outputPort");
		ItemRegistry.registerItem(ISetupItems.itemPowerPort, "IP.item.powerPort");
		ItemRegistry.registerItem(ISetupItems.itemCrusingPlate, "IP.item.crushingPlate");
		ItemRegistry.registerItem(ISetupItems.itemIronPlate, "IP.item.ironPlate");
		ItemRegistry.registerItem(ISetupItems.itemIronTips, "IP.item.ironTips");
		ItemRegistry.registerItem(ISetupItems.itemSmallMachineCasingCrusher, "IP.item.crusherMachineCase");
		ItemRegistry.registerItem(ISetupItems.itemIronLargeChunks, "IP.item.largeIronChunks");
		ItemRegistry.registerItem(ISetupItems.itemCopperLargeChunks, "IP.item.largeCopperChunks");
		ItemRegistry.registerItem(ISetupItems.itemTinLargeChunks, "IP.item.largeTinChunks");
		ItemRegistry.registerItem(ISetupItems.itemIronSmallChunks, "IP.item.smallIronChunks");
		ItemRegistry.registerItem(ISetupItems.itemCopperSmallChunks, "IP.item.smallCopperChunks");
		ItemRegistry.registerItem(ISetupItems.itemTinSmallChunks, "IP.item.smallTinChunks");
		ItemRegistry.registerItem(ISetupItems.itemIronCrushedChunks, "IP.item.crushedIronChunks");
		ItemRegistry.registerItem(ISetupItems.itemCopperCrushedChunks, "IP.item.crushedCopperChunks");
		ItemRegistry.registerItem(ISetupItems.itemTinCrushedChunks, "IP.item.crushedTinChunks");
		ItemRegistry.registerItem(ISetupItems.itemIronWashedChunks, "IP.item.washedIronChunks");
		ItemRegistry.registerItem(ISetupItems.itemCopperWashedChunks, "IP.item.washedCopperChunks");
		ItemRegistry.registerItem(ISetupItems.itemTinWashedChunks, "IP.item.washedTinChunks");
		ItemRegistry.registerItem(ISetupItems.itemIronFineChunks, "IP.item.fineIronChunks");
		ItemRegistry.registerItem(ISetupItems.itemCopperFineChunks, "IP.item.fineCopperChunks");
		ItemRegistry.registerItem(ISetupItems.itemTinFineChunks, "IP.item.fineTinChunks");
		ItemRegistry.registerItem(ISetupItems.itemIronOxideDust, "IP.item.ironOxideDust");
		ItemRegistry.registerItem(ISetupItems.itemCopperMineral, "IP.item.CopperMineral");
		ItemRegistry.registerItem(ISetupItems.itemTinOxideDust, "IP.item.tinOxideDust");
		ItemRegistry.registerItem(ISetupItems.itemIronMixedFragments, "IP.item.ironMixedFragments");
		ItemRegistry.registerItem(ISetupItems.itemCopperMixedFragments, "IP.item.copperMixedFragments");
		ItemRegistry.registerItem(ISetupItems.itemTinMixedFragments, "IP.item.tinMixedFragments");
		ItemRegistry.registerItem(ISetupItems.itemSilicium, "IP.item.silicium");
		ItemRegistry.registerItem(ISetupItems.itemZincDust, "IP.item.zincDust");
		ItemRegistry.registerItem(ISetupItems.itemCopperPurified, "IP.item.purifiedCopper");
		ItemRegistry.registerItem(ISetupItems.itemTinPurified, "IP.item.purifiedTin");
		ItemRegistry.registerItem(ISetupItems.itemSulfur, "IP.item.sulfur");
		ItemRegistry.registerItem(ISetupItems.itemThickStick, "IP.item.thickStick");
		ItemRegistry.registerItem(ISetupItems.itemHammer, "IP.item.hammer");
		ItemRegistry.registerItem(ISetupItems.itemKnife, "IP.item.knife");
		ItemRegistry.registerItem(ISetupItems.itemBlowingTorch, "IP.item.blowTorch");
		ItemRegistry.registerItem(ISetupItems.itemIronSinter, "IP.item.ironSinter");
		ItemRegistry.registerItem(ISetupItems.itemCalcareousSinterDust, "IP.item.calcareousSinterDust");
		ItemRegistry.registerItem(ISetupItems.itemCokes, "IP.item.cokes");
		ItemRegistry.registerItem(ISetupItems.itemSlag, "IP.item.slag");
		ItemRegistry.registerItem(ISetupItems.itemLeadBowl, "IP.item.leadBowl");
		ItemRegistry.registerItem(ISetupItems.itemLeadDust, "IP.item.leadDust");

		ItemRegistry.registerItem(ISetupItems.itemWroughtIron, "IP.item.WroughtIron");
		ItemRegistry.registerItem(ISetupItems.itemPliers, "IP.item.Pliers");
		ItemRegistry.registerItem(ISetupItems.itemPliersHeatedIron, "IP.item.PliersHeatedIron");
		ItemRegistry.registerItem(ISetupItems.itemPliersBloomIron, "IP.item.PliersBloomIron");
		ItemRegistry.registerItem(ISetupItems.itemHeatedCopper, "IP.item.heatedCopper");
		ItemRegistry.registerItem(ISetupItems.itemPliersHeatedCopper, "IP.item.PliersHeatedCopper");

		ItemRegistry.registerItem(ISetupItems.itemWoodenBucket, "IP.item.woodenBucket");
		ItemRegistry.registerItem(ISetupItems.itemWoodenBucketWater, "IP.item.woodenBucketWater");
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(IndustrialProcessing.itemWoodenBucketWater), new ItemStack(IndustrialProcessing.itemWoodenBucket));

		MicroBlockRegistry.registerMicroBlock(ISetupItems.itemCable, "IP.micro.cable", TileEntityLogicCable.class, new ModelCable());
		MicroBlockRegistry.registerMicroBlock(ISetupItems.itemInterfaceAdaptor, "IP.micro.interfaceAdaptor", TileEntityInterfaceAdaptor.class, new ModelCable());

	}

	private ConfigItems() {

	}

	private static ConfigItems instance = new ConfigItems();

	public static ConfigItems getInstance() {
		return instance;
	}

}
