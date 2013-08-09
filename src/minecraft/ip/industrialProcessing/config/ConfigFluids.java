package ip.industrialProcessing.config;

public class ConfigFluids {

	private int blockFluidBaseDirtyWaterID = 2000;
	private int BucketDirtyWaterID = 2001;
	private int blockFluidBaseOreSludgeIronID = 2002;
	private int blockFluidBaseOreSludgeCopperID = 2003;
	private int blockFluidBaseOreSludgeTinID = 2004;
	private int BucketOreSludgeIronID = 2005;
	private int BucketOreSludgeCopperID = 2006;
	private int BucketOreSludgeTinID = 2007;
	
	public static int blockFluidBaseDirtyWaterID(){return getInstance().blockFluidBaseDirtyWaterID;}
	public static int BucketDirtyWaterID(){return getInstance().BucketDirtyWaterID;}
	public static int blockFluidBaseOreSludgeIronID() {return getInstance().blockFluidBaseOreSludgeIronID ;}
	public static int blockFluidBaseOreSludgeCopperID() {return getInstance().blockFluidBaseOreSludgeCopperID ;}
	public static int blockFluidBaseOreSludgeTinID() {return getInstance().blockFluidBaseOreSludgeTinID ;}
	public static int BucketOreSludgeIronID() {return getInstance().BucketOreSludgeIronID ;}
	public static int BucketOreSludgeCopperID() {return getInstance().BucketOreSludgeCopperID ;}
	public static int BucketOreSludgeTinID() {return getInstance().BucketOreSludgeTinID ;}
	
	private ConfigFluids(){
	
	}
	
	private static ConfigFluids instance = new ConfigFluids();
	
	public static ConfigFluids getInstance(){
		return instance;
	}

}