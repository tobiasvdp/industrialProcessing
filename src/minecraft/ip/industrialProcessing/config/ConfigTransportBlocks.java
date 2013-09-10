package ip.industrialProcessing.config;

public class ConfigTransportBlocks {
	private int blockTransportFluidsID = 3500;
	private int blockTransportFluidPumpID = 3501;
	private int blockTransportFluidTankID = 3502;
	private int blockTransportFluidManometerID = 3503;
	private int blockTransportFluidRainTankID = 3504;

	public static int getBlockTransportFluidsID() {
		return getInstance().blockTransportFluidsID;
	}

	public static int getBlockTransportFluidPumpID() {
		return getInstance().blockTransportFluidPumpID;
	}

	public static int getBlockTransportFluidTankID() {
		return getInstance().blockTransportFluidTankID;
	}

	public static int getBlockTransportFluidManometerID() {
		return getInstance().blockTransportFluidManometerID;
	}
	
	public static int getBlockRainTankID() {
		return getInstance().blockTransportFluidRainTankID; 
	}


	private ConfigTransportBlocks() {

	}

	private static ConfigTransportBlocks instance = new ConfigTransportBlocks();

	public static ConfigTransportBlocks getInstance() {
		return instance;
	}

}
