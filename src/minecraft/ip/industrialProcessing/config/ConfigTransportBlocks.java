package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;

public class ConfigTransportBlocks {
    private int blockTransportFluidsID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPipeID", 3500).getInt();
    private int blockTransportFluidPumpID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPumpID", 3501).getInt();
    private int blockTransportFluidTankID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidTankID", 3502).getInt();
    private int blockTransportFluidManometerID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidManometerID", 3503).getInt();
    private int blockTransportFluidRainTankID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidRaintankID", 3504).getInt();
    private int blockTransportFluidValveID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidValveID", 3505).getInt();
    private int blockTransportFluidGrateID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidGrateID", 3506).getInt();
    private int blockTransportFluidsWoodID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPipeWoodID", 3507).getInt();
    private int blockTransportFluidsStoneID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPipeStoneID", 3508).getInt();

    public static int getBlockTransportFluidsID() {
        return getInstance().blockTransportFluidsID;
    }

    public static int getBlockTransportFluidsWoodID() {
        return getInstance().blockTransportFluidsWoodID;
    }

    public static int getBlockTransportFluidsStoneID() {
        return getInstance().blockTransportFluidsStoneID;
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

    public static int getBlockTransportFluidGrateID() {
        return getInstance().blockTransportFluidGrateID;
    }

    public static int getBlockRainTankID() {
        return getInstance().blockTransportFluidRainTankID;
    }

    public static int getBlockValveID() {
        return getInstance().blockTransportFluidValveID;
    }

    private ConfigTransportBlocks() {

    }

    private static ConfigTransportBlocks instance = new ConfigTransportBlocks();

    public static ConfigTransportBlocks getInstance() {
        return instance;
    }

}
