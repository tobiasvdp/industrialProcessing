package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ConfigItems {

	private int ItemIronLargeChunksID = 6500;
	private int ItemCopperLargeChunksID = 6501;
	private int ItemTinLargeChunksID = 6502;
	private int ItemIronSmallChunksID = 6503;
	private int ItemCopperSmallChunksID = 6504;
	private int ItemTinSmallChunksID = 6505;
	private int ItemIronCrushedChunksID = 6506;
	private int ItemCopperCrushedChunksID = 6507;
	private int ItemTinCrushedChunksID = 6508;
	private int ItemIronWashedChunksID = 6509;
	private int ItemCopperWashedChunksID = 6510;
	private int ItemTinWashedChunksID = 6511;
	private int ItemIronFineChunksID = 6512;
	private int ItemCopperFineChunksID = 6513;
	private int ItemTinFineChunksID = 6514;
	private int ItemIronOxideDustID = 6515;
	private int ItemCopperMineralID = 6516;
	private int ItemTinOxideDustID = 6517;
	private int ItemSiliciumID = 6518;
	private int ItemZincDustID = 6519;
	private int ItemCopperPurifiedID = 6520;
	private int ItemTinPurifiedID = 6521;
	private int ItemSulfurID = 6522;
	private int ItemIronMixedFragmentsID = 6523;
	private int ItemCopperMixedFragmentsID = 6524;
	private int ItemTinMixedFragmentsID = 6525;
	private int ItemIronOxidePelletsID = 6526;
	private int ItemCalcareousSinterDustID = 6527;
	private int ItemCokesID = 6528;
	private int ItemSlagID = 6529;
	private int ItemThickStick = 6530;
	private int ItemHammer = 6531;
	private int ItemBlowingTorch = 6532;
	private int ItemSmallMachineCasingID = 6533;
	private int ItemInputPortID = 6534;
	private int ItemOutputPortID = 6535;
	private int ItemPowerPortID = 6536;
	private int ItemSupportBarsID = 6537;
	private int ItemCrusingPlateID = 6538;
	private int ItemIronPlateID = 6539;
	private int ItemIronTipsID = 6540;
	private int ItemSmallMachineCasingCrusherID = 6541;
	private int itemGalenaCrushedChunksID = 6542;
	private int itemGalenaSmallChunksID = 6543;
	private int itemGalenaLargeChunksID = 6544;
	private int itemGalenaWashedChunksID = 6545;
	private int itemGalenaFineChunksID = 6546;
	private int itemRutileCrystalsID = 6547;
	private int itemRutileSmallCrushedCrystalsID = 6549;
	private int itemRutileLargeCrushedCrystalsID = 6550;
	private int itemRutileFineCrushedCrystalsID = 6551;
	private int itemCinnebarCrystalsID = 6552;
	private int itemCinnebarSmallCrushedCrystalsID = 6554;
	private int itemCinnebarLargeCrushedCrystalsID = 6555;
	private int itemCinnebarFineCrushedCrystalsID = 6556;
	private int itemChromiteCrushedChunksID = 6557;
	private int itemChromiteSmallChunksID = 6558;
	private int itemChromiteLargeChunksID = 6559;
	private int itemChromiteWashedChunksID = 6560;
	private int itemChromiteFineChunksID = 6561;
	private int itemGoldCrushedChunksID = 6562;
	private int itemGoldSmallChunksID = 6563;
	private int itemGoldLargeChunksID = 6564;
	private int itemGoldWashedChunksID = 6565;
	private int itemGoldFineChunksID = 6566;
	private int itemTaliaCrushedChunksID = 6567;
	private int itemTaliaSmallChunksID = 6568;
	private int itemTaliaLargeChunksID = 6569;
	private int itemTaliaWashedChunksID = 6570;
	private int itemTaliaFineChunksID = 6571;
	
	private int itemSilverDustID = 6572;
	private int itemRutileDustID = 6573;
	private int itemCinnebarDustID = 6574;
	private int itemChromiteDustID = 6575;
	private int itemGoldDustID = 6576;
	private int itemTaliaDustID = 6577;
	private int itemLeadDustID = 6578;
	
	private int itemHexKeyID = 6579;
	
	public static int itemHexKeyID(){return getInstance().itemHexKeyID;}
	public static int itemLeadDustID(){return getInstance().itemLeadDustID;}
	public static int itemSilverDustID(){return getInstance().itemSilverDustID;}
	public static int itemRutileDustID(){return getInstance().itemRutileDustID;}
	public static int itemCinnebarDustID(){return getInstance().itemCinnebarDustID;}
	public static int itemChromiteDustID(){return getInstance().itemChromiteDustID;}
	public static int itemGoldDustID(){return getInstance().itemGoldDustID;}
	public static int itemTaliaDustID(){return getInstance().itemTaliaDustID;}
	
	public static int itemCinnebarCrystalsID(){return getInstance().itemCinnebarCrystalsID;}
	public static int itemRutileCrystalsID(){return getInstance().itemRutileCrystalsID;}
	public static int itemGalenaCrushedChunksID(){return getInstance().itemGalenaCrushedChunksID;}
	public static int itemGalenaSmallChunksID(){return getInstance().itemGalenaSmallChunksID;}
	public static int itemGalenaLargeChunksID(){return getInstance().itemGalenaLargeChunksID;}
	public static int itemGalenaWashedChunksID(){return getInstance().itemGalenaWashedChunksID;}
	public static int itemGalenaFineChunksID(){return getInstance().itemGalenaFineChunksID;}
	public static int itemRutileSmallCrushedCrystalsID(){return getInstance().itemRutileSmallCrushedCrystalsID;}
	public static int itemRutileLargeCrushedCrystalsID(){return getInstance().itemRutileLargeCrushedCrystalsID;}
	public static int itemRutileFineCrushedCrystalsID(){return getInstance().itemRutileFineCrushedCrystalsID;}
	public static int itemCinnebarSmallCrushedCrystalsID(){return getInstance().itemCinnebarSmallCrushedCrystalsID;}
	public static int itemCinnebarLargeCrushedCrystalsID(){return getInstance().itemCinnebarLargeCrushedCrystalsID;}
	public static int itemCinnebarFineCrushedCrystalsID(){return getInstance().itemCinnebarFineCrushedCrystalsID;}
	public static int itemChromiteCrushedChunksID(){return getInstance().itemChromiteCrushedChunksID;}
	public static int itemChromiteSmallChunksID(){return getInstance().itemChromiteSmallChunksID;}
	public static int itemChromiteLargeChunksID(){return getInstance().itemChromiteLargeChunksID;}
	public static int itemChromiteWashedChunksID(){return getInstance().itemChromiteWashedChunksID;}
	public static int itemChromiteFineChunksID(){return getInstance().itemChromiteFineChunksID;}
	public static int itemGoldCrushedChunksID(){return getInstance().itemGoldCrushedChunksID;}
	public static int itemGoldSmallChunksID(){return getInstance().itemGoldSmallChunksID;}
	public static int itemGoldLargeChunksID(){return getInstance().itemGoldLargeChunksID;}
	public static int itemGoldWashedChunksID(){return getInstance().itemGoldWashedChunksID;}
	public static int itemGoldFineChunksID(){return getInstance().itemGoldFineChunksID;}
	public static int itemTaliaCrushedChunksID(){return getInstance().itemTaliaCrushedChunksID;}
	public static int itemTaliaSmallChunksID(){return getInstance().itemTaliaSmallChunksID;}
	public static int itemTaliaLargeChunksID(){return getInstance().itemTaliaLargeChunksID;}
	public static int itemTaliaWashedChunksID(){return getInstance().itemTaliaWashedChunksID;}
	public static int itemTaliaFineChunksID(){return getInstance().itemTaliaFineChunksID;}
	public static int ItemSmallMachineCasingID(){return getInstance().ItemSmallMachineCasingID;}
	public static int ItemInputPortID(){return getInstance().ItemInputPortID;}
	public static int ItemOutputPortID(){return getInstance().ItemOutputPortID;}
	public static int ItemPowerPortID(){return getInstance().ItemPowerPortID;}
	public static int ItemSupportBarsID(){return getInstance().ItemSupportBarsID;}
	public static int ItemCrusingPlateID(){return getInstance().ItemCrusingPlateID;}
	public static int ItemIronPlateID(){return getInstance().ItemIronPlateID;}
	public static int ItemIronTipsID(){return getInstance().ItemIronTipsID;}
	public static int ItemSmallMachineCasingCrusherID(){return getInstance().ItemSmallMachineCasingCrusherID;}
	public static int ItemBlowingTorch(){return getInstance().ItemBlowingTorch;}
	public static int ItemHammer(){return getInstance().ItemHammer;}
	public static int ItemThickStick(){return getInstance().ItemThickStick;}
	public static int ItemIronLargeChunksID(){return getInstance().ItemIronLargeChunksID;}
	public static int ItemCopperLargeChunksID(){return getInstance().ItemCopperLargeChunksID;}
	public static int ItemTinLargeChunksID(){return getInstance().ItemTinLargeChunksID;}
	public static int ItemIronSmallChunksID(){return getInstance().ItemIronSmallChunksID;}
	public static int ItemCopperSmallChunksID(){return getInstance().ItemCopperSmallChunksID;}
	public static int ItemTinSmallChunksID(){return getInstance().ItemTinSmallChunksID;}
	public static int ItemIronCrushedChunksID(){return getInstance().ItemIronCrushedChunksID;}
	public static int ItemCopperCrushedChunksID(){return getInstance().ItemCopperCrushedChunksID;}
	public static int ItemTinCrushedChunksID(){return getInstance().ItemTinCrushedChunksID;}
	public static int ItemIronWashedChunksID(){return getInstance().ItemIronWashedChunksID;}
	public static int ItemCopperWashedChunksID(){return getInstance().ItemCopperWashedChunksID;}
	public static int ItemTinWashedChunksID(){return getInstance().ItemTinWashedChunksID;}
	public static int ItemIronFineChunksID(){return getInstance().ItemIronFineChunksID;}
	public static int ItemCopperFineChunksID(){return getInstance().ItemCopperFineChunksID;}
	public static int ItemTinFineChunksID(){return getInstance().ItemTinFineChunksID;}
	public static int ItemIronOxideDustID(){return getInstance().ItemIronOxideDustID;}
	public static int ItemCopperMineralID(){return getInstance().ItemCopperMineralID;}
	public static int ItemTinOxideDustID(){return getInstance().ItemTinOxideDustID;}
	public static int ItemSiliciumID(){return getInstance().ItemSiliciumID;}
	public static int ItemZincDustID(){return getInstance().ItemZincDustID;}
	public static int ItemCopperPurifiedID(){return getInstance().ItemCopperPurifiedID;}
	public static int ItemTinPurifiedID(){return getInstance().ItemTinPurifiedID;}
	public static int ItemSulfurID(){return getInstance().ItemSulfurID;}
	public static int ItemIronMixedFragmentsID() {return getInstance().ItemIronMixedFragmentsID;}
	public static int ItemCopperMixedFragmentsID() {return getInstance().ItemCopperMixedFragmentsID;}
	public static int ItemTinMixedFragmentsID() {return getInstance().ItemTinMixedFragmentsID;}
	
	public static int ItemIronOxidePelletsID() {return getInstance().ItemIronOxidePelletsID;}
	public static int ItemCalcareousSinterDustID() {return getInstance().ItemCalcareousSinterDustID;}
	public static int ItemCokesID() {return getInstance().ItemCokesID;}
	public static int ItemSlagID() {return getInstance().ItemSlagID;}
	
	public static void addToLanguageRegistry(){
		LanguageRegistry.addName(IndustrialProcessing.itemHexKey, "Hex Key");
		LanguageRegistry.addName(IndustrialProcessing.itemSmallMachineCasing, "Small machine casing");
		LanguageRegistry.addName(IndustrialProcessing.itemInputPort, "Input port");
		LanguageRegistry.addName(IndustrialProcessing.itemOutputPort, "Output port");
		LanguageRegistry.addName(IndustrialProcessing.itemPowerPort, "Power port");
		LanguageRegistry.addName(IndustrialProcessing.itemSupportBars, "Support bar");
		LanguageRegistry.addName(IndustrialProcessing.itemCrusingPlate, "Crushing plate");
		LanguageRegistry.addName(IndustrialProcessing.itemIronPlate, "Iron plate");
		LanguageRegistry.addName(IndustrialProcessing.itemIronTips, "Iron tips");
		LanguageRegistry.addName(IndustrialProcessing.itemSmallMachineCasingCrusher, "Crusher machine case");
		
		LanguageRegistry.addName(IndustrialProcessing.itemIronLargeChunks, "Large iron Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperLargeChunks, "Large copper Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemTinLargeChunks, "Large tin Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemIronSmallChunks, "Small iron Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperSmallChunks, "Small copper Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemTinSmallChunks, "Small tin Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemIronCrushedChunks, "Crushed iron Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperCrushedChunks, "Crushed copper Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemTinCrushedChunks, "Crushed tin Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemIronWashedChunks, "Washed iron Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperWashedChunks, "Washed copper Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemTinWashedChunks, "Washed tin Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemIronFineChunks, "Fine iron Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperFineChunks, "Fine copper Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemTinFineChunks, "Fine tin Chunks");
		LanguageRegistry.addName(IndustrialProcessing.itemIronOxideDust, "Iron oxide Dust");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperMineral, "Copper mineral");
		LanguageRegistry.addName(IndustrialProcessing.itemTinOxideDust, "Tin oxide Dust");
		LanguageRegistry.addName(IndustrialProcessing.itemIronMixedFragments, "Iron mixed fragments");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperMixedFragments, "Copper mixed fragments");
		LanguageRegistry.addName(IndustrialProcessing.itemTinMixedFragments, "Tin mixed fragments");
		LanguageRegistry.addName(IndustrialProcessing.itemSilicium, "Silicium");
		LanguageRegistry.addName(IndustrialProcessing.itemZincDust, "zinc Dust");
		LanguageRegistry.addName(IndustrialProcessing.itemCopperPurified, "Purified copper");
		LanguageRegistry.addName(IndustrialProcessing.itemTinPurified, "Purified tin");
		LanguageRegistry.addName(IndustrialProcessing.itemSulfur, "Sulfur");
		
		LanguageRegistry.addName(IndustrialProcessing.itemThickStick, "Thick stick");
		LanguageRegistry.addName(IndustrialProcessing.itemHammer, "Hammer");
		LanguageRegistry.addName(IndustrialProcessing.itemBlowingTorch, "Blow torch");
		
		LanguageRegistry.addName(IndustrialProcessing.itemIronOxidePellets, "Iron pellets");
		LanguageRegistry.addName(IndustrialProcessing.itemCalcareousSinterDust, "Calcareous sinter dust");
		LanguageRegistry.addName(IndustrialProcessing.itemCokes, "Cokes");
		LanguageRegistry.addName(IndustrialProcessing.itemSlag, "Slag");
	}
	
	private ConfigItems(){
	
	}
	
	private static ConfigItems instance = new ConfigItems();
	
	public static ConfigItems getInstance(){
		return instance;
	}
}
