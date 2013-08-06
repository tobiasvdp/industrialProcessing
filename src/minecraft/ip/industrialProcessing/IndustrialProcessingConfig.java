package ip.industrialProcessing;

public class IndustrialProcessingConfig {

	private IndustrialProcessingConfig() {

	}

	private static IndustrialProcessingConfig instance = new IndustrialProcessingConfig();
	private int crusherBlockID = 500;
	private int filterBlockId = 501;
	private int magneticSeparatorBlockID = 502;
	private int mixerBlockID = 503;
	private int machineFrameBlockID = 600;
	private int largeCrusherBlockID = 700;

	public static IndustrialProcessingConfig getInstance() {
		return instance;
	}

	public static int getFilterBlockID() {
		return getInstance().filterBlockId;
	}

	public static int getCrusherBlockID() {
		return getInstance().crusherBlockID;
	}

	public static int getMagneticSeparatorBlockID() {

		return getInstance().magneticSeparatorBlockID;
	}

	public static int getMixerBlockID() {
		return getInstance().mixerBlockID;
	}

	public static int getMachineFrameBlockID()
	{
		return getInstance().machineFrameBlockID;
	}
	
	public static int getLargeCrusherBlockID() {
		return getInstance().largeCrusherBlockID;
	}

}
