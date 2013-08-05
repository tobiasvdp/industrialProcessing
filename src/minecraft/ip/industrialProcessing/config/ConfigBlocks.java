package ip.industrialProcessing.config;

public class ConfigBlocks {


	private int BlockCopperOreID = 1000;
	private int BlockTinOreID = 1001;
	
	public static int BlockCopperOreID(){return getInstance().BlockCopperOreID;}
	public static int BlockTinOreID(){return getInstance().BlockTinOreID;}
	
	private ConfigBlocks(){
	
	}
	
	private static ConfigBlocks instance = new ConfigBlocks();
	
	public static ConfigBlocks getInstance(){
		return instance;
	}
}