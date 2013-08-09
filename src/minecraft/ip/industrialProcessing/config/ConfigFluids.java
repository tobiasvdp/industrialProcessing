package ip.industrialProcessing.config;

public class ConfigFluids {

	private int blockFluidBaseDirtyWaterID = 2000;
	private int BucketDirtyWaterID = 2001;
	
	public static int blockFluidBaseDirtyWaterID(){return getInstance().blockFluidBaseDirtyWaterID;}
	public static int BucketDirtyWaterID(){return getInstance().BucketDirtyWaterID;}
	
	private ConfigFluids(){
	
	}
	
	private static ConfigFluids instance = new ConfigFluids();
	
	public static ConfigFluids getInstance(){
		return instance;
	}
}