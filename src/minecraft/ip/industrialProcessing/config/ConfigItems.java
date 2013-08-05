package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessingConfig;

public class ConfigItems {

	private int ItemIronLargeChunksID = 2000;
	
	public static int ItemIronLargeChunksID(){return getInstance().ItemIronLargeChunksID;}
	
	private ConfigItems(){
	
	}
	
	private static ConfigItems instance = new ConfigItems();
	
	public static ConfigItems getInstance(){
		return instance;
	}
}
