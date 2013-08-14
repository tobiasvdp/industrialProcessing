package ip.industrialProcessing.config;

public class ConfigTransportBlocks {
    private int blockTransportFluidsID = 3500;
    private int blockTransportFluidPumpID = 3501;
    private int blockTransportFluidTankID = 3502;

    public static int getBlockTransportFluidsID() {
	return getInstance().blockTransportFluidsID;
    }

    public static int getBlockTransportFluidPumpID() {
	return getInstance().blockTransportFluidPumpID;
    }
    public static int getBlockTransportFluidTankID() {
	return getInstance().blockTransportFluidTankID;
    }


    private ConfigTransportBlocks() {

    }

    private static ConfigTransportBlocks instance = new ConfigTransportBlocks();

    public static ConfigTransportBlocks getInstance() {
	return instance;
    }
}
