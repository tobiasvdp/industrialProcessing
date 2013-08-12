package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ConfigItems {

	private int ItemIronLargeChunksID = 5000;
	private int ItemCopperLargeChunksID = 5001;
	private int ItemTinLargeChunksID = 5002;
	private int ItemIronSmallChunksID = 5003;
	private int ItemCopperSmallChunksID = 5004;
	private int ItemTinSmallChunksID = 5005;
	private int ItemIronCrushedChunksID = 5006;
	private int ItemCopperCrushedChunksID = 5007;
	private int ItemTinCrushedChunksID = 5008;
	private int ItemIronWashedChunksID = 5009;
	private int ItemCopperWashedChunksID = 5010;
	private int ItemTinWashedChunksID = 5011;
	private int ItemIronFineChunksID = 5012;
	private int ItemCopperFineChunksID = 5013;
	private int ItemTinFineChunksID = 5014;
	private int ItemIronOxideDustID = 5015;
	private int ItemCopperMineralID = 5016;
	private int ItemTinOxideDustID = 5017;
	private int ItemSiliciumID = 5018;
	private int ItemZincDustID = 5019;
	private int ItemCopperPurifiedID = 5020;
	private int ItemTinPurifiedID = 5021;
	private int ItemSulfurID = 5022;
	private int ItemIronMixedFragmentsID = 5023;
	private int ItemCopperMixedFragmentsID = 5024;
	private int ItemTinMixedFragmentsID = 5025;
	
	private int ItemIronOxidePelletsID = 5026;
	private int ItemCalcareousSinterDustID = 5027;
	private int ItemCokesID = 5028;
	private int ItemSlagID = 5029;
	
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
