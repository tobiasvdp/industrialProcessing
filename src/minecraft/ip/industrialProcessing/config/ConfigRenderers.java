package ip.industrialProcessing.config;

public class ConfigRenderers {

    private int rendererCrankGeneratorID;
    private int rendererWireID;
    private int rendererMixerID;
    private int rendererFilterID;
    private int rendererMagneticSeperatorID;
    private int rendererCrusherID;
    private int rendererDiskFilterID;
    private int rendererVoltMeterID;
    private int rendererAmpMeterID;
    private int rendererTransportFluidID;
    private int rendererBatteryBoxID;
    private int rendererBlastFurnaceID;
    private int rendererTankID;
    private int rendererBlockMachineFrameID;

    public static int getRendererBlockMachineFrameID() {
	return getInstance().rendererBlockMachineFrameID;
    }

    public static void setRendererBlockMachineFrameID(int value) {
	getInstance().rendererBlockMachineFrameID = value;
    }
    public static int getRendererFilterId() {
	return getInstance().rendererFilterID;
    }

    public static void setRendererFilterId(int value) {
	getInstance().rendererFilterID = value;
    }

    public static int getRendererMagneticSeperatorId() {
	return getInstance().rendererMagneticSeperatorID;
    }

    public static void setRendererMagneticSeperatorId(int value) {
	getInstance().rendererMagneticSeperatorID = value;
    }

    public static int getRendererMixerId() {
	return getInstance().rendererMixerID;
    }

    public static void setRendererMixerId(int value) {
	getInstance().rendererMixerID = value;
    }

    public static int getRendererCrusherId() {
	return getInstance().rendererCrusherID;
    }

    public static void setRendererCrusherId(int value) {
	getInstance().rendererCrusherID = value;
    }

    public static int getRendererDiskFilterId() {
	return getInstance().rendererDiskFilterID;
    }

    public static void setRendererDiskFilterIdId(int value) {
	getInstance().rendererDiskFilterID = value;
    }

    public static int getRendererWireId() {
	return getInstance().rendererWireID;
    }

    public static void setRendererWireId(int value) {
	getInstance().rendererWireID = value;
    }

    public static int getRendererVoltMeterId() {
	return getInstance().rendererVoltMeterID;
    }

    public static void setRendererVoltMeterId(int value) {
	getInstance().rendererVoltMeterID = value;
    }

    public static int getRendererAmpMeterId() {
	return getInstance().rendererAmpMeterID;
    }

    public static void setRendererAmpMeterId(int value) {
	getInstance().rendererAmpMeterID = value;
    }

    public static int getRendererTransportFluidsId() {
	return getInstance().rendererTransportFluidID;
    }

    public static void setRendererTransportFluidsId(int value) {
	getInstance().rendererTransportFluidID = value;
    }

    public static int getRendererTankId() {
	return getInstance().rendererTankID;
    }

    public static void setRendererTankId(int value) {
	getInstance().rendererTankID = value;
    }

    public static int getRendererBatteryBoxId() {
	return getInstance().rendererBatteryBoxID;
    }

    public static void setRendererBatteryBoxId(int value) {
	getInstance().rendererBatteryBoxID = value;
    }

    public static int getRendererBlastFurnaceId() {
	return getInstance().rendererBlastFurnaceID;
    }

    public static void setRendererBlastFurnaceId(int value) {
	getInstance().rendererBlastFurnaceID = value;
    }

    public static int getRendererCrankGeneratorId() {
	return getInstance().rendererCrankGeneratorID;
    }

    public static void setRendererCrankGeneratorId(int value) {
	getInstance().rendererCrankGeneratorID = value;
    }

    private ConfigRenderers() {

    }

    private static ConfigRenderers instance = new ConfigRenderers();

    public static ConfigRenderers getInstance() {
	return instance;
    }

}
