package ip.industrialProcessing.config;

public class ConfigMachineBlocks {

    private ConfigMachineBlocks() {

    }

    private static ConfigMachineBlocks instance = new ConfigMachineBlocks();
    private int crusherBlockID = 500;
    private int filterBlockId = 501;
    private int magneticSeparatorBlockID = 502;
    private int mixerBlockID = 503;
    private int dryerBlockID = 504;
    private int classifierBlockID = 505;
    private int thickenerBlockID = 506;
    private int flotationCellBlockID = 507;
    private int hydroCycloneBlockID = 508;
    private int diskFilterBlockID = 509;
    
    private int machineFrameBlockID = 600;
    private int multiMachineInputBlockID = 601;
    private int largeCrusherBlockID = 700;

    public static ConfigMachineBlocks getInstance() {
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

    public static int getMachineFrameBlockID() {
	return getInstance().machineFrameBlockID;
    }

    public static int getLargeCrusherBlockID() {
	return getInstance().largeCrusherBlockID;
    }

    public static int getDryerBlockID() {
	return getInstance().dryerBlockID;
    }

    public static int getMultiMachineInputBlockID() {
	return getInstance().multiMachineInputBlockID;
    }

    public static int getClassifierBlockID() {
	return getInstance().classifierBlockID;
    }

    public static int getThickenerBlockID() {
	return getInstance().thickenerBlockID;
    }

    public static int getFlotationCellBlockID() { 
	return getInstance().flotationCellBlockID;
    }

    public static int getHydroCycloneBlockID() {
	return getInstance().hydroCycloneBlockID;
    }

    public static int getDiskFilterBlockID() {
	return getInstance().diskFilterBlockID;
    }

}
