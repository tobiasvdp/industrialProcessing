package mod.industrialProcessing.items;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.items.guide.ItemGuide;
import mod.industrialProcessing.logic.wire.cable.TileEntityCable;
import mod.industrialProcessing.microBlock.MicroBlockType;
import mod.industrialProcessing.microBlock.test.TileEntityTestMicroblock;
import net.minecraft.init.Blocks;

public interface ISetupItems {

	// processing
	public final static ItemIP itemIronLargeChunks = new ItemIP();
	public final static ItemIP itemCopperLargeChunks = new ItemIP();
	public final static ItemIP itemTinLargeChunks = new ItemIP();
	public final static ItemIP itemIronSmallChunks = new ItemIP();
	public final static ItemIP itemCopperSmallChunks = new ItemIP();
	public final static ItemIP itemTinSmallChunks = new ItemIP();
	public final static ItemIP itemIronCrushedChunks = new ItemIP();
	public final static ItemIP itemCopperCrushedChunks = new ItemIP();
	public final static ItemIP itemTinCrushedChunks = new ItemIP();
	public final static ItemIP itemIronWashedChunks = new ItemIP();
	public final static ItemIP itemCopperWashedChunks = new ItemIP();
	public final static ItemIP itemTinWashedChunks = new ItemIP();
	public final static ItemIP itemIronFineChunks = new ItemIP();
	public final static ItemIP itemCopperFineChunks = new ItemIP();
	public final static ItemIP itemTinFineChunks = new ItemIP();
	public final static ItemIP itemIronOxideDust = new ItemIP();
	public final static ItemIP itemCopperMineral = new ItemIP();
	public final static ItemIP itemTinOxideDust = new ItemIP();
	public final static ItemIP itemIronMixedFragments = new ItemIP();
	public final static ItemIP itemCopperMixedFragments = new ItemIP();
	public final static ItemIP itemTinMixedFragments = new ItemIP();
	public final static ItemIP itemCopperPurified = new ItemIP();
	public final static ItemIP itemSilicium = new ItemIP();
	public final static ItemIP itemZincDust = new ItemIP();
	public final static ItemIP itemTinPurified = new ItemIP();
	public final static ItemIP itemSulfur = new ItemIP();
	public final static ItemIP itemSmallMachineCasing = new ItemIP();
	public final static ItemIP itemInputPort = new ItemIP();
	public final static ItemIP itemOutputPort = new ItemIP();
	public final static ItemIP itemPowerPort = new ItemIP();
	public final static ItemIP itemCrusingPlate = new ItemIP();
	public final static ItemIP itemIronPlate = new ItemIP();
	public final static ItemIP itemIronTips = new ItemIP();
	public final static ItemIP itemSmallMachineCasingCrusher = new ItemIP();
	public final static ItemIP itemFiberGlass = new ItemIP();

	public final static ItemIP itemGalenaCrushedChunks = new ItemIP();
	public final static ItemIP itemGalenaSmallChunks = new ItemIP();
	public final static ItemIP itemGalenaLargeChunks = new ItemIP();
	public final static ItemIP itemGalenaFineChunks = new ItemIP();
	public final static ItemIP itemGalenaWashedChunks = new ItemIP();
	public final static ItemIP itemSilverDust = new ItemIP();
	public final static ItemIP itemLeadDust = new ItemIP();

	public final static ItemIP itemChromiteCrushedChunks = new ItemIP();
	public final static ItemIP itemChromiteSmallChunks = new ItemIP();
	public final static ItemIP itemChromiteLargeChunks = new ItemIP();
	public final static ItemIP itemChromiteFineChunks = new ItemIP();
	public final static ItemIP itemChromiteWashedChunks = new ItemIP();
	public final static ItemIP itemChromiteDust = new ItemIP();

	public final static ItemIP itemTaliaCrushedChunks = new ItemIP();
	public final static ItemIP itemTaliaSmallChunks = new ItemIP();
	public final static ItemIP itemTaliaLargeChunks = new ItemIP();
	public final static ItemIP itemTaliaFineChunks = new ItemIP();
	public final static ItemIP itemTaliaWashedChunks = new ItemIP();
	public final static ItemIP itemTaliaDust = new ItemIP();

	public final static ItemIP itemGoldCrushedChunks = new ItemIP();
	public final static ItemIP itemGoldSmallChunks = new ItemIP();
	public final static ItemIP itemGoldLargeChunks = new ItemIP();
	public final static ItemIP itemGoldFineChunks = new ItemIP();
	public final static ItemIP itemGoldWashedChunks = new ItemIP();
	public final static ItemIP itemGoldDust = new ItemIP();

	public final static ItemIP itemCinnebarCrystals = new ItemIP();
	public final static ItemIP itemCinnebarLargeCrushedCrystals = new ItemIP();
	public final static ItemIP itemCinnebarSmallCrushedCrystals = new ItemIP();
	public final static ItemIP itemCinnebarFineCrushedCrystals = new ItemIP();
	public final static ItemIP itemCinnebarDust = new ItemIP();

	public final static ItemIP itemRutileCrystals = new ItemIP();
	public final static ItemIP itemRutileLargeCrushedCrystals = new ItemIP();
	public final static ItemIP itemRutileSmallCrushedCrystals = new ItemIP();
	public final static ItemIP itemRutileFineCrushedCrystals = new ItemIP();
	public final static ItemIP itemRutileDust = new ItemIP();
	public final static ItemIP itemCoalDust = new ItemIP();
	public final static ItemIP itemHardenedSandDust = new ItemIP();
	public final static ItemIP itemAluminumDust = new ItemIP();

	public final static ItemIP itemThickStick = new ItemIP();
	public final static ItemDamage itemHammer = new ItemDamage();
	public final static ItemDamage itemKnife = new ItemDamage();
	public final static ItemDamage itemBlowingTorch = new ItemDamage();

	// Iron blast furnace
	public final static ItemIP itemCalcareousSinterDust = new ItemIP();
	public final static ItemIP itemCokes = new ItemIP();
	public final static ItemIP itemCokePellet = new ItemIP();
	public final static ItemIP itemSlag = new ItemIP();

	public final static ItemIP itemHexKey = new ItemIP();
	public final static ItemWrench itemWrench = new ItemWrench();
	public final static ItemBattery itemBattery = new ItemBattery();
	public final static ItemIP itemAsh = new ItemIP();

	public final static ItemGuide itemGuide = new ItemGuide("itemGuide", IndustrialProcessing.tabMachineParts);

	public final static ItemDamage itemGrownCulture = new ItemDamage(20);
	public final static ItemDamage itemActiveCoal = new ItemDamage(25);

	public final static ItemPaintBrush paintBrushWhite = new ItemPaintBrush(0);
	public final static ItemPaintBrush paintBrushOrange = new ItemPaintBrush(1);
	public final static ItemPaintBrush paintBrushMagenta = new ItemPaintBrush(2);
	public final static ItemPaintBrush paintBrushLightBlue = new ItemPaintBrush(3);
	public final static ItemPaintBrush paintBrushYellow = new ItemPaintBrush(4);
	public final static ItemPaintBrush paintBrushLime = new ItemPaintBrush(5);
	public final static ItemPaintBrush paintBrushPink = new ItemPaintBrush(6);
	public final static ItemPaintBrush paintBrushGray = new ItemPaintBrush(7);
	public final static ItemPaintBrush paintBrushLightGray = new ItemPaintBrush(8);
	public final static ItemPaintBrush paintBrushCyan = new ItemPaintBrush(9);
	public final static ItemPaintBrush paintBrushPurple = new ItemPaintBrush(10);
	public final static ItemPaintBrush paintBrushBlue = new ItemPaintBrush( 11);
	public final static ItemPaintBrush paintBrushBrown = new ItemPaintBrush(12);
	public final static ItemPaintBrush paintBrushGreen = new ItemPaintBrush(13);
	public final static ItemPaintBrush paintBrushRed = new ItemPaintBrush(14);
	public final static ItemPaintBrush paintBrushBlack = new ItemPaintBrush(15);
	public final static ItemIP paintBrush = new ItemIP();

	public final static ItemIP itemCopperIngot = new ItemIP();
	public final static ItemIP itemTinIngot = new ItemIP();
	public final static ItemIP itemSilverIngot = new ItemIP();

	public final static ItemIP itemCopperWire = new ItemIP();
	public final static ItemIP itemCopperWireInsulated = new ItemIP();
	public final static ItemIP itemCopperCoil = new ItemIP();
	public final static ItemIP itemElectroMagnet = new ItemIP();
	public final static ItemIP itemMotorFrame = new ItemIP();
	public final static ItemIP itemMotorStator = new ItemIP();
	public final static ItemIP itemMotorRotor = new ItemIP();
	public final static ItemIP itemMotorPoleAxis = new ItemIP();

	public final static ItemIP itemCrankWheel = new ItemIP();
	public final static ItemIP itemIronBar = new ItemIP();
	public final static ItemIP itemIronRod = new ItemIP();
	public final static ItemIP itemIronT = new ItemIP();
	public final static ItemIP itemCarbonBrush = new ItemIP();
	public final static ItemIP itemSlipRing = new ItemIP();
	public final static ItemDamage itemIronBowl = new ItemDamage(8);
	public final static ItemIP itemIronBracket = new ItemIP();
	public final static ItemDamage itemDrawPlate = new ItemDamage(8);
	public final static ItemDamage itemPestle = new ItemDamage(3);

	public final static ItemIP itemScreen = new ItemIP();
	public final static ItemIP itemFrame = new ItemIP();
	public final static ItemIP itemWovenPatern = new ItemIP();
	public final static ItemIP itemMixingHook = new ItemIP();
	public final static ItemIP itemHeatingElement = new ItemIP();
	public final static ItemIP itemTumbler = new ItemIP();
	public final static ItemIP itemRakeArm = new ItemIP();
	public final static ItemIP itemDisk = new ItemIP();

	public final static ItemIP itemTaliaMixedFragments = new ItemIP();
	public final static ItemIP itemGoldMixedFragments = new ItemIP();
	public final static ItemIP itemGalenaMixedFragments = new ItemIP();
	public final static ItemIP itemChromiteMixedFragments = new ItemIP();

	public final static ItemIP itemLimestoneDust = new ItemIP();
	public final static ItemIP itemIronSinter = new ItemIP();

	public final static ItemIP itemFlask = new ItemIP();
	public final static ItemIP itemCastingMulsh = new ItemIP();
	public final static ItemIP itemSandCast = new ItemIP();
	public final static ItemDamage itemSandCastIngot = new ItemDamage(32);

	public final static ItemIP itemCopperPlate = new ItemIP();

	public final static ItemIP itemCopperBoard = new ItemIP();
	public final static ItemIP itemElectricComponents = new ItemIP();
	public final static ItemIP itemnhardenedIsolationBoard = new ItemIP();
	public final static ItemIP itemIsolationBoard = new ItemIP();
	public final static ItemIP itemPCBoard = new ItemIP();
	public final static ItemIP itemPCBoardWired = new ItemIP();
	public final static ItemDamage itemSolder = new ItemDamage(64);
	public final static ItemIP itemSolderEmpty = new ItemIP();
	public final static ItemIP itemSolderingIron = new ItemIP();
	public final static ItemIP itemStripBoard = new ItemIP();
	public final static ItemIP itemStripBoardWired = new ItemIP();
	public final static ItemIP itemSolderAlloyWire = new ItemIP();
	public final static ItemIP itemSolderAlloyIngot = new ItemIP();
	public final static ItemIP itemRedstoneCircuitry = new ItemIP();
	public final static ItemIP itemSmallEngine = new ItemIP();
	public final static ItemIP itemCopperBar = new ItemIP();
	public final static ItemIP itemFilterTray = new ItemIP();

	public final static ItemIP itemLeadIngot = new ItemIP();
	public final static ItemIP itemLeadBowl = new ItemIP();
	public final static ItemIP itemIronBlade = new ItemIP();
	public final static ItemIP itemTurbineBlades = new ItemIP();
	public final static ItemRemote itemRemote = new ItemRemote();
	
	public final static ItemIP itemWroughtIron = new ItemIP();
	public final static ItemIP itemPliers = (ItemIP) new ItemIP().setMaxStackSize(1);
	public final static ItemIP itemPliersHeatedIron = (ItemIP) new ItemIP().setMaxStackSize(1);
	public final static ItemIP itemPliersBloomIron = (ItemIP) new ItemIP().setMaxStackSize(1);
	
	public final static ItemIP itemHeatedCopper = new ItemIP();
	public final static ItemIP itemPliersHeatedCopper = new ItemIP();
	
	public final static ItemWoodenBucket itemWoodenBucket = (ItemWoodenBucket) new ItemWoodenBucket(null);
	public final static ItemWoodenBucketFilled itemWoodenBucketWater = new ItemWoodenBucketFilled(Blocks.water);
	
	public final static ItemMicroBlock itemCable = new ItemMicroBlock();
	public final static ItemMicroBlock itemTest = new ItemMicroBlock();
}
