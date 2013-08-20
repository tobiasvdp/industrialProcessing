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
