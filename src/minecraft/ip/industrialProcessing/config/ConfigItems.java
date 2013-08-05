package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessingConfig;

public class ConfigItems {

	private int ItemIronLargeChunksID = 2000;
	private int ItemCopperLargeChunksID = 2001;
	private int ItemTinLargeChunksID = 2002;
	private int ItemIronSmallChunksID = 2003;
	private int ItemCopperSmallChunksID = 2004;
	private int ItemTinSmallChunksID = 2005;
	private int ItemIronCrushedChunksID = 2006;
	private int ItemCopperCrushedChunksID = 2007;
	private int ItemTinCrushedChunksID = 2008;
	
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
