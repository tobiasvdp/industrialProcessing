package ip.industrialProcessing.config;

public class ConfigBlocks {


	private int blockCopperOreID = 1000;
	private int blockTinOreID = 1001;
	
	public static int BlockCopperOreID(){return getInstance().blockCopperOreID;}
	public static int BlockTinOreID(){return getInstance().blockTinOreID;}
	
	private ConfigBlocks(){
	
	}
	
	private static ConfigBlocks instance = new ConfigBlocks();
	
	public static ConfigBlocks getInstance(){
		return instance;
	}
}