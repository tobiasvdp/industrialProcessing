package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.items.ItemDamage;
import ip.industrialProcessing.items.ItemIP;

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
    public final static ItemIP itemSmallMachineCasing = new ItemIP(ConfigItems.ItemSmallMachineCasingID(), "itemSmallMachineCasing",IndustrialProcessing.tabOres);
    public final static ItemIP itemInputPort = new ItemIP(ConfigItems.ItemInputPortID(), "itemInputPort",IndustrialProcessing.tabOres);
    public final static ItemIP itemOutputPort = new ItemIP(ConfigItems.ItemOutputPortID(), "itemOutputPort",IndustrialProcessing.tabOres);
    public final static ItemIP itemPowerPort = new ItemIP(ConfigItems.ItemPowerPortID(), "itemPowerPort",IndustrialProcessing.tabOres);
    public final static ItemIP itemSupportBars = new ItemIP(ConfigItems.ItemSupportBarsID(), "itemSupportBars",IndustrialProcessing.tabOres);
    public final static ItemIP itemCrusingPlate = new ItemIP(ConfigItems.ItemCrusingPlateID(), "itemCrusingPlate",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronPlate = new ItemIP(ConfigItems.ItemIronPlateID(), "itemIronPlate",IndustrialProcessing.tabOres);
    public final static ItemIP itemIronTips = new ItemIP(ConfigItems.ItemIronTipsID(), "itemIronTips",IndustrialProcessing.tabOres);
    public final static ItemIP itemSmallMachineCasingCrusher = new ItemIP(ConfigItems.ItemSmallMachineCasingCrusherID(), "itemSmallMachineCasingCrusher",IndustrialProcessing.tabOres);
    
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
    
    public final static ItemIP itemThickStick = new ItemIP(ConfigItems.ItemThickStick(), "ItemThickStick",IndustrialProcessing.tabOreProcessing);
    public final static ItemDamage itemHammer = new ItemDamage(ConfigItems.ItemHammer(), "ItemHammer",IndustrialProcessing.tabOreProcessing);
    public final static ItemDamage itemBlowingTorch = new ItemDamage(ConfigItems.ItemBlowingTorch(), "ItemBlowingTorch",IndustrialProcessing.tabOreProcessing);
    
    //Iron blast furnace
    public final static ItemIP itemIronOxidePellets = new ItemIP(ConfigItems.ItemIronOxidePelletsID(), "ItemIronOxidePellets",IndustrialProcessing.tabOres);
    public final static ItemIP itemCalcareousSinterDust = new ItemIP(ConfigItems.ItemCalcareousSinterDustID(), "ItemCalcareousSinterDust",IndustrialProcessing.tabOres);
    public final static ItemIP itemCokes = new ItemIP(ConfigItems.ItemCokesID(), "ItemCokes",IndustrialProcessing.tabOres);
    public final static ItemIP itemSlag = new ItemIP(ConfigItems.ItemSlagID(), "ItemSlag",IndustrialProcessing.tabOres);
    
    public final static ItemIP itemHexKey = new ItemIP(ConfigItems.itemHexKeyID(), "itemHexKey",IndustrialProcessing.tabPower);
    
}
