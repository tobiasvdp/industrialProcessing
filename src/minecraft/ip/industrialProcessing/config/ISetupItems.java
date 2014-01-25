package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.items.ItemBattery;
import ip.industrialProcessing.items.ItemDamage;
import ip.industrialProcessing.items.ItemIP;
import ip.industrialProcessing.items.ItemPaintBrush;
import ip.industrialProcessing.items.ItemRemote;
import ip.industrialProcessing.items.ItemSuspendedCart;
import ip.industrialProcessing.items.ItemWrench;
import ip.industrialProcessing.items.guide.ItemGuide;

public interface ISetupItems {
	
	//processing
    public final static ItemIP itemIronLargeChunks = new ItemIP(ConfigItems.ItemIronLargeChunksID(), "ItemIronLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperLargeChunks = new ItemIP(ConfigItems.ItemCopperLargeChunksID(), "ItemCopperLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinLargeChunks = new ItemIP(ConfigItems.ItemTinLargeChunksID(), "ItemTinLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronSmallChunks = new ItemIP(ConfigItems.ItemIronSmallChunksID(), "ItemIronSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperSmallChunks = new ItemIP(ConfigItems.ItemCopperSmallChunksID(), "ItemCopperSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinSmallChunks = new ItemIP(ConfigItems.ItemTinSmallChunksID(), "ItemTinSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronCrushedChunks = new ItemIP(ConfigItems.ItemIronCrushedChunksID(), "ItemIronCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperCrushedChunks = new ItemIP(ConfigItems.ItemCopperCrushedChunksID(), "ItemCopperCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinCrushedChunks = new ItemIP(ConfigItems.ItemTinCrushedChunksID(), "ItemTinCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronWashedChunks = new ItemIP(ConfigItems.ItemIronWashedChunksID(), "itemIronWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperWashedChunks = new ItemIP(ConfigItems.ItemCopperWashedChunksID(), "ItemCopperWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinWashedChunks = new ItemIP(ConfigItems.ItemTinWashedChunksID(), "ItemTinWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronFineChunks = new ItemIP(ConfigItems.ItemIronFineChunksID(), "ItemIronFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperFineChunks = new ItemIP(ConfigItems.ItemCopperFineChunksID(), "ItemCopperFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinFineChunks = new ItemIP(ConfigItems.ItemTinFineChunksID(), "ItemTinFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronOxideDust = new ItemIP(ConfigItems.ItemIronOxideDustID(), "ItemIronOxideDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperMineral = new ItemIP(ConfigItems.ItemCopperMineralID(), "ItemCopperMineral",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinOxideDust = new ItemIP(ConfigItems.ItemTinOxideDustID(), "ItemTinOxideDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronMixedFragments = new ItemIP(ConfigItems.ItemIronMixedFragmentsID(), "ItemIronMixedFragments",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperMixedFragments = new ItemIP(ConfigItems.ItemCopperMixedFragmentsID(), "ItemCopperMixedFragments",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinMixedFragments = new ItemIP(ConfigItems.ItemTinMixedFragmentsID(), "ItemTinMixedFragments",IndustrialProcessing.tabOres);
    public final static ItemIP itemCopperPurified = new ItemIP(ConfigItems.ItemCopperPurifiedID(), "ItemCopperPurified",IndustrialProcessing.tabOres);
    public final static ItemIP itemSilicium = new ItemIP(ConfigItems.ItemSiliciumID(), "ItemSilicium",IndustrialProcessing.tabOres);
    public final static ItemIP itemZincDust = new ItemIP(ConfigItems.ItemZincDustID(), "ItemZincDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinPurified = new ItemIP(ConfigItems.ItemTinPurifiedID(), "ItemTinPurified",IndustrialProcessing.tabOres);
    public final static ItemIP itemSulfur = new ItemIP(ConfigItems.ItemSulfurID(), "ItemSulfur",IndustrialProcessing.tabOres);
    public final static ItemIP itemSmallMachineCasing = new ItemIP(ConfigItems.ItemSmallMachineCasingID(), "itemSmallMachineCasing",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemInputPort = new ItemIP(ConfigItems.ItemInputPortID(), "itemInputPort",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemOutputPort = new ItemIP(ConfigItems.ItemOutputPortID(), "itemOutputPort",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemPowerPort = new ItemIP(ConfigItems.ItemPowerPortID(), "itemPowerPort",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemCrusingPlate = new ItemIP(ConfigItems.ItemCrusingPlateID(), "itemCrusingPlate",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemIronPlate = new ItemIP(ConfigItems.ItemIronPlateID(), "itemIronPlate",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemIronTips = new ItemIP(ConfigItems.ItemIronTipsID(), "itemIronTips",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSmallMachineCasingCrusher = new ItemIP(ConfigItems.ItemSmallMachineCasingCrusherID(), "itemSmallMachineCasingCrusher",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemFiberGlass = new ItemIP(ConfigItems.ItemFiberGlassID(), "itemFiberGlass",IndustrialProcessing.tabMachineParts);
    
    public final static ItemIP itemGalenaCrushedChunks = new ItemIP(ConfigItems.itemGalenaCrushedChunksID(), "itemGalenaCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGalenaSmallChunks = new ItemIP(ConfigItems.itemGalenaSmallChunksID(), "itemGalenaSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGalenaLargeChunks = new ItemIP(ConfigItems.itemGalenaLargeChunksID(), "itemGalenaLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGalenaFineChunks = new ItemIP(ConfigItems.itemGalenaFineChunksID(), "itemGalenaFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGalenaWashedChunks = new ItemIP(ConfigItems.itemGalenaWashedChunksID(), "itemGalenaWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemSilverDust = new ItemIP(ConfigItems.itemSilverDustID(), "itemSilverDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemLeadDust = new ItemIP(ConfigItems.itemLeadDustID(), "itemLeadDust",IndustrialProcessing.tabOres);

    public final static ItemIP itemChromiteCrushedChunks = new ItemIP(ConfigItems.itemChromiteCrushedChunksID(), "itemChromiteCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemChromiteSmallChunks = new ItemIP(ConfigItems.itemChromiteSmallChunksID(), "itemChromiteSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemChromiteLargeChunks = new ItemIP(ConfigItems.itemChromiteLargeChunksID(), "itemChromiteLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemChromiteFineChunks = new ItemIP(ConfigItems.itemChromiteFineChunksID(), "itemChromiteFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemChromiteWashedChunks = new ItemIP(ConfigItems.itemChromiteWashedChunksID(), "itemChromiteWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemChromiteDust = new ItemIP(ConfigItems.itemChromiteDustID(), "itemChromiteDust",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemTaliaCrushedChunks = new ItemIP(ConfigItems.itemTaliaCrushedChunksID(), "itemTaliaCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTaliaSmallChunks = new ItemIP(ConfigItems.itemTaliaSmallChunksID(), "itemTaliaSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTaliaLargeChunks = new ItemIP(ConfigItems.itemTaliaLargeChunksID(), "itemTaliaLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTaliaFineChunks = new ItemIP(ConfigItems.itemTaliaFineChunksID(), "itemTaliaFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTaliaWashedChunks = new ItemIP(ConfigItems.itemTaliaWashedChunksID(), "itemTaliaWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemTaliaDust = new ItemIP(ConfigItems.itemTaliaDustID(), "itemTaliaDust",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemGoldCrushedChunks = new ItemIP(ConfigItems.itemGoldCrushedChunksID(), "itemGoldCrushedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGoldSmallChunks = new ItemIP(ConfigItems.itemGoldSmallChunksID(), "itemGoldSmallChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGoldLargeChunks = new ItemIP(ConfigItems.itemGoldLargeChunksID(), "itemGoldLargeChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGoldFineChunks = new ItemIP(ConfigItems.itemGoldFineChunksID(), "itemGoldFineChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGoldWashedChunks = new ItemIP(ConfigItems.itemGoldWashedChunksID(), "itemGoldWashedChunks",IndustrialProcessing.tabOres);
    public final static ItemIP itemGoldDust = new ItemIP(ConfigItems.itemGoldDustID(), "itemGoldDust",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemCinnebarCrystals = new ItemIP(ConfigItems.itemCinnebarCrystalsID(), "itemCinnebarCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemCinnebarLargeCrushedCrystals = new ItemIP(ConfigItems.itemCinnebarLargeCrushedCrystalsID(), "itemCinnebarLargeCrushedCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemCinnebarSmallCrushedCrystals = new ItemIP(ConfigItems.itemCinnebarSmallCrushedCrystalsID(), "itemCinnebarSmallCrushedCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemCinnebarFineCrushedCrystals = new ItemIP(ConfigItems.itemCinnebarFineCrushedCrystalsID(), "itemCinnebarFineCrushedCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemCinnebarDust = new ItemIP(ConfigItems.itemCinnebarDustID(), "itemCinnebarDust",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemRutileCrystals = new ItemIP(ConfigItems.itemRutileCrystalsID(), "itemRutileCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemRutileLargeCrushedCrystals = new ItemIP(ConfigItems.itemRutileLargeCrushedCrystalsID(), "itemRutileLargeCrushedCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemRutileSmallCrushedCrystals = new ItemIP(ConfigItems.itemRutileSmallCrushedCrystalsID(), "itemRutileSmallCrushedCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemRutileFineCrushedCrystals = new ItemIP(ConfigItems.itemRutileFineCrushedCrystalsID(), "itemRutileFineCrushedCrystals",IndustrialProcessing.tabOres);
    public final static ItemIP itemRutileDust = new ItemIP(ConfigItems.itemRutileDustID(), "itemRutileDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemCoalDust = new ItemIP(ConfigItems.itemCoalDustID(), "itemCoalDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemHardenedSandDust = new ItemIP(ConfigItems.itemHardenedSandDustID(), "itemHardenedSandDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemAluminumDust = new ItemIP(ConfigItems.itemAluminumDustID(), "itemAluminumDust",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemThickStick = new ItemIP(ConfigItems.ItemThickStick(), "ItemThickStick",IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemHammer = new ItemDamage(ConfigItems.ItemHammer(), "ItemHammer",IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemKnife = new ItemDamage(ConfigItems.ItemKnife(), "ItemKnife",IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemBlowingTorch = new ItemDamage(ConfigItems.ItemBlowingTorch(), "ItemBlowingTorch",IndustrialProcessing.tabMachineParts);
    
    //Iron blast furnace
    public final static ItemIP itemCalcareousSinterDust = new ItemIP(ConfigItems.ItemCalcareousSinterDustID(), "ItemCalcareousSinterDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemCokes = new ItemIP(ConfigItems.ItemCokesID(), "ItemCokes",IndustrialProcessing.tabOres);
    public final static ItemIP itemCokePellet = new ItemIP(ConfigItems.getItemCokePelletID(), "ItemCokePellet",IndustrialProcessing.tabOres);
    public final static ItemIP itemSlag = new ItemIP(ConfigItems.ItemSlagID(), "ItemSlag",IndustrialProcessing.tabOres);
        
    public final static ItemIP itemHexKey = new ItemIP(ConfigItems.itemHexKeyID(), "itemHexKey",IndustrialProcessing.tabPower);
    public final static ItemWrench itemWrench = new ItemWrench();
    public final static ItemBattery itemBattery = new ItemBattery();
    public final static ItemIP itemAsh = new ItemIP(ConfigItems.itemAshID(), "itemAsh",IndustrialProcessing.tabPower);
    
    public final static ItemGuide itemGuide = new ItemGuide(ConfigItems.getItemGuideID(), "itemGuide", IndustrialProcessing.tabMachineParts);
    
    public final static ItemDamage itemGrownCulture = new ItemDamage(ConfigItems.itemGrownCultureID(), "itemGrownCulture", IndustrialProcessing.tabOres,20);
    public final static ItemDamage itemActiveCoal = new ItemDamage(ConfigItems.itemActiveCoalID(), "itemActiveCoalDust", IndustrialProcessing.tabOres,25);
        
    public final static ItemPaintBrush paintBrushWhite = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 0, 0);
    public final static ItemPaintBrush paintBrushOrange = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 1, 1);
    public final static ItemPaintBrush paintBrushMagenta = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 2, 2);
    public final static ItemPaintBrush paintBrushLightBlue = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 3, 3);
    public final static ItemPaintBrush paintBrushYellow = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 4, 4);
    public final static ItemPaintBrush paintBrushLime = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 5, 5);
    public final static ItemPaintBrush paintBrushPink = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 6, 6);
    public final static ItemPaintBrush paintBrushGray = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 7, 7);
    public final static ItemPaintBrush paintBrushLightGray = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 8, 8);
    public final static ItemPaintBrush paintBrushCyan = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 9, 9);
    public final static ItemPaintBrush paintBrushPurple = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 10, 10);
    public final static ItemPaintBrush paintBrushBlue = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 11, 11);
    public final static ItemPaintBrush paintBrushBrown = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 12, 12);
    public final static ItemPaintBrush paintBrushGreen = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 13, 13);
    public final static ItemPaintBrush paintBrushRed = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 14, 14);
    public final static ItemPaintBrush paintBrushBlack = new ItemPaintBrush(ConfigItems.itemPaintBrushID() + 15, 15);
    public final static ItemIP paintBrush = new ItemIP(ConfigItems.itemPaintBrushID() + 16, "pantBrush16", IndustrialProcessing.tabOres);
    
    public final static ItemIP itemCopperIngot = new ItemIP(ConfigItems.itemCopperIngotID(), "ItemCopperIngot",IndustrialProcessing.tabOres);
    public final static ItemIP itemTinIngot = new ItemIP(ConfigItems.itemTinIngotID(), "ItemTinIngot",IndustrialProcessing.tabOres);
    public final static ItemIP itemSilverIngot = new ItemIP(ConfigItems.itemSilverIngotID(), "ItemSilverIngot",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemCopperWire = new ItemIP(ConfigItems.getItemCopperWireID(), "ItemCopperWire",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemCopperWireInsulated = new ItemIP(ConfigItems.getItemCopperWireInsulatedID(), "ItemCopperWireInsulated",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemCopperCoil = new ItemIP(ConfigItems.getItemCopperCoilID(), "ItemCopperCoil",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemElectroMagnet = new ItemIP(ConfigItems.getItemElectroMagnetID(), "ItemElectroMagnet",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemMotorFrame = new ItemIP(ConfigItems.getItemMotorFrameID(), "ItemMotorFrame",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemMotorStator = new ItemIP(ConfigItems.getItemMotorStatorID(), "ItemMotorStator",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemMotorRotor = new ItemIP(ConfigItems.getItemMotorRotorID(), "ItemMotorRotor",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemMotorPoleAxis = new ItemIP(ConfigItems.getItemMotorPoleAxisID(), "ItemMotorPoleAxis",IndustrialProcessing.tabMachineParts);
    
    public final static ItemIP itemCrankWheel = new ItemIP(ConfigItems.getItemCrankWheelID(), "ItemCrankWheel",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemIronBar = new ItemIP(ConfigItems.getItemIronBarID(), "ItemIronBar",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemIronRod = new ItemIP(ConfigItems.getItemIronRodID(), "ItemIronRod",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemIronT = new ItemIP(ConfigItems.getItemIronTID(), "ItemIronT",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemCarbonBrush = new ItemIP(ConfigItems.getItemCarbonBrushID(), "ItemCarbonBrush",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSlipRing = new ItemIP(ConfigItems.getItemSlipRingID(), "ItemSlipRing",IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemIronBowl = new ItemDamage(ConfigItems.getItemIronBowlID(), "ItemIronBowl",IndustrialProcessing.tabMachineParts,8);
    public final static ItemIP itemIronBracket = new ItemIP(ConfigItems.getItemIronBracketID(), "ItemIronBracket",IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemDrawPlate = new ItemDamage(ConfigItems.getItemDrawPlateID(), "ItemDrawPlate",IndustrialProcessing.tabMachineParts,8);
    public final static ItemDamage itemPestle = new ItemDamage(ConfigItems.getItemPestleID(), "ItemPestle",IndustrialProcessing.tabMachineParts,3);
    
    public final static ItemIP itemScreen = new ItemIP(ConfigItems.getItemScreenID(), "ItemScreen",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemFrame = new ItemIP(ConfigItems.getItemFrameID(), "ItemFrame",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemWovenPatern = new ItemIP(ConfigItems.getItemWovenPaternID(), "ItemWovenPatern",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemMixingHook = new ItemIP(ConfigItems.getItemMixingHookID(), "ItemMixingHook",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemHeatingElement = new ItemIP(ConfigItems.getItemHeatingElementID(), "ItemHeatingElement",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemTumbler = new ItemIP(ConfigItems.getItemTumblerID(), "ItemTumbler",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemRakeArm = new ItemIP(ConfigItems.getItemRakeArmID(), "ItemRakeArm",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemDisk = new ItemIP(ConfigItems.getItemDiskID(), "ItemDisk",IndustrialProcessing.tabMachineParts);
    
    public final static ItemIP itemTaliaMixedFragments = new ItemIP(ConfigItems.getItemTaliaMixedFragmentsID(), "itemTaliaMixedFragments",IndustrialProcessing.tabOres);
    public final static ItemIP itemGoldMixedFragments = new ItemIP(ConfigItems.getItemGoldMixedFragmentsID(), "itemGoldMixedFragments",IndustrialProcessing.tabOres);
    public final static ItemIP itemGalenaMixedFragments = new ItemIP(ConfigItems.getItemGalenaMixedFragmentsID(), "itemGalenaMixedFragments",IndustrialProcessing.tabOres);
    public final static ItemIP itemChromiteMixedFragments = new ItemIP(ConfigItems.getItemChromiteMixedFragmentsID(), "itemChromiteMixedFragments",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemLimestoneDust = new ItemIP(ConfigItems.getItemLimestoneDustID(), "itemLimestoneDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronSinter = new ItemIP(ConfigItems.getItemIronSinterID(), "ItemIronOxidePellets",IndustrialProcessing.tabOres);
    
    public final static ItemSuspendedCart itemSupendedCart = new ItemSuspendedCart(ConfigItems.getItemSuspendedCartID(), "ItemSupendedCart",1,IndustrialProcessing.tabMachineParts);
    
    public final static ItemIP itemFlask = new ItemIP(ConfigItems.getItemFlaskID(), "itemFlask", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemCastingMulsh = new ItemIP(ConfigItems.getItemCastingMulshID(), "itemCastingMulsh", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSandCast = new ItemIP(ConfigItems.getItemSandCastID(), "itemSandCast", IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemSandCastIngot = new ItemDamage(ConfigItems.getItemSandCastIngotID(), "itemSandCastIngot", IndustrialProcessing.tabMachineParts,32);
    
    public final static ItemIP itemCopperPlate = new ItemIP(ConfigItems.getItemCopperPlateID(), "itemCopperPlate", IndustrialProcessing.tabMachineParts);
    
    public final static ItemIP itemCopperBoard = new ItemIP(ConfigItems.getItemCopperBoardID(), "ItemCopperBoard", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemElectricComponents = new ItemIP(ConfigItems.getItemElectricComponentsID(), "ItemElectricComponents", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemnhardenedIsolationBoard = new ItemIP(ConfigItems.getItemUnhardenedIsolationBoardID(), "itemnhardenedIsolationBoard", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemIsolationBoard = new ItemIP(ConfigItems.getItemIsolationBoardID(), "ItemIsolationBoard", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemPCBoard = new ItemIP(ConfigItems.getItemPCBoardID(), "ItemPCBoard", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemPCBoardWired = new ItemIP(ConfigItems.getItemPCBoardWiredID(), "ItemPCBoardWired", IndustrialProcessing.tabMachineParts);
    public final static ItemDamage itemSolder = new ItemDamage(ConfigItems.getItemSolderID(), "ItemSolder", IndustrialProcessing.tabMachineParts,64);
    public final static ItemIP itemSolderEmpty = new ItemIP(ConfigItems.getItemSolderEmptyID(), "ItemSolderEmpty", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSolderingIron = new ItemIP(ConfigItems.getItemSolderingIronID(), "ItemSolderingIron", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemStripBoard = new ItemIP(ConfigItems.getItemStripBoardID(), "ItemStripBoard", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemStripBoardWired = new ItemIP(ConfigItems.getItemStripBoardWiredID(), "ItemStripBoardWired", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSolderAlloyWire = new ItemIP(ConfigItems.getItemSolderAlloyWireID(), "ItemSolderAlloyWire", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSolderAlloyIngot = new ItemIP(ConfigItems.getItemSolderAlloyIngotID(), "ItemSolderAlloyIngot", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemRedstoneCircuitry = new ItemIP(ConfigItems.getItemRedstoneCircuitryID(), "ItemRedstoneCircuitry", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemSmallEngine = new ItemIP(ConfigItems.getItemSmallEngineID(), "ItemSmallEngine", IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemCopperBar = new ItemIP(ConfigItems.getItemCopperBarID(), "ItemCopperBar",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemFilterTray = new ItemIP(ConfigItems.getItemFilterTrayID(), "ItemFilterTray",IndustrialProcessing.tabMachineParts);
    
    public final static ItemIP itemLeadIngot = new ItemIP(ConfigItems.getItemLeadIngotID(), "ItemLeadIngot",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronBlade = new ItemIP(ConfigItems.getItemIronBladeID(), "itemIronBlade",IndustrialProcessing.tabMachineParts);
    public final static ItemIP itemTurbineBlades = new ItemIP(ConfigItems.getItemTurbineBladesID(), "itemTurbineBlades",IndustrialProcessing.tabMachineParts);
    public final static ItemRemote itemRemote = new ItemRemote(ConfigItems.getItemRemoteID());
    
}
