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
	
	public static int ItemIronLargeChunksID(){return getInstance().ItemIronLargeChunksID;}
	public static int ItemCopperLargeChunksID(){return getInstance().ItemCopperLargeChunksID;}
	public static int ItemTinLargeChunksID(){return getInstance().ItemTinLargeChunksID;}
	public static int ItemIronSmallChunksID(){return getInstance().ItemIronSmallChunksID;}
	public static int ItemCopperSmallChunksID(){return getInstance().ItemCopperSmallChunksID;}
	public static int ItemTinSmallChunksID(){return getInstance().ItemTinSmallChunksID;}
	public static int ItemIronCrushedChunksID(){return getInstance().ItemIronCrushedChunksID;}
	public static int ItemCopperCrushedChunksID(){return getInstance().ItemCopperCrushedChunksID;}
	public static int ItemTinCrushedChunksID(){return getInstance().ItemTinCrushedChunksID;}
	
	private ConfigItems(){
	
	}
	
	private static ConfigItems instance = new ConfigItems();
	
	public static ConfigItems getInstance(){
		return instance;
	}
}
