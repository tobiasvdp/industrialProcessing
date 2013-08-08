package ip.industrialProcessing.config;


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
	
	private ConfigItems(){
	
	}
	
	private static ConfigItems instance = new ConfigItems();
	
	public static ConfigItems getInstance(){
		return instance;
	}
}
